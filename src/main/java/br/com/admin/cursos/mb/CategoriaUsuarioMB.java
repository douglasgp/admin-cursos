package br.com.admin.cursos.mb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import com.github.adminfaces.showcase.jdbc.ConnectionFactory;
import com.github.adminfaces.showcase.jdbc.FabricaConexao;

import br.com.admin.cursos.dao.CategoriaUsuarioDAO;
import br.com.admin.cursos.model.CategoriaUsuario;

@ManagedBean
@SessionScoped
public class CategoriaUsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private CategoriaUsuario categUsu;
	private List<CategoriaUsuario> listaCategorias;
	private CategoriaUsuarioDAO cuDAO = new CategoriaUsuarioDAO();
	private Boolean novaCategoria;
	private boolean editaCateg;

	@PostConstruct
	public void init() {
		this.categUsu = new CategoriaUsuario();
		this.listaCategorias = new ArrayList<CategoriaUsuario>();
		this.setEditaCateg(false);
		listar();
	}

	/*
	 * public List<CategoriaUsuario> getCatUsu() throws ClassNotFoundException,
	 * SQLException { new ConnectionFactory(); Connection connect =
	 * ConnectionFactory.getConCursos(); try {
	 * Class.forName("com.mysql.cj.jdbc.Driver"); } catch (Exception ex) {
	 * System.out.println("in exec"); System.out.println(ex.getMessage()); }
	 * List<CategoriaUsuario> listaCat = new ArrayList<CategoriaUsuario>();
	 * PreparedStatement pstmt =
	 * connect.prepareStatement("select * from categoria_usuario"); ResultSet rs =
	 * pstmt.executeQuery(); while (rs.next()) { CategoriaUsuario catUsu = new
	 * CategoriaUsuario(); catUsu.setCodigoCat(rs.getInt("cod_cat_usu"));
	 * catUsu.setNomeCat(rs.getString("nome_cat_usu"));
	 * catUsu.setDescricaoCat(rs.getString("desc_cat_usu"));
	 * 
	 * listaCat.add(catUsu); } rs.close(); pstmt.close(); connect.close();
	 * 
	 * return listaCat; }
	 */

	/*
	 * public String salvaCatUsu(CategoriaUsuario catUsu) {
	 * System.out.println("Tentando salvar"); int result = 0;
	 * 
	 * try { Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
	 * ConnectionFactory.getConCursos();
	 * 
	 * PreparedStatement stmt = con
	 * .prepareStatement("INSERT INTO categoria_usuario(nome_cat_usu, desc_cat_usu) VALUES(?,?)"
	 * ); stmt.setString(1, catUsu.getNomeCat()); stmt.setString(2,
	 * catUsu.getDescricaoCat());
	 * 
	 * result = stmt.executeUpdate(); con.close();
	 * 
	 * } catch (Exception e) { System.out.println(e); } if (result != 0) {
	 * System.out.println("Registrado com sucesso!"); return
	 * "user.xhtml?faces-redirect=true"; } else {
	 * System.out.println("Falha ao registrar!"); return
	 * "create-user.xhtml?faces-redirect=true"; } }
	 */
	
	public void listar() {
		this.listaCategorias = cuDAO.listaCategoriaUsu();
		this.categUsu = new CategoriaUsuario();
	}

	public void edita(CategoriaUsuario catUsu) {
		this.categUsu = catUsu;
		System.out.println("Editar: " + this.categUsu.toString());
	}

	public void recebeCategoria(CategoriaUsuario catUsu) {
		this.setEditaCateg(false);
		for (CategoriaUsuario categoriaUsuario : listaCategorias) {
			if(catUsu.equals(categoriaUsuario)) {
				this.categUsu = catUsu;
				System.out.println("Prepara excluir categoria: " + this.categUsu.getNomeCat());
				break;
			}
		}
	}
	
	public void excluir() {
		int status = 0;
		status = cuDAO.removeCategoria(this.categUsu.getCodigoCat());

		/*
		 * for (int i = 0; i < this.listaCategorias.size(); i++) { CategoriaUsuario
		 * catUsu = this.listaCategorias.get(i); if
		 * (catUsu.getCodigoCat().equals(codCategoria)) {
		 * this.listaCategorias.remove(i); break; } }
		 */

		if (status != 0) {
			Messages.create("SUCESSO!").detail("Categoria [ " + this.categUsu.getNomeCat() + " ] removida com sucesso!")
					.add();
		} else {
			Messages.create("ERRO!")
					.detail("Não foi possível remover categoria [ " + this.categUsu.getNomeCat() + " ] !").add();
		}
		atualizaBanco();
	}

	public void atualizaBanco() {
		FabricaConexao.CloseConnection();
		this.categUsu = new CategoriaUsuario();
		listar();
	}

	/* CREATE and UPDATE */
	public void adicionaCategoria() {
		cuDAO.salvarCatUsuDAO(this.categUsu);
		if (this.categUsu.getCodigoCat() != null) {
			Messages.create("SUCESSO!").detail("Categoria " + this.categUsu.getNomeCat() + " alterado com sucesso!")
					.add();
		} else {
			Messages.create("SUCESSO!").detail("Categoria " + this.categUsu.getNomeCat() + " registrado com sucesso!")
					.add();
		}
		this.categUsu = new CategoriaUsuario();
		atualizaBanco();
	}

	public void novaCategoria() {
		this.categUsu = new CategoriaUsuario();
	}

	public CategoriaUsuario getCategoriaUsu() {
		return categUsu;
	}

	public void setCategoriaUsu(CategoriaUsuario categoriaUsu) {
		this.categUsu = categoriaUsu;
	}

	public List<CategoriaUsuario> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaUsuario> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public void limpaCampos() {
		this.categUsu = new CategoriaUsuario();
	}

	public CategoriaUsuario getCategUsu() {
		return categUsu;
	}

	public void setCategUsu(CategoriaUsuario categUsu) {
		this.categUsu = categUsu;
	}

	public Boolean getNovaCategoria() {
		return novaCategoria;
	}

	public void setNovaCategoria(Boolean novaCategoria) {
		this.novaCategoria = novaCategoria;
	}

	public boolean isEditaCateg() {
		return editaCateg;
	}

	public void setEditaCateg(boolean editaCateg) {
		this.editaCateg = editaCateg;
	}
	
	

}