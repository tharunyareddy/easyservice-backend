package com.easyservice.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.easyservice.exception.TaskNotFoundException;
import com.easyservice.exception.WorkerNotFoundException;
import com.easyservice.model.Status;
import com.easyservice.model.Task;
import com.easyservice.model.Worker;
import com.easyservice.service.ITaskService;

@RestController
@RequestMapping("/task-service")
//@CrossOrigin("http://localhost:4200")
public class TaskController {

	@Autowired
	ITaskService taskService;

	// http://localhost:8072/task-service/task
	@PostMapping("/task")
	ResponseEntity<Task> addTask(@RequestBody Task task) {
		Task taskAdded = taskService.addTask(task);
		ResponseEntity<Task> responseAdd = new ResponseEntity<Task>(taskAdded, HttpStatus.OK);
		return responseAdd;
	}

	// http://localhost:8072/task-service/task/taskId/205
	@DeleteMapping("/task/taskId/{taskId}")
	ResponseEntity<String> deleteTask(@PathVariable("taskId") int taskId) {
		taskService.deleteTask(taskId);
		ResponseEntity<String> responseDelete = new ResponseEntity<String>("value deleted", HttpStatus.OK);
		return responseDelete;
	}

	// http://localhost:8072/task-service/task
	@PutMapping("/task")
	ResponseEntity<String> updateTask(@RequestBody Task task) {
		taskService.updateTask(task);
		ResponseEntity<String> responseUpdate = new ResponseEntity<String>("value updated", HttpStatus.OK);
		return responseUpdate;
	}

	// http://localhost:8072/task-service/task/taskId/200
	@GetMapping("/task/taskId/{taskId}")
	ResponseEntity<Task> getById(@PathVariable("taskId") int taskId) {
		Task task = taskService.getById(taskId);
		ResponseEntity<Task> responseById = new ResponseEntity<Task>(task, HttpStatus.OK);
		return responseById;
	}

