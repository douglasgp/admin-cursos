package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;

/*
 * 9. Faça um programa que receba o valor do salário mínimo e o valor do salário de um funcionário,
 *  calcule  mostre a quantidade de salários mínimos que ganha esse funcionário.
 */
public class SalarioMinimo {
	public static Scanner scan = new Scanner(System.in);
	public static Double salMinimo, salAtual, qtdSal;
	
	public static void main(String[] args) {
		System.out.println("Informe salario mínimo atual: ");
		salMinimo = scan.nextDouble();
		System.out.println("Informe salário recebido: ");
		salAtual = scan.nextDouble();
		calculaSal();
		System.out.println("Salarios recebidos: " + salAtual);
	}
	
	public static void calculaSal() {
		salAtual /= salMinimo;
	}

}
