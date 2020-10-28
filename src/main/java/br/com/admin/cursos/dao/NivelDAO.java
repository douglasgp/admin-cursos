package br.com.admin.cursos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.adminfaces.showcase.jdbc.FabricaConexao;

import br.com.admin.cursos.model.Nivel;

public class NivelDAO {
	
	public List<Nivel> listarNivel(){
		Connection con = FabricaConexao.getConEscola();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM nivel");
			ResultSet rs = stmt.executeQuery();
			List<Nivel> listaNivel = new ArrayList<Nivel>();
			
			while (rs.next()) {
				Nivel nivel = new Nivel();
				nivel.setCodNivel(rs.getInt("cod_nivel"));
				nivel.setNomeNivel(rs.getString("nome_nivel"));
				nivel.setDescNivel(rs.getString("desc_nivel"));
				listaNivel.add(nivel);
			}
			return listaNivel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void salvaNivelDao(Nivel nivel) {
		Connection con = FabricaConexao.getConEscola();

		try {
			PreparedStatement stmt;
			if(nivel.getCodNivel() == null) {
				stmt = con.prepareStatement("INSERT INTO nivel(nome_nivel, desc_nivel) VALUES (?,?)");
			} else {
				stmt = con.prepareStatement("UPDATE nivel SET nome_nivel=?, desc_nivel=? WHERE cod_nivel=?");
				stmt.setInt(3, nivel.getCodNivel());
			}
			stmt.setString(1, nivel.getNomeNivel());
			stmt.setString(2, nivel.getDescNivel());
			stmt.execute();
			
			FabricaConexao.CloseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
