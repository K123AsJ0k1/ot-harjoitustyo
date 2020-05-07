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
import javafx.stage.Stage;

/**
 *
 * @author niila
 */
public class CreateProfileScene {
    
    Scene createProfileScreen;
    TextArea profileEditor;
    MenuItem chooseAbilityItem;
    MenuItem leftParameterItem;
    MenuItem resetAbilityItem;
    MenuItem checkAreaItem;
    MenuItem wordCountItem;
    MenuItem characterCountItem;
    MenuItem lineCheckItem;
    MenuItem spaceCheckItem;
    MenuItem abilityCheckItem;
    Menu exitProfile;
    MenuItem exitWithSave;
    MenuItem exitWithoutSave;
    
    
    public CreateProfileScene() {
        VBox layout = new VBox();

        GridPane menu = new GridPane();

        BorderPane menuRoot = new BorderPane();

        MenuBar menuBar = new MenuBar();
        
        ContextMenu contextMenu = new ContextMenu();
        this.chooseAbilityItem = new MenuItem("Choose an Ability");
        this.leftParameterItem = new MenuItem("Ability parameters left:");
        this.resetAbilityItem = new MenuItem("Resets current ability");
        this.checkAreaItem = new MenuItem("Check the textarea for ability parameters");
        this.wordCountItem = new MenuItem("Current wordcount:0");
        this.characterCountItem = new MenuItem("Current character count:0");
        this.lineCheckItem = new MenuItem("Text has different lines:");
        this.spaceCheckItem = new MenuItem("Words have spaces between them:");
        this.abilityCheckItem = new MenuItem("The amount of abilities found in text:0");
        
        contextMenu.getItems().addAll(this.chooseAbilityItem, this.leftParameterItem, this.resetAbilityItem, this.checkAreaItem, this.wordCountItem, this.characterCountItem, this.lineCheckItem, this.spaceCheckItem, this.abilityCheckItem);   
        this.exitProfile= new Menu("Exit profile creator");

        this.exitWithSave = new MenuItem("Save and return");
        this.exitWithoutSave = new MenuItem("Return without saving");

        this.exitProfile.getItems().addAll(this.exitWithSave, this.exitWithoutSave);
        
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
          
        menuBar.getMenus().addAll(this.exitProfile, textTemplatesAreaProfileMenu, helpProfileMenu);

        menuRoot.setTop(menuBar);

        profileEditor = new TextArea();
        profileEditor.setContextMenu(contextMenu);

        profileEditor.setMinSize(500, 425);
        profileEditor.setMaxSize(500, 425);
        profileEditor.setWrapText(true);

        menu.getChildren().addAll(menuRoot);
        menu.add(profileEditor, 0, 0);

        layout.getChildren().addAll(menuRoot, menu);

        layout.setPrefSize(501, 500);

        this.createProfileScreen = new Scene(layout);
    }
    
    public void setCreateProfileStage(Stage primaryStage) {
        primaryStage.setTitle("Create profile");
        primaryStage.setScene(this.createProfileScreen);
    }
    
    public Scene getCreateProfileScene() {
        return this.createProfileScreen;
    }
    
    public TextArea getProfileEditor() {
        return this.profileEditor;
    }
    
    public MenuItem getChoosenAbilityItem() {
        return this.chooseAbilityItem;
    }
    
    public MenuItem getLeftParameterItem() {
        return this.leftParameterItem;
    }
    
    public MenuItem getResetAbilityItem() {
        return this.resetAbilityItem;
    }
    
    public MenuItem getCheckAreaItem() {
        return this.checkAreaItem;
    }
    
    public MenuItem getWordCountItem() {
        return this.wordCountItem;
    }
    
    public MenuItem getCharacterCountItem() {
        return this.characterCountItem;
    }
    
    public MenuItem getLineCheckItem() {
        return this.lineCheckItem;
    }
    
    public MenuItem getSpaceCheckItem() {
        return this.spaceCheckItem;
    }
    
    public MenuItem getAbilityCheckItem() {
        return this.abilityCheckItem;
    }
    
    public Menu getExitProfile() {
        return this.exitProfile;
    }
    
    public MenuItem getExitWithSave() {
        return this.exitWithSave;
    }
    
    public MenuItem getExitWithoutSave() {
        return this.exitWithoutSave;
    }
    
    
}
