package com.receita_api.controller;

import com.receita_api.dto.ReceitaRequestDTO;
import com.receita_api.dto.ReceitaResponseDTO;
import com.receita_api.model.Receita;
import com.receita_api.service.ReceitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @GetMapping
    public List<ReceitaResponseDTO> listar() {
        return receitaService.listar();
    }

    @PostMapping
    public ResponseEntity<ReceitaResponseDTO> criar(@RequestBody ReceitaRequestDTO receita) {
        ReceitaResponseDTO receitaSalva = receitaService.criar(receita);
        return ResponseEntity.status(HttpStatus.CREATED).body(receitaSalva);
    }

    @GetMapping("/{id}")
    public ReceitaResponseDTO buscarPorId(@PathVariable Long id) {
        return receitaService.buscarPorId(id);
    }
}
