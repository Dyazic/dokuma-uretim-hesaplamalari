package com.example.dokumauretimheaplamalar;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ToplamCozguTelSayisiHesaplamaFragment extends Fragment {
    private Toolbar toolbarTopTelSayi;
    private EditText editTextMamulEn;
    private EditText editTextAtkiKivrim;
    private EditText editTextTarakNo;
    private EditText editTextTarakDisi;
    private EditText editTextKenarEn;
    private EditText editTextKenarDisi;
    private Button buttonTelSayiHesapla;
    private TextView textViewToplamTel, textViewAnaTarakEn, textViewAnaTelSayisi, textViewKenarTelSayi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim = inflater.inflate(R.layout.fragment_toplam_cozgu_tel_sayisi_hesaplama, container, false);
        toolbarTopTelSayi = tasarim.findViewById(R.id.toolbarTopTelSayi);
        toolbarTopTelSayi.setSubtitle("Mamülden Toplam Tel Sayısı");
        editTextMamulEn = tasarim.findViewById(R.id.editTextMamulEn);
        editTextAtkiKivrim = tasarim.findViewById(R.id.editTextAtkiKivrim);
        editTextTarakDisi = tasarim.findViewById(R.id.editTextTarakDisi);
        editTextTarakNo = tasarim.findViewById(R.id.editTextTarakNo);
        editTextKenarDisi = tasarim.findViewById(R.id.editTextKenarDisi);
        editTextKenarEn = tasarim.findViewById(R.id.editTextKenarEn);
        buttonTelSayiHesapla = tasarim.findViewById(R.id.buttonTelSayiHesapla);
        textViewToplamTel = tasarim.findViewById(R.id.textViewToplamTel);
        textViewAnaTarakEn = tasarim.findViewById(R.id.textViewAnaTarakEn);
        textViewAnaTelSayisi = tasarim.findViewById(R.id.textViewAnaTelSayisi);
        textViewKenarTelSayi = tasarim.findViewById(R.id.textViewKenarTelSayi);

        buttonTelSayiHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mamulKumasEniS = editTextMamulEn.getText().toString();
                String atkıkıvrımıS = editTextAtkiKivrim.getText().toString();
                String kenarcmS = editTextKenarEn.getText().toString();
                String taraknoS = editTextTarakNo.getText().toString();
                String tarakdissayisiS = editTextTarakDisi.getText().toString();
                String kenardissayisiS = editTextKenarDisi.getText().toString();
                if (TextUtils.isEmpty(mamulKumasEniS)) {
                    editTextMamulEn.setError("Bu alan boş olamaz");
                } else if (TextUtils.isEmpty(atkıkıvrımıS)) {
                    editTextAtkiKivrim.setError("Bu alan boş olamaz");
                } else if (TextUtils.isEmpty(kenarcmS)) {
                    editTextKenarEn.setError("Bu alan boş olamaz");
                } else if (TextUtils.isEmpty(taraknoS)) {
                    editTextTarakNo.setError("Bu alan boş olamaz");
                } else if (TextUtils.isEmpty(tarakdissayisiS)) {
                    editTextTarakDisi.setError("Bu alan boş olamaz");
                } else if (TextUtils.isEmpty(kenardissayisiS)) {
                    editTextKenarDisi.setError("Bu alan boş olamaz");
                } else {
                    double mamulkumaseni = Double.parseDouble(mamulKumasEniS);
                    int atkıkıvrımı = Integer.parseInt(editTextAtkiKivrim.getText().toString());
                    double kenarcm = Double.parseDouble(editTextKenarEn.getText().toString());
                    int tarakno = Integer.parseInt(editTextTarakNo.getText().toString());
                    int tarakdissayisi = Integer.parseInt(editTextTarakDisi.getText().toString());
                    int kenardissayisi = Integer.parseInt(editTextKenarDisi.getText().toString());
                    double anatarakeni = new Metodlar().mamuldenCozguTelHesap(mamulkumaseni, atkıkıvrımı);
                    double anatel = new Metodlar().anatelHesap(anatarakeni, tarakno, tarakdissayisi);
                    double kenartel = new Metodlar().kenarTelHesap(kenarcm, tarakno, kenardissayisi);
                    double toplamtel = new Metodlar().toplamTelHesap(kenartel, anatel);
                    textViewToplamTel.setText("Toplam Tel Sayısı = " + toplamtel);
                    textViewAnaTarakEn.setText("Ana Tarak Eni = " + anatarakeni);
                    textViewAnaTelSayisi.setText("Ana Tel Sayısı = " + anatel);
                    textViewKenarTelSayi.setText("Kenar Tel Sayınız= " + kenartel);
                }
            }
        });
        return tasarim;
    }
}