/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filelogic;

import domain.FileManagerInterface;
import java.io.File;

/**
 * Sovelluksen tiedoston hallitsija.
 */
public class FileManager implements FileManagerInterface {

    String directoryPath;

    /**
     * Konstruktori.
     */
    public FileManager() {
        this.directoryPath = "";
    }

    @Override
    public String getUserPath() {
        return System.getProperty("user.dir");
    }

    @Override
    public String getDirectoryPath() {
        return directoryPath;
    }

    @Override
    public Boolean createStandardDirectory() {
        String createdPath = getUserPath() + File.separator + "projectdatabases";

        boolean creationOfDir = new File(createdPath).mkdir();

        if (creationOfDir) {
            this.directoryPath = createdPath;
            return true;
        }
        this.directoryPath = createdPath;
        return false;
    }

    @Override
    public Boolean createModifiedDirectory(String givenName) {
        String createdPath = getUserPath() + File.separator + givenName;

        boolean creationOfDir = new File(createdPath).mkdir();

        if (creationOfDir) {
            this.directoryPath = createdPath;
            return true;
        }
        this.directoryPath = createdPath;
        return false;
    }

    @Override
    public Boolean configFileExists() {
        String path = getUserPath() + File.separator + "config";
        File file = new File(path);
        return file.exists();
    }

}
