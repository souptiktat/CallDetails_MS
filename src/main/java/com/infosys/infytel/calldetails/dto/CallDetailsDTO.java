package com.infosys.infytel.calldetails.dto;

import java.util.Date;

import com.infosys.infytel.calldetails.entity.CallDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CallDetailsDTO {

	Integer id;
	Long calledBy;
	Long calledTo;
	Date calledOn;
	Integer duration;
	
	public static CallDetailsDTO valueOf(CallDetails callDetails) {
		CallDetailsDTO callDetailsDTO = new CallDetailsDTO();
		callDetailsDTO.setId(callDetails.getId());
		callDetailsDTO.setCalledBy(callDetails.getCalledBy());
		callDetailsDTO.setCalledOn(callDetails.getCalledOn());
		callDetailsDTO.setCalledTo(callDetails.getCalledTo());
		callDetailsDTO.setDuration(callDetails.getDuration());
		return callDetailsDTO;
	}
	
	public CallDetails createCallDetails() {
		CallDetails callDetails = new CallDetails();
		callDetails.setId(this.id);
		callDetails.setCalledBy(this.calledBy);
		callDetails.setCalledOn(this.calledOn);
		callDetails.setCalledTo(this.calledTo);
		callDetails.setDuration(this.duration);
		return callDetails;
	}
}
