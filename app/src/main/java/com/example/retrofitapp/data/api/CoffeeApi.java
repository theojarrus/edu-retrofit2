package com.example.retrofitapp.data.api;

import com.example.retrofitapp.domain.entity.Coffee;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoffeeApi {

    // BASE_URL = https://api.sampleapis.com/category/example
    // @GET("coffee") - https://api.sampleapis.com/category/example/coffee
    // @GET("/coffee") - https://api.sampleapis.com/coffee

    // Argument - category
    // @Path("name") - https://api.sampleapis.com/category/
    // @Query("name") - https://api.sampleapis.com?name=value&name=value
    // @Field - for POST query

    @GET("coffee/{category}")
    Single<List<Coffee>> getCoffee(
            @Path("category")
            String category
            /*@Query("example")
            String example,
            @Query("param")
            String param*/
    );
}
