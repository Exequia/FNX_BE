package com.fnx.be.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fnx.be.models.JobskillsExperiencies;

public interface JobsSkillsExperiencyRepository  extends JpaRepository<JobskillsExperiencies, Integer>{
	
	List<JobskillsExperiencies> findByJobId(Integer jobId);

}
