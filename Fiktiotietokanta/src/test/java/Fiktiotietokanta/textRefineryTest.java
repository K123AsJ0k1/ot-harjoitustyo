/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import dao.TextRefinery;
import domain.TextRefineryInterface;
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
public class textRefineryTest {
    
    @Test
    public void test() {
        TextRefineryInterface test = new TextRefinery();
        System.out.println(test.refineGivenText("--------------------------------------------------hek pklksdlöa sdkadkaslkdm kdgmkmsdkjasmdkasns dsd--------------------------------------------------"));
    }
    
    
}
