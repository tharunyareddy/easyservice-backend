/**
 *
 */
package com.easyservice.repository;

/**
 * @author TharunyaREDDY
 *
 */
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.easyservice.exception.MaintenanceNotFoundException;
import com.easyservice.model.Contract;
import com.easyservice.model.Maintenance;
import com.easyservice.model.Priority;
import com.easyservice.model.Status;

@Repository
public interface IContractorRepository extends JpaRepository<Contract, Integer> {

	// contractor

	//Contract findByContractId(Integer contractId);

	Contract findByContractName(String contractName);

	@Query("from Contract c where c.cStatus=?1")
	List<Contract> findByStatus(Status cStatus);

	@Query("from Contract c where c.cPriority=?1")
	List<Contract> findByPriority(Priority cPriority);

//	Contract findByContractorName(String contractorName);
//
//	List<Contract> findByStartDate(LocalDate startDate);
//
//	List<Contract> findByEndDate(LocalDate endDate);

//	@Query("from Contractor c where c.startDate=?1 and c.endDate=?2")
//	List<Contract> findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
//
//	@Query("from Maintenance m inner join m.contractor c where c.contractName=?1")
//	List<Maintenance> findMaintenanceByContractName(String contractName);
//
//	@Query("from Maintenance m inner join m.contractor c where c.contractorName=?1")
//	List<Maintenance> findMaintenanceByContractorName(String contractorName);
//
//	@Query("from Contractor c inner join c.maintenanceList m where m.maintenanceManager=?1")
//	List<Contract> findContractNameByMaintenanceManager(String maintenanceManager);
//
//	@Query("from Contractor c inner join c.maintenanceList m where m.maintenanceName=?1")
//	List<Contract> findContractsByMaintenanceName(String maintenanceName);

	@Query("from Maintenance m inner join m.contractor c where c.contractId=?1")
//	@Query(value="select * from maintenance m inner join contract c where m.contractId = c.contractId",nativeQuery = true)
	List<Maintenance> findMaintenanceByContractId(int contractId) throws MaintenanceNotFoundException;
}
