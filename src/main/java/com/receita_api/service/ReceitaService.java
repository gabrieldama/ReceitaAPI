package com.receita_api.service;

import com.receita_api.dto.IngredienteDTO;
import com.receita_api.dto.ReceitaRequestDTO;
import com.receita_api.dto.ReceitaResponseDTO;
import com.receita_api.mapper.ReceitaMapper;
import com.receita_api.model.Ingrediente;
import com.receita_api.model.ModoPreparo;
import com.receita_api.model.Receita;
import com.receita_api.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    public ReceitaResponseDTO criar(ReceitaRequestDTO dto) {
        Receita novaReceita = new Receita();

        novaReceita.setNome(dto.nome());
        novaReceita.setDescricao(dto.descricao());
        novaReceita.setCategoria(dto.categoria());
        novaReceita.setTempoPreparoMinutos(dto.tempoPreparo());
        novaReceita.setPorcoes(dto.porcoes());

        if (dto.ingredientes() != null) {
            for(IngredienteDTO ing: dto.ingredientes()){
                // Cria um novo ingrediente com os dados do DTO
                Ingrediente ingrediente = new Ingrediente(
                        null,
                        ing.nome(),
                        ing.quantidade(),
                        novaReceita
                );
                // Adiciona o novo ingrediente
                novaReceita.getIngredientes().add(ingrediente);
            }
        }

        if (dto.modoPreparo() != null) {
            for(String passo: dto.modoPreparo()){
                ModoPreparo modoPreparo = new ModoPreparo(null, passo, novaReceita);
                novaReceita.getModoPreparo().add(modoPreparo);
            }
        }

        Receita rec = receitaRepository.save(novaReceita);

        return ReceitaMapper.toResponseDTO(rec);
    }

    public ReceitaResponseDTO buscarPorId(Long id) {
        Receita rec = receitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));

        return ReceitaMapper.toResponseDTO(rec);
    }

    public List<ReceitaResponseDTO> listar() {
        return receitaRepository.findAll()
                .stream()
                .map((receita) -> ReceitaMapper.toResponseDTO(receita))
                .toList();
    }
}
