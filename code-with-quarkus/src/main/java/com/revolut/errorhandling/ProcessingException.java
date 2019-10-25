package com.revolut.errorhandling;

public class ProcessingException extends Exception{

    private static final long serialVersionUID = -5086618644518815430L;
	private String message;
    private int httpStatus;

    public ProcessingException(String message,int httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ProcessingException(String message,int httpStatus,Throwable ex){
        initCause(ex);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
