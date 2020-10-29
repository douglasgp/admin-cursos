package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

import java.util.Scanner;

public class Exercicio02 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		CalculaAnosMinutos calculaIdade = new CalculaAnosMinutos();
		calculaIdade.reset();

		System.out.println("Informe uma idade em anos: ");
		calculaIdade.pessoa.setIdade(scan.nextInt());

		calculaIdade.converteAnosMinutos();
		System.out.println("Idade anos: " + calculaIdade.pessoa.getIdade());
		System.out.println("Idade minutos: " + calculaIdade.getMinutos());
	}

}
