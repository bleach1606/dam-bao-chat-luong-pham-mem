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
    
    @Test
    public void TestCase4() throws Exception {
        assertFalse(admin.equals(userDAO.CheckUser("admin~!@#$%^&*()_+=-.,;'`", "123456")));
    }
    
    @Test
    public void testCase8() throws Exception {
        assertTrue(admin.equals(userDAO.CheckUser("admin", "password")));
    }
    
    
}
