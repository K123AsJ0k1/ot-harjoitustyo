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
public class DescriptionTable {
    
    private String descriptionNumberIdentity = null;
    private String descriptionNameIdentity = null;
    
    public DescriptionTable(String descriptionNumberIdentity, String descriptionNameIdentity) {
        this.descriptionNumberIdentity = descriptionNumberIdentity;
        this.descriptionNameIdentity = descriptionNameIdentity;
    }
    
    public String getDescriptionNumberIdentity() {
        return this.descriptionNumberIdentity;
    }
    
    public String getDescriptionNameIdentity() {
        return this.descriptionNameIdentity;
    }
    
    @Override
    public String toString() {
        return this.descriptionNumberIdentity+"/"+this.descriptionNameIdentity;
    }
    
}
