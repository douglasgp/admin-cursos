package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;

/*
 * 6. Faça um programa que leia o nome e o sobrenome de um usuário como duas entradas separadas; 
 * e, exiba o nome e o sobrenome na mesma linha.
 */
public class ExibeNome {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Informe primeiro nome: ");
		String firstName = scan.nextLine();
		
		System.out.println("Informe último nome: ");
		String lastName = scan.nextLine();
		
		System.out.println("Bem vindo " + firstName + " " + lastName);
		
	}
}
