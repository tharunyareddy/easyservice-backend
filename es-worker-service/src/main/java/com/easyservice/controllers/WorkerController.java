package com.easyservice.controllers;

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

import com.easyservice.exception.IdNotFoundException;
import com.easyservice.exception.WorkerNotFoundException;
import com.easyservice.model.Worker;
import com.easyservice.service.IWorkerService;

@RestController
@RequestMapping("/work-service")
//@CrossOrigin("http://localhost:4200")
public class WorkerController {

	@Autowired
	IWorkerService workService;
	
	

	// http://localhost:8073/work-service/work/workerName/Ram
//	@GetMapping("/work/workerName/{workerName}")
//	ResponseEntity<Worker> getByWorkerName(@PathVariable("workerName") String workerName)
//			throws WorkerNotFoundException {
//		Worker worker = workService.getByWorkerName(workerName);
//		ResponseEntity<Worker> responsebyWorkerName = new ResponseEntity<Worker>(worker, HttpStatus.OK);
//		return responsebyWorkerName;
//	}
//
//	// http://localhost:8073/work-service/work/status/NA/workType/InteriorPainting
//	@GetMapping("/work/status/{status}/workType/{workType}")
//	ResponseEntity<Worker> getByStatusAndWorkType(@PathVariable("status") String status,
//			@PathVariable("workType") String workType) throws WorkerNotFoundException {
//		Worker worker = workService.getByStatusAndWorkType(status, workType);
//		ResponseEntity<Worker> responsebyStatusAndWorkType = new ResponseEntity<Worker>(worker, HttpStatus.OK);
//		return responsebyStatusAndWorkType;
//	}

//	// http://localhost:8073/work-service/work/workDuration/8/workType/InteriorPainting
//	@GetMapping("/work/workDuration/{workDuration}/workType/{workType}")
//	ResponseEntity<Worker> getByDurationAndWorkType(@PathVariable("workDuration") int workDuration,
//			@PathVariable("workType") String workType) throws WorkerNotFoundException {
//		Worker worker = workService.getByDurationAndWorkType(workDuration, workType);
//		ResponseEntity<Worker> responsebyDurationAndWorkType = new ResponseEntity<Worker>(worker, HttpStatus.OK);
//		return responsebyDurationAndWorkType;
//	}

	@DeleteMapping("/work/{workerId}")
	ResponseEntity<String> deleteById(@PathVariable("workerId") int workerId) throws IdNotFoundException {
		workService.deleteById(workerId);
		ResponseEntity<String> responseDeleteDetails = new ResponseEntity<String>("worker details deleted",
				HttpStatus.OK);
		return responseDeleteDetails;
	}

	// http://localhost:8073/work-service/work/300
	@GetMapping("/work/{workerId}")
	ResponseEntity<Worker> getById(@PathVariable("workerId") int workerId) throws IdNotFoundException {
		Worker workerById = workService.getById(workerId);
		ResponseEntity<Worker> responseGetById = new ResponseEntity<Worker>(workerById, HttpStatus.OK);
		return responseGetById;
	}

	// http://localhost:8073/work-service/work
	@GetMapping("/work")
	ResponseEntity<List<Worker>> getAllWorkers() {
		List<Worker> allWorkerList = workService.getAllWorkers();
		ResponseEntity<List<Worker>> responseAllWorkerList = new ResponseEntity<List<Worker>>(allWorkerList,
				HttpStatus.OK);
		return responseAllWorkerList;
	}

	// http://localhost:8073/work-service/work/availability/Available
	@GetMapping("/work/availability/{availability}")
	ResponseEntity<List<Worker>> getByAvailability(@PathVariable("availability") String availability)
			throws WorkerNotFoundException {
		List<Worker> availableWorkers = workService.getByAvailability(availability);
		ResponseEntity<List<Worker>> responseAvailableWorkerList = new ResponseEntity<List<Worker>>(availableWorkers,
				HttpStatus.OK);
		return responseAvailableWorkerList;
	}

	// http://localhost:8073/work-service/work
	@PutMapping("/work")
	ResponseEntity<String> getUpdate(@RequestBody Worker worker) {
		workService.getUpdate(worker);
		ResponseEntity<String> responseUpdate = new ResponseEntity<String>("worker details updated", HttpStatus.OK);
		return responseUpdate;
	}
	
	// http://localhost:8073/work-service/work
	@PostMapping("/work")
	ResponseEntity<String> addWorker(@RequestBody Worker worker) {
	    workService.addWorker(worker);
	    ResponseEntity<String> response = new ResponseEntity<String>("worker details added", HttpStatus.OK);
		return response;
	}


}
