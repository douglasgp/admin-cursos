package br.com.admin.residencia.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.omnifaces.util.Messages;

import com.github.adminfaces.showcase.jdbc.FabricaConexao;

import br.com.admin.residencia.dao.ClasseContabilDAO;
import br.com.admin.residencia.model.ClasseContabil;

@ManagedBean
@RequestScoped
public class ClasseContabilMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private ClasseContabil classeCont;
	private List<ClasseContabil> listClasseContabil;
	private ClasseContabilDAO ccDAO = new ClasseContabilDAO();

	@PostConstruct
	public void init() {
		this.classeCont = new ClasseContabil();
		this.listClasseContabil = new ArrayList<ClasseContabil>();
		listar();
	}

	public void listar() {
		this.listClasseContabil = ccDAO.listaClassContabil();
		this.classeCont = new ClasseContabil();
	}

	public void salvaClassContabil() {
		// ccDAO.salvaClassContabilDAO(this.classeCont);

		if (this.classeCont.getIdClasseContabil() != null) {
			System.out.println("Editado");
			Messages.create("SUCESSO!")
					.detail("Classe de despesa " + this.classeCont.getDescClasseContabil() + " alterada com sucesso!")
					.add();
		} else {
			System.out.println("Novo");
			Messages.create("SUCESSO!")
					.detail("Classe de despesa " + this.classeCont.getDescClasseContabil() + " registrada com sucesso!")
					.add();
		}
		atualizaBanco();
	}

	public void editaClassContabil(ClasseContabil cc) {
		this.classeCont = cc;
		System.out.println("Edita CC: " + this.classeCont.getIdClasseContabil());
	}

	public void reset() {
		this.classeCont = new ClasseContabil();
	}

	public void atualizaBanco() {
		FabricaConexao.CloseConnection();
		listar();
	}

	public List<ClasseContabil> getListClasseContabil() {
		return listClasseContabil;
	}

	public void setListClasseContabil(List<ClasseContabil> listClasseContabil) {
		this.listClasseContabil = listClasseContabil;
	}

	public ClasseContabil getClasseCont() {
		return classeCont;
	}

	public void setClasseCont(ClasseContabil classeCont) {
		this.classeCont = classeCont;
	}

	public ClasseContabilDAO getCcDAO() {
		return ccDAO;
	}

	public void setCcDAO(ClasseContabilDAO ccDAO) {
		this.ccDAO = ccDAO;
	}

}
