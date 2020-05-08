/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uilogic;

import assets.Parameters;
import assets.User;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import service.ScenePlayer;
import service.TextPlayer;

/**
 *
 * @author niila
 */
public class UiSupportLogic {

    ScenePlayer scenePlayer;

    public UiSupportLogic(ScenePlayer scenePlayer) {
        this.scenePlayer = scenePlayer;
    }

    public void resetProfile(Stage primaryStage) {
        this.scenePlayer.getCreateProfile().getProfileEditor().clear();
        this.scenePlayer.getCreateFile().getTextPresentation().setText("");
    }

    public void saveProfileAsAFile(Stage primaryStage, TextPlayer textPlayer) {
        String text = this.scenePlayer.getCreateProfile().getProfileEditor().getText().trim();
        this.scenePlayer.getCreateFile().getTextPresentation().setText(text);
        textPlayer.getFileWriterInterface().showSaveFileDialog(primaryStage, text);
    }

    public void addAbility(User user, UiAbilityLogic uiAbilityLogic) {
        scenePlayer.getAddAbilities().getErrorMessage().setText("");
        String textFieldClass = scenePlayer.getAddAbilities().getClassInput().getText().trim();
        String textFieldName = scenePlayer.getAddAbilities().getNameInput().getText().trim();
        String textFieldDescription = scenePlayer.getAddAbilities().getDescriptionInput().getText().trim();
        String textFieldRequriment = scenePlayer.getAddAbilities().getRequrimentInput().getText().trim();
        String textFieldReality = scenePlayer.getAddAbilities().getRealityInput().getText().trim();

        String addAbility = uiAbilityLogic.addAbility(user.getId(), textFieldClass, textFieldName, textFieldDescription, textFieldRequriment, textFieldReality);
        scenePlayer.getAddAbilities().getErrorMessage().setText(addAbility);

        scenePlayer.getAddAbilities().getClassInput().clear();
        scenePlayer.getAddAbilities().getNameInput().clear();
        scenePlayer.getAddAbilities().getDescriptionInput().clear();
        scenePlayer.getAddAbilities().getRequrimentInput().clear();
        scenePlayer.getAddAbilities().getRealityInput().clear();
    }

    public void removeAbility(User user, UiAbilityLogic uiAbilityLogic) {
        if (scenePlayer.getRemoveAbilities().getSelectionModel().getSelectedItems().size() > 0) {
            ObservableList selectedItems = scenePlayer.getRemoveAbilities().getSelectionModel().getSelectedItems();
            int removedIndex = scenePlayer.getRemoveAbilities().getSelectionModel().getFocusedIndex();
            uiAbilityLogic.removeAbility(user.getId(), selectedItems);
            scenePlayer.getRemoveAbilities().getTableView().getItems().remove(removedIndex);
            scenePlayer.getRemoveAbilities().getTableView().refresh();
        }
    }
    
    public void resetAbility(Parameters parameters) {
        parameters.setChoosenAbility("");
        parameters.setLeftOverParameters("");
        scenePlayer.getCreateProfile().getLeftParameterItem().setText("Ability parameters left:" + "");
    }
    
    public void checkTextAreaForAbilities(Parameters parameters, TextPlayer textPlayer) {
        parameters.setLeftOverParameters(textPlayer.getTextRefineryInterface().choosenAbilityIsFoundFromText(scenePlayer.getCreateProfile().getProfileEditor().getText(),parameters.getChosenAbility()));
        scenePlayer.getCreateProfile().getLeftParameterItem().setText("Ability parameters left:" + parameters.getLeftOverParameters());
    }
    
    public void checkTextArea(TextPlayer textPlayer) {
        scenePlayer.getCreateProfile().getLineCheckItem().setText("Text has different lines:"+textPlayer.getTextRefineryInterface().givenTextLineChecker(scenePlayer.getCreateProfile().getProfileEditor().getText().trim()));
        scenePlayer.getCreateProfile().getSpaceCheckItem().setText("Words have spaces between them:"+textPlayer.getTextRefineryInterface().givenTextLineHasSpaces(scenePlayer.getCreateProfile().getProfileEditor().getText().trim()));
        scenePlayer.getCreateProfile().getWordCountItem().setText("Current wordcount:"+textPlayer.getTextRefineryInterface().giveTextWordCount(scenePlayer.getCreateProfile().getProfileEditor().getText().trim()));
        scenePlayer.getCreateProfile().getCharacterCountItem().setText("Current charactercount:"+textPlayer.getTextRefineryInterface().giveCharacterCount(scenePlayer.getCreateProfile().getProfileEditor().getText().trim()));
    }

}