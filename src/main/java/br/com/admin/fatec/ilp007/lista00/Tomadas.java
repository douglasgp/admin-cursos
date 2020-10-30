package br.com.admin.fatec.ilp007.lista00;

import java.util.Scanner;

/*
 * 12. (Fonte: Spoj Brasil – TOMADA13 - Tomadas)
	A Olimpíada Internacional de Informática (IOI, no original em inglês) é a mais prestigiada competição de 
	programação para alunos de ensino médio; seus aproximadamente 300 competidores se reúnem em um país diferente 
	todo ano para os dois dias de prova da competição. Naturalmente, os competidores usam o tempo livre para acessar a Internet, programar e jogar em seus notebooks, mas eles se depararam com um problema: o saguão do hotel só tem uma tomada.
	Felizmente, os quatro competidores da equipe brasileira da IOI trouxeram cada um uma régua de tomadas, 
	permitindo assim ligar vários notebooks em uma tomada só; eles também podem ligar uma régua em outra para 
	aumentar ainda mais o número de tomadas disponíveis. No entanto, como as réguas têm muitas tomadas, eles pediram para você escrever um programa que, dado o número de tomadas em cada régua, determina quantas tomadas podem ser disponibilizadas no saguão do hotel.
	Entrada:
	A entrada consiste de uma linha com quatro inteiros positivos T1, T2, T3, T4, indicando o número de tomadas
	 de cada uma das quatro réguas.
	Saída:
	Seu programa deve imprimir uma única linha contendo um único número inteiro, indicando o número máximo de
	 notebooks que podem ser conectados num mesmo instante.
	Restrições:
	2 <= Ti <= 6
	Exemplos
	Entrada: 2, 4, 3, 2
	Saída: 8
 */
public class Tomadas {
	public static Scanner scan = new Scanner(System.in);
	public static Integer t1, t2, t3, t4, resultado;
	
	public static void main(String[] args) {
		System.out.println("Qtd entradas Régua 1: ");
		t1 = scan.nextInt();
		System.out.println("Qtd entradas Régua 2: ");
		t2 = scan.nextInt();
		System.out.println("Qtd entradas Régua 3: ");
		t3 = scan.nextInt();
		System.out.println("Qtd entradas Régua 4: ");
		t4 = scan.nextInt();
		calculaEntradas();
		System.out.println("Qtd total de entradas: " + resultado);
		
	}
	
	public static void calculaEntradas() {
		resultado = (t1-1) + (t2-1) + (t3-1) + t4;
	}

}
