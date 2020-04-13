/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta.dao;

import java.sql.SQLException;

/**
 *
 * @author niila
 */
public interface databaseInterface {
    
    public boolean createDatabase() throws Exception;
    
    public boolean databaseExists();
    
    public boolean addInformation(String information);
    
    public boolean searchInformation(String information);
    
    public Integer searchInfromationId(String information);
    
    public boolean removeInformation(String information);
    
    public boolean removeDatabase() throws Exception;
    
}
