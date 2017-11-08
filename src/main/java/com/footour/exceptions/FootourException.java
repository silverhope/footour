package com.footour.exceptions;

import org.springframework.http.HttpStatus;

public class FootourException extends Exception {
    private static final long serialVersionUID = -142579660147925451L;

    private  String message;
    private HttpStatus status;

    public FootourException() { super(); }

    public FootourException(String message) {
        super();
        this.message = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public FootourException(String message, HttpStatus status) {
        super();
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
