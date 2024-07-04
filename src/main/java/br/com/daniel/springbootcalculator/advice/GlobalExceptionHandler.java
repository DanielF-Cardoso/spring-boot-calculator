package br.com.daniel.springbootcalculator.advice;

import br.com.daniel.springbootcalculator.exceptions.DivisionByZeroException;
import br.com.daniel.springbootcalculator.exceptions.InvalidNumberException;
import br.com.daniel.springbootcalculator.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "Not Found",
                "The requested resource was not found - Error code: 404",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidNumberException.class)
    public ResponseEntity<ErrorResponse> handleInvalidNumberException(InvalidNumberException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "Invalid Input",
                ex.getMessage() + " - Error Code: " + ex.getErrorCode(),
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DivisionByZeroException.class)
    public ResponseEntity<ErrorResponse> handleDivisionByZeroException(DivisionByZeroException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "Division Error",
                ex.getMessage() + " - Error Code: " + ex.getErrorCode(),
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}