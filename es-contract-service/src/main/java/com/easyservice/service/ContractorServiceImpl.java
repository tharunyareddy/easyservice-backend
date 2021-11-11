/**
 *
 */
package com.easyservice.service;

/**
 * @author TharunyaREDDY
 *
 */
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.easyservice.exception.ContractNotFoundException;
import com.easyservice.exception.MaintenanceNotFoundException;
import com.easyservice.model.Contract;
import com.easyservice.model.Maintenance;
import com.easyservice.model.Priority;
import com.easyservice.model.Status;
import com.easyservice.repository.IContractorRepository;

@Service
public class ContractorServiceImpl implements IContractorService {

	RestTemplate restTemplate;

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	private static final String BASEURL = "http://localhost:8071/maintenance-service/maintenance";

	@Autowired
	IContractorRepository contractorRepository;

	// ********************************************Contractor**************************************

	// To Add the Contract
	@Override
	public Contract addContractor(Contract contractor) {
		return contractorRepository.save(contractor);
	}

	// To Update the Contract Details
	@Override
	public String updateContractor(Contract contractor) {
		contractorRepository.save(contractor);
		return "Contract Updated Successfully";
	}

	// To Delete the Contract By Contract Id
	@Override
	public String deleteContractor(int contractId) throws ContractNotFoundException {
		Contract contractor = contractorRepository.findById(contractId).get();
		if (contractor == null) {
			throw new ContractNotFoundException("Contract Id Not Found,Invalid ContractId");
		}
		contractorRepository.deleteById(contractId);
		return "Contract Deleted Succesfully";
	}

	// Retrieving Contract By Contract Id
	@Override
	public Contract getByContractId(int contractId) throws ContractNotFoundException {

		Contract contract = contractorRepository.findById(contractId).get();
		if (contract == null) {
			throw new ContractNotFoundException("Contract Not Found,Invalid ContractId");
		}
		return contract;
	}

	// Retrieving All Contracts
	@Override
	public List<Contract> getAllContracts() {
		List<Contract> allContracts = contractorRepository.findAll();
		return allContracts;

	}

	// Retrieving Contract By maintenance Manager Name
//	@Override
//	public List<Contract> getContractNameByMaintenanceManager(String maintenanceManager)
//			throws ContractNotFoundException {
//		String url = BASEURL + "/maintenanceManager/" + maintenanceManager;
//		List<Contract> contractList = contractorRepository.findContractNameByMaintenanceManager(maintenanceManager);
//
//		if (contractList.isEmpty()) {
//			throw new ContractNotFoundException("Contract Not Found,Invalid Manager Name");
//		}
//
//		return contractList;
//	}

	// Retrieving Contract By maintenance Name like cleaning,painting etc
//	@Override
//	public List<Contract> getContractsByMaintenanceName(String maintenanceName) throws ContractNotFoundException {
//
//		String url = BASEURL + "/maintenanceName/" + maintenanceName;
//		List<Contract> contractList = contractorRepository.findContractsByMaintenanceName(maintenanceName);
//		if (contractList.isEmpty()) {
//			throw new ContractNotFoundException("Contract Not Found,Invaild Maintenance Name");
//		}
//		return contractList;
//	}
//
	// Retrieving Contract By Contract Name
	@Override
	public Contract getByContractName(String contractName) throws ContractNotFoundException {

		Contract contractByName = contractorRepository.findByContractName(contractName);
		if (contractByName == null) {
			throw new ContractNotFoundException("Contract Name Not Found");
		}
		return contractByName;
	}

//	// Retrieving Contract By Contractor Name
//	@Override
//	public Contract getByContractorName(String contractorName) throws ContractNotFoundException {
//
//		Contract contractorByName = contractorRepository.findByContractorName(contractorName);
//		if (contractorByName == null) {
//			throw new ContractNotFoundException("Contract Not Found,Invalid Contractor Name");
//		}
//		return contractorByName;
//	}
//
//	// Retrieving Contract By Start Date
//	@Override
//	public List<Contract> getByStartDate(LocalDate startDate) throws ContractNotFoundException {
//
//		List<Contract> contractByStartDate = contractorRepository.findByStartDate(startDate);
//		if (contractByStartDate.isEmpty()) {
//			throw new ContractNotFoundException("Contract Not Found,Invalid Start Date");
//		}
//		return contractByStartDate;
//
//	}
//
//	// Retrieving Contract By End Date
//	@Override
//	public List<Contract> getByEndDate(LocalDate endDate) throws ContractNotFoundException {
//
//		List<Contract> contractByEndDate = contractorRepository.findByEndDate(endDate);
//		if (contractByEndDate.isEmpty()) {
//			throw new ContractNotFoundException("Contract Not Found,Invalid End Date");
//		}
//		return contractByEndDate;
//
//	}
//
//	// Retrieving Contract By Start Date and End Date
//	@Override
////	public List<Contract> getByStartDateAndEndDate(LocalDate startDate, LocalDate endDate)
////			throws ContractNotFoundException {
////
////		List<Contract> contractByStartDateAndEndDate = contractorRepository.findByStartDateAndEndDate(startDate,
////				endDate);
////		if (contractByStartDateAndEndDate.isEmpty()) {
////			throw new ContractNotFoundException("Contract Not Found,Invalid Dates");
////		}
////		return contractByStartDateAndEndDate;
////	}

