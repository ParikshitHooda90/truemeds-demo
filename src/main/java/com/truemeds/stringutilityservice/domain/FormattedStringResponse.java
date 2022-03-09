package com.truemeds.stringutilityservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FormattedStringResponse {
	private String formattedString;
	private Integer numberOfSteps;
	private CommonResponse serviceData;
	
	public String getFormattedString() {
		return formattedString;
	}
	public void setFormattedString(String formattedString) {
		this.formattedString = formattedString;
	}
	public CommonResponse getServiceData() {
		return serviceData;
	}
	public void setServiceData(CommonResponse serviceData) {
		this.serviceData = serviceData;
	}
	public Integer getNumberOfSteps() {
		return numberOfSteps;
	}
	public void setNumberOfSteps(Integer numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}
	
}
