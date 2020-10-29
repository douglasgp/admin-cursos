package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CalculaAreaCirculo {

	public Circulo circulo;

	public void exibeDados() {
		System.out.println(circulo.getRaio());
	}

	public void calculaArea() {
		// reset();
		if (!circulo.getRaio().equals(null)) {
			circulo.setArea(circulo.getPi() * Math.pow(circulo.getRaio(), 2));
		} else {
			System.out.println("Necessário informar valor do [ RAIO ] ");
		}
	}

	public void reset() {
		circulo = new Circulo();
	}

	public Circulo getCirculo() {
		return circulo;
	}

	public void setCirculo(Circulo circulo) {
		this.circulo = circulo;
	}

}
