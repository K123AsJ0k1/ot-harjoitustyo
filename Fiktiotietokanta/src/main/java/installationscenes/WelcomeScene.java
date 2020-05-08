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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author niila
 */
public class WelcomeScene {
    
    Scene welcomeScene;
    CheckBox publicMode;
    CheckBox privateMode;
    CheckBox devMode;
    Button shutDown;
    Button next;
    
    
    public WelcomeScene() {
        GridPane layout = new GridPane();
        
        Label title = new Label("Welcome, please choose one of these options");
        this.publicMode = new CheckBox("Use public server set up");
        Text publicDesription = new Text();
        this.privateMode = new CheckBox("Use private set up");
        Text privateDesription = new Text();
        this.devMode = new CheckBox("Use developer set up");
        Text devDescription = new Text();
        HBox buttonLayout = new HBox();
        this.shutDown = new Button("Shut down");
        this.next = new Button("Next");
        buttonLayout.getChildren().addAll(this.shutDown, this.next);
        
        layout.add(title, 0, 0);
        layout.add(this.publicMode, 0, 1);
        layout.add(publicDesription, 0, 2);
        layout.add(this.privateMode, 0, 3);
        layout.add(privateDesription, 0, 4);
        layout.add(this.devMode, 0, 5);
        layout.add(devDescription, 0, 6);
        layout.add(buttonLayout, 0, 7);
        
        layout.setPrefSize(300, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        this.welcomeScene = new Scene(layout);
    }
    
    public Scene getWelcomeScene() {
        return this.welcomeScene;
    }
    
    public CheckBox getPublicMode() {
        return this.publicMode;
    }
    
    public CheckBox getPrivateMode() {
        return this.privateMode;
    }
    
    public CheckBox getDevMode() {
        return this.devMode;
    } 
    
    public Button getShutDownButton() {
        return this.shutDown;
    }
    
    public Button getNextButton() {
        return this.next;
    }
    
}
