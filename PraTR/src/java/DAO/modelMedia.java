/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author BagasWidodo
 */
public class modelMedia {

    private String nama_media;
    private String fungsi;
    private String cara_buat_media;
    private String gambar;

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama_media() {
        return nama_media;
    }

    public void setNama_media(String nama_media) {
        this.nama_media = nama_media;
    }

    public String getFungsi() {
        return fungsi;
    }

    public void setFungsi(String fungsi) {
        this.fungsi = fungsi;
    }

    public String getCara_buat_media() {
        return cara_buat_media;
    }

    public void setCara_buat_media(String cara_buat_media) {
        this.cara_buat_media = cara_buat_media;
    }

}
