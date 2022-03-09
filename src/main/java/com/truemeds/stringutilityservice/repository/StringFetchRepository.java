package com.truemeds.stringutilityservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.truemeds.stringutilityservice.entity.InputDetailsEntity;

public interface StringFetchRepository extends CrudRepository<InputDetailsEntity, Long> {
	 
}
