package br.com.admin.cursos.constantes;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public enum CATEGORIAUSUARIO {
	
	FUNCIONARIO("Funcionario"),
	PROFESSOR("Professor"),
	ALUNO("Aluno"),
	OUTROS("Outros");
	
	private String valorEnum;

	private CATEGORIAUSUARIO(String valorEnum) {
		this.valorEnum = valorEnum;
	}
	
	public String getValor() {
		return valorEnum;
	}
	
	public static List<SelectItem> getCatUsu() {
		List<SelectItem> listaCategorias = new ArrayList<>();
		
		for (CATEGORIAUSUARIO valor : values()) {
			listaCategorias.add(new SelectItem(valor.getValor()));
		}
		return listaCategorias;
	}
	
}
