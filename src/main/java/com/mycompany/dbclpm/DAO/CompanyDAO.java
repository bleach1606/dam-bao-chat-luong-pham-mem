/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import static com.mycompany.dbclpm.DAO.DAO.connect;
import com.mycompany.dbclpm.model.Company;
import com.mycompany.dbclpm.model.Member;
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
public class CompanyDAO extends DAO{
    public CompanyDAO(){
        super();
        try {
            connectToDB();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Company getById(int id) {
        Company c = new Company();
        String sql = "SELECT * FROM `tblcompany` WHERE id = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            if (rs.next()) {                
                c.setId(rs.getInt(1));
                c.setIdBHXH(rs.getString(2));
                c.setName(rs.getString(3));
                c.setJoinDate(rs.getDate(4));
                c.setIdVung(rs.getInt(5));
                c.setWorkers(rs.getInt(6));
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public Company getByCOde(String code) {
        Company c = new Company();
        String sql = "SELECT * FROM `tblcompany` WHERE id_BHXH = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            if (rs.next()) {                
                c.setId(rs.getInt(1));
                c.setIdBHXH(rs.getString(2));
                c.setName(rs.getString(3));
                c.setJoinDate(rs.getDate(4));
                c.setIdVung(rs.getInt(5));
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public ArrayList<Company> getListByDate(Date date1, Date date2) {
        ArrayList<Company> list = new ArrayList<>();
        String sql = "SELECT DISTINCT id_company FROM `tbl_bhxh_compulsory` WHERE ? <= time AND  `time` <= ? AND status = 0";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setDate(1, date1);
            ps.setDate(2, date2);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {                
                Company c = getById(rs.getInt(1));
                System.out.println(c.toString());
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Company> getList(int id) {
        ArrayList<Company> list = new ArrayList<>();
        String sql = "SELECT * FROM `tblcompany` WHERE id_vung = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {                
                Company c = new Company();
                c.setId(rs.getInt(1));
                c.setIdBHXH(rs.getString(2));
                c.setName(rs.getString(3));
                c.setJoinDate(rs.getDate(4));
                c.setIdVung(rs.getInt(5));
                c.setWorkers(rs.getInt(6));
                System.out.println(c.toString());
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        CompanyDAO member = new CompanyDAO();
        System.out.println(member.getList(1).size());
    }
    
}
