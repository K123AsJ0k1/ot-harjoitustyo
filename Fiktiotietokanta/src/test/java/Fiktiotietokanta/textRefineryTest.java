/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta;

import textlogic.TextRefinery;
import domain.TextRefineryInterface;
import java.util.ArrayList;
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
public class textRefineryTest {
    
    @Test
    public void test() {
        TextRefineryInterface test = new TextRefinery();
        List<String> testList = new ArrayList<>();
        testList.add("hei,koi,hoi,toi,loi");
        testList.add("mina,sina,te,me,he");
        List<String> gottenList = test.choosenAbilitiesAreFoundFromText("hei ja koi ja hoi ja toi ja loi ja mina ja sina ja te ja me ja he",testList);
        System.out.println(gottenList.toString());
    }
    
    
}
