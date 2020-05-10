/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import assets.Parameters;
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
public class ParametersTest {
    
    @Test
    public void constructorWorks() {
        Parameters test = new Parameters("Test","Test");
        assertEquals("Test", test.getChosenAbility());
        assertEquals("Test", test.getLeftOverParameters());
    }
}
