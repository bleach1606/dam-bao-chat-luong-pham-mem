/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import static com.mycompany.dbclpm.DAO.DAO.connect;
import com.mycompany.dbclpm.model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v
 */
public class VungDAO extends DAO{
    public VungDAO(){
        super();
        try {
            connectToDB();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Vung getById(int id) {
        Vung vung = new Vung();
        String sql = "SELECT * FROM `tbl_vung` WHERE id = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            if (rs.next()) {
                vung.setId(rs.getInt(1));
                vung.setVung(rs.getString(2));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return vung;
    }

    public ArrayList<Vung> getList() {
        ArrayList<Vung> list = new ArrayList();
        String sql = "SELECT * FROM `tbl_vung` WHERE 1";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {
                Vung vung = new Vung();
                vung.setId(rs.getInt(1));
                vung.setVung(rs.getString(2));
                list.add(vung);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        VungDAO test = new VungDAO();
        System.out.println(test.getList());
    }
    
}
