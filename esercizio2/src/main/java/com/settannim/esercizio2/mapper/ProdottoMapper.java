package com.settannim.esercizio2.mapper;

import com.settannim.esercizio2.entity.Prodotto;
import com.settannim.esercizio2.model.ProdottoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdottoMapper {
    ProdottoDTO toDTO(Prodotto prodotto);
    Prodotto toEntity(ProdottoDTO prodottoDTO);
}
