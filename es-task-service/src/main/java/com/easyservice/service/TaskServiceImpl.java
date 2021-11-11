package com.easyservice.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.easyservice.exception.TaskNotFoundException;
import com.easyservice.exception.WorkerNotFoundException;
import com.easyservice.model.Status;
import com.easyservice.model.Task;
import com.easyservice.model.Worker;
import com.easyservice.repository.ITaskRepository;

@Service
@Transactional
public class TaskServiceImpl implements ITaskService {

	@Autowired
	RestTemplate restTemplate;

	private static final String BASEURL = "http://localhost:8073/work-service/work";

	@Autowired
	ITaskRepository taskRepository;

	@Override
	public Task addTask(Task task) {
		return taskRepository.save(task);

	}

	@Override
	public void deleteTask(int taskId) {
		taskRepository.deleteById(taskId);

	}

	@Override
	public void updateTask(Task task) {
		taskRepository.save(task);

	}

	@Override
	public Task getById(int taskId) {
		return taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task Id not Found"));
	}

	@Override
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}

	@Override
	public int assignTaskToMaintenance(int maintenanceId, int taskId) {
		return taskRepository.assignTask(maintenanceId, taskId);
	}
	@Override
	public int workerStatus(String availability, int workerId) {
		return taskRepository.workerStatus("Not-Available", workerId);
	}


	@Override
	public int assignTaskToWorker(int workerId, int taskId) {

		Worker worker = getByWorkerId(workerId);
		Task task = getById(taskId);
		task.setWorker(worker);
		taskRepository.workerStatus("Not-Available", workerId);
		// System.out.println(worker);
		return 0;

	}

//	@Override
//	public Task getByMaintenanceId(int maintenanceId) throws WorkerNotFoundException {
//		Task taskByMaintenanceId = taskRepository.findByMaintenanceId(maintenanceId);
//		if (taskByMaintenanceId == null) {
//			throw new WorkerNotFoundException("Id Not Found");
//		}
//		return taskByMaintenanceId;
//
//	}
//
//	@Override
//	public Task getByOrganiserAndStatus(String organiser, Status tStatus) throws TaskNotFoundException {
//		Task taskByOrganiserAndStatus = taskRepository.findByOrganiserAndTStatus(organiser, tStatus);
//		if (taskByOrganiserAndStatus == null) {
//			throw new TaskNotFoundException("Organiser Not Found");
//		}
//		return taskByOrganiserAndStatus;
//	}
//
//	@Override
//	public List<Task> getByTaskStartDateAndEndDate(LocalDate tStartDate, LocalDate tEndDate)
//			throws TaskNotFoundException {
//		List<Task> taskByTaskStartDateAndEndDate = taskRepository.findByTaskStartDateAndEndDate(tStartDate, tEndDate);
//		if (taskByTaskStartDateAndEndDate.isEmpty()) {
//			throw new TaskNotFoundException("Organiser Not Found");
//		}
//		return taskByTaskStartDateAndEndDate;
//	}
//
//	// Worker Table
//
//	@Override
//	public Worker getByWorkerName(String workerName) {
//		String url = BASEURL + "/workerName/" + workerName;
//		ResponseEntity<Worker> responseByWorkerName = restTemplate.getForEntity(url, Worker.class);
//		return responseByWorkerName.getBody();
//	}
//
//	@Override
//	public Worker getByStatusAndWorkType(String status, String workType) {
//		String url = BASEURL + "/status/" + status + "/workType/" + workType;
//		ResponseEntity<Worker> responseByStatusAndWorkType = restTemplate.getForEntity(url, Worker.class);
//		return responseByStatusAndWorkType.getBody();
//	}
//
//	@Override
//	public Worker getByDurationAndWorkType(int workDuration, String workType) {
//		String url = BASEURL + "/workDuration/" + workDuration + "/workType/" + workType;
//		ResponseEntity<Worker> responseByDurationAndWorkType = restTemplate.getForEntity(url, Worker.class);
//		return responseByDurationAndWorkType.getBody();
//	}
//
//	@Override
//	public List<Worker> allWorkerList() {
//		String url = BASEURL;
//		ResponseEntity<List> responseAllWorker = restTemplate.getForEntity(url, List.class);
//		return responseAllWorker.getBody();
//	}
//
//	@Override
//	public List<Worker> getByAvailability(String availability) throws WorkerNotFoundException {
//		String url = BASEURL + "/avl/" + availability;
//		ResponseEntity<List> responseWorkerByAvailability = restTemplate.getForEntity(url, List.class);
//		return responseWorkerByAvailability.getBody();
//	}
//
	@Override
	public Worker getByWorkerId(int workerId) throws WorkerNotFoundException {
		String url = BASEURL + "/" + workerId;
		ResponseEntity<Worker> responseByWorkerId = restTemplate.getForEntity(url, Worker.class);
		return responseByWorkerId.getBody();
	}
//
//	@Override
//	public Worker assignWorkToWorker(Worker worker, int taskId) {
//		Task task = taskRepository.findById(taskId).get();
//		worker.setTask(task);
//		worker.setwStatus("NA");
//		String url = BASEURL;
//		restTemplate.put(url, worker);
//		return worker;
//	}
//
//	@Override
//	public Worker unAssignWorkToWorker(Worker worker) {
//		String url = BASEURL;
//		worker.setwStatus("A");
//		restTemplate.put(url, worker);
//		return worker;
//	}


}
