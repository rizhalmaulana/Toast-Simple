package id.ac.ubpkarawang.tugas_mobile;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmenKalkulator extends Fragment {

    public TextView txtHasil;
    public EditText edtDialog1, edtDialog2;
    public CardView cvTambah, cvKurang, cvKali, cvBagi;

    public FragmenKalkulator() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmen_kalkulator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtHasil    = view.findViewById(R.id.hasil);
        edtDialog1  = view.findViewById(R.id.textDialog1);
        edtDialog2  = view.findViewById(R.id.textDialog2);
        cvTambah    = view.findViewById(R.id.cv_tambah);
        cvKurang    = view.findViewById(R.id.cv_kurang);
        cvKali      = view.findViewById(R.id.cv_kali);
        cvBagi      = view.findViewById(R.id.cv_bagi);

        cvTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputBilangan1 = edtDialog1.getText().toString().trim();
                String inputBilangan2 = edtDialog2.getText().toString().trim();
                boolean isEmptyField = false;
                boolean isInvalidDouble = false;

                if (TextUtils.isEmpty(inputBilangan1) && TextUtils.isEmpty(inputBilangan2)){
                    isEmptyField = true;
                    Toast toast = Toast.makeText(getActivity(), "Kolom Anda Masih Kosong", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (TextUtils.isEmpty(inputBilangan1)){
                    isEmptyField = true;
                    edtDialog1.setError("Bilangan 1 Harus Diisi");
                }
                if (TextUtils.isEmpty(inputBilangan2)){
                    isEmptyField = true;
                    edtDialog2.setError("Bilangan 2 Harus Diisi");
                }

                Double bilangan1 = toDouble(inputBilangan1);
                Double bilangan2 = toDouble(inputBilangan2);

                if (!isEmptyField && !isInvalidDouble){
                    double kurang = bilangan1 - bilangan2;
                    txtHasil.setText(String.valueOf(kurang));
                }
            }
        });

        cvKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputBilangan1 = edtDialog1.getText().toString().trim();
                String inputBilangan2 = edtDialog2.getText().toString().trim();
                boolean isEmptyField = false;
                boolean isInvalidDouble = false;

                if (TextUtils.isEmpty(inputBilangan1) && TextUtils.isEmpty(inputBilangan2)){
                    isEmptyField = true;
                    Toast toast = Toast.makeText(getActivity(), "Kolom Anda Masih Kosong", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (TextUtils.isEmpty(inputBilangan1)){
                    isEmptyField = true;
                    edtDialog1.setError("Bilangan 1 Harus Diisi");
                }
                if (TextUtils.isEmpty(inputBilangan2)){
                    isEmptyField = true;
                    edtDialog2.setError("Bilangan 2 Harus Diisi");
                }

                Double bilangan1 = toDouble(inputBilangan1);
                Double bilangan2 = toDouble(inputBilangan2);

                if (!isEmptyField && !isInvalidDouble){
                    double kurang = bilangan1 - bilangan2;
                    txtHasil.setText(String.valueOf(kurang));
                }
            }
        });

        cvKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputBilangan1 = edtDialog1.getText().toString().trim();
                String inputBilangan2 = edtDialog2.getText().toString().trim();
                boolean isEmptyField = false;
                boolean isInvalidDouble = false;

                if (TextUtils.isEmpty(inputBilangan1) && TextUtils.isEmpty(inputBilangan2)){
                    isEmptyField = true;
                    Toast toast = Toast.makeText(getActivity(), "Kolom Anda Masih Kosong", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (TextUtils.isEmpty(inputBilangan1)){
                    isEmptyField = true;
                    edtDialog1.setError("Bilangan 1 Harus Diisi");
                }
                if (TextUtils.isEmpty(inputBilangan2)){
                    isEmptyField = true;
                    edtDialog2.setError("Bilangan 2 Harus Diisi");
                }

                Double bilangan1 = toDouble(inputBilangan1);
                Double bilangan2 = toDouble(inputBilangan2);

                if (!isEmptyField && !isInvalidDouble){
                    double kurang = bilangan1 - bilangan2;
                    txtHasil.setText(String.valueOf(kurang));
                }
            }
        });

        cvBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputBilangan1 = edtDialog1.getText().toString().trim();
                String inputBilangan2 = edtDialog2.getText().toString().trim();
                boolean isEmptyField = false;
                boolean isInvalidDouble = false;

                if (TextUtils.isEmpty(inputBilangan1) && TextUtils.isEmpty(inputBilangan2)){
                    isEmptyField = true;
                    Toast toast = Toast.makeText(getActivity(), "Kolom Anda Masih Kosong", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (TextUtils.isEmpty(inputBilangan1)){
                    isEmptyField = true;
                    edtDialog1.setError("Bilangan 1 Harus Diisi");
                }
                if (TextUtils.isEmpty(inputBilangan2)){
                    isEmptyField = true;
                    edtDialog2.setError("Bilangan 2 Harus Diisi");
                }

                Double bilangan1 = toDouble(inputBilangan1);
                Double bilangan2 = toDouble(inputBilangan2);

                if (!isEmptyField && !isInvalidDouble){
                    double kurang = bilangan1 - bilangan2;
                    txtHasil.setText(String.valueOf(kurang));
                }
            }
        });
    }

    private Double toDouble(String str) {
        try{
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
