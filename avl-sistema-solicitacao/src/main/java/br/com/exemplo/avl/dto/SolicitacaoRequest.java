package br.com.exemplo.avl.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoRequest {
    private int numero;
    private String solicitante;
    private String descricao;
    private LocalDateTime dateTimeOpen;
}
