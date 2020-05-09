/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.Configuration;
import assets.TextAreaMode;
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
            primaryStage.setScene(scenePlayer.getPublicDaoSettings().getDaoSettingScene());
        }
                 
        if (scenePlayer.getWelcome().getPrivateMode().isSelected()) {
            configuration.setMode("Private");
            primaryStage.setTitle("Dao settings");
            primaryStage.setScene(scenePlayer.getPrivateDaoSettings().getDaoSettingPrivateScene());
        }
    }
    
    public void fromDaoSettingsToWelcome(Stage primaryStage, Configuration configuration, TextAreaMode textAreaMode){
        if (configuration.getMode().equals("Public")) {
            configuration.setMode("");
            textAreaMode.setMode("");
            scenePlayer.getPublicDaoSettings().getNameInput().clear();
            scenePlayer.getPublicDaoSettings().getMessage().setText("");
            primaryStage.setTitle("Fiktiotietokanta installation");
            primaryStage.setScene(scenePlayer.getWelcome().getWelcomeScene());
        }
                 
        if (configuration.getMode().equals("Private")) {
            configuration.setMode("");
            textAreaMode.setMode("");
            scenePlayer.getPrivateDaoSettings().getNameInput().clear();
            scenePlayer.getPrivateDaoSettings().getMessage().setText("");
            primaryStage.setTitle("Fiktiotietokanta installation");
            primaryStage.setScene(scenePlayer.getWelcome().getWelcomeScene());
        }
        
    }
    
    public void fromDaoSettingsToUpKeepSettings(Stage primaryStage, TextAreaMode textAreaMode) {
        textAreaMode.setMode("");
        scenePlayer.getPrivateDaoSettings().getNameInput().clear();
        primaryStage.setTitle("Administrator settings");
        primaryStage.setScene(scenePlayer.getAdministratorSettings().getAdministratorSettingsScene());
    }
    
    public void fromAdministratorSettingsToDaoSettings(Stage primaryStage) {
        scenePlayer.getAdministratorSettings().getUsernameArea().clear();
        scenePlayer.getAdministratorSettings().getPasswordArea().clear();
        scenePlayer.getAdministratorSettings().getMessage().setText("");
        primaryStage.setTitle("Dao settings");
        primaryStage.setScene(scenePlayer.getPublicDaoSettings().getDaoSettingScene());
    }
    
    public void fromAdministratorToLogin(Stage primaryStage, UiLogicCore uiLogicCore, Configuration configuration, FileManagerInterface fileManager,  FileWriterInterface fileWriter) {
        if (configuration.getAdminList().size()>0) {
        fileWriter.saveTextAsAConfig(configuration.createConfigString(), fileManager);
        uiLogicCore.publicCoreSetup(configuration.getAdminList());
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(scenePlayer.getLogin().getLoginScene());
        }
    }
    
    public void fromDaoSettingsToLogin(Stage primaryStage, UiLogicCore uiLogicCore, Configuration configuration, FileManagerInterface fileManager,  FileWriterInterface fileWriter) {
        fileWriter.saveTextAsAConfig(configuration.createConfigString(), fileManager);
        uiLogicCore.privateCoreSetup();
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(scenePlayer.getLogin().getLoginScene());
    }
    
    
    
    
    
}
