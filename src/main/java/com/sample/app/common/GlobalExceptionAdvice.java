package com.sample.app.common;

import com.sample.app.dto.ErrorResponseDTO;
import com.sample.app.exception.CustomerResourceNotFoundException;
import com.sample.app.exception.ResourceAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionAdvice extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger("Controller Advice Logger");

    @ExceptionHandler(value = { CustomerResourceNotFoundException.class })
    protected ResponseEntity<ErrorResponseDTO> handleConflict(CustomerResourceNotFoundException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(ex.getMessage(), ex.getErrorCode()));
    }

    @ExceptionHandler(value = { ResourceAlreadyExistException.class })
    protected ResponseEntity<ErrorResponseDTO> handleConflict(ResourceAlreadyExistException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseDTO(ex.getMessage(), ex.getErrorCode()));
    }
}