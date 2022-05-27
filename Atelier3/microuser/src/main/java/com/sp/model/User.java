package com.sp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MY_USER")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String first_name;
	private String login;
	private String password;
	private String email;
	private String imgUrl;
	private int money;
	private Collection<Integer> cards;
	
	
	public User() {
	}
	
	public User(String name, String login, String password, String first_name, String email, String imgUrl) {
		super();
		this.setMoney(5000);
		this.name = name;
		this.password = password;
		this.login = login;
		this.first_name = first_name;
		this.email = email;
		this.imgUrl = imgUrl;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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
	
	public void addCard(Integer id_card) {
		this.cards.add(id_card);
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", first_name=" + first_name + ", login=" + login + ", password="
				+ password + ", email=" + email + ", imgUrl=" + imgUrl + ", cards=" + cards + "]";
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	

}
