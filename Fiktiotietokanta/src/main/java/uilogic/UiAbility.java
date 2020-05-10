/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import tables.AbilityTable;
import domain.DatabaseInterface;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import service.DaoPlayer;

/**
 * Sovelluksen ominaisuuksien toiminnan hallitsija.
 */
public class UiAbility {

    DatabaseInterface classDatabase;
    DatabaseInterface nameDatabase;
    DatabaseInterface descriptionDatabase;
    DatabaseInterface requrimentDatabase;
    DatabaseInterface realityDatabase;
    DatabaseInterface abilityDatabase;

    /**
     * Konstruktori.
     *
     * @param daoPlayer antaa tarvittavan viiteet.
     */
    public UiAbility(DaoPlayer daoPlayer) {
        this.classDatabase = daoPlayer.getClassDatabase();
        this.nameDatabase = daoPlayer.getNameDatabase();
        this.descriptionDatabase = daoPlayer.getDescriptionDatabase();
        this.requrimentDatabase = daoPlayer.getRequrimetnDatabase();
        this.realityDatabase = daoPlayer.getRealityDatabase();
        this.abilityDatabase = daoPlayer.getAbilityDatabase();
    }

    /**
     * Lisää ominaisuuden tietokantaan.
     *
     * @param usernameId käyttäjän id
     * @param textFieldClass saatu merkkijono.
     * @param textFieldName saatu merkkijono.
     * @param textFieldDescription saatu merkkijono.
     * @param textFieldRequriment saatu merkkijono.
     * @param textFieldReality saatu merkkijono.
     * @return palauttaa koodin tilaa merkitsevän merkkijono.
     */
    public String addAbility(int usernameId, String textFieldClass, String textFieldName, String textFieldDescription, String textFieldRequriment, String textFieldReality) {

        if (textFieldClass.length() == 0 || textFieldName.length() == 0 || textFieldDescription.length() == 0 || textFieldRequriment.length() == 0 || textFieldReality.length() == 0) {
            return "Not all blanks are full";
        }

        Boolean addClass = false;
        Boolean addName = false;
        Boolean addDescription = false;
        Boolean addRequriment = false;
        Boolean addReality = false;

        if (!classDatabase.searchInformation(textFieldClass)) {
            addClass = true;
        }
        if (!nameDatabase.searchInformation(textFieldName)) {
            addName = true;
        }
        if (!descriptionDatabase.searchInformation(textFieldDescription)) {
            addDescription = true;
        }
        if (!requrimentDatabase.searchInformation(textFieldRequriment)) {
            addRequriment = true;
        }
        if (!realityDatabase.searchInformation(textFieldReality)) {
            addReality = true;
        }
        
        Boolean classHasBeenAdded = false;
        if (addClass) {
            classHasBeenAdded = classDatabase.addInformation(textFieldClass);
        }
        Boolean nameHasBeenAdded = false;
        if (addName) {
            nameHasBeenAdded = nameDatabase.addInformation(textFieldName);
        }
        Boolean descriptionHasBeenAdded = false;
        if (addDescription) {
            descriptionHasBeenAdded = descriptionDatabase.addInformation(textFieldDescription);
        }
        Boolean requrimentHasBeenAdded = false;
        if (addRequriment) {
            requrimentHasBeenAdded = requrimentDatabase.addInformation(textFieldRequriment);
        }
        Boolean realityHasBeenAdded = false;
        if (addReality) {
            realityHasBeenAdded = realityDatabase.addInformation(textFieldReality);
        }

        int classId = classDatabase.searchInfromationId(textFieldClass);
        int nameId = nameDatabase.searchInfromationId(textFieldName);
        int descriptionId = descriptionDatabase.searchInfromationId(textFieldDescription);
        int requrimentId = requrimentDatabase.searchInfromationId(textFieldRequriment);
        int realityId = realityDatabase.searchInfromationId(textFieldReality);

        String information = String.valueOf(usernameId) + "/" + String.valueOf(classId) + "/" + String.valueOf(nameId) + "/" + String.valueOf(descriptionId) + "/" + String.valueOf(requrimentId) + "/" + String.valueOf(realityId);

        if (usernameId == 0 || classId == 0 || nameId == 0 || descriptionId == 0 || requrimentId == 0 || realityId == 0) {
            return "Error has happened";
        }

        if (abilityDatabase.searchInformation(information)) {
            return "Ability already exists";
        }

        Boolean abilityHasBeenAdded = abilityDatabase.addInformation(information);

        if (!abilityHasBeenAdded) {
            return "Error has happened";
        }

        return "Ability has been added";
    }

    /** Lisää ominaisuudet listaan ability olio listaan.
     * @param abilityList lista ominaisuuksia.
     * @return palauttaa koodin tilaa merkitsevän merkkijono.
     */
    public List<AbilityTable> addAbilitiesIntoList(List<String> abilityList) {
        List<AbilityTable> returnedList = new ArrayList<>();

        for (String ability : abilityList) {
            String[] split = ability.split("/");
            String classIdentity = classDatabase.searchInformationTextIdentity(split[0]);
            String nameIdentity = nameDatabase.searchInformationTextIdentity(split[1]);
            String descriptionIdentity = descriptionDatabase.searchInformationTextIdentity(split[2]);
            String requrimentIdentity = requrimentDatabase.searchInformationTextIdentity(split[3]);
            String realityIdentity = realityDatabase.searchInformationTextIdentity(split[4]);
            AbilityTable addedAbility = new AbilityTable(classIdentity, nameIdentity, descriptionIdentity, requrimentIdentity, realityIdentity);
            returnedList.add(addedAbility);
        }
        return returnedList;
    }

    /**Poistaa ominaisuuden tietokannasta.
     * @param usernameId käyttäjän id.
     * @param selectedItems listasta valittu ominaisuus.
     */
    public void removeAbility(int usernameId, ObservableList selectedItems) {
        String[] givenAbilitySplit = selectedItems.get(0).toString().split("/");
        int classId = classDatabase.searchInfromationId(givenAbilitySplit[0]);
        int nameId = nameDatabase.searchInfromationId(givenAbilitySplit[1]);
        int descriptionId = descriptionDatabase.searchInfromationId(givenAbilitySplit[2]);
        int requrimentId = requrimentDatabase.searchInfromationId(givenAbilitySplit[3]);
        int realityId = realityDatabase.searchInfromationId(givenAbilitySplit[4]);
        String removedId = String.valueOf(usernameId) + "/" + String.valueOf(classId) + "/" + String.valueOf(nameId) + "/" + String.valueOf(descriptionId) + "/" + String.valueOf(requrimentId) + "/" + String.valueOf(realityId);
        abilityDatabase.removeInformation(removedId);
    }

    /** Valitsee ominaisuuden listasta.
     * @param selectedItems listasta valittu ominaisuus.
     * @return palauttaa ominaisuuden parametrit.
     */
    public String chooseAbility(ObservableList selectedItems) {
        String[] givenAbilitySplit = selectedItems.get(0).toString().split("/");
        String selectedParameters = givenAbilitySplit[0] + "," + givenAbilitySplit[1] + "," + givenAbilitySplit[2] + "," + givenAbilitySplit[3] + "," + givenAbilitySplit[4];
        return selectedParameters;
    }

}
