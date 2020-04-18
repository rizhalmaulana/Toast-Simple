package id.ac.ubpkarawang.tugas_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InformasiActivity extends AppCompatActivity {

    ImageButton imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);

        imgBtn = findViewById(R.id.backButtonAbout);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backPress = new Intent(InformasiActivity.this, MainActivity.class);
                startActivity(backPress);
            }
        });
    }
}
