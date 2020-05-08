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
public class ReaDSettingLayout {
    
    VBox layout;
    TextArea nameReaD;
    TextArea pathReaD;
    Button checkNameReaD;
    Button checkPathReaD;
    Button choosePathReaD;
    
    public ReaDSettingLayout() {
        layout = new VBox();
        HBox reaDButtonLayout = new HBox();
        Label reaD = new Label("These settings control reality database");
        nameReaD = new TextArea();
        pathReaD = new TextArea();
        
        nameReaD.setMaxSize(250, 5);
        pathReaD.setMaxSize(250, 5);
        
        checkNameReaD = new Button("Check name");
        checkPathReaD = new Button("Check path");
        choosePathReaD = new Button("Choose path");
        reaDButtonLayout.getChildren().addAll(checkNameReaD, checkPathReaD, choosePathReaD);
        layout.getChildren().addAll(reaD, nameReaD, pathReaD, checkNameReaD, checkPathReaD, choosePathReaD, reaDButtonLayout);
    }
    
    public VBox getLayout() {
        return this.layout;
    }
    
    public TextArea getName() {
        return this.nameReaD;
    }
    
    public TextArea getPath() {
        return this.pathReaD;
    }
    
    public Button getCheckNameButton() {
        return this.checkNameReaD;
    }
    
    public Button getCheckPathButton() {
        return this.checkPathReaD;
    }
    
    public Button getChoosenPathButton() {
        return this.choosePathReaD;
    }
    
}
