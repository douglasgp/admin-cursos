package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;
/*
 * 3. Faça um programa que leia um número inteiro é informe se ele ele é par ou ímpar.
 */
public class ImparPar {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Integer n1, n2;
		String result;
		System.out.println("Informe um número : ");
		n1 = scan.nextInt();
		result = imparPar(n1);
		System.out.println("Maior número informado: " + result);
	}
	
	public static String imparPar(Integer n1) {
		return n1 % 2 == 0 ? "PAR" : "ÍMPAR";
	}
}
