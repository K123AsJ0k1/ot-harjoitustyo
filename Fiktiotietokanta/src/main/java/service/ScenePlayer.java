/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import installationscenes.PrivateDaoSettingsScene;
import installationscenes.PublicDaoSettingsScene;
import installationscenes.AdministratorSettingsScene;
import installationscenes.WelcomeScene;
import programscenes.AbilityMenuScene;
import programscenes.AbilityParametersTableScene;
import programscenes.AddAbilitiesScene;
import programscenes.AdminMenuScene;
import programscenes.ChooseAbilitiesScene;
import programscenes.CreateFileScene;
import programscenes.CreateProfileScene;
import programscenes.LoginScene;
import programscenes.PrivateMainMenuScene;
import programscenes.PublicMainMenuScene;
import programscenes.ProfileMenuScene;
import programscenes.RemoveAbilitiesScene;
import programscenes.SignInScene;
import programscenes.UserDatabaseTableScene;

/**
 * Sovelluksen käyttöliittymän scenejen toiminnan hallitsija.
 */
public class ScenePlayer {

    LoginScene loginScene;
    SignInScene signInScene;
    PublicMainMenuScene publicMainMenuScene;
    PrivateMainMenuScene privateMainMenuScene;
    AbilityMenuScene abilityMenuScene;
    ProfileMenuScene profileMenuScene;
    AdminMenuScene adminMenuScene;
    CreateFileScene createFileScene;
    AddAbilitiesScene addAbilitiesScene;
    RemoveAbilitiesScene removeAbilitiesScene;
    CreateProfileScene createProfileScene;
    ChooseAbilitiesScene chooseAbilitiesScene;
    WelcomeScene welcomeScene;
    PublicDaoSettingsScene publicDaoSettingsScene;
    PrivateDaoSettingsScene privateDaoSettingsScene;
    AdministratorSettingsScene administratorSettingsScene;
    UserDatabaseTableScene userDatabaseTableScene;
    AbilityParametersTableScene abilityParametersTableScene;

    /**
     * Konstruktori.
     */
    public ScenePlayer() {
        loginScene = new LoginScene();
        signInScene = new SignInScene();
        publicMainMenuScene = new PublicMainMenuScene();
        privateMainMenuScene = new PrivateMainMenuScene();
        abilityMenuScene = new AbilityMenuScene();
        profileMenuScene = new ProfileMenuScene();
        adminMenuScene = new AdminMenuScene();
        createFileScene = new CreateFileScene();
        addAbilitiesScene = new AddAbilitiesScene();
        removeAbilitiesScene = new RemoveAbilitiesScene();
        createProfileScene = new CreateProfileScene();
        chooseAbilitiesScene = new ChooseAbilitiesScene();
        welcomeScene = new WelcomeScene();
        publicDaoSettingsScene = new PublicDaoSettingsScene();
        privateDaoSettingsScene = new PrivateDaoSettingsScene();
        administratorSettingsScene = new AdministratorSettingsScene();
        userDatabaseTableScene = new UserDatabaseTableScene();
        abilityParametersTableScene = new AbilityParametersTableScene();
    }

    public LoginScene getLogin() {
        return this.loginScene;
    }

    public SignInScene getSignIn() {
        return this.signInScene;
    }

    public PublicMainMenuScene getPublicMainMenu() {
        return this.publicMainMenuScene;
    }

    public PrivateMainMenuScene getPrivateMainMenu() {
        return this.privateMainMenuScene;
    }

    public AbilityMenuScene getAbilityMenu() {
        return this.abilityMenuScene;
    }

    public ProfileMenuScene getProfileMenu() {
        return this.profileMenuScene;
    }

    public AdminMenuScene getAdminMenu() {
        return this.adminMenuScene;
    }

    public CreateFileScene getCreateFile() {
        return this.createFileScene;
    }

    public AddAbilitiesScene getAddAbilities() {
        return this.addAbilitiesScene;
    }

    public RemoveAbilitiesScene getRemoveAbilities() {
        return this.removeAbilitiesScene;
    }

    public CreateProfileScene getCreateProfile() {
        return this.createProfileScene;
    }

    public ChooseAbilitiesScene getChooseAbilities() {
        return this.chooseAbilitiesScene;
    }

    public WelcomeScene getWelcome() {
        return this.welcomeScene;
    }

    public PublicDaoSettingsScene getPublicDaoSettings() {
        return this.publicDaoSettingsScene;
    }

    public PrivateDaoSettingsScene getPrivateDaoSettings() {
        return this.privateDaoSettingsScene;
    }

    public AdministratorSettingsScene getAdministratorSettings() {
        return this.administratorSettingsScene;
    }

    public UserDatabaseTableScene getUserDatabaseTable() {
        return this.userDatabaseTableScene;
    }

    public AbilityParametersTableScene getAbilityParamtersTable() {
        return this.abilityParametersTableScene;
    }

}
