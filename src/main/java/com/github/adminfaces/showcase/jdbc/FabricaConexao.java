package com.github.adminfaces.showcase.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	private static Connection con;

	public static Connection getConEscola() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://192.168.0.115/cursos", "devop", "dev");
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		return con;
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

}
