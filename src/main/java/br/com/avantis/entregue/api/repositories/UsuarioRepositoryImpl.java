package br.com.avantis.entregue.api.repositories;

import br.com.avantis.entregue.api.domain.Permissao;
import br.com.avantis.entregue.api.domain.Usuario;
import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author okfx
 */
public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Override
    public Optional<Usuario> findByEmailWithPermissions(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            usuario.get().setPermissoes(permissaoRepository.findByUsuarios_Email(email));
        }
        return usuario;
    }

}
