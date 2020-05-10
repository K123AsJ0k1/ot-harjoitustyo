/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import service.UiInstallCore;
import service.UiLogicCore;

/**
 * Käyttöliittymä.
 *
 * @author niila
 */
public class UserInterface extends Application {

    UiInstallCore uiInstallCore;
    UiLogicCore uiLogicCore;

    @Override
    public void init() throws Exception {
        uiInstallCore = new UiInstallCore();
        uiLogicCore = new UiLogicCore(uiInstallCore.getScenePlayer());

        if (uiInstallCore.getFileManager().configFileExists()) {
            uiLogicCore.coreStart();
        }

    }

    @Override
    public void start(Stage primaryStage) {
        //InstallCore setOnAction
        uiInstallCore.getScenePlayer().getWelcome().getShutDownButton().setOnAction((event) -> {
            stop();
        });

        uiInstallCore.getScenePlayer().getWelcome().getNextButton().setOnAction((event) -> {
            uiInstallCore.getUiInstallTransitionsLogic().fromWelcomeToDaoSettings(primaryStage, uiInstallCore.getConfiguration());
        });

        //Public daoSetting
        uiInstallCore.getScenePlayer().getPublicDaoSettings().getPrevious().setOnAction((event) -> {
            uiInstallCore.getUiInstallTransitionsLogic().fromDaoSettingsToWelcome(primaryStage, uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPublicDaoSettings().getFolder().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkFolderName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPublicDaoSettings().getUsernameDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkUserDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPublicDaoSettings().getClassDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkClassDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPublicDaoSettings().getNameDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkNameDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPublicDaoSettings().getDescriptionDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkDescriptionDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPublicDaoSettings().getRequrimentDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkRequrimentDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPublicDaoSettings().getRealityDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkRealityDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPublicDaoSettings().getAbilityDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkAbilityDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPublicDaoSettings().getSelectName().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().setSelectedName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPublicDaoSettings().getNext().setOnAction((event) -> {
            uiInstallCore.getUiInstallTransitionsLogic().fromDaoSettingsToUpKeepSettings(primaryStage, uiInstallCore.getTextAreaMode());
        });

        //Private dao settings
        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getPrevious().setOnAction((event) -> {
            uiInstallCore.getUiInstallTransitionsLogic().fromDaoSettingsToWelcome(primaryStage, uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getFolder().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkFolderName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getUsernameDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkUserDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getClassDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkClassDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getNameDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkNameDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getDescriptionDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkDescriptionDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getRequrimentDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkRequrimentDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getRealityDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkRealityDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getAbilityDatabaseItem().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().checkAbilityDName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getSelectName().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().setSelectedName(uiInstallCore.getConfiguration(), uiInstallCore.getTextAreaMode());
        });

        uiInstallCore.getScenePlayer().getPrivateDaoSettings().getFinish().setOnAction((event) -> {
            uiInstallCore.getUiInstallTransitionsLogic().fromDaoSettingsToMainMenu(primaryStage, uiLogicCore, uiInstallCore.getConfiguration(), uiInstallCore.getFileManager(), uiInstallCore.getFileWriter());
        });

        //Public admin settings
        uiInstallCore.getScenePlayer().getAdministratorSettings().getPreviousButton().setOnAction((event) -> {
            uiInstallCore.getUiInstallTransitionsLogic().fromAdministratorSettingsToDaoSettings(primaryStage);
        });

        uiInstallCore.getScenePlayer().getAdministratorSettings().getCreateAdminButton().setOnAction((event) -> {
            uiInstallCore.getUiInstallSupportLogic().AddAdmin(uiInstallCore.getConfiguration());
        });

        uiInstallCore.getScenePlayer().getAdministratorSettings().getFinishButton().setOnAction((event) -> {
            uiInstallCore.getUiInstallTransitionsLogic().fromAdministratorToLogin(primaryStage, uiLogicCore, uiInstallCore.getConfiguration(), uiInstallCore.getFileManager(), uiInstallCore.getFileWriter());
        });
        
        //Private main menu
        
        uiLogicCore.getScenePlayer().getPrivateMainMenu().getAbilitiesButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromMainMenuToAbilityMenu(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getPrivateMainMenu().getProfilesButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromMainMenuToProfileMenu(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getPrivateMainMenu().getAdminButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromMainMenuToAdminMenu(primaryStage, uiLogicCore.getUser());
        });
        
        uiLogicCore.getScenePlayer().getPrivateMainMenu().getShutDownButton().setOnAction((event) ->{
           stop(); 
        });
        

        //UiLogicCore setOnAction
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

        uiLogicCore.getScenePlayer().getPublicMainMenu().getAbilitiesButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromMainMenuToAbilityMenu(primaryStage);
        });

        uiLogicCore.getScenePlayer().getPublicMainMenu().getProfilesButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromMainMenuToProfileMenu(primaryStage);
        });

        uiLogicCore.getScenePlayer().getPublicMainMenu().getAdminButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromMainMenuToAdminMenu(primaryStage, uiLogicCore.getUser());
        });

        uiLogicCore.getScenePlayer().getPublicMainMenu().getSignOutButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromMainMenuToLogin(primaryStage, uiLogicCore.getUser());
        });

        uiLogicCore.getScenePlayer().getAbilityMenu().getAddAbilityButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromAbilityMenuToAddAbility(primaryStage);
        });

        uiLogicCore.getScenePlayer().getAbilityMenu().getRemoveAbilityButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromAbilityMenuToRemoveAbility(primaryStage, uiLogicCore.getDaoPlayer().getAbilityDatabase().showDatabaseAsARestrictedList(String.valueOf(uiLogicCore.getUser().getId())), uiLogicCore.getUiAbilityLogic());
        });

        uiLogicCore.getScenePlayer().getAbilityMenu().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromAbilityMenuToMainMenu(primaryStage, uiLogicCore.getConfiguration());
        });

        uiLogicCore.getScenePlayer().getProfileMenu().getCreateProfileButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromProfileMenuToCreateProfile(primaryStage);
        });

        uiLogicCore.getScenePlayer().getProfileMenu().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromProfileMenuToMainMenu(primaryStage, uiLogicCore.getConfiguration());
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

        uiLogicCore.getScenePlayer().getAdminMenu().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromAdminMenuToMainMenu(primaryStage, uiLogicCore.getConfiguration());
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
        
        uiLogicCore.getScenePlayer().getAdminMenu().getUserParamsAsAListMenuButton().setOnAction((event) ->{
            uiLogicCore.getUiTransitionLogic().fromAdminMenuToUserTable(primaryStage, uiLogicCore.getDaoPlayer().getUsernameDatabase().showDatabaseAsAList(), uiLogicCore.getUiUserTableLogic());
        });
        
        uiLogicCore.getScenePlayer().getUserDatabaseTable().getReturnButton().setOnAction((event) ->{
            uiLogicCore.getUiTransitionLogic().fromUserTableToAdminMenu(primaryStage);
        });
        
        if (uiInstallCore.getFileManager().configFileExists()) {
            if (uiLogicCore.getConfiguration().getMode().equals("Public")) {
                primaryStage.setTitle("Login screen");
                primaryStage.setScene(uiLogicCore.getScenePlayer().getLogin().getLoginScene());
                primaryStage.show();
            }
            
            if (uiLogicCore.getConfiguration().getMode().equals("Private")) {
                primaryStage.setTitle("Main menu");
                primaryStage.setScene(uiLogicCore.getScenePlayer().getPrivateMainMenu().getMainMenuScene());
                primaryStage.show();
            }
        }

        if (!uiInstallCore.getFileManager().configFileExists()) {
            primaryStage.setTitle("Welcome to Fiktiotietokanta installation");
            primaryStage.setScene(uiInstallCore.getScenePlayer().getWelcome().getWelcomeScene());
            primaryStage.show();
        }
    }

    @Override
    public void stop() {
        System.exit(0);
    }

    /**
     * Käyttöliittymä.
     *
     *
     * @param args parametri.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
