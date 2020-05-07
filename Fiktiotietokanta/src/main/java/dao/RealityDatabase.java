/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.DatabaseInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Todellisuus tietokanta.
 */
public class RealityDatabase implements DatabaseInterface {

    private Connection connection;
    private Boolean databaseExists;
    private String connectionRepresentation;

    /**
     * Todellisuus tietokanta konstruktori.
     *
     * @param useCondition
     */
    public RealityDatabase(String useCondition) {
        try {

            if (useCondition.equals("Normal")) {
                this.connection = DriverManager.getConnection("jdbc:sqlite:realitydatabase:connection");
                this.connectionRepresentation = "jdbc:sqlite:realitydatabase:connection";
            }
            if (useCondition.equals("Test")) {
                this.connection = DriverManager.getConnection("jdbc:sqlite:realitydatabasetest:connection");
                this.connectionRepresentation = "jdbc:sqlite:realitydatabasetest:connection";
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
            command.execute("CREATE TABLE Realities (id INTEGER PRIMARY KEY, Reality TEXT UNIQUE);");
            command.execute("CREATE INDEX idx_Reality ON Realities (Reality);");
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
    public boolean addInformation(String givenReality) {
        try {
            PreparedStatement command = connection.prepareStatement("INSERT INTO Realities(Reality) VALUES (?);");
            command.setString(1, givenReality);
            command.executeUpdate();
            command.close();
            return true;
        } catch (SQLException k) {

        }
        return false;
    }

    @Override
    public boolean searchInformation(String givenReality) {
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

        }

        return false;
    }

    @Override
    public Integer searchInfromationId(String givenReality) {
        try {
            PreparedStatement command = connection.prepareStatement("SELECT id FROM Realities WHERE Reality=?;");
            command.setString(1, givenReality);
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
    public boolean removeInformation(String givenReality) {
        try {
            PreparedStatement command = connection.prepareStatement("DELETE FROM Realities WHERE Reality=?");
            command.setString(1, givenReality);
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
            command.execute("DROP TABLE Realities");
            command.close();
            databaseExists = false;
            return true;
        } catch (SQLException k) {

        }

        return false;
    }

    @Override
    public String searchInformationTextIdentity(String givenRealityId) {

        int checkId = Integer.valueOf(givenRealityId);

        try {
            PreparedStatement command = connection.prepareStatement("SELECT Reality FROM Realities WHERE id=?");
            command.setInt(1, checkId);
            ResultSet querySet = command.executeQuery();
            String givenTextIdentity = "null";
            if (querySet.next()) {
                givenTextIdentity = querySet.getString("Reality");
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
            PreparedStatement command = connection.prepareStatement("SELECT Reality FROM Realities;");
            ResultSet querySet = command.executeQuery();
            while (querySet.next()) {
                String givenClass = querySet.getString("Reality");
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
