package io.github.gustavolopesmoreira.gerenciadordetreinos.service;

import io.github.gustavolopesmoreira.gerenciadordetreinos.model.Exercicio;
import io.github.gustavolopesmoreira.gerenciadordetreinos.model.Treino;

import java.util.List;

public class TreinoService {

    private final List<Treino> treinos;

    public TreinoService(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public List<Treino> listarTreinos() {
        return treinos;
    }

    public void criarTreino(String nomeTreino) {
        treinos.add(new Treino(nomeTreino));
    }

    public void deletarTreino(int indexOriginal) {
        if (indexOriginal >= 0 && indexOriginal < treinos.size()) {
            treinos.remove(indexOriginal);
        } else {
            throw new IllegalArgumentException("Índice de treino inválido.");
        }
    }

    public Treino buscarTreino(int indexOriginal) {
        if (indexOriginal >= 0 && indexOriginal < treinos.size()) {
            return treinos.get(indexOriginal);
        }
        throw new IllegalArgumentException("Índice de treino inválido.");
    }

    public void adicionarExercicio(Treino treino, Exercicio exercicio) {
        treino.addExercicio(exercicio);
    }

    public void removerExercicio(Treino treino, int indexExercicio) {
        List<Exercicio> exercicios = treino.getExercicios();
        if (indexExercicio >= 0 && indexExercicio < exercicios.size()) {
            Exercicio exRemovido = exercicios.get(indexExercicio);
            treino.removeExercicio(exRemovido);
        } else {
            throw new IllegalArgumentException("Índice de exercício inválido.");
        }
    }
}