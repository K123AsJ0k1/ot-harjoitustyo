/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javafx.stage.Stage;

/**
 *
 * @author niila
 */
public class UiTransitionLogic {

    ScenePlayer scenePlayer;

    public UiTransitionLogic(ScenePlayer scenePlayer) {
        this.scenePlayer = scenePlayer;
    }

    public void fromLoginToSignIn(Stage primaryStage) {
        scenePlayer.getLogin().getErrorMessage().setText("");
        scenePlayer.getLogin().getUsernameInput().clear();
        scenePlayer.getLogin().getPasswordInput().clear();
        primaryStage.setTitle("Sign in screen");
        primaryStage.setScene(scenePlayer.getSignIn().getSignInScene());
    }

    public void fromSignInToLogin(Stage primaryStage) {
        scenePlayer.getSignIn().getErrorMessage().setText("");
        scenePlayer.getSignIn().getUsernameInput().clear();
        scenePlayer.getSignIn().getPasswordInput().clear();
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(scenePlayer.getLogin().getLoginScene());
    }

    public void fromMainMenuToAbilityMenu(Stage primaryStage) {
        scenePlayer.getMainMenu().getErrorMessage().setText("");
        primaryStage.setTitle("Ability menu");
        primaryStage.setScene(scenePlayer.getAbilityMenu().getAbilityMenuScene());
    }

    public void fromMainMenuToProfileMenu(Stage primaryStage) {
        scenePlayer.getMainMenu().getErrorMessage().setText("");
        primaryStage.setTitle("Profile menu");
        primaryStage.setScene(scenePlayer.getProfileMenu().getProfileMenuScene());
    }

    public void fromMainMenuToAdminMenu(Stage primaryStage, String givenUsername, String givenPassword) {
        if (!(givenUsername.equals("Tester")) && !(givenPassword.equals("Tester"))) {
            scenePlayer.getMainMenu().getErrorMessage().setText("Your user doesn't have admin privileges");
            return;
        }
        primaryStage.setTitle("Admin menu");
        primaryStage.setScene(scenePlayer.getAdminMenu().getAdminMenuScene());
    }
    
    public void fromMainMenuToLogin(Stage primaryStage, User user) {
        user.setId(0);
        user.setUsername("");
        user.setPassword("");
        scenePlayer.getMainMenu().getErrorMessage().setText("");
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(scenePlayer.getLogin().getLoginScene());
    }
    
    public void fromAbilityMenuToAddAbility(Stage primaryStage) {
        primaryStage.setTitle("Add ability");
        primaryStage.setScene(scenePlayer.getAddAbilities().getAddAbilitiesScene());
    }
    
    public void fromAbilityMenuToRemoveAbility(Stage primaryStage, List<String> abilityList, UiAbilityLogic uiAbilityLogic) {
        scenePlayer.getRemoveAbilities().getTableView().getItems().addAll(uiAbilityLogic.addAbilitiesIntoList(abilityList));
        primaryStage.setTitle("Remove Abilities table");
        primaryStage.setScene(scenePlayer.getRemoveAbilities().getRemoveAbilitiesScene());
    }
    
    public void fromAbilityMenuToMainMenu(Stage primaryStage) {
        primaryStage.setTitle("Main menu");
        primaryStage.setScene(scenePlayer.getMainMenu().getMainMenuScene());
    }
    
    

}
