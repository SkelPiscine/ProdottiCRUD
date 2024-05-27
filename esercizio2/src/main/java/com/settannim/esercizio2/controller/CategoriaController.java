package com.settannim.esercizio2.controller;

import com.settannim.esercizio2.entity.Categoria;
import com.settannim.esercizio2.model.CategoriaDTO;
import com.settannim.esercizio2.model.ProdottoDTO;
import com.settannim.esercizio2.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categorie")
public class CategoriaController {
    private final CategoriaService categoriaService;


    @GetMapping("/{categoriaId}")
    public ResponseEntity<CategoriaDTO> getCategoria(@PathVariable int categoriaId) {
        try{
            CategoriaDTO categoriaDTO = categoriaService.findById(categoriaId);
            return ResponseEntity.ok(categoriaDTO);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> addCategoria(@RequestBody CategoriaDTO theCategoria) {
        try {
            CategoriaDTO categoriaDTO = categoriaService.save(theCategoria);
            return ResponseEntity.ok(categoriaDTO);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/set_Product")
    public ResponseEntity<CategoriaDTO> addProductToCategory(@RequestBody ProdottoDTO prodottoDTO,
                                                             @RequestBody Categoria categoria) {
        try {
            CategoriaDTO categoriaDTO = categoriaService.addProduct(prodottoDTO, categoria);
            return ResponseEntity.ok(categoriaDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping
    public ResponseEntity<CategoriaDTO> updateName(@RequestBody CategoriaDTO theCategoria, @RequestParam String name) {
        try{
            CategoriaDTO categoriaDTO = categoriaService.updateName(theCategoria, name);
            return ResponseEntity.ok(categoriaDTO);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<Categoria> deleteCategory(@PathVariable int categoriaId) {
        try{
            categoriaService.deleteById(categoriaId);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}