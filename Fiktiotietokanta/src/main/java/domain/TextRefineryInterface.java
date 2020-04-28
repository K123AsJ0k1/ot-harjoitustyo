/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/** Rajapinta käyttöliittymän ja textRefineryn välillä.
 *
 * 
 */
public interface TextRefineryInterface {
    
    /**Tarkastaa, onko annettussa tekstissä yhtään "\n" merkkejä.   
    * @param information on mikä tahansa merkkijono.
    * @return antaa true, jos merkkijonosta löytyy merkkeja halutun välin sisällä ja false, jos ei
    */
    public boolean givenTextLineChecker(String information);
    
    /**Tarkastaa, onko annettussa tekstissä yhtään " " merkkejä.   
    * @param information on mikä tahansa merkkijono.
    * @return antaa true, jos merkkijonosta löytyy merkkeja halutun välin sisällä ja false, jos ei
    */
    public boolean givenTextLineHasSpaces(String information);
    
    /**Tarkastaa, löytyykö tekstistä valitun ominaisuuden parameterja 
    * @param information on mikä tahansa merkkijono.
    * @param abilityInformation on ominaisuuden parametreja sisältävä merkkijono.
    * @return palauttaa ne parametrit, jotka löytyivät.
    */
    public String choosenAbilityIsFoundFromText(String information, String abilityInformation);
    
    /**Tarkastaa, löytyykö tekstistä valitun ominaisuuden parameterja 
    * @param information on mikä tahansa merkkijono.
     * @param abilityList on lista eri ominaisuuksia.
     * @return palauttaa ne parametrit, jotka löytyivät.
    */
    public List<String> choosenAbilitiesAreFoundFromText(String information,List<String> abilityList);
    
    /**Tarkastaa annettun merkkijonon sana määrän.
     * @param infromation annettu merkkijono.
     * @return Palauttaa merkkijonosta löydetty sana määrä.
    */
    public Integer giveTextWordCount(String infromation);
    
    /**Tarkastaa annettun merkkijonon merkki märään
     * @param infromation annettu merkkijono.
     * @return Palauttaa merkkijonosta löydetty merkki määrä.
    */
    public Integer giveCharacterCount(String infromation);
    
}
