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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Sovelluksen käyttöliittymän kirjautumis scene.
 */
public class LoginScene {

    Scene loginScreen;
    Button loginButton;
    Button signInButton;
    TextField usernameInput;
    PasswordField passwordInput;
    Label errorMessage;

    /**
     * Konstruktori.
     */
    public LoginScene() {

        GridPane layout = new GridPane();

        Label titleLogin = new Label("What is your username?");
        this.loginButton = new Button("Login");
        this.signInButton = new Button("Sign in");
        this.errorMessage = new Label("");

        this.usernameInput = new TextField();
        this.passwordInput = new PasswordField();

        layout.add(titleLogin, 0, 0);
        layout.add(this.usernameInput, 0, 1);
        layout.add(this.passwordInput, 0, 2);
        layout.add(this.loginButton, 0, 3);
        layout.add(this.signInButton, 0, 4);
        layout.add(this.errorMessage, 0, 5);

        layout.setPrefSize(300, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        this.loginScreen = new Scene(layout);
    }

    public Scene getLoginScene() {
        return this.loginScreen;
    }

    public Button getLoginButton() {
        return this.loginButton;
    }

    public Button getSigninButton() {
        return this.signInButton;
    }

    public TextField getUsernameInput() {
        return this.usernameInput;
    }

    public PasswordField getPasswordInput() {
        return this.passwordInput;
    }

    public Label getErrorMessage() {
        return this.errorMessage;
    }

}
