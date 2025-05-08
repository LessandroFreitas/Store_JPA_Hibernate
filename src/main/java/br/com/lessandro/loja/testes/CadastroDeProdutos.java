package br.com.lessandro.loja.testes;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import br.com.lessandro.loja.dao.CategoriaDao;
import br.com.lessandro.loja.dao.ProdutoDao;
import br.com.lessandro.loja.modelo.Categoria;
import br.com.lessandro.loja.modelo.Produto;
import br.com.lessandro.loja.util.JPAUtil;



public class CadastroDeProdutos {
 
	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManeger();
		ProdutoDao produtoDao = new ProdutoDao(em); 
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());

	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi","Muito Legal",new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManeger();
		ProdutoDao produtoDao = new ProdutoDao(em); 
		CategoriaDao categoriaDao = new CategoriaDao(em); 
				
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}

	
	
}
