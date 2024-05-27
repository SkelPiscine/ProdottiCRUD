package com.settannim.esercizio2.service;

import com.settannim.esercizio2.entity.Categoria;
import com.settannim.esercizio2.entity.Prodotto;
import com.settannim.esercizio2.mapper.ProdottoMapper;
import com.settannim.esercizio2.model.CategoriaDTO;
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
    public ProdottoDTO findById(int theId) throws Exception {
        Optional<Prodotto> prodottoTemp = prodottoRepository.findById(theId);
        if (prodottoTemp.isEmpty()) {
            throw new Exception("Product not found by id: " + theId);
        }
        return prodottoMapper.toDTO(prodottoTemp.get());
    }


    @Override
    public ProdottoDTO save(ProdottoDTO prodottoDTO) throws Exception {
        Optional<Prodotto> tempProduct = prodottoRepository.findByNome(prodottoDTO.getNome());
        if(tempProduct.isPresent()){
            throw new Exception("Product already existing");
        }
        Prodotto newProduct = prodottoMapper.toEntity(prodottoDTO);
        newProduct = prodottoRepository.save(newProduct);
        return prodottoMapper.toDTO(newProduct);
    }

    @Override
    public void deleteById(int theId) throws Exception {
        Optional<Prodotto> prodotto = prodottoRepository.findById(theId);
        if(prodotto.isEmpty()){
            throw new Exception("product not found");
        }
        prodottoRepository.deleteById(theId);
    }
}
