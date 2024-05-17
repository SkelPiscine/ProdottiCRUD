package com.settannim.esercizio2.service;

import com.settannim.esercizio2.entity.Prodotto;
import com.settannim.esercizio2.mapper.ProdottoMapper;
import com.settannim.esercizio2.model.ProdottoDTO;
import com.settannim.esercizio2.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoServiceImpl implements ProdottoService{

    private ProdottoRepository prodottoRepository;
    private ProdottoMapper prodottoMapper;

    @Autowired
    public ProdottoServiceImpl(ProdottoRepository theProdottoRepository, ProdottoMapper theProdottoMapper){
        prodottoRepository = theProdottoRepository;
        prodottoMapper = theProdottoMapper;
    }

    @Override
    public List<Prodotto> findAll() {
        return prodottoRepository.findAll();
    }

    @Override
    public Prodotto findById(int theId) {
        Optional<Prodotto> result = prodottoRepository.findById(theId);
        Prodotto theProdotto = null;

        if (result.isPresent()){
            theProdotto = result.get();
        }
        else{
            //se non trova nessuna corrispondenza con theId
            throw new RuntimeException("non ho trovato il prodotto con ID " + theId);
        }
        return theProdotto;
    }

    public ProdottoDTO findDTOById(int theId) throws Exception {
        Prodotto prodotto = prodottoRepository.findById(theId).orElseThrow();
        return prodottoMapper.prodottoToProdottoDTO(prodotto);
    }

    @Override
    public Prodotto save(Prodotto theProdotto) {
        return prodottoRepository.save(theProdotto);
    }

    @Override
    public void deleteById(int theId) {
        prodottoRepository.deleteById(theId);
    }
}
