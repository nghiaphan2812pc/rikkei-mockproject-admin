package com.product.Entity.Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.product.Entity.Brand;

import lombok.Getter;
import lombok.Setter;

public class BrandDto {

	@Getter
	@Setter
	private Long id;
	private String name;
	private List<ProductsDto> productsDto = new ArrayList<>();
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return this.name;
	}



	public void setName(String name) {
		this.name = name;
	}







	public static BrandDto from(Brand brand) {
		BrandDto brandDto = new BrandDto();
		brandDto.setId(brand.getId());
		brandDto.setName(brand.getName());
		// Trường hợp tạo mới brand thì chưa có products -> can check empty truoc khi stream
		if(!CollectionUtils.isEmpty(brand.getProducts())) {

			brandDto.setProductsDto(brand.getProducts()
					.stream().map(ProductsDto::from)
					.collect(Collectors.toList()));
		}
		return brandDto;
		
		
	}



	public List<ProductsDto> getProductsDto() {
		return productsDto;
	}



	public void setProductsDto(List<ProductsDto> productsDto) {
		this.productsDto = productsDto;
	}



	
}