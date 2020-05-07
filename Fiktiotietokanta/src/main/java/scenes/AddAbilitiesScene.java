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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author niila
 */
public class AddAbilitiesScene {
    
    Scene addAbilitiesScreen;
    Button createAbilityButton;
    Button returnButton;
    Label errorMessage;
    TextField classInput;
    TextField nameInput;
    TextField descriptionInput;
    TextField requrimentInput;
    TextField realityInput;
    
    public AddAbilitiesScene() {
        GridPane layout = new GridPane();

        Label instructions = new Label("Fill all the blanks");
        Label classQuestion = new Label("What class does the ability belong to?");
        Label nameQuestion = new Label("What name does the ability have?");
        Label descriptionQuestion = new Label("What description does the ability have?");
        Label requrimentQuestion = new Label("What requriment does the ability have?");
        Label realityQuestion = new Label("In what reality is the ability?");
        this.createAbilityButton = new Button("Create ability");
        this.returnButton = new Button("Return");
        this.errorMessage = new Label("");

        this.classInput = new TextField();
        this.nameInput = new TextField();
        this.descriptionInput = new TextField();
        this.requrimentInput = new TextField();
        this.realityInput = new TextField();

        layout.add(instructions, 0, 0);
        layout.add(classQuestion, 0, 1);
        layout.add(this.classInput, 0, 2);
        layout.add(nameQuestion, 0, 3);
        layout.add(this.nameInput, 0, 4);
        layout.add(descriptionQuestion, 0, 5);
        layout.add(this.descriptionInput, 0, 6);
        layout.add(requrimentQuestion, 0, 7);
        layout.add(this.requrimentInput, 0, 8);
        layout.add(realityQuestion, 0, 9);
        layout.add(this.realityInput, 0, 10);
        layout.add(this.createAbilityButton, 0, 11);
        layout.add(this.returnButton, 0, 12);
        layout.add(this.errorMessage, 0, 13);

        layout.setPrefSize(500, 500);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        this.addAbilitiesScreen = new Scene(layout);
    }
    
    public void setAddAbilitiesStage(Stage primaryStage) {
        primaryStage.setTitle("Add abilities");
        primaryStage.setScene(this.addAbilitiesScreen);
    }
    
    public Scene getAddAbilitiesScene() {
        return this.addAbilitiesScreen;
    }
    
    public Button getCreateAbilityButton() {
        return this.createAbilityButton;
    }
    
    public Button getReturnButton() {
        return this.returnButton;
    }
    
    public Label getErrorMessage() {
        return this.errorMessage;
    } 
    
    public void setErrorMessage(String givenError) {
        this.errorMessage.setText(givenError);
    }
    
    public TextField getClassInput() {
        return this.classInput;
    }
    
    public TextField getNameInput() {
        return this.nameInput;
    }
    
    public TextField getDescriptionInput() {
        return this.descriptionInput;
    }
    
    public TextField getRequrimentInput() {
        return this.requrimentInput;
    }
    
    public TextField getRealityInput() {
        return this.realityInput;
    }
    
}
