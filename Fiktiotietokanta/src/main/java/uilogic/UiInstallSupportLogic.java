/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.Configuration;
import assets.TextAreaMode;
import service.ScenePlayer;

/**
 * Sovelluksen asennuksen toimintaa tukeva hallitsija.
 */
public class UiInstallSupportLogic {

    ScenePlayer scenePlayer;

    /**
     * Konstruktori.
     *
     * @param scenePlayer antaa tarpeellisen viiteen.
     */
    public UiInstallSupportLogic(ScenePlayer scenePlayer) {
        this.scenePlayer = scenePlayer;
    }

    /**
     * Hakee tietokanta kansion nimen ja laittaa moodin Folderiksi.
     *
     * @param configuration annettuu asetukset.
     * @param textMode tilanteen mukainen teksti tila.
     */
    public void checkFolderName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("Folder");
            scenePlayer.getPublicDaoSettings().getMessage().setText("");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getFolderName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("Folder");
            scenePlayer.getPrivateDaoSettings().getMessage().setText("");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getFolderName());
        }

    }

    /**
     * Hakee käyttäjä tietokannan nimen ja laittaa moodin UsernameDatabase.
     *
     * @param configuration annettuu asetukset.
     * @param textMode tilanteen mukainen teksti tila.
     */
    public void checkUserDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("UsernameDatabase");
            scenePlayer.getPublicDaoSettings().getMessage().setText("");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getUsernameDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("UsernameDatabase");
            scenePlayer.getPrivateDaoSettings().getMessage().setText("");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getUsernameDName());
        }
    }

    /**
     * Hakee luokka tietokannan nimen ja laittaa moodin ClassDatabase.
     *
     * @param configuration annettuu asetukset.
     * @param textMode tilanteen mukainen teksti tila.
     */
    public void checkClassDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("ClassDatabase");
            scenePlayer.getPublicDaoSettings().getMessage().setText("");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getClassDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("ClassDatabase");
            scenePlayer.getPrivateDaoSettings().getMessage().setText("");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getClassDName());
        }
    }

    /**
     * Hakee nimi tietokannan nimen ja laittaa moodin NameDatabase.
     *
     * @param configuration annettuu asetukset.
     * @param textMode tilanteen mukainen teksti tila.
     */
    public void checkNameDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("NameDatabase");
            scenePlayer.getPublicDaoSettings().getMessage().setText("");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getNameDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("NameDatabase");
            scenePlayer.getPrivateDaoSettings().getMessage().setText("");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getNameDName());
        }
    }

    /**
     * Hakee selite tietokannan nimen ja laittaa moodin DescriptionDatabase.
     *
     * @param configuration annettuu asetukset.
     * @param textMode tilanteen mukainen teksti tila.
     */
    public void checkDescriptionDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("DescriptionDatabase");
            scenePlayer.getPublicDaoSettings().getMessage().setText("");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getDescriptionDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("DescriptionDatabase");
            scenePlayer.getPrivateDaoSettings().getMessage().setText("");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getDescriptionDName());
        }
    }

    /**
     * Hakee vaatimus tietokannan nimen ja laittaa moodin RequrimentDatabase.
     *
     * @param configuration annettuu asetukset.
     * @param textMode tilanteen mukainen teksti tila.
     */
    public void checkRequrimentDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("RequrimentDatabase");
            scenePlayer.getPublicDaoSettings().getMessage().setText("");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getRequrimentDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("RequrimentDatabase");
            scenePlayer.getPrivateDaoSettings().getMessage().setText("");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getRequrimentDName());
        }
    }

    /**
     * Hakee todellisuus tietokannan nimen ja laittaa moodin RealityDatabase.
     *
     * @param configuration annettuu asetukset.
     * @param textMode tilanteen mukainen teksti tila.
     */
    public void checkRealityDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("RealityDatabase");
            scenePlayer.getPublicDaoSettings().getMessage().setText("");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getRealityDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("RealityDatabase");
            scenePlayer.getPrivateDaoSettings().getMessage().setText("");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getRealityDName());
        }
    }

    /**
     * Hakee omainsuus tietokannan nimen ja laittaa moodin AbilityDatabase.
     *
     * @param configuration annettuu asetukset.
     * @param textMode tilanteen mukainen teksti tila.
     */
    public void checkAbilityDName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            textMode.setMode("AbilityDatabase");
            scenePlayer.getPublicDaoSettings().getMessage().setText("");
            scenePlayer.getPublicDaoSettings().getNameInput().setText(configuration.getAbilityDName());
        }

        if (configuration.getMode().equals("Private")) {
            textMode.setMode("AbilityDatabase");
            scenePlayer.getPrivateDaoSettings().getMessage().setText("");
            scenePlayer.getPrivateDaoSettings().getNameInput().setText(configuration.getAbilityDName());
        }
    }

    /**
     * Muuttaa textArean merkkijonon teksti tilan mukaiseksi.
     *
     * @param configuration annettuu asetukset.
     * @param textMode tilanteen mukainen teksti tila.
     */
    public void setSelectedName(Configuration configuration, TextAreaMode textMode) {
        if (configuration.getMode().equals("Public")) {
            String givenName = scenePlayer.getPublicDaoSettings().getNameInput().getText();

            if (givenName.length() < 5) {
                scenePlayer.getPublicDaoSettings().getMessage().setText("Name is too short");
                return;
            }

            if (givenName.equals("projectdatabases")) {
                scenePlayer.getPublicDaoSettings().getMessage().setText("Name is forbbidden");
                return;
            }

            if (textMode.getMode().equals("")) {
                scenePlayer.getPublicDaoSettings().getMessage().setText("Select examined name");
                return;
            }

            if (textMode.getMode().equals("Folder")) {
                configuration.setFolderName(givenName);
            }

            if (textMode.getMode().equals("UsernameDatabase")) {
                configuration.setUsernameDName(givenName);
            }

            if (textMode.getMode().equals("ClassDatabase")) {
                configuration.setClassDName(givenName);
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

            if (textMode.getMode().equals("AbilityDatabase")) {
                configuration.setAbilityDName(givenName);
            }

            scenePlayer.getPublicDaoSettings().getMessage().setText("Name has been changed");
        }

        if (configuration.getMode().equals("Private")) {
            String givenName = scenePlayer.getPrivateDaoSettings().getNameInput().getText();

            if (givenName.length() < 5) {
                scenePlayer.getPrivateDaoSettings().getMessage().setText("Name is too short");
                return;
            }

            if (givenName.equals("projectdatabases")) {
                scenePlayer.getPrivateDaoSettings().getMessage().setText("Name is forbbidden");
                return;
            }

            if (textMode.getMode().equals("")) {
                scenePlayer.getPrivateDaoSettings().getMessage().setText("Select examined name");
                return;
            }

            if (textMode.getMode().equals("Folder")) {
                configuration.setFolderName(givenName);
            }

            if (textMode.getMode().equals("UsernameDatabase")) {
                configuration.setUsernameDName(givenName);
            }

            if (textMode.getMode().equals("ClassDatabase")) {
                configuration.setClassDName(givenName);
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

            if (textMode.getMode().equals("AbilityDatabase")) {
                configuration.setAbilityDName(givenName);
            }

            scenePlayer.getPrivateDaoSettings().getMessage().setText("Name has been changed");
        }
    }

    /**
     * Lisää pääkäyttäjän.
     *
     * @param configuration annettuu asetukset.
     */
    public void AddAdmin(Configuration configuration) {
        if (configuration.getMode().equals("Public")) {
            String givenUsername = scenePlayer.getAdministratorSettings().getUsernameArea().getText();
            String givenPassword = scenePlayer.getAdministratorSettings().getPasswordArea().getText();

            if (givenUsername.length() < 5) {
                scenePlayer.getAdministratorSettings().getMessage().setText("Given username is too short");
                return;
            }

            if (givenPassword.length() < 5) {
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
