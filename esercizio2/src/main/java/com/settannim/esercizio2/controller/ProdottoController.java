package com.settannim.esercizio2.controller;

import com.settannim.esercizio2.entity.Categoria;
import com.settannim.esercizio2.entity.Prodotto;
import com.settannim.esercizio2.model.CategoriaDTO;
import com.settannim.esercizio2.model.ProdottoDTO;
import com.settannim.esercizio2.repository.ProdottoRepository;
import com.settannim.esercizio2.service.ProdottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/prodotti")
public class ProdottoController {
    private final ProdottoService prodottoService;


    @GetMapping("/{id}/dto")
    public ResponseEntity<ProdottoDTO> findById(@PathVariable int id) {
        try {
            ProdottoDTO prodottoDTO = prodottoService.findById(id);
            return ResponseEntity.ok(prodottoDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProdottoDTO> addProduct(@RequestBody ProdottoDTO theProduct) {
        try {
            ProdottoDTO prodottoDTO = prodottoService.save(theProduct);
            return ResponseEntity.ok(prodottoDTO);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prodotto> deleteProduct(@PathVariable int id) {
        try{
            prodottoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
