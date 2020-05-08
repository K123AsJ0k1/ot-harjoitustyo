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
public class NDSettingLayout {
    
    VBox layout;
    TextArea nameND;
    TextArea pathND;
    Button checkNameND;
    Button checkPathND;
    Button choosePathND;
    
    public NDSettingLayout() {
        layout = new VBox();
        HBox nDButtonLayout = new HBox();
        Label nD = new Label("These settings control name database");
        nameND = new TextArea();
        pathND = new TextArea();
        checkNameND = new Button("Check name");
        checkPathND = new Button("Check path");
        choosePathND = new Button("Choose path");
        nDButtonLayout.getChildren().addAll(checkNameND, checkPathND, choosePathND);
        layout.getChildren().addAll(nD, nameND, pathND, checkNameND, checkPathND, choosePathND, nDButtonLayout);
    }
    
    public VBox getLayout() {
        return this.layout;
    }
    
    public TextArea getName() {
        return this.nameND;
    }
    
    public TextArea getPath() {
        return this.pathND;
    }
    
    public Button getCheckNameButton() {
        return this.checkNameND;
    }
    
    public Button getCheckPathButton() {
        return this.checkPathND;
    }
    
    public Button getChoosePathButton() {
        return this.choosePathND;
    }
    
    
    
}
