/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/** Käyttäjän ja käyttöliittymän rajapinta.
 *
 * 
 */
public interface UsernameInterface {
    
    /** Luo tietokannan.
    *
    * 
     * @return palauttaa true jos tietokanta on luotu ja false jos ei.
     * @throws java.lang.Exception virhe.
    */
    public boolean createUsernameDatabase() throws Exception;
    
    /** Tarkastaa tietokannan olemassaolon.
    *
    * 
     * @return palauttaa true jos tietokanta on luotu ja false jos ei.
    */
    public boolean usernameDatabaseExists();
    
    /** Lisää tietoa käyttäjä tietokantaan.
    *
    * 
     * @param information annettu tieto.
     * @return palauttaa true, jos tieto on lisätty ja false jos ei.
    */
    public boolean addUserInformation(String information);
    
    /** Tarkastaa halutun tiedon tietokannasta.
    *
    * 
     * @param information annettu tieto.
     * @return palauttaa true, jos tieto löytyy ja false jos ei.
    */
    public boolean searchUserInformation(String information);
    
    /** Hakee halutun käyttäjän id:n tietokannasta.
    *
    * 
     * @param information annettu tieto.
     * @return palauttaa tietokannan antaman id:n, jos käyttäjä löytyy ja palauttaa 0, jos ei.
    */
    public Integer searchUsernameId(String information);
    
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
     * @throws java.lang.Exception virhe.
    */
    public boolean removeUsernameDatabase() throws Exception;
    
}
