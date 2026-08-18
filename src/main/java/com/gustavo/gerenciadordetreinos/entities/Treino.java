package com.gustavo.gerenciadordetreinos.entities;

import java.util.ArrayList;
import java.util.List;

public class Treino {
    private String nome;
    private List<Exercicio> exercicios = new ArrayList<>();

    public Treino(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void addExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
    }

    public void removeExercicio(Exercicio exercicio) {
        this.exercicios.remove(exercicio);
    }

    public String toString() {
        StringBuilder texto = new StringBuilder();

        texto.append("Treino: ").append(nome).append("\n");
        texto.append("Exercícios:\n");

        if (exercicios.isEmpty()) {
            texto.append(" - Nenhum exercício adicionado ainda.\n");
        } else {
            for (Exercicio ex : exercicios) {
                texto.append(" - ").append(ex.toString()).append("\n");
            }
        }

        return texto.toString();
    }
}