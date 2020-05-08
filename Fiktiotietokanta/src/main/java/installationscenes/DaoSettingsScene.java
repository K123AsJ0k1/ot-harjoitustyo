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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import layoutassets.CDSettingLayout;
import layoutassets.DDSettingLayout;
import layoutassets.FolderSettingLayout;
import layoutassets.NDSettingLayout;
import layoutassets.ReaDSettingLayout;
import layoutassets.ReqDSettingLayout;
import layoutassets.UDSettingLayout;

/**
 *
 * @author niila
 */
public class DaoSettingsScene {
    
    Scene daoSettingScene;
    Label usedDao;
    FolderSettingLayout folderSettingLayout;
    UDSettingLayout uDSettingLayout;
    CDSettingLayout cDSettingLayout;
    NDSettingLayout nDSettingLayout;
    DDSettingLayout dDSettingLayout;
    ReqDSettingLayout reqDSettingLayout;
    ReaDSettingLayout reaDSettingLayout;
    Button previous;
    Button next;
    
    public DaoSettingsScene() {
        
        folderSettingLayout = new FolderSettingLayout();
        uDSettingLayout = new UDSettingLayout();
        cDSettingLayout = new CDSettingLayout();
        nDSettingLayout = new NDSettingLayout();
        dDSettingLayout = new DDSettingLayout();
        reqDSettingLayout = new ReqDSettingLayout();
        reaDSettingLayout = new ReaDSettingLayout();
               
        GridPane layout = new GridPane();
        
        Label title = new Label("Data access object settings");
        usedDao = new Label("Currently used data access object:");
        Text description = new Text("You can configure these given options, or continue to the next step");
        
        HBox buttonLayout = new HBox();
        previous = new Button("Previous");
        next = new Button("Next");
        buttonLayout.getChildren().addAll(previous, next);
        
        layout.add(title, 0, 0);
        layout.add(usedDao, 0, 1);
        layout.add(description, 0, 2);
        layout.add(folderSettingLayout.getLayout(), 0, 3);
        layout.add(uDSettingLayout.getLayout(), 0, 4);
        //layout.add(cDSettingLayout.getLayout(), 0, 5);
        //layout.add(nDSettingLayout.getLayout(), 0, 6);
        //layout.add(dDSettingLayout.getLayout(), 0, 7);
        //layout.add(reqDSettingLayout.getLayout(), 0, 8);
        //layout.add(reaDSettingLayout.getLayout(), 0, 9);
        layout.add(buttonLayout, 0, 10);
        
        layout.setPrefSize(600, 600);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(20);
        layout.setHgap(20);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        this.daoSettingScene = new Scene(layout); 
    }
    
    public Scene getDaoSettingScene() {
        return this.daoSettingScene;
    }
    
    public Label getUsedDao() {
        return this.usedDao;
    }
    
    public FolderSettingLayout getFolderLayout() {
        return this.folderSettingLayout;
    }
    
    public UDSettingLayout getUDLayout() {
        return this.uDSettingLayout;
    }
    
    public CDSettingLayout getCDLayout() {
        return this.cDSettingLayout;
    }
    
    public NDSettingLayout getNDLayout() {
        return this.nDSettingLayout;
    }
    
    public DDSettingLayout getDDLayout() {
        return this.dDSettingLayout;
    }
    
    public ReqDSettingLayout getReqDSettingLayout() {
        return this.reqDSettingLayout;
    }
    
    public ReaDSettingLayout getReaDSettingLayout() {
        return this.reaDSettingLayout;
    }
    
    public Button getPrevious() {
        return this.previous;
    }
    
    public Button getNext() {
        return this.next;
    }
    
    
    
}
