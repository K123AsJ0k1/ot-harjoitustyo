/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programscenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Sovelluksen käyttöliittymän luo tiedosto scene.
 */
public class CreateFileScene {

    Scene createFileScreen;
    Text textPresentation;
    Button saveButton;
    Button returnButton;

    /**
     * Luo tiedoston konstruktori.
     */
    public CreateFileScene() {
        VBox layout = new VBox();

        this.textPresentation = new Text();
        this.textPresentation.setFont(new Font(14));

        HBox buttonLayout = new HBox();

        this.saveButton = new Button("Save");
        this.returnButton = new Button("Return");

        buttonLayout.setAlignment(Pos.CENTER);

        buttonLayout.getChildren().addAll(this.saveButton, this.returnButton);

        layout.getChildren().addAll(this.textPresentation, buttonLayout);

        layout.setAlignment(Pos.CENTER);
        layout.setPrefSize(700, 500);

        this.createFileScreen = new Scene(layout);
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
