package com.product.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>{

}
