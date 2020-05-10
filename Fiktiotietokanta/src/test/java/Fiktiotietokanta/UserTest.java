/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import assets.User;
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
public class UserTest {
    
    @Test
    public void constructorWorks() {
        User test = new User("Test","Test","Test", 1);
        assertEquals("Test", test.getUsername());
        assertEquals("Test", test.getPassword());
        assertEquals("Test", test.getPrivilage());
        assertEquals(1, test.getId().intValue());
    }
}
