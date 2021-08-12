package com.example.medphox;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.medphox.ui.care.CareFragment;
import com.example.medphox.ui.home.HomeFragment;
import com.example.medphox.ui.offer.OfferFragment;
import com.example.medphox.ui.profile.ProfileFragment;
import com.example.medphox.ui.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView view = findViewById(R.id.btm_nav);
        view.setOnItemSelectedListener(listener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
    }

    @SuppressLint("NonConstantResourceId")
    private final NavigationBarView.OnItemSelectedListener listener =
            item -> {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.navigation_search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.navigation_care:
                        fragment = new CareFragment();
                        break;
                    case R.id.navigation_offer:
                        fragment = new OfferFragment();
                        break;
                    case R.id.navigation_profile:
                        fragment = new ProfileFragment();
                        break;
                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                }
                return true;
            };
}