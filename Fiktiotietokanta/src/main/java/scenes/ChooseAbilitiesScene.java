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
public class ChooseAbilitiesScene {
    
    public ChooseAbilitiesScene() {
        VBox chooseAbilityLayout = new VBox();

        Label chooseAbilityTableViewLable = new Label("List of abilities you have created");

        HBox chooseAbilityButtonLayout = new HBox();

        Button chooseSelectedAbilityTableView = new Button("Choose selected ability");
        Button returnChooseAbilityMenuTableView = new Button("Return");
        
        chooseAbilityLayout.getChildren().addAll(returnChooseAbilityMenuTableView, chooseSelectedAbilityTableView);
        TableView chooseAbilityTableView = new TableView();

        TableColumn<String, Ability> classChooseAbilityTableViewColumn = new TableColumn<>("Class");
        classChooseAbilityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("classIdentity"));
        TableColumn<String, Ability> nameChooseAbilityTableViewColumn = new TableColumn<>("Name");
        nameChooseAbilityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("nameIdentity"));
        TableColumn<String, Ability> descriptionChooseAbilityTableViewColumn = new TableColumn<>("Description");
        descriptionChooseAbilityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("descriptionIdentity"));
        TableColumn<String, Ability> requrimentChooseAbilityTableViewColumn = new TableColumn<>("Requriment");
        requrimentChooseAbilityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("requrimentIdentity"));
        TableColumn<String, Ability> realityChooseAbilityTableViewColumn = new TableColumn<>("Reality");
        realityChooseAbilityTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("realityIdentity"));

        chooseAbilityTableView.getColumns().addAll(classChooseAbilityTableViewColumn, nameChooseAbilityTableViewColumn, descriptionChooseAbilityTableViewColumn, requrimentChooseAbilityTableViewColumn, realityChooseAbilityTableViewColumn);
        chooseAbilityLayout.getChildren().addAll(chooseAbilityTableViewLable, chooseAbilityTableView, chooseAbilityButtonLayout);

        chooseAbilityLayout.setPrefSize(400, 400);

        TableView.TableViewSelectionModel<Ability> selectionModelChooseAbilityTableView = chooseAbilityTableView.getSelectionModel();
        selectionModelChooseAbilityTableView.setSelectionMode(SelectionMode.SINGLE);

        Scene chooseAbilityTable = new Scene(chooseAbilityLayout);
    }
    
}
