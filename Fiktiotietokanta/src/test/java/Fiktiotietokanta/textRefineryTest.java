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
    /*
    @Test
    public void test() {
        TextRefineryInterface test = new TextRefinery();
        List<String> testList = new ArrayList<>();
        testList.add("hei,koi,hoi,toi,loi");
        testList.add("mina,sina,te,me,he");
        List<String> gottenList = test.choosenAbilitiesAreFoundFromText("hei ja koi ja hoi ja toi ja loi ja mina ja sina ja te ja me ja he",testList);
    }
    */
    
    @Test
    public void textLineCheckerWorks() {
        TextRefineryInterface test = new TextRefinery();
        String exampleString = "dsasdas sdasd asd asd \n asdasd asd \n asda";
        boolean givenVerdict = test.givenTextLineChecker(exampleString);
        assertEquals(true, givenVerdict);
    }
    
    @Test
    public void textLineCheckerGivesFalse() {
        TextRefineryInterface test = new TextRefinery();
        String exampleString = "dsaddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
        boolean givenVerdict = test.givenTextLineChecker(exampleString);
        assertEquals(false, givenVerdict);
    }
    
    @Test
    public void textSpaceCheckerWorks() {
        TextRefineryInterface test = new TextRefinery();
        String exampleString = "dsad dddddddddd dddddddd ddddd";
        boolean givenVerdict = test.givenTextLineHasSpaces(exampleString);
        assertEquals(true, givenVerdict);
    }
    
    @Test
    public void textSpaceCheckerGivesFalse() {
        TextRefineryInterface test = new TextRefinery();
        String exampleString = "dsad dddddddddd dddddddd ddddd ddddd dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
        boolean givenVerdict = test.givenTextLineHasSpaces(exampleString);
        assertEquals(false, givenVerdict);
    }
    
    @Test
    public void textWordCountWorks() {
        TextRefineryInterface test = new TextRefinery();
        String exampleString = "d d d d";
        Integer givenWordCount = test.giveTextWordCount(exampleString);
        assertEquals(4, givenWordCount.intValue());
    }
    
    @Test
    public void textWordCountGivesRightNumbers() {
        TextRefineryInterface test = new TextRefinery();
        String exampleString = "adsasdas asdasd sads asdas asdasd dsad dsads d";
        Integer givenWordCount = test.giveTextWordCount(exampleString);
        assertEquals(8, givenWordCount.intValue());
    }
    
    @Test
    public void characterCountWorks() {
        TextRefineryInterface test = new TextRefinery();
        String exampleString = "d d d d";
        Integer givenCharacterCount = test.giveCharacterCount(exampleString);
        assertEquals(7, givenCharacterCount.intValue());
    }
    
    @Test
    public void characterCountIsCorrect() {
        TextRefineryInterface test = new TextRefinery();
        String exampleString = "d d d d ds sd sd sd sd";
        Integer givenCharacterCount = test.giveCharacterCount(exampleString);
        assertEquals(22, givenCharacterCount.intValue());
    }
    
    
    
    
    
    
}
