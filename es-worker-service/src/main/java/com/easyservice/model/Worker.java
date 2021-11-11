/**
 *
 */
package com.easyservice.model;

/**
 * @author TharunyaREDDY
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Worker {

	@Id
	@GeneratedValue(generator = "worker_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "worker_gen", sequenceName = "worker_seq", initialValue = 300, allocationSize = 1)
	private Integer workerId;
	
	@Column(length = 20)
	private String workerName;
	
	@Column(length = 20)
	private String workType;
	
	@Column(length = 20)
	private String availability;
	
	@Column(length = 10)
	private String contactNumber;
	
	private Integer workingHours;
	
	private String workerImg;
	
	@OneToOne(mappedBy = "worker")
	@JsonIgnore
	Task task;
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public Integer getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public Integer getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(Integer workingHours) {
		this.workingHours = workingHours;
	}
	public String getWorkerImg() {
		return workerImg;
	}
	public void setWorkerImg(String workerImg) {
		this.workerImg = workerImg;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Worker(String workerName, String workType, String availability, String contactNumber, Integer workingHours,
			String workerImg) {
		super();
		this.workerName = workerName;
		this.workType = workType;
		this.availability = availability;
		this.contactNumber = contactNumber;
		this.workingHours = workingHours;
		this.workerImg = workerImg;
	}
	@Override
	public String toString() {
		return "Worker [workerName=" + ", availability=" + availability
				+ ", contactNumber=" + contactNumber + ", workType=" + workType + ", workingHours=" + workingHours
				+ ", workerImg=" + workerImg + "]";
	}
}
