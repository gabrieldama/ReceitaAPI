package com.receita_api.mapper;

import com.receita_api.dto.IngredienteDTO;
import com.receita_api.dto.ReceitaResponseDTO;
import com.receita_api.model.Receita;

import java.util.List;

public class ReceitaMapper {

    public static ReceitaResponseDTO toResponseDTO(Receita receita){

        List<String> passos = receita.getModoPreparo().stream().map(passo -> passo.getDescricao()).toList();
        List<IngredienteDTO> ingredientes = receita.getIngredientes().stream().map(ingrediente -> new IngredienteDTO(ingrediente.getNome(), ingrediente.getQuantidade())).toList();


        return new ReceitaResponseDTO(receita.getId(), receita.getNome(), receita.getDescricao(), receita.getTempoPreparoMinutos(), receita.getPorcoes(), receita.getCategoria(),ingredientes,passos );
    }
}
