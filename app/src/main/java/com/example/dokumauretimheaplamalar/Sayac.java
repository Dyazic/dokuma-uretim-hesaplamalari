package com.example.dokumauretimheaplamalar;

import android.util.Log;

public class Sayac {
    int sayac;

    public Sayac() {

    }

    public Sayac(int sayac) {
        this.sayac = sayac;
    }

    public int getSayac() {
        return sayac;
    }

    public void setSayac(int sayac) {
        this.sayac = sayac;
        System.out.println("Reklam sayacı ="+sayac);
    }

}
