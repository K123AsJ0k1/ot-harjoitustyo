/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

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
public class ProfileMenuScene {
    
    Scene profileMenuScreen;
    Button createProfileButton;
    Button createFileButton;
    Button resetProfileButton;
    Button returnButton;
    
    public ProfileMenuScene() {
        GridPane layout = new GridPane();

        Label titleProfileMenu = new Label("What do you want to do?");
        this.createProfileButton = new Button("Create a new profile");
        this.createFileButton = new Button("Create a file from profile");
        this.resetProfileButton = new Button("Reset current profile");
        this.returnButton = new Button("Return to the main menu");

        layout.add(titleProfileMenu, 0, 0);
        layout.add(this.createProfileButton, 0, 1);
        layout.add(this.createFileButton, 0, 2);
        layout.add(this.resetProfileButton, 0, 3);
        layout.add(this.returnButton, 0, 4);

        layout.setPrefSize(300, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        this.profileMenuScreen = new Scene(layout);
    }
    
    public void setProfileMenuStage(Stage primaryStage) {
        primaryStage.setTitle("Profile menu");
        primaryStage.setScene(this.profileMenuScreen);
    }
    
    public Scene getProfileMenuScene() {
        return this.profileMenuScreen;
    }
    
    public Button getCreateProfileButton() {
        return this.createProfileButton;
    }
    
    public Button getCreateFileButton() {
        return this.createFileButton;
    }
    
    public Button getResetProfileButton() {
        return this.resetProfileButton;
    }
   
    public Button getReturnButton() {
        return this.returnButton;
    }
    
    
}
