package com.fnx.be.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fnx.be.models.TaskStatus;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Integer> {

	List<TaskStatus> findByName(String name);

}
