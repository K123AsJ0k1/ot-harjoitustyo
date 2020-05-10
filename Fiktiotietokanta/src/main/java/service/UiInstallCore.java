/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import assets.Configuration;
import assets.TextAreaMode;
import domain.FileManagerInterface;
import domain.FileWriterInterface;
import filelogic.FileManager;
import filelogic.FileWriter;
import uilogic.UiInstallSupportLogic;
import uilogic.UiInstallTransitionsLogic;

/** Sovelluksen asennuksen toiminan ydin.
 */
public class UiInstallCore {

    ScenePlayer scenePlayer;
    Configuration configuration;
    TextAreaMode textAreaMode;
    FileWriterInterface fileWriter;
    FileManagerInterface fileManager;
    UiInstallSupportLogic uiInstallSupportLogic;
    UiInstallTransitionsLogic uiInstallTransitionsLogic;
    
    /** Konstruktori.
    */
    public UiInstallCore() {
        scenePlayer = new ScenePlayer();
        configuration = new Configuration();
        textAreaMode = new TextAreaMode();
        fileWriter = new FileWriter();
        fileManager = new FileManager();
        uiInstallSupportLogic = new UiInstallSupportLogic(this.scenePlayer);
        uiInstallTransitionsLogic = new UiInstallTransitionsLogic(this.scenePlayer);
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }

    public TextAreaMode getTextAreaMode() {
        return this.textAreaMode;
    }

    public FileWriterInterface getFileWriter() {
        return this.fileWriter;
    }

    public FileManagerInterface getFileManager() {
        return this.fileManager;
    }

    public ScenePlayer getScenePlayer() {
        return this.scenePlayer;
    }

    public UiInstallSupportLogic getUiInstallSupportLogic() {
        return this.uiInstallSupportLogic;
    }

    public UiInstallTransitionsLogic getUiInstallTransitionsLogic() {
        return this.uiInstallTransitionsLogic;
    }

}
