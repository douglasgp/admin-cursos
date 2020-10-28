package br.com.admin.residencia.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.admin.residencia.dao.StatusContabilDAO;
import br.com.admin.residencia.model.StatusContabil;

@ManagedBean
@SessionScoped
public class StatusContabilMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private StatusContabil status;
	private List<StatusContabil> listaStatus;

	private StatusContabilDAO scDAO = new StatusContabilDAO();

	@PostConstruct
	public void init() {
		this.listaStatus = new ArrayList<StatusContabil>();
		reset();
		listar();
	}

	public void listar() {
		this.listaStatus = scDAO.listaStatusContabil();
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

}
