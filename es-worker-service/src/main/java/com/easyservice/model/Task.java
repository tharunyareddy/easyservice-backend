/**
 *
 */
package com.easyservice.model;

/**
 * @author TharunyaREDDY
 *
 */
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task {
	@Column(length = 20)
	private String taskName;
	@Id
	@GeneratedValue(generator = "task_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "task_gen", sequenceName = "task_seq", initialValue = 200, allocationSize = 1)
	private Integer taskId;

	@Column(length = 20)
	private String organiser;
	private LocalDate tStartDate;
	private LocalDate tEndDate;
	private Integer durationDays;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Status tStatus;

	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private Priority tPriority;

	@ManyToOne
	@JoinColumn(name = "maintenance_id")
	@JsonIgnore
	Maintenance maintenance;

	private String taskImg;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "worker_id")
	Worker worker;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getOrganiser() {
		return organiser;
	}

	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}

	public LocalDate gettStartDate() {
		return tStartDate;
	}

	public void settStartDate(LocalDate tStartDate) {
		this.tStartDate = tStartDate;
	}

	public LocalDate gettEndDate() {
		return tEndDate;
	}

	public void settEndDate(LocalDate tEndDate) {
		this.tEndDate = tEndDate;
	}

	public Integer getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(Integer durationDays) {
		this.durationDays = durationDays;
	}

	public Status gettStatus() {
		return tStatus;
	}

	public void settStatus(Status tStatus) {
		this.tStatus = tStatus;
	}

	public Priority gettPriority() {
		return tPriority;
	}

	public void settPriority(Priority tPriority) {
		this.tPriority = tPriority;
	}

	public Maintenance getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(Maintenance maintenance) {
		this.maintenance = maintenance;
	}

	public String getTaskImg() {
		return taskImg;
	}

	public void setTaskImg(String taskImg) {
		this.taskImg = taskImg;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(String taskName, String organiser, LocalDate tStartDate, LocalDate tEndDate, Integer durationDays,
			Status tStatus, Priority tPriority, String taskImg) {
		super();
		this.taskName = taskName;
		this.organiser = organiser;
		this.tStartDate = tStartDate;
		this.tEndDate = tEndDate;
		this.durationDays = durationDays;
		this.tStatus = tStatus;
		this.tPriority = tPriority;
		this.taskImg = taskImg;
	}

	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", organiser=" + organiser + ", tStartDate=" + tStartDate + ", tEndDate="
				+ tEndDate + ", durationDays=" + durationDays + ", tStatus=" + tStatus + ", tPriority=" + tPriority
				+ ", taskImg=" + taskImg + ", worker=" + worker + "]";
	}

	
}
