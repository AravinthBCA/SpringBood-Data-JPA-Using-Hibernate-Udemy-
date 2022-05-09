package com.spring.boot.data.DatingApi.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.data.DatingApi.Entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

	@Query("from UserAccount where age=:age and city=:city and country=:country")
	List<UserAccount> findMatches(@Param("age") int age,@Param("city") String city,@Param("country") String country);
	
}
