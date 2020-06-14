/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import static com.mycompany.dbclpm.DAO.DAO.connect;
import com.mycompany.dbclpm.DTO.KB2BHXHBatBuoc;
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
public class MemberDAO extends DAO{
    public MemberDAO(){
        super();
        try {
            connectToDB();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Member> getList(int id) {
        ArrayList<Member> list = new ArrayList<>();
        
        String sql = "SELECT * FROM `tblmember` WHERE `id_vung` = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {                
                Member m = new Member();
                m.setId(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setIdNumber(rs.getString(3));
                m.setIdBHXH(rs.getString(4));
                m.setBirthday(rs.getDate(5));
                m.setJoinDate(rs.getDate(6));
                m.setIdVung(rs.getInt(7));
                System.out.println(m.toString());
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Member> getListByCompany(int id) {
        ArrayList<Member> list = new ArrayList<>();
        
        String sql = "SELECT mem.* FROM `tblemployee` AS emp, tblmember AS mem "
                + "WHERE emp.id_company = ? AND emp.id_member = mem.id";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {                
                Member m = new Member();
                m.setId(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setIdNumber(rs.getString(3));
                m.setIdBHXH(rs.getString(4));
                m.setBirthday(rs.getDate(5));
                m.setJoinDate(rs.getDate(6));
                m.setIdVung(rs.getInt(7));
                System.out.println(m.toString());
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Member getListByID(String bhxh, String cmnd) throws Exception {
        if(checkSQl(bhxh) || checkSQl(cmnd)) {
            throw new Exception("Chứa kí tự đặc biết");
        }
        Member m = null;
        String sql = "SELECT * FROM `tblmember` WHERE `id_number` = ? OR `id_BHXH` = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, cmnd);
            ps.setString(2, bhxh);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) { 
                m = new Member();
                m.setId(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setIdNumber(rs.getString(3));
                m.setIdBHXH(rs.getString(4));
                m.setBirthday(rs.getDate(5));
                m.setJoinDate(rs.getDate(6));
                m.setIdVung(rs.getInt(7));
                System.out.println(m.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    
    public Member getID(int id) {
        String sql = "SELECT * FROM `tblmember` WHERE `id` = ?";
        Member m = new Member();
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            if (rs.next()) {                
                m.setId(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setIdNumber(rs.getString(3));
                m.setIdBHXH(rs.getString(4));
                m.setBirthday(rs.getDate(5));
                m.setJoinDate(rs.getDate(6));
                m.setIdVung(rs.getInt(7));
                System.out.println(m.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    
    public ArrayList<Member> getListByTime(Date date1, Date date2) {
        ArrayList<Member> list = new ArrayList<>();
        
        String sql = "SELECT DISTINCT id_member FROM `tbl_pay_bhxh_voluntary` WHERE ? <= time AND  `time` <= ? AND status = 0;";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setDate(1, date1);
            ps.setDate(2, date2);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {                
                int k = rs.getInt(1);
                Member m = getID(k);
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        MemberDAO member = new MemberDAO();
    }
}
