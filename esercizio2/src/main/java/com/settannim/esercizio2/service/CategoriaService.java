package com.settannim.esercizio2.service;

import com.settannim.esercizio2.entity.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> findAll();
    Categoria findById(int theId);
    Categoria save(Categoria theCategoria);
    void deleteById(int theId);
}