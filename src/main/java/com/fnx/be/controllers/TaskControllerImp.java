package com.fnx.be.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
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
import com.fnx.be.dto.TaskDto;
import com.fnx.be.models.Task;
import com.fnx.be.models.TaskStatus;
import com.fnx.be.services.interfaces.ITaskService;
import com.fnx.be.services.interfaces.ITaskStatusService;
import com.fnx.be.util.RestResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tasks")
public class TaskControllerImp implements ITaskController {

	final static Logger logger = Logger.getLogger(TaskControllerImp.class);

	@Autowired
	protected ObjectMapper mapper;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	protected ITaskService taskService;

	@Autowired
	protected ITaskStatusService taskStatusService;

	@Override
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public ResponseEntity<RestResponse> getHomeTasks(@RequestParam int id) {

		logger.info("/findById -> " + id);

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
				response.setData(lstTasks.stream().map(task -> this.convertToDto(task)).collect(Collectors.toList()));
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
	@RequestMapping(value = "/findForHome", method = RequestMethod.GET)
	public ResponseEntity<RestResponse> findForHome() {

		logger.info("/findForHome");

		RestResponse response = new RestResponse();
		HttpStatus httpStatus = HttpStatus.OK;

		try {

			List<TaskStatus> lstStatus = taskStatusService.findByName(TaskStatus.OPEN);

			List<Task> lstTasks = taskService.findForHome(lstStatus.get(0).getId());

			if (lstTasks.size() == 0) {

				response.setStatus(0);
				response.setMsg("No se han encontrado tareas");

			} else {

				response.setStatus(1);
				response.setMsg("OK");
				response.setData(lstTasks.stream().map(task -> this.convertToDto(task)).collect(Collectors.toList()));
			}

		} catch (Exception e) {
			logger.error(e);

			response.setStatus(0);
			response.setMsg("Se ha producido un error no controlado. Por favor contacte con el administrador");

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
	}

	private TaskDto convertToDto(Task task) {
		return modelMapper.map(task, TaskDto.class);
	}
}
