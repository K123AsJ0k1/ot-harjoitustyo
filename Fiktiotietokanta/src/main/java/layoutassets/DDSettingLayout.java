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
public class DDSettingLayout {
    
    VBox layout;
    TextArea nameDD;
    TextArea pathDD;
    Button checkNameDD;
    Button checkPathDD;
    Button choosePathDD;
    
    public DDSettingLayout() {
        layout = new VBox();
        HBox dDButtonLayout = new HBox();
        Label dD = new Label("These settings control description database");
        nameDD = new TextArea();
        pathDD = new TextArea();
        checkNameDD = new Button("Check name");
        checkPathDD = new Button("Check path");
        choosePathDD = new Button("Choose path");
        dDButtonLayout.getChildren().addAll(checkNameDD, checkPathDD, choosePathDD);
        layout.getChildren().addAll(dD, nameDD, pathDD, checkNameDD, checkPathDD, choosePathDD, dDButtonLayout);
    }
    
    public VBox getLayout() {
        return this.layout;
    }
    
    public TextArea getName() {
        return this.nameDD;
    }
    
    public TextArea getPath() {
        return this.pathDD;
    }
    
    public Button getCheckName() {
        return this.checkNameDD;
    }
    
    public Button getCheckPath() {
        return this.checkPathDD;
    }
    
    public Button getChooseePath() {
        return this.choosePathDD;
    }
    
}
