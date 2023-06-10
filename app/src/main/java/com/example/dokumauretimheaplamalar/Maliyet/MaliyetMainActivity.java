package com.example.dokumauretimheaplamalar.Maliyet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.dokumauretimheaplamalar.R;

public class MaliyetMainActivity extends AppCompatActivity {
private Toolbar toolbarMaliyetMain;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maliyet_main);
        toolbarMaliyetMain=findViewById(R.id.toolbarMaliyetMain);
        toolbarMaliyetMain.setTitle("MaliyetEkrani");



    }
}