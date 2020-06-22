package com.example.appdoctruyen;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navaNavigationView = (BottomNavigationView) findViewById(R.id.bottomnav);
        navaNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        loadFragment(new TuSachFragment());
        }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fr;
            Bundle bundle;
            switch (menuItem.getItemId()){
                case R.id.navigation_tusach:
                    fr = new TuSachFragment();
                    loadFragment(fr);
                    return true;
                case R.id.navigation_thuvien:
                    fr = new ThuVienFragment();
                    loadFragment(fr);
                    return true;
                case R.id.navigation_taikhoan:
                    fr = new TaiKhoanFragment();
                    loadFragment(fr);
                    return true;
            }
            return false;
        }
    };
    void loadFragment(Fragment fr)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fr);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    int getAcc()
    {
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("IDAcc",-1);
        return id;
    }


}
