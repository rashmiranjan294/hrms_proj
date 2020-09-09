/*
 * Copyright 2020 ONPASSIVE AI Company 
 * All Rights Reserved.
 * No portions of this source code or the resulting compiled program may be
 * used without express written consent and licensing by ONPASSIVE
 */

package com.onpassive.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onpassive.hrms.model.Employee;

/**
 * This is the repository for employee entity.
 * 
 * @author Rashmiranjan
 *
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value="select * from Employee e where e.email_id=:emailId",nativeQuery=true)
	Employee findEmpByEmail(@Param("emailId") String emailId);
	
}
