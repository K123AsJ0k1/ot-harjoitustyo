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
import filelogic.FileManager;
import java.util.List;
import uilogic.UiParametersTableLogic;
import uilogic.UiSupportLogic;
import uilogic.UiUserTableLogic;
/**
 * Sovelluksen käyttöliittymän toiminnan ydin.
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
    UiUserTableLogic uiUserTableLogic;
    UiParametersTableLogic uiParamtersTableLogic;
    UiTransitionLogic uiTransitionLogic;
    UiSupportLogic uiSupportLogic;
    /** Konstruktori.
     * @param scenePlayer peritty ScenePlayer.
     */
    public UiLogicCore(ScenePlayer scenePlayer) {
        this.scenePlayer = scenePlayer;
        this.textPlayer = new TextPlayer();
        fileManager = new FileManager();
        configuration = new Configuration();
    }
    
    /** Käynnistää ytimen.
     * @return palauttaa true, jos käynnistäminen onnistu ja false, jos ei.
     */
    public boolean coreStart() {

        Boolean configRead = configuration.readConfigFile(fileManager);

        if (!configRead) {
            return false;
        }

        this.daoPlayer = new DaoPlayer(fileManager, configuration);
        if (configuration.getMode().equals("Public")) {
            user = new User("", "", "", 0);
            parameters = new Parameters("", "");
        }

        if (configuration.getMode().equals("Private")) {
            user = new User("", "", "", 0);
            user.setUsername("Private");
            user.setPassword("Private");
            user.setId(this.daoPlayer.usernameDatabase.searchUsernameId("Private"));
            user.setPrivilage(this.daoPlayer.usernameDatabase.searchUsernamePrivilage("Private"));
            parameters = new Parameters("", "");
        }
        uiAbilityLogic = new UiAbilityLogic(this.daoPlayer);
        uiUserTableLogic = new UiUserTableLogic(this.daoPlayer);
        uiParamtersTableLogic = new UiParametersTableLogic(this.daoPlayer);
        uiUserLogic = new UiUserLogic(this.daoPlayer.getUsernameDatabase(), user, this.scenePlayer);
        uiTransitionLogic = new UiTransitionLogic(this.scenePlayer);
        uiSupportLogic = new UiSupportLogic(this.scenePlayer);
        return true;
    }
    
    /** Asettaa ytimen yksityiseen tilaan.
     * @return palauttaa true, jos asetus onnistu ja false, jos ei.
     */
    public boolean privateCoreSetup() {
        Boolean configRead = configuration.readConfigFile(fileManager);

        if (!configRead) {
            return false;
        }

        this.daoPlayer = new DaoPlayer(fileManager, configuration);

        Boolean daoSetup = daoPlayer.daoSetup();

        this.daoPlayer.usernameDatabase.addUserInformation("Private", "Private", "Admin");

        if (!daoSetup) {
            return false;
        }

        user = new User("", "", "", 0);
        user.setUsername("Private");
        user.setPassword("Private");
        user.setId(this.daoPlayer.usernameDatabase.searchUsernameId("Private"));
        user.setPrivilage(this.daoPlayer.usernameDatabase.searchUsernamePrivilage("Private"));

        parameters = new Parameters("", "");
        uiAbilityLogic = new UiAbilityLogic(this.daoPlayer);
        uiUserTableLogic = new UiUserTableLogic(this.daoPlayer);
        uiParamtersTableLogic = new UiParametersTableLogic(this.daoPlayer);
        uiUserLogic = new UiUserLogic(this.daoPlayer.getUsernameDatabase(), user, this.scenePlayer);
        uiTransitionLogic = new UiTransitionLogic(this.scenePlayer);
        uiSupportLogic = new UiSupportLogic(this.scenePlayer);

        return true;
    }
    /** Asettaa ytimen julkiseen tilaan.
     * @param adminList asennuksen aikana tuotettu pääkäyttäjien lista.
     * @return palauttaa true, jos asetus onnistu ja false, jos ei.
     */
    public boolean publicCoreSetup(List<Admin> adminList) {
        Boolean configRead = configuration.readConfigFile(fileManager);

        if (!configRead) {
            return false;
        }

        this.daoPlayer = new DaoPlayer(fileManager, configuration);

        Boolean daoSetup = daoPlayer.daoSetup();

        for (Admin admin : adminList) {
            daoPlayer.getUsernameDatabase().addUserInformation(admin.getUsername(), admin.getPassword(), "Admin");
        }

        if (!daoSetup) {
            return false;
        }

        user = new User("", "", "", 0);
        parameters = new Parameters("", "");
        uiAbilityLogic = new UiAbilityLogic(this.daoPlayer);
        uiUserTableLogic = new UiUserTableLogic(this.daoPlayer);
        uiParamtersTableLogic = new UiParametersTableLogic(this.daoPlayer);
        uiUserLogic = new UiUserLogic(this.daoPlayer.getUsernameDatabase(), user, this.scenePlayer);
        uiTransitionLogic = new UiTransitionLogic(this.scenePlayer);
        uiSupportLogic = new UiSupportLogic(this.scenePlayer);
        
        return true;
    }
    /** Sulkee ytimen.
     * @return palauttaa true, jos sulkeminen onnistu ja false, jos ei.
     */
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
    public UiUserTableLogic getUiUserTableLogic() {
        return this.uiUserTableLogic;
    }
    public UiParametersTableLogic getUiParametersTableLogic() {
        return this.uiParamtersTableLogic;
    }
    public UiTransitionLogic getUiTransitionLogic() {
        return this.uiTransitionLogic;
    }
    public UiSupportLogic getUiSupportLogic() {
        return this.uiSupportLogic;
    }
    public Configuration getConfiguration() {
        return this.configuration;
    }

}
