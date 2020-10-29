package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;

/*
 * 13. De acordo com o artigo 130 da Consolidação das Leis de Trabalhos (CLT), o trabalhador que tem 
 * carteira assinada tem direito a 30 dias de férias remuneradas depois de completar 12 meses seguidos na empresa, 
 * podendo esse período se menor se houver faltas injustificadas, conforme relação abaixo.
 * - 30 dias corridos de férias, quando não houver mais de cinco faltas no serviço;
 * - 24 dias corridos de férias, quando houver de 6 a 14 faltas;
 * - 18 dias corridos de férias, quando houver de 15 a 23 faltas;
 * - 12 dias corridos de férias, quando houver de 24 a 32 faltas;
 * Faça um programa que informe a quantidade de dias que um funcionário terá de férias.
 */
public class CalculaFerias {
	public static Scanner scan = new Scanner(System.in);
	public static Integer faltas;
	public static String msg;

	public static void main(String[] args) {
		System.out.println("Informe a quantidade faltas: ");
		faltas = scan.nextInt();
		contaFaltas();
		System.out.println(msg);
	}

	public static void contaFaltas() {
		if (faltas == 0) {
			msg = "30 dias";
		} else if (faltas >= 6 && faltas <= 14) {
			msg = "24 dias";
		} else if (faltas >= 15 && faltas <= 23) {
			msg = "18 dias";
		} else if (faltas >= 24 && faltas <= 32) {
			msg = "12 dias";
		}
	}

}
