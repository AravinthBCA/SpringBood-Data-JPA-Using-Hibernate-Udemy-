package com.spring.boot.data.FileData.Entities.Repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.FileData.Entities.Image;

public interface ImageRepository extends CrudRepository<Image , Long> {

}
