package br.com.admin.residencia.model;

public class CategoriaDespesa {

	private Integer id;
	private String nome;
	private String descricao;
	private String sigla;
	
	public CategoriaDespesa() {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "CategoriaDespesa [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", sigla=" + sigla + "]";
	}

}
