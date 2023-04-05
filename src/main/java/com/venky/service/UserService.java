package com.venky.service;

import java.util.List;

import com.venky.payload.UserDto;

public interface UserService {
	
	public UserDto create(UserDto userDto);
	
	public UserDto update(UserDto t, int userId);
	
	public void delete(int userId);
	
	public List<UserDto> getAll();
	
	public UserDto getByUserId(int userId);
	
	public UserDto getByEmailId(String emailId);

}
