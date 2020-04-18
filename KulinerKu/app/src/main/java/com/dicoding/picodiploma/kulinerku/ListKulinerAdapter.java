package com.dicoding.picodiploma.kulinerku;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListKulinerAdapter extends RecyclerView.Adapter<ListKulinerAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Kuliner> listKuliner;

    ListKulinerAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Kuliner> getListKuliner() {
        return listKuliner;
    }

    void setListKuliner(ArrayList<Kuliner> listKuliner) {
        this.listKuliner = listKuliner;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_kuliner, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, @SuppressLint("RecyclerView") final int position) {
        categoryViewHolder.tvName.setText(getListKuliner().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListKuliner().get(position).getRemarks());
        Glide.with(context)
                .load(getListKuliner().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);

        categoryViewHolder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailKulinerActivity.class);
                intent.putExtra("Nama Kuliner", getListKuliner().get(position).getName());
                intent.putExtra("Harga Kuliner", getListKuliner().get(position).getRemarks());
                intent.putExtra("Deskripsi Kuliner", getListKuliner().get(position).getDeskripsi());
                intent.putExtra("Content Nama", getListKuliner().get(position).getName());
                intent.putExtra("Remarks", getListKuliner().get(position).getRemarks());
                intent.putExtra("Content Asal", getListKuliner().get(position).getAsal());
                intent.putExtra("Photo", getListKuliner().get(position).getPhoto());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListKuliner().size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
