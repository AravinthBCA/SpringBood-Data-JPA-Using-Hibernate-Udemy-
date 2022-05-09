package com.spring.boot.data.DatingApi.Repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.data.DatingApi.Entities.Interest;
import com.spring.boot.data.DatingApi.Entities.UserAccount;

public interface InterestRepository extends JpaRepository<Interest, Integer> {

	@Query(value="select * from interest where user_id=:userId",nativeQuery=true)
	List<Interest> sample(@Param("userId") int id);
	
	@Query(value="select * from interest where user_id=:id",nativeQuery=true)
	List<Interest> findByUserAccountUserId(@Param("id") int id);

}
