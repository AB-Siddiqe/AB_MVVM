package com.example.ab_mvvm.ViewModels;

import android.os.CountDownTimer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RandomViewModel2 extends ViewModel {

    MutableLiveData<Long> count=new MutableLiveData<>();

    public MutableLiveData<Long> getCount() {
        return count;
    }

    MutableLiveData<String> counterfinish=new MutableLiveData<>();

    public MutableLiveData<String> getCounterfinish() {
        return counterfinish;
    }

    public RandomViewModel2() {
        counterStart();

    }

    private void counterStart() {
        new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long l) {
                count.postValue(l/1000);
            }

            @Override
            public void onFinish() {
                counterfinish.postValue("Finished");

            }
        }.start();
    }
}
