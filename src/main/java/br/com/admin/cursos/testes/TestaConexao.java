package br.com.admin.cursos.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestaConexao {

	public static void main(String[] args) {

		Connection conexao =null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		conexao = ModuloConexao.con();
		System.out.println("Conexão: " + conexao);
	
	}
	
}
