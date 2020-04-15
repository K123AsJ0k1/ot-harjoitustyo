/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta.domain;

/**
 *
 * @author niila
 */
public class ability {
    
    private String classIdentity = null;
    private String nameIdentity = null;
    private String descriptionIdentity = null;
    private String requrimentIdentity = null;
    private String realityIdentity = null;
    
    public ability(String givenClass,String givenName,String givenDescription,String givenRequriment,String givenReality) {
        this.classIdentity = givenClass;
        this.nameIdentity = givenName;
        this.descriptionIdentity = givenDescription;
        this.requrimentIdentity = givenRequriment;
        this.realityIdentity = givenReality;
    }
    
    public String getClassIdentity() {
        return this.classIdentity;
    }
    
    public String getNameIdentity() {
        return this.nameIdentity;
    }
    
    public String getDescriptionIdentity() {
        return this.descriptionIdentity;
    }
    
    public String getRequrimentIdentity() {
        return this.requrimentIdentity;
    }
    
    public String getRealityIdentity() {
        return this.realityIdentity;
    }
    
    @Override
    public String toString() {
        return this.classIdentity+"/"+this.nameIdentity+"/"+this.descriptionIdentity+"/"+this.requrimentIdentity+"/"+this.realityIdentity;
    }
        
}
