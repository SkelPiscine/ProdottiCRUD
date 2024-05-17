package com.settannim.esercizio2.service;

import com.settannim.esercizio2.entity.Categoria;
import com.settannim.esercizio2.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(int theId) {
        Optional<Categoria> result = categoriaRepository.findById(theId);
        Categoria theCategoria = null;

        if (result.isPresent()) {
            theCategoria = result.get();
        } else {
            throw new RuntimeException("Categoria non trovata con ID: " + theId);
        }

        return theCategoria;
    }

    @Override
    public Categoria save(Categoria theCategoria) {
        return categoriaRepository.save(theCategoria);
    }

    @Override
    public void deleteById(int theId) {
        categoriaRepository.deleteById(theId);
    }
}
