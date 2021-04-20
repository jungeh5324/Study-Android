package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.result);
        Button plusButton = findViewById(R.id.plusButton);
        Button minusButton = findViewById(R.id.minusButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divisionButton = findViewById(R.id.divisionButton);
        EditText firstNum = findViewById(R.id.firstNum);
        EditText secondNum = findViewById(R.id.secondNum);
        ImageView imageface = findViewById(R.id.imageface);
        imageface.setImageResource(0);
        plusButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNum.getText().length()==0||secondNum.getText().length()==0) {
                    Log.d("String","toast");
                    Toast.makeText(getApplicationContext(), "수를 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
                else if(firstNum.getText().length()>0&&secondNum.getText().length()>0){
                    int num1 = Integer.parseInt(firstNum.getText().toString());
                    int num2 = Integer.parseInt(secondNum.getText().toString());
                    result = num1 + num2;
                    textView.setText(result+"");
                    if(result<=9){
                        imageface.setImageResource(0);
                    }
                    if(result>=10){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_red);
                    }
                    if(result>=20){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_green);
                    }
                    if(result>=30){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_blue);
                    }
                }
            }
        });
        minusButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNum.getText().length()==0||secondNum.getText().length()==0) {
                    Toast.makeText(getApplicationContext(), "수를 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
                else if(firstNum.getText().length()>0&&secondNum.getText().length()>0){
                    int num1 = Integer.parseInt(firstNum.getText().toString());
                    int num2 = Integer.parseInt(secondNum.getText().toString());
                    result = num1 - num2;
                    textView.setText(result+"");
                    ImageView imageface = findViewById(R.id.imageface);
                    if(result<=9){
                        imageface.setImageResource(0);
                    }
                    if(result >= 10){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_red);
                    }
                    if(result>=20){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_green);
                    }
                    if(result>=30){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_blue);
                    }
                }
            }
        });
        multiplyButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNum.getText().length()==0||secondNum.getText().length()==0) {
                    Toast.makeText(getApplicationContext(), "수를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(firstNum.getText().length()>0&&secondNum.getText().length()>0){
                    int num1 = Integer.parseInt(firstNum.getText().toString());
                    int num2 = Integer.parseInt(secondNum.getText().toString());
                    result = num1 * num2;
                    textView.setText(result+"");
                    ImageView imageface = findViewById(R.id.imageface);
                    if(result<=9){
                        imageface.setImageResource(0);
                    }
                    if(result >= 10){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_red);
                    }
                    if(result>=20){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_green);
                    }
                    if(result>=30){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_blue);
                    }
                }
            }
        });
        divisionButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNum.getText().length()==0||secondNum.getText().length()==0) {
                    Toast.makeText(getApplicationContext(), "수를 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
                else if(firstNum.getText().length()>0&&secondNum.getText().length()>0){
                    int num1 = Integer.parseInt(firstNum.getText().toString());
                    int num2 = Integer.parseInt(secondNum.getText().toString());
                    result = num1 / num2;
                    textView.setText(result+"");
                    ImageView imageface = findViewById(R.id.imageface);
                    if(result<=9){
                        imageface.setImageResource(0);
                    }
                    if(result >= 10){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_red);
                    }
                    if(result>=20){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_green);
                    }
                    if(result>=30){
                        imageface.setImageResource(R.drawable.ic_baseline_mood_blue);
                    }
                }
            }
        });
    }
}