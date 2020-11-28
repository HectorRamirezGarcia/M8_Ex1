package com.example.m8_ex1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import android.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends Fragment {

    int cont = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener nav_listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new pFragment();
                            break;
                        case R.id.nav_config:
                            selectedFragment = new FragmentPrueba();
                            break;
                    }
                    getFragmentManager().beginTransaction().replace(R.id.MenuAndConfigure, selectedFragment).commit();
                    return true;
                }
            };

    public BottomNavigation() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View menu = inflater.inflate(R.layout.activity_bottom_navigation, container, false);

        BottomNavigationView bottomNav = menu.findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(nav_listener);

        return menu;

    }

}