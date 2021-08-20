package com.product.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Users users;

	@Column(name = "address")
	private String address;

	@Column(name = "date")
	private LocalDate time;

	@Column(name = "final_price")
	private int final_price;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "shipping_price")
	private int shipping;

	@Column(name = "status")
	private String status;

	@Column(name = "total_price")
	private String total_price;

	/*
	 * @Column(name = "users_id") private Long users_id;
	 */
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getTime() {
		return this.time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public int getFinal_price() {
		return this.final_price;
	}

	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getShipping() {
		return this.shipping;
	}

	public void setShipping(int shipping) {
		this.shipping = shipping;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotal_price() {
		return this.total_price;
	}

	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}

	/*
	 * public Long getUsers_id() { return this.users_id; }
	 * 
	 * 
	 * public void setUsers_id(Long users_id) { this.users_id = users_id; }
	 */ 
	public Users getUsers() { return this.users; }
	public void setUsers(Users users) {
		this.users = users;
	}

	public void addUsers(Users users) {

	}

	public void removeUsers(Users users) {

	}

//	public Orders getUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
