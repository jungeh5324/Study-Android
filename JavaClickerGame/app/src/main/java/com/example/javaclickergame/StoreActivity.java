package com.example.javaclickergame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class StoreActivity extends AppCompatActivity {
    public static int money1 = 0; // 가지고 있는 돈
    public static int clickMoney1 = 5000; // 터치했을 때 들어오는 돈
    public static int autoMoney1 = 0;
    public static double price = 50; // 업그레이드 1 가격
    public static double price1 = 300; // 업그레이드 2 가격
    private final int num = 1; // 업그레이드 1을 했을 때 터치했을 때 돈의 올라가는 비율

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        TextView haveMoney; // 가지고 있는 돈을 보여줄 TextView를 haveMoney로 생성
        TextView priceMoney = (TextView) findViewById(R.id.priceText1);
        TextView priceMoney1 = (TextView) findViewById(R.id.priceText2);
        Context context = getApplicationContext(); // 돈이 없을 때 띄울 토스트 메세지를 위한 Context를 생성
        Button backButton1 = (Button) findViewById(R.id.backButton); // 터치했을 때 MainActivity 로 이동하는 버튼을 backButton1 로 선언
        Button upgradeButton1 = (Button) findViewById(R.id.clickUpgrade); // 터치했을 때 업그레이드1이 되는 버튼을 upgradeButton1로 선언
        Button upgradeButton2 = (Button) findViewById(R.id.timeUpgrade); // 터치했을 때 업그레이드2이 되는 버튼을 upgradeButton2로 선언
        StoreActivity.money1 = MainActivity.money; // StoreActivity의 money1을 MaINAcitivity의 money과 연결
        haveMoney = findViewById(R.id.haveMoney); // 가지고 있는 돈을 띄워줄 haveMoney를 xml파일의 haveMoney와 연결
        String money = String.valueOf(money1); // money1을 string으로 변환
        clickMoney1 = MainActivity.clickMoney; // StoreActivity의 clickMoney1를 MaINAcitivity의 clickMoney와 연결
        haveMoney.setText(money); // haveMoney의 텍스트를 money로 setText
        priceMoney.setText((int) price+"");
        priceMoney1.setText((int)price1+"");
        CharSequence text = "돈이 부족합니다";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,text,duration);
        TimerTask autoMoneyTimer = new TimerTask() {
            @Override
            public void run() {
                money1 = autoMoney1 + money1;
            }
        };
        Timer timer = new Timer();
        timer.schedule(autoMoneyTimer,0,1000);
        backButton1.setOnClickListener(new View.OnClickListener() { // backButton을 터치하면 MainAcitivity로 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                autoMoneyTimer.cancel();
                finish();
            }
        });
        upgradeButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("money1", String.valueOf(money1));
                if (money1 >= price) { // 가지고 있는 돈이 업그레이드 가격보다 크거나 같다
                    money1 = money1 - (int)price; // 가지고 있는 돈에서 업그레이드 가격만큼 차감
                    Log.d("clickMoney1", String.valueOf(clickMoney1));
                    clickMoney1 = clickMoney1 + num; // // 터치 했을 때 들어오는 돈에 num(1.1) 곱
                    haveMoney.setText(String.valueOf(money1)); // 가지고 있는 돈 변경
                    price = price * 1.3;
                    Math.floor(price);
                    priceMoney.setText((int) price+"");
                } else if (money1 < price) {// 만약 가지고 있는 돈이 부족하다면 토스트 메세지 출력
                    Log.d("price", String.valueOf(price));
                    toast.show();
                }
            }
        });
        upgradeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money1>=price1){
                    money1 = money1 - (int)price1;
                    autoMoney1 = autoMoney1 + num;
                    haveMoney.setText(String.valueOf(money1));
                    price1 = price1 * 1.3;
                    Math.floor(price1);
                    priceMoney1.setText((int)price1+"");
                } else if(money1 < price1){
                    toast.show();
                }
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
                                haveMoney.setText(money1+"");
                            }
                        });
                    }
                    catch (InterruptedException e){

                    }
            }
        })).start();
    }
}