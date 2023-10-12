package com.globallogic.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorInfo> IdNotFoundException(IdNotFoundException ex, WebRequest web)
    {
        ErrorInfo info=new ErrorInfo();
        info.setTimeStamp(LocalDateTime.now());
        info.setStatus(HttpStatus.NOT_FOUND);
        info.setMsg(ex.getMsg());
        info.setPath(web.getDescription(false));
return new ResponseEntity<>(info,HttpStatus.NOT_FOUND);
    }
}
