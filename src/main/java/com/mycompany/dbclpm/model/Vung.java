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
public class Vung {
    private int id;
    private String vung;

    public Vung() {
        this.id = 0;
        this.vung = "";
    }

    public Vung(int id, String vung) {
        this.id = id;
        this.vung = vung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVung() {
        return vung;
    }

    public void setVung(String vung) {
        this.vung = vung;
    }
    
    
}
