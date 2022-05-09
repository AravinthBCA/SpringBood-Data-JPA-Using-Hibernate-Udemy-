package com.spring.boot.data.JPQLandNativeSQL.Repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.boot.data.JPQLandNativeSQL.Entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("from Student")
	List<Student> findAllStudents(Pageable pageable);
	
	@Query("select st.firstName,st.lastName from Student st")
	List<Object[]> findAllStudentsPartialData();
	
	@Query("from Student where firstName = :firstName") // : represented named query parameter
	List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

	@Query("from Student where score > :min and score <= :max")
	List<Student> findStudentsForGivenScores(@Param("min") int min,@Param("max") int max);

	@Modifying // why using this means every query in spring it consider select query,
              // non select query like(insert,delete,update,etc) use this annotations
	@Query("delete from Student where firstName = :firstName")
	void deleteStudentsByFirstName(@Param("firstName") String firstName);
	
	List<Student> findByIdIn(List<Long> list,Pageable pageable);
	
	@Query(value="select * from student",nativeQuery=true)
	List<Student> findAllStudentNQ();
	
	@Query(value="select * from student where fname=:firstName",nativeQuery=true)
	List<Student> findByFirstNQ(@Param("firstName") String firstName);
	
	@Query(value="CALL GetAllStudents",nativeQuery = true)
	List<Student> findAllProducts();
	
	@Query(value ="CALL  GetAllStudnetsByScore (:score_in)", nativeQuery = true)
	List<Student> findAllProductByPrice(double score_in);
	
	@Query(value = "CALL GetAllStudentsCountByScore (:score_in)", nativeQuery = true)
	int findAllProductsCountByPrice(double score_in);
}

