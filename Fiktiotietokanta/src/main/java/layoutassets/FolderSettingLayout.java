/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutassets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author niila
 */
public class FolderSettingLayout {
    
    VBox layout;
    
    TextArea nameFolder;
    TextArea pathFolder;
    Button checkNameFolder;
    Button checkPathFolder;
    Button choosePathFolder;
    
    
    public FolderSettingLayout() {
        layout = new VBox();
        
        HBox folderButtonLayout = new HBox();
        Label folder = new Label("These setting controls the folder containing needed databases");
        nameFolder = new TextArea();
        pathFolder = new TextArea();
        
        nameFolder.setMaxSize(250, 5);
        pathFolder.setMaxSize(250, 5);
       
        checkNameFolder = new Button("Check name");
        checkPathFolder = new Button("Check path");
        choosePathFolder = new Button("Choose path");
        folderButtonLayout.getChildren().addAll(checkNameFolder, checkPathFolder, choosePathFolder);
        layout.getChildren().addAll(folder, nameFolder, pathFolder, checkNameFolder, checkPathFolder, choosePathFolder, folderButtonLayout);
        
        layout.setPrefSize(100, 100);
    } 
    
    public VBox getLayout() {
        return this.layout;
    }
    
    public TextArea getName() {
        return this.nameFolder;
    }
    
    public TextArea getPath() {
        return this.pathFolder;
    }
    
    public Button getCheckNameButton() {
        return this.checkNameFolder;
    }
    
    public Button getCheckPathButton() {
        return this.checkPathFolder;
    }
    
    public Button getChoosePathButton() {
        return this.choosePathFolder;
    }
    
}
