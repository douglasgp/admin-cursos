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

import br.com.admin.residencia.model.StatusContabil;
import br.com.admin.residencia.model.StatusContabil;

public class StatusContabilDAO {

	private static Connection con;
	private boolean status = false;

	public List<StatusContabil> listaStatusContabil() {
		try {
			Connection con = ConectaBDResidencia.getConResidencia();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM status");
			ResultSet rs = stmt.executeQuery();
			List<StatusContabil> listaStatusContabil = new ArrayList<StatusContabil>();

			while (rs.next()) {
				StatusContabil statusContabil = new StatusContabil();
				statusContabil.setCodContabil(rs.getInt("id_status"));
				statusContabil.setNomeContabil(rs.getString("nome_status"));
				statusContabil.setDescContabil(rs.getString("desc_status"));
				listaStatusContabil.add(statusContabil);
			}
			return listaStatusContabil;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean salvaStatusContabilDAO(StatusContabil sc) {
		Connection con = ConectaBDResidencia.getConResidencia();
		try {
			PreparedStatement stmt;
			if (sc.getCodContabil() == null) {
				stmt = con.prepareStatement(
						"INSERT INTO status (nome_status, desc_status) VALUES (?,?)");
			} else {
				stmt = con.prepareStatement(
						"UPDATE status SET nome_status=?, desc_status=? WHERE id_status=?");
				stmt.setInt(3, sc.getCodContabil());
			}
			stmt.setString(1, sc.getNomeContabil());
			stmt.setString(2, sc.getDescContabil());
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

	public int removeStatusContabilDAO(Integer codStatus) {
		int status = 0;
		try {
			Connection con = ConectaBDResidencia.getConResidencia();
			PreparedStatement stmt = con
					.prepareStatement("DELETE FROM status WHERE id_status = " + codStatus);
			status = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
