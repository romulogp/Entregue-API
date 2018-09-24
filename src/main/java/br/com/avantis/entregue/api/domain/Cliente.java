package br.com.avantis.entregue.api.domain;

import java.util.List;

/**
 *
 * @author okfx
 */
public class Cliente {

    private Long id;
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String celular;
    private String email;
    private List<Endereco> enderecos;
    private Usuario cadastrante;
    private Usuario proprietario;
    
}
