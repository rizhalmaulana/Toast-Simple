package id.ac.ubpkarawang.tugas_mobile;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new FragmentToast();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;

            case R.id.navigation_uts:
                fragment = new FragmentTugasUts();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                        .commit();

                return true;
            case R.id.navigation_kalkulator:
                fragment = new FragmenKalkulator();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                        .commit();

                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new FragmentToast());
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private boolean loadFragment(FragmentToast fragmentToast) {
        if (fragmentToast != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_layout, fragmentToast)
                    .commit();
            return true;
        }
        return false;


    }

}
