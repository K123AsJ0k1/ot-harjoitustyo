/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filelogic;

import domain.FileManagerInterface;
import domain.FileWriterInterface;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/** Sovelluksen tiedostojen tallentamiseen käytetty kirjoittaja.
 */
public class FileWriter implements FileWriterInterface {

    /** Konstruktori.
     */
    public FileWriter() {

    }
    @Override
    public void showSaveFileDialog(Stage primaryStage, String text) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(primaryStage);

        if (file != null) {
            saveTextAsAFile(text, file);
        }
    }

    @Override
    public boolean saveTextAsAFile(String information, File file) {

        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(information);
            writer.close();
            return true;
        } catch (IOException ex) {

        }

        return false;
    }

    @Override
    public boolean saveTextAsAConfig(String information, FileManagerInterface fileManager) {
        String path = fileManager.getUserPath() + File.separator + "config";
        File configFile = new File(path);
        
        try {
            PrintWriter writer;
            writer = new PrintWriter(configFile);
            writer.println(information);
            writer.close();
            return true;
        } catch (IOException ex) {

        }

        return false;
         
    }
    
    

}
