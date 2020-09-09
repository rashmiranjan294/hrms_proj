package com.onpassive.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onpassive.hrms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query(value="select * from User u where user_name=:userName and user_password=:encodedPassword",nativeQuery=true)
	User login(@Param("userName") String user_name,@Param("encodedPassword") String encodedPassword);


}
