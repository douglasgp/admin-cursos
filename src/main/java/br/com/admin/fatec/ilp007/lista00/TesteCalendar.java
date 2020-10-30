package br.com.admin.fatec.ilp007.lista00;

import java.util.Calendar;

public class TesteCalendar {
	
	public static void main(String[] args) {
		Integer ano = 1990;
		Calendar c = Calendar.getInstance();
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		a.set(Calendar.YEAR, ano);
		
		System.out.println("Data/Hora atual: " + c.getTime());
		System.out.println("Ano: " + c.get(Calendar.YEAR));
		System.out.println("Teste: " + a.get(Calendar.YEAR));
		
		b.toInstant();
		System.out.println(b.get(Calendar.DATE));
		
	}
}
