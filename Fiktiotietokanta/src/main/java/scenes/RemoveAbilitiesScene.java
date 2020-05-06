/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import service.Ability;

/**
 *
 * @author niila
 */
public class RemoveAbilitiesScene {
    
    public RemoveAbilitiesScene() {
        VBox removeAbilityLayout = new VBox();

        Label removeAbilityTableViewLable = new Label("List of abilities you have created");

        HBox removeAbilityButtonLayout = new HBox();

        Button removeSelectedAbilityTableView = new Button("Remove selected ability");
        Button returnAbilityMenuTableView = new Button("Return");
        
        removeAbilityButtonLayout.getChildren().addAll(returnAbilityMenuTableView, removeSelectedAbilityTableView);
        TableView removeAbilityTableView = new TableView();

        TableColumn<String, Ability> classTableViewColumn = new TableColumn<>("Class");
        classTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("classIdentity"));
        TableColumn<String, Ability> nameTableViewColumn = new TableColumn<>("Name");
        nameTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("nameIdentity"));
        TableColumn<String, Ability> descriptionTableViewColumn = new TableColumn<>("Description");
        descriptionTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("descriptionIdentity"));
        TableColumn<String, Ability> requrimentTableViewColumn = new TableColumn<>("Requriment");
        requrimentTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("requrimentIdentity"));
        TableColumn<String, Ability> realityTableViewColumn = new TableColumn<>("Reality");
        realityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("realityIdentity"));

        removeAbilityTableView.getColumns().addAll(classTableViewColumn, nameTableViewColumn, descriptionTableViewColumn, requrimentTableViewColumn, realityTableViewColumn);
        removeAbilityLayout.getChildren().addAll(removeAbilityTableViewLable, removeAbilityTableView, removeAbilityButtonLayout);

        removeAbilityLayout.setPrefSize(320, 400);

        TableView.TableViewSelectionModel<Ability> selectionModelTableView = removeAbilityTableView.getSelectionModel();
        selectionModelTableView.setSelectionMode(SelectionMode.SINGLE);

        Scene removeAbilityTable = new Scene(removeAbilityLayout);
    }
    
}
