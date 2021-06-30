package com.example.dogdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SpeciesClick extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_click);

        Intent intent = getIntent();
        ImageView dog = (ImageView)findViewById(R.id.dogImage);
        TextView title = (TextView)findViewById(R.id.dogTitle);
    }
}