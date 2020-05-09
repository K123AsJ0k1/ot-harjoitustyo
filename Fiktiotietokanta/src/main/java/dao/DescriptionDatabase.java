/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.DatabaseInterface;
import domain.FileManagerInterface;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Selitys tietokanta.
 *
 *
 */
public class DescriptionDatabase implements DatabaseInterface {

    private Connection connection;
    private Boolean databaseExists;
    private String connectionRepresentation;

    /**
     * Selitys tietokannan konstruktori.
     *
     *
     * @param fileManager
     * @param useCondition annettu tila.
     * @param givenDatabaseName
     * 
     */
    public DescriptionDatabase(FileManagerInterface fileManager, String useCondition, String givenDatabaseName) {
        try {
            if (useCondition.equals("Normal")) {
                String name = givenDatabaseName+":connection";
                String path = "jdbc:sqlite:"+fileManager.getDirectoryPath() + File.separator + name;
                this.connection = DriverManager.getConnection(path);
                connectionRepresentation = path;
            }
            if (useCondition.equals("Test")) {
                String name = givenDatabaseName+"Test:connection";
                String path = "jdbc:sqlite:"+fileManager.getDirectoryPath() + File.separator + name;
                this.connection = DriverManager.getConnection(path);
                connectionRepresentation = path;
            }
            
            this.databaseExists = false;
        } catch (SQLException k) {
            this.databaseExists = null;
        }
        

    }

    @Override
    public boolean createDatabase() {
        try {
            Statement command = connection.createStatement();
            command.execute("PRAGMA foreign_keys = ON;");
            command.execute("CREATE TABLE Descriptions (id INTEGER PRIMARY KEY, Description TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Description ON Descriptions (Description);");
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
    public boolean addInformation(String givenDescription) {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Descriptions(Description) VALUES (?);");
            command.setString(1, givenDescription);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {

        }
        return false;
    }

    @Override
    public boolean searchInformation(String givenDescription) {
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

        }
        return false;
    }

    @Override
    public Integer searchInfromationId(String givenDescription) {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT id FROM Descriptions WHERE Description=?;");
            command.setString(1, givenDescription);
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
    public boolean removeInformation(String givenDescription) {
        try {
            PreparedStatement command = connection.prepareStatement("DELETE FROM Descriptions WHERE Description=?");
            command.setString(1, givenDescription);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {

        }
        return false;
    }

    @Override
    public boolean removeDatabase() {
        try {
            Statement command = connection.createStatement();
            command.execute("DROP TABLE Descriptions;");
            command.close();
            databaseExists = false;
            return true;
        } catch (SQLException k) {

        }
        return false;

    }

    @Override
    public String searchInformationTextIdentity(String givenDescriptionId) {
        int checkId = Integer.valueOf(givenDescriptionId);
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Description FROM Descriptions WHERE id=?");
            command.setInt(1, checkId);
            ResultSet querySet = command.executeQuery();
            String givenTextIdentity = "null";
            if (querySet.next()) {
                givenTextIdentity = querySet.getString("Description");
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
            PreparedStatement command = connection.prepareStatement("SELECT Description FROM Descriptions;");
            ResultSet querySet = command.executeQuery();
            while (querySet.next()) {
                String givenClass = querySet.getString("Description");
                databaseAsAList.add(givenClass);
            }
            querySet.close();
            command.close();
            return databaseAsAList;
        } catch (SQLException k) {

        }
        return databaseAsAList;
    }

    @Override
    public List<String> showDatabaseAsARestrictedList(String information) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getConnectionString() {
        return this.connectionRepresentation;
    }

}
