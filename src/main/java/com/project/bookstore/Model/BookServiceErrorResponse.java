package com.project.bookstore.Model;


public class BookServiceErrorResponse {

    private String errorDescription;
    private String detailErrorMessage;

    public BookServiceErrorResponse() {

    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getDetailErrorMessage() {
        return detailErrorMessage;
    }

    public void setDetailErrorMessage(String detailErrorMessage) {
        this.detailErrorMessage = detailErrorMessage;
    }

}
