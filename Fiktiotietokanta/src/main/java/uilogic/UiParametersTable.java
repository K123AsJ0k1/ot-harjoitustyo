/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import tables.ClassTable;
import tables.DescriptionTable;
import tables.NameTable;
import tables.RealityTable;
import tables.RequrimentTable;
import domain.UsernameInterface;
import java.util.ArrayList;
import java.util.List;
import service.DaoPlayer;

/**
 * Sovelluksen käyttöliittymän parametri taulukon toiminnan hallitsija.
 */
public class UiParametersTable {

    UsernameInterface usernameDatabase;

    /**
     * Konstruktori.
     *
     * @param daoPlayer antaa tarvitun viiteen.
     */
    public UiParametersTable(DaoPlayer daoPlayer) {
        usernameDatabase = daoPlayer.getUsernameDatabase();
    }

    /**
     * Lisää luokka tietokannan tiedot ClassTable olion sisältävään listaan.
     *
     * @param classList luokka tietokannan antaman lista.
     * @return palauttaa tietokannan antamien tietojen mukaisen listan.
     */
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

    /**
     * Lisää nimi tietokannan tiedot NameTable olion sisältävään listaan.
     *
     * @param nameList nimi tietokannan antama lista.
     * @return palauttaa tietokannan antamien tietojen mukaisen listan.
     */
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

    /**
     * Lisää selite tietokannan tiedot DescriptionTable olion sisältävään
     * listaan.
     *
     * @param descriptionList selite tietokannan antama lista.
     * @return palauttaa tietokannan antamien tietojen mukaisen listan.
     */
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

    /**
     * Lisää vaatimus tietokannan tiedot RequrimentTable olion sisältävään
     * listaan.
     *
     * @param requrimentList vaatimus tietokannan antama lista.
     * @return palauttaa tietokannan antamien tietojen mukaisen listan.
     */
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

    /**
     * Lisää todellisuus tietokannan tiedot RealityTable olion sisältävään
     * listaan.
     *
     * @param realityList todellisuus tietokannan antama lista.
     * @return palauttaa tietokannan antamien tietojen mukaisen listan.
     */
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
