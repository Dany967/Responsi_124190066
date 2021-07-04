package com.upnyk.coronavirus.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.upnyk.coronavirus.R;
import com.upnyk.coronavirus.corona.CoronaFragment;
import com.upnyk.coronavirus.hospital.HospitalFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView botNavMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botNavMain = findViewById(R.id.bot_nav_main);
        botNavMain.setOnNavigationItemSelectedListener(this);
        loadFragment(new CoronaFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.corona_menu_item:
                return loadFragment(new CoronaFragment());
            case R.id.hospital_menu_item:
                return loadFragment(new HospitalFragment());
            default:
                return loadFragment(new Fragment());
        }
    }

    boolean loadFragment(Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout_main, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}