/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets;

/** Asennuksessa käytetty pääkäyttäjä olio.
 */
public class Admin {
    
    private String username;
    private String password;
    
    /** pääkäyttäjän olion konstuktori.
     * @param givenUsername annettu käyttäjä nimi.
     * @param givenPassword annettu salasana.
    */
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
    
    @Override
    public String toString() {
        return this.username + "/" + this.password;
    }
    
    
}
