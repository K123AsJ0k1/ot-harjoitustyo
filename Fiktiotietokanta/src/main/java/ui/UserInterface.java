/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import service.Ability;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import dao.UsernameDatabase;
import dao.AbilityDatabase;
import dao.ClassDatabase;
import dao.DescriptionDatabase;
import dao.NameDatabase;
import dao.RealityDatabase;
import dao.RequrimentDatabase;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ContextMenu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import domain.DatabaseInterface;
import domain.FileWriterInterface;
import domain.UsernameInterface;
import service.FileWriter;
import textlogic.TemplateMaker;
import textlogic.TextRefinery;
import domain.TextRefineryInterface;
import domain.TextTemplateInterface;
import java.io.File;
import java.util.Arrays;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import scenes.AbilityMenuScene;
import scenes.AddAbilitiesScene;
import scenes.AdminMenuScene;
import scenes.ChooseAbilitiesScene;
import scenes.CreateFileScene;
import scenes.CreateProfileScene;
import scenes.LoginScene;
import scenes.MainMenuScene;
import scenes.ProfileMenuScene;
import scenes.RemoveAbilitiesScene;
import scenes.SignInScene;
import scenes.Test;
import service.UiAbilityLogic;

/** Käyttöliittymä.
 *
 * @author niila
 */
public class UserInterface extends Application {

    private UsernameInterface usernameDatabase;
    private DatabaseInterface classDatabase;
    private DatabaseInterface nameDatabase;
    private DatabaseInterface descriptionDatabase;
    private DatabaseInterface requrimentDatabase;
    private DatabaseInterface realityDatabase;
    private DatabaseInterface abilityDatabase;
    private FileWriterInterface fileWriter;
    private TextTemplateInterface templateFactory;
    private TextRefineryInterface textRefinery;
    private Integer usernameId;
    private String username;
    private String password;
    private String chosenAbility;
    private String leftOverParameters;
    UiAbilityLogic uiAbilityLogic;
    Test testScene1;
    LoginScene loginScene;
    SignInScene signInScene;
    MainMenuScene mainMenuScene;
    AbilityMenuScene abilityMenuScene;
    ProfileMenuScene profileMenuScene;
    AdminMenuScene adminMenuScene;
    CreateFileScene createFileScene;
    AddAbilitiesScene addAbilitiesScene;
    RemoveAbilitiesScene removeAbilitiesScene;
    CreateProfileScene createProfileScene;
    ChooseAbilitiesScene chooseAbilitiesScene;
    
    @Override
    public void init() throws Exception {
        usernameDatabase = new UsernameDatabase("Normal");
        classDatabase = new ClassDatabase("Normal");
        nameDatabase = new NameDatabase("Normal");
        descriptionDatabase = new DescriptionDatabase("Normal");
        requrimentDatabase = new RequrimentDatabase("Normal");
        realityDatabase = new RealityDatabase("Normal");
        abilityDatabase = new AbilityDatabase("Normal");
        fileWriter = new FileWriter();
        templateFactory = new TemplateMaker();
        textRefinery = new TextRefinery();
        uiAbilityLogic = new UiAbilityLogic(classDatabase, nameDatabase, descriptionDatabase, requrimentDatabase, realityDatabase, abilityDatabase);
        usernameDatabase.createUsernameDatabase();
        classDatabase.createDatabase();
        nameDatabase.createDatabase();
        descriptionDatabase.createDatabase();
        requrimentDatabase.createDatabase();
        realityDatabase.createDatabase();
        abilityDatabase.createDatabase();

        usernameDatabase.addUserInformation("Tester","Tester");
        usernameId = 0;
        username = "";
        password = "";
        chosenAbility = "";
        leftOverParameters = "";
        
        testScene1 = new Test();
        
        loginScene = new LoginScene();
        signInScene = new SignInScene();
        mainMenuScene = new MainMenuScene();
        abilityMenuScene = new AbilityMenuScene();
        profileMenuScene = new ProfileMenuScene();
        adminMenuScene = new AdminMenuScene();
        createFileScene = new CreateFileScene();
        addAbilitiesScene = new AddAbilitiesScene();
        removeAbilitiesScene = new RemoveAbilitiesScene();
        createProfileScene = new CreateProfileScene();
        chooseAbilitiesScene = new ChooseAbilitiesScene();
    }

