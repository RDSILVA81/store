package com.company.store.controller;

import com.company.store.exception.ErrorResponse;
import com.company.store.exception.StoreException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class StoreExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StoreException.class)
    public ResponseEntity<Object> handleScheduleException(final StoreException exception, final WebRequest request) {
        var errorResponse = ErrorResponse.builder()
                .date(ZonedDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .message(exception.getMessage())
                .path(request != null ? ((ServletWebRequest)request).getRequest().getRequestURI():null)
                .build();
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
