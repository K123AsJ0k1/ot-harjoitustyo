/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.FileWriterInterface;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Tiedoston tallentaja.
 *
 * 
 */
public class FileWriter implements FileWriterInterface  {
    
    /** Tiedoston tallentaja konstruktori.
    *
    * 
    */
    public FileWriter() {
        
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
    
}
