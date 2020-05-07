/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.FileWriterInterface;
import domain.TextRefineryInterface;
import textlogic.TextRefinery;

/**
 *
 * @author niila
 */
public class TextPlayer {
    
    FileWriterInterface fileWriter;
    TextRefineryInterface textRefinery;
    
    public TextPlayer() {
        fileWriter = new FileWriter();
        textRefinery = new TextRefinery();
    }
    
    
    public FileWriterInterface getFileWriterInterface() {
        return this.fileWriter;
    }
    
    public TextRefineryInterface getTextRefineryInterface() {
        return this.textRefinery;
    }
}
