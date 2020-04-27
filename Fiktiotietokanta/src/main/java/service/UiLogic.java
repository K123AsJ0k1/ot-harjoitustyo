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
import textEditorLogic.TemplateMaker;
import textEditorLogic.TextRefinery;

/**
 *
 * @author niila
 */
public class UiLogic {

    DatabaseInterface classDatabase;
    DatabaseInterface nameDatabase;
    DatabaseInterface descriptionDatabase;
    DatabaseInterface requrimentDatabase;
    DatabaseInterface realityDatabase;
    DatabaseInterface abilityDatabase;

    public UiLogic(DatabaseInterface classDatabase, DatabaseInterface nameDatabase, DatabaseInterface descriptionDatabase, DatabaseInterface requrimentDatabase, DatabaseInterface realityDatabase, DatabaseInterface abilityDatabase) {
        this.classDatabase = classDatabase;
        this.nameDatabase = nameDatabase;
        this.descriptionDatabase = descriptionDatabase;
        this.requrimentDatabase = requrimentDatabase;
        this.realityDatabase = realityDatabase;
        this.abilityDatabase = abilityDatabase;

    }

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

        System.out.println("hei");
        int classId = classDatabase.searchInfromationId(textFieldClass);
        int nameId = nameDatabase.searchInfromationId(textFieldName);
        int descriptionId = descriptionDatabase.searchInfromationId(textFieldDescription);
        int requrimentId = requrimentDatabase.searchInfromationId(textFieldRequriment);
        int realityId = realityDatabase.searchInfromationId(textFieldReality);

        String information = String.valueOf(usernameId) + "/" + String.valueOf(classId) + "/" + String.valueOf(nameId) + "/" + String.valueOf(descriptionId) + "/" + String.valueOf(requrimentId) + "/" + String.valueOf(realityId);
        System.out.println(information);
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

}
