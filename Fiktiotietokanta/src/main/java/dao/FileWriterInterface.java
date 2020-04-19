/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;

/** Tiedoston tallentamisen rajapinta.
 *
 * 
 */
public interface FileWriterInterface {
    /** Tallentaa halutun tiedon halutuksi tiedostoksi.
     * @param information halutut merkkijonot.
     * @param file haluttu tiedosto.
     * @return palauttaa true, jos tiedoston tallentaminen onnistui ja false, jos ei.
     */
    public boolean saveTextAsAFile(String information, File file);
    
}
