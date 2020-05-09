/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import installationscenes.DaoSettingsPrivateScene;
import installationscenes.DaoSettingsScene;
import installationscenes.UpKeepSettingsScene;
import installationscenes.WelcomeScene;
import javafx.scene.Scene;
import programscenes.AbilityMenuScene;
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

/**
 *
 * @author niila
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
    DaoSettingsScene daoSettingsScene;
    DaoSettingsPrivateScene daoSettingsPrivateScene;
    UpKeepSettingsScene upKeepSettingsScene;
    
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
        daoSettingsScene = new DaoSettingsScene();
        daoSettingsPrivateScene = new DaoSettingsPrivateScene();
        upKeepSettingsScene = new UpKeepSettingsScene();
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
    
    public DaoSettingsScene getDaoSettings() {
        return this.daoSettingsScene;
    }
    
    public DaoSettingsPrivateScene getDaoSettingsPrivateScene() {
        return this.daoSettingsPrivateScene;
    }
    
    public UpKeepSettingsScene getUpKeepSettings() {
        return this.upKeepSettingsScene;
    }
    
     
}
