package com.epages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.TOO_MANY_REQUESTS, reason="No more food") 
public class OutOfFoodException extends Exception {

}
