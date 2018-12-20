package com.honeybadger.graymarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*The APIs will throw exceptions if the request is not valid or some unexpected situation occurs.
*/
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {

	 public AppException(String message) {
	        super(message);
	    }

	    public AppException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
