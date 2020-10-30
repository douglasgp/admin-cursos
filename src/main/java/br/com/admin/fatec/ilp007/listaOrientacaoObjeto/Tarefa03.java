package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

public class Tarefa03 {
	
	public static void main(String[] args) {
		double valor;
		
		Conta c1 = new Conta();
		c1.setConta("0135-7");
		c1.setCpf("0111111111-02");
		c1.setNome("José Silva");
		c1.setSaldo(1045.36);
		
		Conta c2 = new Conta("0246-8");
		c2.setCpf("0222222222-03");
		c2.setNome("Maria Silva");
		c2.setSaldo(2090.72);
		
		Conta c3 = new Conta("01245-3", "033333333-04");
		c3.setNome("Frederico Silva");
		c3.setSaldo(3060.82);
		
		Conta c4 = new Conta("03164-4", "0444444444-05", "Otaviono Silva");
		c4.setSaldo(1190.89);
		
		Conta c5 = new Conta("0265-0", "0555555555-06", "Helio Silva", 556.32);
		
		System.out.println("= = = CONTAS = = =");
		System.out.println(c1.toString());
		System.out.println(" ");
		System.out.println(c2.toString());
		System.out.println(" ");
		System.out.println(c3.toString());
		System.out.println(" ");
		System.out.println(c4.toString());
		System.out.println(" ");
		System.out.println(c5.toString());
		
		System.out.println("\n= = = PÓS-DEPOSITO = = = ");
		c1.realizaDeposito(589.34);
		c2.realizaDeposito(342.55);
		c3.realizaDeposito(345.87);
		c4.realizaDeposito(300.43);
		c5.realizaDeposito(587.12);
		System.out.println(c1.exibeSaldo());
		System.out.println(c2.exibeSaldo());
		System.out.println(c3.exibeSaldo());
		System.out.println(c4.exibeSaldo());
		System.out.println(c5.exibeSaldo());
		
		System.out.println("\n= = = PÓS-SAQUE = = = ");
		c1.realizaSaque(192.88);
		c2.realizaSaque(449.02);
		c3.realizaSaque(878.90);
		c4.realizaSaque(443.90);
		c5.realizaSaque(123.41);
		System.out.println(c1.exibeSaldo());
		System.out.println(c2.exibeSaldo());
		System.out.println(c3.exibeSaldo());
		System.out.println(c4.exibeSaldo());
		System.out.println(c5.exibeSaldo());
				
	}

}
