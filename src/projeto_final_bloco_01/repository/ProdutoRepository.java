package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;

public interface ProdutoRepository {

	public void criarProduto(Produto produto);
	public void listarTodos();
	public void consultaPorId(int id);
	public void atualizar(Produto produto);
	public void deletar(int id);
	
	public void gerirEstoque(int id, int estoque);
}
