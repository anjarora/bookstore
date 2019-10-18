package com.project.bookstore.Model;

public class BookingServiceSuccessResponse {

    private String successMessage;

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public BookingServiceSuccessResponse(String successMessage) {
        this.successMessage = successMessage;
    }
}
