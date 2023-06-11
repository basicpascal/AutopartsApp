package com.mirea.autopartsapp.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.autopartsapp.Adapter.PartsAdapter;
import com.mirea.autopartsapp.Model.Part;
import com.mirea.autopartsapp.R;

import java.util.ArrayList;
import java.util.List;

public class PartListActivity extends AppCompatActivity implements PartsAdapter.OnItemClickListener {

    private PartsAdapter partsAdapter;
    private List<Part> partsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView partsRecyclerView = findViewById(R.id.partsRecyclerView);

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
        partsList.add(new Part("Ремень ГРМ", "Ремень ГРМ для автомобилей марки Toyota.", "https://partreview.ru/Templates/storage/review_ava/8091.jpg"));
        partsList.add(new Part("Тормозные колодки", "Тормозные колодки передние для автомобилей марки Honda.", "https://ir.ozone.ru/s3/multimedia-8/c1000/6491019920.jpg"));
        partsList.add(new Part("Фильтр воздушный", "Фильтр воздушный для автомобилей марки BMW.", "https://ir.ozone.ru/s3/multimedia-v/c1000/6418346959.jpg"));
        partsList.add(new Part("Амортизатор задний", "Амортизатор задний для автомобилей марки Ford.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Свечи зажигания", "Свечи зажигания для автомобилей марки Volkswagen.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Масляный фильтр", "Масляный фильтр для автомобилей марки Mercedes-Benz.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Топливный насос", "Топливный насос для автомобилей марки Audi.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Стекло лобовое", "Стекло лобовое для автомобилей марки Volvo.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Радиатор охлаждения", "Радиатор охлаждения для автомобилей марки Nissan.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Подшипник передней ступицы", "Подшипник передней ступицы для автомобилей марки Chevrolet.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Рычаг переключения передач", "Рычаг переключения передач для автомобилей марки Peugeot.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Задний фонарь", "Задний фонарь левый для автомобилей марки Hyundai.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Сальник коленвала", "Сальник коленвала для автомобилей марки Kia.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Рулевая рейка", "Рулевая рейка для автомобилей марки Subaru.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Датчик кислорода", "Датчик кислорода для автомобилей марки Mitsubishi.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Катушка зажигания", "Катушка зажигания для автомобилей марки Opel.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Генератор", "Генератор для автомобилей марки Renault.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Сцепление", "Сцепление для автомобилей марки Fiat.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Полуось", "Полуось передняя правая для автомобилей марки Citroen.", "https://example.com/image-url.jpg"));
        partsList.add(new Part("Стартер", "Стартер для автомобилей марки Skoda.", "https://example.com/image-url.jpg"));



        partsAdapter.setData(partsList);
    }

    @Override
    public void onItemClick(Part part) {
        Intent intent = new Intent(this, PartDetailActivity.class);
        intent.putExtra("part", part); // Передача объекта Part
        startActivity(intent);
    }

}

