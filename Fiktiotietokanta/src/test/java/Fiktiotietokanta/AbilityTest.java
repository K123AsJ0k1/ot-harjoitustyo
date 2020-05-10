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
import tables.AbilityTable;

/**
 *
 * @author niila
 */
public class AbilityTest {
    
    @Test
    public void construtorWorks() {
        AbilityTable test = new AbilityTable("Test","Test","Test","Test","Test");
        String testClass = test.getClassIdentity();
        String testName = test.getNameIdentity();
        String testDescription = test.getDescriptionIdentity();
        String testRequriment = test.getRequrimentIdentity();
        String testReality = test.getRealityIdentity();
        assertEquals("Test", testClass);
        assertEquals("Test", testName);
        assertEquals("Test", testDescription);
        assertEquals("Test", testRequriment);
        assertEquals("Test", testReality);
    }
    
    @Test
    public void toStringIsCorrect() {
        AbilityTable test = new AbilityTable("Test","Test","Test","Test","Test");
        String testToString = test.toString();
        assertEquals("Test/Test/Test/Test/Test", testToString);
    }
}
