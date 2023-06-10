package com.example.dokumauretimheaplamalar;

import android.util.Log;

public class SayacKontrol {

    public void sayacKontrol(int sayac){

        if (sayac>10){
            Log.e("reklam kontrol =", "Reklamlaar");
            System.out.println("Reklamlar");
        }else {
            Log.e("reklam kontrol =", "Reklamlara"+(10-sayac));


        }
    }
}
