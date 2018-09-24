package br.com.avantis.entregue.api.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author okfx
 */
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "permissao")
public class Permissao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    private String nome;
    private String descricao;
    
    @ManyToMany(mappedBy = "permissoes")
    private List<Usuario> usuarios;
}
