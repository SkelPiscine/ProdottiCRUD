package com.settannim.esercizio2.controller;

import com.settannim.esercizio2.entity.Prodotto;
import com.settannim.esercizio2.model.ProdottoDTO;
import com.settannim.esercizio2.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prodotti")
public class ProdottoController {
    private ProdottoService prodottoService;

    @Autowired
    public ProdottoController(ProdottoService theProdottoService){
        prodottoService = theProdottoService;
    }

    @GetMapping
    public List<Prodotto> findAll() {
        return prodottoService.findAll();
    }

    @GetMapping("/{prodottoId}")
    public Prodotto getProdotto(@PathVariable int prodottoId){
        Prodotto theProdotto = prodottoService.findById(prodottoId);
        if (theProdotto == null){
            throw new RuntimeException("Prodotto non trovato con id " + prodottoId);
        }
        return theProdotto;
    }
    @GetMapping("/{id}/dto")
    public ResponseEntity<ProdottoDTO> findById(@PathVariable int id) {
        try {
            ProdottoDTO prodottoDTO = prodottoService.findDTOById(id);
            return ResponseEntity.ok(prodottoDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Prodotto addProdotto(@RequestBody Prodotto theProdotto){

        //imposto l'id a 0, cosi nel caso in cui venga passato un prodotto con un id gia,
        //non fa l'update di uno magari gia esistente
        theProdotto.setId(0);

        Prodotto dbProdotto = prodottoService.save(theProdotto);
        return dbProdotto;
    }

    @PutMapping
    public Prodotto updateProdotto(@RequestBody Prodotto theProdotto){
        Prodotto dbProdotto = prodottoService.save(theProdotto);
        return dbProdotto;
    }

    @DeleteMapping("/{prodottoId}")
    public String deleteProdotto(@PathVariable int prodottoId){
        Prodotto theProdotto = prodottoService.findById(prodottoId);
        //se non trova il prodotto con l'id inserito
        if (theProdotto == null){
            throw new RuntimeException("prodotto non trovato all'id " + prodottoId);
        }
        prodottoService.deleteById(prodottoId);
        return "prodotto rimosso con id " + prodottoId;
    }
}
