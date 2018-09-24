package br.com.avantis.entregue.api.repositories;

import br.com.avantis.entregue.api.domain.Usuario;
import java.util.Optional;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author okfx
 */
public interface UsuarioRepositoryQuery {

    Optional<Usuario> findByEmailWithPermissions(@Param("email") String email);

}
