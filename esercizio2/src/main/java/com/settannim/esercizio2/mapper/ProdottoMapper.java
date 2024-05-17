package com.settannim.esercizio2.mapper;

import com.settannim.esercizio2.entity.Prodotto;
import com.settannim.esercizio2.model.ProdottoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdottoMapper {
    ProdottoDTO prodottoToProdottoDTO(Prodotto prodotto);
}
