package com.model;

public class CardDTO {
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
	private Integer price;
	private Integer userId;
	private Boolean isToSell;

	public CardDTO() {
		this.setId(0);
		this.name = "";
		this.description = "";
		this.family = "";
		this.affinity = "";
		this.imgUrl="";
		this.defense = 0;
		this.energy = 0;
		this.hp = 0;
		this.attack = 0;
		this.userId = 0;
		this.price = 0;
		this.setIsToSell(false);
	}
	
	public CardDTO(String name,String description,String family, String affinity, String imgUrl, Integer defense , Integer energy, Integer hp, Integer attack, Integer userId, Boolean isToSell) {
		this.name = name;
		this.description = description;
		this.family = family;
		this.affinity = affinity;
		this.imgUrl=imgUrl;
		this.defense = defense;
		this.energy = energy;
		this.hp = hp;
		this.attack = attack;
		this.userId = userId;
		this.price = 100;
		this.isToSell = isToSell;
	}

	// GETTER AND SETTER

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
	public Integer getDefense() {
		return defense;
	}
	public void setDefense(Integer defense) {
		this.defense = defense;
	}
	public Integer getEnergy() {
		return energy;
	}
	public void setEnergy(Integer energy) {
		this.energy = energy;
	}
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public Integer getAttack() {
		return attack;
	}
	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getIsToSell() {
		return isToSell;
	}

	public void setIsToSell(Boolean isToSell) {
		this.isToSell = isToSell;
	}

}