	// Retrieving Contracts By Maintenance
	@Override
	public List<Contract> getByContractStatus(Status cStatus) throws ContractNotFoundException {
		List<Contract> contractByStatus = contractorRepository.findByStatus(cStatus);
		if (contractByStatus.isEmpty()) {
			throw new ContractNotFoundException("Contract Not Found,Invalid Dates");
		}
		return contractByStatus;
	}

	@Override
	public List<Contract> getByContractPriority(Priority cPriority) throws ContractNotFoundException {
		List<Contract> contractByPriority = contractorRepository.findByPriority(cPriority);
		if (contractByPriority.isEmpty()) {
			throw new ContractNotFoundException("Contract Not Found,Invalid Dates");
		}
		return contractByPriority;
	}

	// ***************************************Maintenance***************************************

	@Override
	public Maintenance getByMaintenanceId(int maintenanceId) throws MaintenanceNotFoundException {
		String url = BASEURL + '/' + maintenanceId;
		Maintenance maintenance = restTemplate.getForEntity(url, Maintenance.class).getBody();
		if (maintenance == null) {
			throw new MaintenanceNotFoundException("Maintenance Not Found,Invalid Maintenance Id");
		}
		return maintenance;
	}

	// Assigning Maintenance to the Contract
	@Override
	public String assignMaintenance(int maintenanceId, int contractId) {
		Contract contractor = getByContractId(contractId);
		Maintenance maintenance = getByMaintenanceId(maintenanceId);
		System.out.println(contractor);
		System.out.println(maintenance);
		maintenance.setContractor(contractor);
		System.out.println(contractor);
		System.out.println(maintenance);
		return "assigned";
	}

	// Un-Assigning the maintenance to the contract
	@Override
	public void unAssignMaintenance(Maintenance maintenance) {

		String url = BASEURL;
		restTemplate.put(url, maintenance);
	}

	// Retrieving Maintenance By Maintenance Id

	// Retrieving All Maintenances
	@Override
	public List<Maintenance> getAllMaintenance() {
		String url = BASEURL;
		ResponseEntity<List> maintenanceList = restTemplate.getForEntity(url, List.class);
		return maintenanceList.getBody();
	}

	// Retrieving Maintenance By Contract Name
//	@Override
//	public List<Maintenance> getMaintenanceByContractName(String contractName) throws MaintenanceNotFoundException {
//		String url = BASEURL + "/contractName/" + contractName;
//		List<Maintenance> maintenanceList = contractorRepository.findMaintenanceByContractName(contractName);
//
//		if (maintenanceList.isEmpty()) {
//			throw new MaintenanceNotFoundException("Maintenance Not Found,Invalid Contract Name");
//		}
//
//		return maintenanceList;
//	}

	// Retrieving Maintenance By Contractor Name
//	@Override
//	public List<Maintenance> getMaintenanceByContractorName(String contractorName) throws MaintenanceNotFoundException {
//		String url = BASEURL + "/contractorName/" + contractorName;
//		List<Maintenance> maintenanceList = contractorRepository.findMaintenanceByContractorName(contractorName);
//
//		if (maintenanceList.isEmpty()) {
//			throw new MaintenanceNotFoundException("Maintenance Not Found,Invalid Contractor Name");
//		}
//
//		return maintenanceList;
//	}

	// Retrieving Maintenance By Maintenance Name
//	@Override
//	public Maintenance getByMaintenanceName(String maintenanceName) throws MaintenanceNotFoundException {
//		String url = BASEURL + "/maintenanceName/" + maintenanceName;
//		Maintenance maintenance = restTemplate.getForEntity(url, Maintenance.class).getBody();
//		if (maintenance == null) {
//			throw new MaintenanceNotFoundException("Maintenance Name Not Found");
//		}
//		return maintenance;
//	}

	// Retrieving Maintenance By Maintenance Manager
//	@Override
//	public Maintenance getByMaintenanceManager(String maintenanceManager) throws MaintenanceNotFoundException {
//		String url = BASEURL + "/maintenanceManager/" + maintenanceManager;
//		Maintenance maintenance = restTemplate.getForEntity(url, Maintenance.class).getBody();
//		if (maintenance == null) {
//			throw new MaintenanceNotFoundException("Maintenance Manager Not Found");
//		}
//		return maintenance;
//	}
//
//	// Retrieving Maintenance By Maintenance Start Date
//	@Override
//	public List<Maintenance> getByMaintenanceStartDate(LocalDate mStartDate) throws MaintenanceNotFoundException {
//		String url = BASEURL + "/maintenanceStartDate/" + mStartDate;
//		ResponseEntity<List> maintenanceList = restTemplate.getForEntity(url, List.class);
//		if (maintenanceList.getBody().isEmpty()) {
//			throw new MaintenanceNotFoundException("Maintenance Not Found,Invalid Start Date");
//		}
//		return maintenanceList.getBody();
//	}

