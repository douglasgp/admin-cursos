package br.com.admin.fatec.ilp007.tarefa02;

public class ProdutoMB {

	private Produto produto;
	private ProdutoService prodServe = new ProdutoService();
	private double percentualReajuste = 0.05;
	private double totalReajuste;

	public void reajustaPreco() {
		prodServe.populaListaProduto();
		prodServe.getP1().setPrecoVenda(prodServe.getP1().getPrecoVenda() + prodServe.getP1().getPrecoVenda() * percentualReajuste);
		prodServe.getP2().setPrecoVenda(prodServe.getP2().getPrecoVenda() + prodServe.getP2().getPrecoVenda() * percentualReajuste);
		prodServe.getP3().setPrecoVenda(prodServe.getP3().getPrecoVenda() + prodServe.getP3().getPrecoVenda() * percentualReajuste);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoService getProdServe() {
		return prodServe;
	}

	public void setProdServe(ProdutoService prodServe) {
		this.prodServe = prodServe;
	}

	public double getPercentualReajuste() {
		return percentualReajuste;
	}

	public void setPercentualReajuste(double percentualReajuste) {
		this.percentualReajuste = percentualReajuste;
	}

	public double getTotalReajuste() {
		return totalReajuste;
	}

	public void setTotalReajuste(double totalReajuste) {
		this.totalReajuste = totalReajuste;
	}

}
