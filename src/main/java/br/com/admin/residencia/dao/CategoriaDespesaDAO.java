package br.com.admin.residencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.adminfaces.showcase.jdbc.ConectaBDResidencia;
import com.github.adminfaces.showcase.jdbc.FabricaConexao;

import br.com.admin.cursos.model.CategoriaUsuario;
import br.com.admin.residencia.model.CategoriaDespesa;

public class CategoriaDespesaDAO {

	private static Connection con;

	public List<CategoriaDespesa> listaCategoriaDespesa() {
		try {
			Connection con = ConectaBDResidencia.getConResidencia();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM categoria_despesa");
			ResultSet rs = stmt.executeQuery();
			List<CategoriaDespesa> listaCatDesp = new ArrayList<CategoriaDespesa>();

			while (rs.next()) {
				CategoriaDespesa catDesp = new CategoriaDespesa();
				catDesp.setId(rs.getInt("id_categoria"));
				catDesp.setNome(rs.getString("nome_categoria"));
				catDesp.setDescricao(rs.getString("desc_categoria"));
				catDesp.setSigla(rs.getString("sigla_categoria"));
				listaCatDesp.add(catDesp);
			}
			return listaCatDesp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void salvaCatDespDAO(CategoriaDespesa cd) {
		Connection con = ConectaBDResidencia.getConResidencia();
		try {
			PreparedStatement stmt;
			if(cd.getId() == null) {
				stmt = con.prepareStatement("INSERT INTO categoria_despesa (nome_categoria, desc_categoria, sigla_categoria) VALUES(?,?,?)");
			} else {
				stmt = con.prepareStatement("UPDATE categoria_despesa SET nome_categoria=?, desc_categoria=?, sigla_categoria=? WHERE id_categoria=?");
				stmt.setInt(4, cd.getId());
			}
			stmt.setString(1, cd.getNome());
			stmt.setString(2, cd.getDescricao());
			stmt.setString(3, cd.getSigla());
			stmt.execute();
			ConectaBDResidencia.CloseConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void CloseConnection() {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int removeCatDespDAO(Integer codCat) {
		int status = 0;
		try {
			Connection con = ConectaBDResidencia.getConResidencia();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM categoria_despesa WHERE id_categoria = " + codCat);
			status = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
