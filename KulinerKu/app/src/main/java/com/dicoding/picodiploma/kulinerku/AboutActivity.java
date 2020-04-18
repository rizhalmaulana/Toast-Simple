package com.dicoding.picodiploma.kulinerku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imgBack = findViewById(R.id.backButtonAbout);
        imgBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.backButtonAbout) {
            onBackPressed();
            {
                Intent main = new Intent(AboutActivity.this, MainActivity.class);
                startActivity(main);
            }
        }
    }
}
