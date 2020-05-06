/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author niila
 */
public class CreateProfileScene {
    
    public CreateProfileScene() {
        VBox createProfileLayout = new VBox();

        GridPane createProfileMenu = new GridPane();

        BorderPane menuRoot = new BorderPane();

        MenuBar createProfileMenuBar = new MenuBar();
        
        ContextMenu contextMenuCreateProfile = new ContextMenu();
        MenuItem chooseAnAbilityContextMenu = new MenuItem("Choose an Ability");
        MenuItem currenAbilityProgressContextMenu = new MenuItem("Ability parameters left:");
        MenuItem resetAnAbilityContextMenu = new MenuItem("Resets current ability");
        MenuItem checkTextAreaContextMenu = new MenuItem("Check the textarea for ability parameters");
        MenuItem wordCountContextMenu = new MenuItem("Current wordcount:0");
        MenuItem characterCountContextMenu = new MenuItem("Current character count:0");
        MenuItem textHasLinesContextMenu = new MenuItem("Text has different lines:");
        MenuItem textHasSpacesContextMenu = new MenuItem("Words have spaces between them:");
        MenuItem textHasFullAbilitesContextMenu = new MenuItem("The amount of abilities found in text:0");
        
        contextMenuCreateProfile.getItems().addAll(chooseAnAbilityContextMenu, currenAbilityProgressContextMenu, resetAnAbilityContextMenu,checkTextAreaContextMenu,wordCountContextMenu,characterCountContextMenu,textHasLinesContextMenu,textHasSpacesContextMenu,textHasFullAbilitesContextMenu);   
        Menu exitProfileMenu = new Menu("Exit profile creator");

        MenuItem exitProfileMenu1 = new MenuItem("Save and return");
        MenuItem exitProfileMenu2 = new MenuItem("Return without saving");

        exitProfileMenu.getItems().addAll(exitProfileMenu1, exitProfileMenu2);
        
        Menu textTemplatesAreaProfileMenu = new Menu("Templates");
        
        MenuItem editTextAreaProfileMenu1 = new MenuItem("Create unspecified template");
        MenuItem editTextAreaProfileMenu2 = new MenuItem("Person profile template");
        MenuItem editTextAreaProfileMenu3 = new MenuItem("Culture profile template");
        MenuItem editTextAreaProfileMenu4 = new MenuItem("Object profile template");
        MenuItem editTextAreaProfileMenu5 = new MenuItem("Place profile template");
        MenuItem editTextAreaProfileMenu6 = new MenuItem("World profile template");
        MenuItem editTextAreaProfileMenu7 = new MenuItem("Universe profile template");
        
        textTemplatesAreaProfileMenu.getItems().addAll(editTextAreaProfileMenu1, editTextAreaProfileMenu2, editTextAreaProfileMenu3, editTextAreaProfileMenu4, editTextAreaProfileMenu5, editTextAreaProfileMenu6,editTextAreaProfileMenu7);
        
        Menu helpProfileMenu = new Menu("Help");
        
        MenuItem helpProfileMenu1 = new MenuItem("How to use this editor");
        MenuItem helpProfileMenu2 = new MenuItem("Quick tips");
        MenuItem helpProfileMenu3 = new MenuItem("General questions answered");
        
        helpProfileMenu.getItems().addAll(helpProfileMenu1, helpProfileMenu2, helpProfileMenu3);
          
        createProfileMenuBar.getMenus().addAll(exitProfileMenu, textTemplatesAreaProfileMenu, helpProfileMenu);

        menuRoot.setTop(createProfileMenuBar);

        TextArea profileEditorCreateProfileMenu = new TextArea();
        profileEditorCreateProfileMenu.setContextMenu(contextMenuCreateProfile);

        profileEditorCreateProfileMenu.setMinSize(500, 425);
        profileEditorCreateProfileMenu.setMaxSize(500, 425);
        profileEditorCreateProfileMenu.setWrapText(true);

        createProfileMenu.getChildren().addAll(menuRoot);
        createProfileMenu.add(profileEditorCreateProfileMenu, 0, 0);

        createProfileLayout.getChildren().addAll(menuRoot, createProfileMenu);

        createProfileLayout.setPrefSize(501, 500);

        Scene createProfileScene = new Scene(createProfileLayout);
    }
    
}
