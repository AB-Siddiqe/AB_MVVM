package com.example.ab_mvvm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {
    Animation top,bottom,left;

    TextView textView;
    ImageView imageView,imageView2;
    private long Splash;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView=findViewById(R.id.textView);
        imageView=findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView2);


        top= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottom=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        left=AnimationUtils.loadAnimation(this,R.anim.left_anim);

        imageView.setAnimation(top);
        textView.setAnimation(bottom);
        imageView2.setAnimation(left);



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,CountDownActivity.class));
                overridePendingTransition(R.anim.zoom_in,R.anim.static_animation);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.static_animation,R.anim.zoom_out);
            }
        });
    }
}