package com.example.ab_mvvm;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ab_mvvm.ViewModels.RandomViewModel;
import com.example.ab_mvvm.ViewModels.RandomViewModel2;

public class CountDownActivity extends AppCompatActivity {

    TextView textcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_count_down);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textcount=findViewById(R.id.textcount);

        RandomViewModel2 randomViewModel= new ViewModelProvider(this).get(RandomViewModel2.class);

        randomViewModel.getCount().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                textcount.setText(aLong+"");
            }
        });
        randomViewModel.getCounterfinish().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textcount.setText(s);
            }
        });
    }
}