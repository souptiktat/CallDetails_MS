package com.infosys.infytel.calldetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.infytel.calldetails.entity.CallDetails;

@Repository
public interface CallDetailsRepository extends JpaRepository<CallDetails, Integer>{

	List<CallDetails> getByCalledBy(Long calledBy);
}
