package com.example.dokumauretimheaplamalar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView NavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer=findViewById(R.id.drawer);
        NavigationView=findViewById(R.id.NavigationView);
       toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Dokuma Üretim Hesaplamaları");
        NavHostFragment navHostFragment=
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        NavigationUI.setupWithNavController(NavigationView,navHostFragment.getNavController());
        ActionBarDrawerToggle toggle=
                new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        View baslik=NavigationView.inflateHeaderView(R.layout.navigation_baslik);
        TextView textViewBaslik=baslik.findViewById(R.id.textViewBaslik);
        textViewBaslik.setText("Dokuma Hesaplamaları");
    }



    @Override
    public void onBackPressed() {//geri tuşuyla draweri kapatma.
        if(drawer.isDrawerOpen(GravityCompat.START)){
           drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}