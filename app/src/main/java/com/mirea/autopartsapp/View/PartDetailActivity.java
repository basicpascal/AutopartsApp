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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ImageView partImageView = findViewById(R.id.partImageView);
        TextView partDescriptionTextView = findViewById(R.id.partDescriptionTextView);

        Part part = getIntent().getParcelableExtra("part");
        String imageUrl = part.getImageUrl();

        // Загрузка и отображение изображения
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.placeholder_image)
                    .error(R.drawable.error_image)
                    .into(partImageView);
        }
        else {
            partImageView.setImageResource(R.drawable.error_image);
        }
            partDescriptionTextView.setText(part.getDescription());
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
