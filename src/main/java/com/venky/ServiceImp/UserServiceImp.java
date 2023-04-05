package com.venky.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.venky.Exception.Resourses_Not_Found;
import com.venky.model.User;
import com.venky.payload.UserDto;
import com.venky.repository.RoleRepository;
import com.venky.repository.UserRepository;
import com.venky.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepositroy;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDto create(UserDto userDto) {
		User user = this.toEntity(userDto);
		String passEncode = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(passEncode);
		User userCreate = this.userRepositroy.save(user);
		return this.toDto(userCreate);
	}

	public UserDto update(UserDto t, int userId) {
		User u = userRepositroy.findById(userId)
				.orElseThrow(() -> new Resourses_Not_Found("User not found by this id"));
		u.setPhone(t.getPhone());
		u.setPassword(t.getPassword());
		u.setName(t.getName());
		u.setGender(t.getGender());
		u.setEmail(t.getEmail());
		u.setDate(t.getDate());
		u.setAddress(t.getAddress());
		u.setActive(t.isActive());
		u.setAbout(t.getAbout());
		User Updateuser = this.userRepositroy.save(u);
		return this.toDto(Updateuser);
	}

	public void delete(int userId) {
		User u = userRepositroy.findById(userId).orElseThrow(() -> new Resourses_Not_Found("UserId not Found"));
		userRepositroy.delete(u);

	}

	public List<UserDto> getAll() {
		List<User> alluser = userRepositroy.findAll();
		List<UserDto> allUserDto = alluser.stream().map(user -> this.toDto(user)).collect(Collectors.toList());

		return allUserDto;
	}

	public UserDto getByUserId(int userId) {
		User finduser = userRepositroy.findById(userId)
				.orElseThrow(() -> new Resourses_Not_Found("User Not Found" + userId));

		return this.toDto(finduser);
	}

	public UserDto getByEmailId(String emailId) {
		User findemail = userRepositroy.findByEmail(emailId)
				.orElseThrow(() -> new Resourses_Not_Found("User Email Is is Not Exit" + emailId));
		return this.toDto(findemail);
	}

	@Autowired
	private ModelMapper mapper;

	public UserDto toDto(User u) {
//		UserDto dto=new UserDto();
//		dto.setUserId(u.getUserId());
//		dto.setName(u.getName());
//		dto.setEmail(u.getEmail());
//		dto.setPassword(u.getPassword());
//		dto.setAbout(u.getAbout());
//		dto.setAddress(u.getAddress());
//		dto.setGender(u.getGender());
//		dto.setDate(u.getDate());
//		dto.setPhone(u.getPhone());
//		dto.setActive(u.isActive());
		// dto.setRoles(u.getRoles());
		// return dto;

		return this.mapper.map(u, UserDto.class);
	}

	public User toEntity(UserDto dto) {
//	User  u=new User();
//	u.setUserId(dto.getUserId());
//	u.setPhone(dto.getPhone());
//	u.setPassword(dto.getPassword());
//	u.setName(dto.getName());
//	u.setGender(dto.getGender());
//	u.setEmail(dto.getEmail());
//	u.setDate(dto.getDate());
//	u.setAddress(dto.getAddress());
//	u.setActive(dto.isActive());
//	u.setAbout(dto.getAbout());
//	//u.setRoles(u.getRoles());
//	return u;
		return this.mapper.map(dto, User.class);
	}
}