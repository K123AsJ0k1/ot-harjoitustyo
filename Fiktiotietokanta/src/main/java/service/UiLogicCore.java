/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import assets.Admin;
import assets.Configuration;
import uilogic.UiAbilityLogic;
import uilogic.UiUserLogic;
import uilogic.UiTransitionLogic;
import assets.User;
import assets.Parameters;
import domain.FileManagerInterface;
import java.util.List;
import uilogic.UiInstallSupportLogic;
import uilogic.UiInstallTransitionsLogic;
import uilogic.UiSupportLogic;

/**
 *
 * @author niila
 */
public class UiLogicCore {
    
    ScenePlayer scenePlayer;
    DaoPlayer daoPlayer;
    TextPlayer textPlayer;
    Configuration configuration;
      
    User user;
    Parameters parameters;
    FileManagerInterface fileManager;
    UiUserLogic uiUserLogic;
    UiAbilityLogic uiAbilityLogic;
    UiTransitionLogic uiTransitionLogic;
    UiSupportLogic uiSupportLogic;
    
    public UiLogicCore() {   
        this.scenePlayer = new ScenePlayer();
        this.textPlayer = new TextPlayer();
        configuration = new Configuration();
    }
    
    public boolean coreStart() {
        
        Boolean configRead = configuration.readConfigFile(fileManager);
        
        if (!configRead) {
            return false;
        }
        
        this.daoPlayer = new DaoPlayer(fileManager, configuration);
        
        uiAbilityLogic = new UiAbilityLogic(this.daoPlayer);
        uiUserLogic = new UiUserLogic(this.daoPlayer.getUsernameDatabase(), user, this.scenePlayer);
        uiTransitionLogic = new UiTransitionLogic(this.scenePlayer);
        uiSupportLogic = new UiSupportLogic(this.scenePlayer);
        
        return true;
    }
    
    
    public boolean privateCoreSetup() {
        Boolean daoSetup = daoPlayer.daoSetup();
        
        this.daoPlayer.usernameDatabase.addUserInformation("Private","Private");
        
        if (!daoSetup) {
            return false;
        }
        
        uiAbilityLogic = new UiAbilityLogic(this.daoPlayer);
        uiUserLogic = new UiUserLogic(this.daoPlayer.getUsernameDatabase(), user, this.scenePlayer);
        uiTransitionLogic = new UiTransitionLogic(this.scenePlayer);
        uiSupportLogic = new UiSupportLogic(this.scenePlayer);
        
        return true;
    }
    
    public boolean publicCoreSetup(List<Admin> adminList) {
        
        Boolean daoSetup = daoPlayer.daoSetup();
        
        for (Admin admin: adminList) {
            daoPlayer.getUsernameDatabase().addUserInformation(admin.getUsername(), admin.getPassword());
        }
        
        
        if (!daoSetup) {
            return false;
        }
        
        
        user = new User("","",0);
        parameters = new Parameters("","");

        uiAbilityLogic = new UiAbilityLogic(this.daoPlayer);
        uiUserLogic = new UiUserLogic(this.daoPlayer.getUsernameDatabase(), user, this.scenePlayer);
        uiTransitionLogic = new UiTransitionLogic(this.scenePlayer);
        uiSupportLogic = new UiSupportLogic(this.scenePlayer);
        
        //this.daoPlayer.usernameDatabase.addUserInformation("Tester","Tester");
        
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
