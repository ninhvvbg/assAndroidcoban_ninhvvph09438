package com.example.assandroidcoban_ninhvvph09438.quanlysinhvien;

import java.io.Serializable;

public class sinhvien implements Serializable {
    private String id;
    private String name;
    private String ngaysinh;

    public sinhvien() {
    }

    public sinhvien(String id, String name, String ngaysinh) {
        this.id = id;
        this.name = name;
        this.ngaysinh = ngaysinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
}