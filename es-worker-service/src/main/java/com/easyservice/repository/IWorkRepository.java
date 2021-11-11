package com.easyservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.easyservice.exception.WorkerNotFoundException;
import com.easyservice.model.Worker;



@Repository
public interface IWorkRepository extends JpaRepository<Worker,Integer>{
	
//	Worker findByWorkerName(String workerName);
//	
//	@Query(value = "select * from worker where w_status=?1 and work_type=?2", nativeQuery = true)
//	Worker findByWStatusAndWorkType(String status, String workType) throws WorkerNotFoundException;
//	
//	@Query(value = "select * from worker where work_duration=?1 and work_type=?2", nativeQuery = true)
//	Worker findByDurationAndWorkType(int workDuration, String workType) throws WorkerNotFoundException;
//	
	@Query(value = "select * from worker where availability=?1", nativeQuery = true)
	List<Worker> findByAvailability(String availability);

}
