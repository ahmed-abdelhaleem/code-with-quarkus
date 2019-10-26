package com.quarkus.errorhandling;

public class ErrorResponse {

    private int errorCode;
    private String errorMessage;
    private String description;
    private String transactionId;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorMessage, String description) {
        this.errorMessage = errorMessage;
        this.description = description;
    }
    public ErrorResponse( String errorMessage, String description, String transactionId) {
        this.errorMessage = errorMessage;
        this.description = description;
        this.transactionId = transactionId;
    }
    public ErrorResponse(int errorCode, String errorMessage, String description, String transactionId) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.description = description;
        this.transactionId = transactionId;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
