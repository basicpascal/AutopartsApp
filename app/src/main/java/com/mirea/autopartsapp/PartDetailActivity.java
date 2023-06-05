package com.mirea.autopartsapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class PartDetailActivity extends AppCompatActivity {

    private TextView partNameTextView;
    private TextView partDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true); // Включение кнопки "назад"
        getSupportActionBar().setTitle("Part Detail"); // Очистка заголовка активити

        partNameTextView = findViewById(R.id.partNameTextView);
        partDescriptionTextView = findViewById(R.id.partDescriptionTextView);

        // Получение переданной запчасти из параметров
        Part part = getIntent().getParcelableExtra("part");

        // Заполнение элементов интерфейса информацией о запчасти
        if (part != null) {
            partNameTextView.setText(part.getName());
            partDescriptionTextView.setText(part.getDescription());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
