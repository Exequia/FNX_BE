package com.fnx.be.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the task_status database table.
 * 
 */
@Entity
@Table(name="task_status")
@NamedQuery(name="TaskStatus.findAll", query="SELECT t FROM TaskStatus t")
public class TaskStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String comment;

	private String name;

	public TaskStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}