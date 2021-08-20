package com.product.Entity.Dto;

import java.time.LocalDate;
import java.util.Objects;

import com.product.Entity.Orders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersDto {
	
	
	private Long id;
	private LocalDate time;
	private String fullName;
	private String total_price;
	private String status;
	private Long users_id;
	private String address;
	private int final_price;
	private String phone;
	private int shipping;

	private PlainOrdersDto plainOrdersDto;
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getTime() {
		return this.time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	}
	public String getFullName() {
		return this.fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getTotal_price() {
		return this.total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getUsers_id() {
		return this.users_id;
	}
	public void setUsers_id(Long users_id) {
		this.users_id = users_id;
	}
	public PlainOrdersDto getPlainOrdersDto() {
		return plainOrdersDto;
	}
	public void setPlainOrdersDto(PlainOrdersDto plainOrdersDto) {
		this.plainOrdersDto = plainOrdersDto;
	} 
	
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getFinal_price() {
		return this.final_price; 
	}
	public void setFinal_price(int final_price) {
		this.final_price = final_price;
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
	public static OrdersDto from(Orders orders) {
		OrdersDto ordersDto = new OrdersDto();
		
		ordersDto.setId(orders.getId());
		
		ordersDto.setAddress(orders.getAddress());
		
		ordersDto.setFinal_price(orders.getFinal_price());
		
		ordersDto.setShipping(orders.getShipping());
		
		ordersDto.setPhone(orders.getPhone());
		
		ordersDto.setTime(orders.getTime());
		
		ordersDto.setFullName(orders.getFullName());
		
		ordersDto.setTotal_price(orders.getTotal_price());
		
		ordersDto.setStatus(orders.getStatus());
		
		ordersDto.setUsers_id(orders.getUsers().getId());
		
		if(Objects.nonNull(orders.getUsers())) {
			ordersDto.setPlainOrdersDto(PlainOrdersDto.from(orders.getUsers()));
		}
		return ordersDto;
	}
	
	
}
