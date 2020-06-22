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
public class TestCase85 {
    
    private MemberDAO memberDAO;
    
    public TestCase85() {
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
                System.out.println(member1.toString());
                System.out.println(member2.toString());
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void TestCasegetByID6() {
        assertTrue(new Member(6, "Luu Quang Anh", "1114", "HD04",stringToDate("1995-01-09"), stringToDate("2019-05-01"), 1)
                .equals(memberDAO.getID(6)));
    }
    
    @Test
    public void TestCasegetByID7() {
        assertTrue(new Member(7, "Le Quang Ninh", "1115", "HD05",stringToDate("1991-12-03"), stringToDate("2019-01-01"), 1)
                .equals(memberDAO.getID(7)));
    }
    
    @Test
    public void TestCasegetByID9() {
        assertTrue(new Member(9, "Pham Van Tinh", "1122", "CG02",stringToDate("1995-01-01"), stringToDate("2019-02-01"), 1)
                .equals(memberDAO.getID(9)));
    }
    
    @Test
    public void TestCasegetByID13() {
        assertTrue(new Member(13, "Nguyen Thi Anh", "1133", "TX03",stringToDate("1995-01-03"), stringToDate("2019-06-01"), 1)
                .equals(memberDAO.getID(13)));
    }
    
    
    @Test
    public void TestCaseGetListByTime() {
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member(6, "Luu Quang Anh", "1114", "HD04",stringToDate("1995-01-09"), stringToDate("2019-05-01"), 1));
        list.add(new Member(7, "Le Quang Ninh", "1115", "HD05",stringToDate("1991-12-03"), stringToDate("2019-01-01"), 1));
        list.add(new Member(9, "Pham Van Tinh", "1122", "CG02",stringToDate("1995-01-01"), stringToDate("2019-02-01"), 1));
        list.add(new Member(13, "Nguyen Thi Anh", "1133", "TX03",stringToDate("1995-01-03"), stringToDate("2019-06-01"), 1));
        assertTrue(compareMember(list, memberDAO.getListByTime(stringToDate("2019-01-01"), stringToDate("2019-12-31"))));
    }
}
