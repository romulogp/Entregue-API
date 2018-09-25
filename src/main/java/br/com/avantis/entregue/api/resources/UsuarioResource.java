package br.com.avantis.entregue.api.resources;

import br.com.avantis.entregue.api.domain.Usuario;
import br.com.avantis.entregue.api.services.UsuarioService;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author okfx
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody @Valid Usuario usuario) throws URISyntaxException {
        Usuario usuarioSalvo = usuarioService.register(usuario);
        return ResponseEntity.created(new URI("/usuarios")).body(usuarioSalvo);
    }
    
    @GetMapping("/{id}/equipe")
    public ResponseEntity<List<Usuario>> listarEquipe(Authentication authentication) {
        List<Usuario> equipe = new ArrayList<>();
        Usuario admin = new Usuario(1L, "Admin", "admin@admin.com.br", null, LocalDateTime.now(), true, null, null);
        equipe.add(new Usuario(2L, "Usuario2", "u2@gmail.com", "asdadasda", LocalDateTime.now(), true, null, admin));
        equipe.add(new Usuario(3L, "Usuario3", "u3@gmail.com", null, LocalDateTime.now(), true, null, admin));
        return ResponseEntity.ok(equipe);
    }
    

}
