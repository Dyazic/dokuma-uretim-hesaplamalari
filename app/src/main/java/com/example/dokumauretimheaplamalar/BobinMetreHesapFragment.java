package com.example.dokumauretimheaplamalar;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BobinMetreHesapFragment extends Fragment {
private Toolbar toolbarBobinMt;
private EditText editTextBobinGr;
private EditText editTextIplikNo;
private EditText editTextKabloSayisi;
private TextView textViewBobinMt;
private TextView textViewIpNo;
private TextView textViewCozguMt;
private Button buttonCozguHesapla;
private Button buttonPopUpAcBobin;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tasarim=inflater.inflate(R.layout.fragment_bobin_metre_hesap, container, false);
        toolbarBobinMt=tasarim.findViewById(R.id.toolbarBobinMt);
        toolbarBobinMt.setSubtitle("Bobinden Metre Hesaplama");
        editTextBobinGr=tasarim.findViewById(R.id.editTextBobinGr);
        editTextIplikNo=tasarim.findViewById(R.id.editTextIplikNo);
        editTextKabloSayisi=tasarim.findViewById(R.id.editTextKabloSayisi);
        textViewBobinMt=tasarim.findViewById(R.id.textViewBobinMt);
        textViewIpNo=tasarim.findViewById(R.id.textViewIpNo);
        textViewCozguMt=tasarim.findViewById(R.id.textViewCozguMt);
        buttonCozguHesapla=tasarim.findViewById(R.id.buttonCozguHesapla);
        buttonPopUpAcBobin=tasarim.findViewById(R.id.buttonPopUpAcBobin);
        buttonPopUpAcBobin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bobinKgS = editTextBobinGr.getText().toString();
                String iplikNoS = editTextIplikNo.getText().toString();
                if (TextUtils.isEmpty(bobinKgS)) {
                    editTextBobinGr.setError("Bu alan boş olamaz");
                } else if (TextUtils.isEmpty(iplikNoS)) {//bu kalıp sadece string değerlerde çalışır
                    editTextIplikNo.setError("Bu alan boş olamaz");

                } else {

                    int bobinKg = Integer.parseInt(bobinKgS);
                    int iplikno = Integer.parseInt(iplikNoS);


                    //  int kabloSayisi=Integer.parseInt(editTextKabloSayisi.getText().toString());
                    float dn = new Metodlar().iplikgrmajDn(iplikno);
                    float ne = new Metodlar().iplikgrmajNe(iplikno);
                    float nm = new Metodlar().iplikgramajNm(iplikno);
                    float teks = new Metodlar().iplikgramajTex(iplikno);
                    final float[] bobinmt = new float[1];
                    PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopUpAcBobin);
                    popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @SuppressLint("NonConstantResourceId")
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {

                            switch (item.getItemId()) {
                                case R.id.action_ne:
                                    textViewIpNo.setText("NE");
                                    bobinmt[0] = new Metodlar().bobinMtHesap(bobinKg, ne);
                                    textViewBobinMt.setText("Bobin Metresi = " + bobinmt[0] + " Mt");
                                    Log.e("Bobin Mt = ", String.valueOf(bobinmt[0]));
                                    return true;
                                case R.id.action_nm:
                                    textViewIpNo.setText("NM");
                                    bobinmt[0] = new Metodlar().bobinMtHesap(bobinKg, nm);
                                    textViewBobinMt.setText("Bobin Metresi = " + bobinmt[0] + " Mt");
                                    // Toast.makeText(getActivity(), "Nm Seçtiniz", Toast.LENGTH_SHORT).show();
                                    return true;
                                case R.id.action_dn:
                                    textViewIpNo.setText("DN");
                                    bobinmt[0] = new Metodlar().bobinMtHesap(bobinKg, dn);
                                    textViewBobinMt.setText("Bobin Metresi = " + bobinmt[0] + " Mt");

                                    //  Toast.makeText(getActivity(), "Dn Seçtiniz", Toast.LENGTH_SHORT).show();
                                    return true;
                                case R.id.action_tex:
                                    textViewIpNo.setText("TEX");
                                    bobinmt[0] = new Metodlar().bobinMtHesap(bobinKg, teks);
                                    textViewBobinMt.setText("Bobin Metresi = " + bobinmt[0] + " Mt");
                                    return true;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
                            }

                        }
                    });
                    popupMenu.show();
                    buttonCozguHesapla.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String kabloSayisiS = editTextKabloSayisi.getText().toString();

                            if (TextUtils.isEmpty(kabloSayisiS)) {//bu kalıp sadece string değerlerde çalışır

                                    editTextKabloSayisi.setError("Bu alan boş olamaz");
                            } else {

                                int kabloSayisi = Integer.parseInt(editTextKabloSayisi.getText().toString());
                                float cozguMt = bobinmt[0] / (float) kabloSayisi;
                                textViewCozguMt.setText("Bobinden Alınacak Maks. çözgü mt= " + cozguMt + " Mt");

                            }
                        }
                    });


                }
            }
        });
        return tasarim;
    }
}