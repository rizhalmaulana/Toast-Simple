package com.dicoding.picodiploma.kulinerku;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class CardViewKulinerAdapter extends RecyclerView.Adapter<CardViewKulinerAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Kuliner> listKuliner;

    CardViewKulinerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_kuliner, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder cardViewViewHolder, final int position) {
        final Kuliner positionI = getListKuliner().get(position);
        Glide.with(context)
                .load(positionI.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvName.setText(positionI.getName());
        cardViewViewHolder.tvRemarks.setText(positionI.getRemarks());
        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListKuliner().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListKuliner().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewViewHolder.imgPhoto.setOnClickListener(new View.OnClickListener() {
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

    private ArrayList<Kuliner> getListKuliner() {
        return listKuliner;
    }

    static class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;

        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);

        }
    }
}
