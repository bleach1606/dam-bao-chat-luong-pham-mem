/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

import com.mycompany.dbclpm.DAO.MemberDAO;
import com.mycompany.dbclpm.DAO.TMemberDAO;
import com.mycompany.dbclpm.model.Member;
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
public class TestCase77 {
    
    
    private MemberDAO memberDAO;
    
    public TestCase77() {
        memberDAO = new MemberDAO();
    }
    
    public Date stringToDate(String s)  {
        return Date.valueOf(s);
    }
    
    public boolean compareMember(ArrayList<Member> list1,ArrayList<Member> list2) {
        if(list1.size() != list2.size()) return false;
        for(int i = 0; i< list1.size(); i++) {
            Member member1 = list1.get(i);
            Member member2 = list2.get(i);
            if (member1.equals(member2)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void TestCasegetByID4() {
        assertTrue(new Member(4, "Nguyen Van Sinh", "1111", "HD01",stringToDate("1994-02-28"), stringToDate("2019-01-01"), 1)
                .equals(memberDAO.getID(4)));
    }
    
    @Test
    public void TestCasegetByID5() {
        assertTrue(new Member(5, "Nguyen Thi Kim", "1113", "HD03",stringToDate("1995-04-03"), stringToDate("2019-05-01"), 1)
                .equals(memberDAO.getID(5)));
    }
    
    @Test
    public void TestCasegetByID8() {
        assertTrue(new Member(8, "Luu A Binh", "1121", "CG01",stringToDate("1995-04-01"), stringToDate("2019-01-01"), 1)
                .equals(memberDAO.getID(8)));
    }
    
    @Test
    public void TestCasegetListByCompany1() {
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member(4, "Nguyen Van Sinh", "1111", "HD01",stringToDate("1994-02-28"), stringToDate("2019-01-01"), 1));
        list.add(new Member(5, "Nguyen Thi Kim", "1113", "HD03",stringToDate("1995-04-03"), stringToDate("2019-05-01"), 1));
        list.add(new Member(8, "Luu A Binh", "1121", "CG01",stringToDate("1995-04-01"), stringToDate("2019-01-01"), 1));
        assertTrue(compareMember(list, memberDAO.getListByCompany(1)));
    }
    
}
