package com.spring.boot.data.Associations.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.Associations.MTM.Entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer>{

}
