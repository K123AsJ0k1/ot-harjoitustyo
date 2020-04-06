/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import Fiktiotietokanta.domain.AbilityParametersDatabase;
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
public class AbilityParametersDatabaseTest {
    /*
    public AbilityParametersDatabaseTest() {
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
    public void databaseIsRemoved() throws Exception {
        AbilityParametersDatabase databaseTest=new AbilityParametersDatabase();
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
   
    @Test
    public void classIsAdded() throws Exception {
        AbilityParametersDatabase databaseTest=new AbilityParametersDatabase();
        Boolean isAdded=databaseTest.addClassIntoDatabase("Test");
        assertEquals(true,isAdded);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void classIsFound() throws Exception {
        AbilityParametersDatabase databaseTest=new AbilityParametersDatabase();
        Boolean isAdded=databaseTest.addClassIntoDatabase("Test");
        assertEquals(true,isAdded);
        Boolean isFound=databaseTest.searchClassFromDatabase("Test");
        assertEquals(true,isFound);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void correctClassIsFound() throws Exception {
        AbilityParametersDatabase databaseTest=new AbilityParametersDatabase();
        Boolean isAdded1=databaseTest.addClassIntoDatabase("Test1");
        assertEquals(true,isAdded1);
        Boolean isAdded2=databaseTest.addClassIntoDatabase("Test2");
        assertEquals(true,isAdded2);
        Boolean isAdded3=databaseTest.addClassIntoDatabase("Test3");
        assertEquals(true,isAdded3);
        Boolean isFound=databaseTest.searchClassFromDatabase("Test2");
        assertEquals(true,isFound);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void noExistingClassIsntFound() throws Exception {
        AbilityParametersDatabase databaseTest=new AbilityParametersDatabase();
        Boolean isAdded1=databaseTest.addClassIntoDatabase("Test1");
        assertEquals(true,isAdded1);
        Boolean isAdded2=databaseTest.addClassIntoDatabase("Test2");
        assertEquals(true,isAdded2);
        Boolean isAdded3=databaseTest.addClassIntoDatabase("Test3");
        assertEquals(true,isAdded3);
        Boolean isFound=databaseTest.searchClassFromDatabase("Test4");
        assertEquals(false,isFound);
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void classIdCanBeFound() throws Exception {
        AbilityParametersDatabase databaseTest=new AbilityParametersDatabase();
        Boolean isAdded=databaseTest.addClassIntoDatabase("Test");
        assertEquals(true,isAdded);
        Boolean isFound=databaseTest.searchClassFromDatabase("Test");
        assertEquals(true,isFound);
        Integer correctId=databaseTest.getSearchedClassIdFromDatabase("Test");
        assertEquals(1,correctId.intValue());
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void correctClassIdIsFound() throws Exception {
        AbilityParametersDatabase databaseTest=new AbilityParametersDatabase();
        Boolean isAdded1=databaseTest.addClassIntoDatabase("Test1");
        assertEquals(true,isAdded1);
        Boolean isAdded2=databaseTest.addClassIntoDatabase("Test2");
        assertEquals(true,isAdded2);
        Boolean isAdded3=databaseTest.addClassIntoDatabase("Test3");
        assertEquals(true,isAdded3);
        Boolean isFound1=databaseTest.searchClassFromDatabase("Test1");
        assertEquals(true,isFound1);
        Boolean isFound2=databaseTest.searchClassFromDatabase("Test2");
        assertEquals(true,isFound2);
        Boolean isFound3=databaseTest.searchClassFromDatabase("Test3");
        assertEquals(true,isFound3);
        Integer correctId1=databaseTest.getSearchedClassIdFromDatabase("Test1");
        assertEquals(1,correctId1.intValue());
        Integer correctId2=databaseTest.getSearchedClassIdFromDatabase("Test2");
        assertEquals(2,correctId2.intValue());
        Integer correctId3=databaseTest.getSearchedClassIdFromDatabase("Test3");
        assertEquals(3,correctId3.intValue());
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
    @Test
    public void noExistingClassIdWorks() throws Exception {
        AbilityParametersDatabase databaseTest=new AbilityParametersDatabase();
        Boolean isAdded1=databaseTest.addClassIntoDatabase("Test1");
        assertEquals(true,isAdded1);
        Boolean isAdded2=databaseTest.addClassIntoDatabase("Test2");
        assertEquals(true,isAdded2);
        Boolean isAdded3=databaseTest.addClassIntoDatabase("Test3");
        assertEquals(true,isAdded3);
        Boolean isFound1=databaseTest.searchClassFromDatabase("Test1");
        assertEquals(true,isFound1);
        Boolean isFound2=databaseTest.searchClassFromDatabase("Test2");
        assertEquals(true,isFound2);
        Boolean isFound3=databaseTest.searchClassFromDatabase("Test3");
        assertEquals(true,isFound3);
        Integer correctId1=databaseTest.getSearchedClassIdFromDatabase("Test1");
        assertEquals(1,correctId1.intValue());
        Integer correctId2=databaseTest.getSearchedClassIdFromDatabase("Test2");
        assertEquals(2,correctId2.intValue());
        Integer correctId3=databaseTest.getSearchedClassIdFromDatabase("Test3");
        assertEquals(3,correctId3.intValue());
        Integer correctId4=databaseTest.getSearchedClassIdFromDatabase("Test4");
        assertEquals(0,correctId4.intValue());
        Boolean isRemoved=databaseTest.removeDatabase();
        assertEquals(true,isRemoved);
    }
    
}
