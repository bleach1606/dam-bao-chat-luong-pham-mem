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
public class TiLEBHXHDAO extends DAO{
    public TiLEBHXHDAO() {
        super();
        try {
            connectToDB();
        } catch (Exception ex) {
            Logger.getLogger(CHMucLuongBHXHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<TiLeBHXH> getList() {
        ArrayList<TiLeBHXH> list = new ArrayList();
        String sql = "SELECT * FROM `tbl_tile` WHERE 1";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {
                TiLeBHXH tile = new TiLeBHXH();
                tile.setId(rs.getInt(1));
                tile.setLoaiBHXH(rs.getString(2));
                tile.setCaNhan(rs.getFloat(3));
                tile.setToChuc(rs.getFloat(4));
                tile.setTong(tile.getCaNhan() + tile.getToChuc());
                list.add(tile);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public int addTL(TiLeBHXH tile) {
        int k = -1;
        String sql = "INSERT INTO `tbl_tile`(`loai_BHXH`, `ca_nhan`, `to_chuc`) "
                + "VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tile.getLoaiBHXH());
            ps.setFloat(2, tile.getCaNhan());
            ps.setFloat(3, tile.getToChuc());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                k = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return k;
    }
    
    public int deleteML(int id) {
        int ok = -1;
        String sql = "DELETE FROM `tbl_tile` WHERE id = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ok = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ok;
    }

    public int updateML(TiLeBHXH tile) {
        int k = -1;
        String sql = "UPDATE `tbl_tile` SET `ca_nhan`= ?,`to_chuc`= ? WHERE id = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setFloat(1, tile.getCaNhan());
            ps.setFloat(2, tile.getToChuc());
            ps.setInt(3, tile.getId());
            System.out.println(ps);
            k = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return k;
    }
    
    public static void main(String[] args) throws Exception {
        TiLEBHXHDAO test = new TiLEBHXHDAO();
        System.out.println(test.addTL(new TiLeBHXH(1, "cá nhân", 1, 0, 0)));
//        System.out.println(test.deleteML(2));
//        System.out.println(test.updateML(new CHMucLuongBHXH(3, "3", 0, 123, 0, 0, 123)));
    }
    
}
