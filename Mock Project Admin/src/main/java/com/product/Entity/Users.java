package com.product.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.product.Entity.Dto.UsersDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class Users  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Getter
@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_id")
	private List<Orders> orders;
	
	@Column(name ="user_name")
	private String userName;
	
	@Column(name ="password")
	private String password;

	@Column(name ="full_name")
	private String fullName;

	@Column(name ="address")
	private String address;

	@Column(name ="phone")
	private String phone;

	@Column(name ="role")
	private String role;
	
	public void addUsers(Users users) {
		users.addUsers(users);
	}
	
	public void removeUsers(Users users) {
		users.removeUsers(users);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Orders> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void addOrders(Orders orders) {
		// TODO Auto-generated method stub
		
	}

	public void removeOrders(Orders orders) {
		// TODO Auto-generated method stub
		
	}
	public static Users from(UsersDto usersDto) {
		Users users = new Users();
		
		users.setAddress(usersDto.getAddress());
		
		users.setFullName(usersDto.getFullName());
		
		users.setPassword(usersDto.getPassword());
		
		users.setPhone(usersDto.getPhone());

		users.setRole(usersDto.getRole());
		
		users.setUserName(usersDto.getUserName());
		
		return users;
	}
}
