package com.infosys.infytel.calldetails.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "calldetails")
@Data
public class CallDetails {

	@Id
	@Column(name = "id", nullable = false)
	Integer id;
	
	@Column(name = "called_by", nullable = false)
	Long calledBy;
	
	@Column(name = "called_to", nullable = false)
	Long calledTo;
	
	@Column(name = "called_on", nullable = false)
	Date calledOn;
	
	@Column(name = "duration", nullable = false)
	Integer duration;
}
