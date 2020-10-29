package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

import java.util.Scanner;

public class Exercicio05 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		CalculaMedidasDeIdade calcIdade = new CalculaMedidasDeIdade();
		calcIdade.reset();

		System.out.println("Informe ano de nascimento: ");
		calcIdade.setAnoIdade(scan.nextInt());

		System.out.println("Informe ano atual: ");
		calcIdade.setAnoAtual(scan.nextInt());

		calcIdade.converteAnosMinutos();

		System.out.println("Idade em anos: " + calcIdade.pessoa.getIdade());
		System.out.println("Idade em meses: " + calcIdade.getMes());
		System.out.println("Idade em dias: " + calcIdade.getDia());
		System.out.println("Idade em horas: " + calcIdade.getHora());
		System.out.println("Idade em minutos: " + calcIdade.getMinutos());
		System.out.println("Idade em segundos: " + calcIdade.getSegundos());
	}

}
