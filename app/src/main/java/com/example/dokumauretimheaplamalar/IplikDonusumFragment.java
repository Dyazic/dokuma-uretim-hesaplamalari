package com.example.dokumauretimheaplamalar;

import android.annotation.SuppressLint;
import android.os.Bundle;


import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IplikDonusumFragment extends Fragment {
    private TextView textViewSayi1;
    private TextView textViewSayi2;
    private TextView textViewSayi3;
    private TextView textViewIplikNo;
    private EditText editTextİplikNo;
    private Button buttonIplikPopupAc;
    float sonucNe;
    float sonucNm;
    float sonucDn;
    float sonucTex;
    private Toolbar toolbarIplik;


    @SuppressLint("NonConstantResourceId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim = inflater.inflate(R.layout.fragment_iplik_donusum, container, false);
        editTextİplikNo = tasarim.findViewById(R.id.editIplikUz);
        textViewSayi1 = tasarim.findViewById(R.id.textViewSayi);
        textViewSayi2 = tasarim.findViewById(R.id.textViewSayi2);
        textViewSayi3 = tasarim.findViewById(R.id.textViewSayi3);
        textViewIplikNo = tasarim.findViewById(R.id.textViewIplikNo);
        buttonIplikPopupAc = tasarim.findViewById(R.id.buttonIplikPopupAcIpHesap);
        toolbarIplik = tasarim.findViewById(R.id.toolbarIplikAnaliz);
        toolbarIplik.setSubtitle("İplik Dönüşüm");

        buttonIplikPopupAc.setOnClickListener(view -> {
            String iplikNoS = editTextİplikNo.getText().toString();
            if (TextUtils.isEmpty(iplikNoS)) {//bu kalıp sadece string değerlerde çalışır
                editTextİplikNo.setError("Bu alan boş olamaz");
            } else {
                int iplikNo = Integer.parseInt(iplikNoS);
                PopupMenu popupMenu = new PopupMenu(getActivity(), buttonIplikPopupAc);
                popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.action_ne:
                            textViewIplikNo.setText("NE");
                            sonucDn = (float) (5316.625 / iplikNo);
                            sonucTex = (float) (590.625 / iplikNo);
                            sonucNm = (float) (iplikNo * 1.6932);
                            textViewSayi1.setText(sonucDn + " Dn");
                            textViewSayi3.setText(sonucTex + " Tex");
                            textViewSayi2.setText(sonucNm + " Nm");
                            return true;
                        case R.id.action_nm:
                            textViewIplikNo.setText("NM");
                            sonucNe = (float) (iplikNo / 1.6932);
                            sonucTex = (float) (1000 / iplikNo);
                            sonucDn = (float) (9000 / iplikNo);
                            textViewSayi1.setText(sonucNe + " Ne");
                            textViewSayi3.setText(sonucTex + " Tex");
                            textViewSayi2.setText(sonucDn + " Dn");
                            return true;
                        case R.id.action_dn:
                            textViewIplikNo.setText("DN");
                            sonucNe = (float) (5315.625 / iplikNo);
                            sonucNm = (float) (9000 / iplikNo);
                            sonucTex = (float) (0.111 * iplikNo);
                            textViewSayi1.setText(sonucNe + " Ne");
                            textViewSayi2.setText(sonucNm + " Nm");
                            textViewSayi3.setText(sonucTex + " Tex");
                            return true;
                        case R.id.action_tex:
                            textViewIplikNo.setText("TEX");
                            sonucDn = (float) (9 * iplikNo);
                            sonucNm = (float) (1000 / iplikNo);
                            sonucNe = (float) (590.625 / iplikNo);
                            textViewSayi1.setText(sonucNe + " Ne");
                            textViewSayi2.setText(sonucDn + " Dn");
                            textViewSayi3.setText(sonucNm + " Nm");
                            return true;
                        default:
                            throw new IllegalStateException("Unexpected value: " + item.getItemId());
                    }
                });
                popupMenu.show();
            }
        });
        return tasarim;
    }
}