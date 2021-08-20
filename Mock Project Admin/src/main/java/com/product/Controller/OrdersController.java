package com.product.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.Entity.Orders;
import com.product.Entity.Dto.OrdersDto;
//import com.product.Entity.Dto.ProductsDto;
import com.product.Service.OrdersService;

@RestController
@RequestMapping("/orders/")
public class OrdersController {

	private final OrdersService ordersService;
	
	@Autowired
	public OrdersController(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
//	@PostMapping
//	public ResponseEntity<OrdersDto> addOrders(@RequestBody final OrdersDto ordersDto){
//		Orders orders = ordersService.addOrders(ordersDto);
//		return new ResponseEntity<>(OrdersDto.from(orders), HttpStatus.OK);
//		
//	}
	
	@GetMapping("/")
	public ResponseEntity<List<OrdersDto>> getOrders(){
		List<Orders> orders = ordersService.getOrders();
		List<OrdersDto> ordersDto = orders.stream().map(OrdersDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(ordersDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrdersDto> getOrders(@PathVariable final Long id){
		Orders orders = ordersService.getOrders(id);
		return new ResponseEntity<>(OrdersDto.from(orders), HttpStatus.OK);

	}
	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<OrdersDto> editOrders(@PathVariable final Long id, @RequestBody final OrdersDto ordersDto){
//		Orders editedOrders = ordersService.editOrders(id, ordersDto);
//		return  new ResponseEntity<>(OrdersDto.from(editedOrders), HttpStatus.OK);
//	}
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<String> deleteOrders(@PathVariable final Long id){
//		try {
//			ordersService.deleteOrders(id);
//		}catch(Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//
//		}
//		return new ResponseEntity<>("Delete success", null , HttpStatus.OK);
//	}
	
}
