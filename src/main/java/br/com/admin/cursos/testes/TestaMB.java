package br.com.admin.cursos.testes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.admin.cursos.model.CategoriaUsuario;

@ManagedBean
@SessionScoped
public class TestaMB {

	private CategoriaUsuario categUsu;
	private List<CategoriaUsuario> listaCategorias;
	
	@PostConstruct
	public void init() {
		this.listaCategorias = new ArrayList<>();
		this.categUsu = new CategoriaUsuario();
	}
	
	public void adicionaLista() {
		this.listaCategorias.add(this.categUsu);
		this.categUsu = new CategoriaUsuario();
	}

	public CategoriaUsuario getCategUsu() {
		return categUsu;
	}

	public void setCategUsu(CategoriaUsuario categUsu) {
		this.categUsu = categUsu;
	}

	public List<CategoriaUsuario> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaUsuario> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

}
