package com.example.dokumauretimheaplamalar;


import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class GunlukUretimFragment extends Fragment {
private Toolbar toolbarGunluk;
private EditText editTextDevir;
private EditText editTextRandıman;
private EditText editTextSiklik;
private TextView textViewSaatlikUretim;
private TextView textViewGunlukUretim;
private Button buttonUretimHesap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim = inflater.inflate(R.layout.fragment_gunluk_uretim, container, false);
        toolbarGunluk=tasarim.findViewById(R.id.toolbarGunluk);
        toolbarGunluk.setSubtitle("Günlük üretim");
        editTextDevir=tasarim.findViewById(R.id.editTextDevir);
        editTextRandıman=tasarim.findViewById(R.id.editTextRandıman);
        editTextSiklik=tasarim.findViewById(R.id.editTextSiklikA);
        textViewSaatlikUretim=tasarim.findViewById(R.id.textViewSaatlikUretim);
        textViewGunlukUretim=tasarim.findViewById(R.id.textViewGunlukUretim);
        buttonUretimHesap=tasarim.findViewById(R.id.buttonUretimHesap);


        buttonUretimHesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String siklikS = editTextSiklik.getText().toString();
                String devirS = editTextDevir.getText().toString();
                String randimanS = editTextRandıman.getText().toString();
                if(TextUtils.isEmpty(randimanS) && TextUtils.isEmpty(siklikS) && TextUtils.isEmpty(devirS) ) {
                  //  bu kalıpları kullanırken ilk başta hepsinin boş olduğu hali kullan

                    Toast.makeText(getActivity(), "Alanlar Boş Olamaz", Toast.LENGTH_SHORT).show();
                }
                    else if (TextUtils.isEmpty(siklikS)) {//bu kalıp sadece string değerlerde çalışır
                    editTextSiklik.setError("Bu alan boş olamaz");

                }
                else if (TextUtils.isEmpty(devirS)) {//bu kalıp sadece string değerlerde çalışır
                    editTextDevir.setError("Bu alan boş olamaz");
                }
                else if (TextUtils.isEmpty(randimanS)) {//bu kalıp sadece string değerlerde çalışır
                    editTextRandıman.setError("Bu alan boş olamaz");
                }

                else {
                    int siklik = Integer.parseInt(siklikS);
                    int devir = Integer.parseInt(editTextDevir.getText().toString());
                    int randiman = Integer.parseInt(editTextRandıman.getText().toString());
                    double saatlikUretim = ((double) devir * 60 * randiman / 100) / ((double) siklik * 100);
                    double gunlukUretim = saatlikUretim * 24;
                    textViewSaatlikUretim.setText(String.valueOf(saatlikUretim));
                    textViewGunlukUretim.setText(String.valueOf(gunlukUretim));
                    Log.e("saatlik ", String.valueOf(saatlikUretim));

                }
            }
        });



        // Inflate the layout for this fragment
        return tasarim;
    }
}