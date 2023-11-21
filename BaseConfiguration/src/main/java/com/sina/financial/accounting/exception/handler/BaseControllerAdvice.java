package com.sina.financial.accounting.exception.handler;

import com.sina.financial.accounting.exception.ApplicationException;
import com.sina.financial.accounting.exception.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class BaseControllerAdvice {

    @Autowired
    MessageSource messageSource;

    public BaseControllerAdvice() {
    }


    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException applicationException) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.toString(), "", "", "", "");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> allRuntimeErrors(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        List<String> errors = bindingResult.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        FieldError fieldError = ex.getFieldError();

        var now = LocalDateTime.now();
        var statusCode = HttpStatus.BAD_REQUEST.value() + "";
        var errorCode = getErrorCode(fieldError);
        var message = getErrorMessage(errorCode);
        var path = "";

        ErrorResponse errorResponse = new ErrorResponse( now, statusCode, errorCode, message, path, errors);
        // Return a ResponseEntity with the error response and appropriate HTTP status
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private String getErrorMessage(String errorCode) {
       try {
           if (StringUtils.hasText(errorCode)) {
               return messageSource.getMessage(errorCode, null, Locale.US);
           }
       }catch (Exception ex) {
           return errorCode;
       }
       return errorCode;
    }

    private String getErrorCode(FieldError fieldError) {
        String errorCode = fieldError.getDefaultMessage();
        if (StringUtils.hasText(errorCode)) {
           return errorCode.replace("{", "").replace("}", "");
        }
        return "";
    }

}
