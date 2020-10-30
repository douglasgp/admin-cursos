package br.com.admin.fatec.ilp007.lista00;

import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * 2. Faça um programa que transforme uma idade (em anos) em minutos.
 */
public class ConverteIdadeMinutos {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Calendar.getInstance();
		Integer idade;
		Long r;
		System.out.println("Informe sua idade: ");
		idade = scan.nextInt();
		r = converteIdade(idade);
		System.out.println(r);
	}

	public static Long converteIdade(Integer idade) {
		return (long) (idade * ((365 * 24) * 60));
	}
}
