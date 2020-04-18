package id.ac.ubpkarawang.tugas_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HitungNilaiActivity extends AppCompatActivity {

    TextView hasilNilai;
    CardView cvHitungNilai;
    EditText edtTugas, edtUts, edtUas;
    Spinner spHadir;
    ImageButton imgBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_nilai);

        hasilNilai = findViewById(R.id.txtHasilNilai);
        cvHitungNilai = findViewById(R.id.cvHitungNilai);
        edtTugas = findViewById(R.id.textDialog1);
        edtUts = findViewById(R.id.textDialog2);
        edtUas = findViewById(R.id.textDialog3);
        spHadir = findViewById(R.id.spinner1);
        imgBtnBack = findViewById(R.id.backButtonNilai);

        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backPress = new Intent(HitungNilaiActivity.this, MainActivity.class);
                startActivity(backPress);
            }
        });

        cvHitungNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nilaiTugas = edtTugas.getText().toString().trim();
                String nilaiUts = edtUts.getText().toString().trim();
                String nilaiUas = edtUas.getText().toString().trim();
                String spinnerhadir = spHadir.getSelectedItem().toString().trim();
                boolean isEmptyField = false;
                boolean isInvalidDouble = false;
                double totalHadir = 0;
                String mutu = null;

                //EditText
                if (TextUtils.isEmpty(nilaiTugas)){
                    isEmptyField = true;
                    Toast.makeText(HitungNilaiActivity.this, "Field Nilai Tugas Harus Diisi!!", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(nilaiUts)){
                    isEmptyField = true;
                    Toast.makeText(HitungNilaiActivity.this, "Field Nilai UTS Harus Diisi!!", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(nilaiUas)){
                    isEmptyField = true;
                    Toast.makeText(HitungNilaiActivity.this, "Field Nilai UAS Harus Diisi!!", Toast.LENGTH_SHORT).show();
                }

                Double tugas = toDouble(nilaiTugas);
                Double uts = toDouble(nilaiUts);
                Double uas = toDouble(nilaiUas);
                Double sphadir = toDouble(spinnerhadir);

                if (tugas == null){
                    isInvalidDouble = true;
                    edtTugas.setError("Field Harus Berupa Angka!");
                }else if(uts == null){
                    isInvalidDouble = true;
                    edtUts.setError("Field Harus Berupa Angka!");
                }else if(uas == null){
                    isInvalidDouble = true;
                    edtUas.setError("Field Harus Berupa Angka!");
                }
                //EditText

                //Absensi
                if (sphadir >= 13){
                    totalHadir = 100;
                }else if (sphadir >= 10){
                    totalHadir = 70;
                }else if (sphadir >= 7){
                    totalHadir = 50;
                }else if (sphadir >= 5){
                    totalHadir = 30;
                }else if (sphadir >= 1){
                    totalHadir = 10;
                }
                //Absensi

                //Hasil
                double nilaiAkhir = (totalHadir + tugas + uts + uas) / 4;
                if (nilaiAkhir >= 85){
                    mutu = "A";
                }else if(nilaiAkhir >= 65){
                    mutu = "B";
                }else if(nilaiAkhir >= 45){
                    mutu = "C";
                }else{
                    mutu = "D/E (Perbaikan)";
                }
                hasilNilai.setText("Nilai Keseluruhan : " +nilaiAkhir+ "\n Nilai Mutu : " +mutu);
                //
            }
        });
    }

    private Double toDouble(String nilai) {
        try{
            return Double.valueOf(nilai);
        }catch (NumberFormatException e){
            return null;
        }
    }

}
