package com.example.appdoctruyen.models;

public class TacGia {
    private int idTacGia;
    private String tenTacGia;

    public TacGia(int idTacGia, String tenTacGia) {
        this.idTacGia = idTacGia;
        this.tenTacGia = tenTacGia;
    }

    public int getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(int idTacGia) {
        this.idTacGia = idTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }
}
