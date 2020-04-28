/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/** Saadun tekstin jalostamiseen rajapinta.
 *
 * 
 */
public interface TextRefineryInterface {
    
    
   
    
    /**Tarkastaa, onko annettu teksti luettavassa kunnossa.    
    * @param information on mitä tahansa merkkijonoja
     * @return true tai false.
    * 
    */
    public boolean givenTextLineChecker(String information);
    
    public boolean givenTextLineHasSpaces(String information);
    
    public String choosenAbilityIsFoundFromText(String information, String abilityInformation);
    
    public List<String> choosenAbilitiesAreFoundFromText(String information,List<String> abilityList);
    
    public Integer giveTextWordCount(String infromation);
    
    public Integer giveCharacterCount(String infromation);
    
}
