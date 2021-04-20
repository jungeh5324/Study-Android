package com.example.javaclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    public static int money = 0;  // 가지고 있는 돈
    public static int clickMoney = 5000;  // 터치했을 때 들어오는 돈
    public static int autoMoney = 0;
    public static double price2;
    public static double price3;
    SoundPool soundPool; // 효과음
    int soundID; // 효과음
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.money = StoreActivity.money1; // MainActivity의 money를 StoreAcitivity의 money1과 연결
        MainActivity.clickMoney = StoreActivity.clickMoney1; // MainActivity의 clcikMoney를 StoreAcitivity의 clcikMoney1과 연결
        MainActivity.autoMoney = StoreActivity.autoMoney1;
        TextView moneyView = (TextView)findViewById(R.id.textView); // 가지고 있는 돈을 출력할 moneyView 만들기
        MainActivity.price2 = StoreActivity.price;
        MainActivity.price3 = StoreActivity.price1;
        TextView clickMoneyView = findViewById(R.id.clickMoney);
        TextView autoMoneyView = findViewById(R.id.autoMoney);
        clickMoneyView.setText("터치당 : "+clickMoney);
        autoMoneyView.setText("1초당 : "+autoMoney);
        ImageView coinImage = findViewById(R.id.coinImage);
        moneyView.setText(money+""); // moneyView를 money로 setText
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0); // 효과음
        soundID = soundPool.load(this, R.raw.coinsound, 1); // 효과음
        ImageButton moneyButton1 = (ImageButton) findViewById(R.id.moneyButton); // 눌렀을 때 돈이 들어오는 버튼을 moneyButton1 로 선언
        CharSequence text = "50원 달성 !";
        int duration = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context,text,duration);
        TimerTask autoMoneyTimer = new TimerTask() {
            @Override
            public void run() {
                money = autoMoney + money;
            }
        };
        Timer timer = new Timer();
        timer.schedule(autoMoneyTimer,0,1000);
        moneyButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money = (int) (money + clickMoney); // moneyButton을 터치하면 가지고 있는 돈 money에 터치했을 때 들어오는 돈 clickMoney를 더함.
                soundPool.play(soundID, 1f, 1f, 0, 0, 1f); // moneyButton을 터치하면 효과음이 출력 됨.
                moneyView.setText(money+"");
                if(money == 50){
                    toast.show();
                }
                if(money >= 10000){
                    coinImage.setImageResource(R.drawable.onewon);
                }
            }
        });
        Button storeButton1 = (Button) findViewById(R.id.storeButton); // 눌렀을 때 StoreActivity로 이동하는 버튼을 storeButton1 로 선언
        storeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StoreActivity.class); // intent로 두 class를 연결
                startActivity(intent);
                autoMoneyTimer.cancel();
                finish();
            }
        });
        (new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted())
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                moneyView.setText(money+"");
                            }
                        });
                    }
                catch (InterruptedException e){

                }
            }
        })).start();
    }
}