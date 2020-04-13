/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta.ui;

import Fiktiotietokanta.dao.databaseInterface;
import Fiktiotietokanta.dao.usernameInterface;
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
import Fiktiotietokanta.domain.usernameDatabase;
import Fiktiotietokanta.domain.abilityDatabase;
import Fiktiotietokanta.domain.classDatabase;
import Fiktiotietokanta.domain.descriptionDatabase;
import Fiktiotietokanta.domain.nameDatabase;
import Fiktiotietokanta.domain.realityDatabase;
import Fiktiotietokanta.domain.requrimentDatabase;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author niila
 */
public class userInterface extends Application {
     
    private usernameInterface usernameDatabase;
    private databaseInterface classDatabase;
    private databaseInterface nameDatabase;
    private databaseInterface descriptionDatabase;
    private databaseInterface requrimentDatabase;
    private databaseInterface realityDatabase;
    private databaseInterface abilityDatabase;
    private Integer usernameId;
    
    
    
    @Override
    public void init() throws Exception {
        usernameDatabase = new usernameDatabase();
        classDatabase = new classDatabase();
        nameDatabase = new nameDatabase();
        descriptionDatabase = new descriptionDatabase();
        requrimentDatabase = new requrimentDatabase();
        realityDatabase = new realityDatabase();
        abilityDatabase = new abilityDatabase();
        
        usernameDatabase.createUsernameDatabase();
        classDatabase.createDatabase();
        nameDatabase.createDatabase();
        descriptionDatabase.createDatabase();
        requrimentDatabase.createDatabase();
        realityDatabase.createDatabase();
        abilityDatabase.createDatabase();
               
        usernameId=0;
        
    }
    
       
    @Override
    public void start(Stage primaryStage) {

        //All UI Scenes
        //Login scene
        GridPane layout_Login = new GridPane();

        Label title_Login = new Label("What is your username?");
        Button login_Login = new Button("Login");
        Button signIn_Login = new Button("Sign in");
        Label loginerror_Login = new Label("");

        TextField usernameInput_Login = new TextField();

        layout_Login.add(title_Login, 0, 0);
        layout_Login.add(usernameInput_Login, 0, 1);
        layout_Login.add(login_Login, 0, 2);
        layout_Login.add(signIn_Login, 0, 3);
        layout_Login.add(loginerror_Login, 0, 4);

        layout_Login.setPrefSize(300, 300);
        layout_Login.setAlignment(Pos.CENTER);
        layout_Login.setVgap(10);
        layout_Login.setHgap(10);
        layout_Login.setPadding(new Insets(20, 20, 20, 20));

        Scene screen_Login = new Scene(layout_Login);

        //Sign in scene
        GridPane layout_SignIn = new GridPane();

        Label title_SignIn = new Label("Write a username atleast 5 letters long");
        Button create_SignIn = new Button("Create a new account");
        Button return_SignIn = new Button("Return");
        Label accountExistsError_SignIn = new Label("");
        Label accountIsToShortError_SignIn = new Label("");

        TextField createUsernameInput_SignIn = new TextField();

        layout_SignIn.add(title_SignIn, 0, 0);
        layout_SignIn.add(createUsernameInput_SignIn, 0, 1);
        layout_SignIn.add(create_SignIn, 0, 2);
        layout_SignIn.add(return_SignIn, 0, 3);
        layout_SignIn.add(accountExistsError_SignIn, 0, 4);
        layout_SignIn.add(accountIsToShortError_SignIn, 0, 4);

        layout_SignIn.setPrefSize(300, 300);
        layout_SignIn.setAlignment(Pos.CENTER);
        layout_SignIn.setVgap(10);
        layout_SignIn.setHgap(10);
        layout_SignIn.setPadding(new Insets(20, 20, 20, 20));

        Scene screen_SignIn = new Scene(layout_SignIn);
        //Main menu scene
        GridPane layout_MainMenu = new GridPane();

        Label title_MainMenu = new Label("What do you want to do?");
        Button ablitiesMenu_MainMenu = new Button("Ability Menu");
        Button profilesMenu_MainMenu = new Button("Profiles Menu");
        Button signOut_MainMenu = new Button("Sign out");

        layout_MainMenu.add(title_MainMenu, 0, 0);
        layout_MainMenu.add(ablitiesMenu_MainMenu, 0, 1);
        layout_MainMenu.add(profilesMenu_MainMenu, 0, 2);
        layout_MainMenu.add(signOut_MainMenu, 0, 3);

        layout_MainMenu.setPrefSize(300, 300);
        layout_MainMenu.setAlignment(Pos.CENTER);
        layout_MainMenu.setVgap(10);
        layout_MainMenu.setHgap(10);
        layout_MainMenu.setPadding(new Insets(20, 20, 20, 20));

        Scene screen_MainMenu = new Scene(layout_MainMenu);
        //Ability menu scene
        GridPane layout_AbilityMenu = new GridPane();

        Label title_AbilityMenu = new Label("What do you want to do?");
        Button addAbilities_AbilityMenu = new Button("Add abilities");
        Button removeAbilities_AbilityMenu = new Button("Remove abilities");
        Button return_AbilityMenu = new Button("Return to the main menu");

        layout_AbilityMenu.add(title_AbilityMenu, 0, 0);
        layout_AbilityMenu.add(addAbilities_AbilityMenu, 0, 1);
        layout_AbilityMenu.add(removeAbilities_AbilityMenu, 0, 2);
        layout_AbilityMenu.add(return_AbilityMenu, 0, 3);

        layout_AbilityMenu.setPrefSize(300, 300);
        layout_AbilityMenu.setAlignment(Pos.CENTER);
        layout_AbilityMenu.setVgap(10);
        layout_AbilityMenu.setHgap(10);
        layout_AbilityMenu.setPadding(new Insets(20, 20, 20, 20));

        Scene screen_AbilityMenu = new Scene(layout_AbilityMenu);
        //Profile menu scene
        GridPane layout_ProfileMenu = new GridPane();

        Label title_ProfileMenu = new Label("What do you want to do?");
        Button createProfile_ProfileMenu = new Button("Create a new profile");
        Button createFileProfile_ProfileMenu = new Button("Create a file from profile");
        Button resetProfile_ProfileMenu = new Button("Reset current profile");
        Button return_ProfileMenu = new Button("Return to the main menu");

        layout_ProfileMenu.add(title_ProfileMenu, 0, 0);
        layout_ProfileMenu.add(createProfile_ProfileMenu, 0, 1);
        layout_ProfileMenu.add(createFileProfile_ProfileMenu, 0, 2);
        layout_ProfileMenu.add(resetProfile_ProfileMenu, 0, 3);
        layout_ProfileMenu.add(return_ProfileMenu, 0, 4);

        layout_ProfileMenu.setPrefSize(300, 300);
        layout_ProfileMenu.setAlignment(Pos.CENTER);
        layout_ProfileMenu.setVgap(10);
        layout_ProfileMenu.setHgap(10);
        layout_ProfileMenu.setPadding(new Insets(20, 20, 20, 20));

        Scene screen_ProfileMenu = new Scene(layout_ProfileMenu);
        
        //Add abilities Scene
        
        GridPane addAbilityMenu=new GridPane();
        
        Label addAbilityMenuInsturctions=new Label("Fill all the blanks");
        Label addAbilityMenuClass=new Label("What class does the ability belong to?");
        Label addAbilityMenuName=new Label("What name does the ability have?");
        Label addAbilityMenuDescription=new Label("What description does the ability have?");
        Label addAbilityMenuRequriment=new Label("What requriment does the ability have?");
        Label addAbilityMenuReality=new Label("In what reality is the ability?");
        Button addAbilityMenuInsertNewAbility=new Button("Create ability");
        Button addAbilityMenuReturn=new Button("Return");
        Label addAbilityMenuError=new Label("");
        
        TextField writenGlass=new TextField();
        TextField writenName=new TextField();
        TextField writenDescription=new TextField();
        TextField writenRequriment=new TextField();
        TextField writenReality=new TextField();
        
        addAbilityMenu.add(addAbilityMenuInsturctions,0,0);
        addAbilityMenu.add(addAbilityMenuClass,0,1);
        addAbilityMenu.add(writenGlass,0,2);
        addAbilityMenu.add(addAbilityMenuName,0,3);
        addAbilityMenu.add(writenName,0,4);
        addAbilityMenu.add(addAbilityMenuDescription,0,5);
        addAbilityMenu.add(writenDescription,0,6);
        addAbilityMenu.add(addAbilityMenuRequriment,0,7);
        addAbilityMenu.add(writenRequriment,0,8);
        addAbilityMenu.add(addAbilityMenuReality,0,9);
        addAbilityMenu.add(writenReality,0,10);
        addAbilityMenu.add(addAbilityMenuInsertNewAbility,0,11);
        addAbilityMenu.add(addAbilityMenuReturn,0,12);
        addAbilityMenu.add(addAbilityMenuError,0,13);
        
        addAbilityMenu.setPrefSize(500, 500);
        addAbilityMenu.setAlignment(Pos.CENTER);
        addAbilityMenu.setVgap(10);
        addAbilityMenu.setHgap(10);
        addAbilityMenu.setPadding(new Insets(20, 20, 20, 20));
        
        Scene screenAddAbilityMenu= new Scene(addAbilityMenu);
        
        //Remove Abilities Scene
        
        //Create profile Scene
        
        VBox createProfileLayout=new VBox();
        
        GridPane createProfileMenu = new GridPane();
        
        BorderPane menuRoot = new BorderPane();
        
        MenuBar createProfileMenuBar = new MenuBar();
        
        Menu exitProfileMenu = new Menu("Exit profile creator");
        
        MenuItem exitProfileMenu1 = new MenuItem("Save and return");
        MenuItem exitProfileMenu2 = new MenuItem("Return without saving");
        
        exitProfileMenu.getItems().addAll(exitProfileMenu1,exitProfileMenu2);
        
        createProfileMenuBar.getMenus().addAll(exitProfileMenu);
        
        menuRoot.setTop(createProfileMenuBar);
        
        TextArea profileEditorCreateProfileMenu=new TextArea();
        
        profileEditorCreateProfileMenu.setMinSize(480, 425);
        profileEditorCreateProfileMenu.setMaxSize(480, 425);
        profileEditorCreateProfileMenu.setWrapText(true);
        
        
        createProfileMenu.getChildren().addAll(menuRoot);
        createProfileMenu.add(profileEditorCreateProfileMenu, 0, 0);
        
        createProfileLayout.getChildren().addAll(menuRoot,createProfileMenu);
        
        createProfileLayout.setPrefSize(500, 500);
        
        Scene createProfileScene=new Scene(createProfileLayout);
        
        
        
        //Create a file from Profile Scene
        
        //Reset current profile Scene      

        //All UI actions and events
        //Login screen transitions
        //Transition from login scene to mainmenu scene when login
        login_Login.setOnAction((event) -> {
            loginerror_Login.setText("");
            String givenUsername_Login = usernameInput_Login.getText().trim();
                
            if (!(usernameDatabase.searchUserInformation(givenUsername_Login))) {
                loginerror_Login.setText("Username doesn't exist");
                return;
            }
            
            
            usernameId=usernameDatabase.searchUsernameId(givenUsername_Login);
            usernameInput_Login.clear();
            loginerror_Login.setText("");
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(screen_MainMenu);

        });

        //Transition from login scene to signin scene when signin
        signIn_Login.setOnAction((event) -> {
            loginerror_Login.setText("");
            usernameInput_Login.clear();
            primaryStage.setTitle("Sign in screen");
            primaryStage.setScene(screen_SignIn);
        });

        //Sign in screen transitions
        //Transition from signin scene to login scene when create a new account
        create_SignIn.setOnAction((event) -> {
            accountIsToShortError_SignIn.setText("");
            accountExistsError_SignIn.setText("");
            String givenUsername_SignIn = createUsernameInput_SignIn.getText().trim();
            if (givenUsername_SignIn.length() < 5) {
                accountIsToShortError_SignIn.setText("Given username is too short");
                return;
            }
            
            if (usernameDatabase.searchUserInformation(givenUsername_SignIn)) {
                accountExistsError_SignIn.setText("Given username already exists");
                return;
            }
            
            Boolean isAdded = usernameDatabase.addUserInformation(givenUsername_SignIn);
            
            if (!isAdded) {
                accountExistsError_SignIn.setText("Error has occured");
                return;
            }
            
            accountIsToShortError_SignIn.setText("");
            accountExistsError_SignIn.setText("");
            createUsernameInput_SignIn.clear();
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(screen_Login);
        });

        //Transition from signin scene to login scene when return
        return_SignIn.setOnAction((event) -> {
            accountIsToShortError_SignIn.setText("");
            accountExistsError_SignIn.setText("");
            createUsernameInput_SignIn.clear();
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(screen_Login);
        });

        //Main menu transitions
        //Transition from main menu scene to ability menu scene when ability menu
        ablitiesMenu_MainMenu.setOnAction((event) -> {
            primaryStage.setTitle("Ability menu");
            primaryStage.setScene(screen_AbilityMenu);
        });

        profilesMenu_MainMenu.setOnAction((event) -> {
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(screen_ProfileMenu);
        });

        //Transition from main menu scene to login scene when sign out
        signOut_MainMenu.setOnAction((event) -> {
            //usernameId=0;
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(screen_Login);
        });

        //Ability menu transitions
        //Transition from ability menu scene to main menu scene when return
        return_AbilityMenu.setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(screen_MainMenu);
        });
        
        //Transition from ability menu scene to add ability scene when add ability
        
        addAbilities_AbilityMenu.setOnAction((event) -> {
           primaryStage.setTitle("Add ability");
           primaryStage.setScene(screenAddAbilityMenu);
        });
        

        //Profile menu transitions;
        
        //Transition from profile menu scene to create profile scene when create profile
        
        createProfile_ProfileMenu.setOnAction((event) -> {
            primaryStage.setTitle("Profile creator");
            primaryStage.setScene(createProfileScene);
            
        });
        
        //Transition from profile menu scene to main menu scene when return
        return_ProfileMenu.setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(screen_MainMenu);
        });
        
        //Add ability menu transition
        //Transition from add ability scene to ability main menu scene when return
        
        addAbilityMenuReturn.setOnAction((event) ->{
           addAbilityMenuError.setText("");
           primaryStage.setTitle("Ability menu");
           primaryStage.setScene(screen_AbilityMenu);
        });
        
        //Adding of new ability
        
        addAbilityMenuInsertNewAbility.setOnAction((event) -> {
           addAbilityMenuError.setText("");
           String textFieldClass = writenGlass.getText().trim();
           String textFieldName = writenName.getText().trim();
           String textFieldDescription = writenDescription.getText().trim();
           String textFieldRequriment = writenRequriment.getText().trim();
           String textFieldReality = writenReality.getText().trim();
           if (textFieldClass.length()==0 || textFieldName.length()==0 || textFieldDescription.length()==0 || textFieldRequriment.length()==0 || textFieldReality.length()==0){
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
               classHasBeenAdded=classDatabase.addInformation(textFieldClass);
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
           
           String information = String.valueOf(usernameId)+"/"+String.valueOf(classId)+"/"+String.valueOf(nameId)+"/"+String.valueOf(descriptionId)+"/"+String.valueOf(requrimentId)+"/"+String.valueOf(realityId);
           
           if (usernameId==0 || classId==0 || nameId==0 || descriptionId==0 || requrimentId==0 || realityId==0) {
               addAbilityMenuError.setText("Error has happened");
               return;
           }
           
           if (abilityDatabase.searchInformation(information)) {
               addAbilityMenuError.setText("Ability already exists");
               return;
           }
           
           Boolean abilityHasBeenAdded=abilityDatabase.addInformation(information);
           
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
           
           
        
        //Create profile transitions
        
        //Transition from create profile scene to profile menu when save and return
        
        exitProfileMenu1.setOnAction((event) -> {
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(screen_ProfileMenu);         
        });
        
        //Transition from create profile scene to profile menu when return without saving
        
        exitProfileMenu2.setOnAction((event) -> {
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(screen_ProfileMenu);        
        });
        
        
        

        //UI start code
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(screen_Login);
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
                
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
