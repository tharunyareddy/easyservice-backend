package com.easyservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.easyservice.exception.IdNotFoundException;
import com.easyservice.exception.WorkerNotFoundException;
import com.easyservice.model.Contract;
import com.easyservice.model.Worker;

@Service
public interface IWorkerService {
	
	Worker addWorker(Worker worker);
	
	void deleteById(int workerId) throws IdNotFoundException;
	
	Worker getUpdate(Worker worker);
	
	List<Worker> getAllWorkers();
	
	Worker getById(int workerId) throws IdNotFoundException;
	
//	Worker getByWorkerName(String workerName) throws WorkerNotFoundException;
//	
//	Worker getByStatusAndWorkType(String status, String workType) throws WorkerNotFoundException;
//
//	Worker getByDurationAndWorkType(int workDuration, String workType) throws WorkerNotFoundException;
//	
	List<Worker> getByAvailability(String availability) throws WorkerNotFoundException;
	
}
