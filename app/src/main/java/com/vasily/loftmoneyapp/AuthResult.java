package com.vasily.loftmoneyapp;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthResult extends Result {
    public int id;

    @Expose
    @SerializedName("auth_token")
    public String authToken;

}

