/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbclpm.model;

/**
 *
 * @author v
 */
public class User {
    private int id;
    private String username;
    private String password;

    public User() {
        this.id = 0;
        this.password = "";
        this.username = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }

    public boolean equals(User user) {
        if(user == null) return false;
        if (0 == user.getId() ||user.id != id) 
            return false;
        if (user.getPassword() == "" || !user.getPassword().equals(password)) 
            return false;
        if (user.getUsername() == "" || !user.getUsername().equals(username)) 
            return false;
        return true;
    }
    
    

}
