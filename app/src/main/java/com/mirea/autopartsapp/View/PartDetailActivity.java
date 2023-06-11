package com.mirea.autopartsapp.View;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mirea.autopartsapp.Model.Part;
import com.mirea.autopartsapp.R;

import java.util.Objects;

public class PartDetailActivity extends AppCompatActivity {

    public static final String EXTRA_PART = "part";

    private ImageView partImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        partImageView = findViewById(R.id.partImageView);
        TextView partDescriptionTextView = findViewById(R.id.partDescriptionTextView);

        if (getIntent().hasExtra(EXTRA_PART)) {
            Part part = getIntent().getParcelableExtra(EXTRA_PART);
            if (part != null) {
                setTitle(part.getName());
                loadImage(part.getImageUrl());
                partDescriptionTextView.setText(part.getDescription());
            }
        }
    }

    private void loadImage(String imageUrl) {
        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(partImageView);
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
