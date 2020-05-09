/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.Configuration;
import assets.TextAreaMode;
import javafx.scene.Node;
import javafx.stage.Stage;
import service.LayoutPlayer;
import service.ScenePlayer;
import service.UiLogicCore;

/**
 *
 * @author niila
 */
public class UiInstallSupportLogic {

    ScenePlayer scenePlayer;

    public UiInstallSupportLogic(ScenePlayer scenePlayer) {
        this.scenePlayer = scenePlayer;
    }

    public void checkFolderName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("Folder");
            scenePlayer.getDaoSettings().getNameInput().setText(configuration.getFolderName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("Folder");
            scenePlayer.getDaoSettingsPrivateScene().getNameInput().setText(configuration.getFolderName());
        }

    }

    public void checkUserDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("UsernameDatabase");
            scenePlayer.getDaoSettings().getNameInput().setText(configuration.getUsernameDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("UsernameDatabase");
            scenePlayer.getDaoSettingsPrivateScene().getNameInput().setText(configuration.getUsernameDName());
        }
    }

    public void checkNameDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("NameDatabase");
            scenePlayer.getDaoSettings().getNameInput().setText(configuration.getNameDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("NameDatabase");
            scenePlayer.getDaoSettingsPrivateScene().getNameInput().setText(configuration.getNameDName());
        }
    }

    public void checkDescriptionDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("DescriptionDatabase");
            scenePlayer.getDaoSettings().getNameInput().setText(configuration.getDescriptionDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("DescriptionDatabase");
            scenePlayer.getDaoSettingsPrivateScene().getNameInput().setText(configuration.getDescriptionDName());
        }
    }

    public void checkRequrimentDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("RequrimentDatabase");
            scenePlayer.getDaoSettings().getNameInput().setText(configuration.getRequrimentDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("RequrimentDatabase");
            scenePlayer.getDaoSettingsPrivateScene().getNameInput().setText(configuration.getRequrimentDName());
        }
    }

    public void checkRealityDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("RealityDatabase");
            scenePlayer.getDaoSettings().getNameInput().setText(configuration.getRealityDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("RealityDatabase");
            scenePlayer.getDaoSettingsPrivateScene().getNameInput().setText(configuration.getRealityDName());
        }
    }

    public void setSelectedName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            String givenName = scenePlayer.getDaoSettings().getNameInput().getText();
            
            if (givenName.length()==0) {
                return;
            }
            
            if (givenName.equals("projectdatabases")) {
                return;
            }
            
            if (textMode.getMode().equals("")) {
                return;
            }
            
            if (textMode.getMode().equals("Folder")) {
                configuration.setFolderName(givenName);
            }
            
            if (textMode.getMode().equals("UsernameDatabase")) {
                configuration.setUsernameDName(givenName);
            }
            
            if (textMode.getMode().equals("NameDatabase")) {
                configuration.setNameDName(givenName);
            }
            
            if (textMode.getMode().equals("DescriptionDatabase")) {
                configuration.setDescriptionDName(givenName);
            }
            
            if (textMode.getMode().equals("RequrimentDatabase")) {
                configuration.setRequrimentDName(givenName);
            }
            
            if (textMode.getMode().equals("RealityDatabase")) {
               configuration.setRealityDName(givenName);
            }

        }

        if (configuration.getMode().equals("Private")) {
            String givenName = scenePlayer.getDaoSettings().getNameInput().getText();
            
            if (givenName.length()==0) {
                return;
            }
            
            if (givenName.equals("projectdatabases")) {
                return;
            }
            
            if (textMode.getMode().equals("")) {
                return;
            }
            
            if (textMode.getMode().equals("Folder")) {
                configuration.setFolderName(givenName);
            }
            
            if (textMode.getMode().equals("UsernameDatabase")) {
                configuration.setUsernameDName(givenName);
            }
            
            if (textMode.getMode().equals("NameDatabase")) {
                configuration.setNameDName(givenName);
            }
            
            if (textMode.getMode().equals("DescriptionDatabase")) {
                configuration.setDescriptionDName(givenName);
            }
            
            if (textMode.getMode().equals("RequrimentDatabase")) {
                configuration.setRequrimentDName(givenName);
            }
            
            if (textMode.getMode().equals("RealityDatabase")) {
               configuration.setRealityDName(givenName);
            }
        }
    }
    
    public void AddAdmin(Configuration configuration) {
        if (configuration.getMode().equals("Public")) {
            String givenUsername = scenePlayer.getUpKeepSettings().getUsernameArea().getText();
            String givenPassword = scenePlayer.getUpKeepSettings().getPasswordArea().getText();
            
            if (givenUsername.length()<5) {
                return;
            }
            
            if (givenPassword.length()<5) {
                return;
            }
            configuration.addAdmin(givenUsername, givenPassword);
        }

    }
    

}
