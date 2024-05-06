package com.example.retrofitapp.feature.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitapp.data.repository.CoffeeRepository;
import com.example.retrofitapp.domain.entity.Coffee;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Status> _status = new MutableLiveData<>();
    public LiveData<Status> status = _status;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private final MutableLiveData<List<Coffee>> _coffeeList = new MutableLiveData<>();
    public LiveData<List<Coffee>> coffeeList = _coffeeList;

    public void loadCoffeeList(String category, String name) {
        _status.setValue(Status.LOADING);
        compositeDisposable.add(
                CoffeeRepository.getCoffeeByName(category, name).subscribe(list -> {
                    _coffeeList.postValue(list);
                    _status.postValue(Status.CONTENT);
                }, throwable -> {
                    throwable.printStackTrace();
                    _status.postValue(Status.ERROR);
                })
        );
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
