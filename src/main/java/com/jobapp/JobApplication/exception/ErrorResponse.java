package com.jobapp.JobApplication.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Collection;

public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime timeStamp;

    private Collection<?> details;
    private String error;
    private int status;
    private String code;
    private String message;

    public ErrorResponse(LocalDateTime timeStamp, Collection<?> details, String error, int status, String code, String message) {
        this.timeStamp = timeStamp;
        this.details = details;
        this.error = error;
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ErrorResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Collection<?> getDetails() {
        return details;
    }

    public void setDetails(Collection<?> details) {
        this.details = details;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
