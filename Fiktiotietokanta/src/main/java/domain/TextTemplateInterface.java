/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/** Tekstin mallien luomiseen tarkoitettu rajapinta.
 *
 * 
 */
public interface TextTemplateInterface {
    
    /**Luo mallin tekstieditorille.
     * @return palauttaa halutun mallin string muodossa.
    */
    public String simpleMaker();
    
}
