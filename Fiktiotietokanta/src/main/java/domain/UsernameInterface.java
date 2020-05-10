/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/** Käyttäjän ja käyttöliittymän rajapinta.
 *
 * 
 */
public interface UsernameInterface {
    
    /** Luo tietokannan.
    *
    * 
     * @return palauttaa true jos tietokanta on luotu ja false jos ei.
    */
    public boolean createUsernameDatabase();
    
    /** Tarkastaa tietokannan olemassaolon.
    *
    * 
     * @return palauttaa true jos tietokanta on luotu ja false jos ei.
    */
    public boolean usernameDatabaseExists();
    
    /** Lisää tietoa käyttäjä tietokantaan.
    *
    * 
     * @return palauttaa tietokannan käyttämän yhteys merkkijonon.
    */
    
    public String getConnectionString();
    
    /** Lisää tietoa käyttäjä tietokantaan.
    *
    * 
     * @param information annettu tieto.
     * @param secondInformation annettu tieto.
     * @param thirdInformation
     * @return palauttaa true, jos tieto on lisätty ja false jos ei.
    */
    
    public boolean addUserInformation(String information, String secondInformation, String thirdInformation);
    
    /** Tarkastaa halutun tiedon tietokannasta.
    *
    * 
     * @param information annettu tieto.
     * @return palauttaa true, jos tieto löytyy ja false jos ei.
    */
    public boolean searchUserInformation(String information);
    
    
    /** Tarkastaa halutun tiedon tietokannasta.
    *
    * 
     * @param username käyttäjä nimi.
     * @param password salasana.
     * @return palauttaa true, jos tieto löytyy ja false jos ei.
    */
    public boolean userPasswordCheck(String username, String password);
    
    /** Hakee halutun käyttäjän id:n tietokannasta.
    *
    * 
     * @param information annettu tieto.
     * @return palauttaa tietokannan antaman id:n, jos käyttäjä löytyy ja palauttaa 0, jos ei.
    */
    public Integer searchUsernameId(String information);
    
    
    /** Hakee halutun käyttäjän id:n tietokannasta.
    *
    * 
     * @param information annettu tieto.
     * @return palauttaa tietokannan antaman id:n, jos käyttäjä löytyy ja palauttaa 0, jos ei.
    */
    public String searrchUsernamePrivilage(String information);
    
    
    
    public List<String> showDatabaseAsAList();
    
    /** Poistaa halutun tiedon käyttäjä tietokannasta.
    *
    * 
     * @param information annettu tieto.
     * @return palauttaa true, jos poisto onnistui ja false jos ei.
    */
    public boolean removeUserInformation(String information);
    /** Poistaa käyttäjä tietokannan kokonaan.
    *
    * 
     * @return palauttaa true, jos poisto onnistui ja false jos ei.
    */
    public boolean removeUsernameDatabase();
    
}
