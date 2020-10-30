package br.com.admin.fatec.ilp007.lista00;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 14.  Faça um programa que receba a idade de trezentas pessoas, calcule e exiba a quantidade de pessoas
 *  em cada faixa etária; e a porcentagem de cada faixa etária em relação ao total de pessoas.
 *  As faixas etárias são:
 *  1 a 15 anos
 *  16 a 30 anos
 *  31 a 45 anos
 *  46 a 60 anos
 *  igual a 61 anos
 */
public class FaixaEtaria {
	public static List<Integer> listIdade = new ArrayList<Integer>();
	public static Random gerador = new Random();
	public static int cat15, cat30, cat45, cat60, cat61;
	
	public static void main(String[] args) {	
		geraIdade();
		System.out.println("1 a 15 anos: " + cat15);
		System.out.println("16 a 30 anos: " + cat30);
		System.out.println("31 a 45 anos: " + cat45);
		System.out.println("46 a 60 anos: " + cat60);
		System.out.println("61 anos: " + cat61);

	}

	public static void geraIdade() {
		for (int i = 0; i < 300; i++) {
			listIdade.add(gerador.nextInt(61));
		}
		organizaCategoria();
	}

	public static void organizaCategoria() {
		for (Integer valor : listIdade) {
			if (valor >= 1 && valor <= 15) {
				cat15++;
			} else if (valor >= 16 && valor <= 30) {
				cat30++;
			} else if (valor >= 31 && valor <= 45) {
				cat45++;
			} else if (valor >= 46 && valor <= 60) {
				cat60++;
			} else if (valor == 61) {
				cat61++;
			}

		}
	}
}