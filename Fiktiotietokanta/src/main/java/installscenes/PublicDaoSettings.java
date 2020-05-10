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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Sovelluksen asennuksen julkisen tilan dao asetus scene.
 */
public class PublicDaoSettings {

    Scene daoSettingScene;
    GridPane layout;
    MenuItem folder;
    MenuItem usnaDaba;
    MenuItem casDaba;
    MenuItem nameDaba;
    MenuItem deipDaba;
    MenuItem reriDaba;
    MenuItem reliDaba;
    MenuItem abtyDaba;
    TextArea nameInput;
    Label message;
    Button previous;
    Button next;
    Button selectName;

    /**
     * Konstruktori.
     */
    public PublicDaoSettings() {

        layout = new GridPane();

        Label description = new Label("You can change dao file names here if needed");

        MenuBar menuBar = new MenuBar();
        menuBar.setMaxSize(250, 3);
        Menu menu = new Menu("Click here to check diffrent files");
        folder = new MenuItem("Database folder");
        usnaDaba = new MenuItem("Username database");
        casDaba = new MenuItem("Class database");
        nameDaba = new MenuItem("Name database");
        deipDaba = new MenuItem("Description database");
        reriDaba = new MenuItem("Requriment database");
        reliDaba = new MenuItem("Reality database");
        abtyDaba = new MenuItem("Ability database");

        menu.getItems().addAll(folder, usnaDaba, casDaba, nameDaba, deipDaba, reriDaba, reliDaba, abtyDaba);
        menuBar.getMenus().addAll(menu);

        VBox textAreaLayout = new VBox();

        nameInput = new TextArea();

        message = new Label("");

        nameInput.setMaxSize(250, 1);

        selectName = new Button("Select name");

        HBox textAreaButtonLayout = new HBox();

        textAreaButtonLayout.getChildren().addAll(selectName);

        textAreaLayout.getChildren().addAll(nameInput, textAreaButtonLayout);

        HBox buttonLayout = new HBox();
        previous = new Button("Previous");
        next = new Button("Next");
        buttonLayout.getChildren().addAll(previous, next);

        layout.add(description, 0, 1);
        layout.add(menuBar, 0, 2);
        layout.add(textAreaLayout, 0, 3);
        layout.add(message, 0, 4);
        layout.add(buttonLayout, 0, 5);

        layout.setPrefSize(300, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        this.daoSettingScene = new Scene(layout);
    }

    public Scene getDaoSettingScene() {
        return this.daoSettingScene;
    }

    public GridPane getLayout() {
        return this.layout;
    }

    public Button getPrevious() {
        return this.previous;
    }

    public Button getNext() {
        return this.next;
    }

    public MenuItem getFolder() {
        return this.folder;
    }

    public MenuItem getUsernameDatabaseItem() {
        return this.usnaDaba;
    }

    public MenuItem getClassDatabaseItem() {
        return this.casDaba;
    }

    public MenuItem getNameDatabaseItem() {
        return this.nameDaba;
    }

    public MenuItem getDescriptionDatabaseItem() {
        return this.deipDaba;
    }

    public MenuItem getRequrimentDatabaseItem() {
        return this.reriDaba;
    }

    public MenuItem getRealityDatabaseItem() {
        return this.reliDaba;
    }

    public MenuItem getAbilityDatabaseItem() {
        return this.abtyDaba;
    }

    public TextArea getNameInput() {
        return this.nameInput;
    }

    public Label getMessage() {
        return this.message;
    }

    public Button getSelectName() {
        return this.selectName;
    }

}
