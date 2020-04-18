package id.ac.ubpkarawang.tugas_mobile;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTugasUts extends Fragment {


    private CardView cvNilai, cvInfo, cvZakat, cvExit;
    private int waktu = 200;


    public FragmentTugasUts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_tugas_uts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cvNilai = view.findViewById(R.id.cv_hitung);
        cvInfo = view.findViewById(R.id.cv_informasi);
        cvZakat = view.findViewById(R.id.cv_zakat);
        cvExit = view.findViewById(R.id.cv_logout);

        cvNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent hitung = new Intent(getActivity(), HitungNilaiActivity.class);
                        startActivity(hitung);
                    }
                }, waktu);
            }
        });

        cvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent info = new Intent(getActivity(), InformasiActivity.class);
                        startActivity(info);
                    }
                }, waktu);
            }
        });

        cvZakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent zakat = new Intent(getActivity(), ZakatActivity.class);
                        startActivity(zakat);
                    }
                }, waktu);
            }
        });

        cvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        alertDialogBuilder.setTitle("Yakin Ingin Keluar?");
        alertDialogBuilder
                .setIcon(R.drawable.ic_info)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
