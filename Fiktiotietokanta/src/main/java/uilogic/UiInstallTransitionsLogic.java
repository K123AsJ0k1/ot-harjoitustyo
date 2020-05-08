/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import javafx.stage.Stage;
import service.ScenePlayer;

/**
 *
 * @author niila
 */
public class UiInstallTransitionsLogic {
    
    ScenePlayer scenePlayer;
    
    public UiInstallTransitionsLogic(ScenePlayer scenePlayer) {
        this.scenePlayer = scenePlayer;
    }
    
    public void fromWelcomeToDaoSettings(Stage primaryStage) {
        primaryStage.setTitle("Data access object settings");
        primaryStage.setScene(scenePlayer.getDaoSettings().getDaoSettingScene());
    }
    
    public void fromDaoSettingsToWelcome(Stage primaryStage){
        primaryStage.setTitle("Welcome to Fiktiotietokanta installation");
        primaryStage.setScene(scenePlayer.getWelcome().getWelcomeScene());
    }
    
    public void fromDaoSettingsToUpKeepSettings(Stage primaryStage) {
        primaryStage.setTitle("Program up keep settings");
        primaryStage.setScene(scenePlayer.getUpKeepSettings().getUpKeepSettingsScene());
    }
    
    public void fromUpKeepSettingsToDaoSettings(Stage primaryStage) {
        primaryStage.setTitle("Data access object settings");
        primaryStage.setScene(scenePlayer.getDaoSettings().getDaoSettingScene());
    }
    
    public void fromUpKeepSettingsToLogin(Stage primaryStage) {
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(scenePlayer.getLogin().getLoginScene());
    }
    
    
    
}
