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

/**
 *
 * @author niila
 */
public class AbilityDatabase {
    
    Connection ability_Connection=DriverManager.getConnection("jdbc:sqlite:abilitydatabase:connection");
    
    public AbilityDatabase() throws SQLException  {
        try {
            Statement main_Command = ability_Connection.createStatement();
            
            main_Command.execute("PRAGMA foreign_keys = ON;");
            
            main_Command.execute("CREATE TABLE Classes (id INTEGER PRIMARY KEY, Class TEXT UNIQUE);");
            main_Command.execute("CREATE INDEX idx_Class ON Classes (Class);");
            
            main_Command.execute("CREATE TABLE Names (id INTEGER PRIMARY KEY, Name TEXT UNIQUE);");
            main_Command.execute("CREATE INDEX idx_Name ON Names (Name);");
            
            main_Command.execute("CREATE TABLE Descriptions (id INTEGER PRIMARY KEY, Description TEXT UNIQUE);");
            main_Command.execute("CREATE INDEX idx_Description ON Descriptions (Description);");
            
            main_Command.execute("CREATE TABLE Requriments (id INTEGER PRIMARY KEY, Requriment TEXT UNIQUE);");
            main_Command.execute("CREATE INDEX idx_Requriment ON Requriments (Requriment);");
            
            main_Command.execute("CREATE TABLE Realities (id INTEGER PRIMARY KEY, Reality TEXT UNIQUE);");
            main_Command.execute("CREATE INDEX idx_Reality ON Realities (Reality);");
            
            main_Command.execute("CREATE TABLE Abilities (id INTEGER PRIMARY KEY, Username_id INTEGER, Class_id INTEGER REFERENCES Classes, Name_id INTEGER REFERENCES Names, Description_id INTEGER REFERENCES Descriptions,Requriment_id INTEGER REFERENCES Requriments,Reality_id INTEGER REFERENCES Realities);");
            main_Command.execute("CREATE INDEX idx_Ability ON Abilities (Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id);");
            
            main_Command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
    }
    
    public void addClassIntoDatabase(String given_Class) throws SQLException {
        try {
            PreparedStatement main_Command=ability_Connection.prepareStatement("INSERT INTO Classes(Class) VALUES (?);");
            main_Command.setString(1, given_Class);
            main_Command.executeUpdate();
            main_Command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        
    }
    
    public Boolean searchClassFromDatabase(String given_Class) throws SQLException {
        try {
            PreparedStatement main_Command=ability_Connection.prepareStatement("SELECT Class FROM Classes;");
            ResultSet query_Set=main_Command.executeQuery();
            Boolean classExists=false;
            while (query_Set.next()) {
                String searched_Class=query_Set.getString("Class");
                if (searched_Class.equals(given_Class)) {
                    classExists=true;
                    break;
                }
            }
            main_Command.close();
            if (classExists) {
                return true;
            }
            
            return false;
            
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    
    public void addNameIntoDatabase(String given_Name) throws SQLException {
        try {
            PreparedStatement main_Command=ability_Connection.prepareStatement("INSERT INTO Names(Name) VALUES (?);");
            main_Command.setString(1, given_Name);
            main_Command.executeUpdate();
            main_Command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
    }
    
    public Boolean searchNameFromDatabase(String given_Name) throws SQLException {
        try {
            PreparedStatement main_Command=ability_Connection.prepareStatement("SELECT Name FROM Names;");
            ResultSet query_Set=main_Command.executeQuery();
            Boolean nameExists=false;
            while (query_Set.next()) {
                String searched_Name=query_Set.getString("Name");
                if (searched_Name.equals(given_Name)) {
                    nameExists=true;
                    break;
                }
            }
            main_Command.close();
            if (nameExists) {
                return true;
            }
            
            return false;
            
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    
    public void addDescriptionIntoDatabase(String given_Description) throws SQLException {
        try {
            PreparedStatement main_Command=ability_Connection.prepareStatement("INSERT INTO Descriptions(Description) VALUES (?);");
            main_Command.setString(1, given_Description);
            main_Command.executeUpdate();
            main_Command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
    }
    
    public Boolean searchDescriptionFromDatabase(String given_Description) throws SQLException {
        try {
            PreparedStatement main_Command=ability_Connection.prepareStatement("SELECT Description FROM Descriptions;");
            ResultSet query_Set=main_Command.executeQuery();
            Boolean descriptionExists=false;
            while (query_Set.next()) {
                String searched_Description=query_Set.getString("Description");
                if (searched_Description.equals(given_Description)) {
                    descriptionExists=true;
                    break;
                }
            }
            main_Command.close();
            if (descriptionExists) {
                return true;
            }
            
            return false;
            
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    
    public void addRequrimentIntoDatabase(String given_Requriment) throws SQLException {
        try {
            PreparedStatement main_Command=ability_Connection.prepareStatement("INSERT INTO Requriments(Requriment) VALUES (?);");
            main_Command.setString(1, given_Requriment);
            main_Command.executeUpdate();
            main_Command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
    }
    
    public Boolean searchRequrimentFromDatabase(String given_Requriment) throws SQLException {
        try {
            PreparedStatement main_Command=ability_Connection.prepareStatement("SELECT Requriment FROM Requriments;");
            ResultSet query_Set=main_Command.executeQuery();
            Boolean requrimentExists=false;
            while (query_Set.next()) {
                String searched_Requriment=query_Set.getString("Requriment");
                if (searched_Requriment.equals(given_Requriment)) {
                    requrimentExists=true;
                    break;
                }
            }
            main_Command.close();
            if (requrimentExists) {
                return true;
            }
            
            return false;
            
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    
    public void addRealityIntoDatabase(String given_Reality) throws SQLException {
        try {
            PreparedStatement main_Command=ability_Connection.prepareStatement("INSERT INTO Realities(Reality) VALUES (?);");
            main_Command.setString(1, given_Reality);
            main_Command.executeUpdate();
            main_Command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        
    }
    
    public Boolean searchRealityFromDatabase(String given_Reality) throws SQLException {
        try {
            PreparedStatement main_Command=ability_Connection.prepareStatement("SELECT Reality FROM Realities;");
            ResultSet query_Set=main_Command.executeQuery();
            Boolean realityExists=false;
            while (query_Set.next()) {
                String searched_Reality=query_Set.getString("Reality");
                if (searched_Reality.equals(given_Reality)) {
                    realityExists=true;
                    break;
                }
            }
            main_Command.close();
            if (realityExists) {
                return true;
            }
            
            return false;
            
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    
    public void addAbilityIntoDatabase(int id_Username, String given_Class,String given_Name,String given_Description,String given_Requriment,String given_Reality) throws SQLException {
        try{
            if (!(searchClassFromDatabase(given_Class))) {
                return;
            }
            
            PreparedStatement class_Command=ability_Connection.prepareStatement("SELECT id FROM Classes WHERE Class=?;");
            class_Command.setString(1, given_Class);
            ResultSet querry_Class_set=class_Command.executeQuery();
            int class_id=querry_Class_set.getInt("id");
            class_Command.close();
            
            
            if (!(searchNameFromDatabase(given_Name))) {
                return;
            }
            
            PreparedStatement name_Command=ability_Connection.prepareStatement("SELECT id FROM Names WHERE Name=?;");
            name_Command.setString(1, given_Name);
            ResultSet querry_Name_set=name_Command.executeQuery();
            int name_id=querry_Name_set.getInt("id");
            name_Command.close();
            
            if (!(searchDescriptionFromDatabase(given_Description))) {
                return;
            }
            
            PreparedStatement description_Command=ability_Connection.prepareStatement("SELECT id FROM Descriptions WHERE Description=?;");
            description_Command.setString(1, given_Description);
            ResultSet querry_Description_set=description_Command.executeQuery();
            int description_id=querry_Description_set.getInt("id");
            description_Command.close();
            
            if (!(searchRequrimentFromDatabase(given_Requriment))) {
                return;
            }
            
            PreparedStatement requriment_Command=ability_Connection.prepareStatement("SELECT id FROM Requriments WHERE Requriment=?");
            requriment_Command.setString(1, given_Requriment);
            ResultSet querry_Requriment_set=requriment_Command.executeQuery();
            int requriment_id=querry_Requriment_set.getInt("id");
            requriment_Command.close();
            
            if (!(searchRealityFromDatabase(given_Reality))) {
                return;
            }
            
            PreparedStatement reality_Command=ability_Connection.prepareStatement("SELECT id FROM Realities WHERE Reality=?");
            reality_Command.setString(1, given_Reality);
            ResultSet querry_Reality_set=reality_Command.executeQuery();
            int reality_id=querry_Reality_set.getInt("id");
            reality_Command.close();
            
            
            PreparedStatement main_Command=ability_Connection.prepareStatement("INSERT INTO Abilities(Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id) VALUES (?,?,?,?,?,?);");
            main_Command.setInt(1, id_Username);
            main_Command.setInt(2, class_id);
            main_Command.setInt(3, name_id);
            main_Command.setInt(4, description_id);
            main_Command.setInt(5, requriment_id);
            main_Command.setInt(6, reality_id);
            main_Command.executeUpdate();
            main_Command.close();
            
            
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        
    }
    
    public Boolean searchAbilityFromDatabase(int username_id,int class_id,int name_id,int description_id,int requriment_id, int reality_id) throws SQLException {
        try{
            PreparedStatement main_Command=ability_Connection.prepareStatement("SELECT Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id FROM Abilities;");
            ResultSet query_set=main_Command.executeQuery();
            boolean abilityExists=false;
            while(query_set.next()) {
                int user_id=query_set.getInt("Username_id");
                int clas_id=query_set.getInt("Class_id");
                int nam_id=query_set.getInt("Name_id");
                int desc_id=query_set.getInt("Description_id");
                int req_id=query_set.getInt("Requirment_id");
                int rea_id=query_set.getInt("Reality_id");
                
                if (user_id==username_id && class_id==clas_id && name_id==nam_id && description_id==desc_id && requriment_id==req_id && reality_id==rea_id) {
                    abilityExists=true;
                    break;
                }
                
            }
            
            main_Command.close();
            
            if (abilityExists) {
                return true;
            }
            
            return false;
            
            
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        
        return false;
    }
    
    
    public void removeDatabase() throws SQLException {
        try {
            Statement main_Command = ability_Connection.createStatement();
            main_Command.execute("DROP TABLE Classes;");
            main_Command.execute("DROP TABLE Names;");
            main_Command.execute("DROP TABLE Descriptions;");
            main_Command.execute("DROP TABLE Requriments");
            main_Command.execute("DROP TABLE Realities");
            main_Command.execute("DROP TABLE Abilities");
            main_Command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        
    }
    
}
