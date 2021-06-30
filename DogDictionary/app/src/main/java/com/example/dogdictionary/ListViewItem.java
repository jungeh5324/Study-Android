package com.example.dogdictionary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewItem {
    private Drawable iconDrawable;
    private String dogName;

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }

    public void setName(String name) {
        dogName = name;
    }

    public Drawable getIcon() {
        return iconDrawable;
    }

    public String getName() {
        return dogName;
    }
}