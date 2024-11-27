package ctr;

import java.util.List;

import dao.ProdutoDAO;
import dto.Produto;

public class ProdutoController {
	private ProdutoDAO produtoDAO;

	public ProdutoController() {
		this.produtoDAO = new ProdutoDAO();
	}

	// Criar Produto
	public boolean criarProduto(String nomeProd, int idProd, String tamanhoProd, String densidadeProd,
			String materialProd, double precoProd) {
		Produto produto = new Produto(nomeProd, idProd, tamanhoProd, densidadeProd, materialProd, precoProd);
		return produtoDAO.inserir(produto);
	}

	// Editar Produto
	public boolean editarProduto(String nomeProd, int idProd, String tamanhoProd, String densidadeProd,
			String materialProd, double precoProd) {
		Produto produto = new Produto(nomeProd, idProd, tamanhoProd, densidadeProd, materialProd, precoProd);
		return produtoDAO.editar(produto);
	}

	// Pesquisar PRoduto
	public List<Produto> pesquisarPorNomeProduto(String nomeProd) {
		return produtoDAO.pesquisarPorNomeProduto(nomeProd);
	}

	// verificar Produto
	public Boolean verificaExistencia(int idProd) {
		return produtoDAO.verificaExistencia(idProd);
	}

	// Excluir Produto
	public Boolean excluirProduto(int idProd) {
		return produtoDAO.excluir(idProd);
	}

	// listar Produto
	public List<Produto> listarProdutos() {
		return produtoDAO.listar();
	}
}
