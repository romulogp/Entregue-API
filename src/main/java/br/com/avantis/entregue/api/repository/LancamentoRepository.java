package br.com.avantis.entregue.api.repository;

import br.com.avantis.entregue.api.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
