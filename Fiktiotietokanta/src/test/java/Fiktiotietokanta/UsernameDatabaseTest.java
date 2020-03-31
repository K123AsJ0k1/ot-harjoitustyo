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

    UsernameDatabase database_Test;

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
    @Before
    public void setUp() throws Exception {
        database_Test = new UsernameDatabase();
    }

    @After
    public void tearDown() throws Exception {
        database_Test.removeDatabase();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void usernameIsFound() throws Exception {
        database_Test.addUsernameIntoDatabase("Test");
        database_Test.addUsernameIntoDatabase("Username");
        database_Test.addUsernameIntoDatabase("Found");
        Boolean truthValue_Test = database_Test.searchForAnExistingUsername("Username");
        assertEquals(true, truthValue_Test);
    }

    @Test
    public void notExistingUsernameIsntFound() throws Exception {
        database_Test.addUsernameIntoDatabase("Test");
        database_Test.addUsernameIntoDatabase("Found");
        Boolean truthValue_Test = database_Test.searchForAnExistingUsername("Username");
        assertEquals(false, truthValue_Test);
    }

}
