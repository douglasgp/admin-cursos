package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;

/*
 * 7. Escreva um programa para ler o raio de um círculo, calcular e imprimir o diâmetro,
 *  a circunferência, e a área do círculo.
	diâmetro = 2 x raio
	circunferência = PI x raio2
	área = PI * raio2
 */
public class CalculaRaio {
	public static Scanner scan = new Scanner(System.in);
	public static Double raio, diametro, circunferencia, area;
	public static Double pi = 3.14159265359;

	public static void main(String[] args) {
		System.out.println("Informe o raio do círculo: ");
		raio = scan.nextDouble();
		calcDiametro();
		System.out.println("Diametro: " + diametro +
				"\nCircunferencia: " + circunferencia + 
				"\nArea: " + area);
	}

	public static void calcDiametro() {
		diametro = raio * raio;
		calcCircunferencia();
	}

	public static void calcCircunferencia() {
		circunferencia = 2 * pi * raio;
		calcArea();
	}

	public static void calcArea() {
		area = pi * (Math.pow(raio, 2));
	}

}
