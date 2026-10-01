package br.com.exemplo.avl.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.exemplo.avl.dto.SolicitacaoRequest;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import br.com.exemplo.avl.model.Solicitacao;
import br.com.exemplo.avl.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {
    private final SolicitacaoRepository repository;

    public SolicitacaoService(SolicitacaoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(SolicitacaoRequest solicitacaoRequest) {
        Solicitacao solicitacao = Solicitacao.builder()
                .numero(solicitacaoRequest.getNumero())
                .solicitante(solicitacaoRequest.getSolicitante())
                .descricao(solicitacaoRequest.getDescricao())
                .dateTimeOpen(LocalDateTime.now())
                .build();

        repository.inserir(solicitacao);
    }

    public Solicitacao buscar(int numero) {
        return repository.buscar(numero);
    }

    public boolean remover(int numero) {
        return repository.remover(numero);
    }

    public List<Solicitacao> listar() {
        return repository.listar();
    }

    public String exibirArvore() {
        return repository.exibirArvore();
    }

    public Solicitacao patchById(int numero, SolicitacaoRequest request) {
        Solicitacao main = repository.buscar(numero);

        if (request.getNumero() != 0 || request.getDateTimeOpen() != null) {
            throw new UnsupportedOperationException("Valor imutável e não pode ser alterado.");
        }
        if (request.getDescricao() != null) {
            main.setDescricao(request.getDescricao());
        }
        if (request.getSolicitante() != null) {
            main.setSolicitante(request.getSolicitante());
        }

        return main;
    }
}
