package com.settannim.esercizio2.service;

import com.settannim.esercizio2.entity.Prodotto;
import com.settannim.esercizio2.model.ProdottoDTO;

import java.util.List;

public interface ProdottoService {
    ProdottoDTO findById(int theId) throws Exception;
    ProdottoDTO save(ProdottoDTO theProdotto) throws Exception;
    void deleteById(int theId) throws Exception;
}
