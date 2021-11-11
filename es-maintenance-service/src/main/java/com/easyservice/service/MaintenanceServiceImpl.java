package com.easyservice.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.easyservice.exception.MaintenanceNotFoundException;
import com.easyservice.exception.TaskNotFoundException;
import com.easyservice.model.Contract;
import com.easyservice.model.Maintenance;
import com.easyservice.model.Priority;
import com.easyservice.model.Status;
import com.easyservice.model.Task;
import com.easyservice.repository.IMaintenanceRepository;

/**
 * @author GAYATHRI S
 *
 */
@Service
public class MaintenanceServiceImpl implements IMaintenanceService {

	@Autowired
	RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Autowired
	IMaintenanceRepository maintenanceRepository;

	public static final String BASEURL = "http://localhost:8072/task-service/task";

	// List<Task> taskList = null;
	Maintenance maintenance = new Maintenance();
	Task task = new Task();

	@Override
	public Maintenance addMaintenance(Maintenance maintenance) {
		return maintenanceRepository.save(maintenance);
	}

	@Override
	public void updateMaintenance(Maintenance maintenance) {
		maintenanceRepository.save(maintenance);
	}

	@Override
	public void deleteMaintenance(int maintenanceId) {
		maintenanceRepository.deleteById(maintenanceId);
	}

	@Override
	public Maintenance getById(int maintenanceId) throws MaintenanceNotFoundException {
		return maintenanceRepository.findById(maintenanceId).get();
	}

	@Override
	public List<Maintenance> getAll() {
		return maintenanceRepository.findAll();
	}

//
//	@Override
//	public Maintenance getByMaintenanceName(String maintenanceName) {
//		return maintenanceRepository.findByMaintenanceName(maintenanceName);
//	}
//
//	@Override
//	public Maintenance getByMaintenanceManager(String maintenanceManager) {
//		return maintenanceRepository.findByMaintenanceManager(maintenanceManager);
//	}
//
//	@Override
//	public List<Maintenance> getByMaintenanceStartDate(LocalDate mStartDate) {
//		return maintenanceRepository.findByMaintenanceStartDate(mStartDate);
//	}
//
//	@Override
//	public List<Maintenance> getByMaintenanceEndDate(LocalDate mEndDate) {
//		return maintenanceRepository.findByMaintenanceEndDate(mEndDate);
//	}
//
	@Override
	public List<Maintenance> getByMaintenanceStatus(Status mStatus) {
		return maintenanceRepository.findByMaintenanceStatus(mStatus);
	}

	@Override
	public List<Maintenance> getByMaintenancePriority(Priority mPriority) {
		return maintenanceRepository.findByMaintenancePriority(mPriority);
	}
//
//	@Override
//	public List<Maintenance> getByMaintenanceStartAndEndDate(LocalDate mStartDate, LocalDate mEndDate)throws MaintenanceNotFoundException {
//	    List<Maintenance> maintenanceList=maintenanceRepository.findByMaintenanceStartAndEndDate(mStartDate, mEndDate);
//	    if(maintenanceList.isEmpty()) {
//	    	throw new MaintenanceNotFoundException("Maintenance Id not found");
//	    }
//	    else {
//		   return maintenanceList;
//	    }
//	}
//
//	@Override
//	public List<Maintenance> getByMaintenanceStatusAndPriority(Status mStatus, Priority mPriority)throws MaintenanceNotFoundException {
//		List<Maintenance> maintenanceList=maintenanceRepository.findByMaintenanceStatusAndPriority(mStatus, mPriority);
//		if(maintenanceList.isEmpty()) {
//	    	throw new MaintenanceNotFoundException("Maintenance not found");
//	    }
//	    else {
//		   return maintenanceList;
//	    }
//	}
//
//	@Override
//	public Maintenance getByMaintenanceNameAndStatus(String maintenanceName, Status mStatus) {
//		return maintenanceRepository.findByMaintenanceNameAndStatus(maintenanceName, mStatus);
//	}
//
//	@Override
//	public Maintenance getByMaintenanceNameAndPriority(String maintenanceName, Priority mPriority) {
//		return maintenanceRepository.findByMaintenanceNameAndPriority(maintenanceName, mPriority);
//	}
//
//	@Override
//	public Task assignTask(Task task,int maintenanceId) {
//		maintenance=maintenanceRepository.findById(maintenanceId).get();
//		task.setMaintenance(maintenance);
//		String url=BASEURL;
//		HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
//        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Task> requestEntity = new HttpEntity<>(task, requestHeaders);
//        ResponseEntity<Task> responseEntity = restTemplate.exchange(
//                url,
//                HttpMethod.POST,
//                requestEntity,
//                Task.class
//        );
// return requestEntity.getBody();
//		
//	}
//	
//
//
//	public void unAssignedTask(Task task) {
//		String url = BASEURL;
//		restTemplate.put(url,task);
//	}
//
//
//	public void deleteTask(int taskId) {
//		String url = BASEURL + "/ taskId/"+taskId;
//		restTemplate.delete(url, taskId);
//	}
//
//	public Task getByTaskId(int taskId)throws TaskNotFoundException {
//		String url = BASEURL + "/taskId/" + taskId;
//		task = restTemplate.getForObject(url, Task.class);
//		return task;
//	}
//
//	@Override
//	public List<Task> getAllTask() {
//
//		String url = BASEURL;
//		ResponseEntity<List> taskList = restTemplate.getForEntity(url, List.class);
//		return taskList.getBody();
//	}
//
//	@Override
//	public Task getByMaintenanceId(int maintenanceId)throws MaintenanceNotFoundException {
//		String url = BASEURL + "/maintenanceId/" + maintenanceId;
//		ResponseEntity<Task> task = restTemplate.getForEntity(url, Task.class);
//		//System.out.println(task);
//		return task.getBody();
//	}
//
//	@Override
//	public Task getByOrganiserAndStatus(String organiser,Status tStatus) {
//		String url = BASEURL + "/organiser/" + organiser + "/tStatus/" + tStatus;
//		task = restTemplate.getForObject(url, Task.class);
//		return task;
//	}
//
//	@Override
//	public List<Task> getByTaskStartDateAndEndDate(LocalDate tStartDate, LocalDate tEndDate)throws TaskNotFoundException {
//		String url = BASEURL + "/tStartDate/" + tStartDate + "/tEndDate/" + tEndDate;
//		ResponseEntity<List>  task = restTemplate.getForEntity(url, List.class);
//		return task.getBody();
//	}

	@Override
	public int assignMaitenanceToContract(int maintenanceId, int contractId) {
		return maintenanceRepository.assignMaintenanceToContract(contractId, maintenanceId);
	}

//	@Override
//	public int deAssignMaitenanceToContract(int contractId,int maintenanceId) {
//		return maintenanceRepository.deAssignMaintenanceToContract(, maintenanceId);
//	}

//	@Override
//	public Contract getByContractId(int contractId) {
//		String url = BASEURL2 + "/contractId/"+contractId;
//		ResponseEntity<Contract> contract = restTemplate.getForEntity(url, Contract.class);
//     System.out.println("HI "+contract.getBody());
//	return contract.getBody();
//	}

}
