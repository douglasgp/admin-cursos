package com.github.adminfaces.showcase.model;

public class CategoriaUsuario {

	private Integer codigoCat;
	private String nomeCat;
	private String descricaoCat;

	public CategoriaUsuario() {
		
	}
	
	public CategoriaUsuario(String nomeCat, String descricaoCat) {
		this.nomeCat = nomeCat;
		this.descricaoCat = descricaoCat;
	}

	public Integer getCodigoCat() {
		return codigoCat;
	}

	public void setCodigoCat(Integer codigoCat) {
		this.codigoCat = codigoCat;
	}

	public String getNomeCat() {
		return nomeCat;
	}

	public void setNomeCat(String nomeCat) {
		this.nomeCat = nomeCat;
	}

	public String getDescricaoCat() {
		return descricaoCat;
	}

	public void setDescricaoCat(String descricaoCat) {
		this.descricaoCat = descricaoCat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCat == null) ? 0 : codigoCat.hashCode());
		result = prime * result + ((descricaoCat == null) ? 0 : descricaoCat.hashCode());
		result = prime * result + ((nomeCat == null) ? 0 : nomeCat.hashCode());
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
		CategoriaUsuario other = (CategoriaUsuario) obj;
		if (codigoCat == null) {
			if (other.codigoCat != null)
				return false;
		} else if (!codigoCat.equals(other.codigoCat))
			return false;
		if (descricaoCat == null) {
			if (other.descricaoCat != null)
				return false;
		} else if (!descricaoCat.equals(other.descricaoCat))
			return false;
		if (nomeCat == null) {
			if (other.nomeCat != null)
				return false;
		} else if (!nomeCat.equals(other.nomeCat))
			return false;
		return true;
	}
	
	

}
