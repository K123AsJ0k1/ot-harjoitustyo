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
 * Tietokanta annettuille fiktiivisille ominaisuuksille.
 *
 *
 */
public class AbilityDatabase {

    Connection connection = DriverManager.getConnection("jdbc:sqlite:abilitydatabase:connection");
    Boolean databaseExists=false;
    /**
     * Tietokannan konstruktori.
     *
     *
     * @throws SQLException
     */
    public AbilityDatabase() throws SQLException {
        try {
            Statement command = connection.createStatement();

            command.execute("PRAGMA foreign_keys = ON;");

            command.execute("CREATE TABLE Abilities (id INTEGER PRIMARY KEY, Username_id INTEGER, Class_id INTEGER, Name_id INTEGER, Description_id INTEGER,Requriment_id INTEGER, Reality_id INTEGER);");
            command.execute("CREATE INDEX idx_Ability ON Abilities (Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id);");

            command.close();
            databaseExists=true;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
            databaseExists=false;
        }
    }
    
    public Boolean getDatabaseExists() {
        return databaseExists;
    } 
    /**
     * Lisää uuden ominaisuuden tietokantaan.
     *
     *
     * @param usernameId ominaisuuden luoneen käyttäjän id
     * @param classId luodun luokan id
     * @param nameId luodun nimen id
     * @param descriptionId luodun selosteen id
     * @param requrimentId luodun vaatimuksen id
     * @param realityId luodun todellisuuden id
     * @return palauttaa true jos ominaisuus on lisätty ja false jos ei
     * @throws SQLException 
     */
    public Boolean addAbilityIntoDatabase(int usernameId,int classId, int nameId,int descriptionId, int requrimentId, int realityId) throws SQLException {
        try {
            PreparedStatement command=connection.prepareStatement("INSERT INTO Abilities(Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id) VALUES (?,?,?,?,?,?);");
            command.setInt(1, usernameId);
            command.setInt(2, classId);
            command.setInt(3, nameId);
            command.setInt(4,descriptionId);
            command.setInt(5, requrimentId);
            command.setInt(6,realityId);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    /**
     * Hakee ominaisuuden tietokannasta.
     *
     *
     * @param usernameId ominaisuuden luoneen käyttäjän id
     * @param classId luodun luokan id
     * @param nameId luodun nimen id
     * @param descriptionId luodun selosteen id
     * @param requrimentId luodun vaatimuksen id
     * @param realityId luodun todellisuuden id
     * @return palauttaa true jos ominaisuus on lisätty ja false jos ei
     * @throws SQLException 
     */
    public Boolean searchAbilityFromDatabase(int usernameId,int classId, int nameId,int descriptionId, int requrimentId, int realityId) throws SQLException {
        try {
            PreparedStatement command=connection.prepareStatement("SELECT Username_id,Class_id,Name_id,Description_id,Requriment_id,Reality_id FROM Abilities;");
            ResultSet querrySet=command.executeQuery();
            Boolean abilityExists=false;
            while(querrySet.next()) {
                int userId=querrySet.getInt("Username_id");
                int clasId=querrySet.getInt("Class_id");
                int namId=querrySet.getInt("Name_id");
                int descId=querrySet.getInt("Description_id");
                int reqId=querrySet.getInt("Requriment_id");
                int reaId=querrySet.getInt("Reality_id");
                if (userId==usernameId && clasId==classId && namId==nameId && descId==descriptionId && reqId==requrimentId && reaId==realityId) {
                    abilityExists=true;
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
            System.out.println("Error:" + k);
        }
        return false;
    }
    
    /**
     * Poistaa tietokannan.
     *
     *
     * @return palauttaa true, jos tietokanta on poistettu ja false jos ei
     * @throws SQLException
     */
    public Boolean removeDatabase() throws SQLException {
        try {
            Statement command = connection.createStatement();
            command.execute("DROP TABLE Abilities;");
            command.close();
            databaseExists=false;
            return true;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
}
