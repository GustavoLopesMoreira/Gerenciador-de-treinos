package com.gustavo.gerenciadordetreinos.entities;

public class Exercicio {
    private String nomeExercicio;
    private Integer series;

    public Exercicio(){}

    public Exercicio(String nomeExercicio, Integer series) {
        this.nomeExercicio = nomeExercicio;
        this.series = series;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String toString() {
        return nomeExercicio + " (" + series + " séries)";
    }
}
