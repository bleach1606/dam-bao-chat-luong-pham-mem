/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import static com.mycompany.dbclpm.DAO.DAO.connect;
import com.mycompany.dbclpm.model.Company;
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
public class CompanyDAO extends DAO{
    public CompanyDAO(){
        super();
        try {
            connectToDB();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
