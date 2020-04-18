package id.ac.ubpkarawang.tugas_toastsimple;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
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
                if (edtDialog1==null){
                    Toast alert = Toast.makeText(getActivity(),"Bilangan 1 Harus Diisi", Toast.LENGTH_SHORT);
                    alert.show();
                }else if (edtDialog2==null){
                    Toast alert = Toast.makeText(getActivity(),"Bilangan 2 Harus Diisi", Toast.LENGTH_SHORT);
                    alert.show();
                }else{
                    double bil1 = Double.parseDouble(edtDialog1.getText().toString());
                    double bill2 = Double.parseDouble(edtDialog2.getText().toString());
                    txtHasil.setText(Double.toString(bil1+bill2));
                }
            }
        });

        cvKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtDialog1==null){
                    Toast alert = Toast.makeText(getActivity(),"Bilangan 1 Harus Diisi", Toast.LENGTH_SHORT);
                    alert.show();
                }else if (edtDialog2==null){
                    Toast alert = Toast.makeText(getActivity(),"Bilangan 2 Harus Diisi", Toast.LENGTH_SHORT);
                    alert.show();
                }else{
                    double bil1 = Double.parseDouble(edtDialog1.getText().toString());
                    double bill2 = Double.parseDouble(edtDialog2.getText().toString());
                    txtHasil.setText(Double.toString(bil1-bill2));
                }
            }
        });

        cvKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtDialog1==null){
                    Toast alert = Toast.makeText(getActivity(),"Bilangan 1 Harus Diisi", Toast.LENGTH_SHORT);
                    alert.show();
                }else if (edtDialog2==null){
                    Toast alert = Toast.makeText(getActivity(),"Bilangan 2 Harus Diisi", Toast.LENGTH_SHORT);
                    alert.show();
                }else{
                    double bil1 = Double.parseDouble(edtDialog1.getText().toString());
                    double bill2 = Double.parseDouble(edtDialog2.getText().toString());
                    txtHasil.setText(Double.toString(bil1*bill2));
                }
            }
        });

        cvBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtDialog1==null){
                    Toast alert = Toast.makeText(getActivity(),"Bilangan 1 Harus Diisi", Toast.LENGTH_SHORT);
                    alert.show();
                }else if (edtDialog2==null){
                    Toast alert = Toast.makeText(getActivity(),"Bilangan 2 Harus Diisi", Toast.LENGTH_SHORT);
                    alert.show();
                }else{
                    double bil1 = Double.parseDouble(edtDialog1.getText().toString());
                    double bill2 = Double.parseDouble(edtDialog2.getText().toString());
                    txtHasil.setText(Double.toString(bil1/bill2));
                }
            }
        });
    }
}
