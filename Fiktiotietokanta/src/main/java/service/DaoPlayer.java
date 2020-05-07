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
import domain.UsernameInterface;

/**
 *
 * @author niila
 */
public class DaoPlayer {
    
    UsernameInterface usernameDatabase;
    DatabaseInterface classDatabase;
    DatabaseInterface nameDatabase;
    DatabaseInterface descriptionDatabase;
    DatabaseInterface requrimentDatabase;
    DatabaseInterface realityDatabase;
    DatabaseInterface abilityDatabase;
    
    public DaoPlayer() {
        usernameDatabase = new UsernameDatabase("Normal");
        classDatabase = new ClassDatabase("Normal");
        nameDatabase = new NameDatabase("Normal");
        descriptionDatabase = new DescriptionDatabase("Normal");
        requrimentDatabase = new RequrimentDatabase("Normal");
        realityDatabase = new RealityDatabase("Normal");
        abilityDatabase = new AbilityDatabase("Normal");
    }
    
    public Boolean daoSetup() {
 
        Boolean userDao = usernameDatabase.createUsernameDatabase();
        Boolean classDao = classDatabase.createDatabase();
        Boolean nameDao = nameDatabase.createDatabase();
        Boolean descriptionDao = descriptionDatabase.createDatabase();
        Boolean requrimentDao = requrimentDatabase.createDatabase();
        Boolean realityDao = realityDatabase.createDatabase();
        Boolean abilityDao = abilityDatabase.createDatabase();
        
        if (!userDao || !classDao || !nameDao || !descriptionDao || !requrimentDao || !realityDao || !abilityDao  ) {
            return false;
        }
        return true;
    }
    
    
    public Boolean daoShutDown() {
        
        Boolean userDao = usernameDatabase.removeUsernameDatabase();
        Boolean classDao = classDatabase.removeDatabase();
        Boolean nameDao = nameDatabase.removeDatabase();
        Boolean descriptionDao = descriptionDatabase.removeDatabase();
        Boolean requrimentDao = requrimentDatabase.removeDatabase();
        Boolean realityDao = realityDatabase.removeDatabase();
        Boolean abilityDao = abilityDatabase.removeDatabase();
        
        if (!userDao || !classDao || !nameDao || !descriptionDao || !requrimentDao || !realityDao || !abilityDao  ) {
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
