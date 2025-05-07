package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Carta;
import projeto_final_bloco_01.model.Deck;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		ProdutoController produtos = new ProdutoController();
		
		int opcao, id, tipo, estoque, jogo, conservacao, nivel;
		String nome;
		float valor;
		
		Carta c1 = new Carta(produtos.gerarId(), 3, 1, "Charizard", 30, 1, 2);
		produtos.criarProduto(c1);
		
		Deck d1 = new Deck(produtos.gerarId(), 8, 2, "Deck Kaiba", 60, 2, 2);
		produtos.criarProduto(d1);
		
		while (true) {

			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("        TCG SHOP 82 - A SUA LOJA DE CARD GAME        ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar produto                        ");
			System.out.println("            2 - Listar todas os produtos             ");
			System.out.println("            3 - Buscar produto por ID                ");
			System.out.println("            4 - Atualizar Dados do produto           ");
			System.out.println("            5 - Apagar produto                       ");
			System.out.println("            6 - Gerir estoque                        ");
			System.out.println("            7 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

//			try {
//				opcao = sc.nextInt();
//				sc.nextLine();
//			} catch (InputMismatchException e) {
//				System.out.println("\nDigite valores inteiros!");
//				sc.nextLine();
//				opcao = 0;
//			}
			
			opcao = lerInt(sc, 7);

			if (opcao == 7) {
				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "\n╔════════════════════╗\r\n"
						+ "║░░░░░░░░░░░░░░░░░░░░║\r\n"
						+ "║░  ♦ TCG SHOP 82 ♦ ░║\r\n"
						+ "║░░░░░░░░░░░░░░░░░░░░║\r\n"
						+ "║░    ★ ☆ ✦ ☆ ★    ░║\r\n"
						+ "║░░░░░░░░░░░░░░░░░░░░║\r\n"
						+ "║░    GENERATION    ░║\r\n"
						+ "║░░░░░░░░░░░░░░░░░░░░║\r\n"
						+ "╚════════════════════╝" + Cores.TEXT_RESET);
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "Criar Produto\n\n");
					
					System.out.println("Digite o nome do produto: ");
					nome = sc.nextLine();
					
					System.out.println("Digite o tipo do produto (1 - CARTA | 2 - DECK) ");
					tipo = lerInt(sc, 2);
					
					System.out.println("Digite o jogo do produto (1 - POKEMON | 2 - YUGIOH | 3 - MAGIC | 4 - OUTROS) ");
					jogo = lerInt(sc, 4);
					
					System.out.println("Digite a quantidade do estoque: ");
					estoque = lerInt(sc);
					
					System.out.println("Digite o valor do produto: ");
					valor = lerFloat(sc);
					
					switch (tipo) {
					case 1 -> {
						System.out.println("Informe o estado de conservação da Carta (1 - M | 2 - NM | 3 - SP | 4 - MP | 5 - HP | 6 - D) ");
						conservacao = lerInt(sc, 6);
						produtos.criarProduto(new Carta(produtos.gerarId(), estoque, tipo, nome, valor, jogo, conservacao));
					}
					case 2 -> {
						System.out.println("Digite o nivel do DecK (1 - INICIANTE | 2 - INTERMEDIÁRIO | 3 - AVANÇADO) ");
						nivel = lerInt(sc, 3);
						produtos.criarProduto(new Deck(produtos.gerarId(), estoque, tipo, nome, valor, jogo, nivel));
					}
					}
				
					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todas os Produtos\n");
					produtos.listarTodos();
					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Consultar dados do Produto por ID\n\n");
					System.out.println("Digite o ID do produto");
					id = lerInt(sc);
					
					produtos.consultaPorId(id);

					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados do Produton\n");
					System.out.println("Digite o ID do produto");
					id = lerInt(sc);
					sc.nextLine();
					
					Optional<Produto> produto = produtos.buscarNaCollection(id);
					
					if (produto.isPresent()) {
						System.out.println("Digite o novo nome do Produto: ");
						nome = sc.nextLine();
						
						System.out.println("Digite o novo tipo do produto (1 - CARTA | 2 - DECK) ");
						tipo = lerInt(sc, 2);
						
						System.out.println("Digite o jogo do produto (1 - POKEMON | 2 - YUGIOH | 3 - MAGIC | 4 - OUTROS) ");
						jogo = lerInt(sc, 4);
						
						System.out.println("Digite a quantidade do estoque: ");
						estoque = lerInt(sc);
						
						System.out.println("Digite o novo valor do Produto");
						valor = lerFloat(sc);
						
						switch (tipo) {
						case 1 -> {
							System.out.println("Informe o estado de conservação da Carta (1 - M | 2 - NM | 3 - SP | 4 - MP | 5 - HP | 6 - D ");
							conservacao = lerInt(sc, 6);
							produtos.atualizar(new Carta(id, estoque, tipo, nome, valor, jogo, conservacao));
						}
						case 2 -> {
							System.out.println("Digite o nivel do DecK (1 - INICIANTE | 2 - INTERMEDIÁRIO | 3 - AVANÇADO ");
							nivel = lerInt(sc, 3);
							produtos.atualizar(new Deck(id, estoque, tipo, nome, valor, jogo, nivel));
						}
						}
					} else
						System.out.printf("\nProduto ID %d não existe", id);

					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Apagar Produto\n\n");
					System.out.println("Digite o ID do produto: ");
					id = lerInt(sc);
					
					produtos.deletar(id);

					keyPress();
					break;
					
				case 6:
					System.out.println(Cores.TEXT_WHITE + "Atualizar estoque\n");
					System.out.println("Digite o ID do produto");
					id = lerInt(sc);
					
					Optional<Produto> produto1 = produtos.buscarNaCollection(id);
					
					if (produto1.isPresent()) {
						System.out.println("Digite a nova quantidade de estoque: ");
						estoque = lerInt(sc);
						
						produtos.gerirEstoque(id, estoque);
					} else System.out.printf("\nProduto ID %d não existe", id);

					keyPress();
					break;
					
//				default:
//					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
//					keyPress();
//					break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Alex Ikezili - alex.ikezili@icloud.com");
		System.out.println("github.com/alexikezili");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");

			int input;
			while ((input = System.in.read()) != '\n') {
				if (input == -1) {
					throw new IOException("Entrada encerrada inesperadamente");
				}
			}

		} catch (IOException e) {
			System.err.println("Erro de entrada/saída: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
		}
	}
	
	private static int lerInt(Scanner sc, int max) {
		int valor;
		while(true) {
			try {
				valor = sc.nextInt();
				sc.nextLine();
					if (valor >= 1 && valor <= max) {
						return valor;
					} else {
//						System.out.printf("\nValor fora do intervalo (1 a %d)", max);
						System.out.printf(Cores.TEXT_RED_BOLD + "\nValor fora do intervalo (1 a %d) " + Cores.TEXT_RESET, max);
					}
			} catch(InputMismatchException e) {
				System.out.println(Cores.TEXT_RED_BOLD + "Entrada inválida. Digite apenas números " + Cores.TEXT_RESET);
				sc.nextLine();
			}
		}
	}
	
	private static int lerInt(Scanner sc) {
		int valor;
		while(true) {
			try {
				valor = sc.nextInt();
				sc.nextLine();
				return valor;
			} catch(InputMismatchException e) {
				System.out.println(Cores.TEXT_RED_BOLD + "Entrada inválida. Digite apenas números " + Cores.TEXT_RESET);
				sc.nextLine();
			}
		}
	}
	
	private static float lerFloat(Scanner sc) {
		int valor;
		while(true) {
			try {
				valor = sc.nextInt();
				sc.nextLine();
				return valor;
			} catch(InputMismatchException e) {
				System.out.println(Cores.TEXT_RED_BOLD + "Entrada inválida. Digite apenas números " + Cores.TEXT_RESET);
				sc.nextLine();
			}
		}
	}

}