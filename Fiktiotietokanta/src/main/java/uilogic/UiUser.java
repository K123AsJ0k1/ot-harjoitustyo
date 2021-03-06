/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.User;
import domain.UsernameInterface;
import javafx.stage.Stage;
import mainscenes.Login;
import mainscenes.PublicMainMenu;
import mainscenes.SignIn;
import service.ScenePlayer;

/** Sovelluksen käyttäjä toiminnallisuuden hallitsija.
 */
public class UiUser {

    UsernameInterface usernameDatabase;
    User user;
    Login loginScene;
    SignIn signInScene;
    PublicMainMenu mainMenuScene;
    
    /** Konstruktori.
     * @param usernameDatabase antaa tarvitun viiteen.
     * @param user antaa tarvitun viiteen.
     * @param scenePlayer antaa tarvitun viiteen.
     */
    public UiUser(UsernameInterface usernameDatabase, User user, ScenePlayer scenePlayer) {
        this.usernameDatabase = usernameDatabase;
        this.user = user;
        this.loginScene = scenePlayer.getLogin();
        this.signInScene = scenePlayer.getSignIn();
        this.mainMenuScene = scenePlayer.getPublicMainMenu();

    }
    /** Kirjaa käyttäjän sisään.
     * @param primaryStage sovelluksen käyttöliittymän stage.
     */
    public void login(Stage primaryStage) {
        String givenUsername = loginScene.getUsernameInput().getText().trim();
        String givenPassword = loginScene.getPasswordInput().getText().trim();
        
        if (!givenUsername.matches("^[a-zA-Z]*$")) {
            loginScene.getErrorMessage().setText("Use only a-z or A-Z characters");
            return;
        }
        
        if (!givenPassword.matches("^[a-zA-Z]*$")) {
            loginScene.getErrorMessage().setText("Use only a-z or A-Z characters");
            return;
        }
        
        if (!(usernameDatabase.searchUserInformation(givenUsername))) {
            loginScene.getErrorMessage().setText("Username doesn't exist");
            return;
        }

        if (!(usernameDatabase.userPasswordCheck(givenUsername, givenPassword))) {
            loginScene.getErrorMessage().setText("Password doesn't exist");
            return;
        }
        user.setUsername(givenUsername);
        user.setPassword(givenPassword);
        user.setId(usernameDatabase.searchUsernameId(givenUsername));
        user.setPrivilage(usernameDatabase.searchUsernamePrivilage(givenUsername));
        loginScene.getUsernameInput().clear();
        loginScene.getPasswordInput().clear();
        loginScene.getErrorMessage().setText("");
        primaryStage.setTitle("Main menu");
        primaryStage.setScene(mainMenuScene.getMainMenuScene());
    }
    /** Luo uuden käyttäjän.
     * @param primaryStage sovelluksen käyttöliittymän stage.
     */
    public void createAccount(Stage primaryStage) {
        signInScene.getErrorMessage().setText("");
        String givenUsername = signInScene.getUsernameInput().getText().trim();
        String givenPassword = signInScene.getPasswordInput().getText().trim();
        
        if (!givenUsername.matches("^[a-zA-Z]*$")) {
            signInScene.getErrorMessage().setText("Use only a-z or A-Z characters");
            return;
        }
        
        if (!givenPassword.matches("^[a-zA-Z]*$")) {
            signInScene.getErrorMessage().setText("Use only a-z or A-Z characters");
            return;
        }
        
        if (givenUsername.length() < 5) {
            signInScene.getErrorMessage().setText("Given username is too short");
            return;
        }

        if (givenPassword.length() < 5) {
            signInScene.getErrorMessage().setText("Given password is too short");
            return;
        }
        
        if (givenUsername.length() > 15) {
            signInScene.getErrorMessage().setText("Given username is too long");
            return;
        }

        if (givenPassword.length() > 15) {
            signInScene.getErrorMessage().setText("Given password is too long");
            return;
        }

        if (usernameDatabase.searchUserInformation(givenUsername)) {
            signInScene.getErrorMessage().setText("Given username already exists");
            return;
        }

        if (usernameDatabase.userPasswordCheck(givenUsername, givenPassword)) {
            signInScene.getErrorMessage().setText("Given password already exists");
            return;
        }

        Boolean isAdded = usernameDatabase.addUserInformation(givenUsername, givenPassword, "User");

        if (!isAdded) {
            signInScene.getErrorMessage().setText("Error has occured");
            return;
        }

        signInScene.getErrorMessage().setText("");
        signInScene.getUsernameInput().clear();
        signInScene.getPasswordInput().clear();
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(loginScene.getLoginScene());
    }

}
