/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.TextTemplateInterface;

/**
 *
 * @author niila
 */
public class TemplateMaker implements TextTemplateInterface {
    
    public TemplateMaker() {
        
    }
       

    @Override
    public String templateMaker(String information) {
        
        int templateWidth = 50;
        int templateHight = 10;
        
        int hight = 0;
        
        
        String templateString = "";
        
        while (hight <= templateHight) {
            
            int width = 0;
            
            while (width < templateWidth) {
                
                if (hight%2 == 0) {
                    templateString = templateString + "-";
                }
                
                if (!(hight%2 == 0)) {
                    
                    boolean wantedSpace = true;
                    
                    if (width == 18) {
                        templateString = templateString + "(Give info)";
                        wantedSpace = false;
                    }
                    
                    if (wantedSpace) {
                    templateString = templateString + " ";
                    }
                }
                
                width = width + 1;
            }
            
            templateString = templateString + "\n";
            hight = hight + 1;
        }
        
                   
        return templateString;
    }
    
}
