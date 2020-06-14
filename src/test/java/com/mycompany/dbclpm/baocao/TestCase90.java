/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.baocao;

import com.mycompany.dbclpm.DAO.CompanyDAO;
import com.mycompany.dbclpm.model.Company;
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
 * @author v
 */
public class TestCase90 {
    
    private CompanyDAO companyDAO;
    
    public TestCase90() {
        companyDAO = new CompanyDAO();
    }
    
    public Date stringToDate(String s)  {
        return Date.valueOf(s);
    }
    
    public boolean compareCompany(ArrayList<Company> list1,ArrayList<Company> list2) {
        if(list1.size() != list2.size()) return false;
        for(int i = 0; i< list1.size(); i++) {
            Company company1 = list1.get(i);
            Company company2 = list2.get(i);
            if (company1.equals(company2)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    
    @Test
    public void TestCaseID1() {
        ArrayList<Company> list = new ArrayList<>();
        list.add(new Company(1, "Samsung", "CT01", stringToDate("2019-01-01"), 1, 3));
        list.add(new Company(2, "Blameo", "CT02", stringToDate("2019-06-01"), 1, 3));
        assertTrue(compareCompany(list, companyDAO.getList(1)));
    }
    
}
