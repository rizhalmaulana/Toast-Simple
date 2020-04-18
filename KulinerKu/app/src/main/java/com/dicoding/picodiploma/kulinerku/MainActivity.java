package com.dicoding.picodiploma.kulinerku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rvCategory;
    ImageButton imgBtnProfile;
    private ArrayList<Kuliner> list;
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtnProfile = findViewById(R.id.profileButton);
        rvCategory = findViewById(R.id.rv_kuliner);
        rvCategory.setHasFixedSize(true);

        imgBtnProfile.setOnClickListener(this);
        list = new ArrayList<>();

        if (savedInstanceState == null) {
            list.addAll(KulinerData.getListData());
            showRecyclerList();
            mode = R.id.daftar_kuliner;

        } else {
            ArrayList<Kuliner> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            assert stateList != null;
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListKulinerAdapter listKulinerAdapter = new ListKulinerAdapter(this);
        listKulinerAdapter.setListKuliner(list);
        rvCategory.setAdapter(listKulinerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        if (selectedMode == R.id.daftar_kuliner) {
            showRecyclerList();
        }
        mode = selectedMode;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

    @Override
    public void onClick(View view) {
        Intent profile = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(profile);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MainActivity.this.finish();
    }
}