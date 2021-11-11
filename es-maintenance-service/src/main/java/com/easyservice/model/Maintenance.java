/**
 *
 */
package com.easyservice.model;

/**
 * @author TharunyaREDDY
 *
 */
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Maintenance {

	@Column(length = 20)
	private String maintenanceName;

	@Id
	@GeneratedValue(generator="maintenance_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="maintenance_gen",sequenceName = "maintenance_seq",initialValue = 100,allocationSize = 1)
	private Integer maintenanceId;
	
	@Column(length = 20)
	private String maintenanceManager;
	private LocalDate mStartDate;
	private LocalDate mEndDate;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 8)
	private Status mStatus;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 8)
	private Priority mPriority;
	
	@ManyToOne
	@JoinColumn(name="contract_id")
	@JsonIgnore
	Contract contractor;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "maintenance_id")
	//@JsonIgnore
	Set<Task> taskList;
	
	private String maintenanceImg;

	public String getMaintenanceName() {
		return maintenanceName;
	}

	public void setMaintenanceName(String maintenanceName) {
		this.maintenanceName = maintenanceName;
	}

	public Integer getMaintenanceId() {
		return maintenanceId;
	}

	public void setMaintenanceId(Integer maintenanceId) {
		this.maintenanceId = maintenanceId;
	}

	public String getMaintenanceManager() {
		return maintenanceManager;
	}

	public void setMaintenanceManager(String maintenanceManager) {
		this.maintenanceManager = maintenanceManager;
	}

	public LocalDate getmStartDate() {
		return mStartDate;
	}

	public void setmStartDate(LocalDate mStartDate) {
		this.mStartDate = mStartDate;
	}

	public LocalDate getmEndDate() {
		return mEndDate;
	}

	public void setmEndDate(LocalDate mEndDate) {
		this.mEndDate = mEndDate;
	}

	public Status getmStatus() {
		return mStatus;
	}

	public void setmStatus(Status mStatus) {
		this.mStatus = mStatus;
	}

	public Priority getmPriority() {
		return mPriority;
	}

	public void setmPriority(Priority mPriority) {
		this.mPriority = mPriority;
	}

	public Contract getContractor() {
		return contractor;
	}

	public void setContractor(Contract contractor) {
		this.contractor = contractor;
	}

	public Set<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(Set<Task> taskList) {
		this.taskList = taskList;
	}

	public String getMaintenanceImg() {
		return maintenanceImg;
	}

	public void setMaintenanceImg(String maintenanceImg) {
		this.maintenanceImg = maintenanceImg;
	}

	public Maintenance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Maintenance(String maintenanceName, String maintenanceManager, LocalDate mStartDate, LocalDate mEndDate,
			Status mStatus, Priority mPriority, Set<Task> taskList, String maintenanceImg) {
		super();
		this.maintenanceName = maintenanceName;
		this.maintenanceManager = maintenanceManager;
		this.mStartDate = mStartDate;
		this.mEndDate = mEndDate;
		this.mStatus = mStatus;
		this.mPriority = mPriority;
		this.taskList = taskList;
		this.maintenanceImg = maintenanceImg;
	}

	@Override
	public String toString() {
		return "Maintenance [maintenanceName=" + maintenanceName + ", maintenanceManager=" + maintenanceManager
				+ ", mStartDate=" + mStartDate + ", mEndDate=" + mEndDate + ", mStatus=" + mStatus + ", mPriority="
				+ mPriority + ", taskList=" + taskList + ", maintenanceImg=" + maintenanceImg + "]";
	}

		
}
