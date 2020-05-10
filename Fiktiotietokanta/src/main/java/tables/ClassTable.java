/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

/** ClassTableScenen hyödyntämä olio.
 */
public class ClassTable {
    
    private String classNumberIdentity = null;
    private String classNameIdentity = null;
    
    /** ClassTableScenen hyödyntämä olio.
     * @param classNumberIdentity oliolle annettu id.
     * @param classNameIdentity oliolle annettu nimi.
    */
    public ClassTable(String classNumberIdentity, String classNameIdentity) {
        this.classNumberIdentity = classNumberIdentity;
        this.classNameIdentity = classNameIdentity;
    }
    
    public String getClassNumberIdentity() {
        return this.classNumberIdentity;
    }
    
    public String getClassNameIdentity() {
        return this.classNameIdentity;
    }
    
    @Override
    public String toString() {
        return this.classNumberIdentity + "/" + this.classNameIdentity;
    }
    
}
