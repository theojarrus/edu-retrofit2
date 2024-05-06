package com.example.retrofitapp.data.retrofit;

import com.example.retrofitapp.data.api.CoffeeApi;

public class CoffeeApiSingleton {

    private static CoffeeApi instance;

    public static CoffeeApi getInstance() {
        if (instance == null) instance = RetrofitSingleton.getInstance().create(CoffeeApi.class);
        return instance;
    }
}
