/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.ClassTable;
import assets.DescriptionTable;
import assets.NameTable;
import assets.RealityTable;
import assets.RequrimentTable;
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
    
    public List<DescriptionTable> addDescriptionIntoAlist(List<String> descriptionList) {
        List<DescriptionTable> returnedList = new ArrayList<>();
        
        for (String descriptionParam : descriptionList) {
            String[] split = descriptionParam.split("/");
            String numberIdentity = split[0];
            String nameIdentity = split[1];
            DescriptionTable addedDescription = new DescriptionTable(numberIdentity, nameIdentity);
            returnedList.add(addedDescription);
        }
        return returnedList;
    }
    
    public List<RequrimentTable> addRequrimentIntoAlist(List<String> requrimentList) {
        List<RequrimentTable> returnedList = new ArrayList<>();
        
        for (String requrimentParam : requrimentList) {
            String[] split = requrimentParam.split("/");
            String numberIdentity = split[0];
            String nameIdentity = split[1];
            RequrimentTable addedRequriment = new RequrimentTable(numberIdentity, nameIdentity);
            returnedList.add(addedRequriment);
        }
        return returnedList;
    }
    
    public List<RealityTable> addRealityIntoAlist(List<String> realityList) {
        List<RealityTable> returnedList = new ArrayList<>();
        
        for (String realityParam : realityList) {
            String[] split = realityParam.split("/");
            String numberIdentity = split[0];
            String nameIdentity = split[1];
            RealityTable addedReality = new RealityTable(numberIdentity, nameIdentity);
            returnedList.add(addedReality);
        }
        return returnedList;
    }
    
    
    
}
