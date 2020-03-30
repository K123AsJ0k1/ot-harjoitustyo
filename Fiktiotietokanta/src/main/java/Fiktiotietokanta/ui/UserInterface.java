/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta.ui;

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

/**
 *
 * @author niila
 */
public class UserInterface extends Application {

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
        layout_ProfileMenu.add(return_ProfileMenu,0,4);

        layout_ProfileMenu.setPrefSize(300, 300);
        layout_ProfileMenu.setAlignment(Pos.CENTER);
        layout_ProfileMenu.setVgap(10);
        layout_ProfileMenu.setHgap(10);
        layout_ProfileMenu.setPadding(new Insets(20, 20, 20, 20));

        Scene screen_ProfileMenu = new Scene(layout_ProfileMenu);

        //All UI actions and events
        //Login screen transitions
        //Transition from login scene to mainmenu scene when login
        login_Login.setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(screen_MainMenu);
        });

        //Transition from login scene to signin scene when signin
        signIn_Login.setOnAction((event) -> {
            primaryStage.setTitle("Sign in screen");
            primaryStage.setScene(screen_SignIn);
        });

        //Sign in screen transitions
        //Transition from signin scene to login scene when create a new account
        create_SignIn.setOnAction((event) -> {
            String givenUsername_SignIn = createUsernameInput_SignIn.getText().trim();
            if (givenUsername_SignIn.length() < 5) {
                accountIsToShortError_SignIn.setText("Given username is too short");
                return;
            }
            accountIsToShortError_SignIn.setText("");
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(screen_Login);
        });

        //Transition from signin scene to login scene when return
        return_SignIn.setOnAction((event) -> {
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
            primaryStage.setTitle("Login screen");
            primaryStage.setScene(screen_Login);
        });

        //Ability menu transitions
        
        //Transition from ability menu scene to main menu scene when return
        return_AbilityMenu.setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(screen_MainMenu);
        });

        //Profile menu transitions;
        //Transition from profile menu scene to main menu scene when return
        return_ProfileMenu.setOnAction((event) -> {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(screen_MainMenu);
        });

        //UI start code
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(screen_Login);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
