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

/**
 *
 * @author niila
 */
public class nameDatabase implements databaseInterface {
    
    private Connection connection;
    private Boolean databaseExists;
    
    public nameDatabase() throws Exception {
        this.connection = DriverManager.getConnection("jdbc:sqlite:namedatabase:connection");
        this.databaseExists = false;           
    }

    @Override
    public boolean createDatabase() throws Exception {
        try {
            Statement command = connection.createStatement();

            command.execute("PRAGMA foreign_keys = ON;");
            command.execute("CREATE TABLE Names (id INTEGER PRIMARY KEY, Name TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Name ON Names (Name);");
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
    public boolean addInformation(String givenName) {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Names(Name) VALUES (?);");
            command.setString(1, givenName);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            
        }
        return false;
    }

    @Override
    public boolean searchInformation(String givenName) {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Name FROM Names;");
            ResultSet querySet = command.executeQuery();
            Boolean nameExists = false;
            while (querySet.next()) {
                String searchedName = querySet.getString("Name");
                if (searchedName.equals(givenName)) {
                    nameExists = true;
                    break;
                }
            }
            querySet.close();
            command.close();
            if (nameExists) {
                return true;
            }

            return false;

        } catch (SQLException k) {
            
        }
        return false;
    }

    @Override
    public Integer searchInfromationId(String givenName) {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT id FROM Names WHERE Name=?;");
            command.setString(1, givenName);
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
    public boolean removeInformation(String givenName) {
        try{
            PreparedStatement command = connection.prepareStatement("DELETE FROM Names WHERE Name=?");
            command.setString(1, givenName);
            command.executeUpdate();
            command.close();
            return true;
        }catch (SQLException k) {
            
        }
        return false;
    }

    @Override
    public boolean removeDatabase() throws Exception {
        try {
            Statement command = connection.createStatement();
            command.execute("DROP TABLE Names;");
            command.close();
            databaseExists = false;
            return true;
        } catch (SQLException k) {
            
        }
        return false;
    }
    
}
