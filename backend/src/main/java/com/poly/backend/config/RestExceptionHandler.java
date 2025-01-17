package com.poly.backend.config;

import com.poly.backend.dto.ErrorDTO;
import com.poly.backend.exception.AppUnCheckedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { AppUnCheckedException.class })
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(AppUnCheckedException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ErrorDTO.builder().message(ex.getMessage()).build());
    }
}