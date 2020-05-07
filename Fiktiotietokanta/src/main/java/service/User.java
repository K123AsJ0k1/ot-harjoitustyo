/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author niila
 */
public class User {
    
    private String username;
    private String password;
    private Integer id;
    
    public User(String username, String password, Integer id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setUsername(String givenString) {
        this.username = givenString;
    }
    
    public void setPassword(String givenString) {
        this.password = givenString;
    }
    
    public void setId(Integer givenInteger) {
        this.id = givenInteger;
    }
    
}
