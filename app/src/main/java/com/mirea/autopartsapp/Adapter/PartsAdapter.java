package com.mirea.autopartsapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.autopartsapp.Model.Part;
import com.mirea.autopartsapp.R;

import java.util.ArrayList;
import java.util.List;

public class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.PartsViewHolder> {

    private List<Part> partsList;
    private OnItemClickListener onItemClickListener;

    public PartsAdapter(List<Part> parts) {
        this.partsList = new ArrayList<>();
    }

    public void setData(List<Part> parts) {
        this.partsList = parts;
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
        void onItemClick(int position);
    }

    public class PartsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView partNameTextView;
        private TextView partDescriptionTextView;

        public PartsViewHolder(View itemView) {
            super(itemView);
            partNameTextView = itemView.findViewById(R.id.partNameTextView);
            partDescriptionTextView = itemView.findViewById(R.id.partDescriptionTextView);

            itemView.setOnClickListener(this);
        }

        public void bind(Part part) {
            partNameTextView.setText(part.getName());
            partDescriptionTextView.setText(part.getDescription());
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener.onItemClick(position);
                }
            }
        }
    }
}
