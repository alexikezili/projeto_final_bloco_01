package projeto_final_bloco_01.model;

public class Carta extends Produto{
	
	private int conservacao;

	public Carta(int id, int estoque, int tipo, String nome, float valor, int jogo, int conservacao) {
		super(id, estoque, tipo, nome, valor, jogo);
		this.conservacao = conservacao;
	}

	public int getConservacao() {
		return conservacao;
	}

	public void setConservacao(int conservacao) {
		this.conservacao = conservacao;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		
		String conservacao;
		
		switch (this.conservacao) {
		case 1 -> conservacao = "M";
		case 2 -> conservacao = "NM";
		case 3 -> conservacao = "SP";
		case 4 -> conservacao = "MP";
		case 5 -> conservacao = "HP";
		case 6 -> conservacao = "D";		
		default -> conservacao = "Inválido";
		}

		System.out.println("Conservação: " + conservacao);
	}
	
}
