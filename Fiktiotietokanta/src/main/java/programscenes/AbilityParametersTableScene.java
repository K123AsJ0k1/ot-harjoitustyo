/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programscenes;

import assets.ClassTable;
import assets.NameTable;
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
    
    public AbilityParametersTableScene() {
        VBox layout = new VBox();

        Label lable = new Label("List of abilities you have created");

        HBox buttonLayout = new HBox();

        this.returnButton = new Button("Return");
        
        buttonLayout.getChildren().addAll(this.returnButton);
        this.classTableview = new TableView();
        this.nameTableview = new TableView();

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
        
        
        layout.getChildren().addAll(lable, this.classTableview, nameTableview, buttonLayout);

        layout.setPrefSize(200, 400);

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
    
}
