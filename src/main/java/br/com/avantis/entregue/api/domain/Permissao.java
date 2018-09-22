package br.com.avantis.entregue.api.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author okfx
 */
@Data
@EqualsAndHashCode(of = "id")
public class Permissao {

    private Long id;
    private String descricao;
    
}
