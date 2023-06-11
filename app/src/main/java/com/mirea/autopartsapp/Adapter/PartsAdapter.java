package com.mirea.autopartsapp.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mirea.autopartsapp.Model.Part;
import com.mirea.autopartsapp.R;

import java.util.ArrayList;
import java.util.List;

public class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.PartsViewHolder> {

    private List<Part> partsList;
    private OnItemClickListener onItemClickListener;

    public PartsAdapter(List<Part> parts) {
        this.partsList = new ArrayList<>(parts);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Part> parts) {
        this.partsList = new ArrayList<>(parts);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public PartsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_part, parent, false);
        return new PartsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartsViewHolder holder, int position) {
        Part part = partsList.get(position);
        holder.bind(part);
    }

    @Override
    public int getItemCount() {
        return partsList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Part part);
    }

    public class PartsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView partImageView;
        private final TextView partNameTextView;
        private final TextView partDescriptionTextView;

        public PartsViewHolder(View itemView) {
            super(itemView);
            partImageView = itemView.findViewById(R.id.partImageView);
            partNameTextView = itemView.findViewById(R.id.partNameTextView);
            partDescriptionTextView = itemView.findViewById(R.id.partDescriptionTextView);
            itemView.setOnClickListener(this);
        }

        public void bind(Part part) {
            partNameTextView.setText(part.getName());
            partDescriptionTextView.setText(part.getDescription());
            // Load the image from the URL into partImageView using Glide
            Glide.with(itemView.getContext())
                    .load(part.getImageUrl())
                    .placeholder(R.drawable.default_image)
                    .into(partImageView);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Part part = partsList.get(position);
                    onItemClickListener.onItemClick(part);
                }
            }
        }
    }
}
