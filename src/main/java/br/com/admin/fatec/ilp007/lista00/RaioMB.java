package br.com.admin.fatec.ilp007.lista00;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RaioMB {

	private Double raio;
	private Double pi = 3.141592654;
	private Double resultado;

	@PostConstruct
	public void init() {
		System.out.println("Aplicação iniciada");
	}

	public void calculaRaio() {
		this.resultado = this.raio * this.pi;
		System.out.println("Resultado: " + this.resultado);
	}
	
	public void limpar() {
		System.out.println("Limpar campos");
	}

	public Double getRaio() {
		return raio;
	}

	public void setRaio(Double raio) {
		this.raio = raio;
	}

	public Double getPi() {
		return pi;
	}

	public void setPi(Double pi) {
		this.pi = pi;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

}
