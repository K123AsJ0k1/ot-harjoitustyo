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
 *
 * @author niila
 */
public class UsernameDatabase {

    Connection username_Connection = DriverManager.getConnection("jdbc:sqlite:usernamedatabase:connection");

    public UsernameDatabase() throws SQLException {
        
        try {
            Statement main_Command = username_Connection.createStatement();
            main_Command.execute("PRAGMA foreign_keys = ON;");
            main_Command.execute("CREATE TABLE Usernames (id INTEGER PRIMARY KEY, Username TEXT UNIQUE);");
            main_Command.execute("CREATE INDEX idx_Username ON Usernames (Username);");
            main_Command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
    }
    
    public void addUsernameIntoDatabase(String username) {
        try {
            PreparedStatement main_Command=username_Connection.prepareStatement("INSERT INTO Usernames(Username) VALUES (?);");
            main_Command.setString(1, username);
            main_Command.executeUpdate();
            main_Command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
    }
    
    public boolean searchForAnExistingUsername(String username) {
        try {
            PreparedStatement main_Command=username_Connection.prepareStatement("SELECT Username FROM Usernames;");
            ResultSet query_Set=main_Command.executeQuery();
            Boolean usernameExists=false;
            while (query_Set.next()) {
                String searched_Username=query_Set.getString("Username");
                if (searched_Username.equals(username)) {
                    usernameExists=true;
                    break;
                }
            }
            main_Command.close();
            
            if (usernameExists) {
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
            Statement main_Command = username_Connection.createStatement();
            main_Command.execute("DROP TABLE Usernames");
            main_Command.close();
        } catch (SQLException k) {
            System.out.println("Error:" + k);
        }
    }

}
