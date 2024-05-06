package com.example.retrofitapp.feature.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.retrofitapp.R;
import com.example.retrofitapp.databinding.ActivityMainBinding;
import com.example.retrofitapp.feature.presentation.MainViewModel;
import com.example.retrofitapp.feature.presentation.Status;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.coffeeList.observe(this, coffees -> binding.field.setText(coffees.toString()));
        viewModel.status.observe(this, this::handleStatus);
        binding.button.setOnClickListener(v -> onButtonClick());
    }

    private void handleStatus(Status status) {
        switch (status) {
            case LOADING:
                updateButtonVisibility(false);
                break;
            case ERROR:
                binding.field.setText(R.string.error);
                updateButtonVisibility(true);
                break;
            case CONTENT:
                updateButtonVisibility(true);
                break;
        }
    }

    private void updateButtonVisibility(Boolean isButtonVisible) {
        binding.button.setVisibility(isButtonVisible ? View.VISIBLE : View.INVISIBLE);
        binding.progress.setVisibility(isButtonVisible ? View.GONE : View.VISIBLE);
    }

    private void onButtonClick() {
        String filter = binding.filter.getText().toString().trim();
        viewModel.loadCoffeeList("hot", filter);
    }
}
