/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainscenes;

import tables.UserTable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Sovelluksen käyttöliittymän käyttäjä tietokanta taulu scene.
 */
public class UserDatabaseTable {

    Scene useDatabaseTable;
    Button returnButton;
    Button removeButton;
    TableView tableview;
    TableView.TableViewSelectionModel<UserTable> selectionModel;

    /**
     * Käyttäjä tietokanta taulun konstruktori.
     */
    public UserDatabaseTable() {
        VBox layout = new VBox();

        HBox buttonLayout = new HBox();

        this.returnButton = new Button("Return");
        this.removeButton = new Button("Remove user");

        buttonLayout.getChildren().addAll(this.returnButton, this.removeButton);
        this.tableview = new TableView();

        TableColumn<String, UserTable> numberColumn = new TableColumn<>("Id");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("numberIdentity"));

        TableColumn<String, UserTable> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("usernameIdentity"));

        TableColumn<String, UserTable> privilageColumn = new TableColumn<>("Privilage");
        privilageColumn.setCellValueFactory(new PropertyValueFactory<>("privilageIdentity"));

        this.tableview.getColumns().addAll(numberColumn, usernameColumn, privilageColumn);
        layout.getChildren().addAll(this.tableview, buttonLayout);

        layout.setPrefSize(200, 400);

        this.selectionModel = this.tableview.getSelectionModel();
        this.selectionModel.setSelectionMode(SelectionMode.SINGLE);

        this.useDatabaseTable = new Scene(layout);
    }

    public Scene getUserDatabaseTableScene() {
        return this.useDatabaseTable;
    }

    public Button getReturnButton() {
        return this.returnButton;
    }

    public Button getRemoveButton() {
        return this.removeButton;
    }

    public TableView getTableView() {
        return this.tableview;
    }

    public TableView.TableViewSelectionModel<UserTable> getSelectionModel() {
        return this.selectionModel;
    }

}
