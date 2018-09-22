package br.com.avantis.entregue.api.domain;

/**
 *
 * @author okfx
 */
public class Endereco {

    private Long id;
    private Integer cep;
    private String rua;
    private String numero; // SEM NUMERO
    private String complemento;
    private String cidade;
    private String uf;
    private Cliente cliente;
    
}
