package com.vasily.loftmoneyapp;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @GET("auth")
    Call<AuthResult> auth(@Query("social_user_id") String userId);

    @GET("logout")
    Call<Result> logout();

    @GET("balance")
    Call<BalanceResult> getBalance();

    @GET("items")
    Call<ItemsResult> getItems(@Query("type") String type);

    @POST("items/add")
    Call<ItemsResult> addItem(@Query("price") String price, @Query("name") String name, @Query("type") String type);

    @POST("items/remove")
    Call<ItemsResult> removeItem(@Query("id") int id);

}


