package com.truemeds.stringutilityservice.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truemeds.stringutilityservice.entity.InputDetailsEntity;
import com.truemeds.stringutilityservice.entity.NewTableEntity;
import com.truemeds.stringutilityservice.exceptions.DataNotFoundInEntityException;
import com.truemeds.stringutilityservice.repository.FirstnameLastNameRepository;
import com.truemeds.stringutilityservice.repository.StringFetchRepository;

@Service
public class DatabaseServiceImpl {
	
	@Autowired StringFetchRepository stringRepository;
	@Autowired FirstnameLastNameRepository firstnameLastnaneRepository;
	
	public String getStringById(long id) {
		Optional<InputDetailsEntity> entityopt= stringRepository.findById(id);
		if(entityopt.isPresent()) {
			return entityopt.get().getData();
		}
		throw new DataNotFoundInEntityException();
	}
	
	public void saveNewTableEntity(NewTableEntity entity) {
		firstnameLastnaneRepository.save(entity);
	}
}
