package com.product.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Orders;
import com.product.Entity.Dto.OrdersDto;
import com.product.Entity.Exception.OrdersNotFoundException;
import com.product.Repository.OrdersRepository;
import com.product.Repository.UsersRepository;

@Service
public class OrdersService {
	private final OrdersRepository ordersRepository;
	private final UsersRepository usersRepository;
	
	@Autowired
	public OrdersService(OrdersRepository ordersRepository, UsersRepository usersRepository) {
		this.ordersRepository = ordersRepository;
		this.usersRepository = usersRepository;
	}
	
//	public Orders addOrders(OrdersDto ordersDto) {
//		Orders orders = new Orders();
//		orders.setAddress(ordersDto.getAddress());
//		orders.setFinal_price(ordersDto.getFinal_price());
//		orders.setFullName(ordersDto.getFullName());
//		orders.setPhone(ordersDto.getPhone());
//		orders.setShipping(ordersDto.getShipping());
//		orders.setStatus(ordersDto.getStatus());
//		orders.setTime(ordersDto.getTime());
//		orders.setTotal_price(ordersDto.getTotal_price());
//		orders.setUsers(usersRepository.findById(ordersDto.getUsers_id()).get());
//		return ordersRepository.save(orders);
//	}
	
	public List<Orders> getOrders(){
		return StreamSupport
				.stream(ordersRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	public Orders getOrders(Long id) {
		return ordersRepository.findById(id)
				.orElseThrow(() -> new OrdersNotFoundException(id));
	}
//	@Transactional
//	public void deleteOrders(Long id) throws Exception{
//		ordersRepository.findById(id).orElseThrow(() -> new Exception("this order not found"));
//	}
//	
//	@Transactional
//	public Orders editOrders(Long id, OrdersDto orders) {
//		Orders ordersToEdit = getOrders(id);
//		ordersToEdit.setAddress(orders.getAddress());
//		ordersToEdit.setFinal_price(orders.getFinal_price());
//		ordersToEdit.setFullName(orders.getFullName());
//		ordersToEdit.setPhone(orders.getPhone());
//		ordersToEdit.setShipping(orders.getShipping());
//		ordersToEdit.setStatus(orders.getStatus());
//		ordersToEdit.setTime(orders.getTime());
//		ordersToEdit.setTotal_price(orders.getTotal_price());
//		ordersToEdit.setUsers(usersRepository.findById(orders.getUsers_id()).get());
//		return ordersRepository.save(ordersToEdit);
//	}
}
