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
    
    /**Tarkastaa, voiko annettu teksti jalostaa.
    * @param information on mitä tahansa merkkijonoja
    * @return palauttaa true, jos teksti voidaan jalostaa ja false,jos ei.
    */
    public boolean givenTextCanBeRefined(String information);
    
    /**Jalostaa tekstieditorista saadun tekstin paremmaksi.
    * @param information on mitä tahansa parametreja.
    * @return palauttaa jalostetun tekstin.
    */
    public String refineGivenText(String information);
    
}
