package com.example.dogdictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainFragment fragment1;
    SpeciesFragment fragment2;
    Context context;
    public static SharedPreferences preferences;
    @Override
    public void onBackPressed(){
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        for( Fragment fragment : fragmentList){
            if(fragment instanceof onBackPressedListener){
                ((onBackPressedListener)fragment).onBackPressed();
                return;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new MainFragment();
        fragment2 = new SpeciesFragment();
        preferences = getPreferences(MODE_PRIVATE);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_is,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out).add(R.id.container,fragment1).commit();

    }
    public void onFragmentChange(int index){
        if(index==0){
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_is,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out).replace(R.id.container,fragment1).commit();
        }
        else if(index==1){
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_is,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out).replace(R.id.container,fragment2).commit();
        }
    }
}