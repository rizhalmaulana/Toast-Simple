package id.ac.ubpkarawang.tugas_mobile;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentToast extends Fragment implements View.OnClickListener {

    public TextView txtAngka;
    public CardView cvReset, cvToast, cvCount;
    public MainActivity activity;
    int mCount = 0;

    public FragmentToast() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_toast, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtAngka = view.findViewById(R.id.txt_angka);
        cvCount = view.findViewById(R.id.cv_count);
        cvReset = view.findViewById(R.id.cv_reset);
        cvToast = view.findViewById(R.id.cv_toast);

        cvReset.setOnClickListener(this);
        cvToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getActivity(), "Ini Fungsi Toast", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        cvCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount++;
                if (txtAngka != null){
                    txtAngka.setText(Integer.toString(mCount));
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        txtAngka.setText("0");
    }

}
