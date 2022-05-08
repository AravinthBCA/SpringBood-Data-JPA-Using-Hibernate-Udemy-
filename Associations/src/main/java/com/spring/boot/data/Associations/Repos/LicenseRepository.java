package com.spring.boot.data.Associations.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.Associations.OTO.Entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
