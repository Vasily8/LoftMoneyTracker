package com.vasily.loftmoneyapp;


import com.google.gson.annotations.SerializedName;

public class BalanceResult {
    @SerializedName("total_expenses")
    public long totalExpenses;
    @SerializedName("total_income")
    public long totalIncome;

}



