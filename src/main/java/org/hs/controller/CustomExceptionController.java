package org.hs.controller;

import org.hs.service.CustomExceptionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class CustomExceptionController {

	private CustomExceptionService customExceptionService;

	public CustomExceptionController(CustomExceptionService customExceptionService) {
		this.customExceptionService = customExceptionService;
	}
	
	@RequestMapping(value = {"/custom"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean getCustomException() {
		customExceptionService.throwCustomException();
		return true;
	}

}
