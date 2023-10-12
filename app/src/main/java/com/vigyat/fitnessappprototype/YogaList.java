package com.vigyat.fitnessappprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class YogaList extends AppCompatActivity {


    RecyclerView recyclerView;
    List<YogaListModalClass> yogaList;
    YogaListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_list);

        recyclerView = findViewById(R.id.yogaRecyclerView);

         YogaListModalClass yoga1 = new YogaListModalClass("Kapalbhati",R.drawable.aarogyam,"https://www.google.com","Improves respiratory mechanism");
         YogaListModalClass yoga2 = new YogaListModalClass("Anulom-Vilom",R.drawable.ic_play,"https://www.apple.com/in/","Improves breathing");

         yogaList = new ArrayList<>();

         yogaList.add(yoga1);
         yogaList.add(yoga2);

         adapter = new YogaListAdapter(yogaList,this);
         LinearLayoutManager layoutManager = new LinearLayoutManager(this);

         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setAdapter(adapter);
    }
}