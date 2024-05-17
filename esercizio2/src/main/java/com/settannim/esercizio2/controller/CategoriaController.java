package com.settannim.esercizio2.controller;

import com.settannim.esercizio2.entity.Categoria;
import com.settannim.esercizio2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorie")
public class CategoriaController {
    private CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{categoriaId}")
    public Categoria getCategoria(@PathVariable int categoriaId) {
        Categoria theCategoria = categoriaService.findById(categoriaId);
        if (theCategoria == null) {
            throw new RuntimeException("Categoria non trovata con id " + categoriaId);
        }
        return theCategoria;
    }

    @PostMapping
    public Categoria addCategoria(@RequestBody Categoria theCategoria) {
        // Imposto l'id a 0, così nel caso in cui venga passata una categoria con un id già esistente,
        // non fa l'update di una categoria magari già esistente
        theCategoria.setId(0);
        Categoria dbCategoria = categoriaService.save(theCategoria);
        return dbCategoria;
    }

    @PutMapping
    public Categoria updateCategoria(@RequestBody Categoria theCategoria) {
        Categoria dbCategoria = categoriaService.save(theCategoria);
        return dbCategoria;
    }

    @DeleteMapping("/{categoriaId}")
    public String deleteCategoria(@PathVariable int categoriaId) {
        Categoria theCategoria = categoriaService.findById(categoriaId);
        // Se non trova la categoria con l'id inserito
        if (theCategoria == null) {
            throw new RuntimeException("Categoria non trovata all'id " + categoriaId);
        }
        categoriaService.deleteById(categoriaId);
        return "Categoria rimossa con id " + categoriaId;
    }
}