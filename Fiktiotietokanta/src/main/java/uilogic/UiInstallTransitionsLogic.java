/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.Configuration;
import domain.FileManagerInterface;
import domain.FileWriterInterface;
import javafx.stage.Stage;
import service.ScenePlayer;
import service.UiLogicCore;

/**
 *
 * @author niila
 */
public class UiInstallTransitionsLogic {
    
    ScenePlayer scenePlayer;
    
    public UiInstallTransitionsLogic(ScenePlayer scenePlayer) {
        this.scenePlayer = scenePlayer;
    }
    
    public void fromWelcomeToDaoSettings(Stage primaryStage, Configuration configuration) {
        if (scenePlayer.getWelcome().getPublicMode().isSelected()) {
            configuration.setMode("Public");
            primaryStage.setTitle("Dao settings");
            primaryStage.setScene(scenePlayer.getDaoSettings().getDaoSettingScene());
        }
                 
        if (scenePlayer.getWelcome().getPrivateMode().isSelected()) {
            configuration.setMode("Private");
            primaryStage.setTitle("Dao settings");
            primaryStage.setScene(scenePlayer.getDaoSettingsPrivateScene().getDaoSettingPrivateScene());
        }
    }
    
    public void fromDaoSettingsToWelcome(Stage primaryStage, Configuration configuration){
        if (configuration.getMode().equals("Public")) {
            configuration.setMode("");
            primaryStage.setTitle("Fiktiotietokanta installation");
            primaryStage.setScene(scenePlayer.getWelcome().getWelcomeScene());
        }
                 
        if (configuration.getMode().equals("Private")) {
            configuration.setMode("");
            primaryStage.setTitle("Fiktiotietokanta installation");
            primaryStage.setScene(scenePlayer.getWelcome().getWelcomeScene());
        }
        
    }
    
    public void fromDaoSettingsToUpKeepSettings(Stage primaryStage) {
        primaryStage.setTitle("Admin settings");
        primaryStage.setScene(scenePlayer.getUpKeepSettings().getUpKeepSettingsScene());
    }
    
    public void fromUpKeepSettingsToDaoSettings(Stage primaryStage) {
        primaryStage.setTitle("Dao settings");
        primaryStage.setScene(scenePlayer.getDaoSettings().getDaoSettingScene());
    }
    
    public void fromUpKeepSettingsToLogin(Stage primaryStage, UiLogicCore uiLogicCore, Configuration configuration, FileManagerInterface fileManager,  FileWriterInterface fileWriter) {
        fileWriter.saveTextAsAConfig(configuration.createConfigString(), fileManager);
        uiLogicCore.publicCoreSetup(configuration.getAdminList());
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(scenePlayer.getLogin().getLoginScene());
    }
    
    public void fromDaoSettingsToLogin(Stage primaryStage, UiLogicCore uiLogicCore, Configuration configuration, FileManagerInterface fileManager,  FileWriterInterface fileWriter) {
        fileWriter.saveTextAsAConfig(configuration.createConfigString(), fileManager);
        uiLogicCore.privateCoreSetup();
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(scenePlayer.getLogin().getLoginScene());
    }
    
    
    
    
    
}
