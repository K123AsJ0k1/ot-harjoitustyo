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
public class requrimentDatabase implements databaseInterface {
    
    private Connection connection;
    private Boolean databaseExists;
    
    public requrimentDatabase() throws Exception {
        this.connection = DriverManager.getConnection("jdbc:sqlite:requrimentdatabase:connection");
        this.databaseExists = false;
    } 

    @Override
    public boolean createDatabase() throws Exception {
        try {
            Statement command = connection.createStatement();
            command.execute("PRAGMA foreign_keys = ON;");
            command.execute("CREATE TABLE Requriments (id INTEGER PRIMARY KEY, Requriment TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Requriment ON Requriments (Requriment);");
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
    public boolean addInformation(String givenRequriment) {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Requriments(Requriment) VALUES (?);");
            command.setString(1, givenRequriment);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            
        }
        
        return false;
    }

    @Override
    public boolean searchInformation(String givenRequriment) {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Requriment FROM Requriments;");
            ResultSet querySet = command.executeQuery();
            Boolean requrimentExists = false;
            while (querySet.next()) {
                String searchedRequriment = querySet.getString("Requriment");
                if (searchedRequriment.equals(givenRequriment)) {
                    requrimentExists = true;
                    break;
                }
            }
            querySet.close();
            command.close();
            if (requrimentExists) {
                return true;
            }

            return false;

        } catch (SQLException k) {
            
        }
        return false;
    }

    @Override
    public Integer searchInfromationId(String givenRequriment) {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT id FROM Requriments WHERE Requriment=?;");
            command.setString(1, givenRequriment);
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
    public boolean removeInformation(String givenRequriment) {
        try{
            PreparedStatement command = connection.prepareStatement("DELETE FROM Requriments WHERE Requriment=?");
            command.setString(1, givenRequriment);
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
            command.execute("DROP TABLE Requriments");
            command.close();
            databaseExists = false;
            return true;
        } catch (SQLException k) {
            
        }
        return false;
    }
    
}
