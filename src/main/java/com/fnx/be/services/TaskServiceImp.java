package com.fnx.be.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnx.be.daos.TaskRepository;
import com.fnx.be.models.Task;
import com.fnx.be.services.interfaces.ITaskService;

@Service
public class TaskServiceImp implements ITaskService {
	
	final static Logger logger = Logger.getLogger(TaskServiceImp.class);

	@Autowired
	protected TaskRepository taskRepository;

	@Override
	public List<Task> getHomeTasks(int id) {
		
		List<Task> lstTasks = null;
		
		try {
			
			lstTasks = this.taskRepository.findById(id);
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		return lstTasks;
	}
}
