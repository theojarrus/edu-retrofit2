package com.example.retrofitapp.domain.entity;

import androidx.annotation.NonNull;

public class Coffee {
    public int id;
    public String title;
    public String description;

    @NonNull
    @Override
    public String toString() {
        return "Coffee = { id = " + id + ", title = " + title + ", description = " + description + "}";
    }
}
