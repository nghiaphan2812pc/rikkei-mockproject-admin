package com.product.Entity.Dto;

import com.product.Entity.Brand;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PlainProductsDto {
@Getter
@Setter
		private Long id;
		private String name;

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public static PlainProductsDto from (Brand brand) {
			PlainProductsDto plainProductsDto = new PlainProductsDto();
			plainProductsDto.setId(brand.getId());
			plainProductsDto.setName(brand.getName());
			return plainProductsDto;
		}


}