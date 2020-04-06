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
public class AbilityParametersDatabase {
    
    Connection connection = DriverManager.getConnection("jdbc:sqlite:abilityparametersdatabase:connection");

    /**
     * Tietokannan konstruktori
     *
     * @throws SQLException huomaa mahdolliset virheet
     */
    
    public AbilityParametersDatabase() throws SQLException {
        try {
            Statement command = connection.createStatement();

            command.execute("PRAGMA foreign_keys = ON;");

            command.execute("CREATE TABLE Classes (id INTEGER PRIMARY KEY, Class TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Class ON Classes (Class);");

            command.execute("CREATE TABLE Names (id INTEGER PRIMARY KEY, Name TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Name ON Names (Name);");

            command.execute("CREATE TABLE Descriptions (id INTEGER PRIMARY KEY, Description TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Description ON Descriptions (Description);");

            command.execute("CREATE TABLE Requriments (id INTEGER PRIMARY KEY, Requriment TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Requriment ON Requriments (Requriment);");

            command.execute("CREATE TABLE Realities (id INTEGER PRIMARY KEY, Reality TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Reality ON Realities (Reality);");

            command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
    }
    /**
     * Luokkan lisääjä
     * @param givenClass annettu luokka
     * @return antaa totuusarvon, onko luokka lisätty vai ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean addClassIntoDatabase(String givenClass) throws SQLException {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Classes(Class) VALUES (?);");
            command.setString(1, givenClass);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
       return false;
    }
    /**
     * Tarkastaa luokan olemassa olon tietokannasta
     * @param givenClass annettu luokka
     * @return antaa totuusarvon true jos luokka löytyi ja false jos ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean searchClassFromDatabase(String givenClass) throws SQLException {
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
            System.out.println("Error:" + k);
        }
        return false;
    }
    /**
     * Lisää nimen tietokantaan
     * @param givenName annettu nimi
     * @return antaa totuusarvon true jos nimi lisättiin ja false jos ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean addNameIntoDatabase(String givenName) throws SQLException {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Names(Name) VALUES (?);");
            command.setString(1, givenName);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    /**
     * Tarkastaa nimen olemassa olon tietokannasta
     * @param givenName annettu nimi
     * @return antaa totuusarvon true jos nimi löytyi ja false jos ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean searchNameFromDatabase(String givenName) throws SQLException {
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
            System.out.println("Error:" + k);
        }
        return false;
    }
    /**
     * Lisää selosteen tietokantaan
     * @param givenDescription annettu seloste
     * @return antaa totuusarvon true jos seloste lisättiin ja false jos ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean addDescriptionIntoDatabase(String givenDescription) throws SQLException {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Descriptions(Description) VALUES (?);");
            command.setString(1, givenDescription);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    /**
     * Tarkastaa selosteen olemassa olon tietokannasta
     * @param givenDescription annettu seloste
     * @return antaa totuusarvon true jos seloste löytyi ja false jos ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean searchDescriptionFromDatabase(String givenDescription) throws SQLException {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Description FROM Descriptions;");
            ResultSet querySet = command.executeQuery();
            Boolean descriptionExists = false;
            while (querySet.next()) {
                String searchedDescription = querySet.getString("Description");
                if (searchedDescription.equals(givenDescription)) {
                    descriptionExists = true;
                    break;
                }
            }
            querySet.close();
            command.close();
            if (descriptionExists) {
                return true;
            }

            return false;

        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    /**
     * Lisää vaatimuksen tietokantaan
     * @param givenRequriment annettu vaatimus
     * @return antaa totuusarvon true jos vaatimus lisättiin ja false jos ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean addRequrimentIntoDatabase(String givenRequriment) throws SQLException {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Requriments(Requriment) VALUES (?);");
            command.setString(1, givenRequriment);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    /**
     * Tarkastaa vaatimuksen olemassa olon tietokannasta
     * @param givenRequriment annettu vaatimus
     * @return antaa totuusarvon true jos vaatimus löytyi ja false jos ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean searchRequrimentFromDatabase(String givenRequriment) throws SQLException {
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
            System.out.println("Error:" + k);
        }
        return false;
    }
    
    /**
     * Tarkastaa todellisuuden olemassa olon tietokannasta
     * @param givenReality annettu todellisuus
     * @return antaa totuusarvon true jos vaatimus löytyi ja false jos ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean addRealityIntoDatabase(String givenReality) throws SQLException {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Realities(Reality) VALUES (?);");
            command.setString(1, givenReality);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    /**
     * Tarkastaa todellisuuden olemassa olon tietokannasta
     * @param givenReality annettu todellisuus
     * @return antaa totuusarvon true jos vaatimus löytyi ja false jos ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean searchRealityFromDatabase(String givenReality) throws SQLException {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Reality FROM Realities;");
            ResultSet querySet = command.executeQuery();
            Boolean realityExists = false;
            while (querySet.next()) {
                String searchedReality = querySet.getString("Reality");
                if (searchedReality.equals(givenReality)) {
                    realityExists = true;
                    break;
                }
            }
            querySet.close();
            command.close();
            if (realityExists) {
                return true;
            }

            return false;

        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    /**
     * Poistaa olemassa olevan tietokannan
     * @return antaa totuusarvon true, jos tietokanta on poistettu ja false jos ei
     * @throws SQLException virheen huomatessa annettaan false
     */
    public Boolean removeDatabase() throws SQLException {
        try {
            Statement command = connection.createStatement();
            command.execute("DROP TABLE Classes;");
            command.execute("DROP TABLE Names;");
            command.execute("DROP TABLE Descriptions;");
            command.execute("DROP TABLE Requriments");
            command.execute("DROP TABLE Realities");
            command.close();
            return true;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
}
