package br.com.admin.residencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.github.adminfaces.showcase.jdbc.ConectaBDResidencia;

import br.com.admin.residencia.model.Contabilidade;

public class DespesaDAO {

	private static Connection con;
	private boolean status = false;
	public static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public List<Contabilidade> listaDespesa() {
		try {
			Connection con = ConectaBDResidencia.getConResidencia();
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * FROM despesa d INNER JOIN categoria_despesa cd on d.id_categoria = cd.id_categoria");
			ResultSet rs = stmt.executeQuery();
			List<Contabilidade> listaDespesa = new ArrayList<Contabilidade>();

			while (rs.next()) {
				Contabilidade despesa = new Contabilidade();
				despesa.setId(rs.getInt("cod_despesa"));
				despesa.setNome(rs.getString("nome_despesa"));
				despesa.setValor(rs.getDouble("valor_total"));
				despesa.setDescricao(rs.getString("desc_despesa"));
				despesa.setIdCategoriaDespesa(rs.getInt("id_categoria"));
				despesa.setData(rs.getDate("data_emissao"));
				listaDespesa.add(despesa);
			}
			return listaDespesa;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean salvaContabilidadeDAO(Contabilidade cd) {
		Connection con = ConectaBDResidencia.getConResidencia();
		try {
			PreparedStatement stmt;
			if (cd.getId() == null) {
				stmt = con.prepareStatement(
						"INSERT INTO despesa (nome_despesa, valor_total, desc_despesa, id_categoria, data_emissao) VALUES (?,?,?,?,?)");
			} else {
				stmt = con.prepareStatement(
						"UPDATE despesa SET nome_despesa=?, valor_total=?, desc_despesa=?, id_categoria=?, data_emissao=? WHERE cod_despesa=?");
				stmt.setInt(6, cd.getId());
			}
			String novaData = sdf.format(cd.getData());
			System.out.println("Data no banco" + novaData);
			stmt.setString(1, cd.getNome());
			stmt.setDouble(2, cd.getValor());
			stmt.setString(3, cd.getDescricao());
			stmt.setInt(4, cd.getIdCategoriaDespesa());
			stmt.setString(5, novaData);
			// stmt.setDate(5, (Date) new java.util.Date(new Date(0).getTime()));
			stmt.execute();
			status = true;
			ConectaBDResidencia.CloseConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			status = false;
		}
		return status;
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
			PreparedStatement stmt = con
					.prepareStatement("DELETE FROM categoria_despesa WHERE id_categoria = " + codCat);
			status = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
