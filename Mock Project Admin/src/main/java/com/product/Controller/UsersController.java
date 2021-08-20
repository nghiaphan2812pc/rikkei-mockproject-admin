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

import com.product.Entity.Users;
//import com.product.Entity.Dto.BrandDto;
import com.product.Entity.Dto.UsersDto;
import com.product.Service.UsersService;

@RestController
@RequestMapping("/users/")
public class UsersController {

	private final UsersService usersService;
	
	@Autowired
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@PostMapping
	public ResponseEntity<UsersDto> addUsers(@RequestBody final UsersDto usersDto){
		Users users = usersService.addUsers(usersDto);
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);
	}
	
	@GetMapping(value="/")
	public ResponseEntity<List<UsersDto>> getUsers(){
		List<Users> users = usersService.getUsers();
		List<UsersDto> usersDto = users.stream().map(UsersDto :: from).collect(Collectors.toList());
		return new ResponseEntity<>(usersDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsersDto> getUsers(@PathVariable final Long id){
		Users users = usersService.getUsers(id);
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteUsers(@PathVariable final Long id) {
		try {
			usersService.deleteUsers(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return new ResponseEntity<>("Delete success", null , HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<UsersDto> editUsers(@PathVariable final Long id, @RequestBody final UsersDto usersDto){
		// Cho nay cung truyen Dto la duoc
		Users users = usersService.editUsers(id, usersDto);
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);
	}
	@PostMapping(value = "{usersID}/orders/{ordersId}/add")
	public ResponseEntity<UsersDto> addOrdersToUsers(@PathVariable final Long usersID, @PathVariable final Long ordersId){
		Users users = usersService.addOrderToUsers(usersID, ordersId);
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);
	}
	@DeleteMapping(value = "{usersID}/orders/{ordersId}/remove")
	public ResponseEntity<UsersDto> removeOrdersFromUsers(@PathVariable final Long usersID, @PathVariable final Long ordersId){
		Users users = usersService.removeOrdersFromUsers(usersID, ordersId);
		return new ResponseEntity<>(UsersDto.from(users), HttpStatus.OK);

	}
}
