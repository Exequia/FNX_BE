package com.fnx.be.controllers.interfaces;

import org.springframework.http.ResponseEntity;

import com.fnx.be.util.RestResponse;

public interface IUserController {

	ResponseEntity<RestResponse> login(String email, String pass);

	ResponseEntity<RestResponse> save(String user);

}
