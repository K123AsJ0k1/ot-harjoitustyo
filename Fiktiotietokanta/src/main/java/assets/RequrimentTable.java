/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets;

/** RequrimentTableScenen käyttämä olio.
 */
public class RequrimentTable {
    
    private String requrimentNumberIdentity = null;
    private String requrimentNameIdentity = null;
    /** RequrimentTableScenen käyttämä olio.
     * @param requrimentNumberIdentity oliolle annettu id.
     * @param requrimentNameIdentity oliolle annettu nimi.
    */
    public RequrimentTable(String requrimentNumberIdentity, String requrimentNameIdentity) {
        this.requrimentNumberIdentity = requrimentNumberIdentity;
        this.requrimentNameIdentity = requrimentNameIdentity;
    }
    
    public String getRequrimentNumberIdentity() {
        return this.requrimentNumberIdentity;
    }
    
    public String getRequrimentNameIdentity() {
        return this.requrimentNameIdentity;
    }
    
    @Override
    public String toString() {
        return this.requrimentNumberIdentity + "/" + this.requrimentNameIdentity;
    }
}
