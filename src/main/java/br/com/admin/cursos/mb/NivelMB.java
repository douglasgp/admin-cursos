package br.com.admin.cursos.mb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import com.github.adminfaces.showcase.jdbc.ConnectionFactory;
import com.github.adminfaces.showcase.jdbc.FabricaConexao;

import br.com.admin.cursos.dao.NivelDAO;
import br.com.admin.cursos.model.CategoriaUsuario;
import br.com.admin.cursos.model.Nivel;

@ManagedBean
@SessionScoped
public class NivelMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Nivel nivel;
	private Nivel nivelEdita;
	private List<Nivel> listaNiveis;
	private NivelDAO nivelDao;
	private boolean editaNivel;

	@PostConstruct
	public void init() {
		this.nivel = new Nivel();
		this.listaNiveis = new ArrayList<Nivel>();
		this.nivelDao = new NivelDAO();
		this.editaNivel = false;
		listarNiveis();
	}
	
	public void listarNiveis() {
		this.listaNiveis = nivelDao.listarNivel();
		this.nivel = new Nivel();
	}

	public void novoNivel() {
	}

	public void editaNivel(Nivel nEdita) {
		this.editaNivel = true;
	}

	public void salvaNivel() {
	}

	public void atualizaBanco() {
		FabricaConexao.CloseConnection();
		this.nivel = new Nivel();
		this.nivelEdita = new Nivel();
		this.editaNivel = false;
		listarNiveis();
	}
	
	public void cancelaEdicao() {
		init();
	}

	public void removeNivel(Nivel nivelRemove) {
		this.nivel = nivelRemove;
		System.out.println("Remove nivel: " + this.nivel.toString());
	}

	/*
	 * public List<Nivel> getNiveis() throws ClassNotFoundException, SQLException {
	 * new ConnectionFactory(); Connection connect =
	 * ConnectionFactory.getConCursos(); try {
	 * Class.forName("com.mysql.cj.jdbc.Driver"); } catch (Exception ex) {
	 * System.out.println("in exec"); System.out.println(ex.getMessage()); }
	 * List<Nivel> niveis = new ArrayList<Nivel>(); PreparedStatement pstmt =
	 * connect.prepareStatement("select * from nivel"); ResultSet rs =
	 * pstmt.executeQuery(); while (rs.next()) { Nivel nivel = new Nivel();
	 * nivel.setCodNivel(rs.getInt("cod_nivel"));
	 * nivel.setNomeNivel(rs.getString("nome_nivel"));
	 * nivel.setDescNivel(rs.getString("desc_nivel"));
	 * 
	 * niveis.add(nivel); } rs.close(); pstmt.close(); connect.close(); return
	 * niveis; }
	 * 
	 */

	public String salvaCatUsu(CategoriaUsuario catUsu) {
		int result = 0;

		try {
			new ConnectionFactory();
			Connection con = ConnectionFactory.getConCursos();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO nivel(nome_cat_usu, desc_cat_usu) VALUES(?,?)");
			stmt.setString(1, catUsu.getNomeCat());
			stmt.setString(2, catUsu.getDescricaoCat());

			result = stmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		if (result != 0) {
			return "user.xhtml?faces-redirect=true";
		} else {
			return "create-user.xhtml?faces-redirect=true";
		}
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public List<Nivel> getListaNiveis() {
		return listaNiveis;
	}

	public void setListaNiveis(List<Nivel> listaNiveis) {
		this.listaNiveis = listaNiveis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public NivelDAO getNivelDao() {
		return nivelDao;
	}

	public void setNivelDao(NivelDAO nivelDao) {
		this.nivelDao = nivelDao;
	}

	public Nivel getNivelEdita() {
		return nivelEdita;
	}

	public void setNivelEdita(Nivel nivelEdita) {
		this.nivelEdita = nivelEdita;
	}
	
	public boolean isEditaNivel() {
		return editaNivel;
	}

	public void setEditaNivel(boolean editaNivel) {
		this.editaNivel = editaNivel;
	}

	
}
