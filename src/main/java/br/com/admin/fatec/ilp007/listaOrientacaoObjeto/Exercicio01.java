package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

import java.util.Scanner;

public class Exercicio01 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		CalculaAreaCirculo calcula = new CalculaAreaCirculo();
		calcula.reset();
		calcula.circulo.setPi(3.14);
		System.out.println("Informe o valor do raio: ");
		calcula.circulo.setRaio(scan.nextDouble());
		
		calcula.calculaArea();
		System.out.println(calcula.circulo.toString());
	}
	
	

}
