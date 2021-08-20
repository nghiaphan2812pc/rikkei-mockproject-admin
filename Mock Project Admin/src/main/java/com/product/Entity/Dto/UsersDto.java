package com.product.Entity.Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.product.Entity.Users;

import lombok.Getter;
import lombok.Setter;

public class UsersDto {
	@Getter
	@Setter
	private Long id;
	private String userName;
	
	private String password;
	
	private String fullName;
	
	private String address;
	
	private String phone;
	
	private String role;
	private List<OrdersDto> ordersDto = new ArrayList<>();
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public List<OrdersDto> getOrdersDto() {
		return this.ordersDto;
	}
	public void setOrdersDto(List<OrdersDto> ordersDto) {
		this.ordersDto = ordersDto;
	}
	
	public static UsersDto from(Users users) {
		UsersDto usersDto = new UsersDto();
		
		usersDto.setId(users.getId());
		
		usersDto.setAddress(users.getAddress());
		
//		usersDto.setFullName(users.getFullName());
		usersDto.setFullName(users.getFullName());
		
		usersDto.setPassword(users.getPassword());
		
		usersDto.setPhone(users.getPhone());
		
		usersDto.setRole(users.getRole());
		
		usersDto.setUserName(users.getUserName());
		
		// Trường hợp tạo mới user thì chưa có order -> can check empty truoc khi stream
		if(!CollectionUtils.isEmpty(users.getOrders())) {
			usersDto.setOrdersDto(users.getOrders().stream().map(OrdersDto :: from).collect(Collectors.toList()));
		}
		
		return usersDto;
	}
	
}
