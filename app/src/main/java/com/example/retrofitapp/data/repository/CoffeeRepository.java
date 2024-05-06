package com.example.retrofitapp.data.repository;

import com.example.retrofitapp.data.retrofit.CoffeeApiSingleton;
import com.example.retrofitapp.domain.entity.Coffee;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CoffeeRepository {

    public static Single<List<Coffee>> getCoffee(String category) {
        return CoffeeApiSingleton.getInstance()
                .getCoffee(category)
                .subscribeOn(Schedulers.io());
    }

    public static Single<List<Coffee>> getCoffeeByName(String category, String name) {
        return CoffeeApiSingleton.getInstance()
                .getCoffee(category)
                .map(coffees ->
                        coffees.stream()
                                .filter(coffee -> coffee.title.contains(name))
                                .collect(Collectors.toList())
                )
                .subscribeOn(Schedulers.io());
    }
}
