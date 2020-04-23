/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/** Saadun tekstin jalostamiseen rajapinta.
 *
 * 
 */
public interface TextRefineryInterface {
    
    /**Tarkastaa, onko annettu teksti luettavassa kunnossa.    
    * @param information on mitä tahansa merkkijonoja
    * @return palauttaa true, jos teksti voidaan jalostaa ja false,jos ei.
    */
    public boolean givenTextIsRefined(String information);
    
    
    
}
