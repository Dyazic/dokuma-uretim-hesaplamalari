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


public class AtkiGiderFragment extends Fragment {
private Toolbar toolbarAtkiGider;
   // private EditText editTextToplamTelSayisiA;
    private EditText editTextSiklikA;
    private EditText editTextAtkiPuskulA;
    private EditText editTextCözgüTarakEniA;
    private EditText editTextIplikIkiA;
    private EditText editTextIplikBirA;
    private EditText editTextIplikUcA;
    private EditText editTextIplikDortA;
    private EditText editTextIplikBesA;
    private EditText editTextIpikRaporBirA;
    private EditText editTextIpikRaporIkiA;
    private EditText editTextIpikRaporUcA;
    private EditText editTextIpikRaporDortA;
    private EditText editTextIpikRaporBesA;

    private TextView textViewBirIplikA;
    private TextView textViewIkiIplikA;
    private TextView textViewUcIplikA;
    private TextView textViewDortIplikA;
    private TextView textViewBesIplikA;
    private TextView textViewToplamRaporBoyuA;
    private TextView textViewBirinciGiderA;
    private TextView textViewIkinciGiderA;
    private TextView textViewUcuncuGiderA;
    private TextView textViewDorduncuGiderA;
    private TextView textViewBesinciGiderA;
    private Button buttonPopupCozBirA;
    private Button buttonPopupCozIkiA;
    private Button buttonPopupCozUcA;
    private Button buttonPopupCozDortA;
    private Button buttonPopupCozBesA;
    private Button buttonHesaplaA;
    float iplikGider1A;
    float iplikGider2A;
    float iplikGider3A;
    float iplikGider4A;
    float iplikGider5A;
    int atkiRaporBoyu;
    String errorMessage="Bu Alan Boş Olamaz.";
    int sayac1;
    int sayac2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View tasarim=inflater.inflate(R.layout.fragment_atkigider, container, false);
        toolbarAtkiGider=tasarim.findViewById(R.id.toolbarAtkiGider);
        toolbarAtkiGider.setSubtitle("Atki Gider Hesaplama");
        editTextCözgüTarakEniA=tasarim.findViewById(R.id.editTextCözgüTarakEniA);
        editTextAtkiPuskulA=tasarim.findViewById(R.id.editTextAtkiPuskulA);
        editTextSiklikA=tasarim.findViewById(R.id.editTextSiklikA);
        editTextIplikIkiA=tasarim.findViewById(R.id.editTextIplikIkiA);
        editTextIplikBirA=tasarim.findViewById(R.id.editTextIplikBirA);
        editTextIplikUcA=tasarim.findViewById(R.id.editTextIplikUcA);
        editTextIplikDortA=tasarim.findViewById(R.id.editTextIplikDortA);
        editTextIplikBesA=tasarim.findViewById(R.id.editTextIplikBesA);
        editTextIpikRaporBirA=tasarim.findViewById(R.id.editTextIpikRaporBirA);
        editTextIpikRaporIkiA=tasarim.findViewById(R.id.editTextIpikRaporIkiA);
        editTextIpikRaporUcA=tasarim.findViewById(R.id.editTextIpikRaporUcA);
        editTextIpikRaporDortA=tasarim.findViewById(R.id.editTextIpikRaporDortA);
        editTextIpikRaporBesA=tasarim.findViewById(R.id.editTextIpikRaporBesA);
        textViewBirIplikA=tasarim.findViewById(R.id.textViewBirIplikA);
        textViewIkiIplikA=tasarim.findViewById(R.id.textViewIkiIplikA);
        textViewUcIplikA=tasarim.findViewById(R.id.textViewUcIplikA);
        textViewDortIplikA=tasarim.findViewById(R.id.textViewDortIplikA);
        textViewBesIplikA=tasarim.findViewById(R.id.textViewBesIplikA);
        textViewToplamRaporBoyuA=tasarim.findViewById(R.id.textViewToplamRaporBoyuA);

