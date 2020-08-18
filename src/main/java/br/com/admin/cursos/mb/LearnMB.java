package br.com.admin.cursos.mb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LearnMB {

	int id;
	String name;
	String email;
	String password;
	String gender;
	String address;
	ArrayList<LearnMB> userList;

	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	Connection connection;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	// Cria uma conexao com o BD
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://192.168.0.115:3306/cursos","dev","devop");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	// Exibe lista de usuarios 
	public ArrayList<LearnMB> userList() {
		try {
			userList = new ArrayList<LearnMB>();
			connection = getConnection();
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				LearnMB lmb = new LearnMB();
				lmb.setId(rs.getInt("id"));
				lmb.setName(rs.getString("name"));
				lmb.setEmail(rs.getString("email"));
				lmb.setPassword(rs.getString("password"));
				lmb.setGender(rs.getString("gender"));
				lmb.setAddress(rs.getString("address"));
				userList.add(lmb);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return userList;
	}
	
	// Salva regitro de novo usuario
	public String save() {
		int result = 0;
		try {
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO user(name, email, password, gender, address) VALUES (?,?,?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, password);
			stmt.setString(4, gender);
			stmt.setString(5, address);
			result = stmt.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		if(result != 0)
			return "dashlearning.xthml?faces-redirect=true";
		else
			return "create.xhtml?faces-redirect=true";
	}
	
	// Exibe usuario a ser editado
	public String edit(int id) {
		int result = 0;
		try {
			connection = getConnection();
			PreparedStatement  stmt = connection.prepareStatement("");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	// Altera e salva usuario editado
	public String update(LearnMB u) {
		
		return null;
	}
	
	// Remove usuario
	public void delete(int id) {
		
	}
	
	// 
	public String getGenderName(char geder) {
		
		return null;
	}
	
	
	
}
