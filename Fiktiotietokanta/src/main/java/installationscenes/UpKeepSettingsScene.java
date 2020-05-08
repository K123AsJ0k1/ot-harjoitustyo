/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package installationscenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author niila
 */
public class UpKeepSettingsScene {
    
    Scene upKeepSettingsScene;
    TextArea usernameArea;
    TextArea passwordArea;
    TextArea adminCodeArea;
    TextArea codeArea;
    Button finish;
    Button previous;
    
    
    public UpKeepSettingsScene() {
       GridPane layout = new GridPane();
       
       Label title = new Label("Here you can set up admin accounts, create admin code and create access code");
       
       Text adminDescription = new Text("You can create limitless amounts of different admin accounts, atleast 1 is required");
       usernameArea = new TextArea();
       passwordArea = new TextArea();
       
       Text adminCodeDescription = new Text("This code changes normal users to admins, it must be atleast 4 characters long");
       adminCodeArea = new TextArea();
       
       Text codeDescription = new Text("This code gives ability to access admin tools, it must be atleast 4 characters long");
       codeArea = new TextArea();
       
       HBox buttonLayout = new HBox();
       finish = new Button("Finish");
       previous = new Button("Previous");
       buttonLayout.getChildren().addAll(previous,finish);
       
       layout.add(title, 0, 0);
       layout.add(adminDescription, 0, 1);
       layout.add(usernameArea, 0, 2);
       layout.add(passwordArea, 0, 3);
       layout.add(adminCodeDescription, 0, 4);
       layout.add(adminCodeArea, 0, 5);
       layout.add(codeDescription, 0, 6);
       layout.add(codeArea, 0, 7);
       layout.add(buttonLayout, 0, 8);
       
       layout.setPrefSize(300, 300);
       layout.setAlignment(Pos.CENTER);
       layout.setVgap(10);
       layout.setHgap(10);
       layout.setPadding(new Insets(20, 20, 20, 20));
       
       this.upKeepSettingsScene = new Scene(layout);
       
    }
    
    public Scene getUpKeepSettingsScene() {
        return this.upKeepSettingsScene;
    }
    
    public TextArea getUsernameArea() {
        return this.usernameArea;
    }
    
    public TextArea getPasswordArea() {
        return this.passwordArea;
    }
    
    public TextArea getAdminCodeArea() {
        return this.adminCodeArea;
    }
    
    public TextArea getCodeArea() {
        return this.codeArea;
    }
    
    public Button getFinishButton() {
        return this.finish;
    }
    
    public Button getPreviousButton() {
        return this.previous;
    }
    
}
