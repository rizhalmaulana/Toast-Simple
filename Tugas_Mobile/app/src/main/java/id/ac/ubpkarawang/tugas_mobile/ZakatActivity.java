package id.ac.ubpkarawang.tugas_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class ZakatActivity extends AppCompatActivity {

    TextView txtHasil;
    CardView cvButton;
    RadioGroup rdZakat;
    RadioButton rdbBeras, rdbRupiah;
    EditText edtInput;
    ImageButton imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat);

        txtHasil = findViewById(R.id.satuan);
        cvButton = findViewById(R.id.cardViewHitung);
        rdZakat = findViewById(R.id.radioGroup);
        rdbBeras = findViewById(R.id.radioBeras);
        rdbRupiah = findViewById(R.id.radioRupiah);
        edtInput = findViewById(R.id.textDialog1);
        imgBtn = findViewById(R.id.backButtonZakat);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backPress = new Intent(ZakatActivity.this, MainActivity.class);
                startActivity(backPress);
            }
        });
        Locale localeID = new Locale("in", "ID");
        final NumberFormat formatUang = NumberFormat.getCurrencyInstance(localeID);

        cvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zakat = null;
                String inputBilangan = edtInput.getText().toString().trim();
                boolean isEmptyField = false;
                boolean isEmptyDouble = false;

                //EditText
                if(TextUtils.isEmpty(inputBilangan)){
                    isEmptyField = true;
                    Toast.makeText(ZakatActivity.this, "Silahkan Isi Kolom Yang Kosong", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(inputBilangan)){
                    isEmptyField = true;
                    edtInput.setError("Silahkan Isi!");
                }
                //EditText

                //RadioButton
                int selectedId = rdZakat.getCheckedRadioButtonId();
                if (selectedId == rdbBeras.getId()){
                    zakat = "Beras";
                }else if(selectedId == rdbRupiah.getId()){
                    zakat = "Rupiah";
                }
                //RadioButton

                //Inisialisasi Error
                Double input1 = toDouble(inputBilangan);
                if (input1 == null){
                    isEmptyDouble = true;
                    edtInput.setError("Field ini harus berupa nomer yang valid");
                }
                //Inisialisasi Error

                //Proses Hitung
                if (!isEmptyField && !isEmptyDouble){
                    if (zakat.equals("Beras")){
                        double beras = input1 * 2.5;
                        txtHasil.setText(String.valueOf(beras));

                    }else if(zakat.equals("Rupiah")){
                        double rupiah = input1 * 40000;
                        txtHasil.setText(formatUang.format(rupiah));
                    }
                }
                //Proses Hitung
            }
        });
    }

    //Class toDouble
    private Double toDouble(String str) {
        try{
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
    //Class toDouble
}
