package br.com.admin.fatec.ilp007.aula03;

import java.util.Scanner;

public class CalculaMedia {
	public static Scanner scan =new Scanner(System.in);
	public static Double n1, n2, media;
	
	public static void main(String[] args) {
		System.out.println("N1: ");
		n1 = scan.nextDouble();
		
		System.out.println("N2: ");
		n2 = scan.nextDouble();
		
		media = (n1 + n2) / 2;
		System.out.println("Media: " + media);
	}

}
