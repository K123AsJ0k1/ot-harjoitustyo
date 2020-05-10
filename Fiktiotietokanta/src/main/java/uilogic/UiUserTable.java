/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import tables.UserTable;
import domain.UsernameInterface;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import service.DaoPlayer;

/** Sovelluksen käyttöliittymän käyttäjä taulun hallitsija.
 */
public class UiUserTable {
    
    UsernameInterface usernameDatabase;
    /** Konstruktori.
     * @param daoPlayer antaa tarvitun viiteen.
    */
    public UiUserTable(DaoPlayer daoPlayer) {
        usernameDatabase = daoPlayer.getUsernameDatabase();
    }
    /** Lisää käyttäjät UserTable olio listaan.
     * @param userList hakee ja antaa tarvitun käyttäjä listan
     * @return palauttaa käyttäjä tietokannan mukaisen listan.
    */
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
    /** Poistaa käyttäjän.
     * @param selectedItems antaa tarkasteltavan tiedot.
    */
    public void removeUser(ObservableList selectedItems) {
        String[] givenUserTableSplit = selectedItems.get(0).toString().split("/");
        usernameDatabase.removeUserInformation(givenUserTableSplit [1]);
    }
    
}
