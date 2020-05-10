/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

/** UserTableScenen käyttämä olio.
 */
public class UserTable {
    
    private String numberIdentity = null;
    private String usernameIdentity = null;
    private String privilageIdentity = null;
    /** Olion konstruktori.
     * @param givenNumberId oliolle annettu käyttäjän tunnistenumero.
     * @param givenUsername oliolle annettu käyttäjä nimi.
     * @param givenPrivilage oliolle annettu käyttäjän oikeudet.
    */
    public UserTable(String givenNumberId, String givenUsername, String givenPrivilage) {
        this.numberIdentity = givenNumberId;
        this.usernameIdentity = givenUsername;
        this.privilageIdentity = givenPrivilage;
    }
    
    public String getNumberIdentity() {
        return this.numberIdentity;
    }
    
    public String getUsernameIdentity() {
        return this.usernameIdentity;
    }
    
    public String getPrivilageIdentity() {
        return this.privilageIdentity;
    }
    
    @Override
    public String toString() {
        return this.numberIdentity + "/" + this.usernameIdentity + "/" + this.privilageIdentity;
    }
    
    
    
}
