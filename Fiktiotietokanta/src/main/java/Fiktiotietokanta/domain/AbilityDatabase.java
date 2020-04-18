/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fiktiotietokanta.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Fiktiotietokanta.dao.DatabaseInterface;

/**
 * Tietokanta annettuille fiktiivisille ominaisuuksille.
 */
public class AbilityDatabase implements DatabaseInterface {

    private Connection connection;
    private Boolean databaseExists;

    /**
     * Tietokannan konstruktori.
     * @throws SQLException virhe.
     */
    public AbilityDatabase() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:abilitydatabase:connection");
        this.databaseExists = false;
    }

    @Override
    public boolean createDatabase() throws Exception {
        try {
            Statement command = connection.createStatement();
            command.execute("PRAGMA foreign_keys = ON;");
            command.execute("CREATE TABLE Abilities (id INTEGER PRIMARY KEY, Username_id INTEGER, Class_id INTEGER, Name_id INTEGER, Description_id INTEGER,Requriment_id INTEGER, Reality_id INTEGER);");
            command.execute("CREATE INDEX idx_Ability ON Abilities (Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id);");
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
    public boolean addInformation(String information) {
        String[] split = information.split("/");
        int usernameId = Integer.valueOf(split[0]);
        int classId = Integer.valueOf(split[1]);
        int nameId = Integer.valueOf(split[2]);
        int descriptionId = Integer.valueOf(split[3]);
        int requrimentId = Integer.valueOf(split[4]);
        int realityId = Integer.valueOf(split[5]);
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Abilities(Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id) VALUES (?,?,?,?,?,?);");
            command.setInt(1, usernameId);
            command.setInt(2, classId);
            command.setInt(3, nameId);
            command.setInt(4, descriptionId);
            command.setInt(5, requrimentId);
            command.setInt(6, realityId);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            
        }
        return false;
    }

    @Override
    public boolean searchInformation(String information) {
        String[] split = information.split("/");
        int usernameId = Integer.valueOf(split[0]);
        int classId = Integer.valueOf(split[1]);
        int nameId = Integer.valueOf(split[2]);
        int descriptionId = Integer.valueOf(split[3]);
        int requrimentId = Integer.valueOf(split[4]);
        int realityId = Integer.valueOf(split[5]);
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id FROM Abilities;");
            ResultSet querrySet = command.executeQuery();
            Boolean abilityExists = false;
            while (querrySet.next()) {
                int userId = querrySet.getInt("Username_id");
                int clasId = querrySet.getInt("Class_id");
                int namId = querrySet.getInt("Name_id");
                int descId = querrySet.getInt("Description_id");
                int reqId = querrySet.getInt("Requriment_id");
                int reaId = querrySet.getInt("Reality_id");
                if (userId == usernameId && clasId == classId && namId == nameId && descId == descriptionId && reqId == requrimentId && reaId == realityId) {
                    abilityExists = true;
                    break;
                }
            }
            querrySet.close();
            command.close();
            if (abilityExists) {
                return true;
            }

            return false;
        } catch (SQLException k) {
            
        }
        return false;
    }

    @Override
    public Integer searchInfromationId(String information) {
        String[] split = information.split("/");
        int usernameId = Integer.valueOf(split[0]);
        int classId = Integer.valueOf(split[1]);
        int nameId = Integer.valueOf(split[2]);
        int descriptionId = Integer.valueOf(split[3]);
        int requrimentId = Integer.valueOf(split[4]);
        int realityId = Integer.valueOf(split[5]);
        try {
            PreparedStatement command = connection.prepareStatement("SELECT id FROM Abilities WHERE Username_id=? AND Class_id=? AND Name_id=? AND Description_id=? AND Requriment_id=? AND Reality_id=?;");
            command.setInt(1, usernameId);
            command.setInt(2, classId);
            command.setInt(3, nameId);
            command.setInt(4, descriptionId);
            command.setInt(5, requrimentId);
            command.setInt(6, realityId);
            ResultSet querrySet = command.executeQuery();
            int abilityId = 0;
            if (querrySet.next()) {
                abilityId = querrySet.getInt("id");
            }
            querrySet.close();
            command.close();
            return abilityId;
        } catch (SQLException k) {
            
        }
        return 0;
    }

    @Override
    public boolean removeInformation(String information) {
        String[] split = information.split("/");
        int usernameId = Integer.valueOf(split[0]);
        int classId = Integer.valueOf(split[1]);
        int nameId = Integer.valueOf(split[2]);
        int descriptionId = Integer.valueOf(split[3]);
        int requrimentId = Integer.valueOf(split[4]);
        int realityId = Integer.valueOf(split[5]);
        
        try {
            PreparedStatement command = connection.prepareStatement("DELETE FROM Abilities WHERE Username_id=? AND Class_id=? AND Name_id=? AND Description_id=? AND Requriment_id=? AND Reality_id=?;");
            command.setInt(1, usernameId);
            command.setInt(2, classId);
            command.setInt(3, nameId);
            command.setInt(4, descriptionId);
            command.setInt(5, requrimentId);
            command.setInt(6, realityId);
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
            command.execute("DROP TABLE Abilities;");
            command.close();
            databaseExists = false;
            return true;
        } catch (SQLException k) {
            
        }
        return false;
    }

    @Override
    public String searchInformationTextIdentity(String givenAbilityId) {
        int checkId = Integer.valueOf(givenAbilityId);
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id FROM Abilities WHERE id=?");
            command.setInt(1, checkId);
            ResultSet querySet = command.executeQuery();
            String givenTextIdentity = "null";
            if (querySet.next()) {
                int givenUsernameId = querySet.getInt("Username_id");
                int givenClassId = querySet.getInt("Class_id");
                int givenNameId = querySet.getInt("Name_id");
                int givenDescriptionId = querySet.getInt("Description_id");
                int givenRequrimentId = querySet.getInt("Requriment_id");
                int givenRealityId = querySet.getInt("Reality_id");
                givenTextIdentity = String.valueOf(givenUsernameId) + "/" + String.valueOf(givenClassId) + "/" + String.valueOf(givenNameId) + "/" + String.valueOf(givenDescriptionId) + "/" + String.valueOf(givenRequrimentId) + "/" + String.valueOf(givenRealityId);
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
            PreparedStatement command = connection.prepareStatement("SELECT Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id FROM Abilities;");
            ResultSet querySet = command.executeQuery();
            while (querySet.next()) {
                int givenUsernameId = querySet.getInt("Username_id");
                int givenClassId = querySet.getInt("Class_id");
                int givenNameId = querySet.getInt("Name_id");
                int givenDescriptionId = querySet.getInt("Description_id");
                int givenRequrimentId = querySet.getInt("Requriment_id");
                int givenRealityId = querySet.getInt("Reality_id");
                String givenTextIdentity = String.valueOf(givenUsernameId) + "/" + String.valueOf(givenClassId) + "/" + String.valueOf(givenNameId) + "/" + String.valueOf(givenDescriptionId) + "/" + String.valueOf(givenRequrimentId) + "/" + String.valueOf(givenRealityId);
                databaseAsAList.add(givenTextIdentity);
            }  
            querySet.close();
            command.close();
            return databaseAsAList;           
        } catch (SQLException k) {
   
        } 
        return null;
    }
    @Override
    public List<String> showDatabaseAsARestrictedList(String givenUsernameId) {
        List<String> databaseAsAList = new ArrayList<>();
        int checkId = Integer.valueOf(givenUsernameId);
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Class_id,Name_id,Description_id,Requriment_id,Reality_id FROM Abilities WHERE Username_id=?;");
            command.setInt(1, checkId);
            ResultSet querySet = command.executeQuery();
            while (querySet.next()) {   
                int givenClassId = querySet.getInt("Class_id");
                int givenNameId = querySet.getInt("Name_id");
                int givenDescriptionId = querySet.getInt("Description_id");
                int givenRequrimentId = querySet.getInt("Requriment_id");
                int givenRealityId = querySet.getInt("Reality_id");
                String givenTextIdentity = String.valueOf(givenClassId) + "/" + String.valueOf(givenNameId) + "/" + String.valueOf(givenDescriptionId) + "/" + String.valueOf(givenRequrimentId) + "/" + String.valueOf(givenRealityId);
                databaseAsAList.add(givenTextIdentity);
            }
            querySet.close();
            command.close();
            return databaseAsAList;
        } catch (SQLException k) {
            
        } 
        return null;    
    }
}
