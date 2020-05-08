/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import uilogic.UiAbilityLogic;
import uilogic.UiUserLogic;
import uilogic.UiTransitionLogic;
import assets.User;
import assets.Parameters;
import dao.AbilityDatabase;
import dao.ClassDatabase;
import dao.DescriptionDatabase;
import dao.NameDatabase;
import dao.RealityDatabase;
import dao.RequrimentDatabase;
import dao.UsernameDatabase;
import domain.DatabaseInterface;
import domain.FileWriterInterface;
import domain.TextRefineryInterface;
import domain.UsernameInterface;
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
import scenes.Test;
import textlogic.TextRefinery;
import uilogic.UiSupportLogic;

/**
 *
 * @author niila
 */
public class UiLogicCore {
    
    ScenePlayer scenePlayer;
    DaoPlayer daoPlayer;
    TextPlayer textPlayer;
      
    User user;
    Parameters parameters;
    UiUserLogic uiUserLogic;
    UiAbilityLogic uiAbilityLogic;
    UiTransitionLogic uiTransitionLogic;
    UiSupportLogic uiSupportLogic;
    
    public UiLogicCore() {
        
        this.scenePlayer = new ScenePlayer();
        this.daoPlayer = new DaoPlayer();
        this.textPlayer = new TextPlayer();
           
    }
    
    public boolean coreSetup() {
        
        Boolean daoSetup = daoPlayer.daoSetup();
        
        if (!daoSetup) {
            return false;
        }
        
        
        user = new User("","",0);
        parameters = new Parameters("","");
        
        uiAbilityLogic = new UiAbilityLogic(this.daoPlayer);
        uiUserLogic = new UiUserLogic(this.daoPlayer.getUsernameDatabase(), user, this.scenePlayer);
        uiTransitionLogic = new UiTransitionLogic(this.scenePlayer);
        uiSupportLogic = new UiSupportLogic(this.scenePlayer);
        this.daoPlayer.usernameDatabase.addUserInformation("Tester","Tester");
        
        return true;
    }
    
    public boolean coreShutDown() {
        
        Boolean daoShutDown = daoPlayer.daoShutDown();
        
        if (!daoShutDown) {
            return false;
        }
        
        return true;
    }
    
    
    public ScenePlayer getScenePlayer() {
        return this.scenePlayer;
    }
    
    public DaoPlayer getDaoPlayer() {
        return this.daoPlayer;
    }
    
    public TextPlayer getTextPlayer() {
        return this.textPlayer;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public Parameters getParameters() {
        return this.parameters;
    }
    
    public UiUserLogic getUiUserLogic() {
        return this.uiUserLogic;
    }
    
    public UiAbilityLogic getUiAbilityLogic() {
        return this.uiAbilityLogic;
    }
    
    public UiTransitionLogic getUiTransitionLogic() {
        return this.uiTransitionLogic;
    }
    
    public UiSupportLogic getUiSupportLogic() {
        return this.uiSupportLogic;
    }
    
    
}
