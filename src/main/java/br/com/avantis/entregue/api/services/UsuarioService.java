package br.com.avantis.entregue.api.services;

import br.com.avantis.entregue.api.domain.Usuario;
import br.com.avantis.entregue.api.repositories.UsuarioRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author okfx
 */
@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario register(Usuario usuario) {
        String encodedPassword = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encodedPassword);
        usuario.setCriadoEm(LocalDateTime.now());
        usuario.setAtivo(true);
        return usuarioRepository.save(usuario);
    }

}
