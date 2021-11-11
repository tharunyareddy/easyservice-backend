/**
 *
 */
package com.easyservice.exception;

/**
 * @author TharunyaREDDY
 *
 */
import java.time.LocalDateTime;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.easyservice.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Method not allowed";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Invalid media type";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status.value()).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "path variable is missing  ";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Requesting parameter is missing ";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Type mismatch";
		ApiErrors errors = new ApiErrors(timestamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	// Custom Exceptions

	@ExceptionHandler(ContractNotFoundException.class)
	protected ResponseEntity<Object> handleContractNotFound(ContractNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Contractor not available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);

	}

	@ExceptionHandler(MaintenanceNotFoundException.class)
	protected ResponseEntity<Object> handleMaintenanceNotFound(MaintenanceNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timestamp = LocalDateTime.now();
		String error = "Maintenance not available";
		ApiErrors errors = new ApiErrors(timestamp, message, HttpStatus.CONFLICT.value(), error);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);

	}

}
