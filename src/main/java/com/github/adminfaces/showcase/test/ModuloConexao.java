package com.github.adminfaces.showcase.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModuloConexao {
	
	public static Connection con() {
		java.sql.Connection conexao = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/projetophp";
		String username = "devop";
		String pwd = "dev";
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url,username,pwd);
			return conexao;
		} catch (Exception e) {
			return null;
		}
	}

}
