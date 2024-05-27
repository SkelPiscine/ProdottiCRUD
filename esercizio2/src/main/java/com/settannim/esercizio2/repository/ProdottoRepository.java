package com.settannim.esercizio2.repository;

import com.settannim.esercizio2.entity.Categoria;
import com.settannim.esercizio2.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
    Optional<Prodotto> findByNome(String nome);
}
