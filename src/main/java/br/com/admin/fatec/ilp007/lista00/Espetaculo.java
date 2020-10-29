package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;

/*
 * 10. Faça um programa que recebe o custo de um espetáculo teatral e o preço do convite desse espetáculo.
 * O Algoritmo deve calcular e mostrar a quantidade de convites que devem ser vendidos para que pelo menos o 
 * custo do espetáculo seja alcançado.
 */
public class Espetaculo {
	public static Scanner scan = new Scanner(System.in);
	public static Double custo, convite;
	public static Integer qtdConvite;
	public static void main(String[] args) {
		System.out.println("Custo do espetáculo: ");
		custo = scan.nextDouble();
		System.out.println("Valor do ingresso: ");
		convite = scan.nextDouble();
		calculaValor();
		System.out.println("Total: " + qtdConvite);
		
	}
	
	public static void calculaValor() {
		qtdConvite = 0;
		do {
			qtdConvite++;
		} while ((qtdConvite*convite) < custo);
	}

}
