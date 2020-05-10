/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programscenes;

import assets.UserTable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author niila
 */
public class UserDatabaseTableScene {
    
    Scene useDatabaseTable;
    Button returnButton;
    TableView tableview;
    
    public UserDatabaseTableScene() {
        VBox layout = new VBox();

        Label lable = new Label("List of abilities you have created");

        HBox buttonLayout = new HBox();

        this.returnButton = new Button("Return");
        
        buttonLayout.getChildren().addAll(this.returnButton);
        this.tableview = new TableView();

        TableColumn<String, UserTable> numberColumn = new TableColumn<>("Id");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("numberIdentity"));
       
        TableColumn<String, UserTable> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("usernameIdentity"));
        
        TableColumn<String, UserTable> privilageColumn = new TableColumn<>("Privilage");
        privilageColumn.setCellValueFactory(new PropertyValueFactory<>("privilageIdentity"));
        

        this.tableview.getColumns().addAll(numberColumn, usernameColumn, privilageColumn);
        layout.getChildren().addAll(lable, this.tableview, buttonLayout);

        layout.setPrefSize(200, 400);

        this.useDatabaseTable = new Scene(layout);
    }
    
    public Scene getUserDatabaseTableScene() {
        return this.useDatabaseTable;
    }
     
    public Button getReturnButton() {
        return this.returnButton;
    }
    
    public TableView getTableView() {
        return this.tableview;
    }
    
}
