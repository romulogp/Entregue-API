package br.com.avantis.entregue.api.repositories;

import br.com.avantis.entregue.api.domain.Permissao;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author okfx
 */
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    
    Set<Permissao> findByUsuarios_Email(String email);
    
}
