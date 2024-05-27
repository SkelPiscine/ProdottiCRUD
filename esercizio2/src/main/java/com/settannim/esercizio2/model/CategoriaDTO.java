package com.settannim.esercizio2.model;

import com.settannim.esercizio2.entity.Prodotto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {
    private String nome;
    private Set<Prodotto> prodotti = new HashSet<>();
}
