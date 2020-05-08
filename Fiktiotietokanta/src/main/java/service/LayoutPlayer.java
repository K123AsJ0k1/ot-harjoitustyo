/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javafx.scene.layout.VBox;
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
public class LayoutPlayer {
    
    FolderSettingLayout folderSettingLayout;
    UDSettingLayout uDSettingLayout;
    CDSettingLayout cDSettingLayout;
    NDSettingLayout nDSettingLayout;
    DDSettingLayout dDSettingLayout;
    ReqDSettingLayout reqDSettingLayout;
    ReaDSettingLayout reaDSettingLayout;
    
    public LayoutPlayer() {
        folderSettingLayout = new FolderSettingLayout();
        uDSettingLayout = new UDSettingLayout();
        cDSettingLayout = new CDSettingLayout();
        nDSettingLayout = new NDSettingLayout();
        dDSettingLayout = new DDSettingLayout();
        reqDSettingLayout = new ReqDSettingLayout();
        reaDSettingLayout = new ReaDSettingLayout();
    }
    
    public VBox bringLayout(String wantedLayout) {
        if (wantedLayout.equals("Folder")) {
            return this.folderSettingLayout.getLayout();
        }
        if (wantedLayout.equals("UsernameDatabase")) {
            return this.uDSettingLayout.getLayout();
        }
        if (wantedLayout.equals("ClassDatabase")) {
            return this.cDSettingLayout.getLayout();
        }
        if (wantedLayout.equals("NameDatabase")) {
            return this.nDSettingLayout.getLayout();
        }
        if (wantedLayout.equals("DescriptionDatabase")) {
            return this.dDSettingLayout.getLayout();
        }
        if (wantedLayout.equals("RequrimentDatabase")) {
            return this.reqDSettingLayout.getLayout();
        }
        if (wantedLayout.equals("RealityDatabase")) {
            return this.reaDSettingLayout.getLayout();
        }
        return null;
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
    
    
}