    @Override
    public void start(Stage primaryStage) {

        //Login screen transitions
        //Transition from login scene to mainmenu scene when login
        loginScene.getLoginButton().setOnAction((event) -> {
            loginScene.getErrorMessage().setText("");
            String givenUsernameLogin = loginScene.getUsernameInput().getText().trim();
            String givenPasswordLogin = loginScene.getPasswordInput().getText().trim();
            
            if (!(usernameDatabase.searchUserInformation(givenUsernameLogin))) {
                loginScene.getErrorMessage().setText("Username doesn't exist");
                return;
            }
            
            if (!(usernameDatabase.userPasswordCheck(givenUsernameLogin, givenPasswordLogin))) {
                loginScene.getErrorMessage().setText("Password doesn't exist");
                return;
            }
            username = givenUsernameLogin;
            password = givenPasswordLogin;
            usernameId = usernameDatabase.searchUsernameId(givenUsernameLogin);
            loginScene.getUsernameInput().clear();
            loginScene.getPasswordInput().clear();
            loginScene.getErrorMessage().setText("");
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(mainMenuScene.getMainMenuScene());

        });

        //Transition from login scene to signin scene when signin
        loginScene.getSigninButton().setOnAction((event) -> {
            loginScene.getErrorMessage().setText("");
            loginScene.getUsernameInput().clear();
            loginScene.getPasswordInput().clear();
            primaryStage.setTitle("Sign in screen");
            primaryStage.setScene(signInScene.getSignInScene());
        });

        //Sign in screen transitions
        //Transition from signin scene to login scene when create a new account
        signInScene.getCreateButton().setOnAction((event) -> {
            signInScene.getErrorMessage().setText("");
            String givenUsernameSignIn = signInScene.getUsernameInput().getText().trim();
            String givenPasswordSignIn = signInScene.getPasswordInput().getText().trim();
            if (givenUsernameSignIn.length() < 5) {
                signInScene.getErrorMessage().setText("Given username is too short");
                return;
            }
            
            if (givenPasswordSignIn.length() < 5) {
                signInScene.getErrorMessage().setText("Given password is too short");
                return;
            }

            if (usernameDatabase.searchUserInformation(givenUsernameSignIn)) {
                signInScene.getErrorMessage().setText("Given username already exists");
                return;
            }
            
            if (usernameDatabase.userPasswordCheck(givenUsernameSignIn, givenPasswordSignIn)) {
                signInScene.getErrorMessage().setText("Given password already exists");
                return;
            }
            
            Boolean isAdded = usernameDatabase.addUserInformation(givenUsernameSignIn,givenPasswordSignIn);

            if (!isAdded) {
                signInScene.getErrorMessage().setText("Error has occured");
                return;
            }

            signInScene.getErrorMessage().setText("");
            signInScene.getUsernameInput().clear();
            signInScene.getPasswordInput().clear();
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(loginScene.getLoginScene());
        });

        //Transition from signin scene to login scene when return
        signInScene.getReturnButton().setOnAction((event) -> {
            signInScene.getErrorMessage().setText("");
            signInScene.getUsernameInput().clear();
            signInScene.getPasswordInput().clear();
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(loginScene.getLoginScene());
        });

        //Main menu transitions
        //Transition from main menu scene to ability menu scene when ability menu
        mainMenuScene.getAbilitiesButton().setOnAction((event) -> {
            mainMenuScene.getErrorMessage().setText("");
            primaryStage.setTitle("Ability menu");
            primaryStage.setScene(abilityMenuScene.getAbilityMenuScene());
        });
        //Transition from main menu scene to profile menu scene when profile menu
        mainMenuScene.getProfilesButton().setOnAction((event) -> {
            mainMenuScene.getErrorMessage().setText("");
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(profileMenuScene.getProfileMenuScene());
        });
        
        //Transition from main menu scene to profile menu scene when admin menu
        mainMenuScene.getAdminButton().setOnAction((event) ->{
            if (!(username.equals("Tester")) && !(password.equals("Tester"))) {
                mainMenuScene.getErrorMessage().setText("Your user doesn't have admin privileges");
                return;
            }
            
            primaryStage.setTitle("Admin menu");
            primaryStage.setScene(adminMenuScene.getAdminMenuScene());
        });
        

        //Transition from main menu scene to login scene when sign out
        mainMenuScene.getSignOutButton().setOnAction((event) -> {
            usernameId = 0;
            username = "";
            password = "";
            mainMenuScene.getErrorMessage().setText("");
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(loginScene.getLoginScene());
        });
        
        
        //Ability menu transitions
        //Transition from ability menu scene to main menu scene when return
        abilityMenuScene.getReturnButton().setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(mainMenuScene.getMainMenuScene());
        });

        //Transition from ability menu scene to add ability scene when add ability
        abilityMenuScene.getAddAbilityButton().setOnAction((event) -> {
            primaryStage.setTitle("Add ability");
            primaryStage.setScene(addAbilitiesScene.getAddAbilitiesScene());
        });

        //Profile menu transitions;
        //Transition from profile menu scene to create profile scene when create profile
        profileMenuScene.getCreateProfileButton().setOnAction((event) -> {
            primaryStage.setTitle("Profile creator");
            primaryStage.setScene(createProfileScene.getCreateProfileScene());

        });

        //Transition from profile menu scene to main menu scene when return
        profileMenuScene.getReturnButton().setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(mainMenuScene.getMainMenuScene());
        });
        
        //Transitions from profile menu scene to create file from profile scene
        profileMenuScene.getCreateFileButton().setOnAction((event) -> {
            primaryStage.setTitle("Save profile as a file menu");
            primaryStage.setScene(createFileScene.getCreateFileScene());
        });
        
        //Resets profile
        profileMenuScene.getResetProfileButton().setOnAction((event) -> {
            createProfileScene.getProfileEditor().clear();
            createFileScene.getTextPresentation().setText("");
        });
        
        //Save profile as a file scene
        
        //Transition from create file from profile scene to profile menu scene 
        createFileScene.getReturnButton().setOnAction((event) -> {
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(profileMenuScene.getProfileMenuScene());
        });
        
        //Saving current profile as a file
        createFileScene.getSaveButton().setOnAction((event) -> {
            String text = createProfileScene.getProfileEditor().getText().trim();
            createFileScene.getTextPresentation().setText(text);
            fileWriter.showSaveFileDialog(primaryStage, text);
        });
        
        //Admin menu transitions
        adminMenuScene.getReturnButton().setOnAction((event) ->{
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(mainMenuScene.getMainMenuScene());
        });
        
        //
        adminMenuScene.getInspectMenuButton().setOnAction((event) ->{
            
            
        });
        
        
        //Add ability menu transition
        //Transition from add ability scene to ability main menu scene when return
        addAbilitiesScene.getReturnButton().setOnAction((event) -> {
            addAbilitiesScene.getErrorMessage().setText("");
            primaryStage.setTitle("Ability menu");
            primaryStage.setScene(abilityMenuScene.getAbilityMenuScene());
        });
        
        //Adding of new ability
        addAbilitiesScene.getCreateAbilityButton().setOnAction((event) -> {
            addAbilitiesScene.getErrorMessage().setText("");
            String textFieldClass = addAbilitiesScene.getClassInput().getText().trim();
            String textFieldName = addAbilitiesScene.getNameInput().getText().trim();
            String textFieldDescription = addAbilitiesScene.getDescriptionInput().getText().trim();
            String textFieldRequriment = addAbilitiesScene.getRequrimentInput().getText().trim();
            String textFieldReality = addAbilitiesScene.getRealityInput().getText().trim();
            
            String addAbility = uiAbilityLogic.addAbility(usernameId, textFieldClass, textFieldName, textFieldDescription, textFieldRequriment, textFieldReality);
            addAbilitiesScene.getErrorMessage().setText(addAbility);
            
            addAbilitiesScene.getClassInput().clear();
            addAbilitiesScene.getNameInput().clear();
            addAbilitiesScene.getDescriptionInput().clear();
            addAbilitiesScene.getRequrimentInput().clear();
            addAbilitiesScene.getRealityInput().clear();
        });

        //Transition from ability menu scene to remove ability scene when remove ability
        abilityMenuScene.getRemoveAbilityButton().setOnAction((event) -> {
            List<String> abilityList = abilityDatabase.showDatabaseAsARestrictedList(String.valueOf(usernameId));
            removeAbilitiesScene.getTableView().getItems().addAll(uiAbilityLogic.addAbilitiesIntoList(abilityList));
            primaryStage.setTitle("Remove Abilities table");
            primaryStage.setScene(removeAbilitiesScene.getRemoveAbilitiesScene());
            
        });
        
        //Removal of ability
        removeAbilitiesScene.getRemoveAbilityButton().setOnAction((event) -> {
            if (removeAbilitiesScene.getSelectionModel().getSelectedItems().size() > 0) {
                ObservableList selectedItems = removeAbilitiesScene.getSelectionModel().getSelectedItems();
                int removedIndex = removeAbilitiesScene.getSelectionModel().getFocusedIndex();
                uiAbilityLogic.removeAbility(usernameId, selectedItems);
                removeAbilitiesScene.getTableView().getItems().remove(removedIndex);
                removeAbilitiesScene.getTableView().refresh();
            }
        });
        
        //Transition from remove ability scene to ability menu
        removeAbilitiesScene.getReturnButton().setOnAction((event) -> {
            removeAbilitiesScene.getTableView().getItems().clear();
            primaryStage.setTitle("Ability menu");
            primaryStage.setScene(abilityMenuScene.getAbilityMenuScene());

        });


        //Create profile transitions
        //Transition from create profile scene to profile menu when save and return
        createProfileScene.getExitWithSave().setOnAction((event) -> {
            String unRefinedText = createProfileScene.getProfileEditor().getText();
            createFileScene.getTextPresentation().setText(unRefinedText);
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(profileMenuScene.getProfileMenuScene());
        });

        //Transition from create profile scene to profile menu when return without saving
        createProfileScene.getExitWithoutSave().setOnAction((event) -> {
            createProfileScene.getProfileEditor().clear();
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(profileMenuScene.getProfileMenuScene());
        });
        
        
        
        //Transition from create profile scene to choose ability scene when choose ability
        createProfileScene.getChoosenAbilityItem().setOnAction((event) -> {
            List<String> abilityList = abilityDatabase.showDatabaseAsARestrictedList(String.valueOf(usernameId));
            chooseAbilitiesScene.getTableView().getItems().addAll(uiAbilityLogic.addAbilitiesIntoList(abilityList));
            primaryStage.setTitle("Choose Abilities table");
            primaryStage.setScene(chooseAbilitiesScene.getChoosenAbilitiesScene());
        });
        
        //Resets choosen ability
        createProfileScene.getResetAbilityItem().setOnAction((event) -> {
            chosenAbility = "";
            leftOverParameters = "";
            createProfileScene.getLeftParameterItem().setText("Ability parameters left:" + "");
        });
        
        //Checks textarea string for ability parameters
        createProfileScene.getCheckAreaItem().setOnAction((event) -> {
            leftOverParameters = textRefinery.choosenAbilityIsFoundFromText(createProfileScene.getProfileEditor().getText(), chosenAbility);
            createProfileScene.getLeftParameterItem().setText("Ability parameters left:" + leftOverParameters);
        });
        
        //Checks textarea 
        createProfileScene.getProfileEditor().setOnKeyTyped((event) -> {
           createProfileScene.getLineCheckItem().setText("Text has different lines:"+textRefinery.givenTextLineChecker(createProfileScene.getProfileEditor().getText().trim()));
           createProfileScene.getSpaceCheckItem().setText("Words have spaces between them:"+textRefinery.givenTextLineHasSpaces(createProfileScene.getProfileEditor().getText().trim()));
           createProfileScene.getWordCountItem().setText("Current wordcount:"+textRefinery.giveTextWordCount(createProfileScene.getProfileEditor().getText().trim()));
           createProfileScene.getCharacterCountItem().setText("Current charactercount:"+textRefinery.giveCharacterCount(createProfileScene.getProfileEditor().getText().trim()));
        });
        
        
        //Choose ability transitions
        
        //Transition from choose ability scene to create profile scene when return
        chooseAbilitiesScene.getReturnButton().setOnAction((event) -> {
            chooseAbilitiesScene.getTableView().getItems().clear();
            primaryStage.setTitle("Profile creator");
            primaryStage.setScene(createProfileScene.getCreateProfileScene());
        });
        
        //Transition from choose ability scene to create profile scene when choose ability
        chooseAbilitiesScene.getChoosenAbilityButton().setOnAction((event) -> {
            if (chooseAbilitiesScene.getSelectionModel().getSelectedItems().size() > 0) {
                ObservableList selectedItems = chooseAbilitiesScene.getSelectionModel().getSelectedItems();
                String givenString = uiAbilityLogic.chooseAbility(selectedItems);
                chosenAbility = givenString;
                leftOverParameters = givenString;
                createProfileScene.getLeftParameterItem().setText("Ability parameters left:" + givenString);
                chooseAbilitiesScene.getTableView().getItems().clear();
                primaryStage.setTitle("Profile creator");
                primaryStage.setScene(createProfileScene.getCreateProfileScene());
            }
        });
        
        
        //UI start code
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(loginScene.getLoginScene());
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        usernameDatabase.removeUsernameDatabase();
        classDatabase.removeDatabase();
        nameDatabase.removeDatabase();
        descriptionDatabase.removeDatabase();
        requrimentDatabase.removeDatabase();
        realityDatabase.removeDatabase();
        abilityDatabase.removeDatabase();
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
