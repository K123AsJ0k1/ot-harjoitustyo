/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import dao.NameDatabase;
import domain.DatabaseInterface;
import java.util.List;
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
public class NameDatabaseTest {
    
    //Constructor tests
    
    @Test
    public void normalModeWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Normal");
        String givenNormalConnection = test.getConnectionString();
        assertEquals("jdbc:sqlite:namedatabase:connection", givenNormalConnection);
    }
    
    @Test
    public void testModeWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        String givenTestConnection = test.getConnectionString();
        assertEquals("jdbc:sqlite:namedatabasetest:connection", givenTestConnection);
    }
    
    @Test
    public void getDatabaseWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        assertEquals(false, test.databaseExists());
    }
    
    //Create database tests
    @Test
    public void createDatabaseWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        Boolean isCreated = test.createDatabase();
        assertEquals(true, isCreated);
        test.removeDatabase();
    }
    
    @Test
    public void createDatabaseCatchesErrors() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        Boolean isCreated = test.createDatabase();
        assertEquals(true, isCreated);
        Boolean databaseCantBeCreatedTwice = test.createDatabase();
        assertEquals(false, databaseCantBeCreatedTwice);
        test.removeDatabase();
    }
    
    //Remove database tests
    
    @Test
    public void removeDatabaseWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        Boolean isCreated = test.createDatabase();
        assertEquals(true, isCreated);
        Boolean databaseIsRemoved = test.removeDatabase();
        assertEquals(true, databaseIsRemoved);
    }
    
    @Test
    public void removeDatabaseCatchesErrors1() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        Boolean databaseIsRemoved = test.removeDatabase();
        assertEquals(true, databaseIsRemoved);
        Boolean databaseIsntRemovedTwice = test.removeDatabase();
        assertEquals(false, databaseIsntRemovedTwice);
    }
    
    @Test
    public void removeDatabaseCatchesErrors2() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        Boolean nonExistingDatabaseIsntRemoved = test.removeDatabase();
        assertEquals(false,nonExistingDatabaseIsntRemoved);
    }
    
    //Add information tests
    
    @Test
    public void addInformationWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        Boolean isAdded = test.addInformation("Test");
        assertEquals(true, isAdded);
        test.removeDatabase();
    }
    
    @Test
    public void addInformationCatchesErrors1() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        Boolean isAdded = test.addInformation("Test");
        assertEquals(true, isAdded);
        Boolean sameInfoCantBeAdded = test.addInformation("Test");
        assertEquals(false, sameInfoCantBeAdded);
        test.removeDatabase();
    }
    
    @Test
    public void addInformationCatchesErrors2() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        Boolean infoCantBeAddedIntoNonExistingDatabase = test.addInformation("Test");
        assertEquals(false, infoCantBeAddedIntoNonExistingDatabase);
    }
    
    //Search information tests
    
    @Test
    public void searchInformationWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test");
        Boolean isFound = test.searchInformation("Test");
        assertEquals(true, isFound);
        test.removeDatabase();
    }
    
    @Test
    public void informationIsntFound() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        Boolean isntFound = test.searchInformation("Test");
        assertEquals(false, isntFound);
        test.removeDatabase();
    }
    
    
    @Test
    public void searchInformationIsCorrect() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test1");
        test.addInformation("Test2");
        test.addInformation("Test3");
        Boolean isFound1 = test.searchInformation("Test1");
        Boolean isFound2 = test.searchInformation("Test2");
        Boolean isFound3 = test.searchInformation("Test3");
        assertEquals(true, isFound1);
        assertEquals(true, isFound2);
        assertEquals(true, isFound3);
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationCatchesErrors1() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.addInformation("Test1");
        test.addInformation("Test2");
        test.addInformation("Test3");
        Boolean isntFound = test.searchInformation("Test4");
        assertEquals(false, isntFound);
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationCatchesErrors2() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        Boolean infoCantBeSearchedFromNonExistingDatabase = test.searchInformation("Test");
        assertEquals(false, infoCantBeSearchedFromNonExistingDatabase);
    }
    
    //Remove information tests
    
    @Test
    public void removeInformationWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test");
        Boolean isRemoved = test.removeInformation("Test");
        assertEquals(true, isRemoved);
        test.removeDatabase();
    }
    
    @Test
    public void removeInformationIsCorrect() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test1");
        test.addInformation("Test2");
        test.addInformation("Test3");
        Boolean isRemoved = test.removeInformation("Test2");
        assertEquals(true, isRemoved);
        Boolean isFound1 = test.searchInformation("Test1");
        assertEquals(true, isFound1);
        Boolean isFound2 = test.searchInformation("Test3");
        assertEquals(true, isFound2);
        test.removeDatabase();     
    }
    
    @Test
    public void removeInformationCatchesErrors1() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        Boolean infoIsntRemovedFromNonExistingDatabase = test.removeInformation("Test");
        assertEquals(false, infoIsntRemovedFromNonExistingDatabase);
    }
    
    //SearchInformation tests
    
    @Test
    public void searchInfoIdWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test");
        Integer givenId = test.searchInfromationId("Test");
        assertEquals(1, givenId.intValue());
        test.removeDatabase();
    }
    
    @Test
    public void searchInfoIdIsCorrect() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test1");
        test.addInformation("Test2");
        test.addInformation("Test3");
        Integer givenId1 = test.searchInfromationId("Test1");
        assertEquals(1, givenId1.intValue());
        Integer givenId2 = test.searchInfromationId("Test2");
        assertEquals(2, givenId2.intValue());
        Integer givenId3 = test.searchInfromationId("Test3");
        assertEquals(3, givenId3.intValue());
        test.removeDatabase();
    }
    
    @Test
    public void searchInfoIdCatchesErrors1() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test1");
        test.addInformation("Test2");
        test.addInformation("Test3");
        Integer givenIdIsZero = test.searchInfromationId("Test4");
        assertEquals(0, givenIdIsZero.intValue());
        test.removeDatabase();
    }
    
    @Test
    public void searchInfoIdCatchesErrors2() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        Integer givenIdIsZero = test.searchInfromationId("Test");
        assertEquals(0, givenIdIsZero.intValue());
    }
    
    //SearchIdTextIdentity tests
    
    @Test
    public void giveIdIdentityWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test");
        Integer givenId = test.searchInfromationId("Test");
        String givenIdentity = test.searchInformationTextIdentity(String.valueOf(givenId));
        assertEquals("Test",givenIdentity);
        test.removeDatabase();
    }
    
    @Test
    public void givenIdIdentityIsCorrect() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test1");
        test.addInformation("Test2");
        test.addInformation("Test3");
        Integer givenId1 = test.searchInfromationId("Test1");
        Integer givenId2 = test.searchInfromationId("Test2");
        Integer givenId3 = test.searchInfromationId("Test3");
        String givenIdentity1 = test.searchInformationTextIdentity(String.valueOf(givenId1));
        String givenIdentity2 = test.searchInformationTextIdentity(String.valueOf(givenId2));
        String givenIdentity3 = test.searchInformationTextIdentity(String.valueOf(givenId3));
        assertEquals("Test1", givenIdentity1);
        assertEquals("Test2", givenIdentity2);
        assertEquals("Test3", givenIdentity3);
        test.removeDatabase();
    }
    
    @Test
    public void givenIdIdentityCatchesErrors1() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test1");
        test.addInformation("Test2");
        test.addInformation("Test3");
        String noExistingIdentity = test.searchInformationTextIdentity("4");
        assertEquals("null", noExistingIdentity);
        test.removeDatabase();
    }
    
    @Test
    public void givenIdIdentityCatchesErrors2() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        String noExistingIdentity = test.searchInformationTextIdentity("1");
        assertEquals("null", noExistingIdentity);
    }
    
    //ShowDatabaseAsAList tests
    
    @Test
    public void databaseAsAListWorks() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test");
        List<String> givenList = test.showDatabaseAsAList();
        assertEquals("Test",givenList.get(0));
        test.removeDatabase();
    }
    
    @Test
    public void databaseAsAListIsCorrect() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        test.addInformation("Test1");
        test.addInformation("Test2");
        test.addInformation("Test3");
        List<String> givenList = test.showDatabaseAsAList();
        assertEquals("Test1",givenList.get(0));
        assertEquals("Test2",givenList.get(1));
        assertEquals("Test3",givenList.get(2));
        test.removeDatabase();
    }
    
    @Test
    public void databaseAsAListCatchesErrors1() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        test.createDatabase();
        List<String> givenList = test.showDatabaseAsAList();
        assertEquals("[]", givenList.toString());
        test.removeDatabase();
    }
    
    @Test
    public void databaseAsAListCatchesErrors2() throws Exception {
        DatabaseInterface test = new NameDatabase("Test");
        List<String> givenList = test.showDatabaseAsAList();
        assertEquals("[]", givenList.toString());
    }
    
}
