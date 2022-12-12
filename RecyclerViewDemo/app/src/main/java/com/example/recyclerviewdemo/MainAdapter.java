package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private ArrayList<MainData> mainDataList;

    public MainAdapter(ArrayList<MainData> mainDataList) {
        this.mainDataList = mainDataList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {
        holder.ivProfile.setImageResource(mainDataList.get(position).getIvProfile());
        holder.tvName.setText(mainDataList.get(position).getTvName());
        holder.tvContent.setText(mainDataList.get(position).getTvContent());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(view -> {
            String curName = holder.tvName.getText().toString();
            Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
        });

        holder.itemView.setOnLongClickListener(view -> {
            remove(holder.getAdapterPosition());
            return true;
        });

    }

    @Override
    public int getItemCount() {
        return (null != mainDataList ? mainDataList.size() : 0);
    }

    public void remove(int position) {
        try {
            mainDataList.remove(position);
            notifyItemRemoved(position); // 새로고침
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView ivProfile;
        protected TextView tvName;
        protected TextView tvContent;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.ivProfile = itemView.findViewById(R.id.iv_profile);
            this.tvName = itemView.findViewById(R.id.tv_name);
            this.tvContent = itemView.findViewById(R.id.tv_content);

        }

    }
}
