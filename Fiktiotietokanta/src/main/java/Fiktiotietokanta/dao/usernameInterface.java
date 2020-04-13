/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta.dao;

/**
 *
 * @author niila
 */
public interface usernameInterface {
    
    public boolean createUsernameDatabase() throws Exception;
    
    public boolean usernameDatabaseExists();
    
    public boolean addUserInformation(String information);
    
    public boolean searchUserInformation(String information);
    
    public Integer searchUsernameId(String information);
    
    public boolean removeUserInformation(String information);
    
    public boolean removeUsernameDatabase() throws Exception;
    
}
