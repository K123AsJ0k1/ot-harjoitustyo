/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.UserTable;
import domain.UsernameInterface;
import java.util.ArrayList;
import java.util.List;
import service.DaoPlayer;

/**
 *
 * @author niila
 */
public class UiUserTableLogic {
    
    UsernameInterface usernameDatabase;
    
    public UiUserTableLogic(DaoPlayer daoPlayer) {
        usernameDatabase = daoPlayer.getUsernameDatabase();
    }
    
    public List<UserTable> addUsersIntoAlist(List<String> userList) {
        List<UserTable> returnedList = new ArrayList<>();
        
        for (String userParam : userList) {
            String[] split = userParam.split("/");
            String numberIdentity = split[0];
            String nameIdentity = split[1];
            String privilageIdentity = split[2];
            UserTable addedUser = new UserTable(numberIdentity, nameIdentity, privilageIdentity);
            returnedList.add(addedUser);
        }
        return returnedList;
    }
    
}
