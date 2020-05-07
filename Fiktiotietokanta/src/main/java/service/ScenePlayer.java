/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javafx.scene.Scene;
import scenes.AbilityMenuScene;
import scenes.AddAbilitiesScene;
import scenes.AdminMenuScene;
import scenes.ChooseAbilitiesScene;
import scenes.CreateFileScene;
import scenes.CreateProfileScene;
import scenes.LoginScene;
import scenes.MainMenuScene;
import scenes.ProfileMenuScene;
import scenes.RemoveAbilitiesScene;
import scenes.SignInScene;

/**
 *
 * @author niila
 */
public class ScenePlayer {
    
    LoginScene loginScene;
    SignInScene signInScene;
    MainMenuScene mainMenuScene;
    AbilityMenuScene abilityMenuScene;
    ProfileMenuScene profileMenuScene;
    AdminMenuScene adminMenuScene;
    CreateFileScene createFileScene;
    AddAbilitiesScene addAbilitiesScene;
    RemoveAbilitiesScene removeAbilitiesScene;
    CreateProfileScene createProfileScene;
    ChooseAbilitiesScene chooseAbilitiesScene;
    
    public ScenePlayer() {
        loginScene = new LoginScene();
        signInScene = new SignInScene();
        mainMenuScene = new MainMenuScene();
        abilityMenuScene = new AbilityMenuScene();
        profileMenuScene = new ProfileMenuScene();
        adminMenuScene = new AdminMenuScene();
        createFileScene = new CreateFileScene();
        addAbilitiesScene = new AddAbilitiesScene();
        removeAbilitiesScene = new RemoveAbilitiesScene();
        createProfileScene = new CreateProfileScene();
        chooseAbilitiesScene = new ChooseAbilitiesScene();
    }
    
    
    public LoginScene getLogin() {
        return this.loginScene;
    }
    
    public SignInScene getSignIn() {
        return this.signInScene;
    }
    
    public MainMenuScene getMainMenu() {
        return this.mainMenuScene;
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
    
     
}
