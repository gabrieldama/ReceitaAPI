package com.receita_api.dto;

import com.receita_api.model.Categoria;

import java.util.List;

public record ReceitaRequestDTO(
        String nome,
        String descricao,
        Integer quantidade,
        Integer porcoes,
        Categoria categoria,
        List<IngredienteDTO> ingredientes,
        List<String> modoPreparo
) {
    public Integer tempoPreparo() {
        return null;
    }
}
