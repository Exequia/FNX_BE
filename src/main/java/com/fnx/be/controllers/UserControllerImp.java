package com.fnx.be.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnx.be.controllers.interfaces.IUserController;
import com.fnx.be.dto.UserDto;
import com.fnx.be.models.User;
import com.fnx.be.services.interfaces.IUserService;
import com.fnx.be.util.RestResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserControllerImp implements IUserController {

	final static Logger logger = Logger.getLogger(UserControllerImp.class);

	@Autowired
	protected ObjectMapper mapper;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	protected IUserService userService;

	// @Override
	// @RequestMapping(value = "/getById", method = RequestMethod.GET)
	// public RestResponse getUserById(Integer id) {
	//
	// return userService.getUserById(id);
	//
	// }

	@Override
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<RestResponse> login(String email, String pass) {

		RestResponse response = new RestResponse();
		HttpStatus httpStatus = HttpStatus.OK;

		try {
			
			List<User> lstUsers = userService.login(email, pass);
			
			if (lstUsers.size() == 0) {
				
				response.setStatus(0);
				response.setMsg("No se han encontrado registros");
				
			} else if (lstUsers.size() > 1) {
				
				response.setStatus(0);
				response.setMsg("Se han encontrado más de un registro.");
				
			} else {
				
				User user = lstUsers.get(0);
				if (user.getPass().equals(pass)) {
					
					response.setStatus(1);
					response.setMsg("OK");
					response.setData(this.modelMapper.map(user, UserDto.class));
					
//					resp.setData(lstUsers.stream().map(user -> this.modelMapper.map(user, UserDto.class))
//					.collect(Collectors.toList()));
	
				} else {
	
					response.setStatus(0);
					response.setMsg("La constraseña indicada no es válida");
					
				}
			}

		} catch (Exception e) {
			logger.error(e);

			response.setStatus(0);
			response.setMsg("Se ha producido un error no controlado. Por favor contacte con el administrador");
			
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
	}

	@Override
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<RestResponse> save(@RequestBody String userJson) {

		RestResponse response = new RestResponse();
		HttpStatus httpStatus = HttpStatus.OK;

		try {

			User user = this.mapper.readValue(userJson, User.class);
//			UserDto userDto = this.mapper.readValue(userJson, UserDto.class);
//			User user = this.modelMapper.map(userDto, User.class);

			response = new RestResponse();
			response.setStatus(1);
			response.setMsg("OK");
			response.setData(user);

		} catch (Exception e) {
			logger.error(e);

			response = new RestResponse();
			response.setStatus(0);
			response.setMsg("Se ha producido un error no controlado. Por favor contacte con el administrador");

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
	}

	// private UserDto convertToDto(User user) {
	// UserDto userDto = modelMapper.map(user, UserDto.class);
	// return userDto;
	// }
	//
	// private User convertToEntity(UserDto userDto) {
	// User user = modelMapper.map(userDto, User.class);
	// return user;
	// }

	// @ResponseStatus(HttpStatus.CREATED)

}
