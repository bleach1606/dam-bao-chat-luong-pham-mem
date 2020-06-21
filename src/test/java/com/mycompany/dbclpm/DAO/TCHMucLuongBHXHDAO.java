/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;
import static com.mycompany.dbclpm.DAO.DAO.connect;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.dbclpm.model.CHMucLuongBHXH;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class TCHMucLuongBHXHDAO {
    private CHMucLuongBHXHDAO cHMucLuongBHXHDAO;

    public TCHMucLuongBHXHDAO() {
        cHMucLuongBHXHDAO = new CHMucLuongBHXHDAO();
    }
    
    @Test
    public void testGetList() {
        ArrayList<CHMucLuongBHXH> cHMucLuongBHXHs = new ArrayList<>();
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(6,"V01",500000,1000000,1,505000,1600000));
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(7,"V02",2000000,4000000,1,2020000,1600000));
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(12,"V03",1000000,2000000,21,1210000,1600000));
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(15,"V04",1000000,2000000,2147480000,2147483647,1600000));
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(17,"V05",1000000,2000000, (float) 0.07,1000700,1600000));
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(25,"v03",12,123, (float) 0.07,14,1600000));
        assertTrue(compareMucLuongList(cHMucLuongBHXHs,cHMucLuongBHXHDAO.getList()));
    }
    
    @Test
    public void testAddML() {
        CHMucLuongBHXH cHMucLuongBHXH = new CHMucLuongBHXH("ABC",1,10, (float) 0.07,10,1);
        try {
            connect.setAutoCommit(false);
            cHMucLuongBHXHDAO.addML(cHMucLuongBHXH);
        } catch (SQLException ex) {
            Logger.getLogger(TCHMucLuongBHXHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            assertTrue(compareMucLuong(cHMucLuongBHXH,cHMucLuongBHXHDAO.getList().get(6)));       
            try {
                connect.rollback();
                connect.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(TCHMucLuongBHXHDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Test
    public void testUpdateML() {
        CHMucLuongBHXH cHMucLuongBHXH = new CHMucLuongBHXH(6,"V100",10000,95800,40,5050,5900);
        try {
            connect.setAutoCommit(false);
            cHMucLuongBHXHDAO.updateML(cHMucLuongBHXH);
        } catch (SQLException ex) {
            Logger.getLogger(TCHMucLuongBHXHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            assertTrue(compareMucLuong(cHMucLuongBHXH,cHMucLuongBHXHDAO.getList().get(0)));       
            try {
                connect.rollback();
                connect.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(TCHMucLuongBHXHDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Test
    public void testDeleteML() {
        ArrayList<CHMucLuongBHXH> cHMucLuongBHXHs = new ArrayList<>();
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(7,"V02",2000000,4000000,1,2020000,1600000));
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(12,"V03",1000000,2000000,21,1210000,1600000));
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(15,"V04",1000000,2000000,2147480000,2147483647,1600000));
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(17,"V05",1000000,2000000, (float) 0.07,1000700,1600000));
        cHMucLuongBHXHs.add(new CHMucLuongBHXH(25,"v03",12,123, (float) 0.07,14,1600000));
        try {
            connect.setAutoCommit(false);
            cHMucLuongBHXHDAO.deleteML(6);
        } catch (SQLException ex) {
            Logger.getLogger(TCHMucLuongBHXHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            assertTrue(compareMucLuongList(cHMucLuongBHXHs,cHMucLuongBHXHDAO.getList()));     
            try {
                connect.rollback();
                connect.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(TCHMucLuongBHXHDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean compareMucLuongList(ArrayList<CHMucLuongBHXH> l1, ArrayList<CHMucLuongBHXH> l2) {
        if(l1.isEmpty() && l2.isEmpty()) return true;
        for(int i=0; i<l1.size() ;i++){
            if(l1.get(i).getId() != l2.get(i).getId()) return false;
            if(!l1.get(i).getVung().equals(l2.get(i).getVung())) return false;
            if(l1.get(i).getLdQuaDT()!= l2.get(i).getLdQuaDT()) return false;
            if(l1.get(i).getLuongCB()!= l2.get(i).getLuongCB()) return false;
            if(l1.get(i).getLuongMax()!= l2.get(i).getLuongMax()) return false;
            if(l1.get(i).getLuongMin()!= l2.get(i).getLuongMin()) return false;
            if(l1.get(i).getTiLeLD()!= l2.get(i).getTiLeLD()) return false;
        }
        return true;
    }

    private boolean compareMucLuong(CHMucLuongBHXH l1, CHMucLuongBHXH l2) {
        if(!l1.getVung().equals(l2.getVung())) return false;
        if(l1.getLdQuaDT()!= l2.getLdQuaDT()) return false;
        if(l1.getLuongCB()!= l2.getLuongCB()) return false;
        if(l1.getLuongMax()!= l2.getLuongMax()) return false;
        if(l1.getLuongMin()!= l2.getLuongMin()) return false;
        if(l1.getTiLeLD()!= l2.getTiLeLD()) return false;
        return true;
    }
    
    
}
