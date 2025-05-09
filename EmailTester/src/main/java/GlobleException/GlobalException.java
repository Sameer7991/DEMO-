package GlobleException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice

public class GlobalException {

		
		
	    // ✅ Handles validation errors triggered by @Valid in DTOs
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ExceptionDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
	        List<String> errors = ex.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .map(error -> error.getField() + ": " + error.getDefaultMessage())
	                .collect(Collectors.toList());

	        ExceptionDTO apiError = new ExceptionDTO(
	                HttpStatus.BAD_REQUEST.value(),
	                "Validation Failed",
	                LocalDateTime.now(),
	                errors
	        );

	        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	    }

	    
	    
	    // ✅ Handles business logic failures or known runtime errors (e.g., email failed to send)
	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<ExceptionDTO> handleRuntimeException(RuntimeException ex) {
	    	ExceptionDTO error = new ExceptionDTO(
	                HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                "Internal Server Error",
	                LocalDateTime.now(),
	                Collections.singletonList(ex.getMessage())
	        );
	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    
	    
	    // ✅ Fallback for any other unhandled exceptions
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ExceptionDTO> handleGenericException(Exception ex) {
	    	ExceptionDTO error = new ExceptionDTO(
	                HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                "Unexpected Error",
	                LocalDateTime.now(),
	                Collections.singletonList(ex.getMessage())
	        );
	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    
	}
