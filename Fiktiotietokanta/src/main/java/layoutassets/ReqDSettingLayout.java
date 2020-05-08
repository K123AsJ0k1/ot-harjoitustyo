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
public class ReqDSettingLayout {
    
    VBox layout;
    TextArea nameReqD;
    TextArea pathReqD;
    Button checkNameReqD;
    Button checkPathReqD;
    Button choosePathReqD;
    
    public ReqDSettingLayout() {
        layout = new VBox();
        HBox reqDButtonLayout = new HBox();
        Label reqD = new Label("These settings control requriment database");
        nameReqD = new TextArea();
        pathReqD = new TextArea();
        checkNameReqD = new Button("Check name");
        checkPathReqD = new Button("Check path");
        choosePathReqD = new Button("Choose path");
        reqDButtonLayout.getChildren().addAll(checkNameReqD, checkPathReqD, choosePathReqD);
        layout.getChildren().addAll(reqD, nameReqD, pathReqD, checkNameReqD, checkPathReqD, choosePathReqD, reqDButtonLayout);
    }
    
    public VBox getLayout() {
        return this.layout;
    }
    
    public TextArea getName() {
        return this.nameReqD;
    }
    
    public TextArea getPath() {
        return this.pathReqD;
    }
    
    public Button getCheckNameButton() {
        return this.checkNameReqD;
    }
    
    public Button getCheckPathButton() {
        return this.checkPathReqD;
    }
    
    public Button getChoosenPathButton() {
        return this.choosePathReqD;
    }
    
}
