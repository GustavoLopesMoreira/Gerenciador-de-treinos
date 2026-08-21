package com.gustavo.gerenciadordetreinos.services;

import com.gustavo.gerenciadordetreinos.entities.Exercicio;
import com.gustavo.gerenciadordetreinos.entities.Treino;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeArquivos {

    private static final String CAMINHO_ARQUIVO = "meus-treinos.txt";

    public static void salvarTreinos(List<Treino> treinos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Treino treino : treinos) {

                bw.write("TREINO;" + treino.getNome() + "\n");

                for (Exercicio ex : treino.getExercicios()) {
                    bw.write("EXERCICIO;" + ex.getNomeExercicio() + ";" + ex.getSeries() + "\n");
                }
            }
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public static List<Treino> carregarTreinos() {
        List<Treino> treinosCarregados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            Treino treinoAtual = null;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (partes[0].equals("TREINO")) {
                    treinoAtual = new Treino(partes[1]);
                    treinosCarregados.add(treinoAtual);
                } else if (partes[0].equals("EXERCICIO") && treinoAtual != null) {
                    Exercicio ex = new Exercicio(partes[1], Integer.parseInt(partes[2]));
                    treinoAtual.addExercicio(ex);
                }
            }
        } catch (IOException e) {

        }

        return treinosCarregados;
    }
}