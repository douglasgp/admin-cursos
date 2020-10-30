package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

import java.util.Scanner;

public class Exercicio04 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		CalculaIMC calcImc = new CalculaIMC();
		calcImc.reset();

		System.out.println("Informe a ALTURA: ");
		calcImc.pessoa.setAltura(scan.nextDouble());

		System.out.println("Infomre o PESO: ");
		calcImc.pessoa.setPeso(scan.nextDouble());

		calcImc.calculaImc();
		System.out.println("IMC: " + calcImc.imc);
		System.out.println("Categoria: " + calcImc.tipoIMC);
	}

}
