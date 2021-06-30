package com.example.aboutlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameLayout extends AppCompatActivity {
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        ImageView off = (ImageView)findViewById(R.id.off);
        ImageView on = (ImageView)findViewById(R.id.on);
        Button btn = (Button)findViewById(R.id.starButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageIndex ==0){
                    off.setVisibility(View.VISIBLE);
                    on.setVisibility(View.INVISIBLE);
                    imageIndex = 1;
                }
                else if(imageIndex ==1){
                    off.setVisibility(View.INVISIBLE);
                    on.setVisibility(View.VISIBLE);
                    imageIndex = 0;
                }
            }
        });
    }
}.