package com.fnx.be.dto;

import java.util.Date;


public class TaskDto {

	private int id;

	private String body;

	private Date date;

	private String title;

	private TaskStatusDto taskStatus;

	public TaskDto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}


	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TaskStatusDto getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(TaskStatusDto taskStatus) {
		this.taskStatus = taskStatus;
	}

}