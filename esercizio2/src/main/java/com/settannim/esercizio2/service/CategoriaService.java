package com.settannim.esercizio2.service;

import com.settannim.esercizio2.entity.Categoria;
import com.settannim.esercizio2.model.CategoriaDTO;
import com.settannim.esercizio2.model.ProdottoDTO;

import java.util.List;

public interface CategoriaService {
    CategoriaDTO addProduct(ProdottoDTO prodottoDTO, Categoria categoria) throws Exception;
    CategoriaDTO findById(int theId) throws Exception;
    CategoriaDTO save(CategoriaDTO categoriaDTO) throws Exception;
    CategoriaDTO updateName(CategoriaDTO categoriaDTO, String nome) throws Exception;
    void deleteById(int theId) throws Exception;
}