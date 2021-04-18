package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                }
            }
        });
    }
}