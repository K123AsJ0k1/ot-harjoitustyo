/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import filelogic.FileConfig;
import dao.AbilityDatabase;
import dao.ClassDatabase;
import dao.DescriptionDatabase;
import dao.NameDatabase;
import dao.RealityDatabase;
import dao.RequrimentDatabase;
import dao.UsernameDatabase;
import domain.DatabaseInterface;
import domain.FileManagerInterface;
import domain.UsernameInterface;

/** Sovelluksen tietokantojen toiminnan hallitsija.
 */
public class DaoPlayer {

    UsernameInterface usernameDatabase;
    DatabaseInterface classDatabase;
    DatabaseInterface nameDatabase;
    DatabaseInterface descriptionDatabase;
    DatabaseInterface requrimentDatabase;
    DatabaseInterface realityDatabase;
    DatabaseInterface abilityDatabase;
    
    /** Konstuktori.
     * @param fileManager antaa tarvitun tiedosto polun.
     * @param configuratio antaa tarvitut asetus tiedot.
    */
    public DaoPlayer(FileManagerInterface fileManager, FileConfig configuratio) {
        fileManager.createModifiedDirectory(configuratio.getFolderName());
        usernameDatabase = new UsernameDatabase(fileManager, "Normal", configuratio.getUsernameDName());
        classDatabase = new ClassDatabase(fileManager, "Normal", configuratio.getClassDName());
        nameDatabase = new NameDatabase(fileManager, "Normal", configuratio.getNameDName());
        descriptionDatabase = new DescriptionDatabase(fileManager, "Normal", configuratio.getDescriptionDName());
        requrimentDatabase = new RequrimentDatabase(fileManager, "Normal", configuratio.getRequrimentDName());
        realityDatabase = new RealityDatabase(fileManager, "Normal", configuratio.getRealityDName());
        abilityDatabase = new AbilityDatabase(fileManager, "Normal", configuratio.getAbilityDName());
    }
    /** Laittaa tietokanta hallitsijan päälle.
     * @return palauttaa true, jos rakentaminen onnistu ja false, jos ei.
    */
    public Boolean daoSetup() {

        Boolean userDao = usernameDatabase.createUsernameDatabase();
        Boolean classDao = classDatabase.createDatabase();
        Boolean nameDao = nameDatabase.createDatabase();
        Boolean descriptionDao = descriptionDatabase.createDatabase();
        Boolean requrimentDao = requrimentDatabase.createDatabase();
        Boolean realityDao = realityDatabase.createDatabase();
        Boolean abilityDao = abilityDatabase.createDatabase();

        if (!userDao || !classDao || !nameDao || !descriptionDao || !requrimentDao || !realityDao || !abilityDao) {
            return false;
        }
        return true;
    }
    /** Sulkee tietokanta hallitsijan.
     * @return palauttaa true, jos sulkeminen onnistu ja false, jos ei.
    */
    public Boolean daoShutDown() {

        Boolean userDao = usernameDatabase.removeUsernameDatabase();
        Boolean classDao = classDatabase.removeDatabase();
        Boolean nameDao = nameDatabase.removeDatabase();
        Boolean descriptionDao = descriptionDatabase.removeDatabase();
        Boolean requrimentDao = requrimentDatabase.removeDatabase();
        Boolean realityDao = realityDatabase.removeDatabase();
        Boolean abilityDao = abilityDatabase.removeDatabase();

        if (!userDao || !classDao || !nameDao || !descriptionDao || !requrimentDao || !realityDao || !abilityDao) {
            return false;
        }
        return true;

    }

    public UsernameInterface getUsernameDatabase() {
        return this.usernameDatabase;
    }

    public DatabaseInterface getClassDatabase() {
        return this.classDatabase;
    }

    public DatabaseInterface getNameDatabase() {
        return this.nameDatabase;
    }

    public DatabaseInterface getDescriptionDatabase() {
        return this.descriptionDatabase;
    }

    public DatabaseInterface getRequrimetnDatabase() {
        return this.requrimentDatabase;
    }

    public DatabaseInterface getRealityDatabase() {
        return this.realityDatabase;
    }

    public DatabaseInterface getAbilityDatabase() {
        return this.abilityDatabase;
    }

}
