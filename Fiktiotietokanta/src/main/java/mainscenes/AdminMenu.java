/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainscenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/** Sovelluksen käyttöliittymän ominaisuus päävalikko scene.
 */
public class AdminMenu {

    Scene adminMenuScreen;
    Button usernameListButton;
    Button parametersListButton;
    Button returnButton;
    Label errorMessage;
    
    /** Ominaisuus päävalikkon konstruktori.
    */
    public AdminMenu() {
        GridPane layout = new GridPane();

        Label titleAdminMenu = new Label("What do you want to do?");
        this.usernameListButton = new Button("Username parameters as a list");
        this.parametersListButton = new Button("Ability paramters as a list");
        this.returnButton = new Button("Return to the main menu");
        this.errorMessage = new Label("");

        layout.add(titleAdminMenu, 0, 0);
        layout.add(this.usernameListButton, 0, 1);
        layout.add(this.parametersListButton, 0, 2);
        layout.add(this.returnButton, 0, 3);
        layout.add(this.errorMessage, 0, 4);

        layout.setPrefSize(300, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        this.adminMenuScreen = new Scene(layout);
    }

    public Scene getAdminMenuScene() {
        return this.adminMenuScreen;
    }

    public Button getUserParamsAsAListMenuButton() {
        return this.usernameListButton;
    }

    public Button getAbilityParamsAsAListMenuButton() {
        return this.parametersListButton;
    }

    public Button getReturnButton() {
        return this.returnButton;
    }

    public Label getErrorMessage() {
        return this.errorMessage;
    }

}
