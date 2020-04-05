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
public class Voluntary {
    private int id;
    private int salary;
    private Date time;
    private int status;
    private int id_member;

    public Voluntary() {
    }

    public Voluntary(int id, int salary, Date time, int status, int id_member) {
        this.id = id;
        this.salary = salary;
        this.time = time;
        this.status = status;
        this.id_member = id_member;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    public int getId_member() {
        return id_member;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    @Override
    public String toString() {
        return "Voluntary{" + "id=" + id + ", salary=" + salary + ", time=" + time + ", status=" + status + ", id_member=" + id_member + '}';
    }
    
}
