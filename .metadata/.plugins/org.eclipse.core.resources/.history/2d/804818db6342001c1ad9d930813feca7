/**
 *
 */
package com.easyservice.service;

/**
 * @author TharunyaREDDY
 *
 */
import java.time.LocalDate;
import java.util.List;
import com.easyservice.exception.ContractNotFoundException;
import com.easyservice.exception.MaintenanceNotFoundException;
import com.easyservice.model.Contract;
import com.easyservice.model.Maintenance;
import com.easyservice.model.Priority;
import com.easyservice.model.Status;

public interface IContractorService {

	// **********************************Contractor*******************************************

	Contract addContractor(Contract contractor);

	String updateContractor(Contract contractor);

	String deleteContractor(int contractId) throws ContractNotFoundException;

	List<Contract> getAllContracts();

	Contract getByContractId(int contractId) throws ContractNotFoundException;

//	List<Contract> getContractNameByMaintenanceManager(String maintenanceManager) throws ContractNotFoundException;
//
//	List<Contract> getContractsByMaintenanceName(String maintenanceName) throws ContractNotFoundException;

	// *************************************Maintenance*******************************************

	String assignMaintenance(int maintenanceId, int contractId);

	void unAssignMaintenance(Maintenance maintenance);

	Maintenance getByMaintenanceId(int maintenanceId) throws MaintenanceNotFoundException;

	List<Maintenance> getAllMaintenance();
//
//	List<Maintenance> getMaintenanceByContractName(String contractName) throws MaintenanceNotFoundException;
//
//	List<Maintenance> getMaintenanceByContractorName(String contractorName) throws MaintenanceNotFoundException;
	
	
	List<Maintenance> getMaintenanceByContractId(int contractId) throws MaintenanceNotFoundException;
	// ******************************************************************************************//

	Contract getByContractName(String contractName) throws ContractNotFoundException;
//
//	Contract getByContractorName(String contractorName) throws ContractNotFoundException;
	
	List<Contract> getByContractStatus(Status cStatus) throws ContractNotFoundException;
	
	List<Contract> getByContractPriority(Priority cPriority) throws ContractNotFoundException;
//
//	List<Contract> getByStartDate(LocalDate startDate) throws ContractNotFoundException;
//
//	List<Contract> getByEndDate(LocalDate endDate) throws ContractNotFoundException;
//
//	List<Contract> getByStartDateAndEndDate(LocalDate startDate, LocalDate endDate) throws ContractNotFoundException;
//
//	Maintenance getByMaintenanceName(String maintenanceName) throws MaintenanceNotFoundException;
//
//	Maintenance getByMaintenanceManager(String maintenanceManager) throws MaintenanceNotFoundException;
//
//	List<Maintenance> getByMaintenanceStartDate(LocalDate mStartDate) throws MaintenanceNotFoundException;
//
//	List<Maintenance> getByMaintenanceEndDate(LocalDate mEndDate) throws MaintenanceNotFoundException;
//
	List<Maintenance> getByMaintenanceStatus(Status mStatus) throws MaintenanceNotFoundException;

	List<Maintenance> getByMaintenancePriority(Priority mPriority) throws MaintenanceNotFoundException;

//	List<Maintenance> getByMaintenanceStartAndEndDate(LocalDate mStartDate, LocalDate mEndDate)
//			throws MaintenanceNotFoundException;
//
//	List<Maintenance> getByMaintenanceStatusAndPriority(Status mStatus, Priority mPriority)
//			throws MaintenanceNotFoundException;
//
//	Maintenance getByMaintenanceNameAndStatus(String maintenanceName, Status mStatus)
//			throws MaintenanceNotFoundException;
//
//	Maintenance getByMaintenanceNameAndPriority(String maintenanceName, Priority mPriority)
//			throws MaintenanceNotFoundException;

}
