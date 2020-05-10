/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets;

/** Sovelluksessa käyttäjän tietoja varastoiva olio. 
 */
public class User {
    
    private String username;
    private String password;
    private String privilage;
    private Integer id;
    /** Sovelluksessa käyttäjän tietoja varastoiva olio.
     * @param username käyttäjän nimi.
     * @param password käyttäjän salasana.
     * @param privilage käyttäjän oikeudet.
     * @param id käyttjän tunnistenumero.
    */
    public User(String username, String password, String privilage, Integer id) {
        this.username = username;
        this.password = password;
        this.privilage = privilage;
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getPrivilage() {
        return this.privilage;
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
    
    public void setPrivilage(String givenString) {
        this.privilage = givenString;
    }
    
    public void setId(Integer givenInteger) {
        this.id = givenInteger;
    }
    
}
