package com.settannim.esercizio2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdottoDTO {
    private String nome;
    private double prezzo;
    private int quantita;
}
