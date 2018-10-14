package com.fnx.be.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jobs_skills_experiencies database table.
 * 
 */
@Entity
@Table(name="jobs_skills_experiencies")
@NamedQuery(name="JobskillsExperiencies.findAll", query="SELECT j FROM JobskillsExperiencies j")
public class JobskillsExperiencies implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String comments;

	@Column(name="skills_experiencies_id")
	private int skillsExperienciesId;

	//bi-directional many-to-one association to Job
	@ManyToOne
	private Job job;

	public JobskillsExperiencies() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getSkillsExperienciesId() {
		return this.skillsExperienciesId;
	}

	public void setSkillsExperienciesId(int skillsExperienciesId) {
		this.skillsExperienciesId = skillsExperienciesId;
	}

	public Job getJob() {
//		return this.job;
		return null;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}