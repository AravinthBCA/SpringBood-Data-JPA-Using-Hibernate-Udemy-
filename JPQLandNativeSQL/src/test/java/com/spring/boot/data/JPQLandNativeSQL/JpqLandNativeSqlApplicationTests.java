package com.spring.boot.data.JPQLandNativeSQL;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import com.mysql.cj.Session;
import com.spring.boot.data.JPQLandNativeSQL.Entities.Student;
import com.spring.boot.data.JPQLandNativeSQL.Repos.StudentRepository;

@SpringBootTest
class JpqLandNativeSqlApplicationTests {

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	EntityManager entityManager;
	
//	@Test
	void testStudentCreate() {
		Student student1 = new Student();
		student1.setFirstName("John");
		student1.setLastName("Cena");
		student1.setScore(99);
		
		Student student2 = new Student();
		student2.setFirstName("Roman");
		student2.setLastName("Reigns");
		student2.setScore(99);
		
		studentRepo.save(student1);
		studentRepo.save(student2);
	}
	
//	@Test
	public void testFindAllStudents() {
		System.out.println(studentRepo.findAllStudents(PageRequest.of(0,2,Sort.Direction.DESC,"id")));
	}
	
//	@Test
	public void findAllStudentsPartialData() {
		List<Object[]> partialData = studentRepo.findAllStudentsPartialData();
		for (Object[] objects : partialData) {
			System.out.println(objects[0]);
			System.out.println(objects[0]);
		}
	}
	
//	@Test
	public void testFindAllStudentsByFirstName() {
		System.out.println(studentRepo.findAllStudentsByFirstName("John"));
	}
	
//	@Test
	public void testFindAllStudnetByScores() {
		System.out.println(studentRepo.findStudentsForGivenScores(70,99));
	}
	
//	@Test
	@Transactional
	@Rollback(false)  // why use this annotation means you run test method after finishing it
                     //	 rollbacked all data so u need turnof the rollback then it reflect your db              
	public void testDeleteStudentsByFirstName() {
		studentRepo.deleteStudentsByFirstName("Roman");
	}
	
//	@Test
	public void testGetStudentById() {
	System.out.println(studentRepo.findByIdIn(Arrays.asList(1L,3L,5L),PageRequest.of(0, 2,Sort.Direction.DESC,"id")));
	}
	
//	@Test
	public void testFindAllStudentNQ() {
	System.out.println(studentRepo.findAllStudentNQ());
	}
	
//	@Test
	public void testFindByFirstNameNQ() {
	System.out.println(studentRepo.findByFirstNQ("John"));
	}
	
//	@Test
//	@Transactional // this annotation it maintain the cache
	public void testCaching() {
		Session session = entityManager.unwrap(Session.class);
		Student student = studentRepo.findById(5L).get();
		studentRepo.findById(5L).get();
//		session.evict(student);
		studentRepo.findById(5L).get();
	}
	
	@Test
	public void testFindAllProducts() {
		System.out.println(studentRepo.findAllProducts());
	}
	
	@Test
	public void findAllProductByPrice() {
		System.out.println(studentRepo.findAllProductByPrice(89));
	}

	@Test
	public void findAllProductsCountByPrice() {
		System.out.println(studentRepo.findAllProductsCountByPrice(89));
	}


}
