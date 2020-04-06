package Fiktiotietokanta.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Käyttäjä tietokanta.
 *
 */
public class UsernameDatabase {

    Connection connection = DriverManager.getConnection("jdbc:sqlite:usernamedatabase:connection");
    Boolean databaseExists = false;

    /**
     * Käyttäjä tietokannan konstruktori.
     * @throws SQLException 
     */
    public UsernameDatabase() throws SQLException {

        try {
            Statement command = connection.createStatement();
            command.execute("PRAGMA foreign_keys = ON;");
            command.execute("CREATE TABLE Usernames (id INTEGER PRIMARY KEY, Username TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Username ON Usernames (Username);");
            command.close();
            databaseExists = true;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        databaseExists = false;
    }
    /**
     * Lisää uuden käyttäjän tietokantaan.
     * @param username käyttäjä nimi 
     */
    public void addUsernameIntoDatabase(String username) {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Usernames(Username) VALUES (?);");
            command.setString(1, username);
            command.executeUpdate();
            command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
    }
    /**
     * Hakee käyttäjän tietokannasta
     * @param username käyttäjä nimi 
     * @Return palauttaa true, jos löytyy ja false jos ei
     */
    public boolean searchForAnExistingUsername(String username) {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Username FROM Usernames;");
            ResultSet querySet = command.executeQuery();
            Boolean usernameExists = false;
            while (querySet.next()) {
                String searchedUsername = querySet.getString("Username");
                if (searchedUsername.equals(username)) {
                    usernameExists = true;
                    break;
                }
            }
            querySet.close();
            command.close();

            if (usernameExists) {
                return true;
            }

            return false;

        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return false;
    }
    /**
     * Hakee käyttäjän id:n tietokannasta
     * @param username käyttäjä nimi 
     * @Return palauttaa tietokanta id:n jos löytyy ja 0 jos ei.
     */
    public Integer getSearchedUsernameId(String username) {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT id FROM Usernames WHERE Username=?;");
            command.setString(1, username);
            ResultSet querySet = command.executeQuery();
            int userId = 0;
            if (querySet.next()) {
                userId = querySet.getInt("id");
            }
            querySet.close();
            command.close();
            
            return userId;
                    
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
        return 0;
    }
    
    /**
     * Poistaa tietokannan.
     * 
     * 
     * @throws SQLException
     */
    public void removeDatabase() throws SQLException {
        try {
            Statement command = connection.createStatement();
            command.execute("DROP TABLE Usernames");
            command.close();
            databaseExists = false;
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
    }

}
