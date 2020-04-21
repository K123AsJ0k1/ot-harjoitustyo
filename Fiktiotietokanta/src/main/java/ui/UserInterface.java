/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Ability;
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
import dao.FileWriter;
import java.io.File;
import java.util.Arrays;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;

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
    private Integer usernameId;
    private String chosenAbility;
    private String leftOverParameters;
    
    @Override
    public void init() throws Exception {
        usernameDatabase = new UsernameDatabase();
        classDatabase = new ClassDatabase();
        nameDatabase = new NameDatabase();
        descriptionDatabase = new DescriptionDatabase();
        requrimentDatabase = new RequrimentDatabase();
        realityDatabase = new RealityDatabase();
        abilityDatabase = new AbilityDatabase();
        fileWriter = new FileWriter();

        usernameDatabase.createUsernameDatabase();
        classDatabase.createDatabase();
        nameDatabase.createDatabase();
        descriptionDatabase.createDatabase();
        requrimentDatabase.createDatabase();
        realityDatabase.createDatabase();
        abilityDatabase.createDatabase();

        usernameDatabase.addUserInformation("Tester");
        usernameId = 0;
        chosenAbility = "";
        leftOverParameters = "";

    }

    @Override
    public void start(Stage primaryStage) {

        //All UI Scenes
        //Login scene
        GridPane layoutLogin = new GridPane();

        Label titleLogin = new Label("What is your username?");
        Button loginLogin = new Button("Login");
        Button signInLogin = new Button("Sign in");
        Label loginerrorLogin = new Label("");

        TextField usernameInputLogin = new TextField();

        layoutLogin.add(titleLogin, 0, 0);
        layoutLogin.add(usernameInputLogin, 0, 1);
        layoutLogin.add(loginLogin, 0, 2);
        layoutLogin.add(signInLogin, 0, 3);
        layoutLogin.add(loginerrorLogin, 0, 4);

        layoutLogin.setPrefSize(300, 300);
        layoutLogin.setAlignment(Pos.CENTER);
        layoutLogin.setVgap(10);
        layoutLogin.setHgap(10);
        layoutLogin.setPadding(new Insets(20, 20, 20, 20));

        Scene screenLogin = new Scene(layoutLogin);

        //Sign in scene
        GridPane layoutSignIn = new GridPane();

        Label titleSignIn = new Label("Write a username atleast 5 letters long");
        Button createSignIn = new Button("Create a new account");
        Button returnSignIn = new Button("Return");
        Label accountExistsErrorSignIn = new Label("");
        Label accountIsToShortErrorSignIn = new Label("");

        TextField createUsernameInputSignIn = new TextField();

        layoutSignIn.add(titleSignIn, 0, 0);
        layoutSignIn.add(createUsernameInputSignIn, 0, 1);
        layoutSignIn.add(createSignIn, 0, 2);
        layoutSignIn.add(returnSignIn, 0, 3);
        layoutSignIn.add(accountExistsErrorSignIn, 0, 4);
        layoutSignIn.add(accountIsToShortErrorSignIn, 0, 4);

        layoutSignIn.setPrefSize(300, 300);
        layoutSignIn.setAlignment(Pos.CENTER);
        layoutSignIn.setVgap(10);
        layoutSignIn.setHgap(10);
        layoutSignIn.setPadding(new Insets(20, 20, 20, 20));

        Scene screenSignIn = new Scene(layoutSignIn);
        //Main menu scene
        GridPane layoutMainMenu = new GridPane();

        Label titleMainMenu = new Label("What do you want to do?");
        Button ablitiesMenuMainMenu = new Button("Ability Menu");
        Button profilesMenuMainMenu = new Button("Profiles Menu");
        Button signOutMainMenu = new Button("Sign out");

        layoutMainMenu.add(titleMainMenu, 0, 0);
        layoutMainMenu.add(ablitiesMenuMainMenu, 0, 1);
        layoutMainMenu.add(profilesMenuMainMenu, 0, 2);
        layoutMainMenu.add(signOutMainMenu, 0, 3);

        layoutMainMenu.setPrefSize(300, 300);
        layoutMainMenu.setAlignment(Pos.CENTER);
        layoutMainMenu.setVgap(10);
        layoutMainMenu.setHgap(10);
        layoutMainMenu.setPadding(new Insets(20, 20, 20, 20));

        Scene screenMainMenu = new Scene(layoutMainMenu);
        //Ability menu scene
        GridPane layoutAbilityMenu = new GridPane();

        Label titleAbilityMenu = new Label("What do you want to do?");
        Button addAbilitiesAbilityMenu = new Button("Add abilities");
        Button removeAbilitiesAbilityMenu = new Button("Remove abilities");
        Button returnAbilityMenu = new Button("Return to the main menu");

        layoutAbilityMenu.add(titleAbilityMenu, 0, 0);
        layoutAbilityMenu.add(addAbilitiesAbilityMenu, 0, 1);
        layoutAbilityMenu.add(removeAbilitiesAbilityMenu, 0, 2);
        layoutAbilityMenu.add(returnAbilityMenu, 0, 3);

        layoutAbilityMenu.setPrefSize(300, 300);
        layoutAbilityMenu.setAlignment(Pos.CENTER);
        layoutAbilityMenu.setVgap(10);
        layoutAbilityMenu.setHgap(10);
        layoutAbilityMenu.setPadding(new Insets(20, 20, 20, 20));

        Scene screenAbilityMenu = new Scene(layoutAbilityMenu);
        //Profile menu scene
        GridPane layoutProfileMenu = new GridPane();

        Label titleProfileMenu = new Label("What do you want to do?");
        Button createProfileProfileMenu = new Button("Create a new profile");
        Button createFileProfileProfileMenu = new Button("Create a file from profile");
        Button resetProfileProfileMenu = new Button("Reset current profile");
        Button returnProfileMenu = new Button("Return to the main menu");

        layoutProfileMenu.add(titleProfileMenu, 0, 0);
        layoutProfileMenu.add(createProfileProfileMenu, 0, 1);
        layoutProfileMenu.add(createFileProfileProfileMenu, 0, 2);
        layoutProfileMenu.add(resetProfileProfileMenu, 0, 3);
        layoutProfileMenu.add(returnProfileMenu, 0, 4);

        layoutProfileMenu.setPrefSize(300, 300);
        layoutProfileMenu.setAlignment(Pos.CENTER);
        layoutProfileMenu.setVgap(10);
        layoutProfileMenu.setHgap(10);
        layoutProfileMenu.setPadding(new Insets(20, 20, 20, 20));

        Scene screenProfileMenu = new Scene(layoutProfileMenu);
        
        //Create file from profile scene
        
        VBox saveProfileLayOut = new VBox();
        
        Text profileViewSaveProfile = new Text();
        profileViewSaveProfile.setFont(new Font(14));
        
        
        HBox saveProfileButtonLayOut = new HBox();
        
        Button saveButtonSaveProfile = new Button("Save");
        Button returnButtonSaveProfile = new Button("Return");
        
        saveProfileButtonLayOut.setAlignment(Pos.CENTER);
        
        saveProfileButtonLayOut.getChildren().addAll(saveButtonSaveProfile, returnButtonSaveProfile);
        
        saveProfileLayOut.getChildren().addAll(profileViewSaveProfile,saveProfileButtonLayOut);
        
        saveProfileLayOut.setAlignment(Pos.CENTER);
        saveProfileLayOut.setPrefSize(500, 500);
        
        Scene saveProfileMenu = new Scene(saveProfileLayOut); 

        //Add abilities Scene
        GridPane addAbilityMenu = new GridPane();

        Label addAbilityMenuInsturctions = new Label("Fill all the blanks");
        Label addAbilityMenuClass = new Label("What class does the ability belong to?");
        Label addAbilityMenuName = new Label("What name does the ability have?");
        Label addAbilityMenuDescription = new Label("What description does the ability have?");
        Label addAbilityMenuRequriment = new Label("What requriment does the ability have?");
        Label addAbilityMenuReality = new Label("In what reality is the ability?");
        Button addAbilityMenuInsertNewAbility = new Button("Create ability");
        Button addAbilityMenuReturn = new Button("Return");
        Label addAbilityMenuError = new Label("");

        TextField writenGlass = new TextField();
        TextField writenName = new TextField();
        TextField writenDescription = new TextField();
        TextField writenRequriment = new TextField();
        TextField writenReality = new TextField();

        addAbilityMenu.add(addAbilityMenuInsturctions, 0, 0);
        addAbilityMenu.add(addAbilityMenuClass, 0, 1);
        addAbilityMenu.add(writenGlass, 0, 2);
        addAbilityMenu.add(addAbilityMenuName, 0, 3);
        addAbilityMenu.add(writenName, 0, 4);
        addAbilityMenu.add(addAbilityMenuDescription, 0, 5);
        addAbilityMenu.add(writenDescription, 0, 6);
        addAbilityMenu.add(addAbilityMenuRequriment, 0, 7);
        addAbilityMenu.add(writenRequriment, 0, 8);
        addAbilityMenu.add(addAbilityMenuReality, 0, 9);
        addAbilityMenu.add(writenReality, 0, 10);
        addAbilityMenu.add(addAbilityMenuInsertNewAbility, 0, 11);
        addAbilityMenu.add(addAbilityMenuReturn, 0, 12);
        addAbilityMenu.add(addAbilityMenuError, 0, 13);

        addAbilityMenu.setPrefSize(500, 500);
        addAbilityMenu.setAlignment(Pos.CENTER);
        addAbilityMenu.setVgap(10);
        addAbilityMenu.setHgap(10);
        addAbilityMenu.setPadding(new Insets(20, 20, 20, 20));

        Scene screenAddAbilityMenu = new Scene(addAbilityMenu);

        //Remove Abilities Scene
        VBox removeAbilityLayout = new VBox();

        Label removeAbilityTableViewLable = new Label("List of abilities you have created");

        HBox removeAbilityButtonLayout = new HBox();

        Button removeSelectedAbilityTableView = new Button("Remove selected ability");
        Button returnAbilityMenuTableView = new Button("Return");
        

        removeAbilityButtonLayout.getChildren().addAll(returnAbilityMenuTableView, removeSelectedAbilityTableView);
        TableView removeAbilityTableView = new TableView();

        TableColumn<String, Ability> classTableViewColumn = new TableColumn<>("Class");
        classTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("classIdentity"));
        TableColumn<String, Ability> nameTableViewColumn = new TableColumn<>("Name");
        nameTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("nameIdentity"));
        TableColumn<String, Ability> descriptionTableViewColumn = new TableColumn<>("Description");
        descriptionTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("descriptionIdentity"));
        TableColumn<String, Ability> requrimentTableViewColumn = new TableColumn<>("Requriment");
        requrimentTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("requrimentIdentity"));
        TableColumn<String, Ability> realityTableViewColumn = new TableColumn<>("Reality");
        realityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("realityIdentity"));

        removeAbilityTableView.getColumns().addAll(classTableViewColumn, nameTableViewColumn, descriptionTableViewColumn, requrimentTableViewColumn, realityTableViewColumn);
        removeAbilityLayout.getChildren().addAll(removeAbilityTableViewLable, removeAbilityTableView, removeAbilityButtonLayout);

        removeAbilityLayout.setPrefSize(320, 400);

        TableViewSelectionModel<Ability> selectionModelTableView = removeAbilityTableView.getSelectionModel();
        selectionModelTableView.setSelectionMode(SelectionMode.SINGLE);

        Scene removeAbilityTable = new Scene(removeAbilityLayout);

        //Create profile Scene
        VBox createProfileLayout = new VBox();

        GridPane createProfileMenu = new GridPane();

        BorderPane menuRoot = new BorderPane();

        MenuBar createProfileMenuBar = new MenuBar();
        
        ContextMenu contextMenuCreateProfile = new ContextMenu();
        MenuItem chooseAnAbilityContextMenu = new MenuItem("Choose an Ability");
        MenuItem currenAbilityProgressContextMenu = new MenuItem("Ability parameters left:");
        MenuItem resetAnAbilityContextMenu = new MenuItem("Resets current ability");
        MenuItem checkTextAreaContextMenu = new MenuItem("Check the textarea for ability parameters");
        MenuItem wordCountContextMenu = new MenuItem("Current wordcount:0");
        MenuItem characterCountContextMenu = new MenuItem("Current character count:0");
        
        contextMenuCreateProfile.getItems().addAll(chooseAnAbilityContextMenu, currenAbilityProgressContextMenu, resetAnAbilityContextMenu,checkTextAreaContextMenu,wordCountContextMenu,characterCountContextMenu);   
        Menu exitProfileMenu = new Menu("Exit profile creator");

        MenuItem exitProfileMenu1 = new MenuItem("Save and return");
        MenuItem exitProfileMenu2 = new MenuItem("Return without saving");

        exitProfileMenu.getItems().addAll(exitProfileMenu1, exitProfileMenu2);
        
        Menu textTemplatesAreaProfileMenu = new Menu("Templates");
        
        MenuItem editTextAreaProfileMenu1 = new MenuItem("Unspesified profile template");
        MenuItem editTextAreaProfileMenu2 = new MenuItem("Person profile template");
        MenuItem editTextAreaProfileMenu3 = new MenuItem("Culture profile template");
        MenuItem editTextAreaProfileMenu4 = new MenuItem("Object profile template");
        MenuItem editTextAreaProfileMenu5 = new MenuItem("Place profile template");
        MenuItem editTextAreaProfileMenu6 = new MenuItem("World profile template");
        MenuItem editTextAreaProfileMenu7 = new MenuItem("Universe profile template");
        
        textTemplatesAreaProfileMenu.getItems().addAll(editTextAreaProfileMenu1, editTextAreaProfileMenu2, editTextAreaProfileMenu3, editTextAreaProfileMenu4, editTextAreaProfileMenu5, editTextAreaProfileMenu6,editTextAreaProfileMenu7);
        
        Menu helpProfileMenu = new Menu("Help");
        
        MenuItem helpProfileMenu1 = new MenuItem("How to use this editor");
        MenuItem helpProfileMenu2 = new MenuItem("Quick tips");
        MenuItem helpProfileMenu3 = new MenuItem("General questions answered");
        
        helpProfileMenu.getItems().addAll(helpProfileMenu1, helpProfileMenu2, helpProfileMenu3);
          
        createProfileMenuBar.getMenus().addAll(exitProfileMenu, textTemplatesAreaProfileMenu, helpProfileMenu);

        menuRoot.setTop(createProfileMenuBar);

        TextArea profileEditorCreateProfileMenu = new TextArea();
        profileEditorCreateProfileMenu.setContextMenu(contextMenuCreateProfile);

        profileEditorCreateProfileMenu.setMinSize(480, 425);
        profileEditorCreateProfileMenu.setMaxSize(480, 425);
        profileEditorCreateProfileMenu.setWrapText(true);

        createProfileMenu.getChildren().addAll(menuRoot);
        createProfileMenu.add(profileEditorCreateProfileMenu, 0, 0);

        createProfileLayout.getChildren().addAll(menuRoot, createProfileMenu);

        createProfileLayout.setPrefSize(500, 500);

        Scene createProfileScene = new Scene(createProfileLayout);
        
        //Choose ability scene
        
        VBox chooseAbilityLayout = new VBox();

        Label chooseAbilityTableViewLable = new Label("List of abilities you have created");

        HBox chooseAbilityButtonLayout = new HBox();

        Button chooseSelectedAbilityTableView = new Button("Choose selected ability");
        Button returnChooseAbilityMenuTableView = new Button("Return");
        
        chooseAbilityLayout.getChildren().addAll(returnChooseAbilityMenuTableView, chooseSelectedAbilityTableView);
        TableView chooseAbilityTableView = new TableView();

        TableColumn<String, Ability> classChooseAbilityTableViewColumn = new TableColumn<>("Class");
        classChooseAbilityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("classIdentity"));
        TableColumn<String, Ability> nameChooseAbilityTableViewColumn = new TableColumn<>("Name");
        nameChooseAbilityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("nameIdentity"));
        TableColumn<String, Ability> descriptionChooseAbilityTableViewColumn = new TableColumn<>("Description");
        descriptionChooseAbilityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("descriptionIdentity"));
        TableColumn<String, Ability> requrimentChooseAbilityTableViewColumn = new TableColumn<>("Requriment");
        requrimentChooseAbilityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("requrimentIdentity"));
        TableColumn<String, Ability> realityChooseAbilityTableViewColumn = new TableColumn<>("Reality");
        realityChooseAbilityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("realityIdentity"));

        chooseAbilityTableView.getColumns().addAll(classChooseAbilityTableViewColumn, nameChooseAbilityTableViewColumn, descriptionChooseAbilityTableViewColumn, requrimentChooseAbilityTableViewColumn, realityChooseAbilityTableViewColumn);
        chooseAbilityLayout.getChildren().addAll(chooseAbilityTableViewLable, chooseAbilityTableView, chooseAbilityButtonLayout);

        chooseAbilityLayout.setPrefSize(400, 400);

        TableViewSelectionModel<Ability> selectionModelChooseAbilityTableView = chooseAbilityTableView.getSelectionModel();
        selectionModelChooseAbilityTableView.setSelectionMode(SelectionMode.SINGLE);

        Scene chooseAbilityTable = new Scene(chooseAbilityLayout);

        //Create a file from Profile Scene
        //Reset current profile Scene      
        //All UI actions and events
        
        //Login screen transitions
        //Transition from login scene to mainmenu scene when login
        loginLogin.setOnAction((event) -> {
            loginerrorLogin.setText("");
            String givenUsernameLogin = usernameInputLogin.getText().trim();

            if (!(usernameDatabase.searchUserInformation(givenUsernameLogin))) {
                loginerrorLogin.setText("Username doesn't exist");
                return;
            }

            usernameId = usernameDatabase.searchUsernameId(givenUsernameLogin);
            usernameInputLogin.clear();
            loginerrorLogin.setText("");
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(screenMainMenu);

        });

        //Transition from login scene to signin scene when signin
        signInLogin.setOnAction((event) -> {
            loginerrorLogin.setText("");
            usernameInputLogin.clear();
            primaryStage.setTitle("Sign in screen");
            primaryStage.setScene(screenSignIn);
        });

        //Sign in screen transitions
        //Transition from signin scene to login scene when create a new account
        createSignIn.setOnAction((event) -> {
            accountIsToShortErrorSignIn.setText("");
            accountExistsErrorSignIn.setText("");
            String givenUsernameSignIn = createUsernameInputSignIn.getText().trim();
            if (givenUsernameSignIn.length() < 5) {
                accountIsToShortErrorSignIn.setText("Given username is too short");
                return;
            }

            if (usernameDatabase.searchUserInformation(givenUsernameSignIn)) {
                accountExistsErrorSignIn.setText("Given username already exists");
                return;
            }

            Boolean isAdded = usernameDatabase.addUserInformation(givenUsernameSignIn);

            if (!isAdded) {
                accountExistsErrorSignIn.setText("Error has occured");
                return;
            }

            accountIsToShortErrorSignIn.setText("");
            accountExistsErrorSignIn.setText("");
            createUsernameInputSignIn.clear();
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(screenLogin);
        });

        //Transition from signin scene to login scene when return
        returnSignIn.setOnAction((event) -> {
            accountIsToShortErrorSignIn.setText("");
            accountExistsErrorSignIn.setText("");
            createUsernameInputSignIn.clear();
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(screenLogin);
        });

        //Main menu transitions
        //Transition from main menu scene to ability menu scene when ability menu
        ablitiesMenuMainMenu.setOnAction((event) -> {
            primaryStage.setTitle("Ability menu");
            primaryStage.setScene(screenAbilityMenu);
        });

        profilesMenuMainMenu.setOnAction((event) -> {
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(screenProfileMenu);
        });

        //Transition from main menu scene to login scene when sign out
        signOutMainMenu.setOnAction((event) -> {
            //usernameId=0;
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(screenLogin);
        });

        //Ability menu transitions
        //Transition from ability menu scene to main menu scene when return
        returnAbilityMenu.setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(screenMainMenu);
        });

        //Transition from ability menu scene to add ability scene when add ability
        addAbilitiesAbilityMenu.setOnAction((event) -> {
            primaryStage.setTitle("Add ability");
            primaryStage.setScene(screenAddAbilityMenu);
        });

        //Profile menu transitions;
        //Transition from profile menu scene to create profile scene when create profile
        createProfileProfileMenu.setOnAction((event) -> {
            primaryStage.setTitle("Profile creator");
            primaryStage.setScene(createProfileScene);

        });

        //Transition from profile menu scene to main menu scene when return
        returnProfileMenu.setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(screenMainMenu);
        });
        
        //Transitions from profile menu scene to create file from profile scene
        createFileProfileProfileMenu.setOnAction((event) -> {
            primaryStage.setTitle("Save profile as a file menu");
            primaryStage.setScene(saveProfileMenu);
        });
        
        //Resets profile
        resetProfileProfileMenu.setOnAction((event) -> {
            profileEditorCreateProfileMenu.clear();
            profileViewSaveProfile.setText("");
        });
        
        //Save profile as a file scene
        
        //Transition from create file from profile scene to profile menu scene 
        returnButtonSaveProfile.setOnAction((event) -> {
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(screenProfileMenu);
        });
        
        //Saving current profile as a file
        saveButtonSaveProfile.setOnAction((event) -> {
            String unRefinedText = profileEditorCreateProfileMenu.getText();
            profileViewSaveProfile.setText(unRefinedText);
            FileChooser fileChooser = new FileChooser();
            
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
 
            File file = fileChooser.showSaveDialog(primaryStage);
 
            if (file != null) {
                fileWriter.saveTextAsAFile(unRefinedText, file);
            }
        });

        //Add ability menu transition
        //Transition from add ability scene to ability main menu scene when return
        addAbilityMenuReturn.setOnAction((event) -> {
            addAbilityMenuError.setText("");
            primaryStage.setTitle("Ability menu");
            primaryStage.setScene(screenAbilityMenu);
        });

        //Adding of new ability
        addAbilityMenuInsertNewAbility.setOnAction((event) -> {
            addAbilityMenuError.setText("");
            String textFieldClass = writenGlass.getText().trim();
            String textFieldName = writenName.getText().trim();
            String textFieldDescription = writenDescription.getText().trim();
            String textFieldRequriment = writenRequriment.getText().trim();
            String textFieldReality = writenReality.getText().trim();
            if (textFieldClass.length() == 0 || textFieldName.length() == 0 || textFieldDescription.length() == 0 || textFieldRequriment.length() == 0 || textFieldReality.length() == 0) {
                addAbilityMenuError.setText("Not all blanks are full");
                return;
            }

            Boolean addClass = false;
            Boolean addName = false;
            Boolean addDescription = false;
            Boolean addRequriment = false;
            Boolean addReality = false;

            if (!classDatabase.searchInformation(textFieldClass)) {
                addClass = true;
            }

            if (!nameDatabase.searchInformation(textFieldName)) {
                addName = true;
            }

            if (!descriptionDatabase.searchInformation(textFieldDescription)) {
                addDescription = true;
            }

            if (!requrimentDatabase.searchInformation(textFieldRequriment)) {
                addRequriment = true;
            }

            if (!realityDatabase.searchInformation(textFieldReality)) {
                addReality = true;
            }

            Boolean classHasBeenAdded = false;

            if (addClass) {
                classHasBeenAdded = classDatabase.addInformation(textFieldClass);
            }

            Boolean nameHasBeenAdded = false;

            if (addName) {
                nameHasBeenAdded = nameDatabase.addInformation(textFieldName);
            }

            Boolean descriptionHasBeenAdded = false;

            if (addDescription) {
                descriptionHasBeenAdded = descriptionDatabase.addInformation(textFieldDescription);
            }

            Boolean requrimentHasBeenAdded = false;

            if (addRequriment) {
                requrimentHasBeenAdded = requrimentDatabase.addInformation(textFieldRequriment);
            }

            Boolean realityHasBeenAdded = false;

            if (addReality) {
                realityHasBeenAdded = realityDatabase.addInformation(textFieldReality);
            }

            int classId = classDatabase.searchInfromationId(textFieldClass);
            int nameId = nameDatabase.searchInfromationId(textFieldName);
            int descriptionId = descriptionDatabase.searchInfromationId(textFieldDescription);
            int requrimentId = requrimentDatabase.searchInfromationId(textFieldRequriment);
            int realityId = realityDatabase.searchInfromationId(textFieldReality);

            String information = String.valueOf(usernameId) + "/" + String.valueOf(classId) + "/" + String.valueOf(nameId) + "/" + String.valueOf(descriptionId) + "/" + String.valueOf(requrimentId) + "/" + String.valueOf(realityId);

            if (usernameId == 0 || classId == 0 || nameId == 0 || descriptionId == 0 || requrimentId == 0 || realityId == 0) {
                addAbilityMenuError.setText("Error has happened");
                return;
            }

            if (abilityDatabase.searchInformation(information)) {
                addAbilityMenuError.setText("Ability already exists");
                return;
            }

            Boolean abilityHasBeenAdded = abilityDatabase.addInformation(information);

            if (!abilityHasBeenAdded) {
                addAbilityMenuError.setText("Error has happened");
                return;
            }

            addAbilityMenuError.setText("Ability has been added");

            writenGlass.clear();
            writenName.clear();
            writenDescription.clear();
            writenRequriment.clear();
            writenReality.clear();
        });

        //Transition from ability menu scene to remove ability scene when remove ability
        removeAbilitiesAbilityMenu.setOnAction((event) -> {
            
            List<String> abilityList = abilityDatabase.showDatabaseAsARestrictedList(String.valueOf(usernameId));
            
            for (String ability : abilityList) {
                String[] split = ability.split("/");
                String classIdentity = classDatabase.searchInformationTextIdentity(split[0]);
                String nameIdentity = nameDatabase.searchInformationTextIdentity(split[1]);
                String descriptionIdentity = descriptionDatabase.searchInformationTextIdentity(split[2]);
                String requrimentIdentity = requrimentDatabase.searchInformationTextIdentity(split[3]);
                String realityIdentity = realityDatabase.searchInformationTextIdentity(split[4]);
                Ability addedAbility = new Ability(classIdentity, nameIdentity, descriptionIdentity, requrimentIdentity, realityIdentity);
                removeAbilityTableView.getItems().add(addedAbility);
            }

            primaryStage.setTitle("Remove Abilities table");
            primaryStage.setScene(removeAbilityTable);
            
        });
        
        //Removal of ability
        removeSelectedAbilityTableView.setOnAction((event) -> {
            if (selectionModelTableView.getSelectedItems().size() > 0) {
                ObservableList selectedItems = selectionModelTableView.getSelectedItems();
                int removedIndex = selectionModelTableView.getFocusedIndex();
                String[] givenAbilitySplit = selectedItems.get(0).toString().split("/");
                int classId = classDatabase.searchInfromationId(givenAbilitySplit[0]);
                int nameId = nameDatabase.searchInfromationId(givenAbilitySplit[1]);
                int descriptionId = descriptionDatabase.searchInfromationId(givenAbilitySplit[2]);
                int requrimentId = requrimentDatabase.searchInfromationId(givenAbilitySplit[3]);
                int realityId = realityDatabase.searchInfromationId(givenAbilitySplit[4]);
                String removedId = String.valueOf(usernameId) + "/" + String.valueOf(classId) + "/" + String.valueOf(nameId) + "/" + String.valueOf(descriptionId) + "/" + String.valueOf(requrimentId) + "/" + String.valueOf(realityId);
                abilityDatabase.removeInformation(removedId);
                removeAbilityTableView.getItems().remove(removedIndex);
                removeAbilityTableView.refresh();
            }
        });
        
        //Transition from remove ability scene to ability menu
        returnAbilityMenuTableView.setOnAction((event) -> {
            removeAbilityTableView.getItems().clear();
            primaryStage.setTitle("Ability menu");
            primaryStage.setScene(screenAbilityMenu);

        });


        //Create profile transitions
        //Transition from create profile scene to profile menu when save and return
        exitProfileMenu1.setOnAction((event) -> {
            String unRefinedText = profileEditorCreateProfileMenu.getText();
            profileViewSaveProfile.setText(unRefinedText);
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(screenProfileMenu);
        });

        //Transition from create profile scene to profile menu when return without saving
        exitProfileMenu2.setOnAction((event) -> {
            profileEditorCreateProfileMenu.clear();
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(screenProfileMenu);
        });
        
        //Unspecified text template
        editTextAreaProfileMenu1.setOnAction((event) -> {
           String unspecifiedTemplate = "";
           profileEditorCreateProfileMenu.setText(unspecifiedTemplate); 
        });
        
        //Transition from create profile scene to choose ability scene when choose ability
        chooseAnAbilityContextMenu.setOnAction((event) -> {
            List<String> abilityList = abilityDatabase.showDatabaseAsARestrictedList(String.valueOf(usernameId));
            
            for (String ability : abilityList) {
                String[] split = ability.split("/");
                String classIdentity = classDatabase.searchInformationTextIdentity(split[0]);
                String nameIdentity = nameDatabase.searchInformationTextIdentity(split[1]);
                String descriptionIdentity = descriptionDatabase.searchInformationTextIdentity(split[2]);
                String requrimentIdentity = requrimentDatabase.searchInformationTextIdentity(split[3]);
                String realityIdentity = realityDatabase.searchInformationTextIdentity(split[4]);
                Ability addedAbility = new Ability(classIdentity, nameIdentity, descriptionIdentity, requrimentIdentity, realityIdentity);
                chooseAbilityTableView.getItems().add(addedAbility);
            }

            primaryStage.setTitle("Choose Abilities table");
            primaryStage.setScene(chooseAbilityTable);
        });
        
        //Resets choosen ability
        resetAnAbilityContextMenu.setOnAction((event) -> {
            chosenAbility = "";
            leftOverParameters = "";
            currenAbilityProgressContextMenu.setText("Ability parameters left:" + "");
        });
        
        //Checks textarea string for ability parameters
        checkTextAreaContextMenu.setOnAction((event) -> {
            
            String[] wordTable = profileEditorCreateProfileMenu.getText().trim().split(" ");
            String[] parameterTable = chosenAbility.trim().split(",");
            
            if (parameterTable.length==5) {
            Boolean classIsPresent = false;
            Boolean nameIsPresent = false;
            Boolean descriptionIsPresent = false;
            Boolean requrimentIsPresent = false;
            Boolean realityIsPresent = false;
            
            String classString = parameterTable[0];
            String nameString = parameterTable[1];
            String descriptionString = parameterTable[2];
            String requrimentString = parameterTable[3];
            String realityString = parameterTable[4];
            System.out.println(classString);
            System.out.println(nameString);
            System.out.println(descriptionString);
            System.out.println(requrimentString);
            System.out.println(realityString);
            for (String text: wordTable) {
                
                if (text.equals(parameterTable[0])) {
                    classIsPresent = true;
                }
                
                if (text.equals(parameterTable[1])) {
                    nameIsPresent = true;
                }
                
                if (text.equals(parameterTable[2])) {
                    descriptionIsPresent = true;
                }
                
                if (text.equals(parameterTable[3])) {
                    requrimentIsPresent = true;
                }
                
                if (text.equals(parameterTable[4])) {
                    realityIsPresent = true;
                }
                
            }
            
            String modifiedAbilityString = "";
            
            if (!classIsPresent) {
                modifiedAbilityString = classString;
            }
            
            if (!nameIsPresent) {
                if (modifiedAbilityString.equals(classString)) {
                   modifiedAbilityString = modifiedAbilityString + "," + nameString; 
                }
                if (modifiedAbilityString.equals("")) {
                    modifiedAbilityString = nameString; 
                }
                
            }
            
            if (!descriptionIsPresent) {
                if (modifiedAbilityString.contains(classString) || modifiedAbilityString.contains(nameString) ) {
                   modifiedAbilityString = modifiedAbilityString + "," + descriptionString;
                }
                if (modifiedAbilityString.equals("")) {
                    modifiedAbilityString = descriptionString; 
                }
                       
            }
            
            if (!requrimentIsPresent) {
                if (modifiedAbilityString.contains(classString) || modifiedAbilityString.contains(nameString) || modifiedAbilityString.contains(descriptionString)) {
                   modifiedAbilityString = modifiedAbilityString + "," + requrimentString;
                }
                if (modifiedAbilityString.equals("")) {
                    modifiedAbilityString = requrimentString; 
                }
                
            }
            
            if (!realityIsPresent) {
                if (modifiedAbilityString.contains(classString) || modifiedAbilityString.contains(nameString) || modifiedAbilityString.contains(descriptionString) || modifiedAbilityString.contains(requrimentString)) {
                   modifiedAbilityString = modifiedAbilityString + "," + realityString;
                }
                if (modifiedAbilityString.equals("")) {
                    modifiedAbilityString = realityString; 
                }
                
            }
            
            leftOverParameters = modifiedAbilityString;
            
            currenAbilityProgressContextMenu.setText("Ability parameters left:" + leftOverParameters);
            
            }
        });
        
        //Checks textarea wordcount and character count
        profileEditorCreateProfileMenu.setOnKeyTyped((event) -> {
           String[] wordTable = profileEditorCreateProfileMenu.getText().split(" ");
           char[] characterTable = profileEditorCreateProfileMenu.getText().toCharArray();
           if (characterTable.length==0) {
               wordCountContextMenu.setText("Current wordcount:0");
               characterCountContextMenu.setText("Current character count:0");
               return;
           }
           wordCountContextMenu.setText("Current wordcount:"+ wordTable.length);
           characterCountContextMenu.setText("Current charactercount:"+characterTable.length);
        });
        
        //Choose ability transitions
        
        //Transition from choose ability scene to create profile scene when return
        returnChooseAbilityMenuTableView.setOnAction((event) -> {
            chooseAbilityTableView.getItems().clear();
            primaryStage.setTitle("Profile creator");
            primaryStage.setScene(createProfileScene);
        });
        
        //Transition from choose ability scene to create profile scene when choose ability
        chooseSelectedAbilityTableView.setOnAction((event) -> {
            if (selectionModelChooseAbilityTableView.getSelectedItems().size() > 0) {
                ObservableList selectedItems = selectionModelChooseAbilityTableView.getSelectedItems();
                String[] givenAbilitySplit = selectedItems.get(0).toString().split("/");
                String selectedParameters = givenAbilitySplit[0] + "," + givenAbilitySplit[1] + "," + givenAbilitySplit[2] + "," + givenAbilitySplit[3] + "," + givenAbilitySplit[4];
                chosenAbility = selectedParameters;
                leftOverParameters = selectedParameters;
                currenAbilityProgressContextMenu.setText("Ability parameters left:" + leftOverParameters);
                chooseAbilityTableView.getItems().clear();
                primaryStage.setTitle("Profile creator");
                primaryStage.setScene(createProfileScene);
            }
        });
        
        
        //UI start code
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(screenLogin);
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
