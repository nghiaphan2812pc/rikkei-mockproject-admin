package com.product.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Brand;
import com.product.Entity.Products;
import com.product.Entity.Dto.BrandDto;
import com.product.Entity.Exception.BrandNotFoundException;
import com.product.Entity.Exception.ProductsIdReadyEcception;
import com.product.Repository.BrandRepository;
import com.product.Repository.ProductsRepository;


@Service
public class BrandService {
	@Autowired
	private final BrandRepository brandRepository;
	
	@Autowired
	private final ProductsRepository productRepository;
	
	@Autowired
	private final ProductsService productsService;
	
	@Autowired
	public BrandService(BrandRepository brandRepository, ProductsService productsService, ProductsRepository productsRepository) {
		this.brandRepository = brandRepository;
		this.productsService = productsService;
		this.productRepository = productsRepository;
	}
	
	public Brand addBrand(BrandDto brandDto) {
		Brand brand = new Brand();
		brand.setName(brandDto.getName());
		return brandRepository.save(brand);
	}
	
	public List<Brand> getBrand(){
		return StreamSupport
				.stream(brandRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	@Transactional
	public void deleteBrand(Long id) throws Exception{
		// Kiểm tra xem user đó có trong db ko, ko có thì ra lỗi luôn, ko cần xóa nữa
		brandRepository.findById(id).orElseThrow(() -> new Exception("this brand not found"));
		
		brandRepository.deleteById(id);
	}
	
	public Brand getBrand(Long id) {
		// Get brand
		Brand brand = brandRepository.findById(id)
				.orElseThrow(() -> new BrandNotFoundException(id));
		
		// Get list product of brand
//		List<Products> productList = productRepository.findByBrandId(brand.getId());
		
//		brand.setProducts(productList);
		
		return brand;
	}
	@Transactional
	public Brand editBrand(Long id, BrandDto brandDto) {
		Brand brandToEdit = getBrand(id);
		brandToEdit.setName(brandDto.getName());
		return brandRepository.save(brandToEdit);
	}
	@Transactional
	public Brand addProductsToBrand(Long productsId, Long brandId) {
		Brand brand = getBrand(brandId);
		Products products = productsService.getProducts(productsId);
		if(Objects.nonNull(products.getBrand())) {
			throw new ProductsIdReadyEcception(productsId,
					products.getBrand().getId());	
		}
		brand.addProducts(products);
		return brand;
	}
	@Transactional
	public Brand removeProductsFromBrand(Long brandId, Long productsId) {
		Brand brand = getBrand(brandId);
		Products products = productsService.getProducts(productsId);
		brand.removeProducts(products);
		return brand;
	}
}