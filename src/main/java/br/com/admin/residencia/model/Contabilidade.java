package br.com.admin.residencia.model;

import java.util.Date;

public class Contabilidade {

	private Integer id;
	private String nome;
	private Double valor;
	private String descricao;
	private Integer idCategoriaDespesa;
	private Date data;
	private StatusContabil statusContabil;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Contabilidade() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getIdCategoriaDespesa() {
		return idCategoriaDespesa;
	}

	public void setIdCategoriaDespesa(Integer idCategoriaDespesa) {
		this.idCategoriaDespesa = idCategoriaDespesa;
	}

	public StatusContabil getStatusContabil() {
		return statusContabil;
	}

	public void setStatusContabil(StatusContabil statusContabil) {
		this.statusContabil = statusContabil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idCategoriaDespesa == null) ? 0 : idCategoriaDespesa.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((statusContabil == null) ? 0 : statusContabil.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contabilidade other = (Contabilidade) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idCategoriaDespesa == null) {
			if (other.idCategoriaDespesa != null)
				return false;
		} else if (!idCategoriaDespesa.equals(other.idCategoriaDespesa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (statusContabil == null) {
			if (other.statusContabil != null)
				return false;
		} else if (!statusContabil.equals(other.statusContabil))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Contabilidade [id=" + id + ", nome=" + nome + ", valor=" + valor + ", descricao=" + descricao
				+ ", idCategoriaDespesa=" + idCategoriaDespesa + ", data=" + data + ", statusContabil=" + statusContabil
				+ "]";
	}

}
