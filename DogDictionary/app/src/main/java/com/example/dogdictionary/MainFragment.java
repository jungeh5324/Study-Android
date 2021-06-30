package com.example.dogdictionary;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.media.MediaExtractor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.preference.PreferenceManager;
import android.transition.TransitionInflater;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;


public class MainFragment extends Fragment implements onBackPressedListener{
    MainActivity activity;
    Context context;
    SharedPreferences preferences = MainActivity.preferences;
    Toast toast;
    long backKeyPressedTime;
    public static MediaPlayer mediaPlayer;
    Integer bgm=0;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        TransitionInflater inflater1 = TransitionInflater.from(requireContext());
        setExitTransition(inflater1.inflateTransition(R.transition.fade));
        ImageButton optionButton = (ImageButton) rootView.findViewById(R.id.optionButton);
        context = rootView.getContext();
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean tg = preferences.getBoolean("tg",true);
        if(tg==true) {
            mediaPlayer = MediaPlayer.create(context, R.raw.mung1);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            bgm++;
        }
        if(bgm>1){
            mediaPlayer.stop();
        }
        optionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View optionView = getLayoutInflater().inflate(R.layout.fragment_option,null);
                final AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setCancelable(false);
                builder.setView(optionView);
                Switch sw = (Switch)optionView.findViewById(R.id.switch1);
                final  AlertDialog alertDialog = builder.create();
                alertDialog.setContentView(optionView);
                Window window = alertDialog.getWindow();
                Point size = new Point();
                Display display = window.getWindowManager().getDefaultDisplay();
                display.getSize(size);
                int width = size.x;
                int height = size.y;
                window.setLayout((int)(width * 0.85),(int)(height * 0.9));
                window.setGravity(Gravity.CENTER);
                alertDialog.show();
                boolean tg = preferences.getBoolean("tg",true);
                if(tg==true){
                    sw.setChecked(true);
                }
                else{
                    sw.setChecked(false);
                }
                sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putBoolean("tg",true);
                            mediaPlayer = MediaPlayer.create(context,R.raw.mung1);
                            mediaPlayer.setLooping(true);
                            mediaPlayer.start();
                            bgm++;
                            editor.commit();
                        }
                        else{
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putBoolean("tg",false);
                            mediaPlayer.setLooping(false);
                            mediaPlayer.stop();
                            bgm = 0;
                            editor.commit();
                        }
                    }
                });
               ImageButton backButton = optionView.findViewById(R.id.exitButton);
                backButton.setOnClickListener(new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        builder.setCancelable(false);
                        alertDialog.dismiss();
                    }
                });

            }
        });
        Button speciesButton = (Button)rootView.findViewById(R.id.speciesButton);
        speciesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(1);
            }
        });
        return rootView;
    }
    @Override
    public void onBackPressed() {
        toast = Toast.makeText(context,"한 번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT);
        if(System.currentTimeMillis()>backKeyPressedTime+2000){
            backKeyPressedTime = System.currentTimeMillis();
            toast.show();
            return;
        }
        if(System.currentTimeMillis()<=backKeyPressedTime+2000){
            getActivity().finish();
            toast.cancel();
        }
    }
}