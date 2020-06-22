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
public class TestCase78 {
    
    private MemberDAO memberDAO;
    
    public TestCase78() {
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
    public void TestCasegetByID10() {
        assertTrue(new Member(10, "Nguyen Thi Binh", "1123", "CG03",stringToDate("1995-01-02"), stringToDate("2019-06-01"), 1)
                .equals(memberDAO.getID(10)));
    }
    
    @Test
    public void TestCasegetByID11() {
        assertTrue(new Member(11, "Nguyen Thi Binh", "1131", "TX01",stringToDate("1995-01-01"), stringToDate("2019-06-01"), 1)
                .equals(memberDAO.getID(11)));
    }
    
    @Test
    public void TestCasegetByID12() {
        assertTrue(new Member(13, "Nguyen Thi Anh", "1133", "TX03",stringToDate("1995-01-03"), stringToDate("2019-06-01"), 1)
                .equals(memberDAO.getID(13)));
    }
    
    @Test
    public void TestCasegetListByCompany1() {
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member(10, "Nguyen Thi Binh", "1123", "CG03",stringToDate("1995-01-02"), stringToDate("2019-06-01"), 1));
        list.add(new Member(11, "Nguyen Thi Binh", "1131", "TX01",stringToDate("1995-01-01"), stringToDate("2019-06-01"), 1));
        list.add(new Member(12, "Nguyen Thu Thuy", "1132", "TX02",stringToDate("1995-01-02"), stringToDate("2019-09-01"), 1));
        assertTrue(compareMember(list, memberDAO.getListByCompany(2)));
    }
}
