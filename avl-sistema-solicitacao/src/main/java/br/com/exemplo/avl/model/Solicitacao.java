package br.com.exemplo.avl.model;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Solicitacao {
    private int numero;
    private String solicitante;
    private String descricao;
    private LocalDateTime dateTimeOpen;
}
