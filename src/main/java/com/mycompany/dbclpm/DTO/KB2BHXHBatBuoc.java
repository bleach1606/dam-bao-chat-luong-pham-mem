/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DTO;

import java.sql.Date;

/**
 *
 * @author v
 */
public class KB2BHXHBatBuoc {
    private int salary;
    private String role;
    private int idMember;
    private Date time;

    public KB2BHXHBatBuoc() {
    }

    public KB2BHXHBatBuoc(int salary, String role, int idMember) {
        this.salary = salary;
        this.role = role;
        this.idMember = idMember;
    }

    public KB2BHXHBatBuoc(int salary, String role, int idMember, Date time) {
        this.salary = salary;
        this.role = role;
        this.idMember = idMember;
        this.time = time;
    }
    
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "KB2BHXHBatBuoc{" + "salary=" + salary + ", role=" + role + ", idMember=" + idMember + ", time=" + time + '}';
    }

    
}
