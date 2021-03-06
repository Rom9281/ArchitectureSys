package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="CARD")
public class Card {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String description;
	private String family;
	private String affinity;
	private String imgUrl;
	private Integer defense;
	private Integer energy;
	private Integer hp;
	private Integer attack;
	private int user_id;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	
	
	public Card() {
		this.name = "";
		this.description = "";
		this.family = "";
		this.affinity = "";
		this.imgUrl="";
		this.defense = 0;
		this.energy = 0;
		this.hp = 0;
		this.attack = 0;
		this.user_id = 0;
	}

	public Card(String name,String description,String family, String affinity, String imgUrl, Integer defense, Integer energy, Integer hp, Integer attack, int user_id) {
		this.name = name;
		this.description = description;
		this.family = family;
		this.affinity = affinity;
		this.imgUrl=imgUrl;
		this.defense = defense;
		this.energy = energy;
		this.hp = hp;
		this.attack = attack;
		this.user_id = user_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getAffinity() {
		return affinity;
	}

	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", description=" + description + ", family=" + family
				+ ", affinity=" + affinity + ", imgUrl=" + imgUrl + ", defense=" + defense + ", energy=" + energy
				+ ", hp=" + hp + ", attack=" + attack + "]";
	}

	// GETTER AND SETTER
}

