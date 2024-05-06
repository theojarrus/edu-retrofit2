package com.example.retrofitapp.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static final String BASE_URL = "http://api.sampleapis.com";
    private static Retrofit instance;

    private static HttpLoggingInterceptor createLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(Level.BODY);
        return interceptor;
    }

    private static OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(createLoggingInterceptor())
                .build();
    }

    private static GsonConverterFactory createGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    private static RxJava3CallAdapterFactory createRxJavaCallAdapterFactory() {
        return RxJava3CallAdapterFactory.create();
    }

    private static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .client(createOkHttpClient())
                .addConverterFactory(createGsonConverterFactory())
                .addCallAdapterFactory(createRxJavaCallAdapterFactory())
                .baseUrl(BASE_URL)
                .build();
    }

    public static Retrofit getInstance() {
        if (instance == null) instance = createRetrofit();
        return instance;
    }
}
