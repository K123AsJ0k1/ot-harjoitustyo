/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

/** RealityTableScenen käyttämä olio.
 */
public class RealityTable {
    
    private String realityNumberIdentity = null;
    private String realityNameIdentity = null;
    
    /** Olion konstruktori.
     * @param realityNumberIdentity oliolle annettu id.
     * @param realityNameIdentity oliolle annettu nimi.
    */
    public RealityTable(String realityNumberIdentity, String realityNameIdentity) {
        this.realityNumberIdentity = realityNumberIdentity;
        this.realityNameIdentity = realityNameIdentity;
    }
    
    public String getRealityNumberIdentity() {
        return this.realityNumberIdentity;
    }
    
    public String getRealityNameIdentity() {
        return this.realityNameIdentity;
    }
    
    @Override
    public String toString() {
        return this.realityNumberIdentity + "/" + this.realityNameIdentity;
    }
}
