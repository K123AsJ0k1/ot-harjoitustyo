/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import Fiktiotietokanta.dao.databaseInterface;
import Fiktiotietokanta.domain.abilityDatabase;
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
public class abilityDatabaseTest {
    
    @Test
    public void constructorWorks() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean works = databaseTest.databaseExists();
        assertEquals(false, works);
    }
    
    @Test
    public void abilityDatabaseIsCreated() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        databaseTest.removeDatabase();
    }
    
    @Test
    public void abilitydatabaseCantBeCreatedTwice() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated1 = databaseTest.createDatabase();
        assertEquals(true, isCreated1);
        boolean isCreated2 = databaseTest.createDatabase();
        assertEquals(false, isCreated2);
        databaseTest.removeDatabase();
    }
    
    @Test
    public void abilityDatabaseIsRemoved() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void abilityDatabaseIsntRemovedTwice() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isRemoved1 = databaseTest.removeDatabase();
        assertEquals(true, isRemoved1);
        boolean isRemoved2 = databaseTest.removeDatabase();
        assertEquals(false, isRemoved2);
    }
    
    @Test
    public void noExistingDatabaseIsntRemoved() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(false, isRemoved);
    }
    
    @Test
    public void abilityCanBeAdded() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void duplicateAbilitiesCanBeAdded() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded2);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);
    }
    
    @Test
    public void abilityCantBeAddedIntoNoExistingDatabase() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isAdded = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(false, isAdded);
    }
    
    @Test
    public void abilityIsFound() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded);
        boolean isFound = databaseTest.searchInformation("1/1/1/1/1/1");
        assertEquals(true, isFound);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);   
    }
    
     @Test
    public void noAddedAbilityIsntFound() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("1/1/2/1/1/1");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addInformation("1/1/3/1/1/1");
        assertEquals(true, isAdded3);
        boolean isntFound = databaseTest.searchInformation("1/1/1/1/4/1");
        assertEquals(false, isntFound);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);  
    }
    
    @Test
    public void abilitySearchDoesntWorkOnNoExistingDatabase() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean doesntWork = databaseTest.searchInformation("1/1/1/1/1/1");
        assertEquals(false, doesntWork);
    }
    
    @Test
    public void abilityIdSearchWorks() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded);
        Integer id = databaseTest.searchInfromationId("1/1/1/1/1/1");
        assertEquals(1, id.intValue());
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);  
    }
    
    @Test
    public void noExistingAbilityIdIsZero() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        Integer noId = databaseTest.searchInfromationId("1/1/1/1/1/1");
        assertEquals(0, noId.intValue());
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved);  
    }
    
    @Test
    public void correctAbilityIdIsFound() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("1/1/1/1/1/2");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addInformation("1/1/1/1/1/3");
        assertEquals(true, isAdded3);
        Integer Id = databaseTest.searchInfromationId("1/1/1/1/1/2");
        assertEquals(2, Id.intValue());
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void allAbilityIDsAreCorrect() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("1/1/1/1/1/2");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addInformation("1/1/1/1/1/3");
        assertEquals(true, isAdded3);
        Integer Id1 = databaseTest.searchInfromationId("1/1/1/1/1/1");
        assertEquals(1, Id1.intValue());
        Integer Id2 = databaseTest.searchInfromationId("1/1/1/1/1/2");
        assertEquals(2, Id2.intValue());
        Integer Id3 = databaseTest.searchInfromationId("1/1/1/1/1/3");
        assertEquals(3, Id3.intValue());
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void noExistingAbilityDoesntHaveAnId() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded1 = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("1/1/1/1/1/2");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addInformation("1/1/1/1/1/3");
        assertEquals(true, isAdded3);
        Integer Id1 = databaseTest.searchInfromationId("1/1/1/1/1/1");
        assertEquals(1, Id1.intValue());
        Integer Id2 = databaseTest.searchInfromationId("1/1/1/1/1/2");
        assertEquals(2, Id2.intValue());
        Integer Id3 = databaseTest.searchInfromationId("1/1/1/1/1/3");
        assertEquals(3, Id3.intValue());
        Integer Id = databaseTest.searchInfromationId("1/1/1/1/1/4");
        assertEquals(0, Id.intValue());
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void idSearchDoesntWorkOnNoExistingDatabase() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        Integer doesntWork = databaseTest.searchInfromationId("1/1/1/1/1/1");
        assertEquals(0, doesntWork.intValue());
    }
    
    @Test
    public void abilityInformationRemovalWorks() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded);
        boolean remove = databaseTest.removeInformation("1/1/1/1/1/1");
        assertEquals(true, remove);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void abilityInformationIsActuallyRemoved() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);
        boolean isAdded = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded);
        Integer id = databaseTest.searchInfromationId("1/1/1/1/1/1");
        assertEquals(1, id.intValue());
        boolean remove = databaseTest.removeInformation("1/1/1/1/1/1");
        assertEquals(true, remove);
        boolean doesntExist= databaseTest.searchInformation("1/1/1/1/1/1");
        assertEquals(false, doesntExist);
        Integer noId = databaseTest.searchInfromationId("1/1/1/1/1/1");
        assertEquals(0, noId.intValue());     
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void correctUsernameIsRemoved() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);  
        boolean isAdded1 = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded1);
        Integer id1 = databaseTest.searchInfromationId("1/1/1/1/1/1");
        assertEquals(1, id1.intValue());   
        boolean isAdded2 = databaseTest.addInformation("1/1/1/1/1/2");
        assertEquals(true, isAdded2);
        Integer id2 = databaseTest.searchInfromationId("1/1/1/1/1/2");
        assertEquals(2, id2.intValue()); 
        boolean isAdded3 = databaseTest.addInformation("1/1/1/1/1/3");
        assertEquals(true, isAdded3);
        Integer id3 = databaseTest.searchInfromationId("1/1/1/1/1/3");
        assertEquals(3, id3.intValue());   
        boolean remove = databaseTest.removeInformation("1/1/1/1/1/2");
        assertEquals(true, remove);    
        boolean doesntExist= databaseTest.searchInformation("1/1/1/1/1/2");
        assertEquals(false, doesntExist);
        Integer idExists1 = databaseTest.searchInfromationId("1/1/1/1/1/1");
        assertEquals(1, idExists1.intValue());
        Integer noId = databaseTest.searchInfromationId("1/1/1/1/1/2");
        assertEquals(0, noId.intValue());  
        Integer idExists2 = databaseTest.searchInfromationId("1/1/1/1/1/3");
        assertEquals(3, idExists2.intValue());       
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void removalDoesntWorkWhenDatabaseDoesntExist() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean doesntWork = databaseTest.removeInformation("1/1/1/1/1/1");
        assertEquals(false, doesntWork);
    }
    
    @Test
    public void puttingDatabaseIntoAListWorks() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated);  
        boolean isAdded = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded);
        List<String> testList = databaseTest.showDatabaseAsAList();
        String firstAdded = testList.get(0);
        assertEquals("1/1/1/1/1/1", firstAdded);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
    
    @Test
    public void puttingDatabaseIntoaAListWorksCorrectly() throws Exception {
        databaseInterface databaseTest = new abilityDatabase();
        boolean isCreated = databaseTest.createDatabase();
        assertEquals(true, isCreated); 
        boolean isAdded1 = databaseTest.addInformation("1/1/1/1/1/1");
        assertEquals(true, isAdded1);
        boolean isAdded2 = databaseTest.addInformation("1/1/1/2/1/1");
        assertEquals(true, isAdded2);
        boolean isAdded3 = databaseTest.addInformation("1/1/1/3/1/1");
        assertEquals(true, isAdded3);
        List<String> testList = databaseTest.showDatabaseAsAList();
        String firstAdded = testList.get(0);
        assertEquals("1/1/1/1/1/1", firstAdded);
        String secondAdded = testList.get(1);
        assertEquals("1/1/1/2/1/1", secondAdded);
        String thirdAdded = testList.get(2);
        assertEquals("1/1/1/3/1/1", thirdAdded);
        boolean isRemoved = databaseTest.removeDatabase();
        assertEquals(true, isRemoved); 
    }
}
