/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import static com.mycompany.dbclpm.DAO.DAO.connect;
import com.mycompany.dbclpm.model.Compulsory;
import com.mycompany.dbclpm.model.Voluntary;
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
public class VoluntatyDAO extends DAO{
    public VoluntatyDAO(){
        super();
        try {
            connectToDB();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Voluntary> getList(int id_company, Date time1, Date time2) {
        System.out.println(id_company);
        ArrayList<Voluntary> list = new ArrayList<>();
        String sql = "SELECT * FROM `tbl_pay_bhxh_voluntary` WHERE `id_member` = ? and ? <= time and ? >= time";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id_company);
            ps.setDate(2, time1);
            ps.setDate(3, time2);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {     
                Voluntary c = new Voluntary();
                c.setId(rs.getInt(1));
                c.setSalary(rs.getInt(2));
                c.setTime(rs.getDate(3));
                c.setStatus(rs.getInt(4));
                c.setId_member(id_company);
                list.add(c);
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
