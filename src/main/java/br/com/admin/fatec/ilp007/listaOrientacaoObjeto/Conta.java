package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

public class Conta {

	private String conta;
	private String cpf;
	private String nome;
	private double saldo;

	public Conta(String conta, String cpf, String nome, double saldo) {
		super();
		this.conta = conta;
		this.cpf = cpf;
		this.nome = nome;
		this.saldo = saldo;
	}

	public Conta(String conta, String cpf, String nome) {
		super();
		this.conta = conta;
		this.cpf = cpf;
		this.nome = nome;
	}

	public Conta(String conta, String cpf) {
		super();
		this.conta = conta;
		this.cpf = cpf;
	}

	public Conta(String conta) {
		super();
		this.conta = conta;
	}

	public Conta() {
	}

	public void realizaDeposito(double valor) {
		if (valor <= 0) {
			System.out.println("Depósito deve ser maior que R$ 0");
		} else {
			this.saldo += valor;
		}
	}

	public void realizaSaque(double valor) {
		if(saldo > 0) {
			this.saldo -= valor;			
		} else {
			System.out.println("Operação não permitida: seu saldo é = R$ " + this.saldo);
		}

	}

	public double exibeSaldo() {
		return this.saldo;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "ContaCorrente [CC: " + conta + ", CPF: " + cpf + ", NOME: " + nome + ", SALDO: R$" + saldo + "]";
	}

}
