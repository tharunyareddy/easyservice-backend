package com.easyservice.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyservice.exception.MaintenanceNotFoundException;
import com.easyservice.exception.TaskNotFoundException;
import com.easyservice.model.Contract;
import com.easyservice.model.Maintenance;
import com.easyservice.model.Priority;
import com.easyservice.model.Status;
import com.easyservice.model.Task;
import com.easyservice.service.IMaintenanceService;

/**
 * @author GAYATHRI S
 *
 */

@RestController
@RequestMapping("/maintenance-service")
//@CrossOrigin("http://localhost:4200")
public class MaintenanceController {

	IMaintenanceService maintenanceService;

	@Autowired
	public void setMaintenanceService(IMaintenanceService maintenanceService) {
		this.maintenanceService = maintenanceService;
	}

	Maintenance maintenances = new Maintenance();
	List<Maintenance> maintenanceList = null;
	Task task = new Task();
	
	//http://localhost:8071/maintenance-service/maintenance
	@PostMapping("/maintenance")
	ResponseEntity<String> addMaintenance(@RequestBody Maintenance maintenance) {
		maintenances = maintenanceService.addMaintenance(maintenance);
		return ResponseEntity.status(HttpStatus.CREATED).body("value added!!!");
	}
	
	//http://localhost:8071/maintenance-service/maintenance
	@PutMapping("/maintenance")
	ResponseEntity<String> updateMaintenance(@RequestBody Maintenance maintenance) {
		maintenanceService.updateMaintenance(maintenance);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated !!!");
	}
	
	//http://localhost:8071/maintenance-service/maintenance/101
	@DeleteMapping("/maintenance/{maintenanceId}")
	ResponseEntity<String> deleteMaintenance(@PathVariable("maintenanceId") int maintenanceId) {
		maintenanceService.deleteMaintenance(maintenanceId);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
	}
	
