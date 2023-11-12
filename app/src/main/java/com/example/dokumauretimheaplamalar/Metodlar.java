package com.example.dokumauretimheaplamalar;

public class Metodlar {
    public float iplikgrmajDn(int iplikno) {//1m iplik için bu formüller
        float iplikgramaj = (float) iplikno / 9000;
        return iplikgramaj;
    }

    public float iplikgrmajNe(int iplikno) {
        float iplikgramaj = (float) (0.590626 / iplikno);
        return iplikgramaj;
    }

    public float iplikgramajNm(int iplikno) {
        float iplikgramaj = (float) 1 / iplikno;
        return iplikgramaj;
    }

    public float iplikgramajTex(int iplikno) {
        float iplikgramaj = (float) 1 / iplikno;
        return iplikgramaj;
    }

    public float bobinMtHesap(int bobinGr, float iplikgramaj) {
        float bobinMt = (float) bobinGr / iplikgramaj;
        return bobinMt;

    }

    // çözgü tel sayısı hesaplama
    public double mamuldenCozguTelHesap(double mamulkumaseni, int atkikivrimi) {
        double anatarakeni = mamulkumaseni + (mamulkumaseni * atkikivrimi / 100);
        return anatarakeni;
    }

    public double anatelHesap(double anatarakeni, int tarakno, int tarakdissayisi) {
        double anatel = anatarakeni * tarakno * tarakdissayisi;//anatel sayısı
        return anatel;
    }

    public double kenarTelHesap(double kenarcm, int tarakno, int kenardissayisi) {
        double kenartel = kenarcm * 2 * tarakno * kenardissayisi;
        return kenartel;
    }

    public double toplamTelHesap(double kenartel, double anatel) {
        double toplamtel = kenartel + anatel;
        return toplamtel;
    }

    //
    public double atkiMt(double cozguEni, double atkiPuskul, int siklik, int toplamAdım, int iplikRaporSayi) {
        double birimAtkiMt = cozguEni + atkiPuskul;
        double iplikYuzde = iplikRaporSayi / toplamAdım;
        double atkiMt = birimAtkiMt * iplikYuzde * siklik;
        return atkiMt;

    }

    public double toplamIplikUzunluk(int adet, double ipUzunluk) {
        double toplamIplikUzunluk = (adet * ipUzunluk) / 100;
        return toplamIplikUzunluk;
    }

    public double neNoHesap(double ipUz, double ipGramaj) {
        double neNo = ipUz * 453.6 / (768 * ipGramaj);
        return neNo;
    }

    public double nmNoHesap(double ipUz, double ipGramaj) {
        double nmNo = ipUz / ipGramaj;
        return nmNo;
    }

    public double dnNoHesap(double ipUz, double ipGramaj) {
        double dnNo = 9000 * ipGramaj / ipUz;
        return dnNo;
    }

    public double texNoHesap(double ipUz, double ipGramaj) {
        double texNo = 1000 * ipGramaj / ipUz;
        return texNo;
    }

    public double gramajHesap(double x, double y, double kumasGram) {
        double gramaj = 10000 * kumasGram / (x * y);
        return gramaj;
    }

}
