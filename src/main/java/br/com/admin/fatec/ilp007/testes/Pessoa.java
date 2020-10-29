package br.com.admin.fatec.ilp007.testes;

public class Pessoa {

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
