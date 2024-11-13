package com.estaciojava.Armatech.controller;

import com.estaciojava.Armatech.classes.CrudController;
import com.estaciojava.Armatech.dto.*;
import com.estaciojava.Armatech.infra.security.TokenService;
import com.estaciojava.Armatech.model.Usuario;
import com.estaciojava.Armatech.repository.UsuarioRepository;
import com.estaciojava.Armatech.service.EmailService;
import com.estaciojava.Armatech.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final EmailService emailService;

    //Endpoint para solicitação de recuperação de senha
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordDTO request) {
        String email = request.getEmail();
        System.out.println("E-mail pesquisado: " + email);
        Optional<Usuario> usuario = repository.findByEmail(email.toLowerCase());
        System.out.println("Usuário encontrado: " + usuario.isPresent());
        if (usuario.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }

        //Geração de token de recuperação
        String  resetToken = UUID.randomUUID().toString();
        usuario.get().setResetToken(resetToken);
        repository.save(usuario.get());

        //Envio do link de recuperação por e-mail
        String resetLink = "http://seu-frontend.com/reset-password?token=" + resetToken;
        emailService.sendEmail(email, "Recuperação de Senha", "Clique no link para redefinir a sua senha:  " + resetLink);

        return ResponseEntity.ok("Link de recuperação enviado para o email");

    }

    //Endpoint  para redefinir a senha
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequestDTO request){
        Optional<Usuario> usuario = repository.findByResetToken(request.getToken());
        if (usuario.isEmpty()) {
            return ResponseEntity.badRequest().body("Token inválido");
        }

        // Atualiza a senha e romove o token de recuperação
        usuario.get().setSenha(passwordEncoder.encode(request.getNewPassword()));
        usuario.get().setResetToken(null);
        repository.save(usuario.get());

        return ResponseEntity.ok("Senha redefinida com sucesso");
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        Usuario usuario = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if(passwordEncoder.matches(body.senha(),usuario.getSenha())){
            String token = tokenService.generateToken(usuario);
            return  ResponseEntity.ok(new ResponseDTO(usuario.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity login(@RequestBody RegisterRequestDTO body) {
        Optional<Usuario> usuario = this.repository.findByEmail(body.email());
        if(usuario.isEmpty()) {
            Usuario newUsuario = new Usuario();
            newUsuario.setSenha(passwordEncoder.encode(body.senha()));
            newUsuario.setEmail(body.email());
            newUsuario.setNome(body.nome());
            this.repository.save(newUsuario);


            String token = tokenService.generateToken(newUsuario);
            return ResponseEntity.ok(new ResponseDTO(newUsuario.getNome(), token));

        }
        return ResponseEntity.badRequest().build();
    }

}
