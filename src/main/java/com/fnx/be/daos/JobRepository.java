package com.fnx.be.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fnx.be.models.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

	List<Job> findById(int id);
	
}
