/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;
import com.mycompany.dbclpm.model.Company;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Administrator
 */
public class TCompanyDAO {
    
    private CompanyDAO companyDAO;

    public TCompanyDAO() {
        companyDAO = new CompanyDAO();
    }
    
    public Date stringToDate(String s)  {
        return Date.valueOf(s);
    }
    
    public boolean compareCompany(Company c1, Company c2){
        if(c1.getId() != c2.getId()) return false;
        if(!c1.getIdBHXH().equals(c2.getIdBHXH())) return false;
        if(c1.getIdVung()!= c2.getIdVung()) return false;
        if(c1.getWorkers()!= c2.getWorkers()) return false;
        if(!c1.getJoinDate().toString().equals(c2.getJoinDate().toString())) return false;
        if(!c1.getName().equals(c2.getName())) return false;
        return true;
    }
    
    public boolean compareListCompany(ArrayList<Company> c1, ArrayList<Company> c2){
        if(c1.size() == 0 && c2.size() == 0) return true;
        for(int i=0; i<c1.size(); i++){
            if(c1.get(i).getId() != c2.get(i).getId()) return false;
            if(!c1.get(i).getIdBHXH().equals(c2.get(i).getIdBHXH())) return false;
            if(c1.get(i).getIdVung()!= c2.get(i).getIdVung()) return false;
            if(c1.get(i).getWorkers()!= c2.get(i).getWorkers()) return false;
            if(!c1.get(i).getJoinDate().toString().equals(c2.get(i).getJoinDate().toString())) return false;
            if(!c1.get(i).getName().equals(c2.get(i).getName())) return false;            
        }
        return true;
    }
    
    @Test
    public void TestCaseGetById0() {
        assertTrue(compareCompany(new Company(), companyDAO.getById(100)));
    }
    
    @Test
    public void TestCaseGetById1() {
        Company c1 = new Company(1,"Samsung","CT01",stringToDate("2019-01-01"),1,0);
        Company c2 = companyDAO.getById(1);
        assertTrue(compareCompany(c1, c2));
    }
    
    @Test
    public void TestCaseGetById2() {
        assertTrue(compareCompany(new Company(2,"Blameo","CT02",stringToDate("2019-06-01"),1,0), companyDAO.getById(2)));
    }
    
    @Test
    public void TestCaseGetByCode1() {
        assertTrue(compareCompany(new Company(1,"Samsung","CT01",stringToDate("2019-01-01"),1,0), companyDAO.getByCOde("CT01")));
    }
    
    @Test
    public void TestCaseGetByCode0() {
        assertTrue(compareCompany(new Company(), companyDAO.getByCOde("CT03")));
    }
    
    @Test
    public void TestCaseGetByCode2() {
        assertTrue(compareCompany(new Company(2,"Blameo","CT02",stringToDate("2019-06-01"),1,0), companyDAO.getByCOde("CT02")));
    }
    
    @Test
    public void TestCaseGetListByIdVung1() {
        ArrayList<Company> companys = new ArrayList<>();
        companys.add(new Company(1,"Samsung","CT01",stringToDate("2019-01-01"),1,0));
        companys.add(new Company(2,"Blameo","CT02",stringToDate("2019-06-01"),1,0));
        assertTrue(compareListCompany(companys, companyDAO.getList(1)));
    }
    
    @Test
    public void TestCaseGetListByIdVung0() {
        ArrayList<Company> companys = new ArrayList<>();
        assertTrue(compareListCompany(companys, companyDAO.getList(0)));
    }
    
    @Test
    public void TestCaseGetListByDate() {
        ArrayList<Company> companys = new ArrayList<>();
        companys.add(new Company(1,"Samsung","CT01",stringToDate("2019-01-01"),1,0));
        companys.add(new Company(2,"Blameo","CT02",stringToDate("2019-06-01"),1,0));
        assertTrue(compareListCompany(companys, companyDAO.getListByDate(stringToDate("2019-01-01"),stringToDate("2019-12-01"))));
    }
    
    @Test
    public void TestCaseGetListByDate0() {
        ArrayList<Company> companys = new ArrayList<>();
        assertTrue(compareListCompany(companys, companyDAO.getListByDate(stringToDate("2018-01-01"),stringToDate("2018-12-01"))));
    }
    
}
