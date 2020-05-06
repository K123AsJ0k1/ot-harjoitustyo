/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import dao.AbilityDatabase;
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
        Boolean tooShort = test.searchInformation("1/1/1/1/1");
        assertEquals(false, tooShort);
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationCatchesErrors2() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean tooLong = test.searchInformation("1/1/1/1/1/1/1");
        assertEquals(false, tooLong);
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationCatchesErrors3() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        Boolean wrongString = test.searchInformation("1/1/g/1/1/1");
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
    
    //SearchInformationid tests
    
    @Test
    public void searchInformationIdWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Integer givenId = test.searchInfromationId("1/1/1/1/1/1");
        assertEquals(1, givenId.intValue());
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationIdIsCorrect() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        test.addInformation("2/2/2/2/2/2");
        test.addInformation("3/3/3/3/3/3");
        Integer givenId1 = test.searchInfromationId("1/1/1/1/1/1");
        Integer givenId2 = test.searchInfromationId("2/2/2/2/2/2");
        Integer givenId3 = test.searchInfromationId("3/3/3/3/3/3");
        assertEquals(1, givenId1.intValue());
        assertEquals(2, givenId2.intValue());
        assertEquals(3, givenId3.intValue());
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationInfoIsntFound() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Integer givenIdIsZero = test.searchInfromationId("1/1/1/1/1/2");
        assertEquals(0, givenIdIsZero.intValue());
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationIdCatchesErrors1() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Integer givenStringIstooShort = test.searchInfromationId("1/1/1/1/1");
        assertEquals(0, givenStringIstooShort.intValue());
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationIdCatchesErrors2() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Integer givenStringIstooLong = test.searchInfromationId("1/1/1/1/1/1/1");
        assertEquals(0, givenStringIstooLong.intValue());
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationIdCatchesErrors3() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Integer givenStringIsWrong = test.searchInfromationId("1/1/g/1/1/1");
        assertEquals(0, givenStringIsWrong.intValue());
        test.removeDatabase();
    }
    
    @Test
    public void searchInformationIdCatchesErrors4() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        Integer idCantBeSearchedFromNonExistingDatabase = test.searchInfromationId("1/1/g/1/1/1");
        assertEquals(0, idCantBeSearchedFromNonExistingDatabase.intValue());
        test.removeDatabase();
    }
    
    //SearchIdTextIdentity tests
    
    @Test
    public void giveIdIdentityWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        Integer givenId = test.searchInfromationId("1/1/1/1/1/1");
        String givenIdentity = test.searchInformationTextIdentity(String.valueOf(givenId));
        assertEquals("1/1/1/1/1/1", givenIdentity);
        test.removeDatabase();
    }
    
    @Test
    public void givenIdIdentityIsCorrect() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        test.addInformation("2/2/2/2/2/2");
        test.addInformation("3/3/3/3/3/3");
        Integer givenId1 = test.searchInfromationId("1/1/1/1/1/1");
        Integer givenId2 = test.searchInfromationId("2/2/2/2/2/2");
        Integer givenId3 = test.searchInfromationId("3/3/3/3/3/3");
        String givenIdentity1 = test.searchInformationTextIdentity(String.valueOf(givenId1));
        String givenIdentity2 = test.searchInformationTextIdentity(String.valueOf(givenId2));
        String givenIdentity3 = test.searchInformationTextIdentity(String.valueOf(givenId3));
        assertEquals("1/1/1/1/1/1", givenIdentity1);
        assertEquals("2/2/2/2/2/2", givenIdentity2);
        assertEquals("3/3/3/3/3/3", givenIdentity3);
        test.removeDatabase();
    }
    
    @Test
    public void givenIdIdentityCatchesErrors1() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        String givenIdIsntANumber = test.searchInformationTextIdentity("!");
        assertEquals("null", givenIdIsntANumber);
        test.removeDatabase();
    }
    
    @Test
    public void givenIdIdentityCatchesErrors2() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        String givenIdDoesntExist = test.searchInformationTextIdentity("1");
        assertEquals("null", givenIdDoesntExist);
        test.removeDatabase();
    }
    
    @Test
    public void givenIdIdentityCatchesErrors3() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        String searchDoesntWorkOnANonExistingDatabase = test.searchInformationTextIdentity("1");
        assertEquals("null", searchDoesntWorkOnANonExistingDatabase);
        test.removeDatabase();
    }
    
    //ShowDatabaseAsAList tests
    
    @Test
    public void databaseAsAListWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        List<String> givenList = test.showDatabaseAsAList();
        assertEquals("1/1/1/1/1/1", givenList.get(0));
        test.removeDatabase();
    }
    
    @Test
    public void databaseAsAListIsCorrect() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        test.addInformation("2/2/2/2/2/2");
        test.addInformation("3/3/3/3/3/3");
        List<String> givenList = test.showDatabaseAsAList();
        assertEquals("1/1/1/1/1/1", givenList.get(0));
        assertEquals("2/2/2/2/2/2", givenList.get(1));
        assertEquals("3/3/3/3/3/3", givenList.get(2));
        test.removeDatabase();
    }
    
    @Test
    public void databaseAsAListCatchesErrors1() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        List<String> givenList = test.showDatabaseAsAList();
        assertEquals("[]", givenList.toString());
        test.removeDatabase();
    }
    
    @Test
    public void databaseAsAListCatchesErrors2() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        List<String> givenList = test.showDatabaseAsAList();
        assertEquals("[]", givenList.toString());
    }
    
    //ShowDatabaseAsARestrictedList tests
    
    @Test
    public void databaseAsARestrictedListWorks() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        List<String> givenList = test.showDatabaseAsARestrictedList("1");
        assertEquals("1/1/1/1/1", givenList.get(0));
        test.removeDatabase();
    }
    
    @Test
    public void databaseAsARestrictedListIsCorrect() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        test.addInformation("2/2/2/2/2/2");
        test.addInformation("3/3/3/3/3/3");
        List<String> givenList1 = test.showDatabaseAsARestrictedList("1");
        List<String> givenList2 = test.showDatabaseAsARestrictedList("2");
        List<String> givenList3 = test.showDatabaseAsARestrictedList("3");
        assertEquals("1/1/1/1/1", givenList1.get(0));
        assertEquals("2/2/2/2/2", givenList2.get(0));
        assertEquals("3/3/3/3/3", givenList3.get(0));
        test.removeDatabase();
    }
    
    @Test
    public void databaseAsARestrictedListCatchesErrors1() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        List<String> givenIdIsWrong = test.showDatabaseAsARestrictedList("2");
        assertEquals("[]", givenIdIsWrong.toString());
        test.removeDatabase();
    }
    
    @Test
    public void databaseAsARestrictedListCatchesErrors2() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        test.createDatabase();
        test.addInformation("1/1/1/1/1/1");
        List<String> givenIdIsWrong = test.showDatabaseAsARestrictedList("!");
        assertEquals("[]", givenIdIsWrong.toString());
        test.removeDatabase();
    }
    
    @Test
    public void databaseAsARestrictedListCatchesErrors3() throws Exception {
        DatabaseInterface test = new AbilityDatabase("Test");
        List<String> databaseDoesntExist = test.showDatabaseAsARestrictedList("!");
        assertEquals("[]", databaseDoesntExist.toString());
    }
    
}
