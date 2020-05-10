/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programscenes;

import assets.ClassTable;
import assets.DescriptionTable;
import assets.NameTable;
import assets.RequrimentTable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author niila
 */
public class AbilityParametersTableScene {
    
    Scene abilityParametersTable;
    Button returnButton;
    TableView classTableview;
    TableView nameTableview;
    TableView descriptionTableview;
    TableView requrimentTableview;
    TableView realityTableview;
    
    public AbilityParametersTableScene() {
        VBox layout = new VBox();

        HBox buttonLayout = new HBox();

        this.returnButton = new Button("Return");
        
        buttonLayout.getChildren().addAll(this.returnButton);
        this.classTableview = new TableView();
        this.nameTableview = new TableView();
        this.descriptionTableview = new TableView();
        this.requrimentTableview = new TableView();
        this.realityTableview = new TableView();

        TableColumn<String, ClassTable> classNumberColumn = new TableColumn<>("Class id");
        classNumberColumn.setCellValueFactory(new PropertyValueFactory<>("classNumberIdentity"));
       
        TableColumn<String, ClassTable> classNameColumn = new TableColumn<>("Class Name");
        classNameColumn.setCellValueFactory(new PropertyValueFactory<>("classNameIdentity"));
        
        this.classTableview.getColumns().addAll(classNumberColumn, classNameColumn);
        
        TableColumn<String, NameTable> nameNumberColumn = new TableColumn<>("Name id");
        nameNumberColumn.setCellValueFactory(new PropertyValueFactory<>("nameNumberIdentity"));
        
        TableColumn<String, NameTable> nameNameColumn = new TableColumn<>("Name name");
        nameNameColumn.setCellValueFactory(new PropertyValueFactory<>("nameNameIdentity"));
        
        this.nameTableview.getColumns().addAll(nameNumberColumn, nameNameColumn);
        
        TableColumn<String, DescriptionTable> descriptionNumberColumn = new TableColumn<>("Description id");
        descriptionNumberColumn.setCellValueFactory(new PropertyValueFactory<>("descriptionNumberIdentity"));
        
        TableColumn<String, DescriptionTable> descriptionNameColumn = new TableColumn<>("Description name");
        descriptionNameColumn.setCellValueFactory(new PropertyValueFactory<>("descriptionNameIdentity"));
        
        this.descriptionTableview.getColumns().addAll(descriptionNumberColumn, descriptionNameColumn);
        
        TableColumn<String, RequrimentTable> requrimentNumberColumn = new TableColumn<>("Requriment id");
        requrimentNumberColumn.setCellValueFactory(new PropertyValueFactory<>("requrimentNumberIdentity"));
        
        TableColumn<String, RequrimentTable> requrimentNameColumn = new TableColumn<>("Requriment name");
        requrimentNameColumn.setCellValueFactory(new PropertyValueFactory<>("requrimentNameIdentity"));
        
        this.requrimentTableview.getColumns().addAll(requrimentNumberColumn,requrimentNameColumn);
        
        TableColumn<String, RequrimentTable> realityNumberColumn = new TableColumn<>("Reality id");
        realityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("realityNumberIdentity"));
        
        TableColumn<String, RequrimentTable> realityNameColumn = new TableColumn<>("Reality name");
        realityNameColumn.setCellValueFactory(new PropertyValueFactory<>("realityNameIdentity"));
        
        this.realityTableview.getColumns().addAll(realityNumberColumn,realityNameColumn);
        
        
        HBox tableViewLayout = new HBox();
        
        tableViewLayout.getChildren().addAll(this.classTableview,this.nameTableview,this.descriptionTableview,this.requrimentTableview,this.realityTableview);
        
        layout.getChildren().addAll(tableViewLayout, buttonLayout);

        layout.setPrefSize(800, 400);

        abilityParametersTable = new Scene(layout);
    }
    
    public Scene getUserDatabaseTableScene() {
        return this.abilityParametersTable;
    }
     
    public Button getReturnButton() {
        return this.returnButton;
    }
    
    public TableView getClassTableView() {
        return this.classTableview;
    }
    
    public TableView getNameTableView() {
        return this.nameTableview;
    }
    
    public TableView getDescriptionTableView() {
        return this.descriptionTableview;
    }
    
    public TableView getRequrimentTableView() {
        return this.requrimentTableview;
    }
    
    public TableView getRealityTableView() {
        return this.realityTableview;
    }
    
}
