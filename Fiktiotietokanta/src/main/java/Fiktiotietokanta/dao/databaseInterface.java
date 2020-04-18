/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta.dao;

import java.sql.SQLException;
import java.util.List;

/** Tietokannat ja käyttöliittymän yhdistävä rajapinta.
 * 
 * 
 */
public interface databaseInterface {
    /** Luo tietokannan.
    * 
    * 
     * @return palauttaa true, jos tietokanta on luotu ja false jos ei.
     * @throws java.lang.Exception ottaa vastaan virheet, jotka tapahtuvat.
     * 
    */
    public boolean createDatabase() throws Exception;
    
    
    /** Tarkastaa tietokannan olemassaolon.
    * 
    * 
     * @return palauttaa true, jos tietokanta on olemassa ja false, jos ei.
     * 
    */  
    public boolean databaseExists();
    
    
    /** Lisää tietoa tietokantaan.
    * 
    * 
     * @param information
     * 
     * @return palauttaa true, jos tiedon lisääminen onnistui ja false, jos ei. 
     * 
    */ 
    public boolean addInformation(String information);
    
    
    /** Tarkistaa halutun tiedon tietokannasta.
    * 
    * 
     * @param information
     * 
     * @return palauttaa true, jos tietokannasta löytyy haettu tieto ja false jos ei.
     * 
    */ 
    public boolean searchInformation(String information);
    
    
    /** Hakee tietokannan antamaan id haetulle tiedolle.
    * 
    * 
     * @param information
     * 
     * @return palauttaa tietokannan antaman id onnistuessa ja nollan, jos haettua tietoa ei löydy tietokannasta.
     * 
    */ 
    public Integer searchInfromationId(String information);
    
    
    public String searchInformationTextIdentity(String information);
    
    public List<String> showDatabaseAsAList();
    
    public List<String> showDatabaseAsARestrictedList(String information);
    
    public boolean removeInformation(String information);
    
    public boolean removeDatabase() throws Exception;
    
}
