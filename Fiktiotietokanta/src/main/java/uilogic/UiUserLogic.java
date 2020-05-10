/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.User;
import dao.UsernameDatabase;
import domain.UsernameInterface;
import javafx.scene.Scene;
import javafx.stage.Stage;
import programscenes.LoginScene;
import programscenes.PublicMainMenuScene;
import programscenes.SignInScene;
import service.ScenePlayer;

/**
 *
 * @author niila
 */
public class UiUserLogic {
          
    UsernameInterface usernameDatabase;
    User user;
    LoginScene loginScene;
    SignInScene signInScene;
    PublicMainMenuScene mainMenuScene;

    public UiUserLogic(UsernameInterface usernameDatabase, User user,ScenePlayer scenePlayer) {  
        this.usernameDatabase = usernameDatabase;
        this.user = user;
        this.loginScene = scenePlayer.getLogin();
        this.signInScene = scenePlayer.getSignIn();
        this.mainMenuScene = scenePlayer.getPublicMainMenu(); 
        
    }
    
    public void login(Stage primaryStage) {
            String givenUsername = loginScene.getUsernameInput().getText().trim();
            String givenPassword = loginScene.getPasswordInput().getText().trim();
            
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
    
    public void createAccount(Stage primaryStage) {
            signInScene.getErrorMessage().setText("");
            String givenUsername = signInScene.getUsernameInput().getText().trim();
            String givenPassword = signInScene.getPasswordInput().getText().trim();
            if (givenUsername.length() < 5) {
                signInScene.getErrorMessage().setText("Given username is too short");
                return;
            }
            
            if (givenPassword.length() < 5) {
                signInScene.getErrorMessage().setText("Given password is too short");
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
            
            Boolean isAdded = usernameDatabase.addUserInformation(givenUsername,givenPassword, "User");

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
