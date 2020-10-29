package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;

public class RaioMain {
	static Scanner scan = new Scanner(System.in);
	public static Double pi = 3.141592654;
	
	public static void main(String[] args) {
		Double area, res;
		
		System.out.println("Informe a área: ");
		area = scan.nextDouble();
		
		res = calculaArea(area);
		
		System.out.println("Resultado: " + res);
		
	}
	
	public static Double calculaArea(Double area) {
		return pi * Math.pow(area, 2);		
	}

}
