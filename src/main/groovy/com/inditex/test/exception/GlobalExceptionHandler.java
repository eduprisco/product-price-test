package com.inditex.test.exception;

import com.inditex.test.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<ErrorResponse> handleValidationErrors(Exception ex, WebRequest request) {

        logger.error("{}", ex.getMessage());
        ex.printStackTrace();

        ErrorResponse response = new ErrorResponse(ex.getMessage(), request.getSessionId());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({AmbiguityException.class, Exception.class})
    public ResponseEntity<ErrorResponse> handleAmiguityExceptionsAndAllOthers(Exception ex, WebRequest request) {

        logger.error("{}", ex.getMessage());
        ex.printStackTrace();

        ErrorResponse response = new ErrorResponse(ex.getMessage(), request.getSessionId());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundErrors(Exception ex, WebRequest request) {

        logger.error("{}", ex.getMessage());
        ex.printStackTrace();

        ErrorResponse response = new ErrorResponse(ex.getMessage(), request.getSessionId());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

}
