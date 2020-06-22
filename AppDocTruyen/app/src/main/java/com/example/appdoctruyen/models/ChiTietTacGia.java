package com.example.appdoctruyen.models;

public class ChiTietTacGia {
    private int idTacGia;
    private int idTruyen;

    public ChiTietTacGia(int idTacGia, int idTruyen) {
        this.idTacGia = idTacGia;
        this.idTruyen = idTruyen;
    }

    public int getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(int idTacGia) {
        this.idTacGia = idTacGia;
    }

    public int getIdTruyen() {
        return idTruyen;
    }

    public void setIdTruyen(int idTruyen) {
        this.idTruyen = idTruyen;
    }
}
