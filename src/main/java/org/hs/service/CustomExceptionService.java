package org.hs.service;

import org.hs.exceptions.exceptions.CustomException;
import org.springframework.stereotype.Service;

@Service
public class CustomExceptionService {

	public void throwCustomException() {
		throw new CustomException("This is a reason for custom exception");
	}

}
