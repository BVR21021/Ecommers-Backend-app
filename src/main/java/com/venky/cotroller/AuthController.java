package com.venky.cotroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venky.Exception.Resourses_Not_Found;
import com.venky.payload.JwtRequest;
import com.venky.payload.JwtResponse;
import com.venky.payload.UserDto;
import com.venky.security.JwtHelper;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager manger;
	@Autowired
	private UserDetailsService userDetailSevice;
	@Autowired
	private JwtHelper helper;
	@Autowired
	private ModelMapper model;
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		
	 this.autheticateUser(request.getUsername(),request.getPassword());
	  UserDetails userDetails = this.userDetailSevice.loadUserByUsername(request.getUsername());
		String token=this.helper.generateToken(userDetails);
		JwtResponse response=new JwtResponse();
		response.setToken(token);
		response.setUser(this.model.map(userDetails,UserDto.class));
		
		return new ResponseEntity<JwtResponse>(response,HttpStatus.ACCEPTED);
		
	}
	
	private void autheticateUser(String Username ,String password){
		try {
			
			manger.authenticate(new UsernamePasswordAuthenticationToken(Username, password));
		}catch(BadCredentialsException e) {
			throw new Resourses_Not_Found("Invaild username or password");
			
		}catch(DisabledException e) {
			throw new Resourses_Not_Found("User is not active");
		}
		
	}

}