package projeto_final_bloco_01.model;

public class Deck extends Produto{
	
	private int nivel;

	public Deck(int id, int estoque, int tipo, String nome, float valor, int jogo, int nivel) {
		super(id, estoque, tipo, nome, valor, jogo);
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public void visualizar() {
		super.visualizar();
		
		String nivel;
		
		switch (this.nivel) {
		case 1 -> nivel = "Iniciante";
		case 2 -> nivel = "Intermediário";
		case 3 -> nivel = "Avançado";
		default -> nivel = "Inválido";
		}
		
		System.out.println("Nivel do deck: " + nivel);
	}

}
