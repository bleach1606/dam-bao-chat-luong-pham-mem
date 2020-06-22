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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author v
 */
public class TestCase92 {
    
    private MemberDAO memberDAO;
    
    public TestCase92() {
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
    
    // với công ty có id : 1
    @Test
    public void test92ID1(){
         
        ArrayList<Member> list = new ArrayList<Member>();
        list.add(new Member(4, "Nguyen Van Sinh", "1111", "HD01",stringToDate("1994-02-28"), stringToDate("2019-01-01"), 1));
        list.add(new Member(5, "Nguyen Thi Kim", "1113", "HD03",stringToDate("1995-04-03"), stringToDate("2019-05-01"), 1));
        list.add(new Member(8, "Luu A Binh", "1121", "CG01",stringToDate("1995-01-01"), stringToDate("2019-01-01"), 1));
        
        assertTrue(compareMember(list, memberDAO.getListByCompany(1)));
    }
    
    
//    với công ty có id : 2
    @Test
    public void test92ID2() {
        ArrayList<Member> list = new ArrayList<Member>();
        list.add(new Member(10, "Nguyen Thi Binh", "1123", "CG03",stringToDate("1995-04-01"), stringToDate("2019-06-01"), 1));
        list.add(new Member(11, "Nguyen Thi Binh", "1131", "TX01",stringToDate("1995-01-01"), stringToDate("2019-06-01"), 1));
        list.add(new Member(12, "Nguyen Thu Thuy", "1132", "TX02",stringToDate("1995-01-02"), stringToDate("2019-09-01"), 1));
        
        assertTrue(compareMember(list, memberDAO.getListByCompany(2)));
    }


    private void assertArrayEquals(ArrayList<Member> list, ArrayList<Member> listByCompany) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
