package com.vasily.loftmoneyapp;


import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class AuthResult implements Result {
    public String authToken;


    @Override
    public Status getStatus() {
        return null;
    }

}

