package com.example.assandroidcoban_ninhvvph09438;

import java.io.Serializable;

public class lop implements Serializable {
    public String malop;
    public String tenlop;

    public lop() {
    }

    public lop(String malop, String tenlop) {
        this.malop = malop;
        this.tenlop = tenlop;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }
}
