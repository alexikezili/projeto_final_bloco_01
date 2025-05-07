package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.model.Carta;
import projeto_final_bloco_01.model.Deck;
import projeto_final_bloco_01.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcao, id, tipo, estoque, jogo, conservacao, nivel;
		String nome;
		float valor;
		
		Carta c1 = new Carta(1, 3, 1, "Charizard", 30, 1, 2);
		c1.visualizar();
		
		Deck d1 = new Deck(2, 8, 2, "Deck Kaiba", 60, 2, 2);
		d1.visualizar();
		
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
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				sc.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
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
				
					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todas os Produtos\n\n");

					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Consultar dados do Produto por ID\n\n");

					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados do Produton\n");

					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Apagar Produto\n\n");

					keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					keyPress();
					break;
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

}