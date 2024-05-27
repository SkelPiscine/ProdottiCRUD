package com.settannim.esercizio2.mapper;

import com.settannim.esercizio2.entity.Categoria;
import com.settannim.esercizio2.model.CategoriaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaDTO toDTO(Categoria categoria);
    Categoria toEntity(CategoriaDTO categoriaDTO);
}
