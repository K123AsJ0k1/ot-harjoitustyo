/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

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
import filelogic.FileManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author niila
 */
public class IntegratedTest {
    
    @Test
    public void addAbility() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        
        UsernameInterface usernameTest = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        DatabaseInterface classTest = new ClassDatabase(dirCreator,"Test","ClassDatabase");
        DatabaseInterface nameTest = new NameDatabase(dirCreator,"Test","NameDatabase");
        DatabaseInterface descriptionTest = new DescriptionDatabase(dirCreator,"Test","DescriptionDatabase");
        DatabaseInterface requrimentTest = new RequrimentDatabase(dirCreator,"Test","RequrimentDatabase");
        DatabaseInterface realityTest = new RealityDatabase(dirCreator,"Test","RealityDatabase");
        DatabaseInterface abilityTest = new AbilityDatabase(dirCreator,"Test","AbilityDatabase");
        
        usernameTest.createUsernameDatabase();
        classTest.createDatabase();
        nameTest.createDatabase();
        descriptionTest.createDatabase();
        requrimentTest.createDatabase();
        realityTest.createDatabase();
        abilityTest.createDatabase();
        
        usernameTest.addUserInformation("Username", "Password", "Privilage");
        classTest.addInformation("Class");
        nameTest.addInformation("Name");
        descriptionTest.addInformation("Description");
        requrimentTest.addInformation("Requriment");
        realityTest.addInformation("Reality");
        
        int usernameId = usernameTest.searchUsernameId("Username");
        int classId =  classTest.searchInfromationId("Class");
        int nameId = nameTest.searchInfromationId("Name");
        int descriptionId = descriptionTest.searchInfromationId("Description");
        int requrimentId = requrimentTest.searchInfromationId("Requriment");
        int realityId = realityTest.searchInfromationId("Reality");
        
        String ability = String.valueOf(usernameId)+"/"+String.valueOf(classId)+"/"+String.valueOf(nameId)+"/"+String.valueOf(descriptionId)+"/"+String.valueOf(requrimentId)+"/"+String.valueOf(realityId); 
        
        abilityTest.addInformation(ability);
        
        Boolean exists = abilityTest.searchInformation(ability);
       
        assertEquals(true, exists);
        
        usernameTest.removeUsernameDatabase();
        classTest.removeDatabase();
        nameTest.removeDatabase();
        descriptionTest.removeDatabase();
        requrimentTest.removeDatabase();
        realityTest.removeDatabase();
        abilityTest.removeDatabase();
    }
    
    
    
    
    
}
