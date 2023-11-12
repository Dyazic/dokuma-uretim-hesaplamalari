package com.example.dokumauretimheaplamalar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class IplikAnalizFragment extends Fragment {
    private EditText editTextIplikUz, editIplikSayi, editTextIpGramaj;
    private Button buttonIplikPopupAcIpHesap, buttonIpHesapla;
    private TextView textViewSayi, textIpNo;
    private int ipNo;
    private Toolbar toolbarIplikAnaliz;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim = inflater.inflate(R.layout.fragment_iplik_analiz, container, false);
        Metodlar metod = new Metodlar();
        editTextIplikUz = tasarim.findViewById(R.id.editIplikUz);
        buttonIplikPopupAcIpHesap = tasarim.findViewById(R.id.buttonIplikPopupAcIpHesap);
        textViewSayi = tasarim.findViewById(R.id.textViewSayi);
        textIpNo = tasarim.findViewById(R.id.textIpNo);
        editIplikSayi = tasarim.findViewById(R.id.editIplikSayi);
        buttonIpHesapla = tasarim.findViewById(R.id.buttonIpHesapla);
        editTextIpGramaj = tasarim.findViewById(R.id.editTextIpGramaj);
        toolbarIplikAnaliz = tasarim.findViewById(R.id.toolbarIplikAnaliz);
        buttonIplikPopupAcIpHesap.setOnClickListener(view -> {
            toolbarIplikAnaliz.setSubtitle("İplik Analiz Ekranı");
            PopupMenu popupMenu = new PopupMenu(getActivity(), buttonIplikPopupAcIpHesap);
            popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.action_ne:
                        textIpNo.setText("NE");
                        setIpNo(1);
                        return true;
                    case R.id.action_nm:
                        textIpNo.setText("NM");
                        setIpNo(3);
                        return true;
                    case R.id.action_dn:
                        textIpNo.setText("DN");
                        setIpNo(2);
                        return true;
                    case R.id.action_tex:
                        textIpNo.setText("TEX");
                        setIpNo(4);
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
            });
            popupMenu.show();
        });
        buttonIpHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String iplikUzS = editTextIplikUz.getText().toString();
                String ipSayiS = editIplikSayi.getText().toString();
                String ipGramajS = editTextIpGramaj.getText().toString();
                //if(TextUtils.isEmpty(iplikNo)){
                if (TextUtils.isEmpty(iplikUzS)) {//bu kalıp sadece string değerlerde çalışır
                    editTextIplikUz.setError("Bu alan boş olamaz");
                }
                if (TextUtils.isEmpty(ipSayiS)) {//bu kalıp sadece string değerlerde çalışır
                    editIplikSayi.setError("Bu alan boş olamaz");
                }
                if (TextUtils.isEmpty(ipGramajS)) {//bu kalıp sadece string değerlerde çalışır
                    editTextIpGramaj.setError("Bu alan boş olamaz");
                } else {
                    int ipSayi = Integer.valueOf(ipSayiS);
                    double iplikUz = Double.valueOf(iplikUzS);
                    double ipGramaj = Double.valueOf(ipGramajS);
                    double ipTopUz = metod.toplamIplikUzunluk(ipSayi, iplikUz);
                    if (ipNo == 1) {
                        //ne için
                        double sonuc = metod.neNoHesap(ipTopUz, ipGramaj);
                        String sonuccc = String.valueOf(sonuc);
                        textViewSayi.setText(sonuccc);
                    } else if (ipNo == 2) {
                        //dn için
                        double sonuc = metod.dnNoHesap(ipTopUz, ipGramaj);
                        String sonuccc = String.valueOf(sonuc);
                        textViewSayi.setText(sonuccc);
                        Toast.makeText((Context) getActivity(), sonuccc, Toast.LENGTH_SHORT).show();
                    } else if (ipNo == 3) {
                        //nm için
                        double sonuc = metod.nmNoHesap(ipTopUz, ipGramaj);
                        String sonuccc = String.valueOf(sonuc);
                        textViewSayi.setText(sonuccc);
                    } else if (ipNo == 4) {
                        //tex için
                        double sonuc = metod.texNoHesap(ipTopUz, ipGramaj);
                        String sonuccc = String.valueOf(sonuc);
                        textViewSayi.setText(sonuccc);
                    } else {
                        Toast.makeText(getActivity(), "İplik Numara Seçin", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return tasarim;
    }

    public void setIpNo(int ipNo) {
        System.out.println(ipNo);
        this.ipNo = ipNo;
    }
}