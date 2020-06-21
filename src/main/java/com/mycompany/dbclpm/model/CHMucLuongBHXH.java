/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.model;

/**
 *
 * @author v
 */
public class CHMucLuongBHXH {
    private int id;
    private String vung;
    private int luongMin;
    private int luongMax;
    private float tiLeLD;
    private int ldQuaDT;
    private int luongCB;

    public CHMucLuongBHXH() {
        this.id = 0;
        this.vung = "";
        this.luongMin = 0;
        this.luongMax = 0;
        this.tiLeLD = 0;
        this.ldQuaDT = 0;
        this.luongCB = 0;
    }

    public CHMucLuongBHXH(int id, String vung, int luongMin, int luongMax, float tiLeLD, int ldQuaDT, int luongCB) {
        this.id = id;
        this.vung = vung;
        this.luongMin = luongMin;
        this.luongMax = luongMax;
        this.tiLeLD = tiLeLD;
        this.ldQuaDT = ldQuaDT;
        this.luongCB = luongCB;
    }

    public CHMucLuongBHXH(String vung, int luongMin, int luongMax, float tiLeLD, int ldQuaDT, int luongCB) {
        this.vung = vung;
        this.luongMin = luongMin;
        this.luongMax = luongMax;
        this.tiLeLD = tiLeLD;
        this.ldQuaDT = ldQuaDT;
        this.luongCB = luongCB;
    }
    
    public String getVung() {
        return vung;
    }

    public void setVung(String vung) {
        this.vung = vung;
    }

    public int getLuongMin() {
        return luongMin;
    }

    public void setLuongMin(int luongMin) {
        this.luongMin = luongMin;
    }

    public int getLuongMax() {
        return luongMax;
    }

    public void setLuongMax(int luongMax) {
        this.luongMax = luongMax;
    }

    public float getTiLeLD() {
        return tiLeLD;
    }

    public void setTiLeLD(float tiLeLD) {
        this.tiLeLD = tiLeLD;
    }

    public int getLdQuaDT() {
        return ldQuaDT;
    }

    public void setLdQuaDT(int ldQuaDT) {
        this.ldQuaDT = ldQuaDT;
    }

    public int getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(int luongCB) {
        this.luongCB = luongCB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CHMucLuongBHXH{" + "id=" + id + ", vung=" + vung + ", luongMin=" + luongMin + ", luongMax=" + luongMax + ", tiLeLD=" + tiLeLD + ", ldQuaDT=" + ldQuaDT + ", luongCB=" + luongCB + '}';
    }

    
}
