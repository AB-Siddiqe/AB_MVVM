package com.example.ab_mvvm.ViewModels;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class RandomViewModel extends ViewModel {
    int randomvalue;

    public RandomViewModel() {
        Random random = new Random();
        randomvalue=random.nextInt(100)+1;
    }

    public int getRandomvalue() {
        return randomvalue;
    }
}
