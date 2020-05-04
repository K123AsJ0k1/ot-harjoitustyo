package dao;

import domain.UsernameInterface;
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
public class UsernameDatabase implements UsernameInterface {

    private Connection connection;
    private Boolean databaseExists;
    private String connectionRepresentation;

    /**
    * Käyttäjä tietokannan konstruktori.
     * @param useCondition annettu tila vaatimus.
    * @throws java.lang.Exception virhe.
    */
    
    public UsernameDatabase(String useCondition) throws Exception {
        if (useCondition.equals("Normal")) {
           this.connection = DriverManager.getConnection("jdbc:sqlite:usernamedatabase:connection"); 
           connectionRepresentation = "jdbc:sqlite:usernamedatabase:connection";
        }
        if (useCondition.equals("Test")) {
           this.connection = DriverManager.getConnection("jdbc:sqlite:usernamedatabasetest:connection"); 
           connectionRepresentation = "jdbc:sqlite:usernamedatabasetest:connection";
        }
        
        this.databaseExists = false;
    }
    
    @Override
    public boolean createUsernameDatabase() throws Exception  {
        try {
            Statement command = connection.createStatement();
            command.execute("PRAGMA foreign_keys = ON;");
            command.execute("CREATE TABLE Usernames (id INTEGER PRIMARY KEY, Username TEXT UNIQUE, Password TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Username ON Usernames (Username,Password);");
            command.close();
            databaseExists = true;
            return true;
        } catch (SQLException k) {
            
        }
        return false;
    }
    
    @Override
    public boolean usernameDatabaseExists()  {
        return databaseExists;
    }
     
    @Override
    public boolean addUserInformation(String username, String password) {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Usernames(Username,Password) VALUES (?,?);");
            command.setString(1, username);
            command.setString(2, password);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            
        }
        return false;
    }
    
    
    @Override
    public boolean searchUserInformation(String username) {
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
            
        }
        return false;
    }
    
    @Override
    public boolean removeUserInformation(String username)  {
        try {
            PreparedStatement command = connection.prepareStatement("DELETE FROM Usernames WHERE Username=?;");
            command.setString(1, username);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {
            
        }
        return false;
    }
    
    
    @Override
    public boolean removeUsernameDatabase() throws Exception {
        try {
            Statement command = connection.createStatement();
            command.execute("DROP TABLE Usernames");
            command.close();
            databaseExists = false;
            return true;
        } catch (SQLException k) {
           
        }
        return false;
    }

    @Override
    public Integer searchUsernameId(String username) {
       
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
            
        }
        return 0;
    }

    @Override
    public boolean userPasswordCheck(String username, String password) {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Username,Password FROM Usernames;");
            ResultSet querySet = command.executeQuery();
            Boolean usernameExists = false;
            while (querySet.next()) {
                String searchedUsername = querySet.getString("Username");
                String searchedPassword = querySet.getString("Password");
                if (searchedUsername.equals(username) && searchedPassword.equals(password)) {
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
            
        }
        return false;
    }

    @Override
    public String getConnectionString() {
        return this.connectionRepresentation;
    }
    
   
}
