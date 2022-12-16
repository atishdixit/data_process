package com.data;

public class Result {
    private String name;
    private String email;
    private String PhoneNumber;
    private String status;
    private String message;

    public Result(String name, String email, String phoneNumber, String status, String message) {
        this.name = name;
        this.email = email;
        PhoneNumber = phoneNumber;
        this.status = status;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + name +" email= " + email +" PhoneNumber=" + PhoneNumber+ " status=" + status +" message=" + message;
    }
}
