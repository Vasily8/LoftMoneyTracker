package com.vasily.loftmoneyapp;

public class Result {
    public String status;
    public boolean isSuccess() {
        return status.equals("success");
    }
}


