package br.com.admin.residencia.model;

public class ClasseContabil {

	private Integer idClasseContabil;
	private Integer valorClasseContabil;
	private String descClasseContabil;

	public ClasseContabil() {
		super();
	}

	public Integer getIdClasseContabil() {
		return idClasseContabil;
	}

	public void setIdClasseContabil(Integer idClasseContabil) {
		this.idClasseContabil = idClasseContabil;
	}

	public Integer getValorClasseContabil() {
		return valorClasseContabil;
	}

	public void setValorClasseContabil(Integer valorClasseContabil) {
		this.valorClasseContabil = valorClasseContabil;
	}

	public String getDescClasseContabil() {
		return descClasseContabil;
	}

	public void setDescClasseContabil(String descClasseContabil) {
		this.descClasseContabil = descClasseContabil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descClasseContabil == null) ? 0 : descClasseContabil.hashCode());
		result = prime * result + ((idClasseContabil == null) ? 0 : idClasseContabil.hashCode());
		result = prime * result + ((valorClasseContabil == null) ? 0 : valorClasseContabil.hashCode());
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
		ClasseContabil other = (ClasseContabil) obj;
		if (descClasseContabil == null) {
			if (other.descClasseContabil != null)
				return false;
		} else if (!descClasseContabil.equals(other.descClasseContabil))
			return false;
		if (idClasseContabil == null) {
			if (other.idClasseContabil != null)
				return false;
		} else if (!idClasseContabil.equals(other.idClasseContabil))
			return false;
		if (valorClasseContabil == null) {
			if (other.valorClasseContabil != null)
				return false;
		} else if (!valorClasseContabil.equals(other.valorClasseContabil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClasseContabil [idClasseContabil=" + idClasseContabil + ", valorClasseContabil=" + valorClasseContabil
				+ ", descClasseContabil=" + descClasseContabil + "]";
	}

}
