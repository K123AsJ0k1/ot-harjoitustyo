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
    
    AbilityDatabase database_Test;
    
    /*
    public AbilityDatabaseTest() {
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
        database_Test=new AbilityDatabase();
    }
    
    @After
    public void tearDown() throws Exception {
        database_Test.removeDatabase();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void classIsAddedIntoDatabase() throws Exception  {
        database_Test.addClassIntoDatabase("Test");
        Boolean truthvalue_Test=database_Test.searchClassFromDatabase("Test");
        assertEquals(true,truthvalue_Test);
    }
    
    @Test
    public void correctClassIsFound() throws Exception {
        database_Test.addClassIntoDatabase("Test1");
        database_Test.addClassIntoDatabase("TEST");
        database_Test.addClassIntoDatabase("Test");
        Boolean truthvalue_Test=database_Test.searchClassFromDatabase("Test");
        assertEquals(true,truthvalue_Test);
    }
    
    @Test
    public void noExistingClassIsntFound() throws Exception {
        database_Test.addClassIntoDatabase("Test1");
        database_Test.addClassIntoDatabase("TEST");
        database_Test.addClassIntoDatabase("Test");
        Boolean truthvalue_Test=database_Test.searchClassFromDatabase("T");
        assertEquals(false,truthvalue_Test);
    }
    
    @Test
    public void nameIsAddedIntoDatabase() throws Exception {
        database_Test.addNameIntoDatabase("Test");
        Boolean truthvalue_Test=database_Test.searchNameFromDatabase("Test");
        assertEquals(true,truthvalue_Test);
    }
    
    @Test
    public void correctNameIsFound() throws Exception {
        database_Test.addNameIntoDatabase("TEST");
        database_Test.addNameIntoDatabase("Test");
        database_Test.addNameIntoDatabase("Test1");
        Boolean truthvalue_Test=database_Test.searchNameFromDatabase("Test");
        assertEquals(true,truthvalue_Test);
    }
    
    @Test
    public void noExistingNameIsntFound() throws Exception {
        database_Test.addNameIntoDatabase("TEST");
        database_Test.addNameIntoDatabase("Test");
        database_Test.addNameIntoDatabase("Test1");
        Boolean truthvalue_Test=database_Test.searchNameFromDatabase("Test2");
        assertEquals(false,truthvalue_Test);
    }
    
    @Test
    public void descriptionIsAddedIntoDatabase() throws Exception {
        database_Test.addDescriptionIntoDatabase("Test");
        Boolean truthvalue_Test=database_Test.searchDescriptionFromDatabase("Test");
        assertEquals(true,truthvalue_Test);
    }
    
    @Test
    public void correctDescriptionIsFound() throws Exception {
        database_Test.addDescriptionIntoDatabase("TEST");
        database_Test.addDescriptionIntoDatabase("Test1");
        database_Test.addDescriptionIntoDatabase("Test");
        Boolean truthvalue_Test=database_Test.searchDescriptionFromDatabase("Test");
        assertEquals(true,truthvalue_Test);
    }
    
    @Test
    public void noExistingDescriptionIsntFound() throws Exception {
        database_Test.addDescriptionIntoDatabase("TEST");
        database_Test.addDescriptionIntoDatabase("Test1");
        database_Test.addDescriptionIntoDatabase("Test");
        Boolean truthvalue_Test=database_Test.searchDescriptionFromDatabase("Test2");
        assertEquals(false,truthvalue_Test);
    }
    
    @Test
    public void requirementIsAddedIntoDatabe() throws Exception {
        database_Test.addRequrimentIntoDatabase("Test");
        Boolean truthvalue_Test=database_Test.searchRequrimentFromDatabase("Test");
        assertEquals(true,truthvalue_Test);        
    }
    
    @Test
    public void correctRequirementIsFound() throws Exception {
        database_Test.addRequrimentIntoDatabase("TEST");
        database_Test.addRequrimentIntoDatabase("Test");
        database_Test.addRequrimentIntoDatabase("Test1");
        Boolean truthvalue_Test=database_Test.searchRequrimentFromDatabase("Test");
        assertEquals(true,truthvalue_Test);
    }
    
    @Test
    public void noExistingRequirementIsntFound() throws Exception {
        database_Test.addRequrimentIntoDatabase("TEST");
        database_Test.addRequrimentIntoDatabase("Test");
        database_Test.addRequrimentIntoDatabase("Test1");
        Boolean truthvalue_Test=database_Test.searchRequrimentFromDatabase("Test2");
        assertEquals(false,truthvalue_Test);
    }
    
    @Test
    public void realityIsAddedIntoDatabase() throws Exception {
        database_Test.addRealityIntoDatabase("Test");
        Boolean truthvalue_Test=database_Test.searchRealityFromDatabase("Test");
        assertEquals(true,truthvalue_Test);
    }
    
    @Test
    public void correctRealityIsFound() throws Exception {
        database_Test.addRealityIntoDatabase("TEST");
        database_Test.addRealityIntoDatabase("Test");
        database_Test.addRealityIntoDatabase("Test1");
        Boolean truthvalue_Test=database_Test.searchRealityFromDatabase("Test");
        assertEquals(true,truthvalue_Test);
    }
    
    @Test
    public void noExistingRealityIsntFound() throws Exception {
        database_Test.addRealityIntoDatabase("TEST");
        database_Test.addRealityIntoDatabase("Test");
        database_Test.addRealityIntoDatabase("Test1");
        Boolean truthvalue_Test=database_Test.searchRealityFromDatabase("Test2");
        assertEquals(false,truthvalue_Test);
    }
    /*
    @Test
    public void abilityIsAddenIntoDatabase() throws Exception {
        database_Test.addClassIntoDatabase("Test");
        database_Test.addNameIntoDatabase("Test");
        database_Test.addDescriptionIntoDatabase("Test");
        database_Test.addRequrimentIntoDatabase("Test");
        database_Test.addRealityIntoDatabase("Test");
        database_Test.addAbilityIntoDatabase(1, "Test", "Test", "Test", "Test", "Test");
        Boolean truthvalue_Test=database_Test.searchAbilityFromDatabase(1, 1, 1, 1, 1, 1);
        assertEquals(true,truthvalue_Test);
    }
    */
}   
