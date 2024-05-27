package com.settannim.esercizio2.service;

import com.settannim.esercizio2.entity.Categoria;
import com.settannim.esercizio2.entity.Prodotto;
import com.settannim.esercizio2.mapper.CategoriaMapper;
import com.settannim.esercizio2.mapper.ProdottoMapper;
import com.settannim.esercizio2.model.CategoriaDTO;
import com.settannim.esercizio2.model.ProdottoDTO;
import com.settannim.esercizio2.repository.CategoriaRepository;
import com.settannim.esercizio2.repository.ProdottoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;
    private final ProdottoRepository prodottoRepository;
    private final ProdottoMapper prodottoMapper;

    @Override
    public CategoriaDTO addProduct(ProdottoDTO prodottoDTO, Categoria categoria) throws Exception {
            Optional<Prodotto> prodottoOpt = prodottoRepository.findByNome(prodottoDTO.getNome());
            if(prodottoOpt.isPresent()){
                throw new Exception("Product already exists");
            }
            Optional<Categoria> categoriaOptional = categoriaRepository.findByNome(categoria.getNome());
            if (categoriaOptional.isEmpty()){
                throw new Exception("Category doesn't exist");
            }
            Prodotto prodotto = prodottoMapper.toEntity(prodottoDTO);
            prodotto.setCategoria(categoria);
            return categoriaMapper.toDTO(categoria);
    }

    @Override
    public CategoriaDTO findById(int theId) throws Exception{
        Optional<Categoria> categoriaTemp = categoriaRepository.findById(theId);
        if (categoriaTemp.isEmpty()){
            throw new Exception("category not found by id: " + theId);
        }
        Categoria categoria = categoriaTemp.get();
        return categoriaMapper.toDTO(categoria);

    }

    @Override
    public CategoriaDTO save(CategoriaDTO categoriaDTO) throws Exception {
        Optional<Categoria> tempCategoria = categoriaRepository.findByNome(categoriaDTO.getNome());
        if(tempCategoria.isPresent()){
            throw new Exception("Category already existing");
        }
        Categoria newCategory = categoriaMapper.toEntity(categoriaDTO);
        newCategory = categoriaRepository.save(newCategory);
        return categoriaMapper.toDTO(newCategory);
    }

    @Override
    public CategoriaDTO updateName(CategoriaDTO categoriaDTO, String nome) throws Exception {
        Optional<Categoria> categoriaOpt =categoriaRepository.findByNome(categoriaDTO.getNome());
        if(categoriaOpt.isEmpty()){
            throw new Exception("Category doesn't exist " + categoriaDTO.getNome());
        }
        Categoria categoria = categoriaOpt.get();
        categoria.setNome(nome);
        return categoriaMapper.toDTO(categoria);
    }

    @Override
    public void deleteById(int theId) throws Exception {
        Optional<Categoria> tempCategoria = categoriaRepository.findById(theId);
        if(tempCategoria.isEmpty()){
            throw new Exception("category not found with id: " + theId);
        }
        categoriaRepository.deleteById(theId);
    }
}
