package com.easyservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.easyservice.exception.MaintenanceNotFoundException;
import com.easyservice.exception.TaskNotFoundException;
import com.easyservice.model.Contract;
import com.easyservice.model.Maintenance;
import com.easyservice.model.Priority;
import com.easyservice.model.Status;
import com.easyservice.model.Task;

/**
 * @author GAYATHRI S
 *
 */
public interface IMaintenanceService {

	// crud
	Maintenance addMaintenance(Maintenance maintenance);

	void updateMaintenance(Maintenance maintenance);

	void deleteMaintenance(int maintenanceId);

	Maintenance getById(int maintenanceId)throws MaintenanceNotFoundException;

	List<Maintenance> getAll();

	// maintenance
//	Maintenance getByMaintenanceName(String maintenanceName);
//
//	Maintenance getByMaintenanceManager(String maintenanceManager);
//
//	List<Maintenance> getByMaintenanceStartDate(LocalDate mStartDate);
//
//	List<Maintenance> getByMaintenanceEndDate(LocalDate mEndDate);
//
	List<Maintenance> getByMaintenanceStatus(Status mStatus);
	
	List<Maintenance> getByMaintenancePriority(Priority mPriority);
	
	//Contract getByContractId(int contractId);
	
	int assignMaitenanceToContract(int maintenanceId,int contractId);
	
	//int deAssignMaitenanceToContract(int contractId,int maintenanceId);

//	List<Maintenance> getByMaintenanceStartAndEndDate(LocalDate mStartDate, LocalDate mEndDate)throws MaintenanceNotFoundException;
//
//	List<Maintenance> getByMaintenanceStatusAndPriority(Status mStatus, Priority mPriority)throws MaintenanceNotFoundException;
//
//	Maintenance getByMaintenanceNameAndStatus(String maintenanceName, Status mStatus);
//
//	Maintenance getByMaintenanceNameAndPriority(String maintenanceName, Priority mPriority);

//	Task assignTask(Task task,int maintenanceId);
	
	
//
//	void unAssignedTask(Task task);
//
//	void deleteTask(int taskId);
//
//	Task getByTaskId(int taskId)throws TaskNotFoundException;
//
//	List<Task> getAllTask();
//
//	Task getByMaintenanceId(int maintenanceId)throws MaintenanceNotFoundException;
//
//	Task getByOrganiserAndStatus(String organiser,Status status);
//
//	List<Task> getByTaskStartDateAndEndDate(LocalDate tStartDate, LocalDate tEndDate)throws TaskNotFoundException;
//	


}
