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

/**
 *
 * @author niila
 */
public class AddAbilitiesScene {
    
    public AddAbilitiesScene() {
        GridPane addAbilityMenu = new GridPane();

        Label addAbilityMenuInsturctions = new Label("Fill all the blanks");
        Label addAbilityMenuClass = new Label("What class does the ability belong to?");
        Label addAbilityMenuName = new Label("What name does the ability have?");
        Label addAbilityMenuDescription = new Label("What description does the ability have?");
        Label addAbilityMenuRequriment = new Label("What requriment does the ability have?");
        Label addAbilityMenuReality = new Label("In what reality is the ability?");
        Button addAbilityMenuInsertNewAbility = new Button("Create ability");
        Button addAbilityMenuReturn = new Button("Return");
        Label addAbilityMenuError = new Label("");

        TextField writenGlass = new TextField();
        TextField writenName = new TextField();
        TextField writenDescription = new TextField();
        TextField writenRequriment = new TextField();
        TextField writenReality = new TextField();

        addAbilityMenu.add(addAbilityMenuInsturctions, 0, 0);
        addAbilityMenu.add(addAbilityMenuClass, 0, 1);
        addAbilityMenu.add(writenGlass, 0, 2);
        addAbilityMenu.add(addAbilityMenuName, 0, 3);
        addAbilityMenu.add(writenName, 0, 4);
        addAbilityMenu.add(addAbilityMenuDescription, 0, 5);
        addAbilityMenu.add(writenDescription, 0, 6);
        addAbilityMenu.add(addAbilityMenuRequriment, 0, 7);
        addAbilityMenu.add(writenRequriment, 0, 8);
        addAbilityMenu.add(addAbilityMenuReality, 0, 9);
        addAbilityMenu.add(writenReality, 0, 10);
        addAbilityMenu.add(addAbilityMenuInsertNewAbility, 0, 11);
        addAbilityMenu.add(addAbilityMenuReturn, 0, 12);
        addAbilityMenu.add(addAbilityMenuError, 0, 13);

        addAbilityMenu.setPrefSize(500, 500);
        addAbilityMenu.setAlignment(Pos.CENTER);
        addAbilityMenu.setVgap(10);
        addAbilityMenu.setHgap(10);
        addAbilityMenu.setPadding(new Insets(20, 20, 20, 20));

        Scene screenAddAbilityMenu = new Scene(addAbilityMenu);
    }
    
}
