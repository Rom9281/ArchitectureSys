package com.sp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String email;
	private String imgUrl;
	
	@OneToMany(mappedBy="User")
	private Collection<Card> cards;

	public User() {
	}
	
	public User(String nom, String login, String password, String prenom, String email, String imgUrl) {
		super();
		this.nom = nom;
		this.password = password;
		this.login = login;
		this.prenom = prenom;
		this.email = email;
		this.imgUrl = imgUrl;
		this.cards = new ArrayList<Card>();
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
	
	public void addCard(Card c) {
		this.cards.add(c);
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", imgUrl=" + imgUrl
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
