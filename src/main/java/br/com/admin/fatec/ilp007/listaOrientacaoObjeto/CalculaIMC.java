package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

public class CalculaIMC {

	public Pessoa pessoa = new Pessoa();
	public double alturaP;
	public double pesoP;
	public double imc;
	public String tipoIMC;

	public void calculaImc() {
		this.imc = this.pessoa.getPeso() / Math.pow(this.pessoa.getAltura(), 2);
		this.tipoIMC = retornaCategoriaImc(this.imc);
	}

	public static String retornaCategoriaImc(Double n) {
		String tipo = null;
		if (n < 18.5) {
			tipo = "Peso baixo";
		} else if (n >= 18.5 && n <= 24.9) {
			tipo = "Peso NORMAL";
		} else if (n >= 25.0 && n <= 29.9) {
			tipo = "SOBREPESO";
		} else if (n >= 30.0 && n <= 34.9) {
			tipo = "OBESIDADE I";
		} else if (n >= 35.0 && n <= 39.9) {
			tipo = "OBESIDADE II (severa)";
		} else if (n >= 40.0) {
			tipo = "OBESIDADE III (mórbida)";
		}

		return tipo;
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

	public double getAlturaP() {
		return alturaP;
	}

	public void setAlturaP(double alturaP) {
		this.alturaP = alturaP;
	}

	public double getPesoP() {
		return pesoP;
	}

	public void setPesoP(double pesoP) {
		this.pesoP = pesoP;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public String getTipoIMC() {
		return tipoIMC;
	}

	public void setTipoIMC(String tipoIMC) {
		this.tipoIMC = tipoIMC;
	}

}
