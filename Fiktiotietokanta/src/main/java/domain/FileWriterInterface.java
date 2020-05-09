/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.File;
import javafx.stage.Stage;

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
    
    /** Luo tallentamiseen tarvitun dialogin. 
     * @param primaryStage stage.
     * @param text teksti.
     */
    public void showSaveFileDialog(Stage primaryStage, String text);
    
    public boolean saveTextAsAConfig(String information, FileManagerInterface fileManager);
    
}