        textViewBirinciGiderA=tasarim.findViewById(R.id.textViewBirinciGiderA);
        textViewIkinciGiderA=tasarim.findViewById(R.id.textViewIkinciGiderA);
        textViewDorduncuGiderA=tasarim.findViewById(R.id.textViewDorduncuGiderA);
        textViewUcuncuGiderA=tasarim.findViewById(R.id.textViewUcuncuGiderA);
        textViewBesinciGiderA=tasarim.findViewById(R.id.textViewBesinciGiderA);

        buttonPopupCozBirA=tasarim.findViewById(R.id.buttonPopupCozBirA);
        buttonPopupCozIkiA=tasarim.findViewById(R.id.buttonPopupCozIkiA);
        buttonPopupCozUcA=tasarim.findViewById(R.id.buttonPopupCozUcA);
        buttonPopupCozDortA=tasarim.findViewById(R.id.buttonPopupCozDortA);
        buttonPopupCozBesA=tasarim.findViewById(R.id.buttonPopupCozBesA);
        buttonHesaplaA=tasarim.findViewById(R.id.buttonHesaplaA);
        Metodlar metod=new Metodlar();
        Sayac sayac =new Sayac();

            SayacKontrol sk=new SayacKontrol();





        buttonPopupCozBirA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac2=sayac1+1;

              String iplikRaporBirS = editTextIpikRaporBirA.getText().toString();
               String iplikNoBirS = editTextIplikBirA.getText().toString();
               String cozguTarakEniS = editTextCözgüTarakEniA.getText().toString();
               String atkiPuskulS= editTextAtkiPuskulA.getText().toString();
               String siklikS=editTextSiklikA.getText().toString();
               String iplikRaporIkiS = editTextIpikRaporIkiA.getText().toString();
               String iplikRaporUcSS = editTextIpikRaporUcA.getText().toString();
               String iplikRaporDortS = editTextIpikRaporDortA.getText().toString();
               String iplikRaporBesS = editTextIpikRaporBesA.getText().toString();


