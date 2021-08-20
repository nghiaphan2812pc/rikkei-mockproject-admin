package com.product.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Products;
import com.product.Entity.Dto.ProductsDto;
import com.product.Entity.Exception.ProductsNotFoundException;
import com.product.Repository.BrandRepository;
import com.product.Repository.ProductsRepository;

@Service
public class ProductsService {
	private final ProductsRepository productsRepository;
	private final BrandRepository repo;;
	@Autowired
	public ProductsService(ProductsRepository productsRepository, BrandRepository repo) {
		this.productsRepository = productsRepository;
		this.repo = repo;
	}
	
	public Products addProducts(ProductsDto productsDto) {
		Products products = new Products();
		products.setName(productsDto.getName());
		// Ở entity ko  gọi đc repo nên viết hàm này ở service luôn
		products.setBrand(repo.findById(productsDto.getBrand_id()).get());
		products.setPrice(productsDto.getPrice());
		products.setStatus(productsDto.getStatus());
//		products.setSize(productsDto.getSize());
//		products.setColor(productsDto.getColor());

		
		return productsRepository.save(products);
	}
	
	public List<Products> getProducts(){
		return StreamSupport
				.stream(productsRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Products getProducts(Long id) {
		return productsRepository.findById(id)
				.orElseThrow(() -> new ProductsNotFoundException(id));
	}
	@Transactional
	public void deleteProducts(Long id) throws Exception{
		// Kiểm tra xem user đó có trong db ko, ko có thì ra lỗi luôn, ko cần xóa nữa
		productsRepository.findById(id).orElseThrow(() -> new Exception("this products not found"));
		productsRepository.deleteById(id);

	}
	@Transactional
	public Products editProducts(Long id, ProductsDto products) {
		Products productsToEdit = getProducts(id);
		productsToEdit.setName(products.getName());
		productsToEdit.setBrand(repo.findById(products.getBrand_id()).get());
		productsToEdit.setPrice(products.getPrice());
//		productsToEdit.setSize(products.getSize());
		productsToEdit.setStatus(products.getStatus());
//		productsToEdit.setColor(products.getColor());
		return productsRepository.save(productsToEdit);
	}


}