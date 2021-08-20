package com.product.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Orders;
import com.product.Entity.Users;
import com.product.Entity.Dto.UsersDto;
import com.product.Entity.Exception.OrdersIdReadyException;
import com.product.Entity.Exception.UsersNotFoundException;
import com.product.Repository.OrdersRepository;
import com.product.Repository.UsersRepository;

@Service

public class UsersService {

	@Autowired
	private final UsersRepository usersRepository;
	
	@Autowired
	
	private final OrdersRepository ordersRepository;
	
	@Autowired
	
	private final OrdersService ordersService;
	
	@Autowired
	public UsersService(UsersRepository usersRepository, OrdersService ordersService, OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
		this.ordersService = ordersService;
		this.usersRepository = usersRepository;
	}
	
	public Users addUsers(UsersDto usersDto) {
		Users users = new Users();
		users.setAddress(usersDto.getAddress());
		users.setFullName(usersDto.getFullName());
		users.setPassword(usersDto.getPassword());
		users.setPhone(usersDto.getPhone());
		users.setRole(usersDto.getRole());
		users.setUserName(usersDto.getUserName());	
		
		return usersRepository.save(users);
	}
	
	public List<Users> getUsers(){
		return StreamSupport
				.stream(usersRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Users getUsers(Long id) {
		Users users = usersRepository.findById(id)
				.orElseThrow(() -> new UsersNotFoundException(id));
		return users;
		// Chuẩn thì chỗ get này mà ko tìm thấy thì cũng cần trả lại 404, thì bên client nó mới dựa vào đó để báo lỗi cho ng dùng,   
	}
	@Transactional
	public void deleteUsers(Long id) throws Exception {
		// Kiểm tra xem user đó có trong db ko, ko có thì ra lỗi luôn, ko cần xóa nữa
		usersRepository.findById(id).orElseThrow(()-> new Exception("This user not found"));
		
		usersRepository.deleteById(id);
		// Thông thường khi delete xong thì ko cần trả ra thông tin user -> vì lúc đó đã xóa rồi
		// Sau này học về cái xử lý exception (@ControlerAdvice) nữa thì trường hợp này mình phải trả về lỗi 404 cho client, chứ ko phải 500 như hiện tại
	}
	@Transactional
	public Users editUsers(Long id, UsersDto users) {
		Users usersToEdit = getUsers(id);
		usersToEdit.setAddress(users.getAddress());
		usersToEdit.setFullName(users.getFullName());
		usersToEdit.setPassword(users.getPassword());
		usersToEdit.setPhone(users.getPhone());
		usersToEdit.setUserName(users.getUserName());
		usersToEdit.setRole(users.getRole());
		
		return usersRepository.save(usersToEdit);
	}
	
	@Transactional
	public Users addOrderToUsers(Long usersId, Long ordersId) {
		Users users = getUsers(usersId);
		Orders orders = ordersService.getOrders(ordersId);
		if(Objects.nonNull(orders.getUsers())) {
			throw new OrdersIdReadyException(ordersId, orders.getUsers().getId());
		}
		users.addOrders(orders);
		return users;
	}
	@Transactional
	public Users removeOrdersFromUsers(Long usersId, Long ordersId) {
		Users users = getUsers(usersId);
		Orders orders = ordersService.getOrders(ordersId);
		users.removeOrders(orders);
		return users;
	}
	
}
