/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Fiktiotietokanta.domain.UsernameDatabase;
import java.sql.SQLException;

/**
 *
 * @author niila
 */
public class UsernameDatabaseTest {

    

    /*
    public UsernameDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
     */
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void databaseExists() throws Exception {
        UsernameDatabase databaseTest = new UsernameDatabase();
        Boolean doesExist = databaseTest.getDatabase();
        assertEquals(true, doesExist);
        Boolean isRemoved = databaseTest.removeDatabase();
    }
    
    @Test
    public void databaseIsRemoved() throws Exception {
        UsernameDatabase databaseTest = new UsernameDatabase();
        Boolean doesExist = databaseTest.getDatabase();
        assertEquals(true, doesExist);
        Boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void usernameIsAddedIntoDatabase () throws Exception {
        UsernameDatabase databaseTest = new UsernameDatabase();
        Boolean doesExist = databaseTest.getDatabase();
        assertEquals(true, doesExist);
        Boolean isAdded = databaseTest.addUsernameIntoDatabase("Test");
        assertEquals(true, isAdded);
        Boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void usernameIsFound () throws Exception {
        UsernameDatabase databaseTest = new UsernameDatabase();
        Boolean doesExist = databaseTest.getDatabase();
        assertEquals(true, doesExist);
        Boolean isAdded = databaseTest.addUsernameIntoDatabase("Test");
        assertEquals(true, isAdded);
        Boolean isFound = databaseTest.searchForAnExistingUsername("Test");
        assertEquals(true, isFound);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void correctUserNameIsFound () throws Exception {
        UsernameDatabase databaseTest = new UsernameDatabase();
        Boolean doesExist = databaseTest.getDatabase();
        assertEquals(true, doesExist);
        Boolean isAdded1 = databaseTest.addUsernameIntoDatabase("Test1");
        assertEquals(true, isAdded1);
        Boolean isAdded2 = databaseTest.addUsernameIntoDatabase("Test2");
        assertEquals(true, isAdded2);
        Boolean isAdded3 = databaseTest.addUsernameIntoDatabase("Test3");
        assertEquals(true, isAdded3);
        Boolean isFound = databaseTest.searchForAnExistingUsername("Test2");
        assertEquals(true, isFound);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void noExistingUsernameIsntFound() throws Exception {
        UsernameDatabase databaseTest = new UsernameDatabase();
        Boolean doesExist = databaseTest.getDatabase();
        assertEquals(true, doesExist);
        Boolean isAdded1 = databaseTest.addUsernameIntoDatabase("Test1");
        assertEquals(true, isAdded1);
        Boolean isAdded2 = databaseTest.addUsernameIntoDatabase("Test2");
        assertEquals(true, isAdded2);
        Boolean isAdded3 = databaseTest.addUsernameIntoDatabase("Test3");
        assertEquals(true, isAdded3);
        Boolean isFound = databaseTest.searchForAnExistingUsername("Test4");
        assertEquals(false, isFound);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void getUsernameIdWorks()  throws Exception {
        UsernameDatabase databaseTest = new UsernameDatabase();
        Boolean doesExist = databaseTest.getDatabase();
        assertEquals(true, doesExist);
        Boolean isAdded = databaseTest.addUsernameIntoDatabase("Test");
        assertEquals(true, isAdded);
        Integer getId = databaseTest.getSearchedUsernameId("Test");
        assertEquals(1, getId.intValue());
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test 
    public void correctUsernameIdIsFound() throws Exception {
        UsernameDatabase databaseTest = new UsernameDatabase();
        Boolean doesExist = databaseTest.getDatabase();
        assertEquals(true, doesExist);
        Boolean isAdded1 = databaseTest.addUsernameIntoDatabase("Test1");
        assertEquals(true, isAdded1);
        Integer getId1 = databaseTest.getSearchedUsernameId("Test1");
        assertEquals(1, getId1.intValue());
        Boolean isAdded2 = databaseTest.addUsernameIntoDatabase("Test2");
        assertEquals(true, isAdded2);
        Integer getId2 = databaseTest.getSearchedUsernameId("Test2");
        assertEquals(2, getId2.intValue());
        Boolean isAdded3 = databaseTest.addUsernameIntoDatabase("Test3");
        assertEquals(true, isAdded3);
        Integer getId3 = databaseTest.getSearchedUsernameId("Test3");
        assertEquals(3, getId3.intValue());
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void noExistingUsernameIdWorks() throws Exception {
        UsernameDatabase databaseTest = new UsernameDatabase();
        Boolean doesExist = databaseTest.getDatabase();
        assertEquals(true, doesExist);
        Integer doesntExist = databaseTest.getSearchedUsernameId("Test");
        assertEquals(0, doesntExist.intValue());       
        Boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);
    } 
    
    @Test
    public void noExistingUsernameIdIsntFound() throws Exception {
        UsernameDatabase databaseTest = new UsernameDatabase();
        Boolean doesExist = databaseTest.getDatabase();
        assertEquals(true, doesExist);
        Boolean isAdded1 = databaseTest.addUsernameIntoDatabase("Test1");
        assertEquals(true, isAdded1);
        Integer getId1 = databaseTest.getSearchedUsernameId("Test1");
        assertEquals(1, getId1.intValue());
        Boolean isAdded2 = databaseTest.addUsernameIntoDatabase("Test2");
        assertEquals(true, isAdded2);
        Integer getId2 = databaseTest.getSearchedUsernameId("Test2");
        assertEquals(2, getId2.intValue());
        Boolean isAdded3 = databaseTest.addUsernameIntoDatabase("Test3");
        assertEquals(true, isAdded3);
        Integer getId3 = databaseTest.getSearchedUsernameId("Test3");
        assertEquals(3, getId3.intValue());
        Integer getId4 = databaseTest.getSearchedUsernameId("Test4");
        assertEquals(0, getId4.intValue());
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
     
    
    
    

    
    

}
