package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

import java.util.Scanner;

public class Exercicio13 {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		CalculaFerias calcFerias = new CalculaFerias();
		calcFerias.reset();
		
		System.out.println("Informe quantidade de faltas: ");
		calcFerias.setFaltas(scan.nextInt());
		
		calcFerias.calculaFaltas();
		System.out.println("QTD férias: " + calcFerias.getMsg());
	}
}
