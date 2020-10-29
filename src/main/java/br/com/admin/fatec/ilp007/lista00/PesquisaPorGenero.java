package br.com.admin.fatec.ilp007.lista00;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * 15. Foi feita uma pesquisa entre os habitantes de uma região e coletados os dados de altura e sexo (0=masc, 1=fem) das pessoas. 
 * Faça um programa que leia os dados de 50 pessoas e no final, informe:
 * - A maior e a menor altura encontrada
 * - A média de altura das mulheres
 * - A média de altura da população
 * - O percentual de homens na população
 */
public class PesquisaPorGenero {
	public static Scanner scan = new Scanner(System.in);
	public static Random rd = new Random();
	public static Random rdAltura = new Random();
	public static List<Pessoa> listPessoas = new ArrayList<>();
	public static Integer qtdPessoas = 50;
	public static Pessoa pessoa;
	public static Double maiorAltura = 0.0, menorAltura = 0.0, mediaAlturaFeminino = 0.0, mediaAlturaPopulacao = 0.0;
	public static double parcelaMasculina = 0.0;

	public static void main(String[] args) {
		geraDados();

		System.out.println("Maior altura: " + maiorAltura);
		System.out.println("Menor altura: " + menorAltura);
		System.out.println("Altura média feminino: " + mediaAlturaFeminino);
		System.out.println("Altura média população: " + mediaAlturaPopulacao);
		System.out.println("Percentual masculino: " + parcelaMasculina);

		/*
		 * for (Pessoa string : listPessoas) { System.out.println(string.toString()); }
		 */
	}

	public static void geraDados() {
		for (int i = 0; i < qtdPessoas; i++) {
			verificaGenero(rd.nextInt(2));
			pessoa = new Pessoa();
			pessoa.setGenero(verificaGenero(rd.nextInt(2)));
			pessoa.setAltura(formataValor(rd.nextDouble() * 90));
			listPessoas.add(pessoa);
		}
		retornaResultado();
		// testaGenero();
	}

	public static char verificaGenero(Integer n) {
		char g = 0;
		if (n == 0) {
			g = 'M';
		} else if (n == 1) {
			g = 'F';
		}
		return g;
	}

	public static Double formataValor(Double d) {
		DecimalFormat df = new DecimalFormat("#0.000");
		return new Double(df.format(d));
	}

	public static void retornaResultado() {
		int contMasc = 0, contAltFem = 0, contMediaPop;

		for (Pessoa pessoa : listPessoas) {
			menorAltura = pessoa.getAltura();
			mediaAlturaPopulacao += pessoa.getAltura();
			if (pessoa.getGenero() == 'F') {
				contAltFem++;
				mediaAlturaFeminino += pessoa.getAltura();
			}

			if (pessoa.getGenero() == 'M') {
				contMasc++;
			}

			if (pessoa.getAltura() > maiorAltura) {
				maiorAltura = pessoa.getAltura();
			}
			if (pessoa.getAltura() < menorAltura) {
				menorAltura = pessoa.getAltura();
			}
		}
		mediaAlturaPopulacao = formataValor(mediaAlturaPopulacao / qtdPessoas);
		mediaAlturaFeminino = formataValor(mediaAlturaFeminino / qtdPessoas);
		parcelaMasculina = formataValor(contMasc * 0.10);
	}

}

class Pessoa {
	public Double altura;
	public char genero;

	public Pessoa() {
		super();
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char c) {
		this.genero = c;
	}

	@Override
	public String toString() {
		return "Pessoa [altura=" + altura + ", genero=" + genero + "]";
	}
}
