/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
import domain.TextTemplateInterface;
import domain.UsernameInterface;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import textlogic.TemplateMaker;
import textlogic.TextRefinery;

/**
 * Ominaisuuksiin liittyvää käyttöliittymä logiikkaa.
 *
 *
 */
public class UiAbilityLogic {

    DatabaseInterface classDatabase;
    DatabaseInterface nameDatabase;
    DatabaseInterface descriptionDatabase;
    DatabaseInterface requrimentDatabase;
    DatabaseInterface realityDatabase;
    DatabaseInterface abilityDatabase;

    /**
     * Konstruktori.
     *
     * @param classDatabase luokkatietokanta.
     * @param nameDatabase nimitietokanta.
     * @param descriptionDatabase selitystietokanta.
     * @param requrimentDatabase vaatimusietokanta.
     * @param realityDatabase todellisuustietokanta.
     * @param abilityDatabase ominaisuustietokanta.
     */
    public UiAbilityLogic(DatabaseInterface classDatabase, DatabaseInterface nameDatabase, DatabaseInterface descriptionDatabase, DatabaseInterface requrimentDatabase, DatabaseInterface realityDatabase, DatabaseInterface abilityDatabase) {
        this.classDatabase = classDatabase;
        this.nameDatabase = nameDatabase;
        this.descriptionDatabase = descriptionDatabase;
        this.requrimentDatabase = requrimentDatabase;
        this.realityDatabase = realityDatabase;
        this.abilityDatabase = abilityDatabase;
    }

    /**
     * Lisää ominaisuuden.
     *
     * @param usernameId käyttäjän id-
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

    /**
     * Lisää ominaisuuksia listaksi.
     *
     * @param abilityList lista ominaisuuksia.
     * @return palauttaa koodin tilaa merkitsevän merkkijono.
     */
    public List<Ability> addAbilitiesIntoList(List<String> abilityList) {
        List<Ability> returnedList = new ArrayList<>();
        abilityList.stream().map((ability) -> ability.split("/")).map((split) -> {
            String classIdentity = classDatabase.searchInformationTextIdentity(split[0]);
            String nameIdentity = nameDatabase.searchInformationTextIdentity(split[1]);
            String descriptionIdentity = descriptionDatabase.searchInformationTextIdentity(split[2]);
            String requrimentIdentity = requrimentDatabase.searchInformationTextIdentity(split[3]);
            String realityIdentity = realityDatabase.searchInformationTextIdentity(split[4]);
            Ability addedAbility = new Ability(classIdentity, nameIdentity, descriptionIdentity, requrimentIdentity, realityIdentity);
            return addedAbility;
        }).forEachOrdered((addedAbility) -> {
            returnedList.add(addedAbility);
        });
        return returnedList;
    }

    /**
     * Poistaa ominaisuuden.
     *
     * @param usernameId käyttäjän id.
     * @param selectedItems valitut asiat.
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

    /**
     * Valitsee ominaisuuden.
     *
     * @param selectedItems valitut asiat.
     * @return palauttaa parametrit.
     */
    public String chooseAbility(ObservableList selectedItems) {
        String[] givenAbilitySplit = selectedItems.get(0).toString().split("/");
        String selectedParameters = givenAbilitySplit[0] + "," + givenAbilitySplit[1] + "," + givenAbilitySplit[2] + "," + givenAbilitySplit[3] + "," + givenAbilitySplit[4];
        return selectedParameters;
    }

}
