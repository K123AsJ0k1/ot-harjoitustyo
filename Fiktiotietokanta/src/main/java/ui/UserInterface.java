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

        //Login screen transitions
        //Transition from login scene to mainmenu scene when login
        uiLogicCore.getScenePlayer().getLogin().getLoginButton().setOnAction((event) -> {
            uiLogicCore.getUiUserLogic().login(primaryStage);
        });

        //Transition from login scene to signin scene when signin
        uiLogicCore.getScenePlayer().getLogin().getSigninButton().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getLogin().getErrorMessage().setText("");
            uiLogicCore.getScenePlayer().getLogin().getUsernameInput().clear();
            uiLogicCore.getScenePlayer().getLogin().getPasswordInput().clear();
            primaryStage.setTitle("Sign in screen");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getSignIn().getSignInScene());
        });

        //Sign in screen transitions
        //Transition from signin scene to login scene when create a new account
        uiLogicCore.getScenePlayer().getSignIn().getCreateButton().setOnAction((event) -> {
            uiLogicCore.getUiUserLogic().createAccount(primaryStage);
        });
          
        //Transition from signin scene to login scene when return
        uiLogicCore.getScenePlayer().getSignIn().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getSignIn().getErrorMessage().setText("");
            uiLogicCore.getScenePlayer().getSignIn().getUsernameInput().clear();
            uiLogicCore.getScenePlayer().getSignIn().getPasswordInput().clear();
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getLogin().getLoginScene());
        });
        
        //Main menu transitions
        //Transition from main menu scene to ability menu scene when ability menu
        uiLogicCore.getScenePlayer().getMainMenu().getAbilitiesButton().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getMainMenu().getErrorMessage().setText("");
            primaryStage.setTitle("Ability menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getAbilityMenu().getAbilityMenuScene());
        });
        
        //Transition from main menu scene to profile menu scene when profile menu
        uiLogicCore.getScenePlayer().getMainMenu().getProfilesButton().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getMainMenu().getErrorMessage().setText("");
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getProfileMenu().getProfileMenuScene());
        });
        
        //Transition from main menu scene to profile menu scene when admin menu
        uiLogicCore.getScenePlayer().getMainMenu().getAdminButton().setOnAction((event) ->{
            if (!(uiLogicCore.getUser().getUsername().equals("Tester")) && !(uiLogicCore.getUser().getPassword().equals("Tester"))) {
                uiLogicCore.getScenePlayer().getMainMenu().getErrorMessage().setText("Your user doesn't have admin privileges");
                return;
            }
            
            primaryStage.setTitle("Admin menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getAdminMenu().getAdminMenuScene());
        });
        
        
        //Transition from main menu scene to login scene when sign out
        uiLogicCore.getScenePlayer().getMainMenu().getSignOutButton().setOnAction((event) -> {
            uiLogicCore.getUser().setId(0);
            uiLogicCore.getUser().setUsername("");
            uiLogicCore.getUser().setPassword("");
            uiLogicCore.getScenePlayer().getMainMenu().getErrorMessage().setText("");
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getLogin().getLoginScene());
        });
        
        
        //Ability menu transitions
        //Transition from ability menu scene to main menu scene when return
        uiLogicCore.getScenePlayer().getAbilityMenu().getReturnButton().setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getMainMenu().getMainMenuScene());
        });
        
        //Transition from ability menu scene to add ability scene when add ability
        uiLogicCore.getScenePlayer().getAbilityMenu().getAddAbilityButton().setOnAction((event) -> {
            primaryStage.setTitle("Add ability");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getAddAbilities().getAddAbilitiesScene());
        });
        
        //Profile menu transitions;
        //Transition from profile menu scene to create profile scene when create profile
        uiLogicCore.getScenePlayer().getProfileMenu().getCreateProfileButton().setOnAction((event) -> {
            primaryStage.setTitle("Profile creator");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getCreateProfile().getCreateProfileScene());

        });
        
        //Transition from profile menu scene to main menu scene when return
        uiLogicCore.getScenePlayer().getProfileMenu().getReturnButton().setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getMainMenu().getMainMenuScene());
        });
        
        //Transitions from profile menu scene to create file from profile scene
        uiLogicCore.getScenePlayer().getProfileMenu().getCreateFileButton().setOnAction((event) -> {
            primaryStage.setTitle("Save profile as a file menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getCreateFile().getCreateFileScene());
        });
        
        //Resets profile
        uiLogicCore.getScenePlayer().getProfileMenu().getResetProfileButton().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().clear();
            uiLogicCore.getScenePlayer().getCreateFile().getTextPresentation().setText("");
        });
        
        //Save profile as a file scene
        
        //Transition from create file from profile scene to profile menu scene 
        uiLogicCore.getScenePlayer().getCreateFile().getReturnButton().setOnAction((event) -> {
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getProfileMenu().getProfileMenuScene());
        });
        
        //Saving current profile as a file
        uiLogicCore.getScenePlayer().getCreateFile().getSaveButton().setOnAction((event) -> {
            String text = uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().getText().trim();
            uiLogicCore.getScenePlayer().getCreateFile().getTextPresentation().setText(text);
            uiLogicCore.getTextPlayer().getFileWriterInterface().showSaveFileDialog(primaryStage, text);
        });
        
        //Admin menu transitions
        uiLogicCore.getScenePlayer().getAdminMenu().getReturnButton().setOnAction((event) ->{
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getMainMenu().getMainMenuScene());
        });
        
        //
        
        
        
        //Add ability menu transition
        //Transition from add ability scene to ability main menu scene when return
        uiLogicCore.getScenePlayer().getAddAbilities().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getAddAbilities().getErrorMessage().setText("");
            primaryStage.setTitle("Ability menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getAbilityMenu().getAbilityMenuScene());
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
        
        //Transition from ability menu scene to remove ability scene when remove ability
        uiLogicCore.getScenePlayer().getAbilityMenu().getRemoveAbilityButton().setOnAction((event) -> {
            List<String> abilityList = uiLogicCore.getDaoPlayer().getAbilityDatabase().showDatabaseAsARestrictedList(String.valueOf(uiLogicCore.getUser().getId()));
            uiLogicCore.getScenePlayer().getRemoveAbilities().getTableView().getItems().addAll(uiLogicCore.getUiAbilityLogic().addAbilitiesIntoList(abilityList));
            primaryStage.setTitle("Remove Abilities table");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getRemoveAbilities().getRemoveAbilitiesScene());
            
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
        
        //Transition from remove ability scene to ability menu
        uiLogicCore.getScenePlayer().getRemoveAbilities().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getRemoveAbilities().getTableView().getItems().clear();
            primaryStage.setTitle("Ability menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getAbilityMenu().getAbilityMenuScene());

        });

        
        //Create profile transitions
        //Transition from create profile scene to profile menu when save and return
        uiLogicCore.getScenePlayer().getCreateProfile().getExitWithSave().setOnAction((event) -> {
            String unRefinedText = uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().getText();
            uiLogicCore.getScenePlayer().getCreateFile().getTextPresentation().setText(unRefinedText);
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getProfileMenu().getProfileMenuScene());
        });

        //Transition from create profile scene to profile menu when return without saving
        uiLogicCore.getScenePlayer().getCreateProfile().getExitWithoutSave().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getCreateProfile().getProfileEditor().clear();
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getProfileMenu().getProfileMenuScene());
        });
        
        
        
        //Transition from create profile scene to choose ability scene when choose ability
        uiLogicCore.getScenePlayer().getCreateProfile().getChoosenAbilityItem().setOnAction((event) -> {
            List<String> abilityList = uiLogicCore.getDaoPlayer().getAbilityDatabase().showDatabaseAsARestrictedList(String.valueOf(uiLogicCore.getUser().getId()));
            uiLogicCore.getScenePlayer().getChooseAbilities().getTableView().getItems().addAll(uiLogicCore.getUiAbilityLogic().addAbilitiesIntoList(abilityList));
            primaryStage.setTitle("Choose Abilities table");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getChooseAbilities().getChoosenAbilitiesScene());
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
        
        
        //Choose ability transitions
        
        //Transition from choose ability scene to create profile scene when return
        uiLogicCore.getScenePlayer().getChooseAbilities().getReturnButton().setOnAction((event) -> {
            uiLogicCore.getScenePlayer().getChooseAbilities().getTableView().getItems().clear();
            primaryStage.setTitle("Profile creator");
            primaryStage.setScene(uiLogicCore.getScenePlayer().getCreateProfile().getCreateProfileScene());
        });
        
        //Transition from choose ability scene to create profile scene when choose ability
        uiLogicCore.getScenePlayer().getChooseAbilities().getChoosenAbilityButton().setOnAction((event) -> {
            if (uiLogicCore.getScenePlayer().getChooseAbilities().getSelectionModel().getSelectedItems().size() > 0) {
                ObservableList selectedItems = uiLogicCore.getScenePlayer().getChooseAbilities().getSelectionModel().getSelectedItems();
                String givenString = uiLogicCore.getUiAbilityLogic().chooseAbility(selectedItems);
                uiLogicCore.getParameters().setChoosenAbility(givenString);
                uiLogicCore.getParameters().setLeftOverParameters(givenString);
                uiLogicCore.getScenePlayer().getCreateProfile().getLeftParameterItem().setText("Ability parameters left:" + givenString);
                uiLogicCore.getScenePlayer().getChooseAbilities().getTableView().getItems().clear();
                primaryStage.setTitle("Profile creator");
                primaryStage.setScene(uiLogicCore.getScenePlayer().getCreateProfile().getCreateProfileScene());
            }
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
