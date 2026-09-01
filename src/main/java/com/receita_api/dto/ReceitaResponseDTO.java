package com.receita_api.dto;

import com.receita_api.model.Categoria;

import java.util.List;

public record ReceitaResponseDTO(

        Long id,
        String nome,
        String descricao,
        Integer tempoPreparo,
        Integer porcoes,
        Categoria categoria,
        List<IngredienteDTO> ingrediente,
        List<String> modoPreparo
) {
}
