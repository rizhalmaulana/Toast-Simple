package com.dicoding.picodiploma.kulinerku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;


public class DetailKulinerActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvItemName, tvItemRemarks, contentDetail, contentNama, contentHarga, contentAsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kuliner);

        ImageView imgPhoto = findViewById(R.id.img_photo);
        tvItemName = findViewById(R.id.tv_item_name);
        tvItemRemarks = findViewById(R.id.tv_item_remarks);
        contentDetail = findViewById(R.id.content_detail);
        contentNama = findViewById(R.id.content_nama);
        contentHarga = findViewById(R.id.content_harga);
        contentAsal = findViewById(R.id.content_asal);
        ImageButton imgBack = findViewById(R.id.backButton);

        imgBack.setOnClickListener(this);

        Intent myintent = getIntent();
        String nama = Objects.requireNonNull(myintent.getExtras()).getString("Nama Kuliner");
        String harga = myintent.getExtras().getString("Harga Kuliner");
        String deskripsi = myintent.getExtras().getString("Deskripsi Kuliner");
        String contentkuliner = myintent.getExtras().getString("Content Nama");
        String remarks = myintent.getExtras().getString("Remarks");
        String contentasal = myintent.getExtras().getString("Content Asal");
        String image = myintent.getExtras().getString("Photo");

        Picasso.with(this).load(image).into(imgPhoto);

        tvItemName.setText(nama);
        tvItemRemarks.setText(harga);
        contentDetail.setText(deskripsi);
        contentNama.setText(contentkuliner);
        contentHarga.setText(remarks);
        contentAsal.setText(contentasal);

        Log.d(deskripsi, "Poto");
        Log.d("Deskripsi", deskripsi);
    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.backButton) {
            onBackPressed();
            {
                Intent main = new Intent(DetailKulinerActivity.this, MainActivity.class);
                startActivity(main);
            }
        }
    }
}