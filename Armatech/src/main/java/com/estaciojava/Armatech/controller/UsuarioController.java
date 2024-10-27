package com.estaciojava.Armatech.controller;
import com.estaciojava.Armatech.dto.UsuarioDTO;
import com.estaciojava.Armatech.infra.security.TokenService;
import com.estaciojava.Armatech.model.Usuario;
import com.estaciojava.Armatech.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<UsuarioDTO> getUsuario(@RequestHeader("Authorization") String token) {
        // Remove o prefixo "Bearer " do token e valida
        String email = tokenService.validateToken(token.replace("Bearer ", ""));

        // Verifica se o token é válido (se não, retorna 401 Unauthorized)
        if (email == null) {
            return ResponseEntity.status(401).build();
        }

        // Busca o usuário com base no email extraído
        Usuario usuario = usuarioService.findByEmail(email);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        // Converte o Usuario para UsuarioDTO
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNome(), usuario.getEmail());

        //Retorna o objeto contendo (Nome e email)
        return ResponseEntity.ok(usuarioDTO);
    }
}

