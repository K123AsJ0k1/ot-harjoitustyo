/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author niila
 */
public class Parameters {
    
    String chosenAbility;
    String leftOverParameters;
    
    public Parameters(String givenAbility, String givenString) {
        this.chosenAbility = givenAbility;
        this.leftOverParameters = givenString;
    }
    
    public String getChosenAbility() {
        return this.chosenAbility;
    }
    
    public String getLeftOverParameters() {
        return this.leftOverParameters;
    }
    
    public void setChoosenAbility(String givenString) {
        this.chosenAbility = givenString;
    }
    
    public void setLeftOverParameters(String givenString) {
        this.leftOverParameters = givenString;
    }
    
}
