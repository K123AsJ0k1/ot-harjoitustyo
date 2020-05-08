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
      
    User user;
    Parameters parameters;
    UiInstallSupportLogic uiInstallSupportLogic;
    UiInstallTransitionsLogic uiInstallTransitionsLogic;
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
        uiInstallSupportLogic = new UiInstallSupportLogic(this.scenePlayer);
        uiInstallTransitionsLogic = new UiInstallTransitionsLogic(this.scenePlayer);
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
    
    public UiInstallSupportLogic getUiInstallSupportLogic() {
        return this.uiInstallSupportLogic;
    }
    
    public UiInstallTransitionsLogic getUiInstallTransitionsLogic() {
        return this.uiInstallTransitionsLogic;
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
