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
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getFolderName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("Folder");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getFolderName());
        }

    }

    public void checkUserDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("UsernameDatabase");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getUsernameDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("UsernameDatabase");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getUsernameDName());
        }
    }
    
    public void checkClassDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("ClassDatabase");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getClassDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("ClassDatabase");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getClassDName());
        }
    }

    public void checkNameDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("NameDatabase");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getNameDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("NameDatabase");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getNameDName());
        }
    }

    public void checkDescriptionDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("DescriptionDatabase");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getDescriptionDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("DescriptionDatabase");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getDescriptionDName());
        }
    }

    public void checkRequrimentDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("RequrimentDatabase");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getRequrimentDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("RequrimentDatabase");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getRequrimentDName());
        }
    }

    public void checkRealityDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("RealityDatabase");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getRealityDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("RealityDatabase");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getRealityDName());
        }
    }
    
    public void checkAbilityDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("AbilityDatabase");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getAbilityDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("AbilityDatabase");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getAbilityDName());
        }
    }

    public void setSelectedName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            String givenName = scenePlayer.getPublicDaoSettings().getNameInput().getText();
            
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
            String givenName = scenePlayer.getPrivateDaoSettings().getNameInput().getText();
            
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
            String givenUsername = scenePlayer.getAdministratorSettings().getUsernameArea().getText();
            String givenPassword = scenePlayer.getAdministratorSettings().getPasswordArea().getText();
            
            if (givenUsername.length()<5) {
                scenePlayer.getAdministratorSettings().getMessage().setText("Given username is too short");
                return;
            }
            
            if (givenPassword.length()<5) {
                scenePlayer.getAdministratorSettings().getMessage().setText("Given password is too short");
                return;
            }
            
            if (configuration.checkListForAdmin(givenUsername, givenPassword)) {
                scenePlayer.getAdministratorSettings().getMessage().setText("Account already exists");
                return;
            }
            configuration.addAdmin(givenUsername, givenPassword); 
            scenePlayer.getAdministratorSettings().getMessage().setText("Account has been added");
            scenePlayer.getAdministratorSettings().getUsernameArea().clear();
            scenePlayer.getAdministratorSettings().getPasswordArea().clear();
        }

    }
    

}
