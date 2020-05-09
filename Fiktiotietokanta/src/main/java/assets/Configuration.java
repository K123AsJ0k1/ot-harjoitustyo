/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets;

import domain.FileManagerInterface;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author niila
 */
public class Configuration {

    String mode;
    String folderName;
    String usenameDName;
    String classDName;
    String nameDName;
    String descriptionDName;
    String requrimentDName;
    String realityDName;
    String abilityDName;
    List<Admin> adminList;

    public Configuration() {
        this.mode = "null";
        this.folderName = "databases";
        this.usenameDName = "UsernameDatabase";
        this.classDName = "ClassDatabase";
        this.nameDName = "NameDatabase";
        this.descriptionDName = "DescriptionDatabase";
        this.requrimentDName = "RequrimentDatabase";
        this.realityDName = "RealityDatabase";
        this.abilityDName = "AbilityDatabase";
        adminList = new ArrayList<>();
    }

    public void resetNames() {
        this.folderName = "databases";
        this.usenameDName = "UsernameDatabase";
        this.classDName = "ClassDatabase";
        this.nameDName = "NameDatabase";
        this.descriptionDName = "DescriptionDatabase";
        this.requrimentDName = "RequrimentDatabase";
        this.realityDName = "RealityDatabase";
        this.abilityDName = "AbilityDatabase";
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String givenMode) {
        this.mode = givenMode;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public void setFolderName(String givenName) {
        this.folderName = givenName;
    }

    public String getUsernameDName() {
        return this.usenameDName;
    }

    public void setUsernameDName(String givenName) {
        this.usenameDName = givenName;
    }
    
    public String getClassDName() {
        return this.classDName;
    }
    
    public void setClassDName(String givenName) {
        this.classDName = givenName;
    }

    public String getNameDName() {
        return this.nameDName;
    }

    public void setNameDName(String givenName) {
        this.nameDName = givenName;
    }

    public String getDescriptionDName() {
        return this.descriptionDName;
    }

    public void setDescriptionDName(String givenName) {
        this.descriptionDName = givenName;
    }

    public String getRequrimentDName() {
        return this.requrimentDName;
    }

    public void setRequrimentDName(String givenName) {
        this.requrimentDName = givenName;
    }

    public String getRealityDName() {
        return this.realityDName;
    }

    public void setRealityDName(String givenName) {
        this.realityDName = givenName;
    }
    
    public String getAbilityDName() {
        return this.abilityDName;
    }
    
    public void setAbilityDName(String givenName) {
        this.abilityDName = givenName;
    }

    public void addAdmin(String givenUsername, String givenPassword) {
        this.adminList.add(new Admin(givenUsername, givenPassword));
    }

    public List<Admin> getAdminList() {
        return this.adminList;
    }

    public String createConfigString() {
        String configString = "";

        configString = "ProgramMode:" + this.mode;

        configString = configString + "\n" + "FolderName:" + this.folderName;

        configString = configString + "\n" + "UsernameDatabaseName:" + this.usenameDName;
        
        configString = configString + "\n" + "ClassDatabaseName:" + this.classDName;

        configString = configString + "\n" + "NameDatabaseName:" + this.nameDName;

        configString = configString + "\n" + "DescriptionDatabaseName:" + this.descriptionDName;

        configString = configString + "\n" + "RequrimentDatabaseName:" + this.requrimentDName;

        configString = configString + "\n" + "RealityDatabaseName:" + this.realityDName;
        
        configString = configString + "\n" + "AbilityDatabaseName:" + this.abilityDName;

        return configString;
    }

    public boolean readConfigFile(FileManagerInterface fileManager) {
        String path = fileManager.getUserPath() + File.separator + "config";
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] table = line.split(":");
                if (table[0].equals("ProgramMode")) {
                    this.mode = table[1];
                }
                if (table[0].equals("FolderName")) {
                    this.folderName = table[1];
                }
                if (table[0].equals("UsernameDatabaseName")) {
                    this.usenameDName = table[1];
                }
                if (table[0].equals("ClassDatabaseName")) {
                    this.classDName = table[1];
                }
                if (table[0].equals("NameDatabaseName")) {
                    this.nameDName = table[1];
                }
                if (table[0].equals("DescriptionDatabaseName")) {
                    this.descriptionDName = table[1];
                }
                if (table[0].equals("RequrimentDatabaseName")) {
                    this.requrimentDName = table[1];
                }
                if (table[0].equals("RealityDatabaseName")) {
                    this.realityDName = table[1];
                }
                if (table[0].equals("AbilityDatabaseName")) {
                    this.abilityDName = table[1];
                }

            }

            return true;
        } catch (IOException ex) {

        }
        return false;
    }

}
