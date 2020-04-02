/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import static com.mycompany.dbclpm.DAO.DAO.connect;
import com.mycompany.dbclpm.model.CHMucLuongBHXH;
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
public class CHMucLuongBHXHDAO extends DAO{
    public CHMucLuongBHXHDAO() {
        super();
        try {
            connectToDB();
        } catch (Exception ex) {
            Logger.getLogger(CHMucLuongBHXHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<CHMucLuongBHXH> getList() {
        ArrayList<CHMucLuongBHXH> list = new ArrayList();
        String sql = "SELECT * FROM `tbl_mucluong` WHERE 1";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()) {
                CHMucLuongBHXH mucluong = new CHMucLuongBHXH();
                mucluong.setId(rs.getInt(1));
                mucluong.setVung(rs.getString(2));
                mucluong.setLuongMin(rs.getInt(3));
                mucluong.setLuongMax(rs.getInt(4));
                mucluong.setTiLeLD(rs.getFloat(5));
                mucluong.setLdQuaDT(rs.getInt(6));
                mucluong.setLuongCB(rs.getInt(7));
                list.add(mucluong);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public CHMucLuongBHXH addML(CHMucLuongBHXH mucluong) {
        int k = -1;
        String sql = "INSERT INTO `tbl_mucluong`(`vung`, `luong_min`, `luong_max`, `ti_le`, `ld_qua_dt`, `luong_cb`) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mucluong.getVung());
            ps.setInt(2, mucluong.getLuongMin());
            ps.setInt(3, mucluong.getLuongMax());
            ps.setFloat(4, mucluong.getTiLeLD());
            ps.setInt(5, mucluong.getLdQuaDT());
            ps.setInt(6, mucluong.getLuongCB());
            System.out.println(ps);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                k = rs.getInt(1);
                mucluong.setId(k);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return mucluong;
    }
    
    public int deleteML(int id) {
        int ok = -1;
        String sql = "DELETE FROM `tbl_mucluong` WHERE id = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            System.out.println(ps);
            ok = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ok;
    }

    public int updateML(CHMucLuongBHXH mucluong) {
        int k = -1;
        String sql = "UPDATE `tbl_mucluong` SET `vung`= ?,`luong_min`= ?,`luong_max`= ?,"
                + "`ti_le`= ?,`ld_qua_dt`= ?,`luong_cb`= ? WHERE id = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, mucluong.getVung());
            ps.setInt(2, mucluong.getLuongMin());
            ps.setInt(3, mucluong.getLuongMax());
            ps.setFloat(4, mucluong.getTiLeLD());
            ps.setInt(5, mucluong.getLdQuaDT());
            ps.setInt(6, mucluong.getLuongCB());
            ps.setInt(7, mucluong.getId());
            System.out.println(ps);
            k = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return k;
    }
    
    public static void main(String[] args) throws Exception {
        CHMucLuongBHXHDAO test = new CHMucLuongBHXHDAO();
//        System.out.println(test.addML(new CHMucLuongBHXH(1, "1", 0, 0, 0, 0, 0)));
//        System.out.println(test.deleteML(2));
        System.out.println(test.updateML(new CHMucLuongBHXH(3, "3", 0, 123, 0, 0, 123)));
    }
}
