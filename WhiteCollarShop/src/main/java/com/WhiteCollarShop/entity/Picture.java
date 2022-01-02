package com.WhiteCollarShop.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name="Pictures")
public class Picture {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="NameAuthor")
	private String nameAuthor;
	
	@Column(name="Price")
	private double price;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Date_at")
	private Calendar date_at;

	@Column(name="shopid")
	private int shopid;
	
	
	
	
	public Picture() {}
	
	
	public Picture(String name, String nameAuthor, double price) {
		super();
		this.name = name;
		this.nameAuthor = nameAuthor;
		this.price=price;
	}
	public Picture(int id, String name, String nameAuthor, double price, Calendar date_at, int shopid) {
		super();
		this.id = id;
		this.name = name;
		this.nameAuthor = nameAuthor;
		this.price=price;
		this.date_at = date_at;
		this.shopid = shopid;
	}


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


	public String getNameAuthor() {
		return nameAuthor;
	}


	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Calendar getDate_at() {
		return date_at;
	}


	public void setDate_at(Calendar date_at) {
		this.date_at = date_at;
	}


	public int getShopid() {
		return shopid;
	}


	public void setShopid(int shopid) {
		this.shopid = shopid;
	}


	
	
}