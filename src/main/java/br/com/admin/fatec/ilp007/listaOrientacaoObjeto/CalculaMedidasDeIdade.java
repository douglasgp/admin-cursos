package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CalculaMedidasDeIdade {

	public Pessoa pessoa;
	public int anoIdade;
	public int anoAtual;
	public int mes;
	public int dia;
	public int hora;
	public int minutos;
	public int segundos;

	public void converteAnosMinutos() {
		pessoa.setIdade(anoAtual - anoIdade);
		mes = pessoa.getIdade() * 12;
		dia = mes * 30;
		hora = dia * 24;
		minutos = hora * 60;
		segundos = minutos * 60;
	}

	public void reset() {
		this.pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getAnoIdade() {
		return anoIdade;
	}

	public void setAnoIdade(int anoIdade) {
		this.anoIdade = anoIdade;
	}

	public int getAnoAtual() {
		return anoAtual;
	}

	public void setAnoAtual(int anoAtual) {
		this.anoAtual = anoAtual;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

}
