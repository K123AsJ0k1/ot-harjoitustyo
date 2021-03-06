/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainscenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tables.AbilityTable;

/**
 * Sovelluksen käyttöliittymän valitse ominaisuudet listan scene.
 */
public class ChooseAbilities {

    Scene chooseAbilitiesScreen;
    Button chooseAbilityButton;
    Button returnButton;
    TableView tableView;
    TableView.TableViewSelectionModel<AbilityTable> selectionModel;

    /**
     * Valitse ominaisuudet listan konstruktori.
     */
    public ChooseAbilities() {
        VBox layout = new VBox();

        Label title = new Label("List of abilities you have created");

        HBox buttonLayout = new HBox();

        this.chooseAbilityButton = new Button("Choose selected ability");
        this.returnButton = new Button("Return");

        layout.getChildren().addAll(this.returnButton, this.chooseAbilityButton);
        this.tableView = new TableView();

        TableColumn<String, AbilityTable> classColumn = new TableColumn<>("Class");
        classColumn.setCellValueFactory(new PropertyValueFactory<>("classIdentity"));

        TableColumn<String, AbilityTable> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nameIdentity"));

        TableColumn<String, AbilityTable> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("descriptionIdentity"));

        TableColumn<String, AbilityTable> requrimentColumn = new TableColumn<>("Requriment");
        requrimentColumn.setCellValueFactory(new PropertyValueFactory<>("requrimentIdentity"));

        TableColumn<String, AbilityTable> realityColumn = new TableColumn<>("Reality");
        realityColumn.setCellValueFactory(new PropertyValueFactory<>("realityIdentity"));

        this.tableView.getColumns().addAll(classColumn, nameColumn, descriptionColumn, requrimentColumn, realityColumn);
        layout.getChildren().addAll(title, this.tableView, buttonLayout);

        layout.setPrefSize(400, 400);

        this.selectionModel = this.tableView.getSelectionModel();
        this.selectionModel.setSelectionMode(SelectionMode.SINGLE);

        this.chooseAbilitiesScreen = new Scene(layout);
    }

    public Scene getChoosenAbilitiesScene() {
        return this.chooseAbilitiesScreen;
    }

    public Button getChoosenAbilityButton() {
        return this.chooseAbilityButton;
    }

    public Button getReturnButton() {
        return this.returnButton;
    }

    public TableView getTableView() {
        return this.tableView;
    }

    public TableView.TableViewSelectionModel<AbilityTable> getSelectionModel() {
        return this.selectionModel;
    }

}
