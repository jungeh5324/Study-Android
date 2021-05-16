package com.example.psychologytest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    MainFragment fragment1;
    ExplanationFragment fragment2;
    SelectionFragment fragment3;
    ResultFragment1 result1;
    ResultFragment2 result2;
    ResultFragment3 result3;
    ResultFragment4 result4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new MainFragment();
        fragment2 = new ExplanationFragment();
        fragment3 = new SelectionFragment();
        result1 = new ResultFragment1();
        result2 = new ResultFragment2();
        result3 = new ResultFragment3();
        result4 = new ResultFragment4();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment1).commit();
    }
    public void onFragmentChange(int index){
        if(index==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
        }
        else if(index==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
        }
        else if(index==2){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
        }
        else if(index==3){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,result1).commit();
        }
        else if(index==4){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,result2).commit();
        }
        else if(index==5){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,result3).commit();
        }
        else if(index==6){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,result4).commit();
        }
    }
}