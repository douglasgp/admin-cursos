package br.com.admin.fatec.ilp007.tarefa02;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

	private List<Produto> listProduto = new ArrayList<Produto>();
	private Produto p1 = new Produto();
	private Produto p2 = new Produto();
	private Produto p3 = new Produto();

	public void populaListaProduto() {
		p1.setCodigo(01);
		p1.setNome("Computador");
		p1.setMarca("Lenovo");
		p1.setUnidade("peça");
		p1.setPrecoVenda(998.90);
		p1.setPrecoCusto(899.90);
		p1.setSaldo(p1.getPrecoVenda() - p1.getPrecoCusto());

		p2.setCodigo(02);
		p2.setNome("Geladeira");
		p2.setMarca("Brastemp");
		p2.setUnidade("peça");
		p2.setPrecoVenda(1998.90);
		p2.setPrecoCusto(1899.90);
		p2.setSaldo(p2.getPrecoVenda() - p2.getPrecoCusto());

		p3.setCodigo(03);
		p3.setNome("Caneta");
		p3.setMarca("BIC");
		p3.setUnidade("kg");
		p3.setPrecoVenda(9.90);
		p3.setPrecoCusto(8.90);
		p3.setSaldo(p3.getPrecoVenda() - p3.getPrecoCusto());

		this.listProduto.add(p1);
		this.listProduto.add(p2);
		this.listProduto.add(p3);
	}

	public List<Produto> getListProduto() {
		return listProduto;
	}

	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}

	public Produto getP1() {
		return p1;
	}

	public void setP1(Produto p1) {
		this.p1 = p1;
	}

	public Produto getP2() {
		return p2;
	}

	public void setP2(Produto p2) {
		this.p2 = p2;
	}

	public Produto getP3() {
		return p3;
	}

	public void setP3(Produto p3) {
		this.p3 = p3;
	}

}
