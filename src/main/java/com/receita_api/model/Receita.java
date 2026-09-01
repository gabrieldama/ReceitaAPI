package com.receita_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private Integer tempoPreparoMinutos;

    private Integer porcoes;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL)
    private List<Ingrediente> ingredientes = new ArrayList<>();

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL)
    @OrderColumn(name = "ordem")
    private List<ModoPreparo> modoPreparo = new ArrayList<>();


}
