/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import Fiktiotietokanta.domain.UsernameDatabase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Fiktiotietokanta.dao.UsernameInterface;

/**
 *
 * @author niila
 */
public class usernameDatabaseTest {
    
    @Test
    public void constructorWorks() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean doesntExist = databaseTest.usernameDatabaseExists();
        assertEquals(false, doesntExist);
    }
    
    @Test
    public void usernameDatabaseIsCreated() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        databaseTest.removeUsernameDatabase();
    }
    
    @Test
    public void usernameDatabaseCantBeCreatedTwice() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated1 = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated1);
        boolean isCreated2 = databaseTest.createUsernameDatabase();
        assertEquals(false, isCreated2);
        databaseTest.removeUsernameDatabase();
    }
    
    @Test
    public void usernameDatabaseIsRemoved() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void usernameDatabaseIsntRemovedTwice() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isRemoved1 = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved1);
        boolean isRemoved2 = databaseTest.removeUsernameDatabase();
        assertEquals(false, isRemoved2);
    }
    
    @Test
    public void noExistantUsernameDatabaseIsntRemoved() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isRemoved1 = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved1);
        boolean isRemoved2 = databaseTest.removeUsernameDatabase();
        assertEquals(false, isRemoved2);
    }
    
    @Test
    public void usernameCanBeAdded() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isntRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(false, isntRemoved);      
    }
    
    @Test
    public void duplicatesCantBeAdded() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addUserInformation("Test");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addUserInformation("Test");
        assertEquals(false, isAdded2);
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void usernameCantBeAddedIntoNoExistingDatabase() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isntAdded = databaseTest.addUserInformation("Test");
        assertEquals(false, isntAdded);
    }
    
    @Test
    public void usernameIsFound() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addUserInformation("Test");
        assertEquals(true, isAdded);
        boolean isFound = databaseTest.searchUserInformation("Test");
        assertEquals(true, isFound);
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void correctUsernameIsFound() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addUserInformation("Test1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addUserInformation("Test2");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addUserInformation("Test3");
        assertEquals(true, isAdded3);
        boolean isFound = databaseTest.searchUserInformation("Test2");
        assertEquals(true, isFound);
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void noAddedUsernameIsntFound() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addUserInformation("Test1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addUserInformation("Test2");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addUserInformation("Test3");
        assertEquals(true, isAdded3);
        boolean isntFound = databaseTest.searchUserInformation("Test4");
        assertEquals(false, isntFound);
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void usernameIdSearchWorks() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addUserInformation("Test");
        assertEquals(true, isAdded);        
        boolean isFound = databaseTest.searchUserInformation("Test");
        assertEquals(true, isFound);
        Integer id = databaseTest.searchUsernameId("Test");
        assertEquals(1, id.intValue());
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void correctUsernameIdIsFound() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addUserInformation("Test1");
        assertEquals(true, isAdded1);        
        boolean isFound1 = databaseTest.searchUserInformation("Test1");
        assertEquals(true, isFound1);
        boolean isAdded2 = databaseTest.addUserInformation("Test2");
        assertEquals(true, isAdded2);        
        boolean isFound2 = databaseTest.searchUserInformation("Test2");
        assertEquals(true, isFound2);
        boolean isAdded3 = databaseTest.addUserInformation("Test3");
        assertEquals(true, isAdded3);        
        boolean isFound3 = databaseTest.searchUserInformation("Test3");
        assertEquals(true, isFound3);
        Integer id = databaseTest.searchUsernameId("Test2");
        assertEquals(2, id.intValue());
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void searchDoesntWorkOnNoExistingDatabase() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        Boolean doesntWork = databaseTest.searchUserInformation("Test");
        assertEquals(false, doesntWork);
    }
    
    @Test
    public void allUsernameIdsAreCorrect() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addUserInformation("Test1");
        assertEquals(true, isAdded1);        
        boolean isFound1 = databaseTest.searchUserInformation("Test1");
        assertEquals(true, isFound1);
        boolean isAdded2 = databaseTest.addUserInformation("Test2");
        assertEquals(true, isAdded2);        
        boolean isFound2 = databaseTest.searchUserInformation("Test2");
        assertEquals(true, isFound2);
        boolean isAdded3 = databaseTest.addUserInformation("Test3");
        assertEquals(true, isAdded3);        
        boolean isFound3 = databaseTest.searchUserInformation("Test3");
        assertEquals(true, isFound3);
        Integer id1 = databaseTest.searchUsernameId("Test1");
        assertEquals(1, id1.intValue());
        Integer id2 = databaseTest.searchUsernameId("Test2");
        assertEquals(2, id2.intValue());
        Integer id3 = databaseTest.searchUsernameId("Test3");
        assertEquals(3, id3.intValue());
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void noExistingUsernameIdIsZero() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        Integer noId = databaseTest.searchUsernameId("Test1");
        assertEquals(0, noId.intValue());
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void noExistingUsernameDoesntHaveId() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addUserInformation("Test1");
        assertEquals(true, isAdded1);        
        boolean isFound1 = databaseTest.searchUserInformation("Test1");
        assertEquals(true, isFound1);
        boolean isAdded2 = databaseTest.addUserInformation("Test2");
        assertEquals(true, isAdded2);        
        boolean isFound2 = databaseTest.searchUserInformation("Test2");
        assertEquals(true, isFound2);
        boolean isAdded3 = databaseTest.addUserInformation("Test3");
        assertEquals(true, isAdded3);        
        boolean isFound3 = databaseTest.searchUserInformation("Test3");
        assertEquals(true, isFound3);
        Integer noId = databaseTest.searchUsernameId("Test");
        assertEquals(0, noId.intValue());
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void idSearchDoesntWorkOnNoExistingDatabase() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        Integer isntFound = databaseTest.searchUsernameId("Test");
        assertEquals(0, isntFound.intValue());
    }
    
    @Test
    public void usernameInformationRemovalWorks() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addUserInformation("Test");
        assertEquals(true, isAdded);
        boolean isFound = databaseTest.searchUserInformation("Test");
        assertEquals(true, isFound);
        boolean remove = databaseTest.removeUserInformation("Test");
        assertEquals(true, remove);
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void usernameInformationIsActuallyRemoved() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addUserInformation("Test");
        assertEquals(true, isAdded);
        boolean isFound = databaseTest.searchUserInformation("Test");
        assertEquals(true, isFound);
        Integer id = databaseTest.searchUsernameId("Test");
        assertEquals(1, id.intValue());
        boolean remove = databaseTest.removeUserInformation("Test");
        assertEquals(true, remove);
        boolean exists = databaseTest.searchUserInformation("Test");
        assertEquals(false, exists);
        Integer removedId = databaseTest.searchUsernameId("Test");
        assertEquals(0, removedId.intValue());
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void correctUsernameIsRemoved() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        boolean isCreated = databaseTest.createUsernameDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addUserInformation("Test1");
        assertEquals(true, isAdded1);
        boolean isFound1 = databaseTest.searchUserInformation("Test1");
        assertEquals(true, isFound1);
        Integer id1 = databaseTest.searchUsernameId("Test1");
        assertEquals(1, id1.intValue());
        boolean isAdded2 = databaseTest.addUserInformation("Test2");
        assertEquals(true, isAdded2);
        boolean isFound2 = databaseTest.searchUserInformation("Test2");
        assertEquals(true, isFound2);
        Integer id2 = databaseTest.searchUsernameId("Test2");
        assertEquals(2, id2.intValue());
        boolean isAdded3 = databaseTest.addUserInformation("Test3");
        assertEquals(true, isAdded3);
        boolean isFound3 = databaseTest.searchUserInformation("Test3");
        assertEquals(true, isFound3);
        Integer id3 = databaseTest.searchUsernameId("Test3");
        assertEquals(3, id3.intValue());     
        boolean remove = databaseTest.removeUserInformation("Test2");
        assertEquals(true, remove);
        boolean exists = databaseTest.searchUserInformation("Test2");
        assertEquals(false, exists);
        Integer idReCheck1 = databaseTest.searchUsernameId("Test1");
        assertEquals(1, idReCheck1.intValue());
        Integer idReCheck2 = databaseTest.searchUsernameId("Test2");
        assertEquals(0, idReCheck2.intValue());
        Integer idReCheck3 = databaseTest.searchUsernameId("Test3");
        assertEquals(3, idReCheck3.intValue());       
        boolean isRemoved = databaseTest.removeUsernameDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void removalDoesntWorkWhenDatabaseDoesntExist() throws Exception {
        UsernameInterface databaseTest = new UsernameDatabase();
        Boolean doesntRemove = databaseTest.removeUserInformation("Test");
        assertEquals(false, doesntRemove);
    }
    
    
    
    
    
}
