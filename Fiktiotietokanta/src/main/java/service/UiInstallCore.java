/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import assets.Configuration;
import assets.TextAreaMode;
import domain.FileManagerInterface;
import filelogic.FileManager;
import uilogic.UiInstallSupportLogic;
import uilogic.UiInstallTransitionsLogic;

/**
 *
 * @author niila
 */
public class UiInstallCore {
    
    ScenePlayer scenePlayer;
    Configuration configuration;
    TextAreaMode textAreaMode;
    FileManagerInterface fileManager;
    UiInstallSupportLogic uiInstallSupportLogic;
    UiInstallTransitionsLogic uiInstallTransitionsLogic;
    
    public UiInstallCore() {
        scenePlayer = new ScenePlayer();
        configuration = new Configuration();
        textAreaMode = new TextAreaMode();
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
