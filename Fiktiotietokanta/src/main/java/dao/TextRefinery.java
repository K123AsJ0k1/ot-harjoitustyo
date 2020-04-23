/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.TextRefineryInterface;

/** Jalostaa tekstin.
 *
 * 
 */
public class TextRefinery implements TextRefineryInterface {
    
   /** Konstruktori.
    *
    * 
   */
    public TextRefinery() {
        
    }
    
    @Override
    public boolean givenTextCanBeRefined(String information) {
        char[] characterTable = information.toCharArray();
        
        if (characterTable.length<100) {
            return false;
        }
        int lastLine = characterTable.length-51;
        int lines = 1;
        int allLines = 100;
        int tableIndex = 0;
        boolean truthValue = true;
        while (lines <= allLines) {
            char character = characterTable[tableIndex];
            
            if (!(character == '-')) {
                truthValue = false;
            }
            
            if (lines == 50) {
                tableIndex = lastLine;
            }
            
            lines = lines + 1;
            tableIndex = tableIndex + 1;
        }
        
        return truthValue;
    }
    
    @Override
    public String refineGivenText(String information) {
        char[] characterTable = information.toCharArray();
        
        int tableIndex = 0;
        int lastLine = characterTable.length-51;
        int lines = 1;
        int allLines = characterTable.length;
        int backSpaceLine = 0;
        String refinedText = "";
        while (lines <= allLines) {
            char character = characterTable[tableIndex];
            
            if (backSpaceLine == 50) {
                refinedText = refinedText + "\n";
                backSpaceLine = 0;
            }
            
            refinedText = refinedText + character;
            lines = lines + 1;
            tableIndex = tableIndex + 1;
            backSpaceLine = backSpaceLine + 1; 
        }
        
        return refinedText;
    }

    
    
}
