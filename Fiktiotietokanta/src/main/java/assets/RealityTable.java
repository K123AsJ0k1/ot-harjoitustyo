/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets;

/**
 *
 * @author niila
 */
public class RealityTable {
    
    private String realityNumberIdentity = null;
    private String realityNameIdentity = null;
    
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
        return this.realityNumberIdentity+"/"+this.realityNameIdentity;
    }
}
