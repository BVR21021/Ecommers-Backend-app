package com.venky.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.venky.Exception.Resourses_Not_Found;
import com.venky.model.User;
import com.venky.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private  UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepo.findByEmail(username).orElseThrow(()->new Resourses_Not_Found("User Not Found"));
		return user;
	}
	
	

}