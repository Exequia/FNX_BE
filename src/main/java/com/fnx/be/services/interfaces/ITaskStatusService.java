package com.fnx.be.services.interfaces;

import java.util.List;

import com.fnx.be.models.TaskStatus;

public interface ITaskStatusService {

	/**
	 * Method that return a List of 1 TaskStatus finded by name
	 * 
	 * @param name
	 * @return
	 * @author Alberto Real
	 */
	List<TaskStatus> findByName(String name);

}
