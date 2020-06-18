/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.dbclpm.model.CHMucLuongBHXH;
import java.util.ArrayList;

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
    
//    @Test
//    public void testAddML() {
//        String sql = "SET AUTOCOMMIT = 0";
//        ArrayList<CHMucLuongBHXH> cHMucLuongBHXHs = new ArrayList<>();
//        cHMucLuongBHXHs.add(new CHMucLuongBHXH(6,"V01",500000,1000000,1,505000,1600000));
//        cHMucLuongBHXHs.add(new CHMucLuongBHXH(7,"V02",2000000,4000000,1,2020000,1600000));
//        cHMucLuongBHXHs.add(new CHMucLuongBHXH(12,"V03",1000000,2000000,21,1210000,1600000));
//        cHMucLuongBHXHs.add(new CHMucLuongBHXH(15,"V04",1000000,2000000,2147480000,2147483647,1600000));
//        cHMucLuongBHXHs.add(new CHMucLuongBHXH(17,"V05",1000000,2000000, (float) 0.07,1000700,1600000));
//        cHMucLuongBHXHs.add(new CHMucLuongBHXH(25,"v03",12,123, (float) 0.07,14,1600000));
//        assertTrue(compareMucLuongList(cHMucLuongBHXHs,cHMucLuongBHXHDAO.getList()));
//    }

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
    
    
}
