/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.ClassTable;
import assets.NameTable;
import assets.UserTable;
import domain.UsernameInterface;
import java.util.ArrayList;
import java.util.List;
import service.DaoPlayer;

/**
 *
 * @author niila
 */
public class UiParametersTableLogic {
    
    UsernameInterface usernameDatabase;
    
    public UiParametersTableLogic(DaoPlayer daoPlayer) {
        usernameDatabase = daoPlayer.getUsernameDatabase();
    }
    
    public List<ClassTable> addClassesIntoAlist(List<String> classList) {
        List<ClassTable> returnedList = new ArrayList<>();
        
        for (String classParam : classList) {
            String[] split = classParam.split("/");
            String numberIdentity = split[0];
            String nameIdentity = split[1];
            ClassTable addedClass = new ClassTable(numberIdentity, nameIdentity);
            returnedList.add(addedClass);
        }
        return returnedList;
    }
    
    public List<NameTable> addNamesIntoAlist(List<String> nameList) {
        List<NameTable> returnedList = new ArrayList<>();
        
        for (String nameParam : nameList) {
            String[] split = nameParam.split("/");
            String numberIdentity = split[0];
            String nameIdentity = split[1];
            NameTable addedName = new NameTable(numberIdentity, nameIdentity);
            returnedList.add(addedName);
        }
        return returnedList;
    }
    
    
    
}
