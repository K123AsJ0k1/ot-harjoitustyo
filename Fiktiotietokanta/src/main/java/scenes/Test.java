/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author niila
 */
public class Test {
    
    Scene testScene;
    Button buttonTest;
    Button buttonReturn;
    
    public Test() {
        GridPane layoutLogin = new GridPane();

        Button testButton = new Button("Button test");
        Button returnButton = new Button("Return");
       
        layoutLogin.add(testButton, 0, 0);
        layoutLogin.add(returnButton, 0, 1);

        layoutLogin.setPrefSize(300, 300);
        layoutLogin.setAlignment(Pos.CENTER);
        layoutLogin.setVgap(10);
        layoutLogin.setHgap(10);
        layoutLogin.setPadding(new Insets(20, 20, 20, 20));
        
        this.buttonTest = testButton;
        this.buttonReturn = returnButton;
        this.testScene = new Scene(layoutLogin);
    }
    
    public void setStage(Stage primaryStage) {
        primaryStage.setTitle("Login screen");
        primaryStage.setScene(this.testScene);
    }
    
    public Button testButtonLink() {
        return this.buttonTest;
    }
    
    public Button returnButtonLink() {
        return this.buttonReturn;
    }
    
    
    
}
