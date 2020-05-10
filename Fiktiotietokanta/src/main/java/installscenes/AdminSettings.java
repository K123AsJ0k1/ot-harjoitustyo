/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package installscenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Sovelluksen asennuksen pääkäyttäjä asetusten scene.
 */
public class AdminSettings {

    Scene administratorSettingsScene;
    TextArea usernameArea;
    TextArea passwordArea;
    Label message;
    Button createAdmin;
    Button finish;
    Button previous;

    /**
     * Konstruktori.
     */
    public AdminSettings() {
        GridPane layout = new GridPane();

        Label title = new Label("Add atleast one admin account");
        message = new Label("");
        usernameArea = new TextArea();
        passwordArea = new TextArea();
        createAdmin = new Button("Create admin");

        usernameArea.setMaxSize(200, 1);
        passwordArea.setMaxSize(200, 1);

        HBox buttonLayout = new HBox();
        finish = new Button("Finish");
        previous = new Button("Previous");
        buttonLayout.getChildren().addAll(previous, finish);

        layout.add(title, 0, 1);
        layout.add(usernameArea, 0, 2);
        layout.add(passwordArea, 0, 3);
        layout.add(createAdmin, 0, 4);
        layout.add(message, 0, 5);
        layout.add(buttonLayout, 0, 6);

        layout.setPrefSize(300, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        this.administratorSettingsScene = new Scene(layout);

    }

    public Scene getAdministratorSettingsScene() {
        return this.administratorSettingsScene;
    }

    public TextArea getUsernameArea() {
        return this.usernameArea;
    }

    public TextArea getPasswordArea() {
        return this.passwordArea;
    }

    public Label getMessage() {
        return this.message;
    }

    public Button getCreateAdminButton() {
        return this.createAdmin;
    }

    public Button getFinishButton() {
        return this.finish;
    }

    public Button getPreviousButton() {
        return this.previous;
    }

}
