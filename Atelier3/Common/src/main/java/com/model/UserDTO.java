package com.model;

public class UserDTO {
	
	private Integer id;

	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String email;
	private Integer money = 5000;

	public UserDTO() {
		this.nom = "";
		this.prenom="";
		this.login = "";
		this.password = "";
		this.email = "";
	}
	
	public UserDTO(String nom, String prenom, String login,String password, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	
	// GETTER AND SETTER
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
