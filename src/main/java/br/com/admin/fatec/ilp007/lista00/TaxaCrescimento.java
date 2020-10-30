package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;
/*
 * 16.  Supondo que a população de um país A seja da ordem de 90.000 de habitantes com uma taxa anual
 * de crescimento de 3% e que a população do país B seja, aproximadamente de 200.000 habitantes,
 * com uma taxa anual de crescimento de 1,5%, faça um programa em que calcule e escreva a quantidade
 * de anos necessários para que a população do país A ultrapasse ou iguale a população do país B,
 * mantida essas taxas de crescimento.
 */
public class TaxaCrescimento {
	public static Scanner scan = new Scanner(System.in);
	public static double p1 = 90000, p2 = 200000;
	public static Integer ano = 0;
	
	public static void main(String[] args) {
		while (p1 < p2) {
			p1 += p1 * 3 / 100;
			p2 += p2 * 1.5 / 100;
			ano ++;
		}
		
		System.out.println("Necessário " + ano + " anos.");
	}

}
