package com.fnx.be.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnx.be.daos.JobRepository;
import com.fnx.be.models.Job;
import com.fnx.be.services.interfaces.IJobService;

@Service
public class JobServiceImp implements IJobService {
	
	final static Logger logger = Logger.getLogger(JobServiceImp.class);

	@Autowired
	protected JobRepository jobRepository;


	@Override
	public List<Job> findAll() {
		
		List<Job> lstJobs = null;
		
		try {
			
			lstJobs = this.jobRepository.findAll();
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		return lstJobs;
	}

}
