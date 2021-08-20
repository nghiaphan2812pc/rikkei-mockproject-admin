package com.product.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long>{

}
