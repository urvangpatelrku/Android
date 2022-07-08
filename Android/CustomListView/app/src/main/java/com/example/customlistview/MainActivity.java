package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyAdapter adapter;
    ArrayList<Item> itemlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lstData);
        ArrayList<Item> items = new ArrayList<Item>();

        // 1. pass context and data to the custom adapter
        adapter = new MyAdapter(this, generateData());
        listView.setAdapter(adapter);

    }

    private ArrayList<Item> generateData() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Fenil","01/02/2022","09:10", "985641266", R.drawable.image_0));
        items.add(new Item("Fenil","01/02/2022","09:10", "985655123", R.drawable.image_1));
        items.add(new Item("Fenil","01/02/2022","09:10", "985641266", R.drawable.image_2));
        items.add(new Item("Fenil","01/02/2022","09:10", "985641266", R.drawable.image_0));
        items.add(new Item("Fenil","01/02/2022","09:10", "985655123", R.drawable.image_1));
        items.add(new Item("Fenil","01/02/2022","09:10", "985641266", R.drawable.image_2));
        items.add(new Item("Fenil","01/02/2022","09:10", "985641266", R.drawable.image_0));
        items.add(new Item("Fenil","01/02/2022","09:10", "985655123", R.drawable.image_1));
        items.add(new Item("Fenil","01/02/2022","09:10", "985641266", R.drawable.image_2));
        items.add(new Item("Fenil","01/02/2022","09:10", "985641266", R.drawable.image_0));
        items.add(new Item("Fenil","01/02/2022","09:10", "985655123", R.drawable.image_1));
        items.add(new Item("Fenil","01/02/2022","09:10", "985641266", R.drawable.image_2));
        items.add(new Item("Fenil","01/02/2022","09:10", "985641266", R.drawable.image_0));
        items.add(new Item("Fenil","01/02/2022","09:10", "985655123", R.drawable.image_1));
        items.add(new Item("Fenil","01/02/2022","09:10", "985641266", R.drawable.image_2));
        return items;
    }
}