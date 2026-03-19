package app;

import model.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int contCadastro = 0;
        Livro[] livros = new Livro[50];

        //String[] nomeLivro = new String[50];
        //String[] autorLivro = new String[50];
        //boolean[] emprestado = new boolean[50];

        boolean parar = true;

        while (parar) {
            System.out.println("==============================");
            System.out.println("          BIBLIOTECA          ");
            System.out.println("==============================");

            System.out.println("  [1] - Cadastrar Livros");
            System.out.println("  [2] - Listar Livros");
            System.out.println("  [3] - Buscar Livros");
            System.out.println("  [4] - Alugar Livros");
            System.out.println("  [5] - Devolver Livros");
            System.out.println("  [0] - Sair");

            int opcao;
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Digite apenas números!");
                sc.nextLine();
                System.out.println();
                continue;
            }

            switch (opcao) {
                case 0:
                    System.out.println("Encerrando programa...");
                    parar = false;
                    break;
                case 1:
                    for (; contCadastro < livros.length; ) {
                        Livro livro = new Livro();

                        System.out.print("Insira o titulo do livro: ");
                        livro.setNome(sc.nextLine());
                        System.out.print("Insira o nome do autor do livro: ");
                        livro.setAutor(sc.nextLine());
                        livro.setEmprestado();

                        livros[contCadastro] = livro;
                        contCadastro++;

                        char opcao1;
                        while (true) {
                            System.out.print("Deseja continuar inserindo livro? [S/N]: ");
                            opcao1 = sc.next().charAt(0);
                            sc.nextLine();
                            System.out.println();
                            if (opcao1 == 'S' || opcao1 == 's') {
                                break;
                            } else if (opcao1 == 'N' || opcao1 == 'n') {
                                break;
                            } else {
                                System.out.println("Opção inválida! Digite apenas S ou N.");
                            }
                        }
                        if (opcao1 == 'S' || opcao1 == 's') {
                            continue;
                        } else if (opcao1 == 'N' || opcao1 == 'n') {
                            break;
                        }
                    }
                    break;

                case 2:
                    if (contCadastro == 0) {
                        System.out.println();
                        System.out.println("Não existe nenhum livro cadastrado para listar!");
                        System.out.println();
                        break;
                    } else {
                        for (int i = 0; i < contCadastro; i++) {
                                livros[i].listarLivro();
                        }
                    }
                    break;
                case 3:
                    if (contCadastro == 0) {
                        System.out.println();
                        System.out.println("Não existe nenhum livro cadastrado para fazer a busca!");
                        System.out.println();
                        break;
                    } else {
                        System.out.println();
                        System.out.print("Qual livro desejar procurar: ");
                        String busca = sc.nextLine();
                        System.out.println();

                        boolean encontrado = false;

                        for (int i = 0; i < contCadastro; i++) {
                            if (livros[i].buscarLivro(busca)) {
                                encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Livro não existe no sistema!");
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    if (contCadastro == 0) {
                        System.out.println();
                        System.out.println("Não existe nenhum livro cadastrado para alugar!");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.print("Qual nome do livro que deseja alugar: ");
                        String alugar = sc.nextLine();
                        System.out.println();

                        boolean encontrado = false;

                        for (int i = 0; i < contCadastro; i++) {
                            if (livros[i].alugarLivro(alugar)){
                                encontrado = true;
                            }

                        }
                        if (!encontrado) {
                            System.out.println("Livro não encontrado no sistema para alugar!");
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    if (contCadastro == 0) {
                        System.out.println();
                        System.out.println("Não existe nenhum livro cadastrado para ser devolvido!");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.print("Qual o livro que irá ser devolvido: ");
                        String devolucao = sc.nextLine();
                        System.out.println();

                        boolean encontrado = false;

                        for (int i = 0; i < contCadastro; i++) {
                            if (livros[i].devolucaoLivro(devolucao)) {
                                encontrado = true;
                            }
                        }
                        if (!encontrado){
                            System.out.println("Livro não encontrado no sistema para ser devolvido!");
                            System.out.println();
                        }
                    }
            }
        }
    }
}

