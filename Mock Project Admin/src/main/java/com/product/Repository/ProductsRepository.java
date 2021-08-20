package com.product.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

	List<Products> findByBrandId(Long id);

}