package com.WhiteCollarShop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Shops")
public class Shop {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Capacity")
	private int capacity;
	
	
	@OneToMany(mappedBy="shopid",cascade= CascadeType.ALL) 
	@Column(name="Pictures")
	private List<Picture> pictures;
	
	public Shop() {}

	public Shop(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

	public Shop(int id, String name, int capacity, List<Picture> picture) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.pictures = picture;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public List<Picture> getPictureList() {
		return pictures;
	}

	public void setPictureList(List<Picture> pictures) {
		this.pictures = pictures;
	}
	
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", capacity=" + capacity +"]";
		}
}
