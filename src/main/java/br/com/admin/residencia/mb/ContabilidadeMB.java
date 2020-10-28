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
import br.com.admin.residencia.model.CategoriaDespesa;
import br.com.admin.residencia.model.Contabilidade;

@ManagedBean
@SessionScoped
public class ContabilidadeMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Contabilidade contabilidade;
	private List<Contabilidade> listaContabilidade;
	private DespesaDAO despDao = new DespesaDAO();

	private CategoriaDespesa catDesp = new CategoriaDespesa();
	private CategoriaDespesaDAO catDespDao = new CategoriaDespesaDAO();
	private List<CategoriaDespesa> listCategoriasDesp = catDespDao.listaCategoriaDespesa();
	private List<SelectItem> itemsCatDesp = new ArrayList<SelectItem>();
	private SelectItem editaCatDesp = new SelectItem();

	private boolean editaContabil = false;
	private String dataContabil;
	private Date dateContabil;

	@PostConstruct
	public void init() {
		this.listaContabilidade = new ArrayList<Contabilidade>();
// 		this.listCategoriasDesp = new ArrayList<CategoriaDespesa>();
		reset();
		listar();

	}

	public void reset() {
		System.out.println("Resetando ...");
		this.contabilidade = new Contabilidade();
		this.catDesp = new CategoriaDespesa();
		this.dataContabil = null;
	}

	public void listar() {
		System.out.println("Listando ...");
		this.listaContabilidade = despDao.listaDespesa();
		this.listCategoriasDesp = catDespDao.listaCategoriaDespesa();
		for (CategoriaDespesa itemCatDesp : listCategoriasDesp) {
			itemsCatDesp.add(new SelectItem(itemCatDesp.getNome()));
		}
	}

	public void salvaContabilidade() throws ParseException {
		boolean status = false;
		// pesquisaIdCategoria();
		this.contabilidade.setIdCategoriaDespesa(this.catDesp.getId());
		// converteDate();
		System.out.println("Contabilidade: " + this.contabilidade.toString());
		status = this.despDao.salvaContabilidadeDAO(this.contabilidade);
		if (this.contabilidade.getId() == null) {
			Messages.create("SUCESSO!").detail("Despesa [ " + this.contabilidade.getNome() + " ] registrada com sucesso!").add();
		} else {
			Messages.create("SUCESSO!").detail("Despesa [ " + this.contabilidade.getNome() + " ] alterada com sucesso!").add();
		}
		System.out.println(status);

		reset();
		atualizaBanco();
	}

	public void pesquisaIdCategoria() {
		for (CategoriaDespesa cd : listCategoriasDesp) {
			if (cd.getNome().equals(this.catDesp.getNome())) {
				this.catDesp = cd;
				// this.contabilidade.setIdCategoriaDespesa(cd.getId());
				break;
			}
		}
	}

	public void recuperaCategoria() {
		for (SelectItem si : itemsCatDesp) {
			if (si.getLabel().equals(this.catDesp.getNome())) {
				this.editaCatDesp = si;
				System.out.println("SI Edita Categoria: " + this.editaCatDesp.getLabel());
			}
		}
	}

	/*
	 * Pesquisa por ID e atribui à variável catDesp (SelectItem) para exibir em
	 * componente selectOneMenu
	 */
	public void editaContabilidade(Contabilidade c) throws ParseException {

		this.contabilidade = c;
		this.editaContabil = true;

		for (CategoriaDespesa cd : listCategoriasDesp) {
			if (cd.getId() == this.contabilidade.getIdCategoriaDespesa()) {
				this.catDesp = cd;
				// converteDate();
			}
		}
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

	public void atualizaBanco() throws ParseException {
		// this.contabilidade.setData(null);
		FabricaConexao.CloseConnection();
		reset();
		listar();
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

}
