package com.truemeds.stringutilityservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.truemeds.stringutilityservice.domain.FormattedStringResponse;
import com.truemeds.stringutilityservice.helper.CommonUtility;


@Service
public class StringFormatServiceImpl {
	
	private static Logger LOGGER = LoggerFactory.getLogger(StringFormatServiceImpl.class);
	
	public FormattedStringResponse calculateStepsForStringFormat(String inputString) {
		FormattedStringResponse response = new FormattedStringResponse();
		
		try {
			inputString = inputString.replaceAll(" ", "");
			int i =0;
			int steps = 0;
			while(i < inputString.length() - 1) {
				LOGGER.debug("Checking string for duplicate chars, now string is: {}", inputString);
				if(inputString.charAt(i) == inputString.charAt(i+1)) {
					inputString = processDuplicateCharacters(i, inputString);
					steps++;
					LOGGER.debug("Replaced sequence of string, now string is: {}", inputString);
				}else {
					i++;
				}
				
			}
			LOGGER.info("Formatted string, count: {}, finalString is: {}",steps, inputString);
			response.setFormattedString(inputString);
			response.setNumberOfSteps(steps);
			response.setServiceData(CommonUtility.getCommonResponse("Successful request", "200", true));
		
		}catch(Exception e) {
			response.setServiceData(CommonUtility.getCommonResponse("Exception occured while operation", "500", false));
			LOGGER.error("Exception occured while formatting string", e);
		}
		 return response;
	}
	
	private String processDuplicateCharacters(int startIndex, String inputString) {
		StringBuilder builder = new StringBuilder(inputString);
		int endIndex = startIndex;
		int i = startIndex;
		while(inputString.charAt(i) == inputString.charAt(i+1) && i< inputString.length() -1 ) {
			i++;
		}
		endIndex = i;
		inputString = builder.replace(startIndex, endIndex, "").toString();
		return inputString;
	}
}
