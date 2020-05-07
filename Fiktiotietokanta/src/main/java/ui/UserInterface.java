/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.List;
import javafx.collections.ObservableList;
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
        
        //Resets profile
        uiLogicCore.getScenePlayer().getProfileMenu().getResetProfileButton().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().clear();
            uiLogicCore.getScenePlayer().getCreateFile().getTextPresentation().setText("");
        });
        
        uiLogicCore.getScenePlayer().getCreateFile().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromCreateFileToProfileMenu(primaryStage);
        });
        
        //Saving current profile as a file
        uiLogicCore.getScenePlayer().getCreateFile().getSaveButton().setOnAction((event) -> {
            String text = uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().getText().trim();
            uiLogicCore.getScenePlayer().getCreateFile().getTextPresentation().setText(text);
            uiLogicCore.getTextPlayer().getFileWriterInterface().showSaveFileDialog(primaryStage, text);
        });
         
        uiLogicCore.getScenePlayer().getAdminMenu().getReturnButton().setOnAction((event) ->{
            uiLogicCore.getUiTransitionLogic().fromAdminMenuToMainMenu(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getAddAbilities().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromAddAbilitiesToAbilityMenu(primaryStage);
        });
        
        //Adding of new ability
        uiLogicCore.getScenePlayer().getAddAbilities().getCreateAbilityButton().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getAddAbilities().getErrorMessage().setText("");
            String textFieldClass = uiLogicCore.getScenePlayer().getAddAbilities().getClassInput().getText().trim();
            String textFieldName = uiLogicCore.getScenePlayer().getAddAbilities().getNameInput().getText().trim();
            String textFieldDescription = uiLogicCore.getScenePlayer().getAddAbilities().getDescriptionInput().getText().trim();
            String textFieldRequriment = uiLogicCore.getScenePlayer().getAddAbilities().getRequrimentInput().getText().trim();
            String textFieldReality = uiLogicCore.getScenePlayer().getAddAbilities().getRealityInput().getText().trim();
            
            String addAbility = uiLogicCore.getUiAbilityLogic().addAbility(uiLogicCore.getUser().getId(), textFieldClass, textFieldName, textFieldDescription, textFieldRequriment, textFieldReality);
            uiLogicCore.getScenePlayer().getAddAbilities().getErrorMessage().setText(addAbility);
            
            uiLogicCore.getScenePlayer().getAddAbilities().getClassInput().clear();
            uiLogicCore.getScenePlayer().getAddAbilities().getNameInput().clear();
            uiLogicCore.getScenePlayer().getAddAbilities().getDescriptionInput().clear();
            uiLogicCore.getScenePlayer().getAddAbilities().getRequrimentInput().clear();
            uiLogicCore.getScenePlayer().getAddAbilities().getRealityInput().clear();
        });
        
        //Removal of ability
        uiLogicCore.getScenePlayer().getRemoveAbilities().getRemoveAbilityButton().setOnAction((event) -> {
            if (uiLogicCore.getScenePlayer().getRemoveAbilities().getSelectionModel().getSelectedItems().size() > 0) {
                ObservableList selectedItems = uiLogicCore.getScenePlayer().getRemoveAbilities().getSelectionModel().getSelectedItems();
                int removedIndex = uiLogicCore.getScenePlayer().getRemoveAbilities().getSelectionModel().getFocusedIndex();
                uiLogicCore.getUiAbilityLogic().removeAbility(uiLogicCore.getUser().getId(), selectedItems);
                uiLogicCore.getScenePlayer().getRemoveAbilities().getTableView().getItems().remove(removedIndex);
                uiLogicCore.getScenePlayer().getRemoveAbilities().getTableView().refresh();
            }
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
        
        //Resets choosen ability
        uiLogicCore.getScenePlayer().getCreateProfile().getResetAbilityItem().setOnAction((event) -> {
            uiLogicCore.getParameters().setChoosenAbility("");
            uiLogicCore.getParameters().setLeftOverParameters("");
            uiLogicCore.getScenePlayer().getCreateProfile().getLeftParameterItem().setText("Ability parameters left:" + "");
        });
        
        //Checks textarea string for ability parameters
        uiLogicCore.getScenePlayer().getCreateProfile().getCheckAreaItem().setOnAction((event) -> {
            uiLogicCore.getParameters().setLeftOverParameters(uiLogicCore.getTextPlayer().getTextRefineryInterface().choosenAbilityIsFoundFromText(uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().getText(),uiLogicCore.getParameters().getChosenAbility()));
            uiLogicCore.getScenePlayer().getCreateProfile().getLeftParameterItem().setText("Ability parameters left:" + uiLogicCore.getParameters().getLeftOverParameters());
        });
        
        //Checks textarea 
        uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().setOnKeyTyped((event) -> {
           uiLogicCore.getScenePlayer().getCreateProfile().getLineCheckItem().setText("Text has different lines:"+uiLogicCore.getTextPlayer().getTextRefineryInterface().givenTextLineChecker(uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().getText().trim()));
           uiLogicCore.getScenePlayer().getCreateProfile().getSpaceCheckItem().setText("Words have spaces between them:"+uiLogicCore.getTextPlayer().getTextRefineryInterface().givenTextLineHasSpaces(uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().getText().trim()));
           uiLogicCore.getScenePlayer().getCreateProfile().getWordCountItem().setText("Current wordcount:"+uiLogicCore.getTextPlayer().getTextRefineryInterface().giveTextWordCount(uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().getText().trim()));
           uiLogicCore.getScenePlayer().getCreateProfile().getCharacterCountItem().setText("Current charactercount:"+uiLogicCore.getTextPlayer().getTextRefineryInterface().giveCharacterCount(uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().getText().trim()));
        });
        
        uiLogicCore.getScenePlayer().getChooseAbilities().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromChoosenAbilityToCreateProfileReturn(primaryStage);
        });
        
        uiLogicCore.getScenePlayer().getChooseAbilities().getChoosenAbilityButton().setOnAction((event) -> {
            uiLogicCore.getUiTransitionLogic().fromChoosenAbilityToCreateProfileChoosenAbility(primaryStage, uiLogicCore.getParameters(), uiLogicCore.getUiAbilityLogic());
        });
        
        //UI start code
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(uiLogicCore.getScenePlayer().getLogin().getLoginScene());
        primaryStage.show();

    }

    @Override
    public void stop() {
        uiLogicCore.coreShutDown();
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
