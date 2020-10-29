package br.com.admin.residencia.mb;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import com.github.adminfaces.showcase.jdbc.FabricaConexao;

import br.com.admin.residencia.dao.StatusContabilDAO;
import br.com.admin.residencia.model.StatusContabil;

@ManagedBean
@SessionScoped
public class StatusContabilMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private StatusContabil status;
	private List<StatusContabil> listaStatus;

	private StatusContabilDAO scDAO = new StatusContabilDAO();

	private Integer codStatus;

	@PostConstruct
	public void init() {
		this.listaStatus = new ArrayList<StatusContabil>();
		reset();
		listarStatusContabil();
	}

	public void listarStatusContabil() {
		this.listaStatus = scDAO.listaStatusContabil();
	}

	public void recebeStatusContabil(StatusContabil sc) {
		this.status = new StatusContabil();
		this.status = sc;
		this.codStatus = this.status.getCodContabil();
	}

	public void salvaStatusContabil() {
		System.out.println("Salva status");
		this.scDAO.salvaStatusContabilDAO(this.status);
		if (this.status.getCodContabil() == null) {
			Messages.create("SUCESSO!")
					.detail("Status Contabail [ " + this.status.getNomeContabil() + " ] registrada com sucesso!").add();
		} else {
			Messages.create("SUCESSO!")
					.detail("Status Contabail [ " + this.status.getNomeContabil() + " ] alterada com sucesso!").add();
		}
		reset();
		atualizaBanco();
	}

	public void removeStatusContabil() {
		int id = this.scDAO.removeStatusContabilDAO(this.status.getCodContabil());
		if (id == 1) {
			Messages.create("SUCESSO!").warn()
					.detail("Status Pagamento EXCLUÍDA com sucesso!").add();
		} else {
			Messages.create("ERRO!").warn()
					.detail("Não foi possível EXCLUIR Status de Pagamento").add();
		}
		atualizaBanco();
	}

	public void atualizaBanco() {
		FabricaConexao.CloseConnection();
		reset();
		listarStatusContabil();
	}

	public void reset() {
		this.status = new StatusContabil();
		this.listaStatus = new ArrayList<StatusContabil>();
	}

	public StatusContabil getStatus() {
		return status;
	}

	public void setStatus(StatusContabil status) {
		this.status = status;
	}

	public List<StatusContabil> getListaStatus() {
		return listaStatus;
	}

	public void setListaStatus(List<StatusContabil> listaStatus) {
		this.listaStatus = listaStatus;
	}

	public StatusContabilDAO getScDAO() {
		return scDAO;
	}

	public void setScDAO(StatusContabilDAO scDAO) {
		this.scDAO = scDAO;
	}

	public Integer getCodStatus() {
		return codStatus;
	}

	public void setCodStatus(Integer codStatus) {
		this.codStatus = codStatus;
	}

}
