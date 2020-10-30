package br.com.admin.fatec.ilp007.aula11;

public class Util {

	// Métodos;
	public static void exibirTriangulo() {
		System.out.println(" *");
		System.out.println(" ***");
		System.out.println("*****");
	}

	public static String nomeMes(int m) {
		// Months of the year:
		String nome;
		switch (m) {
		case 1:
			nome = "January";
			break;
		case 2:
			nome = "February";
			break;
		case 3:
			nome = "March";
			break;
		case 4:
			nome = "April";
			break;
		case 5:
			nome = "May";
			break;
		case 6:
			nome = "June";
			break;
		case 7:
			nome = "July";
			break;
		case 8:
			nome = "August";
			break;
		case 9:
			nome = "september";
			break;
		case 10:
			nome = "October";
			break;
		case 11:
			nome = "November";
			break;
		case 12:
			nome = "December";
			break;
		default:
			nome = "";
		}
		return nome;
	}

	public static String nomeMes2(byte dia) {
		// Months of the year:
		String nome;
		if (dia == 1)
			nome = "January";
		else if (dia == 2)
			nome = "February";
		else if (dia == 3)
			nome = "March";
		else if (dia == 4)
			nome = "April";
		else if (dia == 5)
			nome = "May";
		else if (dia == 6)
			nome = "June";
		else if (dia == 7)
			nome = "July";
		else if (dia == 8)
			nome = "August";
		else if (dia == 9)
			nome = "september";
		else if (dia == 10)
			nome = "October";
		else if (dia == 11)
			nome = "November";
		else if (dia == 12)
			nome = "December";
		else
			nome = "";
		return nome;
	}

	public static String mes3(byte m) {
		String mes[] = { "", "jan", "fev", "mar", "abr", "maio", "jun", "ago", "set", "out", "nov", "dez" };
		return (mes[m]);
	}

	public static String mes4(byte m) {
		String mes[] = { "jan", "fev", "mar", "abr", "maio", "jun", "ago", "set", "out", "nov", "dez" };
		return (mes[m - 1]);
	}

}
