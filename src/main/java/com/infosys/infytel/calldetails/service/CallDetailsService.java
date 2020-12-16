package com.infosys.infytel.calldetails.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.infytel.calldetails.dto.CallDetailsDTO;
import com.infosys.infytel.calldetails.entity.CallDetails;
import com.infosys.infytel.calldetails.repository.CallDetailsRepository;

@Service
public class CallDetailsService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CallDetailsRepository callRepo;
	
	public void saveCallDetails(CallDetailsDTO callDetailsDTO) {
		logger.info("Creation request for call details {}" , callDetailsDTO);
		CallDetails callDetails = callDetailsDTO.createCallDetails();
		callRepo.save(callDetails);
	}
	
	public List<Long> getSpecificCallDetails(Long calledBy) {
		List<Long> callDetailsList = new ArrayList<>();
		List<CallDetails> callDetails = callRepo.getByCalledBy(calledBy);
		for(CallDetails callDetail : callDetails) {
			callDetailsList.add(callDetail.getCalledBy());
		}
		return callDetailsList;
	}

}