/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;
import com.mycompany.dbclpm.DTO.KB2BHXHBatBuoc;
import com.mycompany.dbclpm.model.CHMucLuongBHXH;
import org.junit.Test;
import com.mycompany.dbclpm.model.Compulsory;
import java.sql.Date;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class TCompulsoryDAO {
    
    private CompulsoryDAO compulsoryDAO;

    public static Date stringToDate(String s)  {
        return Date.valueOf(s);
    }
    
    public TCompulsoryDAO() {
        compulsoryDAO = new CompulsoryDAO();
    }
    
    @Test
    public void testGetListByIdCompany0() {
        ArrayList<Compulsory> compulsorys = new ArrayList<>();
        assertTrue(compareCompulsoryList(compulsorys,compulsoryDAO.getList(100)));
    }

    @Test
    public void testGetListCompulsoryByIdCompany1() {
        ArrayList<Compulsory> compulsorys = new ArrayList<>();
        compulsorys.add(new Compulsory(1,stringToDate("2019-01-01"),1,1));
        compulsorys.add(new Compulsory(2,stringToDate("2019-02-01"),1,1));
        compulsorys.add(new Compulsory(3,stringToDate("2019-03-01"),1,1));
        compulsorys.add(new Compulsory(4,stringToDate("2019-04-01"),1,1));
        compulsorys.add(new Compulsory(5,stringToDate("2019-05-01"),1,1));
        compulsorys.add(new Compulsory(6,stringToDate("2019-06-01"),1,1));
        compulsorys.add(new Compulsory(7,stringToDate("2019-07-01"),1,1));
        compulsorys.add(new Compulsory(8,stringToDate("2019-08-01"),1,1));
        compulsorys.add(new Compulsory(9,stringToDate("2019-09-01"),1,1));
        compulsorys.add(new Compulsory(10,stringToDate("2019-10-01"),1,1));
        compulsorys.add(new Compulsory(11,stringToDate("2019-11-01"),0,1));
        compulsorys.add(new Compulsory(12,stringToDate("2019-12-01"),0,1));
        assertTrue(compareCompulsoryList(compulsorys,compulsoryDAO.getList(1)));
    }
    
    @Test
    public void testGetListCompulsoryByIdCompany2() {
        ArrayList<Compulsory> compulsorys = new ArrayList<>();
        compulsorys.add(new Compulsory(13,stringToDate("2019-06-01"),1,2));
        compulsorys.add(new Compulsory(14,stringToDate("2019-07-01"),1,2));
        compulsorys.add(new Compulsory(15,stringToDate("2019-08-01"),1,2));
        compulsorys.add(new Compulsory(16,stringToDate("2019-09-01"),1,2));
        compulsorys.add(new Compulsory(17,stringToDate("2019-10-01"),1,2));
        compulsorys.add(new Compulsory(18,stringToDate("2019-11-01"),0,2));
        compulsorys.add(new Compulsory(19,stringToDate("2019-12-01"),0,2));
        assertTrue(compareCompulsoryList(compulsorys,compulsoryDAO.getList(2)));
    }
    
    @Test
    public void testGetListKB2BHXHBatBuoc10() {
        ArrayList<KB2BHXHBatBuoc> kB2BHXHBatBuocs = new ArrayList<>();
        assertTrue(compareKB2BHXHBatBuocList(kB2BHXHBatBuocs,
                compulsoryDAO.getList(1,stringToDate("2018-01-01"),stringToDate("2018-12-01"))));
    }
    
    @Test
    public void testGetListKB2BHXHBatBuoc20() {
        ArrayList<KB2BHXHBatBuoc> kB2BHXHBatBuocs = new ArrayList<>();
        assertTrue(compareKB2BHXHBatBuocList(kB2BHXHBatBuocs,
                compulsoryDAO.getList(2,stringToDate("2018-01-01"),stringToDate("2018-12-01"))));
    }

    @Test
    public void testGetListKB2BHXHBatBuoc0() {
        ArrayList<KB2BHXHBatBuoc> kB2BHXHBatBuocs = new ArrayList<>();
        assertTrue(compareKB2BHXHBatBuocList(kB2BHXHBatBuocs,
                compulsoryDAO.getList(100,stringToDate("2019-01-01"),stringToDate("2019-12-01"))));
    }
    
    @Test
    public void testGetListKB2BHXHBatBuoc1() {
        ArrayList<KB2BHXHBatBuoc> kB2BHXHBatBuocs = new ArrayList<>();
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(10000000,"DEV",4,stringToDate("2019-01-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(7000000,"TESTER",8,stringToDate("2019-01-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(10000000,"DEV",4,stringToDate("2019-02-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(7000000,"TESTER",8,stringToDate("2019-02-01")));
        assertTrue(compareKB2BHXHBatBuocList(kB2BHXHBatBuocs,
                compulsoryDAO.getList(1,stringToDate("2019-01-01"),stringToDate("2019-02-01"))));
    }
    
    @Test
    public void testGetListKB2BHXHBatBuoc2() {
        ArrayList<KB2BHXHBatBuoc> kB2BHXHBatBuocs = new ArrayList<>();
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(10000000,"DEV",4,stringToDate("2019-11-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(7000000,"HR",5,stringToDate("2019-11-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(8000000,"TESTER",8,stringToDate("2019-11-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(10000000,"DEV",4,stringToDate("2019-12-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(7000000,"HR",5,stringToDate("2019-12-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(8000000,"TESTER",8,stringToDate("2019-12-01")));
        assertTrue(compareKB2BHXHBatBuocList(kB2BHXHBatBuocs,
                compulsoryDAO.getList(1,stringToDate("2019-11-01"),stringToDate("2020-01-01"))));
    }
    
    @Test
    public void testGetListKB2BHXHBatBuoc3() {
        ArrayList<KB2BHXHBatBuoc> kB2BHXHBatBuocs = new ArrayList<>();
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(7000000,"TESTER",10,stringToDate("2019-11-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(8000000,"DEV",11,stringToDate("2019-11-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(7000000,"DEV",12,stringToDate("2019-11-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(7000000,"TESTER",10,stringToDate("2019-12-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(8000000,"DEV",11,stringToDate("2019-12-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(8000000,"DEV",12,stringToDate("2019-12-01")));
        assertTrue(compareKB2BHXHBatBuocList(kB2BHXHBatBuocs,
                compulsoryDAO.getList(2,stringToDate("2019-11-01"),stringToDate("2020-01-01"))));
    }
    
    @Test
    public void testGetListKB2BHXHBatBuoc4() {
        ArrayList<KB2BHXHBatBuoc> kB2BHXHBatBuocs = new ArrayList<>();
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(8000000,"TESTER",8,stringToDate("2019-06-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(6000000,"TESTER",10,stringToDate("2019-06-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(7000000,"DEV",11,stringToDate("2019-06-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(6000000,"TESTER",10,stringToDate("2019-07-01")));
        kB2BHXHBatBuocs.add(new KB2BHXHBatBuoc(7000000,"DEV",11,stringToDate("2019-07-01")));
        assertTrue(compareKB2BHXHBatBuocList(kB2BHXHBatBuocs,
                compulsoryDAO.getList(2,stringToDate("2019-06-01"),stringToDate("2019-07-01"))));
    }

    private boolean compareCompulsoryList(ArrayList<Compulsory> l1, ArrayList<Compulsory> l2) {
        if(l1.isEmpty() && l2.isEmpty()) return true;
        if(l1.size() != l2.size()) return false;
        for(int i=0; i<l1.size() ;i++){
            if(l1.get(i).getId() != l2.get(i).getId()) return false;
            if(l1.get(i).getStatus()!= l2.get(i).getStatus()) return false;
            if(l1.get(i).getId_company()!= l2.get(i).getId_company()) return false;
            if(!l1.get(i).getTime().toString().equals(l2.get(i).getTime().toString())) return false;
        }
        return true;
    }

    private boolean compareKB2BHXHBatBuocList(ArrayList<KB2BHXHBatBuoc> l1, ArrayList<KB2BHXHBatBuoc> l2) {
        if(l1.isEmpty() && l2.isEmpty()) return true;
        if(l1.size() != l2.size()) return false;
        for(int i=0; i<l1.size() ;i++){
            if(l1.get(i).getIdMember()!= l2.get(i).getIdMember()) return false;
            if(l1.get(i).getSalary()!= l2.get(i).getSalary()) return false;
            if(!l1.get(i).getTime().toString().equals(l2.get(i).getTime().toString())) return false;
            if(!l1.get(i).getRole().equals(l2.get(i).getRole())) return false;
        }
        return true;
    }
    
}