	//http://localhost:8071/maintenance-service/maintenance/maintenanceId/101
	@GetMapping("/maintenance/maintenanceId/{maintenanceId}")
	ResponseEntity<Maintenance> getById(@PathVariable("maintenanceId") int maintenanceId) throws MaintenanceNotFoundException {
		maintenances = maintenanceService.getById(maintenanceId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get One Maintenance By Id");
		headers.add("info", "Returning one Maintenance");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(maintenances);
	}

	// http://localhost:8071/maintenance-service/maintenance
	@GetMapping("/maintenance")
	ResponseEntity<List<Maintenance>> getAll() {
		maintenanceList = maintenanceService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get all maintenance");
		return ResponseEntity.accepted().headers(headers).body(maintenanceList);
	}
	
	// http://localhost:8071/maintenance-service/maintenance/maintenanceId/111/contractId/17
	@GetMapping("/maintenance/maintenanceId/{maintenanceId}/contractId/{contractId}")
	String assignMaitenanceToContract(@PathVariable("maintenanceId") int maintenanceId,@PathVariable("contractId") int contractId) {
		
		maintenanceService.assignMaitenanceToContract(maintenanceId, contractId);
		
		return "assigned";
	}
	
	 //http://localhost:8071/maintenance-service/maintenance/cId/17/mId/111
//		@GetMapping("/maintenance/cId/{contractId}/mId/{maintenanceId}")
//		String deAssignMaitenanceToContract(@PathVariable("contractId") int contractId,@PathVariable("maintenanceId") int maintenanceId) {
//			
//			maintenanceService.deAssignMaitenanceToContract(contractId,maintenanceId);
//			
//			return "De-Assigned";
//		}
	
	//http://localhost:8071/maintenance-service/contracts/contractId/17
//	@GetMapping("/contracts/contractId/{contractId}")
//	ResponseEntity<Contract>  getByContractId(@PathVariable("contractId") int contractId) {
//		Contract contractById = maintenanceService.getByContractId(contractId);
//		System.out.println(contractById);
//		return ResponseEntity.accepted().body(contractById);
//	}
	
	
	
//	//http://localhost:8071/maintenance-service/maintenance/maintenanceName/Painting
//	@GetMapping("/maintenance/maintenanceName/{maintenanceName}")
//	ResponseEntity<Maintenance> getByMaintenanceName(@PathVariable("maintenanceName") String maintenanceName) {
//		Maintenance maintenances = maintenanceService.getByMaintenanceName(maintenanceName);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get by maintenance name");
//		return ResponseEntity.ok().headers(headers).body(maintenances);
//
//	}
//	
//	//http://localhost:8071/maintenance-service/maintenance/maintenanceManager/Teja
//	@GetMapping("/maintenance/maintenanceManager/{maintenanceManager}")
//	ResponseEntity<Maintenance> getByMaintenanceManager(@PathVariable("maintenanceManager") String maintenanceManager) {
//		Maintenance maintenances = maintenanceService.getByMaintenanceManager(maintenanceManager);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get by maintenance name");
//		return ResponseEntity.ok().headers(headers).body(maintenances);
//
//	}
//	
//	//http://localhost:8071/maintenance-service/maintenance/maintenanceStartDate/2020-10-01
//	@GetMapping("/maintenance/maintenanceStartDate/{mStartDate}")
//	ResponseEntity<List<Maintenance>> getByMaintenanceStartDate(@PathVariable("mStartDate") String mStartDate) {
//		maintenanceList = maintenanceService.getByMaintenanceStartDate(LocalDate.parse(mStartDate));
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get by start date");
//		return ResponseEntity.ok().headers(headers).body(maintenanceList);
//	}
//	
//	@GetMapping("/maintenance/maintenanceEndDate/{mEndDate}")
//	ResponseEntity<List<Maintenance>> getByMaintenanceEndDate(@PathVariable("mEndDate") String mEndDate) {
//		maintenanceList = maintenanceService.getByMaintenanceEndDate(LocalDate.parse(mEndDate));
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get by end date");
//		return ResponseEntity.ok().headers(headers).body(maintenanceList);
//	}
//  //http://localhost:8071/maintenance-service/maintenance/maintenanceStatus/ONHOLD
	@GetMapping("/maintenance/maintenanceStatus/{mStatus}")
	ResponseEntity<List<Maintenance>> getByMaintenanceStatus(@PathVariable("mStatus") Status mStatus) {
		maintenanceList = maintenanceService.getByMaintenanceStatus(mStatus);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get by status");
		return ResponseEntity.ok().headers(headers).body(maintenanceList);
	}
	//http://localhost:8071/maintenance-service/maintenance/maintenancePriority/HIGH
	@GetMapping("/maintenance/maintenancePriority/{mPriority}")
	ResponseEntity<List<Maintenance>> getByMaintenancePriority(@PathVariable("mPriority") Priority mPriority) {
		maintenanceList = maintenanceService.getByMaintenancePriority(mPriority);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get by priority");
		return ResponseEntity.ok().headers(headers).body(maintenanceList);
	}
//
//	@GetMapping("/maintenance/maintenanceStartDate/{mStartDate}/maintenanceEndDate/{mEndDate}")
//	ResponseEntity<List<Maintenance>> getByMaintenanceStartAndEndDate(@PathVariable("mStartDate") String mStartDate,
//			@PathVariable("mEndDate") String mEndDate) throws MaintenanceNotFoundException {
//		maintenanceList = maintenanceService.getByMaintenanceStartAndEndDate(LocalDate.parse(mStartDate),
//				LocalDate.parse(mEndDate));
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get by start date and end date");
//		return ResponseEntity.ok().headers(headers).body(maintenanceList);
//	}
//	
//	@GetMapping("/maintenance/maintenanceStatus/{mStatus}/maintenancePriority/{mPriority}")
//	ResponseEntity<List<Maintenance>> getByMaintenanceStatusAndPriority(@PathVariable("mStatus") Status mStatus,
//			@PathVariable("mPriority") Priority mPriority) throws MaintenanceNotFoundException {
//		maintenanceList = maintenanceService.getByMaintenanceStatusAndPriority(mStatus, mPriority);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get by status and priority");
//		return ResponseEntity.ok().headers(headers).body(maintenanceList);
//	}
//
//	@GetMapping("/maintenance/maintenanceName/{maintenanceName}/maintenanceStatus/{mStatus}")
//	ResponseEntity<Maintenance> getByMaintenanceNameAndStatus(@PathVariable("maintenanceName") String maintenanceName,
//			@PathVariable("mStatus") Status mStatus) {
//		maintenances = maintenanceService.getByMaintenanceNameAndStatus(maintenanceName, mStatus);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get by status and name");
//		return ResponseEntity.ok().headers(headers).body(maintenances);
//	}
//	
//	//http://localhost:8071/maintenance-service/maintenance/maintenanceName/Painting/maintenancePriority/HIGH
//	@GetMapping("/maintenance/maintenanceName/{maintenanceName}/maintenancePriority/{mPriority}")
//	ResponseEntity<Maintenance> getByMaintenanceNameAndPriority(@PathVariable("maintenanceName") String maintenanceName,
//			@PathVariable("mPriority") Priority mPriority) {
//		maintenances = maintenanceService.getByMaintenanceNameAndPriority(maintenanceName, mPriority);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get by start date");
//		return ResponseEntity.ok().headers(headers).body(maintenances);
//	}
//	
//	//http://localhost:8071/maintenance-service/task/maintenanceId/105
//	@PostMapping("/task/maintenanceId/{maintenanceId}")
//	ResponseEntity<String> assignTask(@RequestBody Task task, @PathVariable("maintenanceId") int maintenanceId) {
//		maintenanceService.assignTask(task, maintenanceId);
//		ResponseEntity<String> taskResponse = new ResponseEntity<String>("Task Assigned", HttpStatus.OK);
//		return taskResponse;
//	}
//
//	//http://localhost:8071/maintenance-service/task
//	@PutMapping("/task")
//	ResponseEntity<String> unAssignedTask(@RequestBody Task task) {
//		maintenanceService.unAssignedTask(task);
//		ResponseEntity<String> taskResponse = new ResponseEntity<String>("Task Un-Assigned", HttpStatus.OK);
//		return taskResponse;
//	}
//	
//	//******************TASK******************************************
//	
//	//http://localhost:8071/maintenance-service/task/204
//	@DeleteMapping("/task/{taskId}")
//	ResponseEntity<String> deleteTask(@PathVariable("taskId") int taskId) {
//		maintenanceService.deleteTask(taskId);
//		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
//	}
//	
//	//http://localhost:8071/maintenance-service/task/taskId/200
//	@GetMapping("/task/taskId/{taskId}")
//	ResponseEntity<Task> getByTaskId(@PathVariable("taskId") int taskId) throws TaskNotFoundException {
//		task = maintenanceService.getByTaskId(taskId);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get One Task By Id");
//		headers.add("info", "Returning one task");
//		ResponseEntity<Task> taskResponse = new ResponseEntity<Task>(task, headers, HttpStatus.OK);
//		return taskResponse;
//	}
//	
//	//http://localhost:8071/maintenance-service/task
//	@GetMapping("/task")
//	ResponseEntity<List<Task>> getAllTask() {
//		List<Task> taskList = maintenanceService.getAllTask();
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get all tasks");
//		return ResponseEntity.accepted().headers(headers).body(taskList);
//	}
//	
//	//http://localhost:8071/maintenance-service/task/maintenanceId/100
//	@GetMapping("/task/maintenanceId/{maintenanceId}")
//	ResponseEntity<Task> getByMaintenanceId(@PathVariable("maintenanceId") int maintenanceId) throws MaintenanceNotFoundException {
//		Task task = maintenanceService.getByMaintenanceId(maintenanceId);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get One Task By  maintenanceId");
//		headers.add("info", "Returning one task");
//		return ResponseEntity.accepted().headers(headers).body(task);
//	}
//	
//	//http://localhost:8071/maintenance-service/task/organiser/Navin/tStatus/INPROGRESS
//	@GetMapping("/task/organiser/{organiser}/tStatus/{tStatus}")
//	ResponseEntity<Task> getByOrganiserAndStatus(@PathVariable("organiser") String organiser,
//			@PathVariable("tStatus") Status tStatus) {
//		task = maintenanceService.getByOrganiserAndStatus(organiser,tStatus);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get Tasklist By organiser and status");
//		return ResponseEntity.ok().headers(headers).body(task);
//	}
//	
//	//http://localhost:8071/maintenance-service/task/tStartDate/2021-10-01/tEndDate/2021-10-10
//	@GetMapping("/task/tStartDate/{tStartDate}/tEndDate/{tEndDate}")
//	ResponseEntity<List<Task>> getByTaskStartDateAndEndDate(@PathVariable("tStartDate") String tStartDate,
//			@PathVariable("tEndDate") String tEndDate) throws TaskNotFoundException {
//		List<Task> taskList = maintenanceService.getByTaskStartDateAndEndDate(LocalDate.parse(tStartDate),
//				LocalDate.parse(tEndDate));
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("desc", "Get Task By StartDate and EndDate");
//		return ResponseEntity.ok().headers(headers).body(taskList);
//	}

}
