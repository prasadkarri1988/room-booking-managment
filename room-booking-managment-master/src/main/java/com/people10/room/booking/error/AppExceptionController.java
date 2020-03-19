package com.people10.room.booking.error;

import java.util.Date;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionController {

	@ExceptionHandler(NoRecordsException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(NoRecordsException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(new Date(), Integer.valueOf(1000), ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookingException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(BookingException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(new Date(), Integer.valueOf(1001), ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(HttpMessageNotReadableException ex) {
		// logger.error("Exception HttpMessageNotReadableException :: {} ",
		// ex.getMessage());
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(Integer.valueOf(1002));
		error.setErrorDesc(ex.getMessage());
		error.setTimestamp(new Date());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		// logger.error("Exception HttpMessageNotReadableException :: {} ",
		// ex.getMessage());
		// Get all errors
		Optional<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.reduce((i, j) -> i + " , " + j);

		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(Integer.valueOf(1002));
		error.setErrorDesc(errors.map(i -> i).orElse(null));
		error.setTimestamp(new Date());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
