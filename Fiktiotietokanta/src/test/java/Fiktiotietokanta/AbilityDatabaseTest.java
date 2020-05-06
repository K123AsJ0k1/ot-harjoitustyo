/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import dao.AbilityDatabase;
import domain.DatabaseInterface;
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
public class AbilityDatabaseTest {
    
    //Constructor tests
    
    @Test
    public void normalModeWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Normal");
        String givenNormalConnection = test.getConnectionString();
        assertEquals("jdbc:sqlite:abilitydatabase:connection", givenNormalConnection);
    }
    
    @Test
    public void testModeWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        String givenTestConnection = test.getConnectionString();
        assertEquals("jdbc:sqlite:abilitydatabasetest:connection", givenTestConnection);
    }
    
    @Test
    public void getDatabaseWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        assertEquals(false, test.databaseExists());
    }
    
    //Create database tests
    @Test
    public void createDatabaseWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        Boolean isCreated = test.createDatabase();
        assertEquals(true, isCreated);
        test.removeDatabase();
    }
    
    @Test
    public void createDatabaseCatchesErrors() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        Boolean isCreated = test.createDatabase();
        assertEquals(true, isCreated);
        Boolean databaseCantBeCreatedTwice = test.createDatabase();
        assertEquals(false, databaseCantBeCreatedTwice);
        test.removeDatabase();
    }
    
    //Remove database tests
    
    @Test
    public void removeDatabaseWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        Boolean isCreated = test.createDatabase();
        assertEquals(true, isCreated);
        Boolean databaseIsRemoved = test.removeDatabase();
        assertEquals(true, databaseIsRemoved);
    }
    
    @Test
    public void removeDatabaseCatchesErrors1() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean databaseIsRemoved = test.removeDatabase();
        assertEquals(true, databaseIsRemoved);
        Boolean databaseIsntRemovedTwice = test.removeDatabase();
        assertEquals(false, databaseIsntRemovedTwice);
    }
    
    @Test
    public void removeDatabaseCatchesErrors2() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        Boolean nonExistingDatabaseIsntRemoved = test.removeDatabase();
        assertEquals(false,nonExistingDatabaseIsntRemoved);
    }
    
    //Add information tests
    
    @Test
    public void addInformationWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean isAdded = test.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded);
        test.removeDatabase();
    }
    
    @Test
    public void addInformationCatchesErrors1() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean tooShort = test.addInformation("1/1/1/1/1");
        assertEquals(false, tooShort);
        test.removeDatabase();
    }
    
    
    @Test
    public void addInformationCatchesErrors2() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean tooLong = test.addInformation("1/1/1/1/1/1/1");
        assertEquals(false, tooLong);
        test.removeDatabase();
    }
    
    @Test
    public void addInformationCatchesErrors3() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean inCorrectString = test.addInformation("1/1/g/1/1/1");
        assertEquals(false, inCorrectString);
        test.removeDatabase();
    }
    
    @Test
    public void addInformationCatchesErrors4() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        Boolean cantAddIntoNonExistingDatabase = test.addInformation("1/1/1/1/1/1");
        assertEquals(false, cantAddIntoNonExistingDatabase);
    }
    
    //Search information tests
    
    @Test
    public void searchInformationWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Boolean isFound = test.searchInformation("1/1/1/1/1/1");
        assertEquals(true, isFound);
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationIsCorrect() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        test.addInformation("2/2/2/2/2/2");
        test.addInformation("3/3/3/3/3/3");
        Boolean isFound1 = test.searchInformation("1/1/1/1/1/1");
        assertEquals(true, isFound1);
        Boolean isFound2 = test.searchInformation("2/2/2/2/2/2");
        assertEquals(true, isFound2);
        Boolean isFound3 = test.searchInformation("3/3/3/3/3/3");
        assertEquals(true, isFound3);
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationNoInfoFound() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean isntFound = test.searchInformation("1/1/1/1/1/1");
        assertEquals(false, isntFound);
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationCatchesErrors1() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean tooShort = test.addInformation("1/1/1/1/1");
        assertEquals(false, tooShort);
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationCatchesErrors2() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean tooLong = test.addInformation("1/1/1/1/1/1/1");
        assertEquals(false, tooLong);
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationCatchesErrors3() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean wrongString = test.addInformation("1/1/g/1/1/1");
        assertEquals(false, wrongString);
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationCatchesErrors4() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        Boolean cantSearchNonExisintDatabase = test.searchInformation("1/1/1/1/1/1");
        assertEquals(false, cantSearchNonExisintDatabase);
    }
    
    //Remove information tests
    
    @Test
    public void removeInformationWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Boolean isRemoved = test.removeInformation("1/1/1/1/1/1");
        assertEquals(true, isRemoved);
        test.removeDatabase();
    }
    
    @Test
    public void removeInformationIsCorrect() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        test.addInformation("2/2/2/2/2/2");
        test.addInformation("3/3/3/3/3/3");
        Boolean isRemoved1 = test.removeInformation("1/1/1/1/1/1");
        Boolean isRemoved2 = test.removeInformation("2/2/2/2/2/2");
        Boolean isRemoved3 = test.removeInformation("3/3/3/3/3/3");
        assertEquals(true, isRemoved1);
        assertEquals(true, isRemoved2);
        assertEquals(true, isRemoved3);
        test.removeDatabase();
    }
    
    @Test
    public void removeInformationCatchesErrors1() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Boolean tooShort = test.removeInformation("1/1/1/1/1");
        assertEquals(false, tooShort);
        test.removeDatabase();
    }
    
    @Test
    public void removeInformationCatchesErrors2() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Boolean tooLong = test.removeInformation("1/1/1/1/1/1/1");
        assertEquals(false, tooLong);
        test.removeDatabase();
    }
    
    @Test
    public void removeInformationCatchesErrors3() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Boolean wrongString = test.removeInformation("1/1/g/1/1/1");
        assertEquals(false, wrongString);
        test.removeDatabase();
    }
    
    @Test
    public void removeInformationCatchesErrors4() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        Boolean cantRemoveFromNonExistingDatabase = test.removeInformation("1/1/1/1/1/1");
        assertEquals(false, cantRemoveFromNonExistingDatabase);
    }
    
    
}
