package com.example.exchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    public int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DecimalFormat formatter = new DecimalFormat("###,###");
        EditText dollarText = findViewById(R.id.dollar);
        TextView exchangeView = findViewById(R.id.exchangeView);
        Button exchangeButton = findViewById(R.id.exchangeButton);
        exchangeButton.setOnClickListener(v -> {
            if (dollarText.getText().length() == 0) {
                Toast.makeText(getApplicationContext(), "$를 입력해주세요", Toast.LENGTH_SHORT).show();
            } else if (dollarText.getText().length() > 0) {
                int num = Integer.parseInt(dollarText.getText().toString());
                count = num * 1114;
                String ret = formatter.format(count);
                exchangeView.setText(ret+"원");
                Toast.makeText(getApplicationContext(), ret + "원입니다", Toast.LENGTH_SHORT).show();
            }

        });
    }
}