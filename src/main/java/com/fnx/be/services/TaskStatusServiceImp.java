package com.fnx.be.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnx.be.daos.TaskStatusRepository;
import com.fnx.be.models.TaskStatus;
import com.fnx.be.services.interfaces.ITaskStatusService;

@Service
public class TaskStatusServiceImp implements ITaskStatusService {
	
	final static Logger logger = Logger.getLogger(TaskStatusServiceImp.class);

	@Autowired
	protected TaskStatusRepository taskStatusRepository;

	@Override
	public List<TaskStatus> findByName(String name) {
		

		logger.info("/findByName -> name: " + name);
		
		List<TaskStatus> lstTasksStatus = null;
		
		try {
			
			lstTasksStatus = this.taskStatusRepository.findByName(name);
			
			if (lstTasksStatus.size() == 0) {
				
				throw new Exception("No data find");
				
			} else if (lstTasksStatus.size() > 1) {
				
				throw new Exception("Too many data");
				
			}
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		return lstTasksStatus;
	}
}
