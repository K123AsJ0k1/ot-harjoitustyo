/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/** Ominaisuus ja parametri tietokantojen ja sovelluksen välinen rajapinta.
 * 
 * 
 */
public interface DatabaseInterface {
    
    /** Luo tietokannan.
     * @return palauttaa true jos tietokanta on luotu ja false, jos ei.
    */
    public boolean createDatabase();
    
    /** Tarkastaa, onko tietokanta olemassa.
     * @return palauttaa true jos tietokanta on olemassa ja false, jos ei.
    */
    public boolean databaseExists();
    
    /** Hakee tietokannan yhteys merkkijonon.
     * @return palauttaa yhteyden sitä edustavana merkkijonona.
    */
    public String getConnectionString();
    
    /** Lisää halutut tiedot tietokantaan.
     * @param information hyödynnettään tarvittavan tiedon tuomiseen.
     * @return palauttaa true, jos löyty ja false, jos ei.
    */
    public boolean addInformation(String information);
    
    /** Tarkastaa halutun tiedon olemassa olon tietokannasta.
     * @param information haettava merkkijono.
     * @return palauttaa true, jos löyty ja false, jos ei.
    */
    public boolean searchInformation(String information);
    
    /** Hakee tarkastettavan tiedon tunnistusnumeron tietokannasta.
     * @param information haettava merkkijono.
     * @return löydyttyä palauttaa saadun numeron ja jos se löydy, niin palauttaa numeron 0.
    */
    public Integer searchInfromationId(String information);
    
    /** Hakee halutun identiteetin tietokannasta.
     * @param information haettava tunnistus numero.
     * @return palauttaa halutun merkkijono sen löydyttyessä ja null, jos ei.
    */
    public String searchInformationTextIdentity(String information);
    
    /** Luo listan tietokannasta.
     * @return palauttaa tietokannasta luodun lista.
    */
    public List<String> showDatabaseAsAList();
    
    /** Luo rajoitetun listan tietokannasta.
     * @param information annettu rajoitus.
     * @return palauttaa tietokannasta luodun lista.
    */
    public List<String> showDatabaseAsARestrictedList(String information);
    
    /** Poistaa haluttuja tietoja tietokannasta.
     * @param information poistettava tieto.
     * @return palauttaa true, jos poisto onnistui ja false, jos ei.
    */
    public boolean removeInformation(String information);
    
    /** Poistaa tietokannan.
     * @return palauttaa true, jos poisto onnistui ja false, jos ei.
    */
    public boolean removeDatabase();
    
}
