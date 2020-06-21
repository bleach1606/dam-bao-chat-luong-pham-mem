/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import static com.mycompany.dbclpm.DAO.DAO.connect;
import com.mycompany.dbclpm.model.TiLeBHXH;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class TTiLeBHXHDAO {
    private TiLEBHXHDAO tiLEBHXHDAO;

    public TTiLeBHXHDAO() {
        tiLEBHXHDAO = new TiLEBHXHDAO();
    }
    
    @Test
    public void testGetList() {
        ArrayList<TiLeBHXH> tiLeBHXHs = new ArrayList<>();
        tiLeBHXHs.add(new TiLeBHXH(1,"Tự Nguyện", 8, 25));
        tiLeBHXHs.add(new TiLeBHXH(2,"Bắt Buộc", 8, 25));
        assertTrue(compareTiLeList(tiLeBHXHs,tiLEBHXHDAO.getList()));
    }
    
    @Test
    public void testUpdateML() {
        ArrayList<TiLeBHXH> tiLeBHXHs = new ArrayList<>();
        TiLeBHXH tiLeBHXH = new TiLeBHXH(1,"Tự Nguyện",8,25);
        tiLeBHXHs.add(tiLeBHXH);
        tiLeBHXHs.add(new TiLeBHXH(2,"Bắt Buộc", 8, 25));
        try {
            connect.setAutoCommit(false);
            tiLEBHXHDAO.updateML(tiLeBHXH);
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(TCHMucLuongBHXHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            assertTrue(compareTiLeList(tiLeBHXHs,tiLEBHXHDAO.getList()));           
            try {
                connect.rollback();
                connect.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(TCHMucLuongBHXHDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean compareTiLeList(ArrayList<TiLeBHXH> l1, ArrayList<TiLeBHXH> l2) {
        if(l1.isEmpty() && l2.isEmpty()) return true;
        for(int i=0; i<l1.size() ;i++){
            System.out.println(l1.get(i).toString());
            System.out.println(l2.get(i).toString());
            if(l1.get(i).getId() != l2.get(i).getId()) 
                return false;
            if(!l1.get(i).getLoaiBHXH().equals(l2.get(i).getLoaiBHXH())) 
                return false;
            if(l1.get(i).getCaNhan()!= l2.get(i).getCaNhan()) 
                return false;
            if(l1.get(i).getToChuc()!= l2.get(i).getToChuc()) 
                return false;
        }
        return true;
    }
    
}
