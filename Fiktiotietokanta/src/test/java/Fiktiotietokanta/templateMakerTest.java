/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import dao.TemplateMaker;
import domain.TextTemplateInterface;
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
public class templateMakerTest {
    
    
    @Test
    public void test() {
        TextTemplateInterface test = new TemplateMaker();
        System.out.println(test.templateMaker("hei"));       
    }

    
    
}