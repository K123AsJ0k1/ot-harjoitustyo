/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets;

/** NameTableScenen käyttäjä olio.
 */
public class NameTable {
    
    private String nameNumberIdentity = null;
    private String nameNameIdentity = null;
    
    /** Olion konstruktori.
     * @param nameNumberIdentity oliolle annettu id.
     * @param nameNameIdentity oliolle annettu nimi.
    */
    public NameTable(String nameNumberIdentity, String nameNameIdentity) {
        this.nameNumberIdentity = nameNumberIdentity;
        this.nameNameIdentity  = nameNameIdentity;
    }
    
    public String getNameNumberIdentity() {
        return this.nameNumberIdentity;
    }
    
    public String getNameNameIdentity() {
        return this.nameNameIdentity;
    }
    
    @Override
    public String toString() {
        return this.nameNumberIdentity + "/" + this.nameNameIdentity;
    }
    
}
