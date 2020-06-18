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
public class Compulsory {
    private int id;
    private Date time;
    private int status;
    private int id_company;

    public static Date stringToDate(String s)  {
        return Date.valueOf(s);
    }
    
    public Compulsory() {
        this.id = 0;
        this.time = stringToDate("0000-01-01");
        this.status = 0;
        this.id_company = 0;
    }

    public Compulsory(int id, Date time, int status, int id_company) {
        this.id = id;
        this.time = time;
        this.status = status;
        this.id_company = id_company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    @Override
    public String toString() {
        return "Compulsory{" + "id=" + id + ", time=" + time + ", status=" + status + ", id_company=" + id_company + '}';
    }
    
}
