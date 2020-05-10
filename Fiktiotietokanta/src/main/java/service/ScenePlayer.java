/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import installscenes.PrivateDaoSettings;
import installscenes.PublicDaoSettings;
import installscenes.AdminSettings;
import installscenes.WelcomeScene;
import mainscenes.AbilityMenu;
import mainscenes.ParametersTable;
import mainscenes.AddAbilities;
import mainscenes.AdminMenu;
import mainscenes.ChooseAbilities;
import mainscenes.CreateFile;
import mainscenes.CreateProfile;
import mainscenes.Login;
import mainscenes.PrivateMainMenu;
import mainscenes.PublicMainMenu;
import mainscenes.ProfileMenu;
import mainscenes.RemoveAbilities;
import mainscenes.SignIn;
import mainscenes.UserDatabaseTable;

/**
 * Sovelluksen käyttöliittymän scenejen toiminnan hallitsija.
 */
public class ScenePlayer {

    Login loginScene;
    SignIn signInScene;
    PublicMainMenu publicMainMenuScene;
    PrivateMainMenu privateMainMenuScene;
    AbilityMenu abilityMenuScene;
    ProfileMenu profileMenuScene;
    AdminMenu adminMenuScene;
    CreateFile createFileScene;
    AddAbilities addAbilitiesScene;
    RemoveAbilities removeAbilitiesScene;
    CreateProfile createProfileScene;
    ChooseAbilities chooseAbilitiesScene;
    WelcomeScene welcomeScene;
    PublicDaoSettings publicDaoSettingsScene;
    PrivateDaoSettings privateDaoSettingsScene;
    AdminSettings administratorSettingsScene;
    UserDatabaseTable userDatabaseTableScene;
    ParametersTable abilityParametersTableScene;

    /**
     * Konstruktori.
     */
    public ScenePlayer() {
        loginScene = new Login();
        signInScene = new SignIn();
        publicMainMenuScene = new PublicMainMenu();
        privateMainMenuScene = new PrivateMainMenu();
        abilityMenuScene = new AbilityMenu();
        profileMenuScene = new ProfileMenu();
        adminMenuScene = new AdminMenu();
        createFileScene = new CreateFile();
        addAbilitiesScene = new AddAbilities();
        removeAbilitiesScene = new RemoveAbilities();
        createProfileScene = new CreateProfile();
        chooseAbilitiesScene = new ChooseAbilities();
        welcomeScene = new WelcomeScene();
        publicDaoSettingsScene = new PublicDaoSettings();
        privateDaoSettingsScene = new PrivateDaoSettings();
        administratorSettingsScene = new AdminSettings();
        userDatabaseTableScene = new UserDatabaseTable();
        abilityParametersTableScene = new ParametersTable();
    }

    public Login getLogin() {
        return this.loginScene;
    }

    public SignIn getSignIn() {
        return this.signInScene;
    }

    public PublicMainMenu getPublicMainMenu() {
        return this.publicMainMenuScene;
    }

    public PrivateMainMenu getPrivateMainMenu() {
        return this.privateMainMenuScene;
    }

    public AbilityMenu getAbilityMenu() {
        return this.abilityMenuScene;
    }

    public ProfileMenu getProfileMenu() {
        return this.profileMenuScene;
    }

    public AdminMenu getAdminMenu() {
        return this.adminMenuScene;
    }

    public CreateFile getCreateFile() {
        return this.createFileScene;
    }

    public AddAbilities getAddAbilities() {
        return this.addAbilitiesScene;
    }

    public RemoveAbilities getRemoveAbilities() {
        return this.removeAbilitiesScene;
    }

    public CreateProfile getCreateProfile() {
        return this.createProfileScene;
    }

    public ChooseAbilities getChooseAbilities() {
        return this.chooseAbilitiesScene;
    }

    public WelcomeScene getWelcome() {
        return this.welcomeScene;
    }

    public PublicDaoSettings getPublicDaoSettings() {
        return this.publicDaoSettingsScene;
    }

    public PrivateDaoSettings getPrivateDaoSettings() {
        return this.privateDaoSettingsScene;
    }

    public AdminSettings getAdministratorSettings() {
        return this.administratorSettingsScene;
    }

    public UserDatabaseTable getUserDatabaseTable() {
        return this.userDatabaseTableScene;
    }

    public ParametersTable getAbilityParamtersTable() {
        return this.abilityParametersTableScene;
    }

}
