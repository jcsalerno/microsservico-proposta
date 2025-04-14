package com.salerno.proposta_app.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropostaResponseDto {

    private Long id;

    private String nome;

    private String sobrenome;

    private String telefone;

    private String cpf;

    private Double renda;

    private int prazoPagamento;

    private Boolean aprovado;

    private String observacao;
}
