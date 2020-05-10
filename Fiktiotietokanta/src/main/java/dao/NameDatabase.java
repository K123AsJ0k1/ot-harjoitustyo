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
/** Ominaisuus tietokannan nimi parametrin tietokanta.
 */
public class NameDatabase implements DatabaseInterface {
    private Connection connection;
    private Boolean databaseExists;
    private String connectionRepresentation;
   /** Tietokannan konstruktori.
     * @param fileManager antaa tarvitun tiedosto polun.
     * @param useCondition tietokannan käyttämiseen tila.
     * @param givenDatabaseName tietokannalle annettu nimi.
     */
    public NameDatabase(FileManagerInterface fileManager, String useCondition, String givenDatabaseName) {
        try {
            if (useCondition.equals("Normal")) {
                String name = givenDatabaseName + ":connection";
                String path = "jdbc:sqlite:" + fileManager.getDirectoryPath() + File.separator + name;
                this.connection = DriverManager.getConnection(path);
                connectionRepresentation = path;
            }
            if (useCondition.equals("Test")) {
                String name = givenDatabaseName + "Test:connection";
                String path = "jdbc:sqlite:" + fileManager.getDirectoryPath() + File.separator + name;
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
        try {
            PreparedStatement command = connection.prepareStatement("DELETE FROM Names WHERE Name=?");
            command.setString(1, givenName);
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
            command.execute("DROP TABLE Names;");
            command.close();
            databaseExists = false;
            return true;
        } catch (SQLException k) {

        }
        return false;
    }
    @Override
    public String searchInformationTextIdentity(String givenNameId) {
        int checkId = Integer.valueOf(givenNameId);
        try {
            PreparedStatement command = connection.prepareStatement("SELECT Name FROM Names WHERE id=?");
            command.setInt(1, checkId);
            ResultSet querySet = command.executeQuery();
            String givenTextIdentity = "null";
            if (querySet.next()) {
                givenTextIdentity = querySet.getString("Name");
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
            PreparedStatement command = connection.prepareStatement("SELECT id,Name FROM Names;");
            ResultSet querySet = command.executeQuery();
            while (querySet.next()) {
                Integer givenId = querySet.getInt("id");
                String givenClass = querySet.getString("Name");
                String identity = String.valueOf(givenId) + "/" + givenClass;
                databaseAsAList.add(identity);
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
        List<String> emptyList = new ArrayList<>();
        return emptyList;
    }
    @Override
    public String getConnectionString() {
        return this.connectionRepresentation;
    }
}
