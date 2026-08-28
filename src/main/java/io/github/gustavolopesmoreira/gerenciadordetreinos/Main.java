package io.github.gustavolopesmoreira.gerenciadordetreinos;

import io.github.gustavolopesmoreira.gerenciadordetreinos.model.Treino;
import io.github.gustavolopesmoreira.gerenciadordetreinos.model.Exercicio;
import io.github.gustavolopesmoreira.gerenciadordetreinos.repository.GerenciadorDeArquivos;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Treino> treinos = GerenciadorDeArquivos.carregarTreinos();
        System.out.println("Gerenciador de treinos");
        int opcao = 0;

        do {
            try {
                exibirMenu();
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        listarTreinos(treinos);
                        break;
                    case 2:
                        criarTreino(treinos);
                        break;
                    case 3:
                        deletarTreino(treinos);
                        break;
                    case 4:
                        editarTreino(treinos);
                        break;
                    case 5:
                        System.out.println("Salvando dados e encerrando o menu...");
                        GerenciadorDeArquivos.salvarTreinos(treinos);
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
        } while (opcao != 5);

        System.out.println("Fim da aplicação");
        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("\n1 - Lista de treinos");
        System.out.println("2 - Criar treino");
        System.out.println("3 - Deletar treino");
        System.out.println("4 - Editar treino");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void listarTreinos(List<Treino> treinos) {
        if (treinos.isEmpty()) {
            System.out.println("Nenhum treino criado.");
        } else {
            System.out.println("--- Treinos ---");
            for (Treino treino : treinos) {
                System.out.println(treino);
            }
        }
    }

    private static void criarTreino(List<Treino> treinos) {
        System.out.print("Digite o nome do treino: ");
        String nomeTreino = sc.nextLine();
        treinos.add(new Treino(nomeTreino));
        System.out.println("Treino criado com sucesso!");
    }

    private static void deletarTreino(List<Treino> treinos) {
        if (treinos.isEmpty()) {
            System.out.println("Nenhum treino para deletar.");
        } else {
            System.out.println("Treinos:");

            for (int i = 0; i < treinos.size(); i++) {
                System.out.printf("%d° %s\n", i + 1, treinos.get(i).getNome());
            }

            System.out.print("Digite o numero do treino a ser removido: ");
            int numeroRemovido = sc.nextInt();
            sc.nextLine();

            if (numeroRemovido >= 1 && numeroRemovido <= treinos.size()) {
                treinos.remove(numeroRemovido - 1);
                System.out.println("Treino removido com sucesso");
            } else {
                System.out.println("Valor inválido.");
            }
        }
    }

    private static void editarTreino(List<Treino> treinos) {
        if (treinos.isEmpty()) {
            System.out.println("Nenhum treino para editar.");
        } else {
            System.out.println("Treinos:");

            for (int i = 0; i < treinos.size(); i++) {
                System.out.printf("%d° %s\n", i + 1, treinos.get(i).getNome());
            }

            System.out.print("Digite o numero do treino a ser editado: ");
            int numeroEditado = sc.nextInt();
            sc.nextLine();

            if (numeroEditado >= 1 && numeroEditado <= treinos.size()) {
                Treino treinoSelecionado = treinos.get(numeroEditado - 1);

                System.out.print("Adicionar (1) exercício ou remover (0) exercícios: ");
                int respEditor = sc.nextInt();
                sc.nextLine();

                if (respEditor == 1) {
                    adicionarExercicioNoTreino(treinoSelecionado);
                } else if (respEditor == 0) {
                    removerExercicioDoTreino(treinoSelecionado);
                } else {
                    System.out.println("Opção de edição inválida.");
                }
            } else {
                System.out.println("Valor inválido.");
            }
        }
    }

    private static void adicionarExercicioNoTreino(Treino treinoSelecionado) {
        String respAdicao;
        do {
            System.out.print("Digite o nome do exercício: ");
            String nomeExercicio = sc.nextLine();

            System.out.print("Número de séries: ");
            int numeroSeries = sc.nextInt();
            sc.nextLine();

            Exercicio novoExercicio = new Exercicio(nomeExercicio, numeroSeries);
            treinoSelecionado.addExercicio(novoExercicio);

            System.out.println("Exercício adicionado com sucesso!");

            System.out.print("Quer adicionar mais exercícios? (sim/nao): ");
            respAdicao = sc.nextLine();

        } while (respAdicao.equalsIgnoreCase("sim"));
    }

    private static void removerExercicioDoTreino(Treino treinoSelecionado) {
        String respRemocao;
        do {
            List<Exercicio> listaExercicios = treinoSelecionado.getExercicios();

            if (listaExercicios.isEmpty()) {
                System.out.println("Não há exercícios neste treino para remover.");
                break;
            }

            System.out.println("Exercícios atuais:");
            for (int j = 0; j < listaExercicios.size(); j++) {
                System.out.printf("%d° %s\n", j + 1, listaExercicios.get(j).getNomeExercicio());
            }

            System.out.print("Digite o número do exercício a ser removido: ");
            int numExercicio = sc.nextInt();
            sc.nextLine();

            if (numExercicio >= 1 && numExercicio <= listaExercicios.size()) {
                Exercicio exRemovido = listaExercicios.get(numExercicio - 1);
                treinoSelecionado.removeExercicio(exRemovido);
                System.out.println("Exercício removido com sucesso!");
            } else {
                System.out.println("Número de exercício inválido.");
            }

            if (treinoSelecionado.getExercicios().isEmpty()) {
                System.out.println("Todos os exercícios deste treino foram removidos.");
                break;
            }

            System.out.print("Quer remover mais algum exercício? (sim/nao): ");
            respRemocao = sc.nextLine();

        } while (respRemocao.equalsIgnoreCase("sim"));
    }
}