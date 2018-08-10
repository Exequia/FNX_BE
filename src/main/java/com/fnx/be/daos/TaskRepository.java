package com.fnx.be.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fnx.be.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findById(int id);
	
	List<Task> findTop4ByTaskStatusId(int statusId);

}
