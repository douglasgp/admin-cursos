package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;

/*
 * 11. Sabe-se que para iluminar de maneira correta os cômodos de uma casa, para cada m2, 
 * deve-se usar 18W de potência. Faça um programa que receba as duas dimensões de um cômodo (em metros), 
 * calcule e mostre a sua área (em m2) e a potência de iluminação que deve ser utilizada.
 */
public class IluminacaoComodo {
	public static Scanner scan = new Scanner(System.in);
	public static Double d1, d2, resultado;
	public static Integer w = 18;
	
	public static void main(String[] args) {
		System.out.println("Informe dimensão 1: ");
		d1 = scan.nextDouble();
		
		System.out.println("Informe dimensão 2: ");
		d2 = scan.nextDouble();
		
		calculaW();
		System.out.println("Total: " + resultado);
	}
	
	public static void calculaW() {
		resultado = d1*d2 * w;
	}

}
