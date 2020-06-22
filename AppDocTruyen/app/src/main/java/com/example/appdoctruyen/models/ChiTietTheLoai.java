package com.example.appdoctruyen.models;

public class ChiTietTheLoai {
    private int idTheLoai;
    private int idTruyen;

    public ChiTietTheLoai(int idTheLoai, int idTruyen) {
        this.idTheLoai = idTheLoai;
        this.idTruyen = idTruyen;
    }

    public int getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(int idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public int getIdTruyen() {
        return idTruyen;
    }

    public void setIdTruyen(int idTruyen) {
        this.idTruyen = idTruyen;
    }
}
