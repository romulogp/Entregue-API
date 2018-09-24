package br.com.avantis.entregue.api.resources;

import br.com.avantis.entregue.api.domain.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author okfx
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @GetMapping("/{id}/equipe")
    public ResponseEntity<List<Usuario>> listarEquipe(Authentication authentication) {
        List<Usuario> equipe = new ArrayList<>();
        Usuario admin = new Usuario(1L, "Admin", "admin@admin.com.br", null, null, null);
        equipe.add(new Usuario(2L, "Usuario2", "u2@gmail.com", null, null, admin));
        equipe.add(new Usuario(3L, "Usuario3", "u3@gmail.com", null, null, admin));
        return ResponseEntity.ok(equipe);
    }

}
