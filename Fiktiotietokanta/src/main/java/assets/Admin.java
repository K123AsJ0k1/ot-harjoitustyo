/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets;

/**
 *
 * @author niila
 */
public class Admin {
    
    private String username;
    private String password;
    
    public Admin(String givenUsername, String givenPassword) {
        this.username = givenUsername;
        this.password = givenPassword;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    
}
