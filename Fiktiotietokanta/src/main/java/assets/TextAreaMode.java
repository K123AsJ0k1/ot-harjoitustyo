/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets;

/** DaoSettingsScenejen käyttämä olio.
 */
public class TextAreaMode {
    
    String textMode;
    /** Olion konstruktori.
    */
    public TextAreaMode() {
        textMode = "";
    }
    
    public void setMode(String givenText) {
        this.textMode = givenText;
    }
    
    public String getMode() {
        return this.textMode;
    }
    
}
