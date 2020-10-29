package br.com.admin.residencia.model;

public class StatusContabil {

	private Integer codContabil;
	private String nomeContabil;
	private String descContabil;

	public StatusContabil() {
		super();
	}

	public Integer getCodContabil() {
		return codContabil;
	}

	public void setCodContabil(Integer codContabil) {
		this.codContabil = codContabil;
	}

	public String getNomeContabil() {
		return nomeContabil;
	}

	public void setNomeContabil(String nomeContabil) {
		this.nomeContabil = nomeContabil;
	}

	public String getDescContabil() {
		return descContabil;
	}

	public void setDescContabil(String descContabil) {
		this.descContabil = descContabil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codContabil == null) ? 0 : codContabil.hashCode());
		result = prime * result + ((descContabil == null) ? 0 : descContabil.hashCode());
		result = prime * result + ((nomeContabil == null) ? 0 : nomeContabil.hashCode());
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
		StatusContabil other = (StatusContabil) obj;
		if (codContabil == null) {
			if (other.codContabil != null)
				return false;
		} else if (!codContabil.equals(other.codContabil))
			return false;
		if (descContabil == null) {
			if (other.descContabil != null)
				return false;
		} else if (!descContabil.equals(other.descContabil))
			return false;
		if (nomeContabil == null) {
			if (other.nomeContabil != null)
				return false;
		} else if (!nomeContabil.equals(other.nomeContabil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StatusContabil [codContabil=" + codContabil + ", nomeContabil=" + nomeContabil + ", descContabil="
				+ descContabil + "]";
	}

}
