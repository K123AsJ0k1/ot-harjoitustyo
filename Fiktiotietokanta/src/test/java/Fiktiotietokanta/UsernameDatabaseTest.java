/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import dao.UsernameDatabase;
import domain.FileManagerInterface;
import domain.UsernameInterface;
import filelogic.FileManager;
import java.io.File;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author niila
 */
public class UsernameDatabaseTest {
    
    //Constructor tests
    
    @Test
    public void norModeWorks() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Normal","UsernameDatabase");
        String name = "UsernameDatabase:connection";
        String path = "jdbc:sqlite:"+dirCreator.getDirectoryPath() + File.separator + name;
        assertEquals(path, test.getConnectionString());
    }
    
    @Test
    public void testModeWorks() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        String name = "UsernameDatabaseTest:connection";
        String path = "jdbc:sqlite:"+dirCreator.getDirectoryPath() + File.separator + name;
        assertEquals(path, test.getConnectionString());
    }
    
    
    @Test
    public void dataBaseExists(){
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        assertEquals(false, test.usernameDatabaseExists());
    }
    // Create database tests
    @Test
    public void createDatabase() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        boolean isCreated = test.createUsernameDatabase();
        assertEquals(true, isCreated);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void createDatabaseCatchesErrors() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        boolean isCreated = test.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean cantBeCreatedTwice = test.createUsernameDatabase();
        assertEquals(false, cantBeCreatedTwice);
        test.removeUsernameDatabase();
    }
    //Remove database tests
    @Test
    public void removeDatabaseWorks() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        Boolean isRemoved = test.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    } 
    
    @Test
    public void removeDatabaseCatchesErrors1() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        Boolean nonExistingDatabaseIsntRemoved = test.removeUsernameDatabase();
        assertEquals(false, nonExistingDatabaseIsntRemoved);
    }
    
    @Test
    public void removeDatabaseCatchesErrors2() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        Boolean isRemoved = test.removeUsernameDatabase();
        assertEquals(true, isRemoved);
        Boolean databaseCantBeRemoveTwice = test.removeUsernameDatabase();
        assertEquals(false, databaseCantBeRemoveTwice);
    }
    
    //Add username tests
    
    @Test
    public void usernameCanBeAdded() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        Boolean isAdded = test.addUserInformation("Test", "Test", "Test");
        assertEquals(true, isAdded);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void addUsernameCatchesErrors1() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        Boolean isAdded = test.addUserInformation("Test", "Test", "Test");
        assertEquals(true, isAdded);
        Boolean sameNameIsntAdded = test.addUserInformation("Test", "Test1", "Test");
        assertEquals(false, sameNameIsntAdded);
        Boolean samePasswordIsntAdded = test.addUserInformation("Test1", "Test", "Test");
        assertEquals(false, samePasswordIsntAdded);
        Boolean sameUsernameIsntAdded = test.addUserInformation("Test", "Test", "Test");
        assertEquals(false, sameUsernameIsntAdded);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void addUsernameCatchesErrors2(){
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        Boolean usernameCantBeAddedIntoNoExistingDatabase = test.addUserInformation("Test", "Test", "Test");
        assertEquals(false, usernameCantBeAddedIntoNoExistingDatabase);
    }
    
    // searchUserInformation tests
    @Test
    public void searchUserInfoWorks() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test", "Test", "Test");
        Boolean isFound = test.searchUserInformation("Test");
        assertEquals(true,isFound);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserInfoIsCorrect() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1", "Test");
        test.addUserInformation("Test2", "Test2", "Test");
        test.addUserInformation("Test3", "Test3", "Test");
        Boolean isFound = test.searchUserInformation("Test2");
        assertEquals(true,isFound);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserInfoCatchesErrors1() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1", "Test");
        test.addUserInformation("Test2", "Test2", "Test");
        test.addUserInformation("Test3", "Test3", "Test");
        Boolean nonExistingUsernameIsntFound = test.searchUserInformation("Test4");
        assertEquals(false,nonExistingUsernameIsntFound);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserInfoCatchesErrors2() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        Boolean searchDoesntWorkOnNonExistingDatabase = test.searchUserInformation("Test");
        assertEquals(false,searchDoesntWorkOnNonExistingDatabase);
    }
    
    //Remove username tests
    
    @Test
    public void removeUsernameWorks() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test", "Test", "Test");
        Boolean isRemoved = test.removeUserInformation("Test");
        assertEquals(true, isRemoved);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void removeUsernameIsCorrect() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1", "Test");
        test.addUserInformation("Test2", "Test2", "Test");
        test.addUserInformation("Test3", "Test3", "Test");
        Boolean correctInformationIsRemoved = test.removeUserInformation("Test2");
        assertEquals(true, correctInformationIsRemoved);
        Boolean doesExist1 = test.searchUserInformation("Test1");
        Boolean doesExist2 = test.searchUserInformation("Test3");
        assertEquals(true, doesExist1);
        assertEquals(true, doesExist2);
        test.removeUsernameDatabase();
    }
    
    
    @Test
    public void removeUsernameCatchesErrors1() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        Boolean removeDoesntWorkOnANonExistingDatabase = test.removeUserInformation("Test");
        assertEquals(false, removeDoesntWorkOnANonExistingDatabase);     
    }
    
    //SearchUserIdInformation tests
    
    @Test
    public void searchUserIdWorks() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test", "Test", "Test");
        Integer givenId = test.searchUsernameId("Test");
        assertEquals(1, givenId.intValue());
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserIdIsCorrect() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1", "Test");
        test.addUserInformation("Test2", "Test2", "Test");
        test.addUserInformation("Test3", "Test3", "Test");
        Integer givenId1 = test.searchUsernameId("Test1");
        Integer givenId2 = test.searchUsernameId("Test2");
        Integer givenId3 = test.searchUsernameId("Test3");
        assertEquals(1, givenId1.intValue());
        assertEquals(2, givenId2.intValue());
        assertEquals(3, givenId3.intValue());
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserIdCatchesError1(){
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        Integer givenIdIsZeroWhenUserDoesntExist = test.searchUsernameId("Test");
        assertEquals(0, givenIdIsZeroWhenUserDoesntExist.intValue());
        test.removeUsernameDatabase();
    }
    
    @Test
    public void searchUserIdCatchesError2() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        Integer givenIdIsZero = test.searchUsernameId("Test");
        assertEquals(0, givenIdIsZero.intValue());
    }
    
    @Test
    public void searchUserIdCatchesError3() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1", "Test");
        test.addUserInformation("Test2", "Test2", "Test");
        test.addUserInformation("Test3", "Test3", "Test");
        Integer givenIdIsZero = test.searchUsernameId("Test4");
        assertEquals(0, givenIdIsZero.intValue());
        test.removeUsernameDatabase();
    }
    
    //UserPasswordCheck tests
    
    @Test
    public void userPasswordCheckWorks() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test", "Test", "Test");
        Boolean checkWorks = test.userPasswordCheck("Test", "Test");
        assertEquals(true, checkWorks);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void userPasswordCheckIsCorrect() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1", "Test");
        test.addUserInformation("Test2", "Test2", "Test");
        test.addUserInformation("Test3", "Test3", "Test");
        Boolean checkWorks1 = test.userPasswordCheck("Test1", "Test1");
        Boolean checkWorks2 = test.userPasswordCheck("Test2", "Test2");
        Boolean checkWorks3 = test.userPasswordCheck("Test3", "Test3");
        assertEquals(true, checkWorks1);
        assertEquals(true, checkWorks2);
        assertEquals(true, checkWorks3);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void userPasswordCatchesErros1() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1", "Test");
        test.addUserInformation("Test2", "Test2", "Test");
        test.addUserInformation("Test3", "Test3", "Test");
        Boolean noExistingUsername = test.userPasswordCheck("Test4", "Test4");
        assertEquals(false, noExistingUsername);
        test.removeUsernameDatabase();
    }
    
    @Test
    public void userPasswordCatchesErrors2() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        Boolean checkDoesntWorkOnNonExistingDatabase = test.userPasswordCheck("Test", "Test");
        assertEquals(false, checkDoesntWorkOnNonExistingDatabase);
    }
    
    @Test
    public void userPasswordCatchesErrors3() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test","Test", "Test");
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
    
    // searchUsername Tests
    
    @Test
    public void searchUserPrivilage() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test","Test", "Test");
        String givenPrivilage = test.searchUsernamePrivilage("Test");
        assertEquals("Test", givenPrivilage);
        test.removeUsernameDatabase();
    }
    @Test
    public void searchUserPrivilageIsCorrect() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test1","Test1", "Test1");
        test.addUserInformation("Test2","Test2", "Test2");
        test.addUserInformation("Test3","Test3", "Test3");
        String givenPrivilage1 = test.searchUsernamePrivilage("Test1");
        assertEquals("Test1", givenPrivilage1);
        String givenPrivilage2 = test.searchUsernamePrivilage("Test2");
        assertEquals("Test2", givenPrivilage2);
        String givenPrivilage3 = test.searchUsernamePrivilage("Test3");
        assertEquals("Test3", givenPrivilage3);
        test.removeUsernameDatabase();
    }
    @Test
    public void searchUserPrivilageErrors1() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test","Test", "Test");
        String isNotFound = test.searchUsernamePrivilage("Test2");
        assertEquals("null", isNotFound); 
        test.removeUsernameDatabase();
    }
    @Test
    public void searchUserPrivilageErrors2() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        String isNotFound = test.searchUsernamePrivilage("Test");
        assertEquals("null", isNotFound); 
    }
    
    // Show database as a list tests
    
    @Test
    public void databaseAsAListWorks() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test", "Test", "Test");
        List<String> givenList = test.showDatabaseAsAList();
        assertEquals("1/Test/Test", givenList.get(0));
        test.removeUsernameDatabase();
    }
    
    @Test
    public void databaseAsAListIsCorrect() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        test.addUserInformation("Test1", "Test1", "Test1");
        test.addUserInformation("Test2", "Test2", "Test2");
        test.addUserInformation("Test3", "Test3", "Test3");
        List<String> givenList = test.showDatabaseAsAList();
        assertEquals("1/Test1/Test1", givenList.get(0));
        assertEquals("2/Test2/Test2", givenList.get(1));
        assertEquals("3/Test3/Test3", givenList.get(2));
        test.removeUsernameDatabase();
    }
    
    @Test
    public void databaseAsAListCatchesErrors1() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        test.createUsernameDatabase();
        List<String> noList = test.showDatabaseAsAList();
        assertEquals("[]",noList.toString());
        test.removeUsernameDatabase();
    }
    
    @Test
    public void databaseAsAListCatchesErrors2() {
        FileManagerInterface dirCreator = new FileManager();
        dirCreator.createStandardDirectory();
        UsernameInterface test = new UsernameDatabase(dirCreator,"Test","UsernameDatabase");
        List<String> noList = test.showDatabaseAsAList();
        assertEquals("[]",noList.toString());
        test.removeUsernameDatabase();
    }
    
    
    
    
    
    
     
}
