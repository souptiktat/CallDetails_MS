package com.infosys.infytel.calldetails.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infytel.calldetails.dto.CallDetailsDTO;
import com.infosys.infytel.calldetails.service.CallDetailsService;

@RestController
@EnableAutoConfiguration
public class CallDetailsController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CallDetailsService callDetailsService;
	
	@RequestMapping(value = "/customers/{calledBy}", method =RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCallDetails(@PathVariable("calledBy") Long calledBy, @RequestBody CallDetailsDTO callDetailsDTO) {
		logger.info("Creation request for customer {} with data {}" , calledBy, callDetailsDTO);
		callDetailsService.saveCallDetails(callDetailsDTO);
	}
	
	@RequestMapping(value = "/customers/{calledBy}", method =RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Long> getSpecificCallDetails(@PathVariable("calledBy") Long calledBy) {
		logger.info("Creation request for customer {} with data" , calledBy);
		return callDetailsService.getSpecificCallDetails(calledBy);
	}
}