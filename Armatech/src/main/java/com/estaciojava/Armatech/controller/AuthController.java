package com.estaciojava.Armatech.controller;

import com.estaciojava.Armatech.classes.CrudController;
import com.estaciojava.Armatech.dto.LoginRequestDTO;
import com.estaciojava.Armatech.dto.RegisterRequestDTO;
import com.estaciojava.Armatech.dto.ResponseDTO;
import com.estaciojava.Armatech.infra.security.TokenService;
import com.estaciojava.Armatech.model.Usuario;
import com.estaciojava.Armatech.repository.UsuarioRepository;
import com.estaciojava.Armatech.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

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