               if (TextUtils.isEmpty(iplikNoBirS)) {
                    editTextIplikBirA.setError(errorMessage);

                } else if (TextUtils.isEmpty(iplikRaporBirS)) {
                    editTextIpikRaporBirA.setError(errorMessage);

                } else if (TextUtils.isEmpty(cozguTarakEniS)) {
                   editTextCözgüTarakEniA.setError(errorMessage);

                } else if (TextUtils.isEmpty(iplikRaporIkiS)) {
                    editTextIpikRaporIkiA.setError(errorMessage);

                } else if (TextUtils.isEmpty(iplikRaporUcSS)) {
                    editTextIpikRaporUcA.setError(errorMessage);
                } else if (TextUtils.isEmpty(iplikRaporDortS)) {
                    editTextIpikRaporDortA.setError(errorMessage);
                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBesS)) {
                    editTextIpikRaporBesA.setError(errorMessage);

                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(atkiPuskulS)){
                   editTextAtkiPuskulA.setError((errorMessage));

               }else if(TextUtils.isEmpty(siklikS)){
                   editTextSiklikA.setError((errorMessage));
               }


               else {
                    int iplikNoBir = Integer.parseInt(iplikNoBirS);
                    int iplikRaporBir = Integer.parseInt(iplikRaporBirS);
                    int iplikRaporIki = Integer.parseInt(iplikRaporIkiS);
                    int iplikRaporUc = Integer.parseInt(iplikRaporUcSS);
                    int iplikRaporDort = Integer.parseInt(iplikRaporDortS);
                    int iplikRaporBes = Integer.parseInt(iplikRaporBesS);
                    int atkiPuskul=Integer.parseInt(atkiPuskulS);
                    int siklik=Integer.parseInt(siklikS);
                    int cozguTarakEni=Integer.parseInt(cozguTarakEniS);

                    float dn = metod.iplikgrmajDn(iplikNoBir);
                    float ne = metod.iplikgrmajNe(iplikNoBir);
                    float nm =metod.iplikgramajNm(iplikNoBir);
                    float teks =metod.iplikgramajTex(iplikNoBir);



                  atkiRaporBoyu=iplikRaporBir+iplikRaporIki+iplikRaporUc+iplikRaporDort+iplikRaporBes;
                    float yuzdeSiklik=iplikRaporBir/atkiRaporBoyu*siklik;
                   float toplamAtkiMt=(float)(cozguTarakEni+atkiPuskul)*yuzdeSiklik;

                   PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopupCozBirA);
                    popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_ne:
                                    iplikGider1A=ne*toplamAtkiMt;


                                    textViewBirIplikA.setText("NE");
                                    return true;
                                case R.id.action_nm:

                                    iplikGider1A=nm*toplamAtkiMt;
                                    textViewBirIplikA.setText("NM");
                                    return true;
                                case R.id.action_dn:
                                    iplikGider1A=dn*toplamAtkiMt;
                                    textViewBirIplikA.setText("DN");
                                    return true;
                                case R.id.action_tex:

                                    iplikGider1A=teks*toplamAtkiMt;
                                    textViewBirIplikA.setText("TEX");
                                    return true;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            }
        });
        buttonPopupCozIkiA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac2=sayac1+1;

                String iplikRaporBirS = editTextIpikRaporBirA.getText().toString();
                String iplikNoIkiS = editTextIplikIkiA.getText().toString();
                String cozguTarakEniS = editTextCözgüTarakEniA.getText().toString();
                String atkiPuskulS= editTextAtkiPuskulA.getText().toString();
                String siklikS=editTextSiklikA.getText().toString();
                String iplikRaporIkiS = editTextIpikRaporIkiA.getText().toString();
                String iplikRaporUcSS = editTextIpikRaporUcA.getText().toString();
                String iplikRaporDortS = editTextIpikRaporDortA.getText().toString();
                String iplikRaporBesS = editTextIpikRaporBesA.getText().toString();


                if (TextUtils.isEmpty(iplikNoIkiS)) {
                    editTextIplikIkiA.setError(errorMessage);

                } else if (TextUtils.isEmpty(iplikRaporBirS)) {
                    editTextIpikRaporBirA.setError(errorMessage);

                } else if (TextUtils.isEmpty(cozguTarakEniS)) {
                    editTextCözgüTarakEniA.setError(errorMessage);

                } else if (TextUtils.isEmpty(iplikRaporIkiS)) {
                    editTextIpikRaporIkiA.setError(errorMessage);

                } else if (TextUtils.isEmpty(iplikRaporUcSS)) {
                    editTextIpikRaporUcA.setError(errorMessage);
                } else if (TextUtils.isEmpty(iplikRaporDortS)) {
                    editTextIpikRaporDortA.setError(errorMessage);
                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBesS)) {
                    editTextIpikRaporBesA.setError(errorMessage);

                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(atkiPuskulS)){
                    editTextAtkiPuskulA.setError((errorMessage));

                }else if(TextUtils.isEmpty(siklikS)){
                    editTextSiklikA.setError((errorMessage));
                }


                else {
                    int iplikNoIki = Integer.parseInt(iplikNoIkiS);
                    int iplikRaporBir = Integer.parseInt(iplikRaporBirS);
                    int iplikRaporIki = Integer.parseInt(iplikRaporIkiS);
                    int iplikRaporUc = Integer.parseInt(iplikRaporUcSS);
                    int iplikRaporDort = Integer.parseInt(iplikRaporDortS);
                    int iplikRaporBes = Integer.parseInt(iplikRaporBesS);
                    int atkiPuskul=Integer.parseInt(atkiPuskulS);
                    int siklik=Integer.parseInt(siklikS);
                    int cozguTarakEni=Integer.parseInt(cozguTarakEniS);

                    float dn = metod.iplikgrmajDn(iplikNoIki);
                    float ne = metod.iplikgrmajNe(iplikNoIki);
                    float nm = metod.iplikgramajNm(iplikNoIki);
                    float teks = metod.iplikgramajTex(iplikNoIki);

                    atkiRaporBoyu=iplikRaporBir+iplikRaporIki+iplikRaporUc+iplikRaporDort+iplikRaporBes;
                    float yuzdeSiklik=(float) iplikRaporIki/atkiRaporBoyu*siklik;
                    float toplamAtkiMt=(float)(cozguTarakEni+atkiPuskul)*yuzdeSiklik;

                    PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopupCozBirA);
                    popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_ne:
                                    iplikGider2A=ne*toplamAtkiMt;
                                    textViewIkiIplikA.setText("NE");
                                    return true;
                                case R.id.action_nm:
                                    //   iplikGiderbir[0] = nm * iplikRaporBir;
                                    iplikGider2A=nm*toplamAtkiMt;
                                    textViewIkiIplikA.setText("NM");
                                    return true;
                                case R.id.action_dn:
                                    iplikGider2A=dn*toplamAtkiMt;
                                    textViewIkiIplikA.setText("DN");
                                    return true;
                                case R.id.action_tex:
                                    // iplikGiderbir[0] = teks * iplikRaporBir;
                                    iplikGider2A=teks*toplamAtkiMt;
                                    textViewIkiIplikA.setText("TEX");
                                    return true;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            }
        });

        buttonPopupCozUcA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac2=sayac1+1;

                String iplikRaporBirS = editTextIpikRaporBirA.getText().toString();
                String iplikNoUcS = editTextIplikUcA.getText().toString();
                String cozguTarakEniS = editTextCözgüTarakEniA.getText().toString();
                String atkiPuskulS = editTextAtkiPuskulA.getText().toString();
                String siklikS = editTextSiklikA.getText().toString();
                String iplikRaporIkiS = editTextIpikRaporIkiA.getText().toString();
                String iplikRaporUcSS = editTextIpikRaporUcA.getText().toString();
                String iplikRaporDortS = editTextIpikRaporDortA.getText().toString();
                String iplikRaporBesS = editTextIpikRaporBesA.getText().toString();


                if (TextUtils.isEmpty(iplikNoUcS)) {
                    editTextIplikUcA.setError(errorMessage);

                } else if (TextUtils.isEmpty(iplikRaporBirS)) {
                    editTextIpikRaporBirA.setError(errorMessage);

                } else if (TextUtils.isEmpty(cozguTarakEniS)) {
                    editTextCözgüTarakEniA.setError(errorMessage);

                } else if (TextUtils.isEmpty(iplikRaporIkiS)) {
                    editTextIpikRaporIkiA.setError(errorMessage);

                } else if (TextUtils.isEmpty(iplikRaporUcSS)) {
                    editTextIpikRaporUcA.setError(errorMessage);
                } else if (TextUtils.isEmpty(iplikRaporDortS)) {
                    editTextIpikRaporDortA.setError(errorMessage);
                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(iplikRaporBesS)) {
                    editTextIpikRaporBesA.setError(errorMessage);

                    // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(atkiPuskulS)) {
                    editTextAtkiPuskulA.setError((errorMessage));

                } else if (TextUtils.isEmpty(siklikS)) {
                    editTextSiklikA.setError((errorMessage));
                } else {
                    int iplikNoUc = Integer.parseInt(iplikNoUcS);
                    int iplikRaporBir = Integer.parseInt(iplikRaporBirS);
                    int iplikRaporIki = Integer.parseInt(iplikRaporIkiS);
                    int iplikRaporUc = Integer.parseInt(iplikRaporUcSS);
                    int iplikRaporDort = Integer.parseInt(iplikRaporDortS);
                    int iplikRaporBes = Integer.parseInt(iplikRaporBesS);
                    int atkiPuskul = Integer.parseInt(atkiPuskulS);
                    int siklik = Integer.parseInt(siklikS);
                    int cozguTarakEni = Integer.parseInt(cozguTarakEniS);

                    float dn = metod.iplikgrmajDn(iplikNoUc);
                    float ne = metod.iplikgrmajNe(iplikNoUc);
                    float nm = metod.iplikgramajNm(iplikNoUc);
                    float teks = metod.iplikgramajTex(iplikNoUc);

                    atkiRaporBoyu = iplikRaporBir + iplikRaporIki + iplikRaporUc + iplikRaporDort + iplikRaporBes;
                    float yuzdeSiklik =(float) iplikRaporUc / atkiRaporBoyu * siklik;
                    float toplamAtkiMt = (float) (cozguTarakEni + atkiPuskul) * yuzdeSiklik;

                    PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopupCozBirA);
                    popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_ne:
                                    iplikGider3A = ne * toplamAtkiMt;
                                    textViewUcIplikA.setText("NE");
                                    return true;
                                case R.id.action_nm:
                                    //   iplikGiderbir[0] = nm * iplikRaporBir;
                                    iplikGider3A = nm * toplamAtkiMt;
                                    textViewUcIplikA.setText("NM");
                                    return true;
                                case R.id.action_dn:
                                    iplikGider3A = dn * toplamAtkiMt;
                                    textViewUcIplikA.setText("DN");
                                    return true;
                                case R.id.action_tex:
                                    // iplikGiderbir[0] = teks * iplikRaporBir;
                                    iplikGider3A = teks * toplamAtkiMt;
                                    textViewUcIplikA.setText("TEX");
                                    return true;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            }
        });
                    buttonPopupCozDortA.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String iplikRaporBirS = editTextIpikRaporBirA.getText().toString();
                            String iplikNoDortS = editTextIplikDortA.getText().toString();
                            String cozguTarakEniS = editTextCözgüTarakEniA.getText().toString();
                            String atkiPuskulS = editTextAtkiPuskulA.getText().toString();
                            String siklikS = editTextSiklikA.getText().toString();
                            String iplikRaporIkiS = editTextIpikRaporIkiA.getText().toString();
                            String iplikRaporUcSS = editTextIpikRaporUcA.getText().toString();
                            String iplikRaporDortS = editTextIpikRaporDortA.getText().toString();
                            String iplikRaporBesS = editTextIpikRaporBesA.getText().toString();
                            sayac2=sayac1+1;
                            sayac.setSayac(sayac2);

                            if (TextUtils.isEmpty(iplikNoDortS)) {
                                editTextIplikDortA.setError(errorMessage);

                            } else if (TextUtils.isEmpty(iplikRaporBirS)) {
                                editTextIpikRaporBirA.setError(errorMessage);

                            } else if (TextUtils.isEmpty(atkiPuskulS)) {
                                editTextAtkiPuskulA.setError(errorMessage);

                            } else if (TextUtils.isEmpty(iplikRaporIkiS)) {
                                editTextIpikRaporIkiA.setError(errorMessage);

                            } else if (TextUtils.isEmpty(iplikRaporUcSS)) {
                                editTextIpikRaporUcA.setError(errorMessage);
                            } else if (TextUtils.isEmpty(iplikRaporDortS)) {
                                editTextIpikRaporDortA.setError(errorMessage);
                                // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                            } else if (TextUtils.isEmpty(iplikRaporBesS)) {
                                editTextIpikRaporBesA.setError(errorMessage);

                                // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                            } else if (TextUtils.isEmpty(atkiPuskulS)) {
                                editTextAtkiPuskulA.setError((errorMessage));

                            } else if (TextUtils.isEmpty(siklikS)) {
                                editTextSiklikA.setError((errorMessage));
                            } else {
                                int iplikNoDort = Integer.parseInt(iplikNoDortS);
                                int iplikRaporBir = Integer.parseInt(iplikRaporBirS);
                                int iplikRaporIki = Integer.parseInt(iplikRaporIkiS);
                                int iplikRaporUc = Integer.parseInt(iplikRaporUcSS);
                                int iplikRaporDort = Integer.parseInt(iplikRaporDortS);
                                int iplikRaporBes = Integer.parseInt(iplikRaporBesS);
                                int atkiPuskul = Integer.parseInt(atkiPuskulS);
                                int siklik = Integer.parseInt(siklikS);
                                int cozguTarakEni = Integer.parseInt(cozguTarakEniS);

                                float dn = metod.iplikgrmajDn(iplikNoDort);
                                float ne = metod.iplikgrmajNe(iplikNoDort);
                                float nm = metod.iplikgramajNm(iplikNoDort);
                                float teks = metod.iplikgramajTex(iplikNoDort);

                                atkiRaporBoyu = iplikRaporBir + iplikRaporIki + iplikRaporUc + iplikRaporDort + iplikRaporBes;
                                float yuzdeSiklik = (float)iplikRaporDort / atkiRaporBoyu * siklik;
                                float toplamAtkiMt = (float) (cozguTarakEni + atkiPuskul) * yuzdeSiklik;

                                PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopupCozBirA);
                                popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
                                    @Override
                                    public boolean onMenuItemClick(MenuItem item) {
                                        switch (item.getItemId()) {
                                            case R.id.action_ne:
                                                iplikGider4A = ne * toplamAtkiMt;
                                                textViewDortIplikA.setText("NE");
                                                return true;
                                            case R.id.action_nm:
                                                //   iplikGiderbir[0] = nm * iplikRaporBir;
                                                iplikGider4A = nm * toplamAtkiMt;
                                                textViewDortIplikA.setText("NM");
                                                return true;
                                            case R.id.action_dn:
                                                iplikGider4A = dn * toplamAtkiMt;
                                                textViewDortIplikA.setText("DN");
                                                return true;
                                            case R.id.action_tex:
                                                // iplikGiderbir[0] = teks * iplikRaporBir;
                                                iplikGider4A = teks * toplamAtkiMt;
                                                textViewDortIplikA.setText("TEX");
                                                return true;
                                        }
                                        return false;
                                    }
                                });
                                popupMenu.show();
                            }
                        }
                    });

                                buttonPopupCozBesA.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        String iplikNoBesS = editTextIplikBesA.getText().toString();
                                        String cozguTarakEniS = editTextCözgüTarakEniA.getText().toString();
                                        String atkiPuskulS = editTextAtkiPuskulA.getText().toString();
                                        String siklikS = editTextSiklikA.getText().toString();
                                        String iplikRaporBirS = editTextIpikRaporBirA.getText().toString();
                                        String iplikRaporIkiS = editTextIpikRaporIkiA.getText().toString();
                                        String iplikRaporUcSS = editTextIpikRaporUcA.getText().toString();
                                        String iplikRaporDortS = editTextIpikRaporDortA.getText().toString();
                                        String iplikRaporBesS = editTextIpikRaporBesA.getText().toString();
                                        sayac2=sayac1+1;
                                        sayac.setSayac(sayac2);
                                        if (TextUtils.isEmpty(cozguTarakEniS)) {
                                            editTextCözgüTarakEniA.setError(errorMessage);
                                        }
                                        else if (TextUtils.isEmpty(siklikS)) {
                                            editTextSiklikA.setError((errorMessage));
                                        }
                                        else if(TextUtils.isEmpty(atkiPuskulS)){
                                            editTextAtkiPuskulA.setError(errorMessage);
                                        }
                                        else if (TextUtils.isEmpty(iplikNoBesS)) {
                                            editTextIplikBesA.setError(errorMessage);

                                        } else if (TextUtils.isEmpty(iplikRaporBirS)) {
                                            editTextIpikRaporBirA.setError(errorMessage);
                                        } else if (TextUtils.isEmpty(iplikRaporIkiS)) {
                                            editTextIpikRaporIkiA.setError(errorMessage);

                                        } else if (TextUtils.isEmpty(iplikRaporUcSS)) {
                                            editTextIpikRaporUcA.setError(errorMessage);
                                        } else if (TextUtils.isEmpty(iplikRaporDortS)) {
                                            editTextIpikRaporDortA.setError(errorMessage);
                                            // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();
                                        } else if (TextUtils.isEmpty(iplikRaporBesS)) {
                                            editTextIpikRaporBesA.setError(errorMessage);

                                            // Toast.makeText(getActivity(), "Toplam Tel Sayı", Toast.LENGTH_SHORT).show();

                                        } else {
                                            int iplikNoBes = Integer.parseInt(iplikNoBesS);
                                            int iplikRaporBir = Integer.parseInt(iplikRaporBirS);
                                            int iplikRaporIki = Integer.parseInt(iplikRaporIkiS);
                                            int iplikRaporUc = Integer.parseInt(iplikRaporUcSS);
                                            int iplikRaporDort = Integer.parseInt(iplikRaporDortS);
                                            int iplikRaporBes = Integer.parseInt(iplikRaporBesS);
                                            int atkiPuskul = Integer.parseInt(atkiPuskulS);
                                            int siklik = Integer.parseInt(siklikS);
                                            int cozguTarakEni = Integer.parseInt(cozguTarakEniS);

                                            float dn = metod.iplikgrmajDn(iplikNoBes);
                                            float ne = metod.iplikgrmajNe(iplikNoBes);
                                            float nm = metod.iplikgramajNm(iplikNoBes);
                                            float teks = metod.iplikgramajTex(iplikNoBes);

                                            atkiRaporBoyu = iplikRaporBir + iplikRaporIki + iplikRaporUc + iplikRaporDort + iplikRaporBes;
                                            float yuzdeSiklik = (float)iplikRaporBes / atkiRaporBoyu * siklik;
                                            float toplamAtkiMt = (float) (cozguTarakEni + atkiPuskul) * yuzdeSiklik;

                                            PopupMenu popupMenu = new PopupMenu(getActivity(), buttonPopupCozBirA);
                                            popupMenu.getMenuInflater().inflate(R.menu.iplik_popup_menu, popupMenu.getMenu());
                                            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
                                                @Override
                                                public boolean onMenuItemClick(MenuItem item) {
                                                    switch (item.getItemId()) {
                                                        case R.id.action_ne:
                                                            iplikGider5A = ne * toplamAtkiMt;
                                                            textViewBesIplikA.setText("NE");
                                                            return true;
                                                        case R.id.action_nm:
                                                            //   iplikGiderbir[0] = nm * iplikRaporBir;
                                                            iplikGider5A = nm * toplamAtkiMt;
                                                            textViewBesIplikA.setText("NM");
                                                            return true;
                                                        case R.id.action_dn:
                                                            iplikGider5A = dn * toplamAtkiMt;
                                                            textViewBesIplikA.setText("DN");
                                                            return true;
                                                        case R.id.action_tex:
                                                            // iplikGiderbir[0] = teks * iplikRaporBir;
                                                            iplikGider5A = teks * toplamAtkiMt;
                                                            textViewBesIplikA.setText("TEX");
                                                            return true;
                                                    }
                                                    return false;
                                                }
                                            });
                                            popupMenu.show();
                                        }
                                    }
                                });
        buttonHesaplaA.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                                textViewBirinciGiderA.setText(iplikGider1A + "GR");
                                textViewIkinciGiderA.setText(iplikGider2A + "GR");
                                textViewUcuncuGiderA.setText(iplikGider3A + "GR");
                                textViewDorduncuGiderA.setText(iplikGider4A + "GR");
                                textViewBesinciGiderA.setText(iplikGider5A + "GR");
                                textViewToplamRaporBoyuA.setText(String.valueOf(atkiRaporBoyu));
                                Log.e("iplikGider 5 =", String.valueOf(iplikGider5A));
                                Log.e("iplikGider 4 =", String.valueOf(iplikGider4A));
                                Log.e("iplikGider 3 =", String.valueOf(iplikGider3A));
                                Log.e("iplikGider 2 =", String.valueOf(iplikGider2A));
                                Log.e("iplikGider 1 =", String.valueOf(iplikGider1A));



                Toast.makeText(getActivity(),"reklam sayacı "+sayac.getSayac(),Toast.LENGTH_LONG).show();
                            }

                    });
                 sayac.setSayac(sayac2);

                    //**************************************************************************
                    return tasarim;
                }
            }
