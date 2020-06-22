package com.example.appdoctruyen.models;

public class LoaiTruyen {
    private int idLoaiTruyen;
    private String tenLoaiTruyen;

    public LoaiTruyen(int idLoaiTruyen, String tenLoaiTruyen) {
        this.idLoaiTruyen = idLoaiTruyen;
        this.tenLoaiTruyen = tenLoaiTruyen;
    }

    public int getIdLoaiTruyen() {
        return idLoaiTruyen;
    }

    public void setIdLoaiTruyen(int idLoaiTruyen) {
        this.idLoaiTruyen = idLoaiTruyen;
    }

    public String getTenLoaiTruyen() {
        return tenLoaiTruyen;
    }

    public void setTenLoaiTruyen(String tenLoaiTruyen) {
        this.tenLoaiTruyen = tenLoaiTruyen;
    }
}
