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
public class TiLeBHXH {
    private int id;
    private String loaiBHXH;
    private float caNhan;
    private float toChuc;
    private float tong;

    public TiLeBHXH() {
    }

    public TiLeBHXH(int id, String loaiBHXH, float caNhan, float toChuc, float tong) {
        this.id = id;
        this.loaiBHXH = loaiBHXH;
        this.caNhan = caNhan;
        this.toChuc = toChuc;
        this.tong = tong;
    }

    public TiLeBHXH(int id, float caNhan, float toChuc) {
        this.id = id;
        this.caNhan = caNhan;
        this.toChuc = toChuc;
    }
    
    public TiLeBHXH(int id, String loaiBHXH, float caNhan, float toChuc) {
        this.id = id;
        this.loaiBHXH = loaiBHXH;
        this.caNhan = caNhan;
        this.toChuc = toChuc;
        this.tong = caNhan + toChuc;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaiBHXH() {
        return loaiBHXH;
    }

    public void setLoaiBHXH(String loaiBHXH) {
        this.loaiBHXH = loaiBHXH;
    }

    public float getCaNhan() {
        return caNhan;
    }

    public void setCaNhan(float caNhan) {
        this.caNhan = caNhan;
    }

    public float getToChuc() {
        return toChuc;
    }

    public void setToChuc(float toChuc) {
        this.toChuc = toChuc;
    }

    public float getTong() {
        return tong;
    }

    public void setTong(float tong) {
        this.tong = tong;
    }

    @Override
    public String toString() {
        return "TiLeBHXH{" + "id=" + id + ", loaiBHXH=" + loaiBHXH + ", caNhan=" + caNhan + ", toChuc=" + toChuc + ", tong=" + tong + '}';
    }
    
}
