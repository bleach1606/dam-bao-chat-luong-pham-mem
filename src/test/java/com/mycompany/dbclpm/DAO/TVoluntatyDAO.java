/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import com.mycompany.dbclpm.model.Voluntary;
import com.mycompany.dbclpm.model.Vung;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class TVoluntatyDAO {
    
    private VoluntatyDAO voluntatyDAO;
    
    public TVoluntatyDAO() {
        voluntatyDAO = new VoluntatyDAO();
    }
    
    public Date stringToDate(String s)  {
        return Date.valueOf(s);
    }
    
    public boolean compareListVoluntary(ArrayList<Voluntary> v1, ArrayList<Voluntary>  v2){
        if(v1.size() == 0 && v2.size() == 0) return true;
        for(int i=0; i<v1.size() ;i++){
            if(v1.get(i).getId() != v2.get(i).getId()) return false;
            if(v1.get(i).getSalary()!= v2.get(i).getSalary()) return false;
            if(v1.get(i).getStatus()!= v2.get(i).getStatus()) return false;
            if(v1.get(i).getId_member()!= v2.get(i).getId_member()) return false;
            if(!v1.get(i).getTime().toString().equals(v2.get(i).getTime().toString())) return false;
        }
        return true;
    }
    
    @Test
    public void testGetListByMember6() {
        ArrayList<Voluntary> voluntarys = new ArrayList<>();
        voluntarys.add(new Voluntary(1,10000000,stringToDate("2019-05-01"),1,6));
        voluntarys.add(new Voluntary(2,10000000,stringToDate("2019-06-01"),1,6));
        voluntarys.add(new Voluntary(3,10000000,stringToDate("2019-07-01"),1,6));
        voluntarys.add(new Voluntary(4,10000000,stringToDate("2019-08-01"),1,6));
        voluntarys.add(new Voluntary(5,10000000,stringToDate("2019-09-01"),1,6));
        voluntarys.add(new Voluntary(6,10000000,stringToDate("2019-10-01"),1,6));
        voluntarys.add(new Voluntary(7,10000000,stringToDate("2019-11-01"),1,6));
        voluntarys.add(new Voluntary(8,10000000,stringToDate("2019-12-01"),0,6));
                
        assertTrue(compareListVoluntary(voluntarys, voluntatyDAO.getList(6,stringToDate("2019-01-01"),stringToDate("2019-12-01"))));
    }
    
    @Test
    public void testGetListByMember7() {
        ArrayList<Voluntary> voluntarys = new ArrayList<>();
        voluntarys.add(new Voluntary(9,5000000,stringToDate("2019-01-01"),1,7));
        voluntarys.add(new Voluntary(10,5000000,stringToDate("2019-02-01"),1,7));
        voluntarys.add(new Voluntary(11,5000000,stringToDate("2019-03-01"),1,7));
        voluntarys.add(new Voluntary(12,5000000,stringToDate("2019-04-01"),1,7));
        voluntarys.add(new Voluntary(13,5000000,stringToDate("2019-05-01"),1,7));
        voluntarys.add(new Voluntary(14,5000000,stringToDate("2019-06-01"),1,7));
        voluntarys.add(new Voluntary(15,5000000,stringToDate("2019-07-01"),1,7));
        voluntarys.add(new Voluntary(16,5000000,stringToDate("2019-08-01"),1,7));
        voluntarys.add(new Voluntary(17,5000000,stringToDate("2019-09-01"),1,7));
        voluntarys.add(new Voluntary(18,5000000,stringToDate("2019-10-01"),1,7));
        voluntarys.add(new Voluntary(19,5000000,stringToDate("2019-11-01"),1,7));
        voluntarys.add(new Voluntary(20,5000000,stringToDate("2019-12-01"),0,7));
                
        assertTrue(compareListVoluntary(voluntarys, voluntatyDAO.getList(7,stringToDate("2019-01-01"),stringToDate("2019-12-01"))));
    }
    
    @Test
    public void testGetListByMember9() {
        ArrayList<Voluntary> voluntarys = new ArrayList<>();
        voluntarys.add(new Voluntary(21,7000000,stringToDate("2019-02-01"),1,9));
        voluntarys.add(new Voluntary(22,7000000,stringToDate("2019-03-01"),1,9));
        voluntarys.add(new Voluntary(23,7000000,stringToDate("2019-04-01"),1,9));
        voluntarys.add(new Voluntary(24,7000000,stringToDate("2019-05-01"),1,9));
        voluntarys.add(new Voluntary(25,7000000,stringToDate("2019-06-01"),1,9));
        voluntarys.add(new Voluntary(26,7000000,stringToDate("2019-07-01"),1,9));
                
        assertTrue(compareListVoluntary(voluntarys, voluntatyDAO.getList(9,stringToDate("2019-01-01"),stringToDate("2019-07-01"))));
    }
    
    @Test
    public void testGetListByMember0() {
        ArrayList<Voluntary> voluntarys = new ArrayList<>();
        assertTrue(compareListVoluntary(voluntarys, voluntatyDAO.getList(100,stringToDate("2019-01-01"),stringToDate("2019-12-01"))));
    }
    
    @Test
    public void testGetListByMember90() {
        ArrayList<Voluntary> voluntarys = new ArrayList<>();
        assertTrue(compareListVoluntary(voluntarys, voluntatyDAO.getList(9,stringToDate("2018-01-01"),stringToDate("2018-12-01"))));
    }
    
}
