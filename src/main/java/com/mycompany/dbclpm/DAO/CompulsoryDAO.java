/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import static com.mycompany.dbclpm.DAO.DAO.connect;
import com.mycompany.dbclpm.DTO.KB2BHXHBatBuoc;
import com.mycompany.dbclpm.model.Compulsory;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v
 */
public class CompulsoryDAO extends DAO{
    public CompulsoryDAO(){
        super();
        try {
            connectToDB();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Compulsory> getList(int id_member) {
        ArrayList<Compulsory> list = new ArrayList<>();
        String sql = "SELECT * FROM `tbl_bhxh_compulsory` WHERE `id_company` = ? ";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id_member);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {     
                Compulsory c = new Compulsory();
                c.setId(rs.getInt(1));
                c.setTime(rs.getDate(2));
                c.setStatus(rs.getInt(3));
                c.setId_company(id_member);
                list.add(c);
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<KB2BHXHBatBuoc> getList(int id_member, Date time1, Date time2) {
        ArrayList<KB2BHXHBatBuoc> list = new ArrayList<>();
        String sql = "SELECT p2.role, p2.salary, p3.id_member, p1.time "
                + "FROM tbl_bhxh_compulsory as p1, tbl_pay_bhxh_compulsory as p2, tblemployee as p3 "
                + "WHERE ? <= p1.time and ? >= p1.time "
                + "and p1.id_company = ? AND p2.id_bhxh_compulsory = p1.id AND p3.id = p2.id_employee";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setDate(1, time1);
            ps.setDate(2, time2);
            ps.setInt(3, id_member);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {     
                KB2BHXHBatBuoc c = new KB2BHXHBatBuoc();
                c.setRole(rs.getString(1));
                c.setSalary(rs.getInt(2));
                c.setIdMember(rs.getInt(3));
                c.setTime(rs.getDate(4));
                list.add(c);
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
}
