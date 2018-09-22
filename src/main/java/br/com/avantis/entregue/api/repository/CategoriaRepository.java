package br.com.avantis.entregue.api.repository;

import br.com.avantis.entregue.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
