package com.example.appdoctruyen.models;

public class Truyen {
    private int id;
    private String tenTruyen;
    private int idTrangThai;
    private int idLoaiTruyen;
    private byte[] anh;

    public Truyen(int id, String tenTruyen, int idTrangThai, int idLoaiTruyen, byte[] anh) {
        this.id = id;
        this.tenTruyen = tenTruyen;
        this.idTrangThai = idTrangThai;
        this.idLoaiTruyen = idLoaiTruyen;
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public int getIdLoaiTruyen() {
        return idLoaiTruyen;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public void setIdLoaiTruyen(int idLoaiTruyen) {
        this.idLoaiTruyen = idLoaiTruyen;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }
}
