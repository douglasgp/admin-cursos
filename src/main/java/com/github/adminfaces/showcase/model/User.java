package com.github.adminfaces.showcase.model;

public class User{

	private Integer id;
    private String firstname;

    private String lastname;

    private Integer age;

    private String street;

    private String city;

    private String postalCode;

    private String info;

    private String email;

    private String phone;
    private String password;
    private String gender;
    private String address;
    private String catUsu;

    public User() {
    	
    }
    
    public User(Integer id, String firstname, String email, String address, String catUsu) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.email = email;
		this.address = address;
		this.catUsu = catUsu;
	}
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCatUsu() {
		return catUsu;
	}

	public void setCatUsu(String catUsu) {
		this.catUsu = catUsu;
	}
	
	    
}