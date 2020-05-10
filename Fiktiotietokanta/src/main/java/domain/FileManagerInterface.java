/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/** Tiedostojen hallitsemisessa käytetty rajapinta.
 */
public interface FileManagerInterface {
    /** Hakee käyttäjän nykyisen polun.
     * @return antaa polun merkkijonona.
    */
    public String getUserPath();
    
    /** Hakee sovelluksen luoman tietokanta kansion polun.
     * @return antaa polun merkkijonona.
    */
    public String getDirectoryPath();
    
    /** Tarkastaa config tiedoston olemassaolon.
     * @return antaa true, jos se on olemassa ja false, jos ei.
    */
    public Boolean configFileExists();
        
    /** Luo testeille tarvitun tietokanta kansion.
     * @return antaa true, jos luonti oli tarpeellista ja false, jos ei.
    */
    public Boolean createStandardDirectory();
    
    /** Luo sovellukselle muokatun tietokanta kansion.
     * @param givenName tiedoston annettu nimi.
     * @return antaa true, jos luonti oli tarpeellista ja false, jos ei.
    */
    public Boolean createModifiedDirectory(String givenName);
   
    
}
