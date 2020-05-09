/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package installationscenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author niila
 */
public class UpKeepSettingsScene {
    
    Scene upKeepSettingsScene;
    TextArea usernameArea;
    TextArea passwordArea;
    Button createAdmin;
    Button finish;
    Button previous;
    
    
    public UpKeepSettingsScene() {
       GridPane layout = new GridPane();
       
       Label title = new Label("Add atleast one admin account");
       
       usernameArea = new TextArea();
       passwordArea = new TextArea();
       createAdmin = new Button("Create admin");
       
       usernameArea.setMaxSize(200, 1);
       passwordArea.setMaxSize(200, 1);
         
       HBox buttonLayout = new HBox();
       finish = new Button("Finish");
       previous = new Button("Previous");
       buttonLayout.getChildren().addAll(previous,finish);
       
       layout.add(title, 0, 1);
       layout.add(usernameArea, 0, 2);
       layout.add(passwordArea, 0, 3);
       layout.add(createAdmin, 0, 4);
       layout.add(buttonLayout, 0, 5);
       
       layout.setPrefSize(300, 300);
       layout.setAlignment(Pos.CENTER);
       layout.setVgap(10);
       layout.setHgap(10);
       layout.setPadding(new Insets(20, 20, 20, 20));
       
       this.upKeepSettingsScene = new Scene(layout);
       
    }
    
    public Scene getUpKeepSettingsScene() {
        return this.upKeepSettingsScene;
    }
    
    public TextArea getUsernameArea() {
        return this.usernameArea;
    }
    
    public TextArea getPasswordArea() {
        return this.passwordArea;
    }
    
    public Button getFinishButton() {
        return this.finish;
    }
    
    public Button getPreviousButton() {
        return this.previous;
    }
    
}
