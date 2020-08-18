package br.com.admin.cursos.mb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.github.adminfaces.showcase.jdbc.ConnectionFactory;

import br.com.admin.cursos.model.CategoriaUsuario;
import br.com.admin.cursos.model.Nivel;

@ManagedBean
@SessionScoped
public class NivelMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public List<Nivel> getNiveis() throws ClassNotFoundException, SQLException {
		new ConnectionFactory();
		Connection connect = ConnectionFactory.getConCursos();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}
		List<Nivel> niveis = new ArrayList<Nivel>();
		PreparedStatement pstmt = connect.prepareStatement("select * from nivel");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Nivel nivel = new Nivel();
			nivel.setCodNivel(rs.getInt("cod_nivel"));
			nivel.setNomeNivel(rs.getString("nome_nivel"));
			nivel.setDescNivel(rs.getString("desc_nivel"));

			niveis.add(nivel);
		}
		rs.close();
		pstmt.close();
		connect.close();
		return niveis;
	}

	public String salvaCatUsu(CategoriaUsuario catUsu) {
		int result = 0;

		try {
			new ConnectionFactory();
			Connection con = ConnectionFactory.getConCursos();
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO nivel(nome_cat_usu, desc_cat_usu) VALUES(?,?)");
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


}
