package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository{
	
	private ArrayList<Produto> listaProdutos = new ArrayList<>();
	int id = 0;

	@Override
	public void criarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("O produto foi criado com sucesso!");
		
	}

	@Override
	public void listarTodos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}
		
	}

	@Override
	public void consultaPorId(int id) {
		Optional<Produto> produto = buscarNaCollection(id);
		
		if (produto.isPresent()) {
			produto.get().visualizar();
		} else {
			System.out.printf("\nID = %d | Produto não encontrado", id);
		}
		
	}

	@Override
	public void atualizar(Produto produto) {
		Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());
		
		if (buscaProduto.isPresent()) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
			System.out.printf("\nProduto ID %d atualizado com sucesso", produto.getId());
		} else {
			System.out.printf("\nProduto ID %d não foi encontrado", produto.getId());
		}
		
	}

	@Override
	public void deletar(int id) {
		Optional<Produto> produto = buscarNaCollection(id);
		
		if (produto.isPresent()) {
			if (listaProdutos.remove(produto.get()) == true) 
				System.out.printf("\nProduto ID %d foi excluído", id);
		} else {
			System.out.printf("\nProduto ID %d não encontrado", id);
		}
		
	}
	
	public int gerarId() {
		return ++ id;
	}
	
	public Optional<Produto> buscarNaCollection(int id) {
		for (var produto : listaProdutos) {
			if (produto.getId() == id) {
				return Optional.of(produto);
			}
		}
		
		return Optional.empty();
	}

}
