package com.fnx.be.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the jobs database table.
 * 
 */
@Entity
@Table(name="jobs")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String company;

	@Column(name="company_url")
	private String companyUrl;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="role_id")
	private int roleId;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to JobskillsExperiencies
	@OneToMany(mappedBy="job")
	private List<JobskillsExperiencies> jobsSkillsExperiencies;

	public Job() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyUrl() {
		return this.companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<JobskillsExperiencies> getJobsSkillsExperiencies() {
		return this.jobsSkillsExperiencies;
	}

	public void setJobsSkillsExperiencies(List<JobskillsExperiencies> jobsSkillsExperiencies) {
		this.jobsSkillsExperiencies = jobsSkillsExperiencies;
	}

	public JobskillsExperiencies addJobsSkillsExperiency(JobskillsExperiencies jobsSkillsExperiency) {
		getJobsSkillsExperiencies().add(jobsSkillsExperiency);
		jobsSkillsExperiency.setJob(this);

		return jobsSkillsExperiency;
	}

	public JobskillsExperiencies removeJobsSkillsExperiency(JobskillsExperiencies jobsSkillsExperiency) {
		getJobsSkillsExperiencies().remove(jobsSkillsExperiency);
		jobsSkillsExperiency.setJob(null);

		return jobsSkillsExperiency;
	}

}