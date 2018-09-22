package br.com.avantis.entregue.api.service;

import br.com.avantis.entregue.api.model.Lancamento;
import br.com.avantis.entregue.api.model.Pessoa;
import br.com.avantis.entregue.api.repository.LancamentoRepository;
import br.com.avantis.entregue.api.repository.PessoaRepository;
import br.com.avantis.entregue.api.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }
}
