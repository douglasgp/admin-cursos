package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

import java.util.Scanner;

public class Exercicio07 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		CalculaCirculo calcCirculo = new CalculaCirculo();
		calcCirculo.reset();

		System.out.println("Informe o raio do círculo: ");
		calcCirculo.circulo.setRaio(scan.nextDouble());
		calcCirculo.calcDiametro();
		System.out.println("Diametro: " + calcCirculo.circulo.getDiametro() + "\nCircunferencia: "
				+ calcCirculo.circulo.getCircunferencia() + "\nArea: " + calcCirculo.circulo.getArea());
	}

}
