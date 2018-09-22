package br.com.avantis.entregue.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author okfx
 */
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String senha;

    private List<Permissao> permissoes = new ArrayList<>();

}
