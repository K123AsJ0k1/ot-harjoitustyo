/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import Fiktiotietokanta.dao.databaseInterface;
import Fiktiotietokanta.domain.descriptionDatabase;
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
public class descriptionDatabaseTest {
    
    @Test
    public void constructorWorks() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean works = databaseTest.databaseExists();
        assertEquals(false, works);
    }
    
    @Test
    public void descriptionDatabaseIsCreated() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        databaseTest.removeDatabase();
    }
    
    @Test
    public void descriptiondatabaseCantBeCreatedTwice() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated1 = databaseTest.createDatabase();
        assertEquals(true, isCreated1);
        boolean isCreated2 = databaseTest.createDatabase();
        assertEquals(false, isCreated2);
        databaseTest.removeDatabase();
    }
    
    @Test
    public void descriptionDatabaseIsRemoved() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void descriptionDatabaseIsntRemovedTwice() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isRemoved1 = databaseTest.removeDatabase();
        assertEquals(true, isRemoved1);
        boolean isRemoved2 = databaseTest.removeDatabase();
        assertEquals(false, isRemoved2);
    }
    
    @Test
    public void noExistingDatabaseIsntRemoved() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(false, isRemoved);
    }
    
    @Test
    public void descriptionCanBeAdded() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("Test");
        assertEquals(true, isAdded);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void descriptionCantBeAddedIntoNoExistingDatabase() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isAdded = databaseTest.addInformation("Test");
        assertEquals(false, isAdded);
    }
    
    @Test
    public void duplicateDescriptionCantBeAdded() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addInformation("Test");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("Test");
        assertEquals(false, isAdded2);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void descriptionIsFound() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("Test");
        assertEquals(true, isAdded);
        boolean isFound = databaseTest.searchInformation("Test");
        assertEquals(true, isFound);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);   
    }
    
    @Test
    public void correctDescriptionIsFound() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("Test");
        assertEquals(true, isAdded);
        boolean isFound = databaseTest.searchInformation("Test");
        assertEquals(true, isFound);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);   
    }
    
    @Test
    public void noAddedDescriptionIsntFound() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addInformation("Test1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("Test2");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addInformation("Test3");
        assertEquals(true, isAdded3);
        boolean isFound = databaseTest.searchInformation("Test2");
        assertEquals(true, isFound);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);  
    }
    
    @Test
    public void descriptionSearchDoesntWorkOnNoExistingDatabase() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean doesntWork = databaseTest.searchInformation("Test");
        assertEquals(false, doesntWork);
    }
    
    
    @Test
    public void descriptionIdSearchWorks() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("Test");
        assertEquals(true, isAdded);
        Integer id = databaseTest.searchInfromationId("Test");
        assertEquals(1, id.intValue());
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);  
    }
    
    @Test
    public void noExistingDescriptionIdIsZero() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        Integer noId = databaseTest.searchInfromationId("Test");
        assertEquals(0, noId.intValue());
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);  
    }
    
    @Test
    public void correctDescriptionIdIsFound() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addInformation("Test1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("Test2");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addInformation("Test3");
        assertEquals(true, isAdded3);
        Integer Id = databaseTest.searchInfromationId("Test2");
        assertEquals(2, Id.intValue());
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void allDescriptionIDsAreCorrect() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addInformation("Test1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("Test2");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addInformation("Test3");
        assertEquals(true, isAdded3);
        Integer Id1 = databaseTest.searchInfromationId("Test1");
        assertEquals(1, Id1.intValue());
        Integer Id2 = databaseTest.searchInfromationId("Test2");
        assertEquals(2, Id2.intValue());
        Integer Id3 = databaseTest.searchInfromationId("Test3");
        assertEquals(3, Id3.intValue());
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void noExistingDescriptionDoesntHaveAnId() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addInformation("Test1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("Test2");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addInformation("Test3");
        assertEquals(true, isAdded3);
        Integer Id1 = databaseTest.searchInfromationId("Test1");
        assertEquals(1, Id1.intValue());
        Integer Id2 = databaseTest.searchInfromationId("Test2");
        assertEquals(2, Id2.intValue());
        Integer Id3 = databaseTest.searchInfromationId("Test3");
        assertEquals(3, Id3.intValue());
        Integer Id = databaseTest.searchInfromationId("Test4");
        assertEquals(0, Id.intValue());
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void idSearchDoesntWorkOnNoExistingDatabase() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        Integer doesntWork = databaseTest.searchInfromationId("Test");
        assertEquals(0, doesntWork.intValue());
    }
    
    @Test
    public void descriptionInformationRemovalWorks() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("Test");
        assertEquals(true, isAdded);
        boolean remove = databaseTest.removeInformation("Test");
        assertEquals(true, remove);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void descriptionInformationIsActuallyRemoved() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("Test");
        assertEquals(true, isAdded);
        Integer id = databaseTest.searchInfromationId("Test");
        assertEquals(1, id.intValue());
        boolean remove = databaseTest.removeInformation("Test");
        assertEquals(true, remove);
        boolean doesntExist= databaseTest.searchInformation("Test");
        assertEquals(false, doesntExist);
        Integer noId = databaseTest.searchInfromationId("Test");
        assertEquals(0, noId.intValue());     
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void correctDescriptionIsRemoved() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);  
        boolean isAdded1 = databaseTest.addInformation("Test1");
        assertEquals(true, isAdded1);
        Integer id1 = databaseTest.searchInfromationId("Test1");
        assertEquals(1, id1.intValue());   
        boolean isAdded2 = databaseTest.addInformation("Test2");
        assertEquals(true, isAdded2);
        Integer id2 = databaseTest.searchInfromationId("Test2");
        assertEquals(2, id2.intValue()); 
        boolean isAdded3 = databaseTest.addInformation("Test3");
        assertEquals(true, isAdded3);
        Integer id3 = databaseTest.searchInfromationId("Test3");
        assertEquals(3, id3.intValue());   
        boolean remove = databaseTest.removeInformation("Test2");
        assertEquals(true, remove);    
        boolean doesntExist= databaseTest.searchInformation("Test2");
        assertEquals(false, doesntExist);
        Integer idExists1 = databaseTest.searchInfromationId("Test1");
        assertEquals(1, idExists1.intValue());
        Integer noId = databaseTest.searchInfromationId("Test2");
        assertEquals(0, noId.intValue());  
        Integer idExists2 = databaseTest.searchInfromationId("Test3");
        assertEquals(3, idExists2.intValue());       
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void removalDoesntWorkWhenDatabaseDoesntExist() throws Exception {
        databaseInterface databaseTest = new descriptionDatabase();
        boolean doesntWork = databaseTest.removeInformation("Test");
        assertEquals(false, doesntWork);
    }
}
