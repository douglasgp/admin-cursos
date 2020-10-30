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
import br.com.admin.residencia.model.ClasseContabil;
import br.com.admin.residencia.model.ClasseContabil;

public class ClasseContabilDAO {

	private static Connection con;

	public List<ClasseContabil> listaClassContabil() {
		try {
			Connection con = ConectaBDResidencia.getConResidencia();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM classe_despesa");
			ResultSet rs = stmt.executeQuery();
			List<ClasseContabil> listaClassContabil = new ArrayList<ClasseContabil>();

			while (rs.next()) {
				ClasseContabil classeContabil = new ClasseContabil();
				classeContabil.setIdClasseContabil(rs.getInt("cod_classe"));
				classeContabil.setValorClasseContabil(rs.getInt("valor_classe"));
				classeContabil.setDescClasseContabil(rs.getString("desc_classe"));
				listaClassContabil.add(classeContabil);
			}
			return listaClassContabil;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/* NÃO FINALIZADO */
	public void salvaClassContabilDAO(ClasseContabil cc) {
		Connection con = ConectaBDResidencia.getConResidencia();
		try {
			PreparedStatement stmt;
			if(cc.getIdClasseContabil() == null) {
				stmt = con.prepareStatement("INSERT INTO classe_despesa (valor_classe, desc_classe) VALUES (?,?)");
			} else {
				stmt = con.prepareStatement("UPDATE classe_despesa SET valor_classe=?, desc_classe=? WHERE cod_classe=?");
				stmt.setInt(3, cc.getIdClasseContabil());
			}
			stmt.setInt(1, cc.getValorClasseContabil());
			stmt.setString(2, cc.getDescClasseContabil().toUpperCase());
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

	/* NÃO FINALIZADO */
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
