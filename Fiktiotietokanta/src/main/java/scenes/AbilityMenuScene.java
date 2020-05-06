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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author niila
 */
public class AbilityMenuScene {
    
    Scene abilityMenuScreen;
    Button addAbilityButton;
    Button removeAbilityButton;
    Button returnButton;
    
    public AbilityMenuScene() {
        GridPane layout = new GridPane();

        Label titleAbilityMenu = new Label("What do you want to do?");
        this.addAbilityButton = new Button("Add abilities");
        this.removeAbilityButton = new Button("Remove abilities");
        this.returnButton = new Button("Return to the main menu");

        layout.add(titleAbilityMenu, 0, 0);
        layout.add(this.addAbilityButton, 0, 1);
        layout.add(this.removeAbilityButton, 0, 2);
        layout.add(this.returnButton, 0, 3);

        layout.setPrefSize(300, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        this.abilityMenuScreen = new Scene(layout);
    }
    
    public void setAbilityMenuStage(Stage primaryStage) {
        primaryStage.setTitle("Ability menu");
        primaryStage.setScene(this.abilityMenuScreen);
    }
    
    public Scene getAbilityMenuScene() {
        return this.abilityMenuScreen;
    }
    
    public Button getAddAbilityButton() {
        return this.addAbilityButton;
    }
    
    public Button getRemoveAbilityButton() {
        return this.removeAbilityButton;
    }
    
    public Button getReturnButton() {
        return this.returnButton;
    }
    
    
}
