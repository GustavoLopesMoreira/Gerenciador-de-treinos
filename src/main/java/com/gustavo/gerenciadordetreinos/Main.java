package com.gustavo.gerenciadordetreinos;

import com.gustavo.gerenciadordetreinos.entities.Treino;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Treino> treinos = new ArrayList<>();

        System.out.println("Gerenciador de treinos");
        int r = 0;

        do {
            try {
                System.out.println("1 - Lista de treinos");
                System.out.println("2 - Criar treino");
                System.out.println("3 - Deletar treino");
                System.out.println("4 - Sair");
                System.out.print("Escolha uma opção: ");

                r = sc.nextInt();
                sc.nextLine();

                switch (r) {
                    case 1:
                        if (treinos.isEmpty()) {
                            System.out.println("Nenhum treino criado.");
                        } else {
                            System.out.println("Treinos");
                            for (Treino treino : treinos) {
                                System.out.println(treino);
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Digite o nome do treino: ");
                        String nomeTreino = sc.nextLine();
                        treinos.add(new Treino(nomeTreino));
                        System.out.println("Treino criado com sucesso");
                        break;

                    case 3:
                        if (treinos.isEmpty()) {
                            System.out.println("Nenhum treino para deletar.");
                        } else {
                            System.out.println("Treinos");
                            int i = 0;
                            for (Treino treino : treinos) {
                                System.out.printf("%d° %s\n", i + 1, treino);
                                i++;
                            }

                            System.out.print("Digite o numero do treino a ser removido: ");
                            int numeroRemovido = sc.nextInt();

                            if (numeroRemovido >= 1 && numeroRemovido <= treinos.size()) {
                                treinos.remove(numeroRemovido - 1);
                                System.out.println("Treino removido com sucesso");
                            } else {
                                System.out.println("Valor inválido.");
                            }
                        }
                        break;

                    case 4:
                        break;

                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite apenas números inteiros válidos.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }

        } while (r != 4);

        System.out.println("Fim da aplicação");
        sc.close();
    }
}