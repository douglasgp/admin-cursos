package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;
/*
 * 5. Faça um programa que receba o ano de nascimento de uma pessoa e o ano atual, calcule e mostre:
	a. A idade da pessoa em anos;
	b. A idade em meses;
	c. A idade em dias;
	d. A idade em horas;
	e. A idade em minutos;
	f. A idade em segundos.
 */
public class CalculaIdade {
	public static Scanner scan = new Scanner(System.in);
	public static Integer anoAtual, idadeAtual, idadeMes, idadeDias, idadeHoras, idadeMinutos, idadeSegundos;

	public static void main(String[] args){
		System.out.println("Informa ano de nascimento: ");
		idadeAtual = scan.nextInt();
		System.out.println("Informe ano atual: ");
		anoAtual = scan.nextInt();
		
		converteIdade();
		System.out.println("Idade em anos: " + idadeAtual);
		System.out.println("Idade em meses: " + idadeMes);
		System.out.println("Idade em dias: " + idadeDias);
		System.out.println("Idade em horas: " + idadeHoras);
		System.out.println("Idade em minutos: " + idadeMinutos);
		System.out.println("Idade em segundos: " + idadeSegundos);
	}

	public static void converteIdade() {
		idadeAtual = anoAtual - idadeAtual;
		idadeMes = idadeAtual * 12;
		idadeDias = idadeAtual * 365;
		idadeHoras = idadeDias * 24;
		idadeMinutos = idadeHoras * 60;
		idadeSegundos = idadeMinutos * 60;
	}

}
