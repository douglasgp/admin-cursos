package br.com.admin.residencia.mb;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.omnifaces.util.Messages;

import com.github.adminfaces.showcase.jdbc.FabricaConexao;

import br.com.admin.residencia.dao.CategoriaDespesaDAO;
import br.com.admin.residencia.dao.DespesaDAO;
import br.com.admin.residencia.dao.StatusContabilDAO;
import br.com.admin.residencia.model.CategoriaDespesa;
import br.com.admin.residencia.model.Contabilidade;
import br.com.admin.residencia.model.StatusContabil;

@ManagedBean
@SessionScoped
public class ContabilidadeMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Contabilidade contabilidade;
	private StatusContabil statusContabil;
	private CategoriaDespesa catDesp = new CategoriaDespesa();

	private DespesaDAO despDao = new DespesaDAO();
	private CategoriaDespesaDAO catDespDao = new CategoriaDespesaDAO();
	private StatusContabilDAO statusDao = new StatusContabilDAO();

	private List<CategoriaDespesa> listCategoriasDesp = catDespDao.listaCategoriaDespesa();
	private List<StatusContabil> listaStatusContabil = statusDao.listaStatusContabil();
	private List<Contabilidade> listaContabilidade;
	private List<SelectItem> itemsCatDesp = new ArrayList<SelectItem>();
	private List<SelectItem> itensStatusContabil = new ArrayList<SelectItem>();

	private SelectItem editaCatDesp = new SelectItem();

	private boolean editaContabil = false;
	private String dataContabil;
	private Date dateContabil;

	@PostConstruct
	public void init() {

// 		this.listCategoriasDesp = new ArrayList<CategoriaDespesa>();
		this.listaContabilidade = new ArrayList<Contabilidade>();
		listar();

	}

	/*
	 * public void reset() { System.out.println("Resetando ..."); this.contabilidade
	 * = new Contabilidade(); this.catDesp = new CategoriaDespesa();
	 * this.dataContabil = null; this.statusContabil = new StatusContabil();
	 * this.listaContabilidade = despDao.listaDespesa(); this.editaContabil = false;
	 * }
	 */

	public void listar() {
		System.out.println("Listando ...");
		this.listaContabilidade = despDao.listaDespesa();
		this.listCategoriasDesp = catDespDao.listaCategoriaDespesa();
		this.listaStatusContabil = statusDao.listaStatusContabil();
	}

	/*
	 * Método para evitar que as listas que contenha componente SelectItem sejam
	 * recarregadas com itens duplicados ao realizar uma nova requisição na mudança
	 * de página.
	 */
	public void listaSelectItem() {
		this.itemsCatDesp = new ArrayList<SelectItem>();
		this.itensStatusContabil = new ArrayList<SelectItem>();

		for (CategoriaDespesa itemCatDesp : listCategoriasDesp) {
			itemsCatDesp.add(new SelectItem(itemCatDesp.getNome()));
		}
		for (StatusContabil statusContabil : listaStatusContabil) {
			itensStatusContabil.add(new SelectItem(statusContabil.getNomeContabil()));
		}
	}

	public void salvaContabilidade() throws Exception {
		boolean status = false;
		// pesquisaIdCategoria();
		this.contabilidade.setIdCategoriaDespesa(this.catDesp.getId());
		this.contabilidade.setIdStatusContabil(this.statusContabil.getCodContabil());

		System.out.println("Status Contabil: " + this.statusContabil.toString());
		System.out.println("Contabilidade: " + this.contabilidade.toString());

		status = this.despDao.salvaContabilidadeDAO(this.contabilidade);
		System.out.println("SALVO: " + status);
		// dashboardContabil();
		
		if (this.contabilidade.getId() == null) {
			Messages.create("SUCESSO!")
					.detail("Despesa [ " + this.contabilidade.getNome() + " ] registrada com sucesso!").add();
		} else {
			Messages.create("SUCESSO!").detail("Despesa [ " + this.contabilidade.getNome() + " ] alterada com sucesso!")
					.add();
		}
		 
	}
	

	/*
	 * public void pesquisaIdCategoria() { for (CategoriaDespesa cd :
	 * listCategoriasDesp) { if (cd.getNome().equals(this.catDesp.getNome())) {
	 * System.out.println("CatDesp atual: " + this.catDesp.toString()); } } }
	 */

	public void recuperaCategoria() {
		this.listCategoriasDesp = catDespDao.listaCategoriaDespesa();
		for (CategoriaDespesa cd : listCategoriasDesp) {
			if (this.catDesp.getNome().equals(cd.getNome())) {
				this.catDesp = cd;
				System.out.println("get Categoria: " + this.catDesp.toString());
				break;
			}
		}
	}

	public void recuperaStatusPagamento() {
		this.listaStatusContabil = statusDao.listaStatusContabil();
		for (StatusContabil sc : listaStatusContabil) {
			if (this.statusContabil.getNomeContabil().equals(sc.getNomeContabil())) {
				this.statusContabil = sc;
				System.out.println("get Status: " + this.statusContabil.toString());
				break;
			}
		}
	}

	/*
	 * Pesquisa por ID e atribui à variável catDesp (SelectItem) para exibir em
	 * componente selectOneMenu
	 */
	public void editaContabilidade(Contabilidade c) {
		this.contabilidade = new Contabilidade();
		this.contabilidade = c;
		this.editaContabil = true;

		for (CategoriaDespesa cd : listCategoriasDesp) {
			if (cd.getId() == this.contabilidade.getIdCategoriaDespesa()) {
				this.catDesp = cd;
				// converteDate();
			}
		}
		for (StatusContabil sc : listaStatusContabil) {
			if (sc.getCodContabil() == this.contabilidade.getIdStatusContabil()) {
				this.statusContabil = sc;
			}
		}
		System.out.println("Edita Contabil: " + this.contabilidade.toString());
	}

	public void converteDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if (this.editaContabil) {
			System.out.println("Data editada: " + this.dataContabil);
		} else {
			System.out.println("Data editada: " + this.dataContabil);
		}

		this.editaContabil = false;

		// this.dataContabil = this.contabilidade.getData();
		// System.out.println("Data: " + this.contabilidade.getData());

		/*
		 * if (this.contabilidade.getId() != null) { DateFormat sdf = new
		 * SimpleDateFormat("dd/MM/yyyy"); //
		 * this.contabilidade.setData(sdf.parse(this.dataContabil)); } else { DateFormat
		 * sdf = new SimpleDateFormat("dd/MM/yy"); //
		 * this.contabilidade.setData(sdf.format(this.dateContabil)); this.dataContabil
		 * = sdf.format(this.dateContabil); System.out.println("Data contabil: " +
		 * this.dataContabil); System.out.println("Date contabil: " +
		 * this.contabilidade.getData()); }
		 */

	}

	public void atualizaBanco() {
		FabricaConexao.CloseConnection();
		// reset();
	}

	public String formularioContabil(Contabilidade c) {
		this.contabilidade = new Contabilidade();
		editaContabilidade(c);
		listaSelectItem();
		return "formulario-despesa";
	}

	public String dashboardContabil() {
		System.out.println("Return dashboard contabil");
		atualizaBanco();
		return "financeiro";
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}

	public DespesaDAO getDespDao() {
		return despDao;
	}

	public void setDespDao(DespesaDAO despDao) {
		this.despDao = despDao;
	}

	public List<Contabilidade> getListaContabilidade() {
		return listaContabilidade;
	}

	public void setListaContabilidade(List<Contabilidade> listaContabilidade) {
		this.listaContabilidade = listaContabilidade;
	}

	public CategoriaDespesaDAO getCatDespDao() {
		return catDespDao;
	}

	public void setCatDespDao(CategoriaDespesaDAO catDespDao) {
		this.catDespDao = catDespDao;
	}

	public List<CategoriaDespesa> getListCategoriasDesp() {
		return listCategoriasDesp;
	}

	public void setListCategoriasDesp(List<CategoriaDespesa> listCategoriasDesp) {
		this.listCategoriasDesp = listCategoriasDesp;
	}

	public CategoriaDespesa getCatDesp() {
		return catDesp;
	}

	public void setCatDesp(CategoriaDespesa catDesp) {
		this.catDesp = catDesp;
	}

	public List<SelectItem> getItemsCatDesp() {
		return itemsCatDesp;
	}

	public void setItemsCatDesp(List<SelectItem> itemsCatDesp) {
		this.itemsCatDesp = itemsCatDesp;
	}

	public String getDataContabil() {
		return dataContabil;
	}

	public void setDataContabil(String dataContabil) {
		this.dataContabil = dataContabil;
	}

	public Date getDateContabil() {
		return (Date) dateContabil;
	}

	public void setDateContabil(Date dateContabil) {
		this.dateContabil = dateContabil;
	}

	public SelectItem getEditaCatDesp() {
		return editaCatDesp;
	}

	public void setEditaCatDesp(SelectItem editaCatDesp) {
		this.editaCatDesp = editaCatDesp;
	}

	public boolean isEditaContabil() {
		return editaContabil;
	}

	public void setEditaContabil(boolean editaContabil) {
		this.editaContabil = editaContabil;
	}

	public StatusContabil getStatusContabil() {
		return statusContabil;
	}

	public void setStatusContabil(StatusContabil statusContabil) {
		this.statusContabil = statusContabil;
	}

	public StatusContabilDAO getStatusDao() {
		return statusDao;
	}

	public void setStatusDao(StatusContabilDAO statusDao) {
		this.statusDao = statusDao;
	}

	public List<StatusContabil> getListaStatusContabil() {
		return listaStatusContabil;
	}

	public void setListaStatusContabil(List<StatusContabil> listaStatusContabil) {
		this.listaStatusContabil = listaStatusContabil;
	}

	public List<SelectItem> getItensStatusContabil() {
		return itensStatusContabil;
	}

	public void setItensStatusContabil(List<SelectItem> itensStatusContabil) {
		this.itensStatusContabil = itensStatusContabil;
	}

}
