/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.model;

import java.sql.Date;

/**
 *
 * @author v
 */
public class Company {
    private int id;
    private String name;
    private String idBHXH;
    private Date joinDate;
    private int idVung;
    private int workers;
    
    public static Date stringToDate(String s)  {
        return Date.valueOf(s);
    }

    public Company() {
        this.id = 0;
        this.name = "";
        this.idBHXH = "";
        this.joinDate = stringToDate("0000-01-01");
        this.idVung = 0;
        this.workers = 0;
    }

    public Company(int id, String name, String idBHXH, Date joinDate, int idVung) {
        this.id = id;
        this.name = name;
        this.idBHXH = idBHXH;
        this.joinDate = joinDate;
        this.idVung = idVung;
    }

    public Company(int id, String name, String idBHXH, Date joinDate, int idVung, int workers) {
        this.id = id;
        this.name = name;
        this.idBHXH = idBHXH;
        this.joinDate = joinDate;
        this.idVung = idVung;
        this.workers = workers;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdBHXH() {
        return idBHXH;
    }

    public void setIdBHXH(String idBHXH) {
        this.idBHXH = idBHXH;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getIdVung() {
        return idVung;
    }

    public void setIdVung(int idVung) {
        this.idVung = idVung;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", idBHXH=" + idBHXH + ", joinDate=" + joinDate + ", idVung=" + idVung + ", workers=" + workers + '}';
    }

    public boolean equals(Company company) {
        
        if (company.getId() != id) 
            return false;
        if (!company.getIdBHXH().equals(idBHXH)) 
            return false;
        if (company.getIdVung() != idVung) 
            return false;
        if (!company.getName().equals(name)) 
            return false;
        if (company.getWorkers() != workers) 
            return false;

        return true;
    }
}
