package com.settannim.esercizio2.repository;

import com.settannim.esercizio2.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
}
