/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textlogic;

import domain.TextTemplateInterface;

/** Template tuottaja.
 *
 * 
 */
public class TemplateMaker implements TextTemplateInterface {
    
    
    /** Konstruktori.
    *
    * 
    */
    public TemplateMaker() {

    }

    @Override
    public String simpleMaker() {
        
        int templateWidth = 100;
        int templateHight = 10;

        int hight = 0;

        String templateString = "";

        while (hight <= templateHight) {

            int width = 0;

            while (width < templateWidth) {

                if (hight % 2 == 0) {
                    templateString = templateString + "-";
                }

                if (!(hight % 2 == 0)) {
                    templateString = templateString + " ";
                }

                width = width + 1;
            }

            templateString = templateString + "\n";
            hight = hight + 1;
        }

        return templateString;
    }

}
