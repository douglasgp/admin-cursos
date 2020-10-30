package br.com.admin.fatec.ilp007.listaOrientacaoObjeto;

public class CalculaFerias {
	
	public Funcionario funcionario;
	public Integer faltas;
	public String msg;
	
	public void reset() {
		this.funcionario = new Funcionario();
	}
	
	public void calculaFaltas() {
		if (this.faltas <= 5) {
			this.msg = "30 dias";
		} else if (this.faltas >= 6 && this.faltas <= 14) {
			this.msg = "24 dias";
		} else if (this.faltas >= 15 && this.faltas <= 23) {
			this.msg = "18 dias";
		} else if (this.faltas >= 24 && this.faltas <= 32) {
			this.msg = "12 dias";
		} else {
			this.msg = "0 dias. Você não tem direito à férias.";
		}
	}
	
	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
