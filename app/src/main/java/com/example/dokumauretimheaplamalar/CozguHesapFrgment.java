package com.example.dokumauretimheaplamalar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class CozguHesapFrgment extends Fragment implements SearchView.OnQueryTextListener {
    private Toolbar toolbarCozguHesap;
    private EditText editTextToplamTelSayisi;
    private EditText editTextIplikIki;
    private EditText editTextIplikBir;
    private EditText editTextIplikUc;
    private EditText editTextIplikDort;
    private EditText editTextIplikBes;
    private EditText editTextIpikRaporBir;
    private EditText editTextIpikRaporIki;
    private EditText editTextIpikRaporUc;
    private EditText editTextIpikRaporDort;
    private EditText editTextIpikRaporBes;
    private TextView textViewBirIplik;
    private TextView textViewIkiIplik;
    private TextView textViewUcIplik;
    private TextView textViewDortIplik;
    private TextView textViewBesIplik;
    private TextView textViewToplamRaporBoyu;
    private TextView textViewBirinciGider;
    private TextView textViewIkinciGider;
    private TextView textViewUcuncuGider;
    private TextView textViewDorduncuGider;
    private TextView textViewBesinciGider;
    private Button buttonPopupCozBir;
    private Button buttonPopupCozIki;
    private Button buttonPopupCozUc;
    private Button buttonPopupCozDort;
    private Button buttonPopupCozBes;
    private Button buttonHesapla;
float iplikGider1;
float iplikGider2;
float iplikGider3;
float iplikGider4;
float iplikGider5;
int toplamRaporBoyu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tasarim=inflater.inflate(R.layout.fragment_cozgu_hesap_frgment, container, false);
        toolbarCozguHesap=tasarim.findViewById(R.id.toolbarCozguHesap);
        toolbarCozguHesap.setSubtitle("Çözgü Gider Hesaplama");
        editTextToplamTelSayisi=tasarim.findViewById(R.id.editTextToplamTelSayisi);
        editTextIplikIki=tasarim.findViewById(R.id.editTextIplikIki);
        editTextIplikBir=tasarim.findViewById(R.id.editTextIplikBir);
        editTextIplikUc=tasarim.findViewById(R.id.editTextIplikUc);
        editTextIplikDort=tasarim.findViewById(R.id.editTextIplikDort);
        editTextIplikBes=tasarim.findViewById(R.id.editTextIplikBes);
        editTextIpikRaporBir=tasarim.findViewById(R.id.editTextIpikRaporBir);
        editTextIpikRaporIki=tasarim.findViewById(R.id.editTextIpikRaporIki);
        editTextIpikRaporUc=tasarim.findViewById(R.id.editTextIpikRaporUc);
        editTextIpikRaporDort=tasarim.findViewById(R.id.editTextIpikRaporDort);
        editTextIpikRaporBes=tasarim.findViewById(R.id.editTextIpikRaporBes);
        textViewBirIplik=tasarim.findViewById(R.id.textViewBirIplik);
        textViewIkiIplik=tasarim.findViewById(R.id.textViewIkiIplik);
        textViewUcIplik=tasarim.findViewById(R.id.textViewUcIplik);
        textViewDortIplik=tasarim.findViewById(R.id.textViewDortIplik);
        textViewBesIplik=tasarim.findViewById(R.id.textViewBesIplik);
        textViewToplamRaporBoyu=tasarim.findViewById(R.id.textViewToplamRaporBoyuA);

        textViewBirinciGider=tasarim.findViewById(R.id.textViewBirinciGider);
        textViewIkinciGider=tasarim.findViewById(R.id.textViewIkinciGider);
        textViewDorduncuGider=tasarim.findViewById(R.id.textViewDorduncuGider);
        textViewUcuncuGider=tasarim.findViewById(R.id.textViewUcuncuGider);
        textViewBesinciGider=tasarim.findViewById(R.id.textViewBesinciGider);

        buttonPopupCozBir=tasarim.findViewById(R.id.buttonPopupCozBir);
        buttonPopupCozIki=tasarim.findViewById(R.id.buttonPopupCozIki);
        buttonPopupCozUc=tasarim.findViewById(R.id.buttonPopupCozUc);
        buttonPopupCozDort=tasarim.findViewById(R.id.buttonPopupCozDort);
        buttonPopupCozBes=tasarim.findViewById(R.id.buttonPopupCozBes);
        buttonHesapla=tasarim.findViewById(R.id.buttonHesapla);
           //toolbarı setSupport barı ekleme
            AppCompatActivity activity=(AppCompatActivity) getActivity();
                    activity.setSupportActionBar(toolbarCozguHesap);

       buttonPopupCozBir.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

              String iplikRaporBirS = editTextIpikRaporBir.getText().toString();
               String iplikNoBirS = editTextIplikBir.getText().toString();
               String toplamTelSayisiS = editTextToplamTelSayisi.getText().toString();
               String iplikRaporIkiS = editTextIpikRaporIki.getText().toString();
               String iplikRaporUcSS = editTextIpikRaporUc.getText().toString();
               String iplikRaporDortS = editTextIpikRaporDort.getText().toString();
               String iplikRaporBesS = editTextIpikRaporBes.getText().toString();

               if (TextUtils.isEmpty(iplikNoBirS)) {
                   editTextIplikBir.setError("Bu alan boş olamaz");
                   // Toast.makeText(getActivity(), "1. İplik No boş olmaz ", Toast.LENGTH_SHORT).show();
               } else if (TextUtils.isEmpty(iplikRaporBirS)) {
                   editTextIpikRaporBir.setError("Bu alan boş olamaz");
                   // Toast.makeText(getActivity(), "1 iplik rapor Tel Sayısı Boş Olamaz", Toast.LENGTH_SHORT).show();
               } else if (TextUtils.isEmpty(toplamTelSayisiS)) {
                   editTextToplamTelSayisi.setError("Bu alan boş olamaz");
                   //  Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
               } else if (TextUtils.isEmpty(iplikRaporIkiS)) {
                   editTextIpikRaporIki.setError("Bu alan boş olamaz");
                   //   Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
               } else if (TextUtils.isEmpty(iplikRaporUcSS)) {
                   editTextIpikRaporUc.setError("Bu alan boş olamaz");

                   // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
               } else if (TextUtils.isEmpty(iplikRaporDortS)) {
                   editTextIpikRaporDort.setError("Bu alan boş olamaz");
                   // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
               } else if (TextUtils.isEmpty(iplikRaporBesS)) {
                   editTextIpikRaporBes.setError("Bu alan boş olamaz");

                   // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
               } else {
                  int iplikNoBir = Integer.parseInt(iplikNoBirS);
                   int iplikRaporBir = Integer.parseInt(iplikRaporBirS);
                   int iplikRaporIki = Integer.parseInt(iplikRaporIkiS);
                   int iplikRaporUc = Integer.parseInt(iplikRaporUcSS);
                   int iplikRaporDort = Integer.parseInt(iplikRaporDortS);
                   int iplikRaporBes = Integer.parseInt(iplikRaporBesS);
                   int toplamTelSayisi=Integer.parseInt(toplamTelSayisiS);
                   float dn = new Metodlar().iplikgrmajDn(iplikNoBir);
                  float ne = new Metodlar().iplikgrmajNe(iplikNoBir);
                   float nm = new Metodlar().iplikgramajNm(iplikNoBir);
                   float teks = new Metodlar().iplikgramajTex(iplikNoBir);
                   toplamRaporBoyu = iplikRaporBir + iplikRaporIki + iplikRaporUc + iplikRaporDort + iplikRaporBes;

                   PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopupCozBir);
                   popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                   popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                       @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
                       @Override
                       public boolean onMenuItemClick(MenuItem item) {
                           switch (item.getItemId()) {
                               case R.id.action_ne:
                                   iplikGider1=ne*(iplikRaporBir*((float)toplamTelSayisi/toplamRaporBoyu));
                                   Toast.makeText(getActivity(),"iplik gider"+iplikGider1,Toast.LENGTH_LONG).show();
                                   textViewBirIplik.setText("NE");
                                   return true;
                               case R.id.action_nm:
                                //   iplikGiderbir[0] = nm * iplikRaporBir;
                                   iplikGider1=nm*(iplikRaporBir*((float)toplamTelSayisi/toplamRaporBoyu));
                                   textViewBirIplik.setText("NM");
                                   return true;
                               case R.id.action_dn:
                                   iplikGider1=dn*(iplikRaporBir*((float)toplamTelSayisi/toplamRaporBoyu));
                                   textViewBirIplik.setText("DN");
                                   return true;
                               case R.id.action_tex:
                                  // iplikGiderbir[0] = teks * iplikRaporBir;
                                   iplikGider1=teks*(iplikRaporBir*((float)toplamTelSayisi/toplamRaporBoyu));
                                   textViewBirIplik.setText("TEX");
                                   return true;
                           }
                       return false;
                       }
                   });
                   popupMenu.show();
              }
           }
        });
        buttonPopupCozIki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String iplikRaporBirS = editTextIpikRaporBir.getText().toString();
                String iplikNoIkiS = editTextIplikIki.getText().toString();
                String toplamTelSayisiS = editTextToplamTelSayisi.getText().toString();
                String iplikRaporIkiS = editTextIpikRaporIki.getText().toString();
                String iplikRaporUcSS = editTextIpikRaporUc.getText().toString();
                String iplikRaporDortS = editTextIpikRaporDort.getText().toString();
                String iplikRaporBesS = editTextIpikRaporBes.getText().toString();
                if (TextUtils.isEmpty(iplikNoIkiS)) {
                    editTextIplikIki.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "1. İplik No boş olmaz ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBirS)) {
                    editTextIpikRaporBir.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "1 iplik rapor Tel Sayısı Boş Olamaz", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(toplamTelSayisiS)) {
                    editTextToplamTelSayisi.setError("Bu alan boş olamaz");
                    //  Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporIkiS)) {
                    editTextIpikRaporIki.setError("Bu alan boş olamaz");
                    //   Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporUcSS)) {
                    editTextIpikRaporUc.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporDortS)) {
                    editTextIpikRaporDort.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBesS)) {
                    editTextIpikRaporBes.setError("Bu alan boş olamaz");

                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else {
                    int iplikNoIki = Integer.parseInt(iplikNoIkiS);
                    int iplikRaporBir = Integer.parseInt(iplikRaporBirS);
                    int iplikRaporIki = Integer.parseInt(iplikRaporIkiS);
                    int iplikRaporUc = Integer.parseInt(iplikRaporUcSS);
                    int iplikRaporDort = Integer.parseInt(iplikRaporDortS);
                    int iplikRaporBes = Integer.parseInt(iplikRaporBesS);
                    int toplamTelSayisi=Integer.parseInt(toplamTelSayisiS);
                    float dn = new Metodlar().iplikgrmajDn(iplikNoIki);
                    float ne = new Metodlar().iplikgrmajNe(iplikNoIki);
                    float nm = new Metodlar().iplikgramajNm(iplikNoIki);
                    float teks = new Metodlar().iplikgramajTex(iplikNoIki);
                    toplamRaporBoyu = iplikRaporBir + iplikRaporIki + iplikRaporUc + iplikRaporDort + iplikRaporBes;

                    PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopupCozIki);
                    popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @SuppressLint("NonConstantResourceId")
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_ne:
                                    iplikGider2=ne*(iplikRaporIki*((float)toplamTelSayisi/toplamRaporBoyu));
                                    Toast.makeText(getActivity(),"iplik gider"+iplikGider1,Toast.LENGTH_LONG).show();
                                    textViewIkiIplik.setText("NE");
                                    return true;
                                case R.id.action_nm:
                                    //   iplikGiderbir[0] = nm * iplikRaporBir;
                                    iplikGider2=nm*(iplikRaporIki*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewIkiIplik.setText("NM");
                                    return true;
                                case R.id.action_dn:
                                    iplikGider2=dn*(iplikRaporIki*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewIkiIplik.setText("DN");
                                    return true;
                                case R.id.action_tex:
                                    // iplikGiderbir[0] = teks * iplikRaporBir;
                                    iplikGider2=teks*(iplikRaporIki*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewIkiIplik.setText("TEX");
                                    return true;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            }
        });
        buttonPopupCozUc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String iplikRaporBirS = editTextIpikRaporBir.getText().toString();
                String iplikNoUcS = editTextIplikUc.getText().toString();
                String toplamTelSayisiS = editTextToplamTelSayisi.getText().toString();
                String iplikRaporIkiS = editTextIpikRaporIki.getText().toString();
                String iplikRaporUcSS = editTextIpikRaporUc.getText().toString();
                String iplikRaporDortS = editTextIpikRaporDort.getText().toString();
                String iplikRaporBesS = editTextIpikRaporBes.getText().toString();
                if (TextUtils.isEmpty(iplikNoUcS)) {
                    editTextIplikUc.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "1. İplik No boş olmaz ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBirS)) {
                    editTextIpikRaporBir.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "1 iplik rapor Tel Sayısı Boş Olamaz", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(toplamTelSayisiS)) {
                    editTextToplamTelSayisi.setError("Bu alan boş olamaz");
                    //  Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporIkiS)) {
                    editTextIpikRaporIki.setError("Bu alan boş olamaz");
                    //   Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporUcSS)) {
                    editTextIpikRaporUc.setError("Bu alan boş olamaz");

                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporDortS)) {
                    editTextIpikRaporDort.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBesS)) {
                    editTextIpikRaporBes.setError("Bu alan boş olamaz");

                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else {
                    int iplikNoUc = Integer.parseInt(iplikNoUcS);
                    int iplikRaporBir = Integer.parseInt(iplikRaporBirS);
                    int iplikRaporIki = Integer.parseInt(iplikRaporIkiS);
                    int iplikRaporUc = Integer.parseInt(iplikRaporUcSS);
                    int iplikRaporDort = Integer.parseInt(iplikRaporDortS);
                    int iplikRaporBes = Integer.parseInt(iplikRaporBesS);
                    int toplamTelSayisi=Integer.parseInt(toplamTelSayisiS);
                    float dn = new Metodlar().iplikgrmajDn(iplikNoUc);
                    float ne = new Metodlar().iplikgrmajNe(iplikNoUc);
                    float nm = new Metodlar().iplikgramajNm(iplikNoUc);
                    float teks = new Metodlar().iplikgramajTex(iplikNoUc);
                    toplamRaporBoyu = iplikRaporBir + iplikRaporIki + iplikRaporUc + iplikRaporDort + iplikRaporBes;

                    PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopupCozUc);
                    popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @SuppressLint("NonConstantResourceId")
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_ne:
                                    iplikGider3=ne*(iplikRaporUc*((float)toplamTelSayisi/toplamRaporBoyu));
                                    Toast.makeText(getActivity(),"iplik gider"+iplikGider1,Toast.LENGTH_LONG).show();
                                    textViewUcIplik.setText("NE");
                                    return true;
                                case R.id.action_nm:
                                    //   iplikGiderbir[0] = nm * iplikRaporBir;
                                    iplikGider3=nm*(iplikRaporUc*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewUcIplik.setText("NM");
                                    return true;
                                case R.id.action_dn:
                                    iplikGider3=dn*(iplikRaporUc*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewUcIplik.setText("DN");
                                    return true;
                                case R.id.action_tex:
                                    // iplikGiderbir[0] = teks * iplikRaporBir;
                                    iplikGider3=teks*(iplikRaporUc*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewUcIplik.setText("TEX");
                                    return true;
                            }
                            return true;
                        }
                    });
                    popupMenu.show();
                }
            }
        });
        buttonPopupCozDort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String iplikRaporBirS = editTextIpikRaporBir.getText().toString();
                String iplikNoDortS = editTextIplikDort.getText().toString();
                String toplamTelSayisiS = editTextToplamTelSayisi.getText().toString();
                String iplikRaporIkiS = editTextIpikRaporIki.getText().toString();
                String iplikRaporUcSS = editTextIpikRaporUc.getText().toString();
                String iplikRaporDortS = editTextIpikRaporDort.getText().toString();
                String iplikRaporBesS = editTextIpikRaporBes.getText().toString();
                if (TextUtils.isEmpty(iplikNoDortS)) {
                    editTextIplikDort.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "1. İplik No boş olmaz ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBirS)) {
                    editTextIpikRaporBir.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "1 iplik rapor Tel Sayısı Boş Olamaz", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(toplamTelSayisiS)) {
                    editTextToplamTelSayisi.setError("Bu alan boş olamaz");
                    //  Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporIkiS)) {
                    editTextIpikRaporIki.setError("Bu alan boş olamaz");
                    //   Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporUcSS)) {
                    editTextIpikRaporUc.setError("Bu alan boş olamaz");

                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporDortS)) {
                    editTextIpikRaporDort.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBesS)) {
                    editTextIpikRaporBes.setError("Bu alan boş olamaz");

                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else {
                    int iplikNoDort = Integer.parseInt(iplikNoDortS);
                    int iplikRaporBir = Integer.parseInt(iplikRaporBirS);
                    int iplikRaporIki = Integer.parseInt(iplikRaporIkiS);
                    int iplikRaporUc = Integer.parseInt(iplikRaporUcSS);
                    int iplikRaporDort = Integer.parseInt(iplikRaporDortS);
                    int iplikRaporBes = Integer.parseInt(iplikRaporBesS);
                    int toplamTelSayisi=Integer.parseInt(toplamTelSayisiS);
                    float dn = new Metodlar().iplikgrmajDn(iplikNoDort);
                    float ne = new Metodlar().iplikgrmajNe(iplikNoDort);
                    float nm = new Metodlar().iplikgramajNm(iplikNoDort);
                    float teks = new Metodlar().iplikgramajTex(iplikNoDort);
                    toplamRaporBoyu = iplikRaporBir + iplikRaporIki + iplikRaporUc + iplikRaporDort + iplikRaporBes;

                    PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopupCozDort);
                    popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @SuppressLint("NonConstantResourceId")
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_ne:
                                    iplikGider4=ne*(iplikRaporDort*((float)toplamTelSayisi/toplamRaporBoyu));
                                    Toast.makeText(getActivity(),"iplik gider"+iplikGider1,Toast.LENGTH_LONG).show();
                                    textViewDortIplik.setText("NE");
                                    return true;
                                case R.id.action_nm:
                                    //   iplikGiderbir[0] = nm * iplikRaporBir;
                                    iplikGider4=nm*(iplikRaporDort*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewDortIplik.setText("NM");
                                    return true;
                                case R.id.action_dn:
                                    iplikGider4=dn*(iplikRaporDort*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewDortIplik.setText("DN");
                                    return true;
                                case R.id.action_tex:
                                    // iplikGiderbir[0] = teks * iplikRaporBir;
                                    iplikGider4=teks*(iplikRaporDort*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewDortIplik.setText("TEX");
                                    return true;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            }
        });
        buttonPopupCozBes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String iplikRaporBirS = editTextIpikRaporBir.getText().toString();
                String iplikNoBesS = editTextIplikBes.getText().toString();
                String toplamTelSayisiS = editTextToplamTelSayisi.getText().toString();
                String iplikRaporIkiS = editTextIpikRaporIki.getText().toString();
                String iplikRaporUcSS = editTextIpikRaporUc.getText().toString();
                String iplikRaporDortS = editTextIpikRaporDort.getText().toString();
                String iplikRaporBesS = editTextIpikRaporBes.getText().toString();
                if (TextUtils.isEmpty(iplikNoBesS)) {
                    editTextIplikBes.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "1. İplik No boş olmaz ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBirS)) {
                    editTextIpikRaporBir.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "1 iplik rapor Tel Sayısı Boş Olamaz", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(toplamTelSayisiS)) {
                    editTextToplamTelSayisi.setError("Bu alan boş olamaz");
                    //  Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporIkiS)) {
                    editTextIpikRaporIki.setError("Bu alan boş olamaz");
                    //   Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporUcSS)) {
                    editTextIpikRaporUc.setError("Bu alan boş olamaz");

                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporDortS)) {
                    editTextIpikRaporDort.setError("Bu alan boş olamaz");
                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBesS)) {
                    editTextIpikRaporBes.setError("Bu alan boş olamaz");

                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else {
                    int iplikNoBes = Integer.parseInt(iplikNoBesS);
                    int iplikRaporBir = Integer.parseInt(iplikRaporBirS);
                    int iplikRaporIki = Integer.parseInt(iplikRaporIkiS);
                    int iplikRaporUc = Integer.parseInt(iplikRaporUcSS);
                    int iplikRaporDort = Integer.parseInt(iplikRaporDortS);
                    int iplikRaporBes = Integer.parseInt(iplikRaporBesS);
                    int toplamTelSayisi=Integer.parseInt(toplamTelSayisiS);
                    float dn = new Metodlar().iplikgrmajDn(iplikNoBes);
                    float ne = new Metodlar().iplikgrmajNe(iplikNoBes);
                    float nm = new Metodlar().iplikgramajNm(iplikNoBes);
                    float teks = new Metodlar().iplikgramajTex(iplikNoBes);
                    toplamRaporBoyu = iplikRaporBir + iplikRaporIki + iplikRaporUc + iplikRaporDort + iplikRaporBes;

                    PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopupCozBes);
                    popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @SuppressLint("NonConstantResourceId")
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_ne:
                                    iplikGider5=ne*(iplikRaporBes*((float)toplamTelSayisi/toplamRaporBoyu));
                                    Toast.makeText(getActivity(),"iplik gider"+iplikGider1,Toast.LENGTH_LONG).show();
                                    textViewBesIplik.setText("NE");
                                    return true;
                                case R.id.action_nm:
                                    //   iplikGiderbir[0] = nm * iplikRaporBir;
                                    iplikGider5=nm*(iplikRaporBes*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewBesIplik.setText("NM");
                                    return true;
                                case R.id.action_dn:
                                    iplikGider5=dn*(iplikRaporBes*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewBesIplik.setText("DN");
                                    return true;
                                case R.id.action_tex:
                                    // iplikGiderbir[0] = teks * iplikRaporBir;
                                    iplikGider5=teks*(iplikRaporBes*((float)toplamTelSayisi/toplamRaporBoyu));
                                    textViewBesIplik.setText("TEX");
                                    return true;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            }
        });
        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

        textViewBirinciGider.setText(iplikGider1 +"GR");
        textViewIkinciGider.setText(iplikGider2 +"GR");
        textViewUcuncuGider.setText(iplikGider3 +"GR");
        textViewDorduncuGider.setText(iplikGider4 +"GR");
        textViewBesinciGider.setText(iplikGider5 +"GR");
        textViewToplamRaporBoyu.setText(String.valueOf(toplamRaporBoyu));
        Log.e("iplikGider 5 =",String.valueOf(iplikGider5));
        Log.e("iplikGider 4 =",String.valueOf(iplikGider4));
        Log.e("iplikGider 3 =",String.valueOf(iplikGider3));
        Log.e("iplikGider 2 =",String.valueOf(iplikGider2));
        Log.e("iplikGider 1 =",String.valueOf(iplikGider1));

    }
});


     //**************************************************************************
      return tasarim;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}