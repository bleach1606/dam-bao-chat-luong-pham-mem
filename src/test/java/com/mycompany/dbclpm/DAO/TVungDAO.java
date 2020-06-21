/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import com.mycompany.dbclpm.model.Vung;
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
public class TVungDAO {
    
    private VungDAO vungDAO;
    
    public TVungDAO() {
        vungDAO = new VungDAO();
    }
    
    public boolean compareVung(Vung v1, Vung v2){
        if(v1.getId() != v2.getId()) return false;
        if(!v1.getVung().equals(v2.getVung())) return false;
        return true;
    }
    
    public boolean compareListVung(ArrayList<Vung> v1, ArrayList<Vung>  v2){
        if(v1.size() == 0 && v2.size() == 0) return true;
        for(int i=0; i<v1.size() ;i++){
            if(v1.get(i).getId() != v2.get(i).getId()) return false;
            if(!v1.get(i).getVung().equals(v2.get(i).getVung())) return false;
        }
        return true;
    }
    
    @Test
    public void testGetById1() {
        assertTrue(compareVung(new Vung(1,"Ha Dong"), vungDAO.getById(1)));
    }
    
    @Test
    public void testGetById0() {
        assertTrue(compareVung(new Vung(), vungDAO.getById(10)));
    }

    @Test
    public void testGetList1() {
        ArrayList<Vung> vungs = new ArrayList<>();
        vungs.add(new Vung(1,"Ha Dong"));
        assertTrue(compareListVung(vungs, vungDAO.getList()));
    }
    
}
