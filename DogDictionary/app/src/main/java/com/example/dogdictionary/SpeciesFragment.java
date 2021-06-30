package com.example.dogdictionary;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dogdictionary.dummy.DummyContent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class SpeciesFragment extends ListFragment implements onBackPressedListener {
    MainActivity activity;
    listAdapter adapter;
    ArrayList<Dog> list = new ArrayList<Dog>();

    public Context context;
    public void onBackPressed(){
        goTomain();
    }
    public void goTomain(){
        activity.onFragmentChange(0);
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.context = context;
        activity = (MainActivity)getActivity();
    }
    @Override
    public void onDetach(){
        super.onDetach();
        activity = null;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context context1;
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_species_list, container, false);
        TransitionInflater inflater1 = TransitionInflater.from(requireContext());
        setExitTransition(inflater1.inflateTransition(R.transition.slide_right));
        list.add(new Dog("푸들",R.drawable.wa));
        list.add(new Dog("진돗개",R.drawable.jindo));
        list.add(new Dog("치와와",R.drawable.chihuahua));
        list.add(new Dog("도베르만",R.drawable.doberman));
        list.add(new Dog("시바",R.drawable.shiba));
        list.add(new Dog("포메라니안",R.drawable.pomeranian));
        listAdapter adapter = new listAdapter(getContext(),R.layout.fragment_species_list,list);
        ListView listView = (ListView)viewGroup.findViewById(android.R.id.list);
        listView.setAdapter(adapter);
        return viewGroup;

    }
    @Override
    public void onListItemClick(ListView list,View view, int position,long id){
        ListViewItem item = (ListViewItem) list.getItemAtPosition(position);
        Intent intent = new Intent(getContext(),SpeciesClick.class);
        startActivity(intent);
    }
    public void addItem(Drawable icon, String name){
        adapter.addItem(icon,name);
    }
}
class listAdapter extends BaseAdapter{
    Context context;
    int layout;
    ArrayList<Dog> list;
    private ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>();
    public listAdapter(Context context, int layout, ArrayList<Dog> list){
        this.context = context;
        this.layout = layout;
        this.list = list;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount(){
        return listViewItems.size();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fragment_species,parent,true);
        }
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView);
        TextView dogName = (TextView)convertView.findViewById(R.id.dogName);


        Dog d = list.get(position);
        iconImageView.setImageResource(d.img);
        dogName.setText(d.name);
        return convertView;
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public Object getItem(int position){
        return listViewItems.get(position);
    }
    public void addItem(Drawable icon,String name){
        ListViewItem item = new ListViewItem();
        item.setIcon(icon);
        item.setName(name);
        listViewItems.add(item);
    }
}
class Dog{
    int img;
    String name ="";
    public  Dog(String name,int img){
        super();
        this.name = name;
        this.img = img;
    }
    public Dog(){}
}
