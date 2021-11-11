package com.easyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyservice.exception.IdNotFoundException;
import com.easyservice.exception.WorkerNotFoundException;
import com.easyservice.model.Contract;
import com.easyservice.model.Worker;
import com.easyservice.repository.IWorkRepository;

@Service
public class WorkerServiceImpl implements IWorkerService {

	@Autowired
	IWorkRepository workRepository;

//	@Override
//	public Worker getByWorkerName(String workerName) throws WorkerNotFoundException {
//		Worker workerByWorkerName = workRepository.findByWorkerName(workerName);
//		if (workerByWorkerName == null) {
//			throw new WorkerNotFoundException("Worker Not Found with this Name");
//		}
//		return workerByWorkerName;
//	}
//
//	@Override
//	public Worker getByStatusAndWorkType(String status, String workType) throws WorkerNotFoundException {
//		Worker workerByStatusAndWorkType = workRepository.findByWStatusAndWorkType(status, workType);
//		if (workerByStatusAndWorkType == null) {
//			throw new WorkerNotFoundException("Worker Not Found with this workType");
//		}
//		return workerByStatusAndWorkType;
//	}
//
//	@Override
//	public Worker getByDurationAndWorkType(int workDuration, String workType) throws WorkerNotFoundException {
//		Worker workerByDurationAndWorkType = workRepository.findByDurationAndWorkType(workDuration, workType);
//		if (workerByDurationAndWorkType == null) {
//			throw new WorkerNotFoundException("Worker Not Found with this workType");
//		}
//		return workerByDurationAndWorkType;
//	}

	@Override
	public void deleteById(int workerId) throws IdNotFoundException {
		workRepository.deleteById(workerId);
	}

	@Override
	public Worker getById(int workerId) throws IdNotFoundException {
		return workRepository.findById(workerId).orElseThrow(() -> new IdNotFoundException("Worker Id Not found"));
	}

	@Override
	public List<Worker> getAllWorkers() {
		return workRepository.findAll();
	}

	@Override
	public List<Worker> getByAvailability(String availability) throws WorkerNotFoundException {
		List<Worker> allAvailableWorker = workRepository.findByAvailability(availability);
		if (allAvailableWorker.isEmpty()) {
			throw new WorkerNotFoundException("Workers not available");
		}
		return allAvailableWorker;
	}

	@Override
	public Worker getUpdate(Worker worker) {
		return workRepository.save(worker);
	}

	@Override
	public Worker addWorker(Worker worker) {
		return workRepository.save(worker);
	}
}