	// Retrieving Maintenance By Maintenance End Date
//	@Override
//	public List<Maintenance> getByMaintenanceEndDate(LocalDate mEndDate) throws MaintenanceNotFoundException {
//		String url = BASEURL + "/maintenanceEndDate/" + mEndDate;
//		ResponseEntity<List> maintenanceList = restTemplate.getForEntity(url, List.class);
//		if (maintenanceList.getBody().isEmpty()) {
//			throw new MaintenanceNotFoundException("Maintenance Not Found,Invalid End Date");
//		}
//		return maintenanceList.getBody();
//	}
//
	// Retrieving Maintenance By Maintenance Status
	@Override
	public List<Maintenance> getByMaintenanceStatus(Status mStatus) throws MaintenanceNotFoundException {
		String url = BASEURL + "/maintenanceStatus/" + mStatus;
		ResponseEntity<List> maintenanceList = restTemplate.getForEntity(url, List.class);
		if (maintenanceList.getBody().isEmpty()) {
			throw new MaintenanceNotFoundException("Maintenance Not Found");
		}
		return maintenanceList.getBody();
	}

	// Retrieving Maintenance By Maintenance Priority
	@Override
	public List<Maintenance> getByMaintenancePriority(Priority mPriority) throws MaintenanceNotFoundException {
		String url = BASEURL + "/maintenancePriority/" + mPriority;
		ResponseEntity<List> maintenanceList = restTemplate.getForEntity(url, List.class);
		if (maintenanceList.getBody().isEmpty()) {
			throw new MaintenanceNotFoundException("Maintenance Not Found");
		}
		return maintenanceList.getBody();
	}

	@Override
	public List<Maintenance> getMaintenanceByContractId(int contractId) throws MaintenanceNotFoundException {
return contractorRepository.findMaintenanceByContractId(contractId);
	   

	}

//	// Retrieving Maintenance By Start Date and End Date
//	@Override
//	public List<Maintenance> getByMaintenanceStartAndEndDate(LocalDate mStartDate, LocalDate mEndDate)
//			throws MaintenanceNotFoundException {
//		String url = BASEURL + "/maintenanceStartDate/" + mStartDate + "/maintenanceEndDate/" + mEndDate;
//		ResponseEntity<List> maintenanceList = restTemplate.getForEntity(url, List.class);
//		if (maintenanceList.getBody().isEmpty()) {
//			throw new MaintenanceNotFoundException("Maintenance Not Found");
//		}
//		return maintenanceList.getBody();
//	}
//
//	// Retrieving Maintenance By Status and Priority
//	@Override
//	public List<Maintenance> getByMaintenanceStatusAndPriority(Status mStatus, Priority mPriority)
//			throws MaintenanceNotFoundException {
//		String url = BASEURL + "/maintenanceStatus/" + mStatus + "/maintenancePriority/" + mPriority;
//		ResponseEntity<List> maintenanceList = restTemplate.getForEntity(url, List.class);
//		if (maintenanceList.getBody().isEmpty()) {
//			throw new MaintenanceNotFoundException("Maintenance Not Found");
//		}
//		return maintenanceList.getBody();
//	}
//
//	// Retrieving Maintenance By Maintenance Name and Status
//	@Override
//	public Maintenance getByMaintenanceNameAndStatus(String maintenanceName, Status mStatus)
//			throws MaintenanceNotFoundException {
//		String url = BASEURL + "/maintenanceName/" + maintenanceName + "/maintenanceStatus/" + mStatus;
//		Maintenance maintenance = restTemplate.getForEntity(url, Maintenance.class).getBody();
//		if (maintenance == null) {
//			throw new MaintenanceNotFoundException("Maintenance Not Found");
//		}
//		return maintenance;
//	}
//
//	// Retrieving Maintenance By Maintenance Name and Priority
//	@Override
//	public Maintenance getByMaintenanceNameAndPriority(String maintenanceName, Priority mPriority)
//			throws MaintenanceNotFoundException {
//		String url = BASEURL + "/maintenanceName/" + maintenanceName + "/maintenancePriority/" + mPriority;
//		Maintenance maintenance = restTemplate.getForEntity(url, Maintenance.class).getBody();
//		if (maintenance == null) {
//			throw new MaintenanceNotFoundException("Maintenance Not Found");
//		}
//		return maintenance;
//	}

}
