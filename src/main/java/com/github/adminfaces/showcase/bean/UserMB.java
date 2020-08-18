package com.github.adminfaces.showcase.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.github.adminfaces.showcase.jdbc.ConnectionFactory;
import com.github.adminfaces.showcase.model.CATEGORIAUSUARIO;
import com.github.adminfaces.showcase.model.User;

@ManagedBean
@SessionScoped
public class UserMB implements Serializable {

	private static final long serialVersionUID = 1L;
	Random rd = new Random();
	private User user;
	List<SelectItem> listaCat = CATEGORIAUSUARIO.getCatUsu();

	public void init() {

	}

	public List<User> getUsers() throws ClassNotFoundException, SQLException {

		new ConnectionFactory();
		/*
		 * Connection connect = null; String url =
		 * "jdbc:mysql://192.168.0.115:3306/cursos"; String username = "devop"; String
		 * password = "dev";
		 */
		Connection connect = ConnectionFactory.getConCursos();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// connect = DriverManager.getConnection(url, username, password);
			// System.out.println("Connection established"+connect);

		} catch (Exception ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}

		List<User> users = new ArrayList<User>();
		PreparedStatement pstmt = connect.prepareStatement("select * from user");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			User user = new User();
			user.setId(rs.getInt("id"));
			user.setFirstname(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));

			users.add(user);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return users;

	}

	public String salvaUsuario(User user) {
		int result = 0;
		String senha = geraSenha();

		try {
			new ConnectionFactory();
			Connection con = ConnectionFactory.getConCursos();
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO user(name, email, password,genero,address,cod_cat_usu) VALUES(?,?,?,?,?,?)");
			stmt.setString(1, user.getFirstname());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, senha);
			stmt.setString(4, "M");
			stmt.setString(5, user.getAddress());
			stmt.setString(6, user.getCatUsu());

			result = stmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		if (result != 0) {
			return "user.xhtml?faces-redirect=true";
		} else {
			return "create-user.xhtml?faces-redirect=true";
		}
	}

	public void testaUsuario() {
		this.user = new User();
	}

	public void testaSalvaUsuario(User usuario) {
		this.user = usuario;

	}

	public void consultaCategoria() {
		new ConnectionFactory();
		Connection con = ConnectionFactory.getConCursos();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT cod_cat_usu FROM user");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String geraSenha() {
		Integer senha = rd.nextInt();
		String senhaH = senha + "abc";
		return senhaH;
	}

	public void newUser() {
		this.user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SelectItem> getListaCat() {
		return listaCat;
	}

	public void setListaCat(List<SelectItem> listaCat) {
		this.listaCat = listaCat;
	}

}
