package com.globallogic.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {
    private LocalDateTime timeStamp;
    private HttpStatus status;
    private String msg;
    private String path;
}
