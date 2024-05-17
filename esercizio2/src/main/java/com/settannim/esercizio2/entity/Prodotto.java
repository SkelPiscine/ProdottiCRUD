package com.settannim.esercizio2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prodotto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "prezzo")
    private double prezzo;

    @Column(name = "quantita")
    private int quantita;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
