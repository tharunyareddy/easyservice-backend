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
public class Contract {

	@Column(length = 20)
	private String contractName;
	@Id
	@GeneratedValue(generator = "contract_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "contract_gen", sequenceName = "contract_seq", initialValue = 1, allocationSize = 1)
	private Integer contractId;
	@Column(length = 20)
	private String contractorName;
	private LocalDate startDate;
	private LocalDate endDate;
	@Enumerated(EnumType.STRING)
	private Status cStatus;
	@Enumerated(EnumType.STRING)
	private Priority cPriority;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "contract_id")
	@JsonIgnore
	Set<Maintenance> maintenanceList;
	private String contractImg;
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public Integer getContractId() {
		return contractId;
	}
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	public String getContractorName() {
		return contractorName;
	}
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Status getcStatus() {
		return cStatus;
	}
	public void setcStatus(Status cStatus) {
		this.cStatus = cStatus;
	}
	public Priority getcPriority() {
		return cPriority;
	}
	public void setcPriority(Priority cPriority) {
		this.cPriority = cPriority;
	}
	public Set<Maintenance> getMaintenanceList() {
		return maintenanceList;
	}
	public void setMaintenanceList(Set<Maintenance> maintenanceList) {
		this.maintenanceList = maintenanceList;
	}
	public String getContractImg() {
		return contractImg;
	}
	public void setContractImg(String contractImg) {
		this.contractImg = contractImg;
	}
	
	
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contract(String contractName, String contractorName, LocalDate startDate, LocalDate endDate, Status cStatus,
			Priority cPriority, Set<Maintenance> maintenanceList, String contractImg) {
		super();
		this.contractName = contractName;
		this.contractorName = contractorName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cStatus = cStatus;
		this.cPriority = cPriority;
		this.maintenanceList = maintenanceList;
		this.contractImg = contractImg;
	}
	@Override
	public String toString() {
		return "Contract [contractName=" + contractName + ", contractId=" + contractId + ", contractorName="
				+ contractorName + ", startDate=" + startDate + ", endDate=" + endDate + ", cStatus=" + cStatus
				+ ", cPriority=" + cPriority + ", maintenanceList=" + maintenanceList + ", contractImg=" + contractImg
				+ "]";
	}


}
