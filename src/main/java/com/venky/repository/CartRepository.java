package com.venky.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venky.model.Cart;
import com.venky.model.User;

public interface CartRepository extends JpaRepository<Cart,Integer> {
	public Optional<Cart>findByUser(User user);
	
	  
}