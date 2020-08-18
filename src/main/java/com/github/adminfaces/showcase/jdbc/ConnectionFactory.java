package com.github.adminfaces.showcase.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public Connection getConResidencia() {
		try {
			return DriverManager.getConnection("jdbc:mysql://192.168.0.115/residencia", "devop", "dev");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConCursos() {
		try {
			return DriverManager.getConnection("jdbc:mysql://192.168.0.115/cursos", "devop", "dev");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
