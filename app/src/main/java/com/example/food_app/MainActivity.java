package com.example.food_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.food_app.Fragment.Cart_Fragment;
import com.example.food_app.Fragment.Home_Fragment;
import com.example.food_app.Fragment.Profile_Fragment;
import com.example.food_app.Fragment.Settings_Fragment;
import com.example.food_app.Fragment.Support_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomVavigation);
        frameLayout = findViewById(R.id.frameLayout);
        loadFragment(new Home_Fragment(),true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navhome){
                    loadFragment(new Home_Fragment(),false);
                    //Toast.makeText(MainActivity.this, "home clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.profile) {
                    loadFragment(new Profile_Fragment(),false);
                    //Toast.makeText(MainActivity.this, "profile clicked", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.cart) {
                    loadFragment(new Cart_Fragment(),false);
                    //Toast.makeText(MainActivity.this, "cart clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.support) {
                    loadFragment(new Support_Fragment(),false);
                    //Toast.makeText(MainActivity.this, "support clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.setting) {
                    loadFragment(new Settings_Fragment(),false);
                    //Toast.makeText(MainActivity.this, "setting clicked", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

    }
    private void loadFragment(Fragment fragment,boolean isAppInitialized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized){
            fragmentTransaction.add(R.id.frameLayout,fragment);
        }
        else {
            fragmentTransaction.replace(R.id.frameLayout,fragment);
        }
        fragmentTransaction.commit();
    }
}