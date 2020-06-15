/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.DAO;

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
public class TMemberDAO {
    
    private MemberDAO memberDAO;
    
    public TMemberDAO() {
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
    public void getList() {
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member(4, "Nguyen Van Sinh", "1111", "HD01",stringToDate("1994-02-28"), stringToDate("2019-01-01"), 1));
        list.add(new Member(5, "Nguyen Thi Kim", "1113", "HD03",stringToDate("1995-04-03"), stringToDate("2019-05-01"), 1));
        list.add(new Member(6, "Luu Quang Anh", "1114", "HD04",stringToDate("1995-01-09"), stringToDate("2019-05-01"), 1));
        list.add(new Member(7, "Le Quang Ninh", "1115", "HD05",stringToDate("1991-12-03"), stringToDate("2019-01-01"), 1));
        list.add(new Member(8, "Luu A Binh", "1121", "CG01",stringToDate("1995-04-01"), stringToDate("2019-01-01"), 1));
        list.add(new Member(9, "Pham Van Tinh", "1122", "CG02",stringToDate("1995-01-01"), stringToDate("2019-02-01"), 1));
        list.add(new Member(10, "Nguyen Thi Binh", "1123", "CG03",stringToDate("1995-01-02"), stringToDate("2019-06-01"), 1));
        list.add(new Member(11, "Nguyen Thi Binh", "1131", "TX01",stringToDate("1995-01-01"), stringToDate("2019-06-01"), 1));
        list.add(new Member(12, "Nguyen Thu Thuy", "1132", "TX02",stringToDate("1995-01-02"), stringToDate("2019-09-01"), 1));
        list.add(new Member(13, "Nguyen Thi Anh", "1133", "TX03",stringToDate("1995-01-03"), stringToDate("2019-06-01"), 1));
        assertTrue(compareMember(list, memberDAO.getList(1)));
    }

    @Test
    public void getListByCompanyId2() {
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member(10, "Nguyen Thi Binh", "1123", "CG03",stringToDate("1995-01-02"), stringToDate("2019-06-01"), 1));
        list.add(new Member(11, "Nguyen Thi Binh", "1131", "TX01",stringToDate("1995-01-01"), stringToDate("2019-06-01"), 1));
        list.add(new Member(12, "Nguyen Thu Thuy", "1132", "TX02",stringToDate("1995-01-02"), stringToDate("2019-09-01"), 1));
        assertTrue(compareMember(list, memberDAO.getListByCompany(2)));
    }
    
    @Test
    public void getListByCompanyId1() {
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member(4, "Nguyen Van Sinh", "1111", "HD01",stringToDate("1994-02-28"), stringToDate("2019-01-01"), 1));
        list.add(new Member(5, "Nguyen Thi Kim", "1113", "HD03",stringToDate("1995-04-03"), stringToDate("2019-05-01"), 1));
        list.add(new Member(8, "Luu A Binh", "1121", "CG01",stringToDate("1995-04-01"), stringToDate("2019-01-01"), 1));
        assertTrue(compareMember(list, memberDAO.getListByCompany(1)));
    }
    
    @Test
    public void getListByCompanyId0() {
        ArrayList<Member> list = new ArrayList<>();
        assertTrue(compareMember(list, memberDAO.getListByCompany(0)));
    }
   
    @Test
    public void getListByCompanyId3() {
        ArrayList<Member> list = new ArrayList<>();
        assertTrue(compareMember(list, memberDAO.getListByCompany(3)));
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
    public void TestCaseGetListByTimeIn() {
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member(6, "Luu Quang Anh", "1114", "HD04",stringToDate("1995-01-09"), stringToDate("2019-05-01"), 1));
        list.add(new Member(7, "Le Quang Ninh", "1115", "HD05",stringToDate("1991-12-03"), stringToDate("2019-01-01"), 1));
        list.add(new Member(9, "Pham Van Tinh", "1122", "CG02",stringToDate("1995-01-01"), stringToDate("2019-02-01"), 1));
        list.add(new Member(13, "Nguyen Thi Anh", "1133", "TX03",stringToDate("1995-01-03"), stringToDate("2019-06-01"), 1));
        assertTrue(compareMember(list, memberDAO.getListByTime(stringToDate("2019-01-01"), stringToDate("2019-12-31"))));
    }
    
    @Test
    public void TestGetListByTimeOut() {
        ArrayList<Member> list = new ArrayList<>();
        assertTrue(compareMember(list, memberDAO.getListByTime(stringToDate("2018-01-01"), stringToDate("2018-12-31"))));
    }
}
