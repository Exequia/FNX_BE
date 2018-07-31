package com.fnx.be.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnx.be.controllers.interfaces.ITaskController;
import com.fnx.be.models.Task;
import com.fnx.be.services.interfaces.ITaskService;
import com.fnx.be.util.RestResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tasks")
public class TaskControllerImp implements ITaskController {

	final static Logger logger = Logger.getLogger(TaskControllerImp.class);

	@Autowired
	protected ObjectMapper mapper;

//	@Autowired
//	private ModelMapper modelMapper;

	@Autowired
	protected ITaskService taskService;

	@Override
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public ResponseEntity<RestResponse> getHomeTasks(@RequestParam int id) {

		RestResponse response = new RestResponse();
		HttpStatus httpStatus = HttpStatus.OK;

		try {
			
			List<Task> lstTasks = taskService.getHomeTasks(id);
			
			if (lstTasks.size() == 0) {
				
				response.setStatus(0);
				response.setMsg("No se han encontrado tareas");
				
			} else {
				
					response.setStatus(1);
					response.setMsg("OK");
					response.setData(lstTasks);
					//response.setData(this.modelMapper.map(lstTasks, TaskDto.class));
			}

		} catch (Exception e) {
			logger.error(e);

			response.setStatus(0);
			response.setMsg("Se ha producido un error no controlado. Por favor contacte con el administrador");
			
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
	}
}
