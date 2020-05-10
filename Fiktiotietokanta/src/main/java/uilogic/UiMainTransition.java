/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import filelogic.FileConfig;
import assets.User;
import assets.Parameters;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import service.ScenePlayer;

/**
 * Sovelluksen käyttöliittymän siirtymisen toimien hallitsija.
 */
public class UiMainTransition {

    ScenePlayer scenePlayer;

    /**
     * Konstruktori.
     * @param scenePlayer antaa tarvitun viiteen.
     */
    public UiMainTransition(ScenePlayer scenePlayer) {
        this.scenePlayer = scenePlayer;
    }
    /**
     * Mahdollistaa siirtymisen kirjautumisesta uuden käyttään luomiseen.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromLoginToSignIn(Stage primaryStage) {
        scenePlayer.getLogin().getErrorMessage().setText("");
        scenePlayer.getLogin().getUsernameInput().clear();
        scenePlayer.getLogin().getPasswordInput().clear();
        primaryStage.setTitle("Sign in screen");
        primaryStage.setScene(scenePlayer.getSignIn().getSignInScene());
    }
    /**
     * Mahdollistaa siirtymisen uuden käyttäjän luomisesta kirjautumiseen.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromSignInToLogin(Stage primaryStage) {
        scenePlayer.getSignIn().getErrorMessage().setText("");
        scenePlayer.getSignIn().getUsernameInput().clear();
        scenePlayer.getSignIn().getPasswordInput().clear();
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(scenePlayer.getLogin().getLoginScene());
    }
    /**
     * Mahdollistaa siirtymisen päävalikosta ominaisuus valikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromMainMenuToAbilityMenu(Stage primaryStage) {
        scenePlayer.getPublicMainMenu().getErrorMessage().setText("");
        scenePlayer.getPrivateMainMenu().getErrorMessage().setText("");
        primaryStage.setTitle("Ability menu");
        primaryStage.setScene(scenePlayer.getAbilityMenu().getAbilityMenuScene());
    }
    /**
     * Mahdollistaa siirtymisen päävalikosta profiili valikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromMainMenuToProfileMenu(Stage primaryStage) {
        scenePlayer.getPublicMainMenu().getErrorMessage().setText("");
        scenePlayer.getPrivateMainMenu().getErrorMessage().setText("");
        primaryStage.setTitle("Profile menu");
        primaryStage.setScene(scenePlayer.getProfileMenu().getProfileMenuScene());
    }
    /**
     * Mahdollistaa siirtymisen päävalikosta pääkäyttäjä valikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     * @param user antaa käyttäjän tiedot.
     */
    public void fromMainMenuToAdminMenu(Stage primaryStage, User user) {
        if (!(user.getPrivilage().equals("Admin"))) {
            scenePlayer.getPublicMainMenu().getErrorMessage().setText("Your user doesn't have admin privileges");
            return;
        }
        primaryStage.setTitle("Admin menu");
        primaryStage.setScene(scenePlayer.getAdminMenu().getAdminMenuScene());
    }
    /**
     * Mahdollistaa siirtymisen päävalikosta kirjautumiseen.
     * @param primaryStage käyttöliittymän antama stage.
     * @param user antaa käyttäjän tiedot.
     */
    public void fromMainMenuToLogin(Stage primaryStage, User user) {
        user.setId(0);
        user.setUsername("");
        user.setPassword("");
        user.setPrivilage("");
        scenePlayer.getPublicMainMenu().getErrorMessage().setText("");
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(scenePlayer.getLogin().getLoginScene());
    }
    /**
     * Mahdollistaa siirtymisen ominaisuus valikosta lisää omainaisuuteen.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromAbilityMenuToAddAbility(Stage primaryStage) {
        primaryStage.setTitle("Add ability");
        primaryStage.setScene(scenePlayer.getAddAbilities().getAddAbilitiesScene());
    }
    /**
     * Mahdollistaa siirtymisen ominaisuus valikosta poista ominaisuuteen.
     * @param primaryStage käyttöliittymän antama stage.
     * @param abilityList antaa ominaisuus listan.
     * @param uiAbilityLogic antaa tarvitun viiteen.
     */
    public void fromAbilityMenuToRemoveAbility(Stage primaryStage, List<String> abilityList, UiAbility uiAbilityLogic) {
        scenePlayer.getRemoveAbilities().getTableView().getItems().addAll(uiAbilityLogic.addAbilitiesIntoList(abilityList));
        primaryStage.setTitle("Remove Abilities table");
        primaryStage.setScene(scenePlayer.getRemoveAbilities().getRemoveAbilitiesScene());
    }
    /**
     * Mahdollistaa siirtymisen ominaisuus valikosta päävalikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     * @param configuration antaa sovelluksen asennuksen.
     */
    public void fromAbilityMenuToMainMenu(Stage primaryStage, FileConfig configuration) {
        if (configuration.getMode().equals("Public")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPublicMainMenu().getMainMenuScene());
        }
        if (configuration.getMode().equals("Private")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPrivateMainMenu().getMainMenuScene());
        }
    }
    /**
     * Mahdollistaa siirtymisen ominaisuus valikosta päävalikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromProfileMenuToCreateProfile(Stage primaryStage) {
        primaryStage.setTitle("Profile creator");
        primaryStage.setScene(scenePlayer.getCreateProfile().getCreateProfileScene());
    }
    /**
     * Mahdollistaa siirtymisen profiili valikosta päävalikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     * @param configuration antaa sovelluksen asennuksen.
     */
    public void fromProfileMenuToMainMenu(Stage primaryStage, FileConfig configuration) {
        if (configuration.getMode().equals("Public")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPublicMainMenu().getMainMenuScene());
        }
        if (configuration.getMode().equals("Private")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPrivateMainMenu().getMainMenuScene());
        }
    }
    /**
     * Mahdollistaa siirtymisen profiili valikosta luo tiedostoon.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromProfileMenuToCreateFile(Stage primaryStage) {
        primaryStage.setTitle("Save profile as a file menu");
        primaryStage.setScene(scenePlayer.getCreateFile().getCreateFileScene());
    }
    /**
     * Mahdollistaa siirtymisen luo tiedostosta profiili valikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromCreateFileToProfileMenu(Stage primaryStage) {
        primaryStage.setTitle("Profile menu");
        primaryStage.setScene(scenePlayer.getProfileMenu().getProfileMenuScene());
    }
    /**
     * Mahdollistaa siirtymisen pääkäyttäjä valikosta päävalikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     * @param configuration antaa sovelluksen asennuksen.
     */
    public void fromAdminMenuToMainMenu(Stage primaryStage, FileConfig configuration) {
        if (configuration.getMode().equals("Public")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPublicMainMenu().getMainMenuScene());
        }
        if (configuration.getMode().equals("Private")) {
            primaryStage.setTitle("Main menu");
            primaryStage.setScene(scenePlayer.getPrivateMainMenu().getMainMenuScene());
        }
    }
    /**
     * Mahdollistaa siirtymisen lisää ominaisuudesta ominaisuus valikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromAddAbilitiesToAbilityMenu(Stage primaryStage) {
        scenePlayer.getAddAbilities().getErrorMessage().setText("");
        primaryStage.setTitle("Ability menu");
        primaryStage.setScene(scenePlayer.getAbilityMenu().getAbilityMenuScene());
    }
    /**
     * Mahdollistaa siirtymisen poista ominaisuudesta ominaisuus valikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromRemoveAbilityToAbilityMenu(Stage primaryStage) {
        scenePlayer.getRemoveAbilities().getTableView().getItems().clear();
        primaryStage.setTitle("Ability menu");
        primaryStage.setScene(scenePlayer.getAbilityMenu().getAbilityMenuScene());
    }
    /**
     * Mahdollistaa siirtymisen luo profiilista profiili valikkoon tallentamatta.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromCreateProfileToProfileMenuWithSave(Stage primaryStage) {
        scenePlayer.getCreateFile().getTextPresentation().setText(scenePlayer.getCreateProfile().getProfileEditor().getText());
        primaryStage.setTitle("Profile menu");
        primaryStage.setScene(scenePlayer.getProfileMenu().getProfileMenuScene());
    }
    /**
     * Mahdollistaa siirtymisen luo profiilista profiili valikkoon tallennuksella.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromCreateProfileToProfileMenuWithOutSave(Stage primaryStage) {
        scenePlayer.getCreateProfile().getProfileEditor().clear();
        primaryStage.setTitle("Profile menu");
        primaryStage.setScene(scenePlayer.getProfileMenu().getProfileMenuScene());
    }
    /**
     * Mahdollistaa siirtymisen luo profiilista profiili valitse ominaisuuteen.
     * @param primaryStage käyttöliittymän antama stage.
     * @param abilityList hakee ja antaa tarvitun ominaisuus listan.
     * @param uiAbilityLogic antaa tarvitun viittauksen.
     */
    public void fromCreateProfileToChooseAbility(Stage primaryStage, List<String> abilityList, UiAbility uiAbilityLogic) {
        scenePlayer.getChooseAbilities().getTableView().getItems().addAll(uiAbilityLogic.addAbilitiesIntoList(abilityList));
        primaryStage.setTitle("Choose Abilities table");
        primaryStage.setScene(scenePlayer.getChooseAbilities().getChoosenAbilitiesScene());
    }
    /**
     * Mahdollistaa siirtymisen valitse ominaisuudesta luo profiiliin palaamisen kautta.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromChoosenAbilityToCreateProfileReturn(Stage primaryStage) {
        scenePlayer.getChooseAbilities().getTableView().getItems().clear();
        primaryStage.setTitle("Profile creator");
        primaryStage.setScene(scenePlayer.getCreateProfile().getCreateProfileScene());
    }
    /**
     * Mahdollistaa siirtymisen valitse ominaisuudesta luo profiiliin valitsemisen kautta.
     * @param primaryStage käyttöliittymän antama stage.
     * @param parameters antaa parametrien tiedot.
     * @param uiAbilityLogic antaa tarvitun viiteen.
     */
    public void fromChoosenAbilityToCreateProfileChoosenAbility(Stage primaryStage, Parameters parameters, UiAbility uiAbilityLogic) {
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
    /**
     * Mahdollistaa siirtymisen pääkäyttäjä valikosta käyttäjä taulukkoon.
     * @param primaryStage käyttöliittymän antama stage.
     * @param userList hakee ja antaa tarvitun käyttäjä listan.
     * @param uiUserTableLogic antaa tarvitun viiteen.
     */
    public void fromAdminMenuToUserTable(Stage primaryStage, List<String> userList, UiUserTable uiUserTableLogic) {
        scenePlayer.getUserDatabaseTable().getTableView().getItems().addAll(uiUserTableLogic.addUsersIntoAlist(userList));
        primaryStage.setTitle("Username parameters as a list");
        primaryStage.setScene(scenePlayer.getUserDatabaseTable().getUserDatabaseTableScene());
    }
    /**
     * Mahdollistaa siirtymisen käyttäjä taulukosta pääkäyttäjä valikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromUserTableToAdminMenu(Stage primaryStage) {
        scenePlayer.getUserDatabaseTable().getTableView().getItems().clear();
        primaryStage.setTitle("Admin menu");
        primaryStage.setScene(scenePlayer.getAdminMenu().getAdminMenuScene());
    }
    /**
     * Mahdollistaa siirtymisen pääkäyttäjä valikosta parametri tauluihin.
     * @param primaryStage käyttöliittymän antama stage.
     * @param classList hakee ja antaa tarvitun luokka listan.
     * @param nameList hakee ja antaa tarvitun nimi listan.
     * @param descriptionList hakee ja antaa tarvitun selite listan.
     * @param realityList hakee ja antaa tarvitun todellisuus listan.
     * @param requrimentList hakee ja antaa tarvitun vaatimus listan.
     * @param uiParametersTableLogic antaa tarvitun viiteen.
     */
    public void fromAdminMenuToParameterTable(Stage primaryStage, List<String> classList, List<String> nameList, List<String> descriptionList, List<String> requrimentList, List<String> realityList, UiParametersTable uiParametersTableLogic) {
        scenePlayer.getAbilityParamtersTable().getClassTableView().getItems().addAll(uiParametersTableLogic.addClassesIntoAlist(classList));
        scenePlayer.getAbilityParamtersTable().getNameTableView().getItems().addAll(uiParametersTableLogic.addNamesIntoAlist(nameList));
        scenePlayer.getAbilityParamtersTable().getDescriptionTableView().getItems().addAll(uiParametersTableLogic.addDescriptionIntoAlist(descriptionList));
        scenePlayer.getAbilityParamtersTable().getRequrimentTableView().getItems().addAll(uiParametersTableLogic.addRequrimentIntoAlist(requrimentList));
        scenePlayer.getAbilityParamtersTable().getRealityTableView().getItems().addAll(uiParametersTableLogic.addRealityIntoAlist(realityList));
        primaryStage.setTitle("Ability parameters as a list");
        primaryStage.setScene(scenePlayer.getAbilityParamtersTable().getUserDatabaseTableScene());
    }
    /**
     * Mahdollistaa siirtymisen parametri tauluista pääkäyttäjä valikkoon.
     * @param primaryStage käyttöliittymän antama stage.
     */
    public void fromParametersTableToAdminMenu(Stage primaryStage) {
        scenePlayer.getAbilityParamtersTable().getClassTableView().getItems().clear();
        scenePlayer.getAbilityParamtersTable().getNameTableView().getItems().clear();
        scenePlayer.getAbilityParamtersTable().getDescriptionTableView().getItems().clear();
        scenePlayer.getAbilityParamtersTable().getRequrimentTableView().getItems().clear();
        scenePlayer.getAbilityParamtersTable().getRealityTableView().getItems().clear();
        primaryStage.setTitle("Admin menu");
        primaryStage.setScene(scenePlayer.getAdminMenu().getAdminMenuScene());
    }

}
