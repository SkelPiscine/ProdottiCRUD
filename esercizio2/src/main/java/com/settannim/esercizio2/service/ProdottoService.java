package com.settannim.esercizio2.service;

import com.settannim.esercizio2.entity.Prodotto;
import com.settannim.esercizio2.model.ProdottoDTO;

import java.util.List;

public interface ProdottoService {
    List<Prodotto> findAll();
    Prodotto findById(int theId);
    ProdottoDTO findDTOById(int theID) throws Exception;
    Prodotto save(Prodotto theProdotto);
    void deleteById(int theId);
}
