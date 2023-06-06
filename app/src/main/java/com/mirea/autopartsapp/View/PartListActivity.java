package com.mirea.autopartsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.autopartsapp.Adapter.PartsAdapter;
import com.mirea.autopartsapp.Model.Part;
import com.mirea.autopartsapp.R;

import java.util.ArrayList;
import java.util.List;

public class PartListActivity extends AppCompatActivity implements PartsAdapter.OnItemClickListener {

    private TextView titleTextView;
    private RecyclerView partsRecyclerView;
    private PartsAdapter partsAdapter;
    private List<Part> partsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTextView = findViewById(R.id.titleTextView);
        partsRecyclerView = findViewById(R.id.partsRecyclerView);

        partsList = new ArrayList<>();

        // Настройка RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        partsRecyclerView.setLayoutManager(layoutManager);
        partsAdapter = new PartsAdapter(partsList);
        partsAdapter.setOnItemClickListener(this);
        partsRecyclerView.setAdapter(partsAdapter);

        // Загрузка данных из сервера и обновление адаптера
        loadPartsData();
    }

    private void loadPartsData() {
        // Вместо загрузки данных из сервера используем заглушку
        partsList.add(new Part("Part 1", "Description 1"));
        partsList.add(new Part("Part 2", "Description 2"));
        partsList.add(new Part("Part 3", "Description 3"));

        partsAdapter.setData(partsList);
    }

    @Override
    public void onItemClick(Part part) {
        Intent intent = new Intent(this, PartDetailActivity.class);
        intent.putExtra("part", part); // Передача объекта Part
        startActivity(intent);
    }

}

