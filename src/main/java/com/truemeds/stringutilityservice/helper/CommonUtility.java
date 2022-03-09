package com.truemeds.stringutilityservice.helper;

import com.truemeds.stringutilityservice.domain.CommonResponse;

public class CommonUtility {
		
	public static CommonResponse getCommonResponse(String message, String statusCode, boolean isSuccess) {
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setSuccess(false);
		commonResponse.setMessage(message);
		commonResponse.setStatusCode(statusCode);
		return commonResponse;
	}
}
