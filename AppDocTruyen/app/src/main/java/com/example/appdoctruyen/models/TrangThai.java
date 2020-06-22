package com.example.appdoctruyen.models;

public class TrangThai {
    private int idTrangThai;
    private String tenTrangThai;

    public TrangThai(int idTrangThai, String tenTrangThai) {
        this.idTrangThai = idTrangThai;
        this.tenTrangThai = tenTrangThai;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
}
