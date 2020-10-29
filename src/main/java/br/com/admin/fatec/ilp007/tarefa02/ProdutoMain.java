package br.com.admin.fatec.ilp007.tarefa02;

public class ProdutoMain {
	
	public static void main(String[] args) {
		ProdutoMB prodMb = new ProdutoMB();
		
		prodMb.reajustaPreco();

		System.out.println(" = = = Após o Reajuste = = = ");
		System.out.println(prodMb.getProdServe().getP1().toString());
		System.out.println(prodMb.getProdServe().getP2().toString());
		System.out.println(prodMb.getProdServe().getP3().toString());
	}

}
