/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.FileManagerInterface;
import filelogic.FileWriter;
import domain.FileWriterInterface;
import domain.TextRefineryInterface;
import filelogic.FileManager;
import textlogic.TextRefinery;

/**
 * Sovelluksen tekstin toiminnan hallitsija.
 */
public class TextPlayer {

    FileWriterInterface fileWriter;
    FileManagerInterface fileManager;
    TextRefineryInterface textRefinery;

    /**
     * Konstruktori.
     */
    public TextPlayer() {
        fileWriter = new FileWriter();
        fileManager = new FileManager();
        textRefinery = new TextRefinery();
    }

    public FileWriterInterface getFileWriterInterface() {
        return this.fileWriter;
    }

    public FileManagerInterface getFileManagerInterface() {
        return this.fileManager;
    }

    public TextRefineryInterface getTextRefineryInterface() {
        return this.textRefinery;
    }

}
