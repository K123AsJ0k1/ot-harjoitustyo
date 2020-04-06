/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import Fiktiotietokanta.domain.AbilityDatabase;
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
    /*
    public AbilityDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    */
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void databaseExists() throws Exception {
        AbilityDatabase databaseTest=new AbilityDatabase();
        Boolean itExists=databaseTest.getDatabaseExists();
        assertEquals(true,itExists);
        Boolean isRemoved=databaseTest.removeDatabase();
    }
    
    @Test
    public void databaseExistsWorks() throws Exception {
        AbilityDatabase databaseTest=new AbilityDatabase();
        Boolean itExists=databaseTest.getDatabaseExists();
        assertEquals(true,itExists);
        Boolean isRemoved=databaseTest.removeDatabase();
        Boolean itDoesntExist=databaseTest.getDatabaseExists();
        assertEquals(false,itDoesntExist);
    }
    
    @Test
    public void databaseIsRemoved() throws Exception {
        AbilityDatabase databaseTest=new  AbilityDatabase();
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void abilityIsBeAdded() throws Exception {
        AbilityDatabase databaseTest=new AbilityDatabase();
        Boolean isAdded=databaseTest.addAbilityIntoDatabase(1, 1, 1, 1, 1, 1);
        assertEquals(true,isAdded);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void abilityIsFound() throws Exception {
        AbilityDatabase databaseTest=new AbilityDatabase();
        Boolean isAdded=databaseTest.addAbilityIntoDatabase(1, 1, 1, 1, 1, 1);
        assertEquals(true,isAdded);
        Boolean isFound=databaseTest.searchAbilityFromDatabase(1, 1, 1, 1, 1, 1);
        assertEquals(true, isFound);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void correctAbilityIsFound() throws Exception {
        AbilityDatabase databaseTest=new AbilityDatabase();
        Boolean isAdded1=databaseTest.addAbilityIntoDatabase(1, 1, 1, 1, 1, 1);
        assertEquals(true,isAdded1);
        Boolean isAdded2=databaseTest.addAbilityIntoDatabase(2, 2, 2, 2, 2, 2);
        assertEquals(true,isAdded2);
        Boolean isAdded3=databaseTest.addAbilityIntoDatabase(3, 3, 3, 3, 3, 3);
        assertEquals(true,isAdded3);
        Boolean isFound=databaseTest.searchAbilityFromDatabase(2, 2, 2, 2, 2, 2);
        assertEquals(true, isFound);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void noExistisAbilityIsntFound() throws Exception {
        AbilityDatabase databaseTest=new AbilityDatabase();
        Boolean isAdded1=databaseTest.addAbilityIntoDatabase(1, 1, 1, 1, 1, 1);
        assertEquals(true,isAdded1);
        Boolean isAdded2=databaseTest.addAbilityIntoDatabase(2, 2, 2, 2, 2, 2);
        assertEquals(true,isAdded2);
        Boolean isAdded3=databaseTest.addAbilityIntoDatabase(3, 3, 3, 3, 3, 3);
        assertEquals(true,isAdded3);
        Boolean isFound=databaseTest.searchAbilityFromDatabase(4, 4, 4, 4, 4, 4);
        assertEquals(false, isFound);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
     
}
