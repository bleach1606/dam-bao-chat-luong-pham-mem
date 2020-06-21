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
public class Member {
    private int id;
    private String name;
    private String idNumber;
    private String idBHXH;
    private Date birthday;
    private Date joinDate;
    private int idVung;

    public Member() {
    }

    public Member(int id, String name, String idNumber, String idBHXH, Date birthday, Date joinDate, int idVung) {
        this.id = id;
        this.name = name;
        this.idNumber = idNumber;
        this.idBHXH = idBHXH;
        this.birthday = birthday;
        this.joinDate = joinDate;
        this.idVung = idVung;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdBHXH() {
        return idBHXH;
    }

    public void setIdBHXH(String idBHXH) {
        this.idBHXH = idBHXH;
    }

    
    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", name=" + name + ", idNumber=" + idNumber + ", idBHXH=" + idBHXH + ", birthday=" + birthday + ", joinDate=" + joinDate + ", idVung=" + idVung + '}';
    }

    public boolean equals(Member member) {
        if (member.getId() != id) {
            return false;
        }
//        if (member.getBirthday().toString().trim() != (birthday.toString().trim())) {
//            System.out.println(member.getBirthday().toString().trim());
//            System.out.println();
//            return false;
//        }
        if (!member.getIdBHXH().trim().equals((idBHXH).trim())) {
            System.out.println(member.getIdBHXH());
            System.out.println(idBHXH);
            return false;
        }
        if (member.getIdVung() != idVung) {
            return false;
        }
        if (member.getJoinDate().toString() == null ? (joinDate.toString()) != null : !member.getJoinDate().toString().equals(joinDate.toString())) {
            return false;
        }
        if (!member.getName().equals(name)) {
            return false;
        }
        if (!member.getIdNumber().equals(idNumber)) {
            return false;
        }
        return true;
    }
    
    

}
