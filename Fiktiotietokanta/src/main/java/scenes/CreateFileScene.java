/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import domain.FileWriterInterface;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/** Testi scene.
 *
 * 
 */
public class CreateFileScene {
    
    Scene createFileScreen;
    Text textPresentation;
    Button saveButton;
    Button returnButton;
    
    public CreateFileScene() {
        VBox layout = new VBox();
        
        this.textPresentation = new Text();
        this.textPresentation.setFont(new Font(14));
        
        HBox buttonLayout = new HBox();
        
        this.saveButton = new Button("Save");
        this.returnButton = new Button("Return");
        
        buttonLayout.setAlignment(Pos.CENTER);
        
        buttonLayout.getChildren().addAll(this.saveButton, this.returnButton);
        
        layout.getChildren().addAll(this.textPresentation,buttonLayout);
        
        layout.setAlignment(Pos.CENTER);
        layout.setPrefSize(700, 500);
        
        this.createFileScreen = new Scene(layout); 
    }
    
    public void setCreateFileStage(Stage primaryStage) {
        primaryStage.setTitle("Save file");
        primaryStage.setScene(this.createFileScreen);
    }
    
    public Scene getCreateFileScene() {
        return this.createFileScreen;
    }
    
    public Text getTextPresentation() {
        return this.textPresentation;
    }
    
    public Button getSaveButton() {
        return this.saveButton;
    }
    
    public Button getReturnButton() {
        return this.returnButton;
    }
    
}
