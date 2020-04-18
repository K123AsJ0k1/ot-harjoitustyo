/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta.domain;

import Fiktiotietokanta.dao.databaseInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** Luokka tietokanta.
 *
 * 
 */
public class classDatabase implements databaseInterface {
    
    private Connection connection;
    private Boolean databaseExists;
    
    /** Luokka tietokannan konstruktori.
    *
    * 
     * @throws java.lang.Exception virhe.
    */
    public classDatabase() throws Exception {
        this.connection = DriverManager.getConnection("jdbc:sqlite:classdatabase:connection");
        this.databaseExists = false;
        
    } 

    @Override
    public boolean createDatabase() throws Exception {
        try {
            Statement command = connection.createStatement();
            command.execute("PRAGMA foreign_keys = ON;");
            command.execute("CREATE TABLE Classes (id INTEGER PRIMARY KEY, Class TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Class ON Classes (Class);");
            command.close();
            databaseExists = true;
            return true;
        } catch (SQLException k) {
        }    
        return false;
    }

    @Override
    public boolean databaseExists() {
        return databaseExists;
    }

    @Override
    public boolean addInformation(String givenClass) {
        try {
            
            PreparedStatement command = connection.prepareStatement("INSERT INTO Classes(Class) VALUES (?);");
            command.setString(1, givenClass);
            command.executeUpdate();
            command.close();
            return true;
        
        } catch (SQLException k) {
                   
        } 
       
        return false;
    }

    @Override
    public boolean searchInformation(String givenClass) {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Class FROM Classes;");
            ResultSet querySet = command.executeQuery();
            Boolean classExists = false;
            while (querySet.next()) {
                String searchedClass = querySet.getString("Class");
                if (searchedClass.equals(givenClass)) {
                    classExists = true;
                    break;
                }
            }
            querySet.close();
            command.close();
            if (classExists) {
                return true;
            }

            return false;

        } catch (SQLException k) {
            
        }
        return false;
    }

    @Override
    public Integer searchInfromationId(String givenClass) {
         
        try {
            
            PreparedStatement command = connection.prepareStatement("SELECT id FROM Classes WHERE Class=?;");
            command.setString(1, givenClass);
            ResultSet querrySet = command.executeQuery();
            int classId = 0;
            if (querrySet.next()) {
                classId = querrySet.getInt("id");
            }
            
            querrySet.close();
            command.close();
            
            return classId;
            
        } catch (SQLException k) {
            
        }
        
        return 0;
        
    }

    @Override
    public boolean removeInformation(String givenClass) {
        
        try{
            
            PreparedStatement command = connection.prepareStatement("DELETE FROM Classes WHERE Class=?");
            command.setString(1, givenClass);
            command.executeUpdate();
            command.close();
            return true;
            
        } catch (SQLException k) {
            
        }
        
        return false;
        
    }

    @Override
    public boolean removeDatabase() throws Exception {
        
        try {
            
            Statement command = connection.createStatement();
            command.execute("DROP TABLE Classes;");
            command.close();
            databaseExists = false;
            return true;
            
        } catch (SQLException k) {
            
        }
        
        return false;
        
    }

    @Override
    public String searchInformationTextIdentity(String givenClassId) {
        
        int checkId = Integer.valueOf(givenClassId);
        
        try {
            
            PreparedStatement command = connection.prepareStatement("SELECT Class FROM Classes WHERE id=?");
            command.setInt(1, checkId);
            ResultSet querySet = command.executeQuery();
            String givenTextIdentity = "null";
            if (querySet.next()) {
                givenTextIdentity = querySet.getString("Class");
            }
            
            querySet.close();
            command.close();        
            return givenTextIdentity;
            
        } catch (SQLException k) {
            
        } 
        
        return "null";
        
    }

    @Override
    public List<String> showDatabaseAsAList() {
        
        List<String> databaseAsAList = new ArrayList<>();
        
        try {
            
            PreparedStatement command = connection.prepareStatement("SELECT Class FROM Classes;");
            ResultSet querySet = command.executeQuery();
            
            while (querySet.next()) {
                String givenClass = querySet.getString("Class");
                databaseAsAList.add(givenClass);
            }
            
            querySet.close();
            command.close();
            
            return databaseAsAList;
            
        } catch (SQLException k) {
            
        } 
        
        return null;
        
    }

    @Override
    public List<String> showDatabaseAsARestrictedList(String information) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
}
