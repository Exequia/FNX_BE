package com.fnx.be.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jobs_role database table.
 * 
 */
@Entity
@Table(name="jobs_role")
@NamedQuery(name="JobsRole.findAll", query="SELECT j FROM JobsRole j")
public class JobsRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	public JobsRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}