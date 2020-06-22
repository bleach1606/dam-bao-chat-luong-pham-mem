/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import com.mycompany.dbclpm.model.User;
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
public class TUserDAO {
    
    private UserDAO userDAO;
    private User admin;
    
    public TUserDAO() {
        userDAO = new UserDAO();
        admin = new User(1, "admin", "123456");
    }
    
    @Test
    public void TestCase1() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("", "")));
    }
    
    @Test
    public void TestCase2() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin", "")));
    }
    
    @Test
    public void TestCase3() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase4() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin~!@#$%^&*()_+=-.,;'`", "123456")));
    }
    
    @Test
    public void TestCase5() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("nkt", "123456")));
    }
    
    @Test
    public void TestCase6() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("nkt", "123")));
    }
    
    @Test
    public void TestCase7() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin", "12356")));
    }
    
    
    @Test
    public void testCase8() throws Exception {
        assertTrue(admin.equals(userDAO.CheckUser("admin", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase9() throws Exception {
        assertTrue(admin.equals(userDAO.CheckUser("admin~", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase10() throws Exception {
        admin.equals(userDAO.CheckUser("admin!", "123456"));
    }
    
    @Test(expected = Exception.class)
    public void TestCase11() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin@`", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase12() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin#", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase13() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin$", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase14() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin%", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase15() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin^", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase16() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin&", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase17() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin*", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase18() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin(", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase19() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin_", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase20() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin-.,;'`", "123456")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase21() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin", "~!@#$%^&*()_+=-.,;'`")));
    }
    
    @Test(expected = Exception.class)
    public void TestCase22() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("~!@#$%^&*()_+=-.,;'`", "~!@#$%^&*()_+=-.,;'`")));
    }
    
    
    
}
