package com.settannim.esercizio2.repository;

import com.settannim.esercizio2.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
