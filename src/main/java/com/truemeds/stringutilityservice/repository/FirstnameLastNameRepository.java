package com.truemeds.stringutilityservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.truemeds.stringutilityservice.entity.NewTableEntity;

@Repository
public interface FirstnameLastNameRepository extends CrudRepository<NewTableEntity, Long> {

}
