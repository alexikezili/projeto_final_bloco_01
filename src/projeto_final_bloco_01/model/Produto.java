package projeto_final_bloco_01.model;

import java.text.NumberFormat;

public abstract class Produto {
	private int id, estoque, tipo, jogo;
	private String nome;
	private float valor;
	
	public Produto(int id, int estoque, int tipo, String nome, float valor, int jogo) {
		this.id = id;
		this.estoque = estoque;
		this.tipo = tipo;
		this.nome = nome;
		this.valor = valor;
		this.jogo = jogo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public int getJogo() {
		return jogo;
	}

	public void setJogo(int jogo) {
		this.jogo = jogo;
	}
	
	public void visualizar() {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		String tipo, jogo;
		
		switch (this.tipo) {
		case 1 -> tipo = "Carta";
		case 2 -> tipo = "Deck";
		default -> tipo = "Inválido";
		}
		
		switch (this.jogo) {
		case 1 -> jogo = "Pokemon";
		case 2 -> jogo = "Yu-Gi-OH";
		case 3 -> jogo = "Magic";
		case 4 -> jogo = "Outros";
		default -> jogo = "Inválido";
		}
		
		System.out.println("***************************************");
		System.out.println("DADOS DO PRODUTO                       ");
		System.out.println("***************************************");
		System.out.println("ID do Produto: " + this.id);
		System.out.println("Jogo: " + jogo);
		System.out.println("Nome do Produto: " + this.nome);
		System.out.println("Tipo do Produto: " + tipo);
		System.out.println("Preço do Produto: " + nfMoeda.format(this.valor));
		System.out.println("Quantidade no estoque: " + estoque);
	}
}
