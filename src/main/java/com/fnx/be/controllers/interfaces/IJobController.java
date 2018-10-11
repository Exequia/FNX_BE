package com.fnx.be.controllers.interfaces;

import org.springframework.http.ResponseEntity;

import com.fnx.be.util.RestResponse;

public interface IJobController {

	ResponseEntity<RestResponse> findAll(int languageId);

}
