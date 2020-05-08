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
public class UDSettingLayout {
    
    VBox layout;
    TextArea nameUD;
    TextArea pathUD;
    Button checkNameUD;
    Button checkPathUD;
    Button choosePathUD;
    
    public UDSettingLayout() {
        layout = new VBox();
        HBox uDButtonLayout = new HBox();
        Label uD = new Label("These settings control username database");
        nameUD = new TextArea(); 
        pathUD = new TextArea();
        
        nameUD.setMaxSize(250, 5);
        pathUD.setMaxSize(250, 5);
        
        checkNameUD = new Button("Check name");
        checkPathUD = new Button("Check path");
        choosePathUD = new Button("Choose path");
        uDButtonLayout.getChildren().addAll(checkNameUD, checkPathUD, choosePathUD);
        layout.getChildren().addAll(uD, nameUD, pathUD, checkNameUD, checkPathUD, choosePathUD, uDButtonLayout);
    }
    
    public VBox getLayout() {
        return this.layout;
    }
    
    public TextArea getName() {
        return this.nameUD;
    }
    
    public TextArea getPath() {
        return this.pathUD;
    }
    
    public Button getCheckName() {
        return this.checkNameUD;
    } 
    
    public Button getCheckPath() {
        return this.checkPathUD;
    }
    
    public Button getChoosePath() {
        return this.choosePathUD;
    }
    
}
