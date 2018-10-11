package com.fnx.be.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
import com.fnx.be.controllers.interfaces.IJobController;
import com.fnx.be.models.Job;
import com.fnx.be.services.interfaces.IJobService;
import com.fnx.be.util.RestResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/jobs")
public class JobControllerImp implements IJobController {

	final static Logger logger = Logger.getLogger(JobControllerImp.class);

	@Autowired
	protected ObjectMapper mapper;

//	@Autowired
//	private ModelMapper modelMapper;

	@Autowired
	protected IJobService jobService;

	@Override
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<RestResponse> findAll(@RequestParam int languageId) {

		logger.info("/findAll -> " + languageId);

		RestResponse response = new RestResponse();
		HttpStatus httpStatus = HttpStatus.OK;

		try {

			List<Job> lstJobs = jobService.findAll();

			if (lstJobs.size() == 0) {

				response.setStatus(0);
				response.setMsg("No se han encontrado tareas");

			} else {

				response.setStatus(1);
				response.setMsg("OK");
				response.setData(lstJobs.stream().map(job -> this.convertToDto(job)).collect(Collectors.toList()));
			}

		} catch (Exception e) {
			logger.error(e);

			response.setStatus(0);
			response.setMsg("Se ha producido un error no controlado. Por favor contacte con el administrador");

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
	}

	private Job convertToDto(Job job) {
		// return modelMapper.map(task, TaskDto.class);
		return job;
	}

}
