package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CalculaAnosMinutos {

	public Pessoa pessoa;
	public int minutos = 60;

	public void reset() {
		this.pessoa = new Pessoa();
	}

	public void converteAnosMinutos() {
		int ano = pessoa.getIdade();
		int mes = 12;
		int dia = 30;
		int hora = 24;

		this.minutos *= (hora *= (dia *= (mes *= ano)));
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

}
