package br.com.admin.residencia.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import com.github.adminfaces.showcase.jdbc.ConectaBDResidencia;
import com.github.adminfaces.showcase.jdbc.FabricaConexao;

import br.com.admin.residencia.dao.CategoriaDespesaDAO;
import br.com.admin.residencia.model.CategoriaDespesa;

@ManagedBean
@SessionScoped
public class CategoriaDespesaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private CategoriaDespesa catDespesa;
	private List<CategoriaDespesa> listCatDesp;
	private CategoriaDespesaDAO cdDAO = new CategoriaDespesaDAO();

	@PostConstruct
	public void init() {
		this.catDespesa = new CategoriaDespesa();
		this.listCatDesp = new ArrayList<CategoriaDespesa>();
		listar();
	}

	public void listar() {
		this.listCatDesp = cdDAO.listaCategoriaDespesa();
		this.catDespesa = new CategoriaDespesa();
	}

	public void recebeCategoriaDespesa(CategoriaDespesa c) {
		this.catDespesa = c;
	}
	
	public void salva() {
		cdDAO.salvaCatDespDAO(this.catDespesa);
		if(this.catDespesa.getId() != null) {
			Messages.create("SUCESSO!").detail("Despesa " + this.catDespesa.getNome() + " alterada com sucesso!").add();
		} else {
			Messages.create("SUCESSO!").detail("Despesa " + this.catDespesa.getNome() + " registrada com sucesso!").add();
		}
		atualizaBanco();
	}

	public void atualizaBanco() {
		ConectaBDResidencia.CloseConnection();
		this.catDespesa = new CategoriaDespesa();
		listar();
	}

	public void removeCategoriaDespesa() {
		String categoriaRemove = this.catDespesa.getNome();
		int status = 0;
		status = cdDAO.removeCatDespDAO(this.catDespesa.getId());
		if (status != 0) {
			Messages.create("SUCESSO!").detail("Categoria [ " + categoriaRemove + " ] removida com sucesso!")
					.add();
		} else {
			Messages.create("ERRO!")
					.detail("Não foi possível remover categoria [ " + this.catDespesa.getNome() + " ] !").add();
		}
		atualizaBanco();
	}
	
	public CategoriaDespesa getCatDespesa() {
		return catDespesa;
	}

	public void setCatDespesa(CategoriaDespesa catDespesa) {
		this.catDespesa = catDespesa;
	}

	public List<CategoriaDespesa> getListCatDesp() {
		return listCatDesp;
	}

	public void setListCatDesp(List<CategoriaDespesa> listCatDesp) {
		this.listCatDesp = listCatDesp;
	}

	public CategoriaDespesaDAO getCuDAO() {
		return cdDAO;
	}

	public void setCuDAO(CategoriaDespesaDAO cuDAO) {
		this.cdDAO = cuDAO;
	}

}
