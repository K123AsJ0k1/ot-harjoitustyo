/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package installationscenes;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import layoutassets.CDSettingLayout;
import layoutassets.DDSettingLayout;
import layoutassets.FolderSettingLayout;
import layoutassets.NDSettingLayout;
import layoutassets.ReaDSettingLayout;
import layoutassets.ReqDSettingLayout;
import layoutassets.UDSettingLayout;
import service.LayoutPlayer;

/**
 *
 * @author niila
 */
public class DaoSettingsScene {
    
    Scene daoSettingScene;
    GridPane layout;
    Label usedDao;
    MenuItem folder;
    MenuItem usnaDaba;
    MenuItem casDaba;
    MenuItem nameDaba;
    MenuItem deipDaba;
    MenuItem reriDaba;
    MenuItem reliDaba;
    TextArea nameInput;
    TextArea pathInput;
    Button previous;
    Button next;
    Button checkName;
    Button checkPath;
    Button choosePath;
    
    
    public DaoSettingsScene() {
             
        layout = new GridPane();
        
        Label title = new Label("Data access object settings");
        usedDao = new Label("Currently used data access object:");
        Text description = new Text("You can configure these given options, or continue to the next step");
        
        MenuBar menuBar = new MenuBar();
        menuBar.setMaxSize(120, 5);
        Menu menu = new Menu("Change database");
        folder = new MenuItem("Check folder settings");
        usnaDaba = new MenuItem("Check username database settings");
        casDaba = new MenuItem("Check class database settings");
        nameDaba = new MenuItem("Check name database settings");
        deipDaba= new MenuItem("Check description database settings");
        reriDaba = new MenuItem("Check requriment database settings");
        reliDaba = new MenuItem("Check reality database settings");
        
        menu.getItems().addAll(folder,usnaDaba,casDaba,nameDaba,deipDaba,reriDaba,reliDaba);
        menuBar.getMenus().addAll(menu);
        
        VBox textAreaLayout = new VBox();
        
        nameInput = new TextArea();
        pathInput = new TextArea();
        
        checkName = new Button("Check name");
        checkPath = new Button("Check path");
        choosePath = new Button("Choose path");
        
        HBox textAreaButtonLayout = new HBox();
        
        textAreaButtonLayout.getChildren().addAll(checkName,checkPath,choosePath);
        
        textAreaLayout.getChildren().addAll(nameInput,pathInput,textAreaButtonLayout);
        
        HBox buttonLayout = new HBox();
        previous = new Button("Previous");
        next = new Button("Next");
        buttonLayout.getChildren().addAll(previous, next);
        
        layout.add(title, 0, 0);
        layout.add(usedDao, 0, 1);
        layout.add(description, 0, 2);
        layout.add(menuBar, 0,3);
        layout.add(textAreaLayout, 0, 4);
        layout.add(buttonLayout, 0, 5);
        
        layout.setPrefSize(600, 600);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(20);
        layout.setHgap(20);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        this.daoSettingScene = new Scene(layout); 
    }
     
    public Scene getDaoSettingScene() {
        return this.daoSettingScene;
    }
    
    public GridPane getLayout() {
        return this.layout;
    }
      
    public Label getUsedDao() {
        return this.usedDao;
    }
    
    public Button getPrevious() {
        return this.previous;
    }
    
    public Button getNext() {
        return this.next;
    }
    
    public MenuItem getFolder() {
        return this.folder;
    }
    
    public MenuItem getUsernameDatabaseItem() {
        return this.usnaDaba;
    }
    
    public MenuItem getClassDatabaseItem() {
        return this.casDaba;
    }
    
    public MenuItem getNameDatabaseItem() {
        return this.nameDaba;
    }
    
    public MenuItem getDescriptionDatabaseItem() {
        return this.deipDaba;
    }
    
    public MenuItem getRequrimentDatabaseItem() {
        return this.reriDaba;
    }
    
    public MenuItem getRealityDatabaseItem() {
        return this.reliDaba;
    }
    
    public TextArea getNameInput() {
        return this.nameInput;
    }
    
    public TextArea getPathInput() {
        return this.pathInput;
    }
    
    public Button getCheckName() {
        return this.checkName;
    }
    
    public Button getCheckPath() {
        return this.checkPath;
    }
    
    public Button getChoosePath() {
        return this.choosePath;
    }
     
    
    
}
