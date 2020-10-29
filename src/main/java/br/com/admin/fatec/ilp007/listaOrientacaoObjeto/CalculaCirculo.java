package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CalculaCirculo {
	public Circulo circulo;

	public Double pi = 3.14159265359;

	public void calcDiametro() {
		this.circulo.setDiametro(this.circulo.getRaio() * 2);
		calcCircunferencia();
	}

	public void calcCircunferencia() {
		this.circulo.setCircunferencia(2 * pi * this.circulo.getRaio());
		calcArea();
	}

	public void calcArea() {
		this.circulo.setArea(pi * (Math.pow(this.circulo.getRaio(), 2)));
	}

	public void reset() {
		this.circulo = new Circulo();
	}

	public Circulo getCirculo() {
		return circulo;
	}

	public void setCirculo(Circulo circulo) {
		this.circulo = circulo;
	}

	public Double getPi() {
		return pi;
	}

	public void setPi(Double pi) {
		this.pi = pi;
	}

}
