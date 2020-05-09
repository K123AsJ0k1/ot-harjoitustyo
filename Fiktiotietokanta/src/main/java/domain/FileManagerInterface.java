/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author niila
 */
public interface FileManagerInterface {
    
    public String getUserPath();
    
    public String getDirectoryPath();
    
    public Boolean configFileExists();
        
    public Boolean createStandardDirectory();
    
    public Boolean createModifiedDirectory(String givenName);
   
    
}
