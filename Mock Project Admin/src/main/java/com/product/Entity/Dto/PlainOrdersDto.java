package com.product.Entity.Dto;

//import com.product.Entity.Orders;
import com.product.Entity.Users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlainOrdersDto {
	
	private Long id;
	private String userName;
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
	
	public static PlainOrdersDto from(Users users) {
		PlainOrdersDto plainOrdersDto = new PlainOrdersDto();
		plainOrdersDto.setId(users.getId());
		plainOrdersDto.setUserName(users.getUserName());
		return plainOrdersDto;
	}
}
