package com.truemeds.stringutilityservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.truemeds.stringutilityservice.domain.FormattedStringResponse;
import com.truemeds.stringutilityservice.entity.NewTableEntity;
import com.truemeds.stringutilityservice.exceptions.DataNotFoundInEntityException;
import com.truemeds.stringutilityservice.helper.CommonUtility;
import com.truemeds.stringutilityservice.service.DatabaseServiceImpl;
import com.truemeds.stringutilityservice.service.StringFormatServiceImpl;

@RestController("/format")
public class FetchDataController {
	
	@Autowired
	private StringFormatServiceImpl formatService;
	
	@Autowired
	private DatabaseServiceImpl databaseService;
	
	@GetMapping("/string/{id}")
	public ResponseEntity<FormattedStringResponse> fetchStrings(@PathVariable String id){
		
		Long rowid = Long.valueOf(id);
		String inputString = "";
		FormattedStringResponse  response = new FormattedStringResponse(); 
		try {
			 inputString = databaseService.getStringById(rowid);
			 response = formatService.calculateStepsForStringFormat(inputString);
			 NewTableEntity entity = populateNewTableEntity(response);
			 databaseService.saveNewTableEntity(entity);
		}catch (DataNotFoundInEntityException e) {
			response.setServiceData(CommonUtility.getCommonResponse("No data present for this id", "404", false));
		}catch(Exception e) {
			response.setServiceData(CommonUtility.getCommonResponse("Exception occured while operation", "500", false));
		}
		return ResponseEntity.ok().body(response);
	}
	
	// This code should go to helper class.
	private NewTableEntity populateNewTableEntity(FormattedStringResponse response) {
		NewTableEntity entity = new NewTableEntity();
		entity.setCount(response.getNumberOfSteps());
		entity.setFinalOutput(response.getFormattedString());
		entity.setName("Parikshit Hooda");
		return entity;
	}
	
	
}
