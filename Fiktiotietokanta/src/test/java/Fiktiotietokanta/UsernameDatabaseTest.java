/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import dao.UsernameDatabase;
import domain.UsernameInterface;
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
public class UsernameDatabaseTest {
    
    //Constructor tests
    @Test
    public void normalModeWorks() throws Exception {
        UsernameInterface test = new UsernameDatabase("Normal");
        assertEquals("jdbc:sqlite:usernamedatabase:connection",test.getConnectionString());
    }
    
    @Test
    public void testModeWorks() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        assertEquals("jdbc:sqlite:usernamedatabasetest:connection",test.getConnectionString());
    }
    
    @Test
    public void getDatabaseExistWorks() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        assertEquals(false, test.usernameDatabaseExists());
    }
    // Create database tests
    @Test
    public void createDatabaseWorks() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        boolean isCreated = test.createUsernameDatabase();
        assertEquals(true, isCreated);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void createDatabaseCatchesErrors() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        boolean isCreated = test.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean cantBeCreatedTwice = test.createUsernameDatabase();
        assertEquals(false, cantBeCreatedTwice);
        test.removeUsernameDatabase();
    }
    //Remove database tests
    @Test
    public void removeDatabaseWorks() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        Boolean isRemoved = test.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    } 
    
    @Test
    public void removeDatabaseCatchesErrors1() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        Boolean nonExistingDatabaseIsntRemoved = test.removeUsernameDatabase();
        assertEquals(false, nonExistingDatabaseIsntRemoved);
    }
    
    @Test
    public void removeDatabaseCatchesErrors2() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        Boolean isRemoved = test.removeUsernameDatabase();
        assertEquals(true, isRemoved);
        Boolean databaseCantBeRemoveTwice = test.removeUsernameDatabase();
        assertEquals(false, databaseCantBeRemoveTwice);
    }
    
    //Add username tests
    
    @Test
    public void usernameCanBeAdded() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        Boolean isAdded = test.addUserInformation("Test", "Test");
        assertEquals(true, isAdded);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void addUsernameCatchesErrors1() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        Boolean isAdded = test.addUserInformation("Test", "Test");
        assertEquals(true, isAdded);
        Boolean sameNameIsntAdded = test.addUserInformation("Test", "Test1");
        assertEquals(false, sameNameIsntAdded);
        Boolean samePasswordIsntAdded = test.addUserInformation("Test1", "Test");
        assertEquals(false, samePasswordIsntAdded);
        Boolean sameUsernameIsntAdded = test.addUserInformation("Test", "Test");
        assertEquals(false, sameUsernameIsntAdded);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void addUsernameCatchesErrors2() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        Boolean usernameCantBeAddedIntoNoExistingDatabase = test.addUserInformation("Test", "Test");
        assertEquals(false, usernameCantBeAddedIntoNoExistingDatabase);
    }
    
    // searchUserInformation tests
    @Test
    public void searchUserInfoWorks() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test", "Test");
        Boolean isFound = test.searchUserInformation("Test");
        assertEquals(true,isFound);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserInfoIsCorrect() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1");
        test.addUserInformation("Test2", "Test2");
        test.addUserInformation("Test3", "Test3");
        Boolean isFound = test.searchUserInformation("Test2");
        assertEquals(true,isFound);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserInfoCatchesErrors1() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1");
        test.addUserInformation("Test2", "Test2");
        test.addUserInformation("Test3", "Test3");
        Boolean nonExistingUsernameIsntFound = test.searchUserInformation("Test4");
        assertEquals(false,nonExistingUsernameIsntFound);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserInfoCatchesErrors2() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        Boolean searchDoesntWorkOnNonExistingDatabase = test.searchUserInformation("Test");
        assertEquals(false,searchDoesntWorkOnNonExistingDatabase);
    }
    
    //Remove username tests
    
    @Test
    public void removeUsernameWorks() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test", "Test");
        Boolean isRemoved = test.removeUserInformation("Test");
        assertEquals(true, isRemoved);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void removeUsernameIsCorrect() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1");
        test.addUserInformation("Test2", "Test2");
        test.addUserInformation("Test3", "Test3");
        Boolean correctInformationIsRemoved = test.removeUserInformation("Test2");
        assertEquals(true, correctInformationIsRemoved);
        Boolean doesExist1 = test.searchUserInformation("Test1");
        Boolean doesExist2 = test.searchUserInformation("Test3");
        assertEquals(true, doesExist1);
        assertEquals(true, doesExist2);
        test.removeUsernameDatabase();
    }
    
    
    @Test
    public void removeUsernameCatchesErrors1() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        Boolean removeDoesntWorkOnANonExistingDatabase = test.removeUserInformation("Test");
        assertEquals(false, removeDoesntWorkOnANonExistingDatabase);     
    }
    
    //SearchUserIdInformation tests
    
    @Test
    public void searchUserIdWorks() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test", "Test");
        Integer givenId = test.searchUsernameId("Test");
        assertEquals(1, givenId.intValue());
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserIdIsCorrect() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1");
        test.addUserInformation("Test2", "Test2");
        test.addUserInformation("Test3", "Test3");
        Integer givenId1 = test.searchUsernameId("Test1");
        Integer givenId2 = test.searchUsernameId("Test2");
        Integer givenId3 = test.searchUsernameId("Test3");
        assertEquals(1, givenId1.intValue());
        assertEquals(2, givenId2.intValue());
        assertEquals(3, givenId3.intValue());
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserIdCatchesError1() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        Integer givenIdIsZeroWhenUserDoesntExist = test.searchUsernameId("Test");
        assertEquals(0, givenIdIsZeroWhenUserDoesntExist.intValue());
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserIdCatchesError2() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        Integer givenIdIsZero = test.searchUsernameId("Test");
        assertEquals(0, givenIdIsZero.intValue());
    }
    
    @Test
    public void searchUserIdCatchesError3() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1");
        test.addUserInformation("Test2", "Test2");
        test.addUserInformation("Test3", "Test3");
        Integer givenIdIsZero = test.searchUsernameId("Test4");
        assertEquals(0, givenIdIsZero.intValue());
        test.removeUsernameDatabase();
    }
    
    //UserPasswordCheck tests
    
    @Test
    public void userPasswordCheckWorks() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test", "Test");
        Boolean checkWorks = test.userPasswordCheck("Test", "Test");
        assertEquals(true, checkWorks);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void userPasswordCheckIsCorrect() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1");
        test.addUserInformation("Test2", "Test2");
        test.addUserInformation("Test3", "Test3");
        Boolean checkWorks1 = test.userPasswordCheck("Test1", "Test1");
        Boolean checkWorks2 = test.userPasswordCheck("Test2", "Test2");
        Boolean checkWorks3 = test.userPasswordCheck("Test3", "Test3");
        assertEquals(true, checkWorks1);
        assertEquals(true, checkWorks2);
        assertEquals(true, checkWorks3);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void userPasswordCatchesErros1() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1");
        test.addUserInformation("Test2", "Test2");
        test.addUserInformation("Test3", "Test3");
        Boolean noExistingUsername = test.userPasswordCheck("Test4", "Test4");
        assertEquals(false, noExistingUsername);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void userPasswordCatchesErrors2() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        Boolean checkDoesntWorkOnNonExistingDatabase = test.userPasswordCheck("Test", "Test");
        assertEquals(false, checkDoesntWorkOnNonExistingDatabase);
    }
    
    @Test
    public void userPasswordCatchesErrors3() throws Exception {
        UsernameInterface test = new UsernameDatabase("Test");
        test.createUsernameDatabase();
        test.addUserInformation("Test","Test");
        Boolean correctUsernameCheck = test.userPasswordCheck("Test","Test");
        Boolean wrongNameCheck = test.userPasswordCheck("Test1","Test");
        Boolean wrongPasswordCheck = test.userPasswordCheck("Test","Test1");
        Boolean wrongUsernameCheck = test.userPasswordCheck("Test1","Test1");
        assertEquals(true, correctUsernameCheck);
        assertEquals(false, wrongNameCheck);
        assertEquals(false, wrongPasswordCheck);
        assertEquals(false, wrongUsernameCheck);
        test.removeUsernameDatabase();
    }
    
    
    
    
    
     
    
    
    
}