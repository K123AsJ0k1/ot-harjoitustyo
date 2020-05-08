/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import service.UiLogicCore;

/** Käyttöliittymä.
 *
 * @author niila
 */
public class UserInterface extends Application {
    
    UiLogicCore uiLogicCore;
      
    @Override
    public void init() throws Exception {
        uiLogicCore = new UiLogicCore();
        uiLogicCore.coreSetup();
    }

    @Override
    public void start(Stage primaryStage) {
        
        uiLogicCore.getScenePlayer().getWelcome().getNextButton().setOnAction((event) ->{
            uiLogicCore.getUiInstallTransitionsLogic().fromWelcomeToDaoSettings(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getWelcome().getShutDownButton().setOnAction((event) ->{
            stop();
        });
        
        uiLogicCore.getScenePlayer().getDaoSettings().getPrevious().setOnAction((event) ->{
            uiLogicCore.getUiInstallTransitionsLogic().fromDaoSettingsToWelcome(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getDaoSettings().getNext().setOnAction((event) ->{
            uiLogicCore.getUiInstallTransitionsLogic().fromDaoSettingsToUpKeepSettings(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getUpKeepSettings().getPreviousButton().setOnAction((event) ->{
            uiLogicCore.getUiInstallTransitionsLogic().fromUpKeepSettingsToDaoSettings(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getUpKeepSettings().getFinishButton().setOnAction((event) ->{
            uiLogicCore.getUiInstallTransitionsLogic().fromUpKeepSettingsToLogin(primaryStage);
        });

        uiLogicCore.getScenePlayer().getLogin().getLoginButton().setOnAction((event) -> {
            uiLogicCore.getUiUserLogic().login(primaryStage);
        });
 
        uiLogicCore.getScenePlayer().getLogin().getSigninButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromLoginToSignIn(primaryStage);
        });

        uiLogicCore.getScenePlayer().getSignIn().getCreateButton().setOnAction((event) -> {
            uiLogicCore.getUiUserLogic().createAccount(primaryStage);
        });
          
        uiLogicCore.getScenePlayer().getSignIn().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromSignInToLogin(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getMainMenu().getAbilitiesButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromMainMenuToAbilityMenu(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getMainMenu().getProfilesButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromMainMenuToProfileMenu(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getMainMenu().getAdminButton().setOnAction((event) ->{
            uiLogicCore.getUiTransitionLogic().fromMainMenuToAdminMenu(primaryStage, uiLogicCore.getUser().getUsername(), uiLogicCore.getUser().getPassword());
        });
        
        uiLogicCore.getScenePlayer().getMainMenu().getSignOutButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromMainMenuToLogin(primaryStage, uiLogicCore.getUser());
        });
        
        uiLogicCore.getScenePlayer().getAbilityMenu().getAddAbilityButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromAbilityMenuToAddAbility(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getAbilityMenu().getRemoveAbilityButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromAbilityMenuToRemoveAbility(primaryStage, uiLogicCore.getDaoPlayer().getAbilityDatabase().showDatabaseAsARestrictedList(String.valueOf(uiLogicCore.getUser().getId())), uiLogicCore.getUiAbilityLogic());   
        });
        
        uiLogicCore.getScenePlayer().getAbilityMenu().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromAbilityMenuToMainMenu(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getProfileMenu().getCreateProfileButton().setOnAction((event) -> {
           uiLogicCore.getUiTransitionLogic().fromProfileMenuToCreateProfile(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getProfileMenu().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromProfileMenuToMainMenu(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getProfileMenu().getCreateFileButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromProfileMenuToCreateFile(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getChooseAbilities().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromChoosenAbilityToCreateProfileReturn(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getChooseAbilities().getChoosenAbilityButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromChoosenAbilityToCreateProfileChoosenAbility(primaryStage, uiLogicCore.getParameters(), uiLogicCore.getUiAbilityLogic());
        });
        
        uiLogicCore.getScenePlayer().getCreateFile().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromCreateFileToProfileMenu(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getAdminMenu().getReturnButton().setOnAction((event) ->{
            uiLogicCore.getUiTransitionLogic().fromAdminMenuToMainMenu(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getAddAbilities().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromAddAbilitiesToAbilityMenu(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getRemoveAbilities().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromRemoveAbilityToAbilityMenu(primaryStage);
        });

        uiLogicCore.getScenePlayer().getCreateProfile().getExitWithSave().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromCreateProfileToProfileMenuWithSave(primaryStage);
        });

        uiLogicCore.getScenePlayer().getCreateProfile().getExitWithoutSave().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromCreateProfileToProfileMenuWithOutSave(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getCreateProfile().getChoosenAbilityItem().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromCreateProfileToChooseAbility(primaryStage, uiLogicCore.getDaoPlayer().getAbilityDatabase().showDatabaseAsARestrictedList(String.valueOf(uiLogicCore.getUser().getId())), uiLogicCore.getUiAbilityLogic());
        });
        
        uiLogicCore.getScenePlayer().getProfileMenu().getResetProfileButton().setOnAction((event) -> {
            uiLogicCore.getUiSupportLogic().resetProfile(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getCreateFile().getSaveButton().setOnAction((event) -> {
            uiLogicCore.getUiSupportLogic().saveProfileAsAFile(primaryStage, uiLogicCore.getTextPlayer());
        });
         
        uiLogicCore.getScenePlayer().getAddAbilities().getCreateAbilityButton().setOnAction((event) -> {
            uiLogicCore.getUiSupportLogic().addAbility(uiLogicCore.getUser(), uiLogicCore.getUiAbilityLogic());
        });
        
        uiLogicCore.getScenePlayer().getRemoveAbilities().getRemoveAbilityButton().setOnAction((event) -> {
            uiLogicCore.getUiSupportLogic().removeAbility(uiLogicCore.getUser(), uiLogicCore.getUiAbilityLogic());
        });
        
        uiLogicCore.getScenePlayer().getCreateProfile().getResetAbilityItem().setOnAction((event) -> {
            uiLogicCore.getUiSupportLogic().resetAbility(uiLogicCore.getParameters());
        });
        
        uiLogicCore.getScenePlayer().getCreateProfile().getCheckAreaItem().setOnAction((event) -> {
            uiLogicCore.getUiSupportLogic().checkTextAreaForAbilities(uiLogicCore.getParameters(), uiLogicCore.getTextPlayer());
        });
        
        uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().setOnKeyTyped((event) -> {
           uiLogicCore.getUiSupportLogic().checkTextArea(uiLogicCore.getTextPlayer());
        });
        /*
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(uiLogicCore.getScenePlayer().getLogin().getLoginScene());
        primaryStage.show();
        */
        
        primaryStage.setTitle("Welcome to Fiktiotietokanta installation");
        primaryStage.setScene(uiLogicCore.getScenePlayer().getWelcome().getWelcomeScene());
        primaryStage.show();
        
    }

    @Override
    public void stop() {
        uiLogicCore.coreShutDown();
        System.exit(0);
    }
    
    /** Käyttöliittymä.
    *
    * 
     * @param args parametri.
    */
    public static void main(String[] args) {
        launch(args);
    }

}
