/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.Configuration;
import assets.User;
import assets.Parameters;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import service.ScenePlayer;

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
        scenePlayer.getPublicMainMenu().getErrorMessage().setText("");
        scenePlayer.getPrivateMainMenu().getErrorMessage().setText("");
        primaryStage.setTitle("Ability menu");
        primaryStage.setScene(scenePlayer.getAbilityMenu().getAbilityMenuScene());
    }

    public void fromMainMenuToProfileMenu(Stage primaryStage) {
        scenePlayer.getPublicMainMenu().getErrorMessage().setText("");
        scenePlayer.getPrivateMainMenu().getErrorMessage().setText("");
        primaryStage.setTitle("Profile menu");
        primaryStage.setScene(scenePlayer.getProfileMenu().getProfileMenuScene());
    }

    public void fromMainMenuToAdminMenu(Stage primaryStage, User user) {
        if (!(user.getPrivilage().equals("Admin"))) {
            scenePlayer.getPublicMainMenu().getErrorMessage().setText("Your user doesn't have admin privileges");
            return;
        }
        primaryStage.setTitle("Admin menu");
        primaryStage.setScene(scenePlayer.getAdminMenu().getAdminMenuScene());
    }

    public void fromMainMenuToLogin(Stage primaryStage, User user) {
        user.setId(0);
        user.setUsername("");
        user.setPassword("");
        user.setPrivilage("");
        scenePlayer.getPublicMainMenu().getErrorMessage().setText("");
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

    public void fromAbilityMenuToMainMenu(Stage primaryStage, Configuration configuration) {
        if (configuration.getMode().equals("Public")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPublicMainMenu().getMainMenuScene());
        }
        if (configuration.getMode().equals("Private")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPrivateMainMenu().getMainMenuScene());
        }
    }

    public void fromProfileMenuToCreateProfile(Stage primaryStage) {
        primaryStage.setTitle("Profile creator");
        primaryStage.setScene(scenePlayer.getCreateProfile().getCreateProfileScene());
    }

    public void fromProfileMenuToMainMenu(Stage primaryStage, Configuration configuration) {
        if (configuration.getMode().equals("Public")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPublicMainMenu().getMainMenuScene());
        }
        if (configuration.getMode().equals("Private")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPrivateMainMenu().getMainMenuScene());
        }
    }

    public void fromProfileMenuToCreateFile(Stage primaryStage) {
        primaryStage.setTitle("Save profile as a file menu");
        primaryStage.setScene(scenePlayer.getCreateFile().getCreateFileScene());
    }

    public void fromCreateFileToProfileMenu(Stage primaryStage) {
        primaryStage.setTitle("Profile menu");
        primaryStage.setScene(scenePlayer.getProfileMenu().getProfileMenuScene());
    }

    public void fromAdminMenuToMainMenu(Stage primaryStage, Configuration configuration) {
        if (configuration.getMode().equals("Public")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPublicMainMenu().getMainMenuScene());
        }
        if (configuration.getMode().equals("Private")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPrivateMainMenu().getMainMenuScene());
        }
    }

    public void fromAddAbilitiesToAbilityMenu(Stage primaryStage) {
        scenePlayer.getAddAbilities().getErrorMessage().setText("");
        primaryStage.setTitle("Ability menu");
        primaryStage.setScene(scenePlayer.getAbilityMenu().getAbilityMenuScene());
    }

    public void fromRemoveAbilityToAbilityMenu(Stage primaryStage) {
        scenePlayer.getRemoveAbilities().getTableView().getItems().clear();
        primaryStage.setTitle("Ability menu");
        primaryStage.setScene(scenePlayer.getAbilityMenu().getAbilityMenuScene());
    }

    public void fromCreateProfileToProfileMenuWithSave(Stage primaryStage) {
        scenePlayer.getCreateFile().getTextPresentation().setText(scenePlayer.getCreateProfile().getProfileEditor().getText());
        primaryStage.setTitle("Profile menu");
        primaryStage.setScene(scenePlayer.getProfileMenu().getProfileMenuScene());
    }

    public void fromCreateProfileToProfileMenuWithOutSave(Stage primaryStage) {
        scenePlayer.getCreateProfile().getProfileEditor().clear();
        primaryStage.setTitle("Profile menu");
        primaryStage.setScene(scenePlayer.getProfileMenu().getProfileMenuScene());
    }

    public void fromCreateProfileToChooseAbility(Stage primaryStage, List<String> abilityList, UiAbilityLogic uiAbilityLogic) {
        scenePlayer.getChooseAbilities().getTableView().getItems().addAll(uiAbilityLogic.addAbilitiesIntoList(abilityList));
        primaryStage.setTitle("Choose Abilities table");
        primaryStage.setScene(scenePlayer.getChooseAbilities().getChoosenAbilitiesScene());
    }

    public void fromChoosenAbilityToCreateProfileReturn(Stage primaryStage) {
        scenePlayer.getChooseAbilities().getTableView().getItems().clear();
        primaryStage.setTitle("Profile creator");
        primaryStage.setScene(scenePlayer.getCreateProfile().getCreateProfileScene());
    }

    public void fromChoosenAbilityToCreateProfileChoosenAbility(Stage primaryStage, Parameters parameters, UiAbilityLogic uiAbilityLogic) {
        if (scenePlayer.getChooseAbilities().getSelectionModel().getSelectedItems().size() > 0) {
            ObservableList selectedItems = scenePlayer.getChooseAbilities().getSelectionModel().getSelectedItems();
            String givenString = uiAbilityLogic.chooseAbility(selectedItems);
            parameters.setChoosenAbility(givenString);
            parameters.setLeftOverParameters(givenString);
            scenePlayer.getCreateProfile().getLeftParameterItem().setText("Ability parameters left:" + givenString);
            scenePlayer.getChooseAbilities().getTableView().getItems().clear();
            primaryStage.setTitle("Profile creator");
            primaryStage.setScene(scenePlayer.getCreateProfile().getCreateProfileScene());
        }
    }
    
    public void fromAdminMenuToUserTable(Stage primaryStage, List<String> userList, UiUserTableLogic uiUserTableLogic) {
        System.out.println(userList.toString());
        scenePlayer.getUserDatabaseTable().getTableView().getItems().addAll(uiUserTableLogic.addUsersIntoAlist(userList));
        primaryStage.setTitle("Username parameters as a list");
        primaryStage.setScene(scenePlayer.getUserDatabaseTable().getUserDatabaseTableScene());
    }
    
    public void fromUserTableToAdminMenu(Stage primaryStage) {
        scenePlayer.getUserDatabaseTable().getTableView().getItems().clear();
        primaryStage.setTitle("Admin menu");
        primaryStage.setScene(scenePlayer.getAdminMenu().getAdminMenuScene());
    }

}
