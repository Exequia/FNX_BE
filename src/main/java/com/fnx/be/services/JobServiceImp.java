package com.fnx.be.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnx.be.daos.JobRepository;
import com.fnx.be.daos.JobsSkillsExperiencyRepository;
import com.fnx.be.models.Job;
import com.fnx.be.models.JobskillsExperiencies;
import com.fnx.be.services.interfaces.IJobService;

@Service
public class JobServiceImp implements IJobService {
	
	final static Logger logger = Logger.getLogger(JobServiceImp.class);

	@Autowired
	protected JobRepository jobRepository;
	
	@Autowired
	protected JobsSkillsExperiencyRepository jobsSkillsExperiencyRepository;

	@Override
	public List<Job> findAll() {
		
		List<Job> lstJobs = null;
		
		try {
			
			lstJobs = this.jobRepository.findAll();
			
//			if (lstJobs.size() > 0) {
//				lstJobs.stream().forEach(job -> this.getJobsSkillsExperiency(job));
//			}
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		return lstJobs;
	}

	private List<JobskillsExperiencies> getJobskillsExperiencies(Job job) {
		List<JobskillsExperiencies> lstEx = this.jobsSkillsExperiencyRepository.findByJobId(job.getId());
		return lstEx;
	}

}
