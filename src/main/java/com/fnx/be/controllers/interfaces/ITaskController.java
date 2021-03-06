package com.fnx.be.controllers.interfaces;

import org.springframework.http.ResponseEntity;

import com.fnx.be.util.RestResponse;

public interface ITaskController {

	ResponseEntity<RestResponse> getHomeTasks(int id);

	ResponseEntity<RestResponse> findForHome();
}
