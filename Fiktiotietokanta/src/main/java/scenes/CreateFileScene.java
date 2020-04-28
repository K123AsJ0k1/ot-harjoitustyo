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
    
    Scene saveProfileMenu;
    
    /** Testi scene konstruktori.
     * @param primaryStage testi.
     * @param screenProfileMenu testi.
     * @param profileEditorCreateProfileMenu testi.
     * @param fileWriter testi.
     */
    public CreateFileScene(Stage primaryStage, Scene screenProfileMenu, TextArea profileEditorCreateProfileMenu, FileWriterInterface fileWriter) {
        VBox saveProfileLayOut = new VBox();
        
        Text profileViewSaveProfile = new Text();
        profileViewSaveProfile.setFont(new Font(14));
        
        HBox saveProfileButtonLayOut = new HBox();
        
        Button saveButtonSaveProfile = new Button("Save");
        Button returnButtonSaveProfile = new Button("Return");
        
        saveProfileButtonLayOut.setAlignment(Pos.CENTER);
        
        saveProfileButtonLayOut.getChildren().addAll(saveButtonSaveProfile, returnButtonSaveProfile);
        
        saveProfileLayOut.getChildren().addAll(profileViewSaveProfile, saveProfileButtonLayOut);
        
        saveProfileLayOut.setAlignment(Pos.CENTER);
        saveProfileLayOut.setPrefSize(700, 500);
        
        this.saveProfileMenu = new Scene(saveProfileLayOut); 
        
        returnButtonSaveProfile.setOnAction((event) -> {
            primaryStage.setTitle("Profile menu");
            primaryStage.setScene(screenProfileMenu);
        });
        
        saveButtonSaveProfile.setOnAction((event) -> {
            String text = profileEditorCreateProfileMenu.getText().trim();
            profileViewSaveProfile.setText(text);
            fileWriter.showSaveFileDialog(primaryStage, text);
        });
        
    }
    
    public Scene getCreateFileScene() {
        return this.saveProfileMenu;
    }
    
}
