package com.fnx.be;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fnx.be.dto.UserDto;
import com.fnx.be.models.Role;
import com.fnx.be.models.User;

public class UserDtoUnitTest {

	@Autowired
	private ModelMapper modelMapper;

	@Test
	public void whenConvertUserEntityToUserDto_thenCorrect() {
		Date init = new Date();
		Role role = new Role();
		
		role.setId(1);
		
		User user = new User();
		user.setId(1);
		user.setName("Fénix");
		user.setSurname1("Hell");
		user.setEmail("a@a.a");
		user.setPass("pass");
		user.setInit(init);
		user.setRole(role);

		UserDto userDto = this.modelMapper.map(user, UserDto.class);

		assertEquals(user.getId(), userDto.getId());
		assertEquals(user.getName(), userDto.getName());
		assertEquals(user.getSurname1(), userDto.getSurname1());
		assertEquals(user.getEmail(), userDto.getEmail());
		assertNull(user.getPass());
		assertEquals(user.getInit(), userDto.getInit());
		assertEquals(user.getRole(), userDto.getRole());
	}

//	@Test
//	public void whenConvertUserDtoToUserEntity_thenCorrect() {
//		Date init = new Date();
//		
//		UserDto userDto = new UserDto();
//		userDto.setName("Fénix");
//		userDto.setSurname1("Hell");
//		userDto.setEmail("a@a.a");
//		userDto.setInit(init);
//
//		User user = this.modelMapper.map(userDto, User.class);
//
//		assertEquals(userDto.getName(), user.getName());
//		assertEquals(userDto.getSurname1(), user.getSurname1());
//		assertEquals(userDto.getEmail(), user.getEmail());
//		assertEquals(userDto.getInit(), user.getInit());
//	}

}
