/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programscenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author niila
 */
public class PublicMainMenuScene {
    
    Scene mainMenuScreen;
    Button abilitiesButton;
    Button profilesButton;
    Button adminButton;
    Button signOutButton;
    Label errorMessage;
    
    public PublicMainMenuScene() {
        GridPane layout = new GridPane();

        Label titleMainMenu = new Label("What do you want to do?");
        this.abilitiesButton = new Button("Ability Menu");
        this.profilesButton = new Button("Profiles Menu");
        this.adminButton = new Button("Admin Menu");
        this.signOutButton = new Button("Sign out");
        this.errorMessage = new Label("");

        layout.add(titleMainMenu, 0, 0);
        layout.add(this.abilitiesButton, 0, 1);
        layout.add(this.profilesButton, 0, 2);
        layout.add(this.adminButton, 0, 3);
        layout.add(this.signOutButton, 0, 4);
        layout.add(this.errorMessage, 0, 5);

        layout.setPrefSize(300, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        this.mainMenuScreen = new Scene(layout);
    }
    
    public void setMainMenuStage(Stage primaryStage) {
        primaryStage.setTitle("Main menu");
        primaryStage.setScene(this.mainMenuScreen);
    }
    
    public Scene getMainMenuScene() {
        return this.mainMenuScreen;
    }
    
    public Button getAbilitiesButton() {
        return this.abilitiesButton;
    }
    
    public Button getProfilesButton() {
        return this.profilesButton;
    }
    
    public Button getAdminButton() {
        return this.adminButton;
    }
    
    public Button getSignOutButton() {
        return this.signOutButton;
    }
    
    public Label getErrorMessage() {
        return this.errorMessage;
    }
    
    public void setErrorMessage(String givenError) {
        this.errorMessage.setText(givenError);
    }
    
    
}
