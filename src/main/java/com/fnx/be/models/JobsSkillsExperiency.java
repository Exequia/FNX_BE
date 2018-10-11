package com.fnx.be.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jobs_skills_experiencies database table.
 * 
 */
@Entity
@Table(name="jobs_skills_experiencies")
@NamedQuery(name="JobsSkillsExperiency.findAll", query="SELECT j FROM JobsSkillsExperiency j")
public class JobsSkillsExperiency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String comments;

	//uni-directional many-to-one association to SkillsExperiency
	@ManyToOne
	@JoinColumn(name="skills_experiencies_id")
	private SkillsExperiency skillsExperiency;

	//uni-directional many-to-one association to Job
	@ManyToOne
	private Job job;

	public JobsSkillsExperiency() {
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

	public SkillsExperiency getSkillsExperiency() {
		return this.skillsExperiency;
	}

	public void setSkillsExperiency(SkillsExperiency skillsExperiency) {
		this.skillsExperiency = skillsExperiency;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}