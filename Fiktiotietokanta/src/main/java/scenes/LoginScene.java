/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import dao.UsernameDatabase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** Testi.
 *
 * 
 */
public class LoginScene {
    
    
    /** Testi.
    *
    * 
    */
    public LoginScene() {
       
        GridPane layoutLogin = new GridPane();

        Label titleLogin = new Label("What is your username?");
        Button loginLogin = new Button("Login");
        Button signInLogin = new Button("Sign in");
        Label loginerrorLogin = new Label("");

        TextField usernameInputLogin = new TextField();

        layoutLogin.add(titleLogin, 0, 0);
        layoutLogin.add(usernameInputLogin, 0, 1);
        layoutLogin.add(loginLogin, 0, 2);
        layoutLogin.add(signInLogin, 0, 3);
        layoutLogin.add(loginerrorLogin, 0, 4);

        layoutLogin.setPrefSize(300, 300);
        layoutLogin.setAlignment(Pos.CENTER);
        layoutLogin.setVgap(10);
        layoutLogin.setHgap(10);
        layoutLogin.setPadding(new Insets(20, 20, 20, 20));

        Scene screenLogin = new Scene(layoutLogin);
            
    }
    
    
    
    
}
