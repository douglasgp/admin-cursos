package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;

/*
 * 8. Faça um programa que receba a medida de dois ângulos de um triângulo, 
 * calcule e mostre a medida do terceiro ângulo. Sabe-se que a soma dos ângulos de um triângulo é de 180°.
 */
public class CalculaTriangulo {
	public static Scanner scan = new Scanner(System.in);
	public static Double a1, a2, a3;
	
	public static void main(String[] args) {
		System.out.println("Informe Ângulo 1 do triângulo: ");
		a1 = scan.nextDouble();
		System.out.println("Informe o Ângulo 2 do triângulo: ");
		a2 = scan.nextDouble();
		calculaAngulo();
		System.out.println("3º Ângulo: " + a3);
		
	}
	
	public static void calculaAngulo() {
		a3 = a1+a2-180;
	}
}
