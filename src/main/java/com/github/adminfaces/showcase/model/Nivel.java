package com.github.adminfaces.showcase.model;

public class Nivel {

	private Integer codNivel;
	private String nomeNivel;
	private String descNivel;

	public Nivel() {
		super();
	}

	public Nivel(Integer codNivel, String nomeNivel, String descNivel) {
		super();
		this.codNivel = codNivel;
		this.nomeNivel = nomeNivel;
		this.descNivel = descNivel;
	}

	public Integer getCodNivel() {
		return codNivel;
	}

	public void setCodNivel(Integer codNivel) {
		this.codNivel = codNivel;
	}

	public String getNomeNivel() {
		return nomeNivel;
	}

	public void setNomeNivel(String nomeNivel) {
		this.nomeNivel = nomeNivel;
	}

	public String getDescNivel() {
		return descNivel;
	}

	public void setDescNivel(String descNivel) {
		this.descNivel = descNivel;
	}

}
