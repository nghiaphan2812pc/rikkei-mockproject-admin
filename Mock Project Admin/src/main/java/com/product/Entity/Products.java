package com.product.Entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.product.Entity.Dto.ProductsDto;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "product")
public class Products implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Brand brand;

	 @Column(name = "name") private String name;
	 
	 @Column(name = "price") private int price;
	 
	 @Column(name = "status") private String status;
	 
	public  Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public void add(Products products) {
		// TODO Auto-generated method stub
		
	}


	public void remove(Products products) {
		// TODO Auto-generated method stub
		
	}



}