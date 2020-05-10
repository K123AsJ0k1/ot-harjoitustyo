/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/** Käyttäjä tietokannan ja sovelluksen välinen rajapinta.
 */
public interface UsernameInterface {
    
    /** Luo käyttäjä tietokannan.
     * @return palauttaa true jos tietokanta on luotu ja false, jos ei.
    */
    public boolean createUsernameDatabase();
    
    /** Tarkastaa, onko käyttäjä tietokanta olemassa.
     * @return palauttaa true jos tietokanta on olemassa ja false, jos ei.
    */
    public boolean usernameDatabaseExists();
    
    /** Hakee käyttäjä tietokannan yhteys merkkijonon.
     * @return palauttaa yhteyden sitä edustavana merkkijonona.
    */
    public String getConnectionString();
    
    /** Lisää halutut tiedot käyttäjä tietokantaan.
     * @param information hyödynnettään käyttäjä nimen tuomiseen.
     * @param secondInformation hyödynnettään salasanan tuomiseen.
     * @param thirdInformation hyödynnettään oikeuksien tuomiseen.
     * @return palauttaa true, jos löyty ja false, jos ei.
    */
    public boolean addUserInformation(String information, String secondInformation, String thirdInformation);
    
    /** Hakee halutun tiedon käyttäjä tietokannasta.
     * @param information haettava merkkijono.
     * @return palauttaa true, jos löyty ja false, jos ei.
    */
    public boolean searchUserInformation(String information);
    
    /** Tarkastaa käyttäjän nimen ja salasanan käyttäjä tietokannasta.
     * @param username annettu käyttäjä nimi.
     * @param password annettu salasana;
     * @return palauttaa true, jos löyty ja false, jos ei.
    */
    public boolean userPasswordCheck(String username, String password);
    
    /** Hakee käyttäjän tunnistusnumeron käyttäjä tietokannasta.
     * @param information haettava merkkijono.
     * @return löydyttyä palauttaa saadun numeron ja jos se löydy, niin palauttaa numeron 0.
    */
    public Integer searchUsernameId(String information);
    
    /** Hakee käyttäjän oikeuksia käyttäjä tietokannasta.
     * @param information haettava merkkijono.
     * @return palauttaa löydyttyään käyttäjän oikeus merkkijono ja muuten null.
    */
    public String searchUsernamePrivilage(String information);
    
    /** Luo käyttäjä tietokantaa edustavan listan.
     * @return palauttaa tietokantaa edustavan merkkijono listan.
    */
    public List<String> showDatabaseAsAList();
    
    /** Poistaa halutun tiedot käyttäjä tietokannasta.
     * @param information poistettava tieto.
     * @return true, jos poisto onnistui ja false, jos ei.
    */
    public boolean removeUserInformation(String information);
    
    /** Poistaa käyttäjä tietokannan.
     * @return palauttaa true, jos poisto onnistui ja false, jos ei.
    */
    public boolean removeUsernameDatabase();
    
}
