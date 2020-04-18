package com.dicoding.picodiploma.kulinerku;

import java.util.ArrayList;

class KulinerData {
    private static String[][] data = new String[][]{
            {"Baso Malang", "Rp. 12000", "https://upload.wikimedia.org/wikipedia/commons/b/b6/Baso_Malang_Karapitan.JPG", "Kota Malang", "Baso Malang merupakan makanan yang sudah sangat populer dikalangan para penggemar baso"},
            {"Sate Ayam", "Rp. 14000", "https://upload.wikimedia.org/wikipedia/commons/f/f6/Mutton_satay_from_H._Faqih%2C_Jombang%2C_2017-09-19_02.jpg", "Kota Madura", "Sate Madura merupakan makanan yang sudah sangat populer dikalangan para penggemar sate"},
            {"Gado Gado", "Rp. 10000", "https://upload.wikimedia.org/wikipedia/commons/a/a2/Gado_gado.jpg", "Kota Jakarta", "Gado-Gado merupakan makanan yang sudah sangat populer dikalangan para penggemar gado gado"},
            {"Soto Ayam", "Rp. 12000", "https://upload.wikimedia.org/wikipedia/commons/6/69/Soto_Ayam_home-made.JPG", "Kota Lamongan", "Soto Ayam merupakan makanan yang sudah sangat populer dikalangan para penggemar soto"},
            {"Pecel Lele", "Rp. 16000", "https://upload.wikimedia.org/wikipedia/commons/2/29/Pecel_Lele_1.JPG", "Jawa", "Pecel Lele merupakan makanan yang sudah sangat populer dikalangan para penggemar pecel lele"},
            {"Kerak Telur", "Rp. 15000", "https://upload.wikimedia.org/wikipedia/commons/8/8a/Kerak_Telor.jpg", "Kota Jakarta", "Kerak Telur merupakan makanan yang sudah sangat populer dikalangan para penggemar kerak telur"},
            {"Pempek Palembang", "Rp. 7000", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Pempek_Bangka.JPG/1920px-Pempek_Bangka.JPG", "Kota Palembang", "Pempek Palembang merupakan makanan yang sudah sangat populer dikalangan para penggemar pempek"},
            {"Bubur Ayam", "Rp. 10000", "https://upload.wikimedia.org/wikipedia/commons/7/7f/Bubur_ayam.jpg", "Kota Karawang", "Bubur Ayam merupakan makanan yang sudah sangat populer dikalangan para penggemar bubur"},
            {"Nasi Bebek", "Rp. 12000", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Bebek_Goreng_Malang.JPG/1280px-Bebek_Goreng_Malang.JPG", "Kota Karawang", "Nasi Bebek merupakan makanan yang sudah sangat populer dikalangan para penggemar bebek goreng"},
            {"Mie Ayam", "Rp. 12000", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Mi_ayam_biasa.JPG/1280px-Mi_ayam_biasa.JPG", "Kota Karawang", "Mie Ayam merupakan makanan yang sudah sangat populer dikalangan para penggemar mie"},
    };

    static ArrayList<Kuliner> getListData(){
        Kuliner kuliner;
        ArrayList<Kuliner> list = new ArrayList<>();
        for (String[] datum : data) {
            kuliner = new Kuliner();
            kuliner.setName(datum[0]);
            kuliner.setRemarks(datum[1]);
            kuliner.setPhoto((datum[2]));
            kuliner.setAsal(datum[3]);
            kuliner.setDeskripsi(datum[4]);

            list.add(kuliner);
        }

        return list;
    }
}
