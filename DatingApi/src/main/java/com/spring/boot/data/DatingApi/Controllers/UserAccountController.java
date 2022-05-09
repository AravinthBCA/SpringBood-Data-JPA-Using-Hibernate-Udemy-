package com.spring.boot.data.DatingApi.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.data.DatingApi.Entities.Interest;
import com.spring.boot.data.DatingApi.Entities.UserAccount;
import com.spring.boot.data.DatingApi.Repos.InterestRepository;
import com.spring.boot.data.DatingApi.Repos.UserAccountRepository;

@RestController
@RequestMapping("/api")
public class UserAccountController {

	@Autowired
	UserAccountRepository userRepo;
	
	@Autowired
	InterestRepository interestRepo;
	
	@PostMapping("/register-user")
	public UserAccount registerUser(@RequestBody UserAccount userAccount) {
		return userRepo.save(userAccount);
	}
	
	@PostMapping("/interests/update")
	public Interest updateInterest(@RequestBody Interest interest) {
		UserAccount userAccount = userRepo.findById(interest.getUserAccountId()).get();
		List<Interest> interestList = (List<Interest>) interestRepo.findByUserAccountUserId(userAccount.getId());
		
		interestRepo.deleteAll((Iterable<? extends Interest>) interestList);
		interest.setUserAccount(userAccount);
		return interestRepo.save(interest);
	}
	
	@GetMapping("/users/get/all")
	public List<UserAccount> getUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/user/interest/{id}")
	public List<Interest> interestUserFind(@PathVariable("id") int id){
		return (List<Interest>) interestRepo.sample(id);
	}
	
	@DeleteMapping("/users/delete/{interestId}")
	public void deleteInterest(@PathVariable("interestId") int id) {
		interestRepo.deleteById(id);
	}
	
	@GetMapping("/users/matches/{id}")
	public List<UserAccount> findMatches(@PathVariable("id") int id){
		UserAccount userAccount = userRepo.findById(id).get();
		return userRepo.findMatches(userAccount.getAge(), userAccount.getCity(),
				userAccount.getCountry());
	}
}





