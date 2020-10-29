package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

public class Circulo {

	private Double area;
	private Double raio;
	private Double pi;
	private Double diametro;
	private Double circunferencia;

	public Circulo() {
		super();
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
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

	public Double getDiametro() {
		return diametro;
	}

	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}

	public Double getCircunferencia() {
		return circunferencia;
	}

	public void setCircunferencia(Double circunferencia) {
		this.circunferencia = circunferencia;
	}

	@Override
	public String toString() {
		return "Circulo [area=" + area + ", raio=" + raio + ", pi=" + pi + ", diametro=" + diametro
				+ ", circunferencia=" + circunferencia + "]";
	}

}
