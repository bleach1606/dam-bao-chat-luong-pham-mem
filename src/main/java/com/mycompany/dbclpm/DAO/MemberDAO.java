/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import static com.mycompany.dbclpm.DAO.DAO.connect;
import com.mycompany.dbclpm.model.Member;
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
    
    public static void main(String[] args) {
        MemberDAO member = new MemberDAO();
        System.out.println(member.getList(1).size());
    }
}
