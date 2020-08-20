package br.com.admin.cursos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.adminfaces.showcase.jdbc.FabricaConexao;

import br.com.admin.cursos.model.CategoriaUsuario;

public class CategoriaUsuarioDAO {

	public void salvarCatUsuDAO(CategoriaUsuario cu) {
		Connection con = FabricaConexao.getConEscola();

		try {
			PreparedStatement stmt;
			if (cu.getCodigoCat() == null) {
				stmt = con.prepareStatement("INSERT INTO categoria_usuario(nome_cat_usu, desc_cat_usu) VALUES(?,?)");
			} else {
				stmt = con.prepareStatement(
						"UPDATE categoria_usuario SET nome_cat_usu=?, desc_cat_usu=? WHERE cod_cat_usu=?");
				stmt.setInt(3, cu.getCodigoCat());
			}
			stmt.setString(1, cu.getNomeCat());
			stmt.setString(2, cu.getDescricaoCat());
			stmt.execute();
			FabricaConexao.CloseConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<CategoriaUsuario> listaCategoriaUsu() {
		try {
			Connection con = FabricaConexao.getConEscola();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM categoria_usuario");
			ResultSet rs = stmt.executeQuery();
			List<CategoriaUsuario> listaCat = new ArrayList<CategoriaUsuario>();

			while (rs.next()) {
				CategoriaUsuario catUsu = new CategoriaUsuario();
				catUsu.setCodigoCat(rs.getInt("cod_cat_usu"));
				catUsu.setNomeCat(rs.getString("nome_cat_usu"));
				catUsu.setDescricaoCat(rs.getString("desc_cat_usu"));
				listaCat.add(catUsu);
			}
			return listaCat;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int removeCategoria(Integer codCat) {
		int status = 0;
		try {
			Connection con = FabricaConexao.getConEscola();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM categoria_usuario WHERE cod_cat_usu=" + codCat);
			status = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
