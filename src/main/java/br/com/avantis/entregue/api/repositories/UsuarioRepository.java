package br.com.avantis.entregue.api.repositories;

import br.com.avantis.entregue.api.domain.Usuario;
import java.util.Optional;

/**
 *
 * @author okfx
 */
public interface UsuarioRepository {

    Optional<Usuario> findByEmail(String email);
    
}
