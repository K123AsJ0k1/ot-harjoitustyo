/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.SQLException;
import java.util.List;

/** Tietokannat ja käyttöliittymän yhdistävä rajapinta.
 * 
 * 
 */
public interface DatabaseInterface {
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
     * 
     * 
     * @param information haluttu tieto.
     * @return palauttaa true, jos tiedon lisääminen onnistui ja false, jos ei. 
     * 
    */ 
    public boolean addInformation(String information);
    
    
    /** Tarkistaa halutun tiedon tietokannasta.
    * 
    * 
     * 
     * 
     * @param information haluttu tieto.
     * @return palauttaa true, jos tietokannasta löytyy haettu tieto ja false jos ei.
     * 
    */ 
    public boolean searchInformation(String information);
    
    
    /** Hakee tietokannan antamaan id haetulle tiedolle.
    * 
    * 
     * 
     * 
     * @param information haluttu tieto.
     * @return palauttaa tietokannan antaman id onnistuessa ja nollan, jos haettua tietoa ei löydy tietokannasta.
     * 
    */ 
    public Integer searchInfromationId(String information);
    
    /** Hakee tietokannassa olevat data identiteetit.
    * 
    * 
     * 
     * 
     * @param information haluttu tieto.
     * @return palauttaa tietokannasta saadun tekstin jos onnistuu ja tyhjän merkkijonon jos ei.
     * 
    */ 
    public String searchInformationTextIdentity(String information);
    /** Antaa tietokannan listana.
    * 
    * 
     * 
     * 
     * @return palauttaa tietokantaa edustavan listan jos se onnistuu ja tyhjä null, jos ei.
     * 
    */ 
    public List<String> showDatabaseAsAList();
    
    /** Antaa tietokannan rajoitettuna listana.
    * 
    * 
     * 
     * 
     * @param information haluttu tieto.
     * @return palauttaa tietokantaa edustavan listan jos se onnistuu ja tyhjä null, jos ei.
     * 
    */ 
    public List<String> showDatabaseAsARestrictedList(String information);
    /** Poistaa halutun asian tietokannasta.
    * 
    * 
     * 
     * 
     * @param information haluttu tieto.
     * @return palauttaa true, jos poisto onnistui ja false jos ei.
     * 
    */ 
    public boolean removeInformation(String information);
    /** Poistaa tietokannan kokonaan.
    * 
    * 
     * @return palauttaa true, jos poisto onnistui ja false jos ei.
     * @throws java.lang.Exception virhe.
    */ 
    public boolean removeDatabase() throws Exception;
    
}
