package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;

/*
 * 4. Faça um programa para calcular o IMC de um pessoa.
 */
public class IMC {
	public static Scanner scan = new Scanner(System.in);
	public static String tipo;
	public static void main(String[] args) {
		Double altura, peso, result;
		System.out.println("Informe sua Altura: ");
		altura = scan.nextDouble();
		System.out.println("Informe seu Peso: ");
		peso = scan.nextDouble();
		result = calculaImc(peso, altura);
		System.out.println("IMC = " + result + "\nSTATUS: " + tipo);
	}
	
	public static Double calculaImc(Double p, Double a) {
		Double imc = p / Math.pow(a, 2);
		retornaCategoriaImc(imc);
		return imc;
	}
	
	public static void retornaCategoriaImc(Double n) {
		if(n < 18.5) {
			tipo = "Peso baixo";
		} else if (n >= 18.5 && n <= 24.9) {
			tipo = "Peso NORMAL";
		} else if (n >= 25.0 && n <= 29.9) {
			tipo = "SOBREPESO";
		} else if (n >= 30.0 && n <= 34.9) {
			tipo = "OBESIDADE I";
		} else if (n >= 35.0 && n <= 39.9) {
			tipo = "OBESIDADE II (severa)";
		} else if (n >= 40.0) {
			tipo = "OBESIDADE III (mórbida)";
		}
	}

}
