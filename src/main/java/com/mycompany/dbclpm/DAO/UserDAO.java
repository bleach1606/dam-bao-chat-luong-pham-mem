package com.mycompany.dbclpm.DAO;
import com.mycompany.dbclpm.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends DAO{
    public UserDAO(){
        super();
        try {
            connectToDB();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User CheckUser(String username, String password) throws Exception{
        if(checkSQl(password) || checkSQl(username)) {
            throw new Exception("Chứa kí tự đặc biết");
        }
        User user = null;
        String sql = "select * from tbl_user where username = ? and password = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) throws Exception {
        UserDAO test = new UserDAO();
        System.out.println(test.CheckUser("admin", "123456").toString());
    }
}
