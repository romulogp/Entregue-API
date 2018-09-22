package br.com.avantis.entregue.api.repository;

import br.com.avantis.entregue.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