	// http://localhost:8072/task-service/task
	@GetMapping("/task")
	ResponseEntity<List<Task>> getAllTask() {
		List<Task> allTaskList = taskService.getAllTask();
		ResponseEntity<List<Task>> responseByAllTask = new ResponseEntity<List<Task>>(allTaskList, HttpStatus.OK);
		return responseByAllTask;
	}
	// http://localhost:8072/task-service/task/maintenaceId/111/taskId/201
	@GetMapping("/task/maintenaceId/{maintenanceId}/taskId/{taskId}")
	String assignTaskToMaintenance(@PathVariable("maintenanceId")	int maintenanceId, @PathVariable("taskId") int taskId) {
		taskService.assignTaskToMaintenance(maintenanceId, taskId);
		return "Task Assigned";
	}
	// http://localhost:8072/task-service/task/workerId/301/taskId/201
	@GetMapping("/task/workerId/{workerId}/taskId/{taskId}")
	String assignTaskToWorker(@PathVariable("workerId") int workerId, @PathVariable("taskId") int taskId) {
		taskService.assignTaskToWorker(workerId, taskId);
		return "Work Assigned";
	}
	
//	// http://localhost:8072/task-service/task/worker/205
//	@PostMapping("/task/worker/{taskId}")
//	ResponseEntity<String> assignWorkToWorker(@RequestBody Worker worker, @PathVariable("taskId") int taskId) {
//		taskService.assignWorkToWorker(worker, taskId);
//		ResponseEntity<String> responseWorkAssigned = new ResponseEntity<String>("work assigned", HttpStatus.OK);
//		return responseWorkAssigned;
//	}
//
//	// http://localhost:8072/task-service/task/worker
//	@PostMapping("/task/worker")
//	ResponseEntity<String> unAssignWorkToWorker(@RequestBody Worker worker) {
//		taskService.unAssignWorkToWorker(worker);
//		ResponseEntity<String> responseWorkUnAssigned = new ResponseEntity<String>("work UnAssigned", HttpStatus.OK);
//		return responseWorkUnAssigned;
//	}
//
//	// http://localhost:8072/task-service/task/maintenanceId/100
//	@GetMapping("/task/maintenanceId/{maintenanceId}")
//	ResponseEntity<Task> getByMaintenanceId(@PathVariable("maintenanceId") int maintenanceId) {
//		Task task = taskService.getByMaintenanceId(maintenanceId);
//		ResponseEntity<Task> responseByMaintenanceId = new ResponseEntity<Task>(task, HttpStatus.OK);
//		return responseByMaintenanceId;
//	}
//
//	// http://localhost:8072/task-service/task/organiser/Navin/status/INPROGRESS
//	@GetMapping("/task/organiser/{organiser}/tStatus/{tStatus}")
//	ResponseEntity<Task> getByOrganiserAndStatus(@PathVariable("organiser") String organiser,
//			@PathVariable("tStatus") Status tStatus) {
//		Task task = taskService.getByOrganiserAndStatus(organiser, tStatus);
//		ResponseEntity<Task> responseByOrganiserAndStatus = new ResponseEntity<Task>(task, HttpStatus.OK);
//		return responseByOrganiserAndStatus;
//	}
//
//	// http://localhost:8072/task-service/task/tStartDate/2021-10-01/tEndDate/2021-10-10
//	@GetMapping("/task/tStartDate/{tStartDate}/tEndDate/{tEndDate}")
//	ResponseEntity<List<Task>> getByTaskStartDateAndEndDate(@PathVariable("tStartDate") String tStartDate,
//			@PathVariable("tEndDate") String tEndDate) {
//		LocalDate sDate = LocalDate.parse(tStartDate);
//		LocalDate eDate = LocalDate.parse(tEndDate);
//		List<Task> taskByStartDateAndEndDate = taskService.getByTaskStartDateAndEndDate(sDate, eDate);
//		ResponseEntity<List<Task>> responseByStartDateAndEndDate = new ResponseEntity<List<Task>>(
//				taskByStartDateAndEndDate, HttpStatus.OK);
//		return responseByStartDateAndEndDate;
//	}
//
//	// ************************workerPart***************************************************
//
//	// http://localhost:8072/task-service/work
//	@GetMapping("/work")
//	ResponseEntity<List<Worker>> allWorkerList() {
//		List<Worker> allWorkerList = taskService.allWorkerList();
//		ResponseEntity<List<Worker>> responseByAllWorkerList = new ResponseEntity<List<Worker>>(allWorkerList,
//				HttpStatus.OK);
//		return responseByAllWorkerList;
//	}
//
//	// http://localhost:8072/task-service/work/avl/NA
//	@GetMapping("/work/avl/{availability}")
//	ResponseEntity<List<Worker>> getByAvailability(@PathVariable("availability") String availability)
//			throws WorkerNotFoundException {
//		List<Worker> availableWorkers = taskService.getByAvailability(availability);
//		ResponseEntity<List<Worker>> responseAvailableWorkerList = new ResponseEntity<List<Worker>>(availableWorkers,
//				HttpStatus.OK);
//		return responseAvailableWorkerList;
//	}
//
//	// http://localhost:8072/task-service/work/workerName/Ram
//	@GetMapping("/work/workerName/{workerName}")
//	ResponseEntity<Worker> getByWorkerName(@PathVariable("workerName") String workerName) {
//		Worker worker = taskService.getByWorkerName(workerName);
//		ResponseEntity<Worker> responseByName = new ResponseEntity<Worker>(worker, HttpStatus.OK);
//		return responseByName;
//	}
//
//	// http://localhost:8072/task-service/work/status/NA/workType/InteriorPainting
//	@GetMapping("/work/status/{status}/workType/{workType}")
//	ResponseEntity<Worker> getByStatusAndWorkType(@PathVariable("status") String status,
//			@PathVariable("workType") String workType) {
//		Worker worker = taskService.getByStatusAndWorkType(status, workType);
//		ResponseEntity<Worker> responseByStatusAndType = new ResponseEntity<Worker>(worker, HttpStatus.OK);
//		return responseByStatusAndType;
//	}
//
//	// http://localhost:8072/task-service/work/workDuration/8/workType/InteriorPainting
//	@GetMapping("/work/workDuration/{workDuration}/workType/{workType}")
//	ResponseEntity<Worker> getByDurationAndWorkType(@PathVariable("workDuration") int workDuration,
//			@PathVariable("workType") String workType) {
//		Worker worker = taskService.getByDurationAndWorkType(workDuration, workType);
//		ResponseEntity<Worker> responseByDurationAndType = new ResponseEntity<Worker>(worker, HttpStatus.OK);
//		return responseByDurationAndType;
//	}
//
	// http://localhost:8072/task-service/work/303
	@GetMapping("/work/{workerId}")
	ResponseEntity<Worker> getByWorkerId(@PathVariable("workerId") int workerId) throws WorkerNotFoundException {
		Worker worker = taskService.getByWorkerId(workerId);
		ResponseEntity<Worker> responseByWorkerId = new ResponseEntity<Worker>(worker, HttpStatus.OK);
		return responseByWorkerId;
	}

}
