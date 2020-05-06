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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author niila
 */
public class SignInScene {
    
    Scene signInScreen;
    Button createButton;
    Button returnButton;
    Label errorMessage;
    TextField createdUsernameInput;
    PasswordField createdPasswordInput;
    
    public SignInScene() {
        GridPane layout = new GridPane();

        Label titleSignIn = new Label("Write a username and password atleast 5 letters long");
        this.createButton = new Button("Create a new account");
        this.returnButton = new Button("Return");
        this.errorMessage = new Label("");
        
        this.createdUsernameInput = new TextField();
        this.createdPasswordInput = new PasswordField();

        layout.add(titleSignIn, 0, 0);
        layout.add(this.createdUsernameInput, 0, 1);
        layout.add(this.createdPasswordInput, 0, 2);
        layout.add(this.createButton, 0, 3);
        layout.add(this.returnButton, 0, 4);
        layout.add(this.errorMessage, 0, 5);

        layout.setPrefSize(500, 500);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        this.signInScreen = new Scene(layout);
    }
    
    public void setSignInStage(Stage primaryStage) {
        primaryStage.setTitle("Signin screen");
        primaryStage.setScene(this.signInScreen);
    }
    
    public Scene getSignInScene() {
        return this.signInScreen;
    }
    
    public Button getCreateButton() {
        return this.createButton;
    }
    
    public Button getReturnButton() {
        return this.returnButton;
    }
    
    public TextField getUsernameInput() {
        return this.createdUsernameInput;
    }
    
    public PasswordField getPasswordInput() {
        return this.createdPasswordInput;
    }
    
    public Label getErrorMessage() {
        return this.errorMessage;
    }
    
    public void setErrorMessage(String givenError) {
        this.errorMessage.setText(givenError);
    }
    
    
}
