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
 * Sovelluksen käyttöliittymän poista ominaisuuksia lista scene.
 */
public class RemoveAbilities {

    Scene removeAbilitiesScreen;
    Button removeAbilityButton;
    Button returnButton;
    TableView tableview;
    TableView.TableViewSelectionModel<AbilityTable> selectionModel;

    /**
     * Poista ominaisuuksia listan konstruktori.
     */
    public RemoveAbilities() {
        VBox layout = new VBox();

        Label lable = new Label("List of abilities you have created");

        HBox buttonLayout = new HBox();

        this.removeAbilityButton = new Button("Remove selected ability");
        this.returnButton = new Button("Return");

        buttonLayout.getChildren().addAll(this.returnButton, this.removeAbilityButton);
        this.tableview = new TableView();

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

        this.tableview.getColumns().addAll(classColumn, nameColumn, descriptionColumn, requrimentColumn, realityColumn);
        layout.getChildren().addAll(lable, this.tableview, buttonLayout);

        layout.setPrefSize(400, 400);

        this.selectionModel = this.tableview.getSelectionModel();
        this.selectionModel.setSelectionMode(SelectionMode.SINGLE);

        this.removeAbilitiesScreen = new Scene(layout);
    }

    public Scene getRemoveAbilitiesScene() {
        return this.removeAbilitiesScreen;
    }

    public Button getRemoveAbilityButton() {
        return this.removeAbilityButton;
    }

    public Button getReturnButton() {
        return this.returnButton;
    }

    public TableView getTableView() {
        return this.tableview;
    }

    public TableView.TableViewSelectionModel<AbilityTable> getSelectionModel() {
        return this.selectionModel;
    }

}
