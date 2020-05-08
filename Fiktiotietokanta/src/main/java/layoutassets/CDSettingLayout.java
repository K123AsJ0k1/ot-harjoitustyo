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
public class CDSettingLayout {
    
    VBox layout;
    TextArea nameCD;
    TextArea pathCD;
    Button checkNameCD;
    Button checkPathCD;
    Button choosePathCD;
    
    public CDSettingLayout() {
        layout = new VBox();
        HBox cDButtonLayout = new HBox();
        Label cD = new Label("These settings control class database");
        nameCD = new TextArea();
        pathCD = new TextArea();
        
        nameCD.setMaxSize(250, 5);
        pathCD.setMaxSize(250, 5);
        
        checkNameCD = new Button("Check name");
        checkPathCD = new Button("Check path");
        choosePathCD = new Button("Choose path");
        cDButtonLayout.getChildren().addAll(checkNameCD, checkPathCD, choosePathCD);
        layout.getChildren().addAll(cD, nameCD, pathCD, checkNameCD, checkPathCD, choosePathCD,cDButtonLayout);
        
        layout.setPrefSize(100, 100);
    }
    
    public VBox getLayout() {
        return this.layout;
    }
    
    public TextArea getName() {
        return this.nameCD;
    }
    
    public TextArea getPath() {
        return this.pathCD;
    }
    
    public Button getCheckNameButton() {
        return this.checkNameCD;
    }
    
    public Button getCheckPathButton() {
        return this.checkPathCD;
    }
    
    public Button getChoosePathButton() {
        return this.choosePathCD;
    }
    
}
