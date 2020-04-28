/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textlogic;

import domain.TextRefineryInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Auttaa kirjoittajaa tekstin jalostamisessa.
 *
 *
 */
public class TextRefinery implements TextRefineryInterface {

    /**
     * Konstruktori.
     *
     *
     */
    public TextRefinery() {

    }

    @Override
    public boolean givenTextLineChecker(String information) {

        char[] characterTable = information.toCharArray();

        int previousLineIndex = 0;
        int index = 0;

        for (char merkki : characterTable) {
            int difference = index - previousLineIndex;

            if (merkki == '\n') {
                previousLineIndex = index;
            }

            if (difference > 100) {
                return false;
            }
            index = index + 1;
        }

        return true;
    }

    @Override
    public boolean givenTextLineHasSpaces(String information) {
        char[] characterTable = information.toCharArray();

        int previousSpaceIndex = 0;
        int index = 0;
        for (char merkki : characterTable) {
            int difference = index - previousSpaceIndex;
            if (merkki == ' ') {
                previousSpaceIndex = index;
            }

            if (difference > 20) {
                return false;
            }
            index = index + 1;

        }

        return true;
    }

    @Override
    public String choosenAbilityIsFoundFromText(String information, String abilityInformation) {

        String[] wordTable = information.trim().split(" ");
        String[] parameterTable = abilityInformation.trim().split(",");
        String modifiedAbilityString = "";

        if (parameterTable.length == 5) {
            Boolean classIsPresent = false;
            Boolean nameIsPresent = false;
            Boolean descriptionIsPresent = false;
            Boolean requrimentIsPresent = false;
            Boolean realityIsPresent = false;

            String classString = parameterTable[0];
            String nameString = parameterTable[1];
            String descriptionString = parameterTable[2];
            String requrimentString = parameterTable[3];
            String realityString = parameterTable[4];

            for (String text : wordTable) {

                if (text.equals(parameterTable[0])) {
                    classIsPresent = true;
                }

                if (text.equals(parameterTable[1])) {
                    nameIsPresent = true;
                }

                if (text.equals(parameterTable[2])) {
                    descriptionIsPresent = true;
                }

                if (text.equals(parameterTable[3])) {
                    requrimentIsPresent = true;
                }

                if (text.equals(parameterTable[4])) {
                    realityIsPresent = true;
                }

            }

            if (!classIsPresent) {
                modifiedAbilityString = classString;
            }

            if (!nameIsPresent) {
                if (modifiedAbilityString.equals(classString)) {
                    modifiedAbilityString = modifiedAbilityString + "," + nameString;
                }
                if (modifiedAbilityString.equals("")) {
                    modifiedAbilityString = nameString;
                }

            }

            if (!descriptionIsPresent) {
                if (modifiedAbilityString.contains(classString) || modifiedAbilityString.contains(nameString)) {
                    modifiedAbilityString = modifiedAbilityString + "," + descriptionString;
                }
                if (modifiedAbilityString.equals("")) {
                    modifiedAbilityString = descriptionString;
                }

            }

            if (!requrimentIsPresent) {
                if (modifiedAbilityString.contains(classString) || modifiedAbilityString.contains(nameString) || modifiedAbilityString.contains(descriptionString)) {
                    modifiedAbilityString = modifiedAbilityString + "," + requrimentString;
                }
                if (modifiedAbilityString.equals("")) {
                    modifiedAbilityString = requrimentString;
                }

            }

            if (!realityIsPresent) {
                if (modifiedAbilityString.contains(classString) || modifiedAbilityString.contains(nameString) || modifiedAbilityString.contains(descriptionString) || modifiedAbilityString.contains(requrimentString)) {
                    modifiedAbilityString = modifiedAbilityString + "," + realityString;
                }
                if (modifiedAbilityString.equals("")) {
                    modifiedAbilityString = realityString;
                }

            }
        }

        return modifiedAbilityString;

    }

    @Override
    public List<String> choosenAbilitiesAreFoundFromText(String information, List<String> abilityList) {
        List<String> foundAbilityList = new ArrayList<>();
        HashMap<String,String[]> foundParametersList = new HashMap<>();
        String[] wordTable = information.trim().split(" ");
       
        for (String word:wordTable) {
            
            for (String ability: abilityList) {
                String[] abilityTable = ability.trim().split(",");
                
                if (!foundParametersList.containsKey(ability)) {
                    String[] parameterTable = new String[5];
                    parameterTable[0] = "Null";
                    parameterTable[1] = "Null";
                    parameterTable[2] = "Null";
                    parameterTable[3] = "Null";
                    parameterTable[4] = "Null";
                    foundParametersList.put(ability, parameterTable);
                }
                int index = 0;
                
                for (String parameter:abilityTable) {
                    
                    if (word.equals(parameter)) {
                        
                        if (index == 0) {
                            String[] tempTable = foundParametersList.get(ability);
                            tempTable[0] = parameter;
                            foundParametersList.replace(ability, tempTable);
                        }
                        
                        if (index == 1) {
                            String[] tempTable = foundParametersList.get(ability);
                            tempTable[1] = parameter;
                            foundParametersList.replace(ability, tempTable);
                        }
                        
                        if (index == 2) {
                            String[] tempTable = foundParametersList.get(ability);
                            tempTable[2] = parameter;
                            foundParametersList.replace(ability, tempTable);
                        }
                        
                        if (index == 3) {
                            String[] tempTable = foundParametersList.get(ability);
                            tempTable[3] = parameter;
                            foundParametersList.replace(ability, tempTable);
                        }
                        
                        if (index == 4) {
                            String[] tempTable = foundParametersList.get(ability);
                            tempTable[4] = parameter;
                            foundParametersList.replace(ability, tempTable);
                        }
                    }
                    
                    index = index + 1;
                    
                }
                
                
            }
               
        }
        
        for (String abilityKey:foundParametersList.keySet()) {
            Boolean allParametersAreFull = true;
            Boolean firstParameter = true;
            String ability = "";
            int index = 0;
     
            for (String parameter:foundParametersList.get(abilityKey)) {
                
                if (parameter.equals("Null")) {
                    allParametersAreFull = false;
                    break;
                }
                
                ability = ability + "," + parameter;
                
                if (firstParameter) {
                    ability = parameter;
                    firstParameter = false;
                }
                index = index + 1;
            }
            
            if (allParametersAreFull) {
                foundAbilityList.add(ability);
            }
            
        }
        
        return foundAbilityList;  
    }

    @Override
    public Integer giveTextWordCount(String infromation) {
        String[] wordTable = infromation.split(" ");
        return wordTable.length;   
    }

    @Override
    public Integer giveCharacterCount(String infromation) {
        char[] characterTable = infromation.toCharArray();
        return characterTable.length;
    }
    
    
    

}